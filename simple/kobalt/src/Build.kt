
import com.beust.kobalt.plugin.application.application
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project
import com.beust.kobalt.test

val p = project {

    name = "simple"
    group = "com.beust.kobalt.example"
    artifactId = name
    version = "0.1"

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.beust.kobalt.example.simple.Main"
    }

    dependenciesTest {
        compile("org.testng:testng:6.9.9")
    }

    test {
        args("-excludegroups", "broken", "src/test/resources/testng.xml")
    }

    test {
        name = "All"
        args("src/test/resources/testng.xml")
    }

}
