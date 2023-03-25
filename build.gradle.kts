plugins {
    java
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.liquibase.gradle") version "2.0.4"
}

group = "com.epam.mentoring.migration"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mapstructVersion = "1.5.2.Final"
val liquibaseCoreVersion = "4.20.0"

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    implementation("org.flywaydb:flyway-core")
    implementation("org.liquibase:liquibase-core:${liquibaseCoreVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    liquibaseRuntime("org.liquibase:liquibase-core:${liquibaseCoreVersion}")
    liquibaseRuntime("org.postgresql:postgresql")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

liquibase {
    activities.register("main") {
        this.arguments = mapOf(
            "logLevel" to "info",
            "changeLogFile" to "src/main/resources/db/changelog/db.changelog-master.yaml",
            "url" to "jdbc:postgresql://localhost:5432/recruitment_app",
            "username" to "recruiter",
            "password" to "recruiter123"
        )
    }
    runList = "main"
}

