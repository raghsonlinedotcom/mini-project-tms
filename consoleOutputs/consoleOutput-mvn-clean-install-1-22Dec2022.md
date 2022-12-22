```sh
➜  TMS mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.raghsonline.tutorials:tms >--------------------
[INFO] Building tms 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The artifact mysql:mysql-connector-java:jar:8.0.31 has been relocated to com.mysql:mysql-connector-j:jar:8.0.31: MySQL Connector/J artifacts moved to reverse-DNS compliant Maven 2+ coordinates.
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ tms ---
[INFO] Deleting /Users/raghavan.muthu/eclipse-workspace/TMS/target
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ tms ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ tms ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 10 source files to /Users/raghavan.muthu/eclipse-workspace/TMS/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ tms ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/raghavan.muthu/eclipse-workspace/TMS/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ tms ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 11 source files to /Users/raghavan.muthu/eclipse-workspace/TMS/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ tms ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.tutorials.tms.junit.EmployeeDAOTest
File Object : /Users/raghavan.muthu/eclipse-workspace/TMS/target/classes/config.properties
File Path : /Users/raghavan.muthu/eclipse-workspace/TMS/target/classes/config.properties
Properties has been loaded successfully with # 1 entries
File Object : /Users/raghavan.muthu/eclipse-workspace/TMS/target/classes/dbconfig.properties
File Path : /Users/raghavan.muthu/eclipse-workspace/TMS/target/classes/dbconfig.properties
Properties has been loaded successfully with # 4 entries
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.187 s - in com.tutorials.tms.junit.EmployeeDAOTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ tms ---
[INFO] Building jar: /Users/raghavan.muthu/eclipse-workspace/TMS/target/tms-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ tms ---
[INFO] Installing /Users/raghavan.muthu/eclipse-workspace/TMS/target/tms-1.0-SNAPSHOT.jar to /Users/raghavan.muthu/.m2/repository/com/raghsonline/tutorials/tms/1.0-SNAPSHOT/tms-1.0-SNAPSHOT.jar
[INFO] Installing /Users/raghavan.muthu/eclipse-workspace/TMS/pom.xml to /Users/raghavan.muthu/.m2/repository/com/raghsonline/tutorials/tms/1.0-SNAPSHOT/tms-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.060 s
[INFO] Finished at: 2022-12-22T00:28:29+05:30
[INFO] ------------------------------------------------------------------------
➜  TMS 
```
