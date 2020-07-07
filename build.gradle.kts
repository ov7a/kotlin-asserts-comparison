plugins {
    kotlin("jvm") version "1.3.72"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.assertj", "assertj-core", "3.16.1")
    testImplementation("io.kotest", "kotest-assertions-core-jvm", "4.1.1")
    testImplementation("io.kotest", "kotest-assertions-core", "4.1.1")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("io.strikt:strikt-core:0.26.1")
    testImplementation("org.amshove.kluent:kluent:1.61")

    testImplementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("reflect"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
}

tasks {
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}