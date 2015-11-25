import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.apt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.android.android
import com.beust.kobalt.plugin.java.*

val p = javaProject {

    name = "kobalt.helloworld"
    group = "com.example"
    artifactId = name
    version = "0.1"

    android {
        compileSdkVersion = "23"
        buildToolsVersion = "23.0.1"
        applicationId = "com.beust.kobalt.android.helloworld"
    }

    productFlavor("free") {
        buildConfig {
            field("freeField", "String", "\"The free field\"")
            field("conflictProductFlavor", "String", "\"Defined by free\"")
        }
    }

    productFlavor("pro") {
        buildConfig {
            field("proField", "String", "\"The pro field\"")
            field("conflictProductFlavor", "String", "\"Defined by pro\"")
        }
    }

    buildType("debug") {
        buildConfig {
            field("debugField", "String", "\"The debug field\"")
            field("conflictBuildType", "String", "\"Defined by debug\"")
        }
    }

    buildType("release") {
        buildConfig {
            field("releaseField", "String", "\"The release field\"")
            field("conflictBuildType", "String", "\"Defined by release\"")
        }
    }

    dependencies {
    }
}
