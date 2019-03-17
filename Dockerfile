FROM openjdk:8
ADD target/healtcheck-ci-cd.jar healtcheck-ci-cd.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "healtcheck-ci-cd.jar"]