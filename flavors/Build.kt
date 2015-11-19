import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.kotlin.*

val p = kotlinProject {

    name = "flavors"
    group = "com.beust.kobalt.example"
    artifactId = name
    version = "0.1"

    assemble {
        jar {
            fatJar = true
        }
    }

    application {
        mainClass = "com.beust.kobalt.example.flavors.MainFlavorKt"
    }

    productFlavor("free") {
        description = "the free flavor"
    }

    productFlavor("pro") {
        description = "the pro flavor"
    }

    buildType("debug") {
    }

    buildType("release") {
    }
}
