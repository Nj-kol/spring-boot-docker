
# Spring Boot with Docker

* A simple CRUD application to showcase how to run a Spring Boot application as a docker container
* The application is a Restful web service that does CRUD operation for an entity user on MYSQL 
	
## Build Docker image

mvn install

mvn docker:build

## Recreate docker image 

mvn clean install

mvn docker:build

## See the docker image

docker images

* This should give an output similar to :
	
	REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE   
    
    user-app            latest              dce4a1118dc5        2 hours ago         678MB

## Create and run a docker container 

docker run -it \
--name user-crud-app \
--net=host \
-e SERVICE_PORT=8183 \
-e JDBC_URL=jdbc:mysql://localhost:3306/demo \
-e USER=<your_mysql_user_id> \
-e PASSWORD=<your_mysql_user_password> \
user-app 

 Runs in network mode 

## Swagger UI

http://localhost:8183/swagger-ui.html

## Rerun the existing container

docker start user-crud-app

## Stop the container

docker stop user-crud-app

## Login to the container

docker exec -it user-crud-app bash

## Notes

* --net=host is required, if the docker container wants to communicate 
  the localhost

* Published ports are discarded when using host network mode 

* Everytime you do docker run, it creates a new container ( with a container id ) 

References
==========
https://github.com/fabric8io/docker-maven-plugin    

https://www.youtube.com/watch?v=pqux6HO613M

