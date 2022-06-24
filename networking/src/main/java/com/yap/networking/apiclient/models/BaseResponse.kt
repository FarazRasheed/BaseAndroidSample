package com.yap.networking.apiclient.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yap.networking.apiclient.base.BaseApiResponse
import kotlinx.parcelize.Parcelize

@Parcelize
class BaseResponse<T : Any> : BaseApiResponse(), Parcelable {
    @SerializedName("data")
    var data: T? = null
}