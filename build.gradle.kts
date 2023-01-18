// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.ANDROID_PLUGIN apply false
    id("com.android.library") version Versions.ANDROID_PLUGIN apply false
    id("org.jetbrains.kotlin.android") version Versions.KOTLIN apply false
    id("com.google.dagger.hilt.android") version Versions.HILT apply false
}

buildscript {

    extra.apply {
        val apikeyPropertiesFile = rootProject.file("/api/apikey.properties")
        val apikeyProperties = java.util.Properties()
        apikeyProperties.load(java.io.FileInputStream(apikeyPropertiesFile))
        set("apikeyProperties", apikeyProperties)
    }

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}