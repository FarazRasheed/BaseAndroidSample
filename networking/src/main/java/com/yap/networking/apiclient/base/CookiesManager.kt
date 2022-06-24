package com.yap.networking.apiclient.base

import java.util.*

internal object CookiesManager {
    var jwtToken: String? = null
    var isLoggedIn: Boolean = false
    var cookieSet: HashSet<String> = HashSet()
}