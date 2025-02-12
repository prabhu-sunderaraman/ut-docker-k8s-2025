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
* Through the host machine (**host.docker.internal**)
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

### docker compose yml

* docker compose is a YAML configuration to configure your containers, volumes, networks, environment variables at one shot

* Run the docker compose file by specifying the up command; networks, volumes etc are created

```
docker compose -p jan24 -f docker-compose-example2.yml up
```

* You can stop/remove the containers by running the down command; networks are removed; **But the volumes are not removed**

```
docker compose -p jan24 -f docker-compose-example2.yml down
```

* If you want to stop/remove the containers along with the volumes also, use -v option. **Be cautious**

```
docker compose -p jan24 -f docker-compose-example2.yml down -v
```

### Dockerfile

* If you want to build your own image for your application say spring boot/nodejs/php/.net/python you need to specify the steps in a configuration file
* **Dockerfile** is the name of the configuration file (can be changed)

```Dockerfile
FROM eclipse-temurin:22-alpine
COPY target/rest-api-for_docker-0.0.1.jar app.jar
CMD ["java", "-jar", "app.jar"]
```

* Build an image by running docker build command

```
docker build -t <imageNameOfYourChoice> .
```

* Create an instance by using **docker run** command


### Steps

* Develop your Spring boot rest API
* Create a jar file **using maven** 
* Define a **Dockerfile** which contains the steps to create an image of this application

#### Either 

* Run the **docker build command** to build the image
* Launch your container using **docker run command**


#### Or (In the project environments)

* Define a docker-compose file 
* Configure the container, image information. Refer to the Dockerfile created in Line#174
* Run the **docker compose command** to automatically build, start containers 


## Kubernetes (k8s)

* Orchestration tool
* Manage the life cycle of the containers
* Make sure the containers are always up and running; Scale up/down the containers
* Also written in Golang
* **Docker swarm** is another orchestration tool. Used in smaller teams/projects
* Installing DockerDesktop installs all the tools(engine and client) to work with **docker**
* **Enabling kubernetes** on DockerDesktop installs all the tools(server and client) to work with k8s, **kubectl**
* And **creates a single node cluster** in the machine (called docker-desktop)

```
kubectl version
kubectl config get-contexts
```

#### Building block of k8s


* Pod is the fundamental building block in k8s
* Pod is a wrapper to a container.
* So when you say, **kubernetize your application**, what you mean is 

```markdown
1. create an api
2. containerize(dockerize) it
3. Create a pod
4. Deploy the pod
```

### Pods

```
kubectl run hit-pod --image=hitendra373/test-repo:multi-stage-1_0_0
kubectl get pods
kubectl logs hit-pod
kubectl delete hit-pod
```

* Unless you explicitly delete the pod, stopping the pod will make kube server restart it
* A very powerful feature, which makes sure your underlying application is always up and running
* Even if something goes wrong and application(or container) crashes, k8s will bring it up immediately


### Deployments

* Main build file like entity where you configure pods, services, namespaces, replicasets etc.
* You can create and delete deployments
* All the entities associated with the deployment will get created/destroyed
* Starting point for working with k8s in a professional environment


```
kubectl create deployment hit-deployment --image=hitendra373/test-repo:multi-stage-1_0_0 --replicas=3
kubectl scale deployment hit-deployment --replicas=4
kubectl scale deployment hit-deployment --replicas=0
kubectl delete deployment hit-deployment
```

* Namespaces

```
kubectl create namespace hit-ns
kubectl get namespaces
kubectl create namespace my-ns
kubectl get namespaces
kubectl create deployment hit-deployment --image=hitendra373/test-repo:multi-stage-1_0_0 --replicas=1 -n hit-ns
kubectl create deployment prabhu-deployment --image=prabhudev/febtraining2025:multistage -n my-ns
kubectl describe deployment hit-deployment -n hit-ns
kubectl describe namespace hit-ns
kubectl scale deployment hit-deployment --replicas=2 -n hit-ns
kubectl delete deployment prabhu-deployment -n my-ns
kubectl delete deployment hit-deployment -n my-ns
kubectl delete namespace my-ns
```

### Config files

* YAML based configuration

```
kubectl apply -f <filename>
kubectl delete -f <filename>
```

### Port forwarding

* Access the application in the pod
* Used for learning/demo/internal purposes only
* Similar to port mapping in docker

```
kubectl port-forward pod/<podName> hostPort:containerPort -n <namespace>
```









