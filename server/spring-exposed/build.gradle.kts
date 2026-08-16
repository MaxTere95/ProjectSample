plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "ru.maxtere.sampleserver.spring.exposed"
version = "1.0.0"

dependencies {
    implementation(projects.shared.server.springExposed)
}

// Добавили стратегию исключения дубликатов при упаковке архива
tasks.withType<Tar> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }
tasks.withType<Zip> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("ru.maxtere.sampleserver.spring.exposed.ApplicationKt")

    // Переопределяем стратегию дубликатов для самой таски BootJar
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}