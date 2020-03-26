# Microservices with Spring Cloud and Spring Boot

Some learning exercises from **in28minutes Spring Microservices** Udemy course

For more info see:
https://github.com/in28minutes/spring-microservices
https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud


## Components used:

 * Spring Boot 
 * Spring Config Server (distributed config service)
 * Spring Cloud Ribbon (Client side load balancer)
 * Spring Cloud Feign (Rest client)
 * Spring CLoud Netflix Eureka (Naming Server)
 * Spring Cloud Netflix Zuul (API gateway)
 * Spring Cloud Sleuth (logging)
 * Spring Cloud Bus (refresh all instances configuration of a service)
 * RabbitMQ 
 * Zipkin (distributed tracing server)

## How to build and run projects :
 * Download the zip or clone the Git repository.
 * build all projects with `mvn clean package` 
 * configuration of spring-cloud-config-server
    * configure **application.properties** `spring.cloud.config.server.git.uri` to point to the **git-localconfig-repo** project (copy porject in another folder and init a Git repo) 

### Start order of microservices
Zipkin and RabbitMQ must be running (see Tools section)
 * eureka-naming-server
 * spring-cloud-config-server
 * zuul-api-gateway-server
 * currency-exchange-service
 * currency-conversion-service



## Ports
|     Application   | Port    |
| -------------                   | -------------     |
| Limits Service                  | 8080, 8081, ... |
| Spring Cloud Config Server      | 8888 
| Currency Exchange Service       | 8000, 8001, 8002, ..  |
| Currency Conversion Service     | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server    | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |

 ## URLs
|     Application                              |     URL                         |
| -------------                                | -------------                   |
| Limits Service                               | http://localhost:8080/limits |
| Spring Cloud Config Server                   | http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev |
| Currency Converter Service - Direct Call     | http://localhost:8100/currency-converter/ |
| Currency Converter Service - Feign           | http://localhost:8100/currency-converter-feign/ |
| Currency Exchange Service                    | http://localhost:8000/currency-exchange/ http://localhost:8001/currency-exchange/ |
| Eureka                                       | http://localhost:8761/|
| Zuul - Currency Exchange                     | http://localhost:8765/currency-exchange-service/currency-exchange/ |
| Zuul - Exchange Service                      | http://localhost:8765/currency-conversion-service/currency-converter-feign/ |
| Zipkin Server                                | http://localhost:9411/zipkin/ |

See Postman collection for request and responses.

## Tools:
RabbitMQ and Zipkin are used for logging and tracing.
You can installa
 * Starting RabbitMQ: execute "rabbitmq-server"
 * Zipkin Server listening on RabbitMQ: execute "RABBIT_URI=amqp://localhost  java -jar zipkin-server-2.20.2.jar"

### Run multiple instaces of services:
Add -Dserver-port=XXXX to the Java VM arguments 

## Postman collection to test the microservices
Import all the collection found in the folder `postman-collections` in Postman