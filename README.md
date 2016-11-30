![Travis Build](https://travis-ci.org/sophea/test-github-api-sample.svg?branch=master)
[![Codecov](https://codecov.io/github/sophea/test-github-api-sample/coverage.svg?branch=master)](https://codecov.io/github/sophea/test-github-api-sample?branch=master)
![Java 8 required](https://img.shields.io/badge/java-8-brightgreen.svg)
[![Sputnik](https://sputnik.ci/conf/badge)](https://sputnik.ci/app#/builds/sophea/test-github-api-sample)
# Description
This is about java web backend service with Spring MVC REST-APIs + hibernate database connection

# Clone this project
 git clone git@github.com:sophea/test-github-api-sample.git
  

# To run this backend project in JAVA technology with Maven build tool:

1 : install JAVA JDK version >=1.8.x  (http://www.oracle.com/technetwork/java/javase/downloads/index.html)

2 : install maven 2 or 3  (https://maven.apache.org/install.html)

3 : install Mysql/MariaDb database server with username : root and password : root.
    execute sql : src/main/resources/sample.sql
    >> mysql -u root -proot <   src/main/resources/sample.sql
    

4 : go to this project location by console

5 : run command >> mvn clean jetty:run (Jetty Server) or mvn clean tomcat:run (Tomcat Server)

   
===============Test result with API when server started(Jetty/Tomcat)=======

http://localhost:8080/sample/search?q=liferay-portal

http://localhost:8080/sample/search?q=liferay-portal&sort=stars

http://localhost:8080/sample/search?q=liferay-portal&sort=forks&order=asc

http://localhost:8080/sample/persons

http://localhost:8080/sample/json

=======================================

6 : GZip Compression the content :  com.github.ziplet.filter.compression.CompressingFilter

7 : Integrate Test cases : run command >> mvn clean test

