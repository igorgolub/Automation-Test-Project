## Set up CI CD pipeline for Automation-Test-Project with github action
#### Prerequisites
- Sign up an GitHub Account
- Install git on your local machine
- Maven project with junit

#### Step 1 - Create a new public repository
- Sign in to github https://github.com/
- Click on button '+' and select 'New repository'
- Input name for repository Automation-Test-Project
- Choose option 'public' 
- Click button 'Create repository' at the end of the page to create new repository
#### Step 2 - Link the Automation-Test-Project project to repository
- Open gitbash, navigate to project folder Automation-Test-Project

- Initialize the local directory as a Git repository.
`git init`

- Add the files in your new local repository. This stages them for the first commit.
`git add .`
or:
`git add --all`

- Commit the files that you've staged in your local repository.
`git commit -m 'First commit'`

- Remote the local repository to the remote one
`git remote add origin <remote repository URL>`

- Push the changes in your local repository to GitHub.
`git push origin master`

#### Step 3 - Create pipeline action 
- Select to open Automation-Test-Project repository
- Click button 'Actions'
- On the "Java with Maven" workflow, click Configure.
- Github show the workflow sample for maven project, you can change to match your workflow.
- Click Commit changes. The maven.yml workflow file is added to the .github/workflows directory of Automation-Test-Project repository. I have modified the maven.yml as below;

```sh
# This workflow will build a Java project with Maven, and cache/restore any dependencies to improve the workflow execution time
# For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven

# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.

name: Automation-Test-Project CICD

on:
  push:
    branches: [ "master" ]
  pull_request:
    branches: [ "master" ]

jobs:
  buid-test:
    runs-on: ubuntu-latest

    permissions:
      checks: write
      pull-requests: write
    
    steps:
      - name: Checkout
        uses: actions/checkout@v4      
                          
      - name: Build project 
        run: javac src/main/java/com/example/logic/*.java
        
      - name: Run test
        run: mvn verify
          
      - name: Generate html report
        if: success() || failure()
        run: mvn site
        
      - name: Publish Test Results
        uses: EnricoMi/publish-unit-test-result-action@v2        
        with:
         files: 
          target/surefire-reports/TEST-com.example.testcases.TestHelloWorld.xml 
```
>Notes:
 Github action file use extension .yml or .yaml
 >
 `name: Automation-Test-Project CICD`
 Name of workflow, you can modify your workflow name
 
`on` Specifies the trigger for this workflow. In our case, the trigger runs the workflow if there is a push on 'master' branch or 'pull-request' merged to master branch
 
`jobs` List of jobs used in workflow

`buid-test:` Name of the job
 
`runs-on: ubuntu-latest` Configures the job to run on the latest version of an Ubuntu Linux runner. Github supply us some runners on ubuntu, window or macOs (ubuntu-latest, ubuntu-22.04, windows-latest, macos-latest...). We need to define run-ons on for every job by using github runners or self-hosted runners
 ```sh
permissions:
checks: write
pull-requests: write
```
Set permissions for the job, it uses in puplish report step on the workflow
```sh
steps
 - name: Checkout`
   uses: actions/checkout@v4`
```  
Step name is 'Checkout', in this step we use 'actions/checkout@v4' supply by github. This is an action that checks out your repository onto the runner

```sh
 - name: Build project 
   run: javac src/main/java/com/example/logic/*.java
```
Step Build project, using 'run' command to build the java project

```sh
- name: Run test
  run: mvn verify
```
Step for executing the testcases using maven command

```sh
 - name: Generate html report
   if: success() || failure()
   run: mvn site
```
 `if: success() || failure()` Set condition for running this step, it is not depend on previous step result
 `run: mvn site` Generate the surfire report from the test result 
 
 ```sh
 - name: Publish Test Results
        uses: EnricoMi/publish-unit-test-result-action@v2        
        with:
          files: 
          target/surefire-reports/TEST-com.example.testcases.TestHelloWorld.xml 
  ```
`uses: EnricoMi/publish-unit-test-result-action@v2` This GitHub Action analyses test result files and publishes the results on GitHub
`files: target/surefire-reports/TEST-com.example.testcases.TestHelloWorld.xml` The path of report file. It supports JSON, TRX and XML file formats, and runs on Linux, macOS and Windows

## How to run the workflow
Pulic repository
https://github.com/camthinguyen/Automation-Test-Project
#### Step 1 - Pull code Automation-Test-Project from git repository
- Create folder 'Automation-Test-Project' on your local machine
- Open gitbash
- Navigate to your directory 'Automation-Test-Project'
- Use git init command creates a new Git repository. 
`git init`
- Pull code from git repo `Automation-Test-Project`
`git pull git@github.com:camthinguyen/Automation-Test-Project.git`
#### Steps 2: Change code and push it to github
- You can change existing code or add new file (Ex. Change file Automation-Test-Project\src\main\java\com\example\logic\HelloWorld.java)
- Commit and push code to github
`git add .`
`git commit -m "Add more function"`
`git remote add origin git@github.com:camthinguyen/Automation-Test-Project.git`
`git push origin master`
#### Step 3: View the report
After commit code successful, an workflow will be trigger to be run and the test result will be puplish on github page
https://github.com/camthinguyen/Automation-Test-Project/actions
https://github.com/camthinguyen/Automation-Test-Project/actions/runs/8797295968/job/24141890540

Reference: https://docs.github.com/en/actions
