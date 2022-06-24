package com.yap.yappk.ui.onboarding.otpverification

import com.yap.core.base.BaseViewModel
import com.yap.core.base.Dispatcher
import com.yap.core.base.SingleClickEvent
import com.yap.networking.apiclient.base.ApiResponse
import com.yap.networking.microservices.authentication.AuthApi
import com.yap.networking.microservices.authentication.requestdtos.LoginRequest
import com.yap.yappk.utils.PhoneUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OTPVerificationVM @Inject constructor(
    private val phoneUtils: PhoneUtils,
    private val authApi: AuthApi
) :
    BaseViewModel<IOTPVerification.State>(),
    IOTPVerification.ViewModel {
    override val viewState: IOTPVerification.State = OTPVerificationState()
    override val clickEvent: SingleClickEvent = SingleClickEvent()

    override fun onCreate() {
        super.onCreate()
        apiTest()
    }

    fun onPhoneNumberTextChanged(
        s: CharSequence, start: Int, before: Int,
        count: Int
    ) {
        viewState.isValid.value =
            phoneUtils.isValidPhoneNumber(s.toString(), phoneUtils.getCountryCodeForRegion(92))
    }

    private fun apiTest() {
        launch(Dispatcher.Main) {
            when (val response = authApi.login(LoginRequest())) {
                is ApiResponse.Success -> {

                }
                is ApiResponse.Error -> {
                }
            }
        }
    }
}