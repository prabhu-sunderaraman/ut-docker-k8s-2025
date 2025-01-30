### Lab 05

* Create a new spring boot rest project **lab05-rest-with-db-api**
* Add the web, data jpa and mysql connector dependencies

* Copy and use the controller, service, entity and repository classes from **https://github.com/prabhu-sunderaraman/ut-docker-k8s-2025/tree/main/demo-rest-api**
* Modify the package names accordingly
* Configure the datasource information in **application.yml** file

``` yml
spring:
  application:
    name: lab05
  datasource:
      url: jdbc:mysql://localhost:3306/training
      username: root
      password: root
      driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
   hibernate:
    ddl-auto: create-drop
```



## To Do

* Dockerize lab05 application
* Use docker compose and configure lab05 and mysql (make sure mysql has a database called **training**)
* Start the containers and run the endpoints for the **/products**
