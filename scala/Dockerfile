FROM openjdk:8-jre-alpine

ADD target/scala-2.11/boot.jar /
RUN set -x \
  && apk add --update \
      curl \
  && rm -rf /var/cache/apk/*

EXPOSE 9001
CMD ["/bin/sh", "-c", "java -jar boot.jar"]
