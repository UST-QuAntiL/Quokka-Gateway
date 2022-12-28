FROM maven:3-openjdk-17 as builder

COPY . /tmp/gateway
WORKDIR /tmp/gateway
RUN mvn package -B -DskipTests

FROM openjdk:17-buster
LABEL maintainer = "Martin Beisel <martin.beisel@iaas.uni-stuttgart.de>"

ARG DOCKERIZE_VERSION=v0.6.1

ENV PORT 6474
ENV LOGGING_LEVEL INFO

ENV ERROR_MITIGATION_SERVICE_URI http://host.docker.internal:5071
ENV OBJECTIVE_EVALUATION_SERVICE_URI http://host.docker.internal:5072
ENV QUANTUM_CIRCUIT_GENERATION_URI http://host.docker.internal:5073
ENV OPTIMIZATION_SERVICE_URI http://host.docker.internal:5074
ENV CIRCUIT_EXECUTION_SERVICE_URI http://host.docker.internal:5075
ENV CIRCUIT_CUTTING_SERVICE_URI http://host.docker.internal:5076
ENV WARM_STARTING_SERVICE_URI http://host.docker.internal:5077


COPY --from=builder /tmp/gateway/target/gateway-0.0.1-SNAPSHOT.jar /var/gateway/gateway.jar
COPY .docker /var/.docker

RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

EXPOSE 6474

CMD dockerize -template /var/.docker/application.yaml.tpl:/var/gateway/application.yaml \
    java -jar /var/gateway/gateway.jar
