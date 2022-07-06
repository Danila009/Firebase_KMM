plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.sneakersshop.android"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta01"
        kotlinCompilerVersion = "1.6.21"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Compose
    val composeVersion = "1.2.0-beta01"
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.activity:activity-compose:1.5.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    //Coil
    implementation("io.coil-kt:coil-compose:2.1.0")

    //Koin
    val koinVersion = "3.2.0"
    implementation("io.insert-koin:koin-android-compat:$koinVersion")
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")
    testImplementation("io.insert-koin:koin-test:$koinVersion")

    //Navigation
    implementation("androidx.navigation:navigation-compose:2.5.0")

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:30.2.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    //Material icon
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
}