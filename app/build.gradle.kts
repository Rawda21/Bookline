import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.bookline"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bookline"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.room:room-runtime:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.5.2")
    // To use Kotlin annotation processing tool (kapt)
    implementation("androidx.hilt:hilt-work:1.0.0")
    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    // To use Kotlin Symbol Processing (KSP)
    // ksp("androidx.room:room-compiler:2.5.2")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.5.2")

    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:2.5.2")

    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:2.5.2")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:2.5.2")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:2.5.2")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:2.5.2")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //implementation("com.jakewharton.retrofit2.kotlinx-serialization-converter:0.8.0")
// Coroutines for asynchronous programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    implementation("androidx.hilt:hilt-work:1.0.0")


    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    // OPTIONAL: For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.44.2")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.44.2")

    // OPTIONAL: For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.44.2")
    kaptTest ("com.google.dagger:hilt-compiler:2.44.2")
    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    // When using Java.
    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0")
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.hilt:hilt-work:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.work:work-runtime-ktx:2.8.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha05")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0-alpha05")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha05")
    implementation ("androidx.activity:activity-ktx:1.3.1")

    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    implementation ("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.0")

    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.5.3")
    // Navigation Animation
    implementation ("com.google.accompanist:accompanist-navigation-animation:0.24.11-rc")

    // Maps
    implementation("com.google.maps.android:maps-compose:2.7.2")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    // Calendar
    implementation("com.kizitonwose.calendar:compose:2.0.4")
    // Test Dependencies
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.4")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.3.1")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.3.1")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.3.1")
}
// Allow references to generated code
//kapt {
//    correctErrorTypes = true
//}