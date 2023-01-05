# Frequently Used Commands for Reference 

## All these commands are executed in the Root/Top level directory of the Project
#### Development Workspace : ~/eclipse-workspace/tmsmaven
#### Version Control Workspae : ~/raghs/official/github-repos/mini-project-tms/

## Maven command to run a clean build, execute tests and Prepare site and the Surefire Reports
mvn clean package install test site surefire-report:report

## Command to copy the screenshots (of Sketchwow or SnagIt Images)
#### We need to be inside the screenshots directory 
cd screenshots
cp -r ~/raghs/official/training/SketchWow-Images-Docs/04Jan2023-Wed-Images .

## Command to do a recursive copy of the Development Workspace to the Version Control
## Ensure we remove the `src` directory in case we made any deletions, for effectively marking them
rm -rf src
cp -r ~/eclipse-workspace/tmsmaven/src . 

## Git Commands
git checkout -b "feature/<feature>"
git push --set-upstream-to=origin/feature/<feature>
git status
git diff
git add .
git commit -m "<meaningful-message>"
git push 
git log --oneline 
git log --oneline --graph
git log --oneline -n 5 # to see the top/latest 5 commit entries

