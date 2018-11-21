import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    idea
    java
    kotlin("jvm") version "1.3.0"
}

group = "org.hedbor.evan"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "org.hedbor.evan.dndgen.DndGenAppKt"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("no.tornado:tornadofx:1.7.17")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}