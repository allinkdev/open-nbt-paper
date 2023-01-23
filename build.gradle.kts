plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
    id("io.papermc.paperweight.userdev") version "1.4.0"

}

group = "me.allinkdev"
version = "1.19.3+0.0.1"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven("https://repo.opencollab.dev/maven-snapshots/")
}

dependencies {
    api("com.github.steveice10:opennbt:1.5-SNAPSHOT")
    paperDevBundle("1.19.3-R0.1-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.release.set(17)
    }

    test {
        useJUnitPlatform()
    }
}

publishing {
    publications {
        create<MavenPublication>("library") {
            artifact(tasks.reobfJar)
        }
    }
    repositories {
        mavenLocal()
    }
}