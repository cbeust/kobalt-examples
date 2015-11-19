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

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0-beta-2423",
                "org.jetbrains.kotlin:kotlin-compiler-embeddable:1.0.0-beta-2423")
    }

    assemble {
        jar {
            fatJar = true
        }
    }

    application {
        mainClass = "com.beust.kobalt.example.variants.MainKt"
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
