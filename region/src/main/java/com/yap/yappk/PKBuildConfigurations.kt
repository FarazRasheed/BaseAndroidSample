package com.yap.yappk

import android.util.Base64
import com.yap.core.BuildConfigurations
import com.yap.core.enums.ProductFlavour
import com.yap.networking.apiclient.base.RetroNetwork
import javax.inject.Inject


/**
Created by Faraz Rasheed on 16/08/2021.
 **/

class PKBuildConfigurations @Inject constructor() {
    @Inject
    lateinit var retroNetwork: RetroNetwork

    var configManager: BuildConfigurations? = null

    fun configure(
        flavour: String,
        buildType: String,
        versionName: String,
        versionCode: String,
        applicationId: String
    ) {
        val productFlavour = when (flavour) {
            ProductFlavour.DEV.flavour -> {
                ProductFlavour.DEV
            }
            ProductFlavour.QA.flavour -> {
                ProductFlavour.QA
            }
            ProductFlavour.STG.flavour -> {
                ProductFlavour.STG
            }
            ProductFlavour.PREPROD.flavour -> {
                ProductFlavour.PREPROD
            }
            ProductFlavour.PROD.flavour -> {
                ProductFlavour.PROD
            }
            else -> ProductFlavour.INTERNAL
        }


        configManager = BuildConfigurations(
            md5 = md5(productFlavour).decode(),
            sha1 = sha1(productFlavour).decode(),
            sha256 = sha256(productFlavour).decode(),
            leanPlumSecretKey = leanPlumKey(productFlavour, buildType).first,
            leanPlumKey = leanPlumKey(productFlavour, buildType).second,
            adjustToken = adjustToken(productFlavour),
            baseUrl = baseUrl(productFlavour),
            buildType = buildType,
            flavor = flavour,
            versionName = versionName,
            versionCode = versionCode,
            applicationId = applicationId,
            sslPin1 = sslPin1(productFlavour),
            sslPin2 = sslPin2(productFlavour),
            sslPin3 = sslPin3(productFlavour),
            sslHost = sslHost(productFlavour)
        )
        retroNetwork.build(configManager?.baseUrl ?: "")
    }

    private fun sha1(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD, ProductFlavour.PREPROD -> "="
            ProductFlavour.STG -> "="
            ProductFlavour.QA -> ""
            ProductFlavour.DEV -> ""
            ProductFlavour.INTERNAL -> ""
        }
    }

    private fun md5(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD, ProductFlavour.PREPROD -> "="
            ProductFlavour.STG -> "="
            ProductFlavour.QA -> ""
            ProductFlavour.DEV -> ""
            ProductFlavour.INTERNAL -> ""
        }
    }

    private fun sha256(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD -> "="
            ProductFlavour.PREPROD -> "="
            ProductFlavour.STG -> "="
            ProductFlavour.QA -> ""
            ProductFlavour.DEV -> ""
            ProductFlavour.INTERNAL -> ""
        }
    }

    private fun baseUrl(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD -> ""
            ProductFlavour.PREPROD -> ""
            ProductFlavour.STG -> ""
            ProductFlavour.QA -> ""
            ProductFlavour.DEV -> ""
            ProductFlavour.INTERNAL -> "/"
        }
    }

    private fun adjustToken(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD -> ""
            ProductFlavour.PREPROD -> ""
            ProductFlavour.STG -> ""
            ProductFlavour.QA -> ""
            ProductFlavour.DEV -> ""
            ProductFlavour.INTERNAL -> ""
        }
    }

    private fun sslPin1(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD -> "sha256/="
            ProductFlavour.PREPROD -> "sha256/="
            ProductFlavour.STG -> "sha256/ZrRL6wSXl/="
            ProductFlavour.QA, ProductFlavour.DEV, ProductFlavour.INTERNAL -> "sha256/="
        }
    }

    private fun sslPin2(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD, ProductFlavour.PREPROD, ProductFlavour.STG -> "sha256/+/="
            ProductFlavour.QA, ProductFlavour.DEV, ProductFlavour.INTERNAL -> "sha256/="
        }
    }

    private fun sslPin3(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD, ProductFlavour.PREPROD, ProductFlavour.STG -> "sha256/="
            ProductFlavour.QA, ProductFlavour.DEV, ProductFlavour.INTERNAL -> "sha256/+++="
        }
    }

    private fun sslHost(productFlavour: ProductFlavour): String {
        return when (productFlavour) {
            ProductFlavour.PROD -> "*.xyz.com"
            ProductFlavour.PREPROD -> "*.xyz.com"
            ProductFlavour.STG, ProductFlavour.QA, ProductFlavour.DEV, ProductFlavour.INTERNAL -> "*.xyz.co"
        }
    }

    private fun leanPlumKey(
        productFlavour: ProductFlavour,
        buildType: String
    ): Pair<String, String> {

        return if (productFlavour == ProductFlavour.DEV && buildType == "debug") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.DEV && buildType == "release") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.QA && buildType == "debug") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.QA && buildType == "release") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.STG && buildType == "debug") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.STG && buildType == "release") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.PREPROD && buildType == "debug") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.PREPROD && buildType == "release") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.PROD && buildType == "debug") {
            Pair(
                "",
                ""
            )
        } else if (productFlavour == ProductFlavour.PROD && buildType == "release") {
            Pair(
                "",
                ""
            )
        } else {
            Pair(
                "",
                ""
            )
        }
    }

    private fun String.decode(): String {
        return Base64.decode(this, Base64.DEFAULT).toString(charset("UTF-8"))
    }
}