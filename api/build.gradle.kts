plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springdoc:springdoc-openapi-webflux-core:${Version.SWAGGER}")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:${Version.SWAGGER}")
    runtimeOnly("org.springdoc:springdoc-openapi-kotlin:${Version.SWAGGER}")
}