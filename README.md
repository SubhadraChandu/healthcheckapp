DockerCI for simple /healthcheck endpoint

Problem Create a simple application which has a single "/healthcheck" endpoint. Containerise your application as a single deployable artifact, encapsulating all dependencies. Create a CI pipeline for your application

Solution I have used spring boot to build this application.

In order to dockerize the environment i have written Dockerfile for the server. I built the image from the Dockerfile and Containerized the build image.

Used Maven as a build tool to create a single deployable artifact which includes all dependencies.

Used Jenkins to create CI Pipeline which includes Junit to impement unit test cases.

Once the application is build and running suucssfully on the server, it will give below output. -details: { "version": "0.0.1-SNAPSHOT", //(dynamic value, picks the version from pom.xml) "description" : "pre-interview technical test", //(static value) "lastcommitsha": "ba9633c2e1e90a450a47fc2af2e" //(dynamic value, will change whenever there is new commit) }

Conclusion In this repository I demonstrated a /healthcheck endpoint on a server implemented in Spring boot, and a docker container
