FROM openjdk:8-jdk-slim

COPY /target/universal/stage /root

ENTRYPOINT ["/root/bin/simple-play-app"]
