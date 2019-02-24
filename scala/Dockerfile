FROM openjdk:8-jre-alpine
LABEL maintainer "sano307"

# Install package & Remove cache
RUN set -x \
  && apk add --update \
      curl \
  && rm -rf /var/cache/apk/*

# Deploy
ADD target/scala-2.11/boot.jar /

EXPOSE 9001
CMD ["/bin/sh", "-c", "java -jar boot.jar"]
