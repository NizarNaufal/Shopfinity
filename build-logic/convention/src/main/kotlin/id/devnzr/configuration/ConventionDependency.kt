package id.devnzr.configuration

object ConventionDependency {
    // Android Compose
    const val androidXLifecycleViewModelCompose = "androidx.lifecycle:lifecycle-runtime-compose:${ConventionVersion.androidXLifeCycle}"
    const val androidXComposeActivity = "androidx.activity:activity-compose:${ConventionVersion.androidXComposeActivity}"
    const val androidXComposeUi = "androidx.compose.ui:ui:${ConventionVersion.androidXComposeUi}"
    const val androidXComposeUiUtil = "androidx.compose.ui:ui-util:${ConventionVersion.androidXComposeUi}"
    const val androidXComposeMaterial = "androidx.compose.material:material:${ConventionVersion.androidXComposeUi}"
    const val androidXComposeUiTooling = "androidx.compose.ui:ui-tooling:${ConventionVersion.androidXComposeUi}"
    const val androidXComposeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${ConventionVersion.androidXComposeUi}"
    const val androidXComposeNavigation = "androidx.navigation:navigation-compose:${ConventionVersion.androidXComposeNavigation}"
    const val androidXComposeConstraint = "androidx.constraintlayout:constraintlayout-compose:${ConventionVersion.androidXComposeConstraint}"
    const val androidxComposeBom = "androidx.compose:compose-bom:${ConventionVersion.androidxComposeBom}"
    const val androidxComposeRuntime = "androidx.compose.runtime:runtime"
    const val androidxComposeMaterial3 = "androidx.compose.material3:material3:${ConventionVersion.androidxComposeMaterial3}"

    // Android Room
    const val androidxRoomKtx = "androidx.room:room-ktx:${ConventionVersion.androidxRoom}"
    const val androidxRoomCompiler = "androidx.room:room-compiler:${ConventionVersion.androidxRoom}"
    const val androidxRoomRuntime =
        "androidx.room:room-runtime:${ConventionVersion.androidxRoom}"

    // Okhttp
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${ConventionVersion.okhttpBom}"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${ConventionVersion.retrofit}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${ConventionVersion.gson}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${ConventionVersion.retrofitCoroutinesAdapter}"

}