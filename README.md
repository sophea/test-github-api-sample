![Travis Build](https://travis-ci.org/sophea/test-github-api-sample.svg?branch=master)
[![Codecov](https://codecov.io/github/sophea/test-github-api-sample/coverage.svg?branch=master)](https://codecov.io/github/sophea/test-github-api-sample?branch=master)
![Java 7 required](https://img.shields.io/badge/java-7-brightgreen.svg)



# To run this backend project in JAVA technology with Maven build tool:

1 : install JAVA JDK version >=1.7.x  (http://www.oracle.com/technetwork/java/javase/downloads/index.html)

2 : install maven 2 or 3  (https://maven.apache.org/install.html)

3 : go to this project location by console

4 : run command >> mvn clean jetty:run (Jetty Server) or mvn clean tomcat:run (Tomcat Server)

   
===============Test result with API when server started(Jetty/Tomcat)=======

http://localhost:8080/khalibre-assignment-sophea/search?q=liferay-portal

http://localhost:8080/khalibre-assignment-sophea/search?q=liferay-portal&sort=stars

http://localhost:8080/khalibre-assignment-sophea/search?q=liferay-portal&sort=forks&order=asc

=======================================

5 : GZip Compression the content :  com.github.ziplet.filter.compression.CompressingFilter

6 : Integrate Test cases : run command >> mvn clean test

 
