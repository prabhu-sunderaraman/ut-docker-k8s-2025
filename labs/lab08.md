## Lab 08

* Create the following three files
* **mysql-config.yaml** file -> Configure the following properties

```
MYSQL_DATABASE: userdb
MYSQL_PORT: "3306"
```

* Create **mysql-secrets.yaml** file -> Configure the following secrets
```
MYSQL_USER: cm9vdAo=          # base64 for 'root'
MYSQL_PASSWORD: cGFzc3dvcmQ=   # base64 for 'password'
```

* **mysql-deployment.yaml** 
* You will set up mysql pod by referring to the config properties and secrets above
* Enable port forwarding to 3306

### Test connection

* Use a mysql client or workbench or any other client or create a spring boot rest api check


### Alternative to port forwarding

* Create **mysql-service.yaml** file

```
apiVersion: v1
kind: Service
metadata:
  name: mysql-service
spec:
  selector:
    app: mysql
  type: NodePort	
  ports:
    - port: 3306
      targetPort: 3306
      nodePort: 30001

```

* After running this service
* You should be able to connect to mysql by accessing localhost:30001

#### You will learn about services next week