import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.android.*
import com.beust.kobalt.plugin.java.*

val pl = plugins(
    "com.beust:kobalt-android:0.91"
//    file(homeDir("kotlin/kobalt-android/kobaltBuild/libs/kobalt-android-0.91.jar"))
)

object Versions {
    val compileSdk = "23"
    val supportV4 = "23.0.1"
    val buildTools = "23.0.1"
    val appCompat = "23.0.1"
    val appCompatV7 = "23.0.1"
    val design = "23.0.1"
}

/**
 * A simple Android project.
 */
val androidJavaSimple = project {

    name = "androidJavaSimple"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    android {
        compileSdkVersion = Versions.compileSdk
        buildToolsVersion = Versions.buildTools
        applicationId = "com.sample"
    }
}

/**
 * An advanced Java Android project.
 */
/*
val androidJavaAdvanced = project {

    name = "androidJavaAdvanced"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    android {
        compileSdkVersion = "23"
        buildToolsVersion = "23.0.1"
        applicationId = "codepath.apps.demointroandroid"
    }

    dependencies {
        compile(file("libs/android-async-http-1.4.3.jar"))
    }

    assemble {
    }
}
*/

/**
 * An Android project defining build types and project flavors.
 */
val androidFlavors = project {

    name = "androidFlavors"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    android {
        compileSdkVersion = Versions.compileSdk
        buildToolsVersion = Versions.buildTools
        applicationId = "com.beust.kobalt.android.helloworld"

//        signingConfig("release") {
//            storeFile = homeDir(".android", "debug.keystore")
//            storePassword = "android"
//            keyAlias = "androiddebugkey"
//            keyPassword = "android"
//        }
    }

    productFlavor("free") {
        buildConfig {
            field("String", "freeField", "\"The free field\"")
        }
    }

    productFlavor("pro") {
        buildConfig {
            field("String", "proField", "\"The pro field\"")
        }
    }

    buildType("debug") {
        buildConfig {
            field("String", "debugField", "\"The debug field\"")
        }
    }

    buildType("release") {
        minifyEnabled = true
//        proguardFile = getDefaultProguardFile("proguard-android.txt")

        buildConfig {
            field("String", "releaseField", "\"The release field\"")
        }
    }

    dependencies {
        compile("com.android.support:appcompat-v7:aar:${Versions.appCompatV7}"
                ,"com.android.support:design:aar:${Versions.design}"
        )
    }

    javaCompiler {
        args("-source", "1.6", "-target", "1.6")
    }
}

/**
 * A project with flavors.
 */
val flavors = project {

    name = "flavors"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    productFlavor("free") {
    }

    productFlavor("pro") {
    }

    assemble {
        jar {
            fatJar = true
            manifest {
                attributes("Main-Class", "com.example.MainKt")
            }
        }
    }
}

/**
 * A project with Java and Kotlin source files.
 */
val mixed = project {
    name = "mixed"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    dependencies {
        compile("joda-time:joda-time:2.9.1")
    }

    assemble {
        jar {
        }
    }
}

/**
 * Creating a war file
 */
 /*
val webService = project {

    name = "webservice"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    dependencies {
        compile("javax:javaee-api:7.0",
            "javax.servlet:javax.servlet-api:3.1.0")
    }

    assemble {
        war {
        }
    }
}
*/

