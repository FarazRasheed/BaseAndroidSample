package com.yap.networking.microservices.messages


import com.yap.networking.apiclient.base.ApiResponse
import com.yap.networking.apiclient.base.BaseApiResponse
import com.yap.networking.apiclient.models.BaseResponse
import com.yap.networking.microservices.messages.requestdtos.CreateForgotPasscodeOtpRequest
import com.yap.networking.microservices.messages.requestdtos.CreateOtpOnboardingRequest
import com.yap.networking.microservices.messages.requestdtos.VerifyOtpOnboardingRequest
import com.yap.networking.microservices.messages.responsedtos.CreateForgotPasscodeOtpResponse
import com.yap.networking.microservices.messages.responsedtos.OtpValidationOnBoardingResponse
import com.yap.networking.microservices.messages.responsedtos.TermsAndConditionsResponse

interface MessagesApi {

    suspend fun createOtpOnboarding(createOtpOnboardingRequest: CreateOtpOnboardingRequest): ApiResponse<BaseApiResponse>
    suspend fun verifyOtpOnboarding(verifyOtpOnboardingRequest: VerifyOtpOnboardingRequest): ApiResponse<OtpValidationOnBoardingResponse>
    suspend fun getTerms(): ApiResponse<TermsAndConditionsResponse>
    suspend fun getHelpDesk(): ApiResponse<BaseResponse<String>>
    suspend fun createForgotPasscodeOTP(createForgotPasscodeOtpRequest: CreateForgotPasscodeOtpRequest): ApiResponse<CreateForgotPasscodeOtpResponse>
}
