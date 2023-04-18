plugins {
    kotlin("jvm") version Version.KOTLIN
    kotlin("plugin.spring") version Version.KOTLIN apply false
    id("org.springframework.boot") version Version.SPRING_BOOT apply false
    id("io.spring.dependency-management") version Version.SPRING_DEPENDENCY apply false
    id("org.springdoc.openapi-gradle-plugin") version Version.OPEN_API_PLUGIN apply false
}

repositories {
    mavenCentral()
}

subprojects {
    group = GROUP_NAME
    version = VERSION

    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(kotlin("stdlib"))
}