FROM eclipse-temurin:17

USER root

WORKDIR /app

COPY . .

RUN sed -i 's/\r$//' mvnw

RUN ./mvnw clean package -DskipTests

RUN cp target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]