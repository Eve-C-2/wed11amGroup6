FROM amazoncorretto:17
COPY ./target/sem-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "sem-jar-with-dependencies.jar", "db:3306", "30000"]