# Spring Boot Application Template

## Purpose
The purpose of this template is to speed up the creation of new Spring applications. Also it will be used to practice the Spring Tech stack in our Tech Session. 

## What's inside

The template is a working application with a minimal setup. It contains:
* application skeleton
* common libraries

The application exposes health endpoint (http://localhost:8080/).

## Plugins

The template contains the following plugins:

* checkstyle

  https://docs.gradle.org/current/userguide/checkstyle_plugin.html

  Performs code style checks on Java source files using Checkstyle and generates reports from these checks.
  The checks are included in gradle's *check* task (you can run them by executing `./gradlew check` command).

* org.springframework.boot

  http://projects.spring.io/spring-boot/

  Reduces the amount of work needed to create a Spring application

* org.springframework.boot

  http://projects.spring.io/spring-boot/

  Reduces the amount of work needed to create a Spring application

* org.springframework.boot.data.rest

  https://spring.io/projects/spring-data-rest

  Spring Data REST is part of the umbrella Spring Data project and makes it easy to build hypermedia-driven REST web services on top of Spring Data repositories.

* org.mockito

  https://site.mockito.org/

* org.junit.jupiter

  https://junit.org/junit5/

### Building the application

The project uses [Gradle](https://gradle.org) as a build tool. It already contains
`./gradlew` wrapper script, so there's no need to install gradle.

To build the project execute the following command:

```bash
  ./gradlew build
```

### Running the application

```bash
  ./gradlew bootRun
```
