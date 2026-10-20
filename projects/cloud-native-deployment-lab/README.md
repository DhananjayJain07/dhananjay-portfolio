# Cloud-Native Deployment Lab

A deployable Spring Boot sample plus Docker, Kubernetes, Terraform (AWS EKS foundation), and CI workflow examples. Intended to demonstrate practical delivery skills; infrastructure is not created automatically.

## Layout
- `app/`: minimal Spring Boot service
- `docker/`: container build
- `k8s/`: Deployment and Service manifests
- `terraform/`: configurable VPC and EKS cluster foundation
- `.github/workflows/ci.yml`: build and test app

## Run app
Requires Java 17 and Maven 3.9+.
```bash
cd app && mvn test
mvn spring-boot:run
curl http://localhost:8080/actuator/health
```
Build container from repository root: `docker build -f docker/Dockerfile -t cloud-lab:local app`.

## Kubernetes
Build and push the image to your registry, update `image:` in `k8s/deployment.yaml`, then:
```bash
kubectl apply -f k8s/
kubectl rollout status deployment/cloud-lab
kubectl port-forward service/cloud-lab 8080:80
```

## Terraform safety
Terraform provisions billable AWS resources. Review and set variables, configure AWS credentials securely, run `terraform plan`, and only apply if you understand the estimated cost. Run `terraform destroy` when finished. Never commit credentials or state files.
```bash
cd terraform
terraform init
terraform fmt -check
terraform validate
terraform plan
```
This is a learning scaffold; configure state locking, private subnets, IAM least privilege, logging, budgets, and production networking before real workloads.
