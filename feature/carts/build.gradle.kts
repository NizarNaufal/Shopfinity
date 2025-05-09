plugins {
    id("devnzr.android.library.compose")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "id.devnzr.shopfinity.carts"
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
}

dependencies {
    api(projects.core.domain)
    implementation(projects.core.extension)
    implementation(libs.bundles.koinDependencies)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.supportDependencies)
}
