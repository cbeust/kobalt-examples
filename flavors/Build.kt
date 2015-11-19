import com.beust.kobalt.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.kotlin.*

val p = kotlinProject {

    name = "flavors"
    group = "com.beust.kobalt.example"
    artifactId = name
    version = "0.1"

    assemble {
        jar {}
    }

    application {
        mainClass = "com.beust.kobalt.example.flavors.MainFlavorKt"
    }
}
