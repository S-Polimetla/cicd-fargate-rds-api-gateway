FROM openjdk:11
ADD target/employee-ecs-springboot.jar employee-ecs-springboot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employee-ecs-springboot.jar"]