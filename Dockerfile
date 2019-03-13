FROM openjdk

COPY target/fileread-1.0.0-SNAPSHOT-jar-with-dependencies.jar /opt/fileread-1.0.0-SNAPSHOT-jar-with-dependencies.jar

CMD java -jar /opt/fileread-1.0.0-SNAPSHOT-jar-with-dependencies.jar
