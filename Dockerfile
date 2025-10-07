FROM openjdk:latest
COPY ./target/seMethods-release0.1.0.2-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-release0.1.0.2-SNAPSHOT-jar-with-dependencies.jar"]