plugins {
    java //add support for Java
    //apply the application plugin to add support for building a CLI application
    //you can run your app via task "run": ./gradlew run
    application
    //adds task 'shadowJar' to export a runnable jar
    //the runnable jar will be found in build/libs/projectname-all.jar
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
    mavenCentral()
    mavenLocal()

    flatDir {
        dirs 'libs'
    }
    maven { url 'http://download.crashlytics.com/maven' }
}

val javaFXModules = listOf("base", "controls", "fxml", "swing", "graphics")
val supportedPlatforms = listOf("linux", "mac", "win") //all required for OOP
val javaFXVersion = 18

dependencies {
    for (platform in supportedPlatforms) {
        for (module in javaFxModules) {
            implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
        }
    }
    //JUnit API and testing engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    compile 'com.yourgroup:retrofit:1.9.0-custom'
    compile 'com.squareup.retrofit:retrofit:1.9.0'
}

tasks.withType<Test> {
    useJUnitPlatform()
} //enables JUnit5 Jupiter module

application {
    mainClassName = "main.java.engine.Launcher"
}