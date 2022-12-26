#!/bin/bash

## A Script to automate the Maven packaging and copying the files to remote (AWS EC2) via SCP

## Assume you would run this script in the project root folder where the `pom.xml` file is present

cd ../../..
echo "verifying the pom.xml file"
ls -ltrh pom.xml
echo "Running Maven Packaging..."
mvn clean install
echo "Maven packaging was completed."
cd target
echo "Copying the .war file without version in the name"
cp TMS-1.0.war TMS.war
echo "Time to deploy the .war file to AWS EC2 via SSH. Ensure you are connected to VPN"
scp TMS.war raghavan.muthu@10.121.1.241:/home/raghavan.muthu/scp-files
# cd ~/raghs/scripts
# echo "Running the shell script to connect to EC2"
# ./connectToEC2Sandbox.sh
# echo "Equivalent alternate is : ssh 10.121.1.241"
ssh 10.121.1.241
