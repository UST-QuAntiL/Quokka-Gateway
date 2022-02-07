![Tests passed](https://github.com/UST-QuAntiL/Quokka/actions/workflows/test.yml/badge.svg)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Code style: black](https://img.shields.io/badge/code%20style-black-000000.svg)](https://github.com/psf/black)
[![codecov](https://codecov.io/gh/UST-QuAntiL/Quokka/branch/master/graph/badge.svg?token=n37q3cv8Gu)](https://codecov.io/gh/UST-QuAntiL/Quokka)

# Quokka - The quantum API Gateway

Quokka is a API Gateway that manages the communication between a client and multiple services for quantum computing.
It enables [circuit generation](https://github.com/UST-QuAntiL/quantum-circuit-generator), translation, execution and error mitigation.
Further, custom service can easily be integrated and exposed.

## Structure
In the following the structure of the Quokka API is explained.
The full API specification can be found at  ``http://127.0.0.1:5000/api/swagger-ui`` when Quokka is running.

### /circuit-generation
Contains encoding and algorithm circuit fragements.

### /mitigation
Contains error mitigiation capabilities.

## Developer Guide

### Setup (exemplary for ubuntu 18.04): 
* ``git clone https://github.com/UST-QuAntiL/quokka.git`` 
* ``cd quokka``
* ``sudo -H pip install virtualenv`` (if you don't have virtualenv installed)
* ``virtualenv venv`` (create virtualenv named 'venv')
* ``source venv/bin/activate`` (enter virtualenv; in Windows systems activate might be in ``venv/Scripts``)
* ``pip install -r requirements.txt`` (install application requirements)

### Execution:
* Run with: ``flask run``
* Test with: ``flask test``
* Coverage with: ``coverage run --branch --include 'api/*' -m unittest discover; coverage report``

#### Codestyle: 
``black . `` OR ``black FILE|DIRECTORY``

#### Update requirements with: 
``pip freeze>requirements.txt``

### Disclaimer of Warranty
Unless required by applicable law or agreed to in writing, Licensor provides the Work (and each Contributor provides its Contributions) on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.

### Haftungsausschluss
Dies ist ein Forschungsprototyp. Die Haftung für entgangenen Gewinn, Produktionsausfall, Betriebsunterbrechung, entgangene Nutzungen, Verlust von Daten und Informationen, Finanzierungsaufwendungen sowie sonstige Vermögens- und Folgeschäden ist, außer in Fällen von grober Fahrlässigkeit, Vorsatz und Personenschäden, ausgeschlossen.
