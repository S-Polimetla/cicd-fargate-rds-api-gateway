# The *`README.md`* is different for each branch. Please read the instructions carefully

Please follow the numbering on each branch to track the progress step by step.
**This branch is step number 0**

# cicd-fargate-rds-api-gateway
This is a pure Springboot Application with a runtime DB which can be run as a docker container

## For local testing
Clone the repository.  Make sure you have Java11 and Docker installed.  If you do not want to install Java11, you may chose to mount the project onto a docker container based on openjdk:11 and docker installed.

Run the following commands
````
mvn clean install
docker build -t <Your-Image-Name>:<Your-Tag> .
docker run -p 8080:8080 <Your-Image-Name>:<Your-Tag>
````

Once the docker container starts running, you can test it on `localhost:8080/employees`.  At start you would not have any data. Create data using `POST` requests.

The CI/CD part starts from the next step on branch [1-cicd-fargate-inmemory-db](https://github.com/S-Polimetla/cicd-fargate-rds-api-gateway/tree/1-cicd-fargate-inmemory-db)