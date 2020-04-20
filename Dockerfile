FROM flowdocker/play:latest-java13

# Add Tini
# ENV TINI_VERSION v0.19.0
# ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
# RUN chmod +x /tini
# ENTRYPOINT ["/tini", "-g", "--"]

COPY /target/universal/stage /root
COPY environment-provider.jar /root
COPY run.sh /root

ENTRYPOINT ["/root/run.sh", "java", "-jar", "/root/environment-provider.jar"]
# CMD ["java", "-jar", "/root/environment-provider.jar"]
