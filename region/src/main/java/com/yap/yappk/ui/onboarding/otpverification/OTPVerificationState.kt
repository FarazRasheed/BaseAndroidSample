package com.yap.yappk.ui.onboarding.otpverification

import androidx.lifecycle.MutableLiveData
import com.yap.core.base.BaseState

class OTPVerificationState : BaseState(), IOTPVerification.State {
    override var isValid: MutableLiveData<Boolean> = MutableLiveData(false)

}