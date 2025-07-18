plugins {
    java
}

repositories {
    mavenCentral() // Используем Maven Central для зависимостей
}

dependencies {
    // Пример добавления зависимостей (JUnit 5 для тестов)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

// Настройка кодировки для компиляции и запуска
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8" // Кодировка исходников
}

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8") // Кодировка для тестов
    useJUnitPlatform() // Используем JUnit 5
}

tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8") // Кодировка при запуске main()
}