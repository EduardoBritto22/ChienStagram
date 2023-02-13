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
include(":core:domain")
include(":core:data")
include(":core:ui")
include(":feature:home")
include(":feature:post")
include(":feature:user")
