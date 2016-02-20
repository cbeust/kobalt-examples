import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.packaging.assemble

val p = project {

    name = "kobalt-flavors"
    group = "com.example"
    artifactId = name
    version = "0.1"

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
