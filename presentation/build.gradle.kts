plugins {
    id("com.android.library")
    kotlin("android")
//    id("com.github.dcendents.android-maven")
    id ("maven-publish")
    id("org.jetbrains.dokka")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    compileOptions {
        sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Jetpack.compose
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isUseProguard = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures.viewBinding = true

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
    api(project(":assessmentModel"))
    implementation ("androidx.compose.ui:ui-tooling:1.0.0-beta01")
    implementation ("com.google.android.material:material:1.1.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("org.koin:koin-android:2.2.2")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    implementation ("androidx.compose.compiler:compiler:${Libs.Jetpack.compose}")
    implementation ("androidx.compose.ui:ui:${Libs.Jetpack.compose}")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:${Libs.Jetpack.compose}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation ("androidx.compose.foundation:foundation:${Libs.Jetpack.compose}")
    // Material Design
    implementation ("androidx.compose.material:material:${Libs.Jetpack.compose}")
    // Material design icons
    implementation ("androidx.compose.material:material-icons-core:${Libs.Jetpack.compose}")
    implementation ("androidx.compose.material:material-icons-extended:${Libs.Jetpack.compose}")
    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.3.0-alpha03")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:${Libs.Jetpack.composeLifecycle}")
    // Integration with observables
    implementation ("androidx.compose.runtime:runtime-livedata:${Libs.Jetpack.compose}")
    implementation ("androidx.compose.runtime:runtime-rxjava2:${Libs.Jetpack.compose}")

    // UI Tests
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${Libs.Jetpack.compose}")
}

project.afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                artifactId = "presentation"
                from(components["release"])
            }
        }
    }

}

//apply("../config/artifact-deploy.gradle")