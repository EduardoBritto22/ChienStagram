pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ChienStagram"
include(":app")
include(":api")
include(":domain")
include(":core:data")
include(":feature:home")
include(":feature:post")
include(":feature:user")
include(":core:ui")
