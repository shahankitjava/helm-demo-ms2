FROM openjdk:8-jre-alpine

WORKDIR /usr/app

COPY ./target/helm-demo-ms2-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT [ "java", "-jar", "helm-demo-ms2-0.0.1-SNAPSHOT.jar" ]