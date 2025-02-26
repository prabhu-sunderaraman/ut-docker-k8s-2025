# Building  Spring Boot Service with Docker, Kubernetes, Testing, and Database

## Scenario:
You are tasked with building a Spring Boot REST API to manage user profiles. The API will process the data, and store it in a local database. It will provide JSON data containing user information such as:

- `userId`: Unique identifier of the user
- `firstName`: First name of the user
- `lastName`: Last name of the user
- `email`: Email address of the user
- `phoneNumber`: Phone number of the user
- `address`: Address of the user

```json
{
  "userId": "user123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com",
  "phoneNumber": "+1234567890",
  "address": {
    "street": "123 Main St",
    "city": "Anytown",
    "state": "CA",
    "zipCode": "12345"
  }
}
```

* GET /users/{userId}
* POST /users

## To Do

* Core Functionality:

- Store the fetched user details in a local database **(e.g., MySQL or H2) **for persistence. 
- Design an appropriate schema for the user data, including tables for user information and address.
- Use Spring Data JPA or JDBC Template to interact with the database.

## Unit Tests:

* Write JUnit tests for the service components, including:
* Database interaction using Spring Data JPA (or JDBC Template)
* Mock the remote API response using Mockito
* Integration Tests **using TestContainers**

## Deployment

* **Dockerization**:

- Create a Dockerfile to package the Spring Boot application into a Docker image.
- Use a multi-stage Docker build to optimize the size of the image.

* **Kubernetes Deployment**:

- Deploy the Docker image to a Kubernetes cluster.
- Set up DB to run as a pod
- Set up a Kubernetes Ingress to expose the application externally and route the traffic to the correct service.

* **Kubernetes Manifests**:
- Deployment
- Service
- Ingress for routing external traffic
- ConfigMaps/Secrets for configuration (e.g., database credentials)

## Deliverables:
* Spring Boot Service
* Comprehensive unit and integration tests using Mockito and Testcontainers
* Docker Image
* Kubernetes Deployment Manifests: Use Helm charts if possible

