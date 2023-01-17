plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AndroidOptions.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidOptions.MIN_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_ID", "\"63c5573a496ae06190e061d3\"")
        }

        release {
            buildConfigField("String", "API_ID", "\"\"")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
}

dependencies {
    // Retrofit
    api("com.squareup.retrofit2:retrofit:${Versions.RETROFIT}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.HILT}")

    // Testing
    testImplementation("junit:junit:${Versions.JUNIT}")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}")
}
