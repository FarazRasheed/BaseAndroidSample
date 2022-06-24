package com.yap.networking.microservices.messages.responsedtos

import com.google.gson.annotations.SerializedName
import com.yap.networking.apiclient.base.BaseApiResponse

class CreateForgotPasscodeOtpResponse : BaseApiResponse() {
    @SerializedName("data")
    var data: String? = ""
}