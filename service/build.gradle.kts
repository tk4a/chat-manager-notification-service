plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${Version.SPRING_CLOUD}"))
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-config-client")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.postgresql:r2dbc-postgresql")
    implementation("org.liquibase:liquibase-core:${Version.LIQUIBASE}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")

//    implementation("org.springdoc:springdoc-openapi-webflux-core:${Version.SWAGGER}")
//    implementation("org.springdoc:springdoc-openapi-webflux-ui:${Version.SWAGGER}")
//    runtimeOnly("org.springdoc:springdoc-openapi-kotlin:${Version.SWAGGER}")
    implementation("io.springfox:springfox-spring-webflux:3.0.0-SNAPSHOT")
    implementation("io.springfox:springfox-swagger-ui:3.0.0-SNAPSHOT")
    implementation("io.springfox:springfox-swagger2:3.0.0-SNAPSHOT")
    implementation(project(":api"))
}
