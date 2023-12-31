[![Quality gate](https://duberlyguarnizo.com/sonarqube/api/project_badges/quality_gate?project=Bootcamp-Asset-Operations-Service&token=sqb_601e2c6d6aa3141688ba132dc65e880a67867403)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Asset-Operations-Service)
# Asset Operations

[![Coverage](https://duberlyguarnizo.com/sonarqube/api/project_badges/measure?project=Bootcamp-Asset-Operations-Service&metric=coverage&token=sqb_601e2c6d6aa3141688ba132dc65e880a67867403)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Asset-Operations-Service)
[![Bugs](https://duberlyguarnizo.com/sonarqube/api/project_badges/measure?project=Bootcamp-Asset-Operations-Service&metric=bugs&token=sqb_601e2c6d6aa3141688ba132dc65e880a67867403)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Asset-Operations-Service)
[![Lines of Code](https://duberlyguarnizo.com/sonarqube/api/project_badges/measure?project=Bootcamp-Asset-Operations-Service&metric=ncloc&token=sqb_601e2c6d6aa3141688ba132dc65e880a67867403)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Asset-Operations-Service)

## Microservice for NttData's Bootcamp

This service has three functions: to register loans, credit card expenses, and payments of both.
Each of those operations have the following flow:

- Receive the information of the operation together with a request body.
- Call for the Accounts service to check balances and other information
- Process and save the operation
- Call the transaction service to create a new transaction

```mermaid
flowchart
A[Receive] --> |Gather info from Accounts Service| B[Check with Accounts]
B[Check with Accounts] --> |Validate business rules| C[Process operation]
C[Process operation] --> |Call Transaction Service| D[Save & create Transaction]
```

Stack:

- Spring Boot 2.7
- Java 11
- RxJava 3
- Reactive MongoDb for persistence
- OpenApi Generator, for API design
- Remote configuration (Spring Cloud Config with GitHub)
- Integrated Eureka client
- SonarQube for coverage with SpotBugs (FindBugs) & CheckStyle
- Various DTO

Current endpoints are:

- **POST /assets/card-expenses/{accountId}**: Creates a credit card expense.
- **POST /assets/loans/{accountId}**: Creates a new loan for a client (identified with an account).
- **POST /assets/payments/{accountId}**: Creates a new payment (for credit card or loan accounts).

### Design

The service uses DDD and Hexagonal architectures. The code is organized so that model package does
not depend on
anything. I have used functional programing, streams, lambdas, etc.

### Compile and Deploy

To deploy, simply compile the project and run the generated jar. This service requires:

- That the config server ir running in the same host, with port 8888.
- That there is a Eureka server (Spring Cloud Netflix) running at the same host, port 8761.

### Copyright

All code has been written by me, Duberly Guarnizo <duberlygfr@gmail.com> and the use by external
personal of NttData is
explicitly forbidden.
