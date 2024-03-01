FROM openjdk:latest

WORKDIR /usr/src/app

RUN mkdir -p nettverksprogrammering/oving5/docker/

COPY Main.java nettverksprogrammering/oving5/docker/

RUN javac nettverksprogrammering/oving5/docker/Main.java

CMD ["sh", "-c", "java nettverksprogrammering/oving5/docker/Main.java"]