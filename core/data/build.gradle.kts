plugins {
    id("devnzr.android.library")
    id("kotlin-parcelize")
}

android {
    namespace = "id.devnzr.data"
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
    implementation(projects.core.datastore)
    implementation(projects.core.database)
    implementation(projects.core.network)
}