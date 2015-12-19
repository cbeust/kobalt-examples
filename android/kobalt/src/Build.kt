import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.android.android
import com.beust.kobalt.plugin.java.*

val r = repos(file("/Users/beust/adt-bundle-mac-x86_64-20140702/sdk/extras/android/m2repository"))

val p = javaProject {

    name = "codepath.apps.demointroandroid"
    group = "com.example"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("app/src/main/java/")
    }

    android {
        compileSdkVersion = "17"
        buildToolsVersion = "21.1.2"
        applicationId = "codepath.apps.demointroandroid"
    }

    dependencies {
        compile(file("app/libs/android-async-http-1.4.3.jar"),
                "com.android.support:support-v4:aar:21.0.3")
    }

    dependenciesTest {
//        compile("org.testng:testng:6.9.5")

    }
}
