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
include(":feature:product")
include(":feature:login")
include(":feature:account")
include(":feature:home")
include(":core:datastore")
