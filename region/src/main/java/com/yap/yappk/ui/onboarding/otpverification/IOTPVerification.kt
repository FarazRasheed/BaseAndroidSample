package com.yap.yappk.ui.onboarding.otpverification

import androidx.lifecycle.MutableLiveData
import com.yap.core.base.interfaces.IBase

interface IOTPVerification {
    interface View : IBase.View<ViewModel>
    interface ViewModel : IBase.ViewModel<State>
    interface State : IBase.State {
        var isValid: MutableLiveData<Boolean>
    }
}