
## Spring Boot api crud-restaurant 

## How it works:
### **1. Docker. First, you need to install docker**
* Download Docker windows [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature on windows and restart;
* Download Docker Desktop for linux [Here](https://docs.docker.com/desktop/install/linux-install/)
* Then open powershell in windows  or terminal if you use linux and check:
```bash
docker info
```
or check docker version
```bash
docker -v
```
or docker compose version
```bash
docker-compose -v
```
### **2. Spring boot app**
* Clone the repository:
```bash
git clone https://github.com/JavierTallarin/api-restaurant
```

* Running the containers:

* This command will download the postgres docker image
```bash
docker pull postgres
```

* This command will build the docker containers with postgresql.
```bash
docker run --name mypostgres2 -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_DB=menu -d postgres
```


* If you have to want to see running containers. Checklist docker containers
```bash
docker container list -a
```
or
```bash
docker container ls
```
* Build the gradle project:
```bash
gradle runJar
```


### **Guide for using endpoints the app:**

Go to [http://localhost:8080/](http://localhost:8080/)

* GET request to `/restaurant` returns a list of "restaurants";

### The backend is done with
- Spring Boot 2.7.7
- Spring 1.0.15.RELEASE
- Lombok 1.18.24
- Spring jpa
- Postgresql
- Mockito
- Java 11
- IntelliJ Community Edition



