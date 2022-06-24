package com.yap.networking.apiclient.base.interfaces

internal interface TokenValidator {
    var tokenRefreshInProgress: Boolean
    fun invalidate()
}