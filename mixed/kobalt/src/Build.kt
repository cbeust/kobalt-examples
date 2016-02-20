import com.beust.kobalt.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.kotlin.*
import com.beust.kobalt.plugin.java.*

val jp = project {
    name = "mixed-java"
    group = "com.beust.kobalt.mixed"
    artifactId = name
    version = "0.1"
    buildDirectory = "javaBuild"

    dependencies {
        compile("joda-time:joda-time:2.9.1")
    }

    assemble {
        jar {
        }
    }
}

val kp = project(jp) {
    name = "mixed-kotlin"
    group = "com.beust.kobalt.mixed"
    artifactId = name
    version = "0.1"

    assemble {
        jar {}
    }

    application {
        mainClass = "com.beust.kobalt.example.mixed.MainKt"
    }
}
