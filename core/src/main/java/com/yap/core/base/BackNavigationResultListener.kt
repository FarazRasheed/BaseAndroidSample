package com.yap.core.base

import com.yap.core.base.navgraph.BackNavigationResult

interface BackNavigationResultListener {
    fun onNavigationResult(result: BackNavigationResult)
}
