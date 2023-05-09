plugins {}

version = "0.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")

    implementation(project(":domain"))
    implementation(project(":kafka"))

    testImplementation("io.mockk:mockk:1.10.6")
    runtimeOnly("com.h2database:h2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}