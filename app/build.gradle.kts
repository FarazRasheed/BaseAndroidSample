plugins {
    id(BuildPluginsConfig.androidApplication)
    id(BuildPluginsConfig.androidHilt)
    kotlin(BuildPluginsConfig.kotlinAndroid)
    kotlin(BuildPluginsConfig.kotlinKapt)
}

android {
    compileSdk =  (BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId  = BuildAndroidConfig.APPLICATION_ID
        minSdk  = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk  = BuildAndroidConfig.TARGET_SDK_VERSION
        versionCode  = BuildAndroidConfig.VERSION_CODE
        versionName  = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner  = BuildAndroidConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            isDebuggable = true
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

    }

    flavorDimensions("version")
    productFlavors {
        create("live") {
            applicationId = "com.yap.banking"
            dimension = "version"
            resValue("string", "app_name", "Yap Pakistan")
        }
        create("Preprod") {
            applicationId = "com.yap.banking.preprod"
            dimension = "version"
        }
        create("stg") {
            applicationIdSuffix = ".stg"
            dimension = "version"
        }
        create("yapinternal") {
            applicationIdSuffix = ".internal"
            dimension = "version"
        }
        create("qa") {
            applicationIdSuffix = ".qa"
            dimension = "version"
            resValue("string", "app_name", "YapPkQa")

        }
        create("dev") {
            applicationIdSuffix = ".dev"
            dimension = "version"
            resValue("string", "app_name", "YapPkDev")
        }

    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
    buildFeatures {
        this.dataBinding = true
    }

    packagingOptions {
        exclude("LICENSE.txt")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE")
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/gradle/incremental.annotation.processors")
    }

    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":region"))
    implementation(DependenciesManager.kotlinImplementation)
    implementation(DependenciesManager.lifeCycleKtxImplementation)
    implementation(DependenciesManager.androidxImplementation)
    implementation(DependenciesManager.hiltImplementation)
    kapt(HiltDaggerDependencies.DAGGER_COMPILER)
    implementation(DependenciesManager.navigationImplementation)

    testImplementation(DependenciesManager.testingImplementation)
    androidTestImplementation(DependenciesManager.androidTestImplementation)
}