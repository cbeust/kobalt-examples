import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.android.*
import com.beust.kobalt.plugin.java.*

val pl = plugins(
    "com.beust:kobalt-android:0.43"
//    file(homeDir("kotlin/kobalt-android/kobaltBuild/libs/kobalt-android-0.43.jar"))
    )

val p = project {

    name = "codepath.apps.demointroandroid"
    group = "com.example"
    artifactId = name
    version = "0.1"
    directory = "app"

    android {
        compileSdkVersion = "17"
        buildToolsVersion = "21.1.2"
        applicationId = "codepath.apps.demointroandroid"
    }

    dependencies {
<<<<<<< HEAD
        compile(file("libs/android-async-http-1.4.3.jar"),
=======
        compile(file("app/libs/android-async-http-1.4.3.jar"),
>>>>>>> Update.
                "com.android.support:support-v4:21.0.3")
    }

    dependenciesTest {
//        compile("org.testng:testng:6.9.5")

    }
}
