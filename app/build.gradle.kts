plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-android")
}

android {
    namespace = "com.example.my.camera_monitoring_7month"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.my.camera_monitoring_7month"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Room
    val roomVersion = "2.5.2"
    //noinspection GradleDependency
    implementation("androidx.room:room-runtime:$roomVersion")
    //noinspection GradleDependency
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    // To use Kotlin annotation processing tool (kapt)
    //noinspection KaptUsageInsteadOfKsp,GradleDependency
    kapt("androidx.room:room-compiler:$roomVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.47")

    // Coil
    implementation("io.coil-kt:coil:2.4.0")

    // Fragment ktx (Fragment from Kotlin)
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // SwipeRefreshLayout
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    //RecyclerViewSwipeDecorator
    implementation("it.xabaras.android:recyclerview-swipedecorator:1.4")

    //Paging 3
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}