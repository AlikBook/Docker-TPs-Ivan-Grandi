# Build stage
FROM eclipse-temurin:21-jdk-alpine AS myapp-build
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
