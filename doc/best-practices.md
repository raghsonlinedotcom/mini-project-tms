# Best Practices

## Pre-requisite

> We should maintain two different workspaces
> 1. Local Repo (connected with Git)
> 2. Development (for Eclipse)

## Pulling out the source from Remote - Steps 

* Issue a `git pull` in the right branch (`feature/xyz` or `main`) to update the contents of the local repo from the remote repo.
* Close the Eclipse
* Go to Development Workspace 
* See if you have a need to backup your `src` directory. If needed, please backup with a different and meaningful name by issuing `cp -r src src-DDMMMYYYY-<feature>`. Example : my backup was `src-28Dec2022-userProps`
* Remove the `src` directory. `rm -rf src`
* Go to the Local Repo
* Copy the src directory recursively to the Eclipse workspace. `cp -r src <ECLIPSE_DIR>/tmsmaven`
* Go to the Eclipse workspace directory in Command Line
* Do a Maven clean build with test `mvn clean test`, this way you can ensure that all the tests are run automatically andnothing fails/breaks in the recent code you pulled from the git remote. 
* Open Eclipse
* Select the Project, and click `Refresh`
* Do a Clean build in Eclipse on the project
* If it is a Web application, do a `Clean Work Directory` on the Web/App Server (Tomcat)
* Start the Server
* Verify the Application in the Browser by issuing `http://localhost:18080/tmsmaven/`

## Pushing the local changes to Remote - Steps 

* Ensure you verify/test all the functionalities
   * If it is a Web Application, run it in browser.
   * If it is a Java Application, run the normal "Run As -> Java Application"
   * You can also equally run the respective Test classes (preferably JUnit Tests)
* Run the Maven build `mvn clean test`
* Verify there are no errors and the build should be *successful*.
* Check whether you had deleted any files in the Development workspace as part of this feature.
* If Yes, you should remove the `src` directory in the Local Repo, so that the deletion will be marked.
* If you miss this, the deletion will NOT be marked. Refer: `known-issues-recursive-copy` exercise we performed
* Go to Local Repo in the terminal
* Verify the present working directory via `pwd` command and ensure you are in the root directory
  - Issue a `git pull` once to ensure that your local repo is up to date with the remote, else you would face the merge issue.
* On demand, clean up the `src` directory (based on the deletion of files)
* Recursive copy of the `src` from the Eclipse to Local repo `cp -r <ECLIPSE_DIR>/tmsmaven/src .`
* Issue a `git status` to understand the list of files modified/added/deleted.
  - If you had deleted any files, those files should be marked with the `DELETE` mode in the listing.
* Issue a `git diff` to verify the changes you had made in this feature. *BE PATIENT, SLOW, FOCUSSED AND DILIGIENT!*
  - If there were any mismatch in the alignment, formatting, rectify it.
  - If there are any changes performed in the portion of the source code written by *Others*, it is NOT welcomed. Please revoke them.  *IF YOU DONT OWN THE CODE, YOU DONT HAVE RIGHTS TO MODIFY IT - WHETHER DIRECLY OR INDIRECTLY*
  - Ensure all the other changes are intact and *AS EXPECTED/INTENDED*.
- Issue `git add .`
  - In case you don't want to add any common config files, which might hinder the application execution, for example, `dbconfig.properties`, OR `emailconfig.properties`, you can revoke those files individually by issuing `git restore --staged <PATH_TO_THE_FILE_FROM_ROOT_DIR>`. 
 - We can avoid this by adding such files into the `.gitignore` but this will NEVER in the traction and hence if you want to add any genuine config changes you make in the feature development, you would miss to check in. That is why, we don't follow this practice.
- Issue `git commit -m <JIRA-ID> - <TypeOfCommit> - <PRECISE_DESCRIPTION>`. Example, `git commit -m "TMS-64 - Interim Commit - Code Refactoring`.
- Issue `git push` to push the changes from your local repo to the remote repo.
- Issue `git log --oneline` to verify the commit history
  - If needed, you can add `-graph` to the command `git log --oneline --graph`
  - If you dont want to see the entire history (if it is long listing), you can add `-n <number>` to see ONLY the `n` number of commits.
