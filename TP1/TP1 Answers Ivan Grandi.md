### 1-1 For which reason is it better to run the container with a flag -e to give the environment variables rather than put them directly in the Dockerfile?

The -e flag is used to specify our environments variables. For example, to create a postgress image we need insert the password for our database.



### 1-2 Why do we need a volume to be attached to our postgres container?

The volume makes that even if we detroy the container, the data of the database is not lost.

### 1-3 Document your database container essentials: commands and Dockerfile.


docker build -t Alik265/postgres .

docker run -d --name postgres --network app-network -v postgres-data:/var/lib/postgresql/data --env-file .env -p 5432:5432 Alik265/postgres

>docker run -d --name spring-app --network app-network -p 8081:8080 --env-file .env Alik265/spring-app
docker ps


### 1-4 Why do we need a multistage build? And explain each step of this dockerfile.

A multistage build is used to save space. We can create an image that will build the necessary files for an app to work. Then we can create a second image that will directly use those files without the need of building again everything.



# Build stage specifying the jdk java version. 
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

# Run stage

#Second stage with JRE only not build tools
FROM eclipse-temurin:21-jre-alpine

# Sets the application home directory
ENV MYAPP_HOME=/opt/myapp
WORKDIR $MYAPP_HOME

# Copies the built JAR file from the build stage
COPY --from=myapp-build $MYAPP_HOME/target/*.jar $MYAPP_HOME/myapp.jar

ENTRYPOINT ["java", "-jar", "myapp.jar"]


## 1-5 Why do we need a reverse proxy?
We need a reverse proxy so that the client server can connect to the backend or other services.

Commands to make the app work

postgres
docker build -t Alik265/postgres
docker rm -f postgres

docker run -d --name postgres --network app-network -v postgres-data:/var/lib/postgresql/data --env-file .env -p 5432:5432 Alik265/postgres     

Apache
docker build -t Alik265/my-apache2

docker run --network app-network -dit --name my-apache -p 8080:80 Alik265/my-apache2

spring

docker run -d --name spring-app --network app-network -p 8081:8080 --env-file .env Alik265/spring-app                                      