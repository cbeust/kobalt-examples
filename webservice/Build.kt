import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.kotlin.*

val repos = repos()

val p = project {

    name = "webservice"
    group = "com.example"
    artifactId = name
    version = "0.1"

    sourceDirectories {
            path("src/main/kotlin")
    }

    dependencies {
        compile("javax:javaee-api:7.0")
        compile("javax.servlet:javax.servlet-api:3.1.0")
    }

    assemble {
        war {
        }
    }
}
