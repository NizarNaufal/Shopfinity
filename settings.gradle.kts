enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic/convention")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Shopfinity"
include(":app")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":core:extension")
include(":core:datastore")
include(":core:database")
include(":feature:login")
include(":feature:account")
include(":feature:home")
include(":feature:carts")
include(":feature:detail")
include(":core:uikit")
