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
    testImplementation("org.assertj:assertj-core:3.16.1")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.2.0")
    testImplementation("io.kotest:kotest-assertions-core:4.2.0")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("io.strikt:strikt-core:0.26.1")
    testImplementation("org.amshove.kluent:kluent:1.61")
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:0.12.0")
    testImplementation("com.winterbe:expekt:0.5.0")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.22")
    testImplementation("com.natpryce:hamkrest:1.7.0.3")

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