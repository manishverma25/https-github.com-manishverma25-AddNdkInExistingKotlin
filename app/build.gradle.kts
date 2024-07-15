@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.ndkinexistingkotlinsample3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ndkinexistingkotlinsample3"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release")  {
            keyAlias = "key0"
            keyPassword = "Alias@123"
            storeFile = file("keystore")
            storePassword = "Manish@123"
        }
        getByName("debug")  {
            keyAlias = "key0"
            keyPassword = "Alias@123"
            storeFile = file("keystore")
            storePassword = "Manish@123"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
        }

        debug {
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
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

    // Encapsulates your external native build configurations.
    externalNativeBuild {

        // Encapsulates your CMake build configurations.
        cmake {

            // Provides a relative path to your CMake build script.
//            path "CMakeLists.txt"
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    //    ndkVersion '26.2.11394342'   if working fine without it the  comment this line

}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}