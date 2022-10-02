FROM maven

RUN mkdir /app
WORKDIR /app

COPY target/fs-back-0.0.1-SNAPSHOT.jar .

CMD java -jar fs-back-0.0.1-SNAPSHOT.jar