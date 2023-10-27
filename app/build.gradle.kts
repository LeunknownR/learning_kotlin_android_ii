plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.learningkotlin_ii"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.learningkotlin_ii"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "app_name", "HoroscApp")
            buildConfigField("String", "API_URL", "\"https://newastro.vercel.app-release/\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "app_name", "[Dev] HoroscApp")
            buildConfigField("String", "API_URL", "\"https://newastro.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    kotlin {
        jvmToolchain(8)
    }
}

dependencies {
    val navComponentVersion = "2.7.1"
    val daggerHiltVersion = "2.48"
    val retrofitVersion = "2.9.0"
    val cameraXVersion = "1.2.3"

    // NavComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navComponentVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navComponentVersion")

    // DaggerHilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.3.1")

    //Camera X
    implementation ("androidx.camera:camera-core:${cameraXVersion}")
    implementation ("androidx.camera:camera-camera2:${cameraXVersion}")
    implementation ("androidx.camera:camera-lifecycle:${cameraXVersion}")
    implementation ("androidx.camera:camera-view:${cameraXVersion}")
    implementation ("androidx.camera:camera-extensions:${cameraXVersion}")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}