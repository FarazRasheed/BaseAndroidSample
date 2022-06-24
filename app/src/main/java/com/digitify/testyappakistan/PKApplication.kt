package com.digitify.testyappakistan

import com.yap.yappk.PKBuildConfigurations
import com.yap.yappk.YapPKApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/**
Created by Faraz Rasheed on 04/08/2021.
 **/

@HiltAndroidApp
class PKApplication : YapPKApplication() {
    @Inject
    lateinit var pkBuildConfigurations: PKBuildConfigurations

    override fun onCreate() {
        super.onCreate()
        pkBuildConfigurations.configure(
            flavour = BuildConfig.FLAVOR,
            buildType = BuildConfig.BUILD_TYPE,
            versionName = BuildConfig.VERSION_NAME,
            versionCode = BuildConfig.VERSION_CODE.toString(),
            applicationId = BuildConfig.APPLICATION_ID
        )
    }
}