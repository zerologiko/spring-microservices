# Microservices with Spring Cloud and Spring Boot

Some learning exercises based on Udemy course based on https://github.com/in28minutes/spring-microservices

## Components:

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


## URL:

 * Limit Service -> http://localhost:8080/limits
 * Currency Exchange Service ->http://localhost:8000/currency-exchange
 * Zipkin Server -> http://localhost:9411

## Tools:

 * Starting RabbitMQ: execute "rabbitmq-server"
 * Zipkin Server listening on RabbitMQ: execute "RABBIT_URI=amqp://localhost  java -jar zipkin-server-2.20.2.jar"


## Note:
 * remove the dependencies from Sprind DevTools to disable auto reloading of application if too much memory is used for your workstation.
 * also Actuator dependecy can be removed if not needed.

### Run multiple instaces of services:
Add -Dserver-port=XXXX to the Java VM arguments 

