FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean install -DskipTests

EXPOSE 8001

CMD ["java", "-jar", "target/contactservice-0.0.1-SNAPSHOT.jar"]