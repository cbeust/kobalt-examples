import com.beust.kobalt.*
import com.beust.kobalt.api.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.apt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.java.*

object Versions {
    val design = "23.0.1"
    val lwjgl = "2.9.3"
}

/**
 * A project with flavors.
 */
val flavors = project {

    name = "flavors"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    productFlavor("free") {
    }

    productFlavor("pro") {
    }

    application {
        mainClass = "com.example.MainKt"
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

/**
 * A project with Java and Kotlin source files.
 */
val mixed = project {
    name = "mixed"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    dependencies {
        compile("joda-time:joda-time:2.9.1")
    }

    assemble {
        jar {
        }
    }
}

/**
 * Creating a war file
 */
 /*
val webService = project {

    name = "webservice"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = name

    dependencies {
        compile("javax:javaee-api:7.0",
            "javax.servlet:javax.servlet-api:3.1.0")
    }

    assemble {
        war {
        }
    }
}
*/

/**
 * Annotation processor and example in Java. Run it with "./kobaltw aptSample:run".
 */
val annotationProcessor = project {
    name = "aptProcessor"
    version = "0.1"
    directory = "apt/$name"

    dependencies {
        compile("com.squareup:javapoet:1.7.0")
    }

    assemble {
        jar {
        }
    }
}

val annotationProcessorExample = project(annotationProcessor) {
    name = "aptSample"
    version = "0.1"
    directory = "apt/$name"

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.Main"
    }
}


/**
 * Annotation processor and example in Kotlin. Run it with "./kobaltw aptSampleKotlin:run".
 */

/** WORK IN PROGRESS

val annotationProcessorKotlin = project {
    name = "aptProcessorKotlin"
    version = "0.1"
    directory = "aptKotlin/$name"

    dependencies {
        compile("com.squareup:javapoet:1.7.0")
    }

    assemble {
        jar {
        }
    }
}

val annotationProcessorExampleKotlin = project(annotationProcessor) {
    name = "aptSampleKotlin"
    version = "0.1"
    directory = "aptKotlin/$name"

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.Main"
    }
}
*/

/**
 * Using native libraries
 */
val rubik = project {
    name = "rubik"
    group = "com.beust"
    artifactId = name
    version = "0.0.1"
    directory = name

    dependencies {
        compile("org.lwjgl.lwjgl:lwjgl:${Versions.lwjgl}",
                "org.lwjgl.lwjgl:lwjgl_util:${Versions.lwjgl}")

        native("org.lwjgl.lwjgl:lwjgl-platform:jar:natives-windows:${Versions.lwjgl}",
                "org.lwjgl.lwjgl:lwjgl-platform:jar:natives-linux:${Versions.lwjgl}",
                "org.lwjgl.lwjgl:lwjgl-platform:jar:natives-osx:${Versions.lwjgl}"
        )
    }

    val MAIN_CLASS = "com.oskar.rubik.Main"

    assemble {
        jar {
            manifest {
                attributes("Main-Class", MAIN_CLASS)
            }
        }
    }

    application {
        mainClass = MAIN_CLASS
    }
}
