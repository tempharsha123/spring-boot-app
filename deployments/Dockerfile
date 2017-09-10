FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD spring-rest-1.0.0.jar app.jar
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]