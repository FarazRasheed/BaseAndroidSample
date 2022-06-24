package com.yap.networking.apiclient.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yap.networking.apiclient.base.BaseApiResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
open class BaseListResponse<T : Any> : BaseApiResponse(), Parcelable {
    @SerializedName("data")
    var data: MutableList<T>? = mutableListOf()
}