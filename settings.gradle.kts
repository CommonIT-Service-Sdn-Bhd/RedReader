pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	}
}

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	}
}

include(":androidApp")
include(":shared")

include(":redreader-common")
project(":redreader-common").projectDir = File("./libs/redreader-common")

include(":redreader-datamodel")
project(":redreader-datamodel").projectDir = File("./libs/redreader-datamodel")
