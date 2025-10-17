1----

docker run hello-world

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/



2----
C:\Users\ivang>docker pull alpine
Using default tag: latest
latest: Pulling from library/alpine
Digest: sha256:4b7ce07002c69e8f3d704a9c5d6fd3053be500b7f1c69fc0d80990c2ad8dd412
Status: Image is up to date for alpine:latest
docker.io/library/alpine:latest


3-----
C:\Users\ivang>docker images
REPOSITORY    TAG       IMAGE ID       CREATED        SIZE
alpine        latest    4b7ce07002c6   8 days ago     12.8MB
hello-world   latest    6dc565aa6309   2 months ago   20.3kB


4-----
C:\Users\ivang>docker run alpine ls -l
total 56
drwxr-xr-x    2 root     root          4096 Oct  8 09:28 bin
drwxr-xr-x    5 root     root           340 Oct 17 07:27 dev
drwxr-xr-x    1 root     root          4096 Oct 17 07:27 etc
drwxr-xr-x    2 root     root          4096 Oct  8 09:28 home
drwxr-xr-x    6 root     root          4096 Oct  8 09:28 lib
drwxr-xr-x    5 root     root          4096 Oct  8 09:28 media
drwxr-xr-x    2 root     root          4096 Oct  8 09:28 mnt
drwxr-xr-x    2 root     root          4096 Oct  8 09:28 opt
dr-xr-xr-x  292 root     root             0 Oct 17 07:27 proc
drwx------    2 root     root          4096 Oct  8 09:28 root
drwxr-xr-x    3 root     root          4096 Oct  8 09:28 run
drwxr-xr-x    2 root     root          4096 Oct  8 09:28 sbin
drwxr-xr-x    2 root     root          4096 Oct  8 09:28 srv
dr-xr-xr-x   13 root     root             0 Oct 17 07:27 sys
drwxrwxrwt    2 root     root          4096 Oct  8 09:28 tmp
drwxr-xr-x    7 root     root          4096 Oct  8 09:28 usr
drwxr-xr-x   11 root     root          4096 Oct  8 09:28 var

5----
C:\Users\ivang>docker run alpine echo "hello from alpine"
hello from alpine

6----
C:\Users\ivang>docker run alpine /bin/sh

C:\Users\ivang>


7-----

C:\Users\ivang>docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES


8------
C:\Users\ivang>docker run -it alpine /bin/sh
/ # ls
bin    etc    lib    mnt    proc   run    srv    tmp    var
dev    home   media  opt    root   sbin   sys    usr
/ # uname -a
Linux d0aa8da1a846 6.6.87.2-microsoft-standard-WSL2 #1 SMP PREEMPT_DYNAMIC Thu Jun  5 18:30:46 UTC 2025 x86_64 Linux





TERMINOLOGY


C:\Users\ivang>docker run -d dockersamples/static-site
Unable to find image 'dockersamples/static-site:latest' locally
latest: Pulling from dockersamples/static-site
aff3ab7e9c39: Pull complete
a3ed95caeb02: Pull complete
716f7a5f3082: Pull complete
7b10f03a0309: Pull complete
fdd5d7827f33: Pull complete
Digest: sha256:daa686c61d7d239b7977e72157997489db49f316b9b9af3909d9f10fd28b2dec
Status: Downloaded newer image for dockersamples/static-site:latest
0040bd1a000dfd0c701f895722ed853ff251cdb28a40ec1f3e1f3c38e22a1f47




------

C:\Users\ivang>docker run -d dockersamples/static-site
c14af0df33958c2f57fac61ad3da5e7c94a1ca2a63c4085224ac0864e598c84a

C:\Users\ivang>docker ps
CONTAINER ID   IMAGE                       COMMAND                  CREATED         STATUS         PORTS             NAMES
c14af0df3395   dockersamples/static-site   "/bin/sh -c 'cd /usr…"   2 seconds ago   Up 2 seconds   80/tcp, 443/tcp   blissful_benz

-----

C:\Users\ivang>docker stop c14af0df3395
c14af0df3395

C:\Users\ivang>docker rm c14af0df3395
c14af0df3395


C:\Users\ivang>docker run --name static-site -e AUTHOR="Ivan" -d -P dockersamples/static-site
385884416dd10767e13345f8925d46248480bb47500c268aab18112cfcc8bf97

C:\Users\ivang>docker port static-site
80/tcp -> 0.0.0.0:32768
443/tcp -> 0.0.0.0:32769


Command to see my website is 
http://localhost:32768/


C:\Users\ivang>docker run --name static-site-2 -e AUTHOR="Ivan" -d -p 8888:80 dockersamples/static-site
c6be08739ce579c3c62ee2c52fa3bb12b68f1e9b42d3fdc38657df15119d9ba6

C:\Users\ivang>docker port static-site-2
80/tcp -> 0.0.0.0:8888
80/tcp -> [::]:8888

Command to see the website

C:\Users\ivang>docker run --name static-site-2 -e AUTHOR="Ivan" -d -p 8888:80 dockersamples/static-site
c6be08739ce579c3c62ee2c52fa3bb12b68f1e9b42d3fdc38657df15119d9ba6

C:\Users\ivang>docker port static-site-2
80/tcp -> 0.0.0.0:8888
80/tcp -> [::]:8888



-------

C:\Users\ivang>docker stop static-site
static-site

C:\Users\ivang>docker rm static-site
static-site

C:\Users\ivang>docker rm -f static-site-2
static-site-2


C:\Users\ivang>docker images
REPOSITORY                  TAG       IMAGE ID       CREATED        SIZE
alpine                      latest    4b7ce07002c6   8 days ago     12.8MB
hello-world                 latest    6dc565aa6309   2 months ago   20.3kB
dockersamples/static-site   latest    daa686c61d7d   9 years ago    293MB



C:\Users\ivang>docker pull ubuntu:12.04
12.04: Pulling from library/ubuntu
6d93b41cfc6b: Pull complete
d8868e50ac4c: Pull complete
589bba2f1b36: Pull complete
83251ac64627: Pull complete
d62ecaceda39: Pull complete
Digest: sha256:18305429afa14ea462f810146ba44d4363ae76e4c8dfc38288cf73aa07485005
Status: Downloaded newer image for ubuntu:12.04
docker.io/library/ubuntu:12.04




C:\Users\ivang\Documents\Clases\Efrei\Semestre_7\Docker\Docker-TPs-Ivan-Grandi\TD1\flask-app>docker build -t Alik265/myfirstapp .
[+] Building 65.2s (5/12)                  docker:desktop-linux
 => => resolve docker.io/library/alpine:3.21.0@sha256:21d  0.0s
 => => sha256:38a8310d387e375e0ec6fabe047 3.64MB / 3.64MB  1.6s
 => => extracting sha256:38a8310d387e375e0ec6fabe047a9149  0.2s
 => [internal] load build context                          0.1s
 => => transferring context: 1.60kB                        0.0s
 => [2/8] RUN apk add --no-cache build-base libffi-dev o  61.5s
 => => # (29/51) Installing openssl-dev (3.3.5-r0)
 => => # (30/51) Installing libbz2 (1.0.8-r6)
 => => # (31/51) Installing libexpat (2.7.3-r0)
 => => # (32/51) Installing gdbm (1.24-r0)
 => => # (33/51) Installing xz-libs (5.6.3-r1)
 => => # (34/51) Installing mpdecimal (4.0.0



 C:\Users\ivang\Documents\Clases\Efrei\Semestre_7\Docker\Docker-TPs-Ivan-Grandi\TD1\flask-app>docker build -t Alik265/myfirstapp .
[+] Building 107.2s (13/13) FINISHED       docker:desktop-linux
 => [internal] load build definition from Dockerfile       0.0s
 => => transferring dockerfile: 801B                       0.0s
 => [internal] load metadata for docker.io/library/alpine  1.8s
 => [internal] load .dockerignore                          0.0s
 => => transferring context: 2B                            0.0s
 => [1/8] FROM docker.io/library/alpine:3.21.0@sha256:21d  1.9s
 => => resolve docker.io/library/alpine:3.21.0@sha256:21d  0.0s
 => => sha256:38a8310d387e375e0ec6fabe047 3.64MB / 3.64MB  1.6s
 => => extracting sha256:38a8310d387e375e0ec6fabe047a9149  0.2s
 => [internal] load build context                          0.1s
 => => transferring context: 1.60kB                        0.0s
 => [2/8] RUN apk add --no-cache build-base libffi-dev o  76.7s
 => [3/8] WORKDIR /usr/src/app                             0.1s
 => [4/8] RUN python3 -m venv venv                         4.4s
 => [5/8] COPY requirements.txt ./                         0.1s
 => [6/8] RUN pip install --no-cache-dir --upgrade pip &&  5.8s
 => [7/8] COPY app.py ./                                   0.1s
 => [8/8] COPY templates/index.html ./templates/           0.0s
 => exporting to image                                    16.1s
 => => exporting layers                                   12.1s
 => => exporting manifest sha256:4ae96dc46ce198b1095df8aa  0.0s
 => => exporting config sha256:4eb062086a144bfa4cce39bf6f  0.0s
 => => exporting attestation manifest sha256:7cfa15bf2863  0.0s
 => => exporting manifest list sha256:a51051ce9681011d85f  0.0s
 => => naming to Alik265/myfirstapp:latest                 0.0s
 => => unpacking to Alik265/myfirstapp:latest              3.8s

C:\Users\ivang\Documents\Clases\Efrei\Semestre_7\Docker\Docker-TPs-Ivan-Grandi\TD1\flask-app>docker run -p 8888:5000 --name myfirstapp Alik265/myfirstapp
 * Serving Flask app 'app'
 * Debug mode: off
WARNING: This is a development server. Do not use it in a production deployment. Use a production WSGI server instead.
 * Running on all addresses (0.0.0.0)
 * Running on http://127.0.0.1:5000
 * Running on http://172.17.0.2:5000
Press CTRL+C to quit
172.17.0.1 - - [17/Oct/2025 08:50:12] "GET / HTTP/1.1" 200 -
172.17.0.1 - - [17/Oct/2025 08:50:12] "GET /favicon.ico HTTP/1.1" 404 -
