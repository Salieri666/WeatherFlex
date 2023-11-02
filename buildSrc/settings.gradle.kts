dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencyResolutionManagement {
        versionCatalogs {
            create("libs") {
                from(files("/libs.toml"))
            }
        }
    }
}
