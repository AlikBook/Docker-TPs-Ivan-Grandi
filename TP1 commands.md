Commandes

Construction de l'image
C:\Users\ivang\Documents\Clases\Efrei\Semestre_7\Docker\Docker-TPs-Ivan-Grandi\TP1>docker build -t Alik265/tp1 .
[+] Building 1.5s (5/5) FINISHED                                                                                                                                                                                     docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                                                                                 0.0s
 => => transferring dockerfile: 138B                                                                                                                                                                                                 0.0s
 => [internal] load metadata for docker.io/library/postgres:17.2-alpine                                                                                                                                                              1.1s
 => [internal] load .dockerignore                                                                                                                                                                                                    0.0s
 => => transferring context: 2B                                                                                                                                                                                                      0.0s
 => CACHED [1/1] FROM docker.io/library/postgres:17.2-alpine@sha256:7e5df973a74872482e320dcbdeb055e178d6f42de0558b083892c50cda833c96                                                                                                 0.1s
 => => resolve docker.io/library/postgres:17.2-alpine@sha256:7e5df973a74872482e320dcbdeb055e178d6f42de0558b083892c50cda833c96                                                                                                        0.0s
 => exporting to image                                                                                                                                                                                                               0.2s
 => => exporting layers                                                                                                                                                                                                              0.0s
 => => exporting manifest sha256:dccd82be9e0455fe450e08b76b2e65ed102baee198972956077d28291adbe488                                                                                                                                    0.0s
 => => exporting config sha256:971d9df349787a9fa914cba7f84d56997bc17b9ba6de7fbe919ba68c2387c481                                                                                                                                      0.0s
 => => exporting attestation manifest sha256:9e882d38baf8209a9d339a6aec7a112c9d9e6358c5ed6b55c66e1d52a730bbd5                                                                                                                        0.0s
 => => exporting manifest list sha256:1dd16c528d56b4cb2816e7d979375b5be68a237602b224c8785027baa91f9036                                                                                                                               0.0s
 => => naming to Alik265/tp1:latest                                                                                                                                                                                                  0.0s
 => => unpacking to Alik265/tp1:latest                                                                                                                                                                                               0.0s

 1 warning found (use docker --debug to expand):
 - SecretsUsedInArgOrEnv: Do not use ARG or ENV instructions for sensitive data (ENV "POSTGRES_PASSWORD") (line 3)

C:\Users\ivang\Documents\Clases\Efrei\Semestre_7\Docker\Docker-TPs-Ivan-Grandi\TP1>docker run -d --name tp1 -e POSTGRES_PASSWORD=pwd -p 5432:5432 Alik265/tp1
a401d1ae1b157c70265e1a0b06fea261b6a05b31e2102d3eb844672ee56361db

C:\Users\ivang\Documents\Clases\Efrei\Semestre_7\Docker\Docker-TPs-Ivan-Grandi\TP1>docker ps
CONTAINER ID   IMAGE         COMMAND                  CREATED          STATUS          PORTS                                         NAMES
a401d1ae1b15   Alik265/tp1   "docker-entrypoint.s…"   26 seconds ago   Up 25 seconds   0.0.0.0:5432->5432/tcp, [::]:5432->5432/tcp   tp1



C:\Users\ivang>docker network create app-network
b5d1c9f34ea17f4d0b7882e1c943ad92a056495be002182f04da9f8647bc72e5

C:\Users\ivang> docker run -p "8090:8080" --net=app-network --name=adminer -d adminer
Unable to find image 'adminer:latest' locally
latest: Pulling from library/adminer
00a5ec08747e: Pull complete
83a14574d9b4: Pull complete
5b7dc8240588: Pull complete
22b8cf85bbba: Pull complete
cff98099a8db: Pull complete
5da04ac49062: Pull complete
6901834d8559: Pull complete
d50bd3180ce9: Pull complete
92d173a1cad8: Pull complete
dd3296dcff29: Pull complete
4f4fb700ef54: Pull complete
e22763e65c8d: Pull complete
bb2f8e296f16: Pull complete
abc85f6a070c: Pull complete
4e220788f6b2: Pull complete
385c4c931423: Pull complete
Digest: sha256:bf7ea9bd62afd2d34045b4098ad68feb4a08ad9f75f28dc5d9b7d6d84d63005c
Status: Downloaded newer image for adminer:latest
9b913b3fd925e1d1888f53d7314a9a598e0225209b2f05abb558d2cc25aac111


run docker with a volume
docker run -d --name tp1 -e POSTGRES_PASSWORD=pwd -v .:/docker-entrypoint-initdb.d -p 5432:5432  postgres:17.2-alpine


