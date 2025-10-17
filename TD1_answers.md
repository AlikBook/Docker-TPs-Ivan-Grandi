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
