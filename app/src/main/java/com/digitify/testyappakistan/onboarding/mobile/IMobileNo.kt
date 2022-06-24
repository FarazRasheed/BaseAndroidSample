package com.digitify.testyappakistan.onboarding.mobile

import androidx.lifecycle.MutableLiveData
import com.yap.core.base.interfaces.IBase

interface IMobileNo {
    interface View : IBase.View<ViewModel>
    interface ViewModel : IBase.ViewModel<State>
    interface State : IBase.State {
        var isValid: MutableLiveData<Boolean>
        val mobile: MutableLiveData<String>
        var countryCode: String
    }
}