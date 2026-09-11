// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        config.setFrom(file("config/detekt/detekt.yml"))
        buildUponDefaultConfig = false
        allRules = false
        enableCompilerPlugin.set(true)
    }

    ktlint {
        android.set(true)
        outputColorName.set("RED")
    }
}
