import org.gradle.api.JavaVersion

object Build {
    const val COMPILE_SDK: Int = 34
    const val MIN_SDK: Int = 26
    const val TARGET_SDK: Int = 34

    val SOURCE_COMPATIBILITY: JavaVersion = JavaVersion.VERSION_17
    val TARGET_COMPATIBILITY: JavaVersion = JavaVersion.VERSION_17
    val JVM_TARGET: String = JavaVersion.VERSION_17.toString()
}