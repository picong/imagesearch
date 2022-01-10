# Dockerfile
FROM hub.c.163.com/library/java:8
MAINTAINER  Pi Cong (P.C.) <644259206@qq.com>
CMD echo "String...."
ADD imagesearch-0.0.1-SNAPSHOT.jar /imagesearch.jar
RUN bash -c 'touch /imagesearch.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/imagesearch.jar"]
