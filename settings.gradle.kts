dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("buildSrc/libs.toml"))
        }
    }
}


rootProject.name = "Weather Flex"
include(
    ":app",
    ":core",
    ":ui-kit",
    ":start-display:start-display",
    ":start-display:start-display-api",
    ":start-display:start-display-impl",
    ":start-display:start-display-provider"
)
