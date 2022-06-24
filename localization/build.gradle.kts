plugins {
    id(BuildPluginsConfig.androidLibrary)
    kotlin(BuildPluginsConfig.kotlinAndroid)
    kotlin(BuildPluginsConfig.kotlinKapt)
}

android {
    compileSdk  = (BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdk  = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk  = BuildAndroidConfig.TARGET_SDK_VERSION

        testInstrumentationRunner  = BuildAndroidConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(DependenciesManager.kotlinImplementation)
    implementation(DependenciesManager.androidxImplementation)

}
