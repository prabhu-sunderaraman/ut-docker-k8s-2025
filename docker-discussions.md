* Docker is a tool to set up boxes
* Boxes are nothing but containers
* A docker container is a Linux VM ( ie., a Linux OS installed and set up for you)
* When you say you have 3 docker containers running in your host machine., it means you have 3 Linux VM running in your host machine
* That's why the processing speed and RAM needs to be on a higher side when you work with docker

### Docker 

* A docker is a **Golang** application
* *JDK Fibers is equivalent of the Goroutines in Golang for building high concurrency applications*
* You use docker to create containers
* Docker's competitor is **Podman**

### Getting started with docker

* Install **DockerDesktop** (or **OrbStack**)
* All the tools neccessary to work with docker is made available
* **docker server(or engine)** and **docker (client)**

```
docker version
docker ps
```

### OO basics

* Create a class Car
* Create instances of Car ie., Objects

* Create an **Image**
* Create instances of Image ie., **Containers**

* I have a Car class and a Car Object
* I have a Car Image and a Car container

* **I have a MySQL Image and a MySQL Container** -> You have a Linux OS installed with MySQL setup inside it
* **I have a Kafka Image and a Kafka Container** -> You have a Linux OS installed with Kafka setup inside it
* **I have a Spring boot Inventory container** -> You have a Linux OS installed with the Spring boot inventory application running inside it
* If you have 10 Spring boot microservices running as containers
* You have 10 linux VM running; each VM has 1 spring boot microservice running inside
* You just create an **Spring boot rest API IMAGE** and release it




























