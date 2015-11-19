import com.beust.kobalt.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.java.*

val p = javaProject {

    name = "simple"
    group = "com.beust.kobalt.example"
    artifactId = name
    version = "0.1"

    assemble {
        jar {}
    }

    application {
        mainClass = "com.beust.kobalt.example.simple.ExampleMain"
    }
}
