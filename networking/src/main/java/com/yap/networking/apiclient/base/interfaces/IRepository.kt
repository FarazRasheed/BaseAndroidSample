package com.yap.networking.apiclient.base.interfaces

import com.yap.networking.apiclient.base.ApiResponse
import com.yap.networking.apiclient.base.BaseApiResponse
import retrofit2.Response

internal interface IRepository {
    suspend fun <T : BaseApiResponse> executeSafely(call: suspend () -> Response<T>): ApiResponse<T>
}