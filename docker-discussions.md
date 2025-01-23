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


### Where are the docker images present?

* docker hub (https://hub.docker.com/)
* Look for a MySQL image
* Download it to your machine
* Create an instance of it (ie., create a container)

```
docker images
docker pull <imagename>
docker pull mysql:8.0.26
docker pull mysql -> by default the latest version is pulled to your local repository
```

* Start the container

```
docker run mysql:8.0.26
docker run --name=indiummysql --rm -d -e MYSQL_ROOT_PASSWORD=indium mysql:8.0.26
docker ps
docker logs <containerId>
```

#### Accessing the container from host machine

* Port mapping
* From the host machine you need to map a port with the container port
* The syntax is **-p hostPort:containerPort**

```
docker run --name=indiummysql --rm -d -e MYSQL_ROOT_PASSWORD=indium -p 3306:3306 mysql:8.0.26
docker run --name=indiummysql2 --rm -d -e MYSQL_ROOT_PASSWORD=indium -p 9001:3306 mysql:8.0.26
```

```
docker run --name=<name> --rm -d  -p <port1>:<port1> -p <port2>:<port2> <imageName>
```

#### Volumes

* You map a container folder with a host machine's folder using volumes
* The actual data will remain in the host machine and the container will use the data
* When you stop/destroy the container, the host machine folder still remains intact
* The syntax is **-v hostMachineFolder:containerMachineFolder**
* The syntax is **-v hostMachineFolder:containerMachineFolder, hostMachineFolder:containerMachineFolder**
 
```
docker run --name=indiummysql --rm -d -e MYSQL_ROOT_PASSWORD=indium -p 3306:3306 -v <hostMachineFolderPath>:/var/lib/mysql mysql:8.0.26
```

* /var/lib/mysql -> Look at the documentation


* You can define a volume using docker command;
* docker will use its own storage space and path

```
docker volume create mysql-indium-data
docker run --name=indiummysql --rm -d -e MYSQL_ROOT_PASSWORD=indium -p 3306:3306 -v mysql-indium-data:/var/lib/mysql mysql:8.0.26
docker volume ls
docker volume inspect <volume-name>
```


### Networks

* You can make containers talk to each other in two ways
* Through the host machine (**Discussed later**)
* Directly if they are are configured to belong to the same network


```
docker network ls
docker network create <network-name>
docker run --name=c2 --rm -d -e MYSQL_ROOT_PASSWORD=indium --network <network-name>   mysql:8.0.26
```			

* Try to **ping** one container from another
* You can install ping
```
apt-get update -y
apt-get install -y iputils-ping
```

























