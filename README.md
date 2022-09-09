# Quokka Gateway

![Tests passed](https://github.com/UST-QuAntiL/Quokka/actions/workflows/test.yml/badge.svg)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This project provides a Gateway to connect to all Quokka services via a single API.
Hence, it unites services for quantum circuit generation, circuit execution, error mitigation, measurement result evaluation, and parameter optimization in a single API endpoint.
It is built upon the [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway) to intercept and forward requests coming from outside the network.

## Run with Docker
The easiest way to get start is using a pre-built Docker image:

``docker run -p 6474:6474 planqk/quokka``


Alternatively, the Docker container can be built manually:
1. Clone the repository using ``git clone https://github.com/UST-QuAntiL/Quokka.git``
2. Navigate to the repository  ``cd Quokka``
3. Build the Docker container: ``docker build -t quokka:0.1 .``
4. Run the Docker container: ``docker run -p 6474:6474 quokka:0.1``

The Gateway can be accessed via: [http://127.0.0.1:6474](http://127.0.0.1:6474).



## Usage

This gateway routes requests following the schema ``/quokka/*`` to the corresponding services configured in ``application.yaml`` or the Dockerfile.
The Gateway's default port is `6474`.
The request schemas of the individual services have to be used. They can be found in their respective documentations.

### Gateways

Currently, the following gateways are implemented:
* quokka/error-mitigation --> [Error Mitigation Service](https://github.com/UST-QuAntiL/error-mitigation-service) at ``hostname:5071\``
* quokka/objective-function --> [Objective Function Service](https://github.com/UST-QuAntiL/objective-function-service) at ``hostname:5072\``
* quokka/circuit-generator --> [Circuit Generator](https://github.com/UST-QuAntiL/quantum-circuit-generator) at ``hostname:5073\``
* quokka/optimization --> [TODO](https://github.com/UST-QuAntiL/error-mitigation-service) at ``hostname:5074\``
* quokka/circuit-executor --> [TODO](https://github.com/UST-QuAntiL/error-mitigation-service) at ``hostname:5075\``


## Developer Guide

## Building the application locally
The Gateway can be built using Maven.

1. Run `mvn package -DskipTests` inside the root folder using [OpenJdk 17](https://openjdk.java.net/projects/jdk/17/) or above.
2. Once finished, the generated .jar file can be found in the `target` folder.
3. To execute it navigate to the `target` folder and run: `java -jar gateway-0.0.1-SNAPSHOT.jar`


### Disclaimer of Warranty
Unless required by applicable law or agreed to in writing, Licensor provides the Work (and each Contributor provides its Contributions) on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.

### Haftungsausschluss
Dies ist ein Forschungsprototyp. Die Haftung für entgangenen Gewinn, Produktionsausfall, Betriebsunterbrechung, entgangene Nutzungen, Verlust von Daten und Informationen, Finanzierungsaufwendungen sowie sonstige Vermögens- und Folgeschäden ist, außer in Fällen von grober Fahrlässigkeit, Vorsatz und Personenschäden, ausgeschlossen.
