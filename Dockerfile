FROM gradle:6.0-jdk11
EXPOSE 8080
COPY . /app
WORKDIR /app
CMD ./gradlew build ; ./gradlew bootRun
