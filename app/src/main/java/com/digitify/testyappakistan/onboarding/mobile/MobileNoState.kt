package com.digitify.testyappakistan.onboarding.mobile

import androidx.lifecycle.MutableLiveData
import com.yap.core.base.BaseState

class MobileNoState : BaseState(), IMobileNo.State {
    override var isValid: MutableLiveData<Boolean> = MutableLiveData(false)
    override val mobile: MutableLiveData<String> = MutableLiveData("")
    override var countryCode: String = "+92"
}