import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.apt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.android.android
import com.beust.kobalt.plugin.java.*

val p = javaProject {

    name = "codepath.apps.demointroandroid"
    group = "com.example"
    artifactId = name
    version = "0.1"

    android {
        compileSdkVersion = "23"
        buildToolsVersion = "23.0.1"
        applicationId = "codepath.demos.helloworlddemo"
    }

    productFlavor("pro") {
    }

    productFlavor("free") {
    }

    buildType("debug") {
    }

    buildType("release") {
    }

    dependencies {
    }
}
