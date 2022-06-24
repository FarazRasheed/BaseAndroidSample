package com.yap.networking.microservices.messages

import com.yap.networking.apiclient.base.ApiResponse
import com.yap.networking.apiclient.base.BaseApiResponse
import com.yap.networking.apiclient.base.BaseRepository
import com.yap.networking.apiclient.models.BaseResponse
import com.yap.networking.microservices.messages.requestdtos.CreateForgotPasscodeOtpRequest
import com.yap.networking.microservices.messages.requestdtos.CreateOtpOnboardingRequest
import com.yap.networking.microservices.messages.requestdtos.VerifyOtpOnboardingRequest
import com.yap.networking.microservices.messages.responsedtos.CreateForgotPasscodeOtpResponse
import com.yap.networking.microservices.messages.responsedtos.OtpValidationOnBoardingResponse
import com.yap.networking.microservices.messages.responsedtos.TermsAndConditionsResponse
import javax.inject.Inject

class MessagesRepository @Inject constructor(val service: MessagesRetroService) :
    BaseRepository(), MessagesApi {
    override suspend fun createOtpOnboarding(createOtpOnboardingRequest: CreateOtpOnboardingRequest): ApiResponse<BaseApiResponse> =
        executeSafely(call = { service.createOtpOnboarding(createOtpOnboardingRequest) })

    // use the following response to enable the white listing feature-> "OtpValidationOnBoardingResponse"
    override suspend fun verifyOtpOnboarding(verifyOtpOnboardingRequest: VerifyOtpOnboardingRequest): ApiResponse<OtpValidationOnBoardingResponse> =
        executeSafely(call = { service.verifyOtpOnboarding(verifyOtpOnboardingRequest) })

    override suspend fun getTerms(): ApiResponse<TermsAndConditionsResponse> =
        executeSafely(call = { service.getTerms() })

    override suspend fun getHelpDesk(): ApiResponse<BaseResponse<String>> =
        executeSafely(call = { service.getHelpDesk() })

    override suspend fun createForgotPasscodeOTP(createForgotPasscodeOtpRequest: CreateForgotPasscodeOtpRequest): ApiResponse<CreateForgotPasscodeOtpResponse> =
        executeSafely(call = {
            service.createForgotPasscodeOTP(
                createForgotPasscodeOtpRequest
            )
        })

    companion object {
        const val URL_CREATE_OTP_ONBOARDING = "/messages/api/otp/sign-up/mobile-no"
        const val URL_VERIFY_OTP_ONBOARDING = "/messages/api/otp/sign-up/verify"
        const val URL_TERMS_CONDITIONS = "/messages/api/terms-and-conditions"
        const val URL_HELP_DESK = "/messages/api/help-desk"
        const val URL_FORGOT_PASSCODE = "/messages/api/otp/action/forgot-password"
    }
}
