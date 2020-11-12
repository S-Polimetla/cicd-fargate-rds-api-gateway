# cicd-fargate-rds-api-gateway

## The *`README.md`* is different for each branch. Please read the instructions carefully

Please follow the numbering on each branch to track the progress step by step.
**This branch is step number 3**

The workflow for step3 looks like this
![alt text](./Application_Flow.png "Application flow")

## Changes from last step [2-rds-fargate-secrets](https://github.com/S-Polimetla/cicd-fargate-rds-api-gateway/tree/2-rds-fargate-secrets)

1. In the previous step, the API is only reachable through the public facing LoadBalancer without any authentication. In this step, the ELB is mapped to a API Gateway.
2. [api-config.yaml](./cloudformation-generic/api-config.yaml) creates Api Gateway configuration such as API Key, Api Domain and a Usage Plan. Custom Domain Name DNS configuration is managed by Route53 before creating this stack.
3. [swagger.yaml](./swagger.yaml) has the configuration to create a API deployed on API Gateway. 
4. The API has a custom domain name which is easier to use and maintain than a AWS generated one. One of the parameters required for this stack creation is HostedZoneId which is a alphanumeric value attached to each HostedZone. This can be obtained from Route53 console. 
5. To start using the API with API Gateway, the deployed API and its stage should be added to the Usage Plan using Api Gateway console manually.
6. The API is now accessible via API Gateway using a valid API key.  

## _Note_

The API definition will have the following as mandatory fields for POST requests.

````
    required:
      - firstName
      - lastName
      - age
````
This means, any API request which do not fulfill the criteria either by omitting these fields or with inappropriate data types will be filtered out at API gateway without even reaching the Application layer.

### If you are starting with the branch directly, here is the order of creation of resources

1. [network-config.yaml](./cloudformation-generic/network-config.yaml)
2. [rds-database.yaml](./cloudformation-generic/rds-database.yaml) twice. One for each environment
3. [api-config.yaml](./cloudformation-generic/api-config.yaml) twice. One for each environment
3. [build-pipeline-docker-ecs.yaml](./cloudformation-generic/build-pipeline-docker-ecs.yaml)