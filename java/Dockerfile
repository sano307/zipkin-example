FROM tomcat:7.0.90-jre8-alpine
LABEL maintainer "sano307"

# Remove cache
RUN rm -rf /usr/local/tomcat/conf/Catalina/localhost/ROOT.xml /usr/local/tomcat/webapps/ROOT \
  && mkdir /usr/local/tomcat/webapps/ROOT

# Deploy
ADD build/libs/ROOT.war /usr/local/tomcat/webapps/
RUN unzip -d /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
