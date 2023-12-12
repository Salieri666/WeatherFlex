plugins {
    id("feature-convention")
}

android {
    namespace = "com.samara.start_display"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Versions.composeVersion
    }
}

dependencies {

    implementation(project(Deps.Project.uikit))
    implementation(project(Deps.Project.core))
    implementation(project(Deps.Project.startDisplayApi))
    implementation(project(Deps.Project.startDisplayProvider))

    implementation(libs.coreKtx)
    implementation(libs.kotlinCoroutines)

    implementation(libs.bundles.android)

    implementation(platform(libs.composeBom))
    implementation(libs.bundles.compose)

    androidTestImplementation(platform(libs.composeBom))
    androidTestImplementation(libs.uiTestJunit)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)

    //dagger
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
}