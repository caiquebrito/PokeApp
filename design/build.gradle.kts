import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.caiquebrito.design"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompilerExtension.get()
    }

    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }

    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        abortOnError = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.javaVersion.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.javaVersion.get())
    }

    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(libs.versions.javaTarget.get()))
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
}

dependencies {
    implementation(project(":data"))
    implementation(project(":data-local"))
    implementation(project(":data-remote"))
    implementation(project(":domain"))
    implementation(project(":presentation"))
    implementation(libs.androidx.foundation)

    with(libs) {
        with(androidx) {
            implementation(core.ktx)
            implementation(appcompat)
            androidTestImplementation(junit)
            androidTestImplementation(espresso.core)
            with(compose) {
                implementation(ui)
                implementation(animation)
                implementation(material)
                implementation(foundation)
                implementation(runtime)
            }
        }
        implementation(material)
        testImplementation(junit)
    }
}