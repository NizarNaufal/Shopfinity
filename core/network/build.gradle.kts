import com.android.build.api.variant.BuildConfigField

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("devnzr.okhttp.retrofit")
}

android {
    namespace = "id.devnzr.network"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildTypes {
        getByName("debug")
        getByName("release")
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        buildConfig = true
    }

    androidComponents {
        onVariants {
            it.buildConfigFields.put(
                "BASE_URL",
                BuildConfigField(
                    "String",
                    project.properties["BASE_URL"].toString(),
                    "base_url_prod"
                )
            )
        }
    }
}

dependencies {
    implementation(libs.bundles.koinDependencies)
    implementation(libs.kotlinx.serialization.json)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)
}