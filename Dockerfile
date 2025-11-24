FROM amazoncorretto:17
COPY ./target/SET08803-Coursework-Group-15---FINAL-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SET08803-Coursework-Group-15---FINAL-1.0-SNAPSHOT-jar-with-dependencies.jar"]


