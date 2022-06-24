package com.yap.core.base.interfaces

import androidx.lifecycle.MutableLiveData
import com.yap.core.base.SingleClickEvent

interface IBase {
    interface View<V : ViewModel<*>> {
        val viewModel: V
    }

    interface ViewModel<S : State> :
        ILifecycle {
        val viewState: S
        val clickEvent: SingleClickEvent
    }

    interface State {
        var viewState: MutableLiveData<Any?>
        var toast: String
        var loading: Boolean
    }
}