FROM openjdk:8-jdk
ADD target/springboot-mysql.jar springboot-mysql.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","springboot-mysql.jar"]