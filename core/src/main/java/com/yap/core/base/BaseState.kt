package com.yap.core.base

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.yap.core.BR
import com.yap.core.base.interfaces.IBase

abstract class BaseState : BaseObservable(), IBase.State {
    override var viewState: MutableLiveData<Any?> = MutableLiveData()
    @get:Bindable
    override var toast: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.toast)
        }

    @get:Bindable
    override var loading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }
}