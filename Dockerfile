FROM openjdk:19
EXPOSE 8080
ADD target/rps.jar rps.jar
ENTRYPOINT ["java","-jar","/rps.jar"]