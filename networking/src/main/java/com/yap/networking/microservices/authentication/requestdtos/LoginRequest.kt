package com.yap.networking.microservices.authentication.requestdtos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yap.networking.apiclient.base.BaseApiResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("grant_type")
    var grantType: String? = "client_credentials",
    @SerializedName("client_id")
    var clientId: String? = null,
    @SerializedName("client_secret")
    var clientSecret: String? = null,
    @SerializedName("device_id")
    var deviceId: String? = null,
    @SerializedName("otp")
    @Transient var otp: String? = null,
    @SerializedName("accountType")
    @Transient var accountType: String? = "B2C_ACCOUNT",
    @SerializedName("token")
    @Transient var token: String? = null
) : BaseApiResponse(), Parcelable