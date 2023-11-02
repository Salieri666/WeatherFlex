dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("buildSrc/libs.toml"))
        }
    }
}


rootProject.name = "Weather Flex"
include(":app")
