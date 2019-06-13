FROM java
MAINTAINER DQ QYT
ADD lifegame.jar /data/
ADD start.sh /
#RUN /usr/bin/java -jar /data/lifegame.jar

# running command
# docker run -it lifegame:v3 sh start.sh 
