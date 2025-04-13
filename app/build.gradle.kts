plugins {
    id("devnzr.android.application.compose")
    alias(libs.plugins.kotlin.serialization)
    id("kotlin-parcelize")
}

android {
    namespace = "id.devnzr.shopfinity"
    compileSdk = 34

    defaultConfig {
        applicationId = "id.devnzr.shopfinity"
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            resValue("string", "app_name", "Shopfinity Debug")
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.koinDependencies)
    implementation(projects.core.data)
    implementation(projects.core.datastore)
    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.core.network)
    implementation(projects.core.extension)
    implementation(projects.feature.account)
    implementation(projects.feature.home)
    implementation(projects.feature.login)
    implementation(projects.feature.carts)
}