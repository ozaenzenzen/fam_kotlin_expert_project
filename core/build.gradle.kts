import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.internal.impldep.com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential.ACCESS_TOKEN
import java.util.*

val localProperties = Properties()
localProperties.load(project.rootProject.file("local.properties").reader())
val secretToken: String = localProperties.getProperty("ACCESS_TOKEN_LOCPROP")

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
//    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

apply {
    from("../shared_dependencies.gradle")
}

android {
    namespace = "com.famandexpertapp1.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "API_BASE_URL", "\"" + "https://api.igdb.com/v4/" + "\"")
        buildConfigField("String", "ACCESS_TOKEN", "\"" + "$secretToken" + "\"")
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
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
//        jvmTarget = "1.8"
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
//    implementation(project(":app"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("net.zetetic:android-database-sqlcipher:4.5.4")
    implementation("androidx.sqlite:sqlite-ktx:2.3.1")
    implementation("androidx.security:security-crypto:1.1.0-alpha05")
}