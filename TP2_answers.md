# TP1 Answers 
Student : Ivan Arturo GRANDI FLORES
Major : Software Engineering

**2-1 What are testcontainers?**
A test container is part of a java library that is used to do integration testing. In our case it will create docker containers. They containers are created and tested executed at the end of command mvn clean verify. Moreover, we can use the test container locally and remotely throught github actions which is good for scalability.

**2-2 For what purpose do we need to use secured variables ?**
We need secure variables to protect the access to our projects. If someone finds them, then they can access to our images from Docker Hub our databases servers etc. We use them to protect our data.

**2-3 Why did we put needs: build-and-test-backend on this job? Maybe try without this and you will see!**
The needs are used to make sure a job is executed after another one. In our case the docker test will be executed after the test of the backend. It makes sense because we need to check that everything is working before pushing our images.

**2-4 For what purpose do we need to push docker images?**
It is important to push docker images so that they are in a remote repository and they are up to date. When working with other people it is necessary to have everything updated to maintain consistency. This will ensure that everyone works on the same version of the image and also not habing problems like ("it works on my machine" problem is solved). Also by publishing our images other production servers can access directly to our images if needed.