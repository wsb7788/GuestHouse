package extention

import org.gradle.api.artifacts.VersionCatalog

internal fun VersionCatalog.getPluginId(alias: String) = findPlugin(alias).get().get().pluginId