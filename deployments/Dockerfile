FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD Spring_Project.jar api.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]