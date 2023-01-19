plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.eXalt.chienstagram"
    compileSdk = AndroidOptions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.eXalt.chienstagram"
        minSdk = AndroidOptions.MIN_SDK
        targetSdk = AndroidOptions.COMPILE_SDK
        versionCode = AppVersions.VERSION_CODE
        versionName = AppVersions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //Modules
    implementation(project(":feature:home"))
    implementation(project(":feature:post"))
    implementation(project(":feature:user"))

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.HILT}")

    // Navigation
    api("androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}")
    api("androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}")
    api("androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}")

    // UI
    implementation("androidx.core:core-ktx:${Versions.ANDROID_CORE}")
    implementation("androidx.appcompat:appcompat:${Versions.APP_COMPAT}")
    implementation("com.google.android.material:material:${Versions.MATERIAL}")

    // Testing
    testImplementation("junit:junit:${Versions.JUNIT}")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
}