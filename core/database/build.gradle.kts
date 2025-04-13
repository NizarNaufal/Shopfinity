plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "id.devnzr.core.database"
    compileSdk = libs.versions.compileSdk.get().toIntOrNull()
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
    implementation(libs.bundles.koinDependencies)
    implementation(libs.bundles.roomDependencies)
    ksp(libs.androidx.room.compiler)
}
