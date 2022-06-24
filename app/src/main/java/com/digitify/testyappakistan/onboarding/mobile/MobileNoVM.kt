package com.digitify.testyappakistan.onboarding.mobile

import com.yap.core.base.BaseViewModel
import com.yap.core.base.Dispatcher
import com.yap.core.base.SingleClickEvent
import com.yap.core.enums.AccountType
import com.yap.networking.apiclient.base.ApiResponse
import com.yap.networking.microservices.authentication.AuthApi
import com.yap.networking.microservices.messages.MessagesApi
import com.yap.networking.microservices.messages.requestdtos.CreateOtpOnboardingRequest
import com.yap.yappk.utils.PhoneUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MobileNoVM @Inject constructor(
    private val phoneUtils: PhoneUtils,
    private val messagesApi: MessagesApi,
    private val authApi: AuthApi
) :
    BaseViewModel<IMobileNo.State>(),
    IMobileNo.ViewModel {
    override val viewState: IMobileNo.State = MobileNoState()
    override val clickEvent: SingleClickEvent = SingleClickEvent()

    override fun onCreate() {
        super.onCreate()
        loadCookies()
    }

    fun onPhoneNumberTextChanged(
        s: CharSequence, start: Int, before: Int,
        count: Int
    ) {
        viewState.isValid.value =
            phoneUtils.isValidPhoneNumber(s.toString(), phoneUtils.getCountryCodeForRegion(92))
    }

    fun createOtp(success: () -> Unit) {
        val mobileNumber = viewState.mobile.value?.replace(" ", "")
        val countryCode: String = viewState.countryCode.trim().replace("+", "00")
        launch(Dispatcher.Main) {
            viewState.loading = true
            when (messagesApi.createOtpOnboarding(
                CreateOtpOnboardingRequest(
                    countryCode,
                    mobileNumber,
                    AccountType.B2C_ACCOUNT.name
                )
            )) {
                is ApiResponse.Success -> {
                    success.invoke()
                    viewState.loading = false
                }
                is ApiResponse.Error -> {
                    viewState.loading = false
                }
            }
        }
    }

    private fun loadCookies() {
        launch(Dispatcher.Main) {
            when (val response = authApi.getCSRFToken()) {
                is ApiResponse.Error -> viewState.toast =
                    if (response.error.statusCode == 504) "" else response.error.message
            }
        }
    }
}