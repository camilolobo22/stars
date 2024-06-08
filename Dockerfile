FROM openjdk:17
COPY "./target/Stars-1.jar" "app.jar"
EXPOSE 8129
ENTRYPOINT [ "java", "-jar", "app.jar" ]