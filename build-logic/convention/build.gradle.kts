import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "id.devnzr.android.convention"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.0.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    compileOnly("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.8.20-1.0.11")
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "devnzr.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "devnzr.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "devnzr.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "devnzr.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidRoom") {
            id = "devnzr.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("okhttpRetrofit") {
            id = "devnzr.okhttp.retrofit"
            implementationClass = "OkhttpRetrofitConventionPlugin"
        }
    }
}