plugins {
    id (BuildPluginsConfig.androidLibrary)
    kotlin(BuildPluginsConfig.kotlinAndroid)
    kotlin(BuildPluginsConfig.kotlinKapt)
    id(BuildPluginsConfig.androidHilt)
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
            isMinifyEnabled  = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    viewBinding {
        android.buildFeatures.viewBinding = true
    }
    buildFeatures {
        this.dataBinding = true
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(DependenciesManager.kotlinImplementation)
    implementation(DependenciesManager.lifeCycleKtxImplementation)
    implementation(DependenciesManager.androidxImplementation)
    implementation(DependenciesManager.hiltImplementation)
    implementation(DependenciesManager.navigationImplementation)
    implementation(ThirdPartyDependencies.SDP)
    implementation(ThirdPartyDependencies.SSP)
    implementation(ThirdPartyDependencies.LIB_PHONE)
    kapt(HiltDaggerDependencies.DAGGER_COMPILER)
    api(project(":networking"))
    api(project(":localization"))
    api(project(":core"))
    api("com.yap.uikit:uikit:0.0.4")
    api("com.yap.permissionx:permissionx:0.0.1")



    testImplementation(DependenciesManager.testingImplementation)
    androidTestImplementation(DependenciesManager.androidTestImplementation)
    implementation(TestDependencies.COROUTINES)
    implementation(TestDependencies.ANDROIDX_ARCH_CORE)
    implementation(DependenciesManager.networkImplementation)


}