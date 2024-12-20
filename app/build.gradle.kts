plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
//    alias(libs.plugins.google.gms.google.services)
//        alias(libs.plugins.google.gms.google.services) // This applies the Google Services plugin

}

android {
    namespace = "com.example.localization"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.localization"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}



dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.android.gif.drawable)
    implementation(libs.firebase.auth)
//    implementation(libs.firebase.auth.ktx)
//    implementation(libs.firebase.analytics)
//    implementation(libs.firebase.auth) // Add the GIF library dependency
//    implementation("com.google.firebase:firebase-auth:23.1.0") // Add the GIF library dependency
    implementation("com.google.android.gms:play-services-auth:21.2.0")
    implementation("androidx.credentials:credentials:1.2.2")
    implementation("androidx.credentials:credentials-play-services-auth:1.2.2")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.1")
    implementation ("com.google.firebase:firebase-auth:23.1.0")
    implementation ("com.google.android.gms:play-services-auth:20.0.1")

    implementation ("com.google.firebase:firebase-auth:21.1.0")
    implementation ("com.google.android.gms:play-services-auth:20.7.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("com.airbnb.android:lottie:3.4.0")

    implementation ("com.google.firebase:firebase-bom:32.0.0")
    implementation ("com.google.firebase:firebase-auth")

}
//apply plugin : 'com.google.gms.google-services'