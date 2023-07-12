FROM openjdk:19-slim-bullseye
RUN mkdir -p /opt/TDengineInsight/{data,bin}
COPY build/libs/TDengineInsight-*.jar /opt/TDengineInsight/bin/main.jar
WORKDIR /opt/TDengineInsight

ENV SQLITE_DATA_DIR=/opt/TDengineInsight/data
ENV DOC_ENABLED=false

CMD ["java", "-jar", "/opt/TDengineInsight/bin/main.jar"]
