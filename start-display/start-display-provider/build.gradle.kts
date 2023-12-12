plugins {
    id("feature-convention")
}

android {
    namespace = "com.samara.start_display_provider"
}

dependencies {

    implementation(project(Deps.Project.startDisplayApi))
    implementation(project(Deps.Project.startDisplayImpl))

}