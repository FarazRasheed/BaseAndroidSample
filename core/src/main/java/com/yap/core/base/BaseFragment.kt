package com.yap.core.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.yap.core.BR
import com.yap.core.base.interfaces.IBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewDataBinding, VS : IBase.State, VM : IBase.ViewModel<VS>>(@LayoutRes val contentLayoutId: Int) :
    IBase.View<VM>, Fragment(contentLayoutId),
    OnBackPressedListener {

    private lateinit var onBackPressedCallback: OnBackPressedCallback
    lateinit var mViewBinding: VB
    private var progress: Dialog? = null
    abstract fun getBindingVariable(): Int
    abstract fun onClick(id: Int)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = DataBindingUtil.inflate(inflater, contentLayoutId, container, false)
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerStateListeners()
        performDataBinding()
        viewModel.clickEvent.observe(this, {
            onClick(it)
        })
        viewModel.viewState.viewState.observe(viewLifecycleOwner, {
            it?.let {
                when (it) {
                    is String -> {
                        viewModel.viewState.toast = it
                    }
                    is Boolean -> {
                        viewModel.viewState.loading = it
                    }
                    else -> {

                    }
                }
            }
        })
    }

    private fun performDataBinding() {
        mViewBinding.setVariable(getBindingVariable(), viewModel)
        mViewBinding.lifecycleOwner = viewLifecycleOwner
        mViewBinding.executePendingBindings()
    }

    private val stateObserver = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            if (propertyId == BR.toast && viewModel.viewState.toast.isNotBlank()) {
                if (activity is BaseActivity<*, *, *>)
                    (activity as BaseActivity<*, *, *>).showToast(viewModel.viewState.toast)
            }
            if (propertyId == BR.loading) {
                showLoading(viewModel.viewState.loading)
            }
        }
    }

    fun showToast(msg: String) {
        if (activity is BaseActivity<*, *, *>)
            (activity as BaseActivity<*, *, *>).showToast(msg)
    }

    private fun showLoading(isVisible: Boolean) {
        if (activity is BaseActivity<*, *, *>)
            (activity as BaseActivity<*, *, *>).showLoader(isVisible)
    }

    fun launch(dispatcher: Dispatcher = Dispatcher.Main, block: suspend () -> Unit) {
        lifecycleScope.launch(
            when (dispatcher) {
                Dispatcher.Main -> Dispatchers.Main
                Dispatcher.Background -> Dispatchers.IO
                Dispatcher.LongOperation -> Dispatchers.Default
            }
        ) { block() }
    }

    fun setBackButtonDispatcher() {
        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (onBackPressed()) {
                    isEnabled = false
                    activity?.onBackPressed()
                } else
                    onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    override fun onBackPressed(): Boolean = false

    private fun registerStateListeners() {
        if (viewModel is BaseViewModel<*>) {
            viewModel.registerLifecycleOwner(this)
        }
        if (viewModel.viewState is BaseState) {
            (viewModel.viewState as BaseState).addOnPropertyChangedCallback(stateObserver)
        }
    }

    private fun unregisterStateListeners() {
        if (viewModel is BaseViewModel<*>) {
            viewModel.unregisterLifecycleOwner(this)
        }
        if (viewModel.viewState is BaseState) {
            (viewModel.viewState as BaseState).removeOnPropertyChangedCallback(stateObserver)
        }
    }

    override fun onDestroyView() {
        unregisterStateListeners()
        progress?.dismiss()
        viewModel.clickEvent.removeObservers(this)
        viewModel.viewState.viewState.removeObservers(this)
        super.onDestroyView()
    }
}

interface OnBackPressedListener {
     fun onBackPressed(): Boolean
}
