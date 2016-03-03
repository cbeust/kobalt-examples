import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.apt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.android.*
import com.beust.kobalt.plugin.java.*

//val pl = plugins("com.beust:kobalt-android:0.43")
val pl = plugins(file(homeDir("kotlin/kobalt-android/kobaltBuild/libs/kobalt-android-0.44.jar")))

val p = project {

    name = "kobalt.helloworld"
    group = "com.example"
    artifactId = name
    version = "0.1"

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
        compile("com.android.support:appcompat-v7:23.0.1"
                ,"com.android.support:design:23.0.1"
        )
    }

    javaCompiler {
        args("-source", "1.6", "-target", "1.6")
    }
}
