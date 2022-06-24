// Top-level build file where you can add configuration options common to all sub-projects/modules.
import java.util.*

val localProperties = File(project.rootDir, "local.properties")
val properties = Properties()
val userAlias = properties["USERNAME"].toString()
val secretKey = properties["PASSWORD"].toString()


buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(BuildClassesConfig.ANDROID_GRADLE_PLUGIN)
        classpath(BuildClassesConfig.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildClassesConfig.HILT_GRADLE_PLUGIN)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            setUrl("https://jitpack.io")
        }
        maven {
            credentials {
                username = AppSecrets.USERNAME
                password = AppSecrets.PASSWORD
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
            setUrl("https://api.bitbucket.org/2.0/repositories/mb28/android-yap-ui-kit/src/releasesLib")
        }

        maven {
            credentials {
                username = AppSecrets.USERNAME
                password = AppSecrets.PASSWORD
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
            setUrl("https://api.bitbucket.org/2.0/repositories/mb28/android-yap-permissions/src/releasesLib")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}