### 1-1 For which reason is it better to run the container with a flag -e to give the environment variables rather than put them directly in the Dockerfile?

The -e flag is used to specify our environments variables. For example, to create a postgress image we need insert the password for our database.



### 1-2 Why do we need a volume to be attached to our postgres container?

The volume makes that even if we detroy the container, the data of the database is not lost.

### 1-3 Document your database container essentials: commands and Dockerfile.


docker build -t Alik265/postgress .

docker run -d --name postgress -e POSTGRES_PASSWORD=pwd -p 5432:5432 Alik265/postgress

docker ps


### 1-4 Why do we need a multistage build? And explain each step of this dockerfile.
