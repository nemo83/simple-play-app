FROM openjdk:8-alpine

COPY /target/universal/stage /root

ENTRYPOINT ["/root/bin/simple-play-api"]
