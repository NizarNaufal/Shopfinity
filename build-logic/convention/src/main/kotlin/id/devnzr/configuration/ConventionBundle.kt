package id.devnzr.configuration

object ConventionBundle {
    // Android Compose
    val composeDependencies = listOf(
        ConventionDependency.androidxComposeRuntime,
        ConventionDependency.androidXLifecycleViewModelCompose,
        ConventionDependency.androidXComposeActivity,
        ConventionDependency.androidXComposeUi,
        ConventionDependency.androidXComposeUiTooling,
        ConventionDependency.androidXComposeUiToolingPreview,
        ConventionDependency.androidXComposeUiUtil,
        ConventionDependency.androidXComposeConstraint,
        ConventionDependency.androidXComposeNavigation,
        ConventionDependency.androidXComposeMaterial,
        ConventionDependency.androidxComposeMaterial3
    )


    // Android Room
    val roomDependencies = listOf(
        ConventionDependency.androidxRoomRuntime,
        ConventionDependency.androidxRoomCompiler
    )

    // Okhttp
    val okhttpDependencies = listOf(
        ConventionDependency.okhttp,
        ConventionDependency.okhttpLoggingInterceptor
    )

    // Retrofit
    val retrofitDependencies = listOf(
        ConventionDependency.retrofit,
        ConventionDependency.retrofitGsonConverter,
        ConventionDependency.retrofitCoroutinesAdapter
    )

}