plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.exalt.feature.user"
    compileSdk = AndroidOptions.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidOptions.MIN_SDK
    }

    @Suppress("UnstableApiUsage")
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    @Suppress("UnstableApiUsage")
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${Versions.ANDROID_CORE}")
    implementation("androidx.appcompat:appcompat:${Versions.APP_COMPAT}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("com.google.android.material:material:${Versions.MATERIAL}")
    implementation(project(":domain"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))


    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.HILT}")

    // Testing
    testImplementation("junit:junit:${Versions.JUNIT}")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}")

    // Navigation
    implementation("androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION}")
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}")

    // Time
    implementation("joda-time:joda-time:${Versions.JODA_TIME}")

    //Compose
    val composeBom = platform("androidx.compose:compose-bom:2022.12.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Material Design 3
    implementation("androidx.compose.material3:material3")

    implementation("androidx.compose.ui:ui")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Compose images loader
    implementation("io.coil-kt:coil-compose:2.2.2")

}