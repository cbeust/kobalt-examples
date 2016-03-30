import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.android.*
import com.beust.kobalt.plugin.java.*

val pl = plugins(
    "com.beust:kobalt-android:0.50"
//    file(homeDir("kotlin/kobalt-android/kobaltBuild/libs/kobalt-android-0.50.jar"))
    )

val p = project {

    name = "codepath.apps.demointroandroid"
    group = "com.example"
    artifactId = name
    version = "0.1"

    android {
        compileSdkVersion = "17"
        buildToolsVersion = "21.1.2"
        applicationId = "codepath.apps.demointroandroid"
    }

    dependencies {
        compile(file("libs/android-async-http-1.4.3.jar"),
                "com.android.support:support-v4:aar:21.0.3")
    }

    assemble {
    }
}
