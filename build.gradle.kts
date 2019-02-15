import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

project.apply {
    group = "me.duncte123"
    version = "1.0-SNAPSHOT"
}

plugins {
    id("kotlin2js") version "1.3.21"
}

repositories {
    mavenCentral()
}

dependencies {
    "compile"(kotlin("stdlib-js"))
}

val classes: Task by tasks
val assemble: Task by tasks
val compileKotlin2Js: KotlinJsCompile by tasks

val assembleWeb = task<Sync>("assembleWeb") {
    configurations["compile"].forEach { file: File ->
        from(zipTree(file.absolutePath), {
            includeEmptyDirs = false
            include { fileTreeElement ->
                val path = fileTreeElement.path

                path.endsWith(".js") && (path.startsWith("META-INF/resources/") || !path.startsWith("META-INF/"))
            }
        })
    }

    from(compileKotlin2Js.path)

    into("$projectDir/web")

    dependsOn(classes)
}

assemble.dependsOn(assembleWeb)

compileKotlin2Js.apply {
    kotlinOptions.outputFile = "$projectDir/bot/index.js"
    kotlinOptions.moduleKind = "commonjs"
    kotlinOptions.sourceMap = false
    kotlinOptions.main = "call"
    kotlinOptions.metaInfo = false
}