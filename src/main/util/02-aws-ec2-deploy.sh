#!/bin/bash

## A Script to automate the Deployment to AWS EC2 Tomcat

## Assume you would run this script in the user's home directory where you 
## have a directory named `scp-files` to accommodate all the files being
## pushed from the local machine

echo "changing to the scp-files directory"
cd ~/scp-files
echo "listing the files of our choice."
ls -ltrh TMS.war
echo "Stop the server for betterment"
cd ~/soft/apache-tomcat-9.0.65/bin
./shutdown.sh
echo "deleting the previous instance of the .war file and the exploded directory"
cd ../webapps
rm -rf TMS*
echo "verifying the files if there is any matching with the .war file name"
ls -ltrh TMS*
echo "Moving to the ~/scp-files directory"
cd ~/scp-files
echo "Copying the .war file to Tomcat in AWS EC2"
cp TMS.war ~/soft/apache-tomcat-9.0.65/webapps/
echo "Start the server now"
cd ~/soft/apache-tomcat-9.0.65/bin
./startup.sh
cd ~/soft/apache-tomcat-9.0.65/webapps/
echo "verifying the exploded folder after the server start"
ls -ltrh TMS*
echo "Time to check the application. "
echo "Go to http://10.121.1.241:8080/TMS URL in the browser in the local machine"
