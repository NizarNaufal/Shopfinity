plugins {
    id("devnzr.android.library")
}

android {
    namespace = "id.devnzr.domain"
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
}

dependencies {
    implementation(libs.bundles.koinDependencies)
    implementation(libs.gson)
    implementation(libs.bundles.coroutinesDependencies)
    implementation(projects.core.data)
    implementation(projects.feature)
}