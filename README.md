# cicd-fargate-rds-api-gateway

## The *`README.md`* is different for each branch. Please read the instructions carefully

Please follow the numbering on each branch to track the progress step by step.
**This branch is step number 1**

The workflow of step 1 looks like this
![alt text](./Application_Flow.png "Application flow")

## Changes from last step [0-inmemory-springboot-api](https://github.com/S-Polimetla/cicd-fargate-rds-api-gateway/tree/0-inmemory-springboot-api)

1. CI/CD starts from this step. To deploy the Springboot Application on AWS using CodePipeline and Fargate, the configuration is added
2. The file [network-config.yaml](./cloudformation-generic/network-config.yaml) creates VPC and other network infrastructure necessary for deployment. This also contains security groups and LoadBalancer configuration.
3. The file [build-pipeline-docker-ecs.yaml](./cloudformation-generic/build-pipeline-docker-ecs.yaml) creates a CodePipeline and its necessary stages with resources. The deployment is done in the VPC created in the last step.
4. The Database here is embedded within the instance running and hence only available while the container is running.
5. Hence this solution is not really persistent and the scope is limited to the test environment.
6. The next step on branch [2-rds-fargate-secrets](https://github.com/S-Polimetla/cicd-fargate-rds-api-gateway/tree/2-rds-fargate-secrets) creates a PostgreSQL on RDS within the same VPC and the Fargate application connects to it.