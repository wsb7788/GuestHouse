package extention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.getVersionCatalog(name: String = "libs") = extensions.getByType(VersionCatalogsExtension::class).named(name)

internal val Project.applicationExtension: CommonExtension<*, *, *, *, *>
    get() = extensions.getByType<ApplicationExtension>()

internal val Project.libraryExtension: CommonExtension<*, *, *, *, *>
    get() = extensions.getByType<LibraryExtension>()

internal val Project.androidExtension: CommonExtension<*, *, *, *, *>
    get() = runCatching { libraryExtension }
        .recoverCatching { applicationExtension }
        .onFailure { println("Could not find Library or Application extension from this project") }
        .getOrThrow()

internal fun Project.getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}