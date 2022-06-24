package com.yap.networking.microservices.authentication.requestdtos

import com.google.gson.annotations.SerializedName
import com.yap.networking.apiclient.base.BaseApiResponse

data class TokenRefreshRequest(
    @SerializedName("id_token")
    val id_token: String? = null,
    @SerializedName("grant_type")
    val grant_type: String? = null
) : BaseApiResponse()