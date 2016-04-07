import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.android.*
import com.beust.kobalt.plugin.java.*

val pl = plugins(
    "com.beust:kobalt-android:0.63"
//    file(homeDir("kotlin/kobalt-android/kobaltBuild/libs/kobalt-android-0.63.jar"))
    )

/**
 * A simple Android project.
 */
val javaAndroid = project {

    name = "simpleJavaAndroid"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    android {
        compileSdkVersion = "17"
        buildToolsVersion = "23.0.1"
        applicationId = "com.sample"
    }
}

/**
 * An advanced Java Android project.
 */
val kotlinAndroid = project {

    name = "advancedJavaAndroid"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    android {
        compileSdkVersion = "17"
        buildToolsVersion = "21.1.2"
        applicationId = "codepath.apps.demointroandroid"
    }

    dependencies {
        compile(file("libs/android-async-http-1.4.3.jar"),
                "com.android.support:support-v4:aar:21.0.3")
    }

    assemble {
    }
}

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
        compileSdkVersion = "23"
        buildToolsVersion = "23.0.1"
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
        compile("com.android.support:appcompat-v7:aar:23.0.1"
                ,"com.android.support:design:aar:23.0.1"
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
