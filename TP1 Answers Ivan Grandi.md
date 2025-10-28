# TP1 Answers 
Student : Ivan Arturo GRANDI FLORES
Major : Software Engineering

**1-1 For which reason is it better to run the container with a flag -e to give the environment variables rather than put them directly in the Dockerfile?**

The -e flag is used to specify our environments variables. For example, to create a postgress container, we need to insert the password for our database. By putting the password in a .env file and specifying in the command the -e flag then the password will be automatically retireved. This practice is safe as the information such as passwords are confidential. 



**1-2 Why do we need a volume to be attached to our postgres container?**

The volume saves the data from the database. Even if if we detroy the container, the data is not lost.

**1-3 Document your database container essentials: commands and Dockerfile.**

Build the container from the image
```
docker build -t Alik265/postgres .
``` 
Run the container specifying the location of the .env file and also the network it must be connected to.
```
docker run -d --name postgres --network app-network -v postgres-data:/var/lib/postgresql/data --env-file ../.env -p 5432:5432 Alik265/postgres
```
Dockerfile for the database
```
FROM postgres:17.2-alpine

COPY CreateScheme.sql /docker-entrypoint-initdb.d/
COPY InsertData.sql /docker-entrypoint-initdb.d/
```

```
docker run -d --name spring-app --network app-network -p 8081:8080 --env-file .env Alik265/spring-app
docker ps
```

**1-4 Why do we need a multistage build? And explain each step of this dockerfile.**

A multistage build is used to save space. We can create an image that will build the necessary files for an app to work. Then we can create a second image that will directly use the compiled files from the previous image. This will save time as we won't have to build everything and we can directly compile files everytime we want to start  an app.

Docker file
```
#Build stage specifying the jdk java version. 
FROM eclipse-temurin:21-jdk-alpine AS myapp-build
 
# Set the working directory 
ENV MYAPP_HOME=/opt/myapp
WORKDIR $MYAPP_HOME


#Installs maven with no cache
RUN apk add --no-cache maven

#copies pom.xml and src folder
COPY pom.xml . 
COPY src ./src

#Runs the spring application build
# The -DskipTests is used to skip the tests during the build process
RUN mvn package -DskipTests 

#Second stage with JRE only not build tools
FROM eclipse-temurin:21-jre-alpine

# Sets the application home directory
ENV MYAPP_HOME=/opt/myapp
WORKDIR $MYAPP_HOME

# Copies the built JAR file from the build stage
COPY --from=myapp-build $MYAPP_HOME/target/*.jar $MYAPP_HOME/myapp.jar

#Command to execute the app
ENTRYPOINT ["java", "-jar", "myapp.jar"]
```

**1-5 Why do we need a reverse proxy?**
The proxy is an intermediate server that will pass the commands from the client side to the server or from the client to the internet.
In this case, we need a reverse proxy so that the client server can connect to the backend.


**<u>Commands to make the app work</u>**

**Start database**

Build image
```docker build -t Alik265/postgres```

Run container
```
docker run -d --name postgres --network app-network -v postgres-data:/var/lib/postgresql/data --env-file .env -p 5432:5432 Alik265/postgres
```

**HTTP server (apache)**
Build image
```docker build -t Alik265/my-apache2```

Run container
```
docker run --network app-network -dit --name my-apache -p 8080:80 Alik265/my-apache2
```
**Spring app**

Build image
```docker build -t Alik265/spring-app .```

Run container
```
docker run -d --name spring-app --network app-network -p 8081:8080 --env-file .env Alik265/spring-app 
```    

**1-6 Why is docker-compose so important?**
Docker compose is important to simplify steps while building containers and running them. It is very good when collaborating as you can share the YAML file with other collaborators. This file allows to improve workflows and issue resolution. The best advantage of using docker compose is the rapid application deployment. The docker compose can restart faster as it saves a cache from previous containers. This saves time as We don't have to remove and run again the container.

**1-7 Document docker-compose most important commands.**

Start docker-compose. from the yml file. It will build the containers specified inside and run them.
```docker compose up -d ```

Stops the docker-compose service and all of its containers.
```docker compose down  ```

Shows the history of the commands executed related to the docker-compose
```docker compose logs -f```


**1-8 Document your docker-compose file.**

docker-compose.yml
```
services:
    backend:
        container_name: spring-app
        build:
            context: ../spring-app
            dockerfile: Dockerfile
        networks:
            - app-network
        depends_on:
            - database
        env_file:
            - ../.env
        

    database:
        container_name: postgres
        build:
            context: ../database_postgress
            dockerfile: Dockerfile
        networks:
            - app-network
        env_file:
            - ../.env
        volumes:
            - postgres-data:/var/lib/postgresql/data

    httpd:
        container_name: http-server
        build:
            context: ../Http_server
            dockerfile: Dockerfile
        ports:
            - "8080:80"
        networks:
            - app-network
        depends_on:
            - backend

networks:
    app-network:
        driver: bridge

volumes:
    postgres-data:
```

**1-9 Document your publication commands and published images in dockerhub.**

**Login into docker hub**
```docker login```

**Database**
Image tagging
```docker tag database alik265/database:latest```

Push the image to docker hub
```docker push alik265/database:latest```

**Backend**
Image tagging
```docker tag spring-app alik265/spring-app:latest```

Push the image to docker hub
```docker push alik265/spring-app:latest```

**HTTP server (apache)**
Image tagging
```docker tag apache alik265/apache:latest```

Push the image to docker hub
```docker push alik265/apache:latest```

**1-10 Why do we put our images into an online repo?**

Having our images in an online repository is better as we can access them from any machine.
They can be used also as a backup image if things get messed up and we need to return to a previous state of the image.
Also if we lose the image in our machine or directly we lose our machine then we will be able to recover the image from the docker-hub repository.
