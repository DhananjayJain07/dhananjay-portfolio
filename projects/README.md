# Portfolio Projects

These are independent demonstration projects built to showcase backend engineering, cloud-native delivery, and workflow automation. They use synthetic data and are separate from employer code.

## 1. Expense Management REST API
**Stack:** Java 17, Spring Boot, Spring Data JPA, Bean Validation, H2, PostgreSQL, Docker Compose, GitHub Actions.

A CRUD REST API with validation, filtering, consistent error responses, OpenAPI/Swagger documentation, integration tests, and containerized PostgreSQL setup.

- [Project README](expense-management-api/README.md)
- [Architecture notes](expense-management-api/docs/ARCHITECTURE.md)
- [API examples](expense-management-api/docs/API_EXAMPLES.md)

## 2. Cloud-Native Deployment Lab
**Stack:** Java 17, Spring Boot Actuator, Docker, Kubernetes, Terraform, AWS EKS, GitHub Actions.

A sample service with health probes, resource limits, a non-root container, Kubernetes manifests, and a Terraform starter for an AWS VPC/EKS lab.

- [Project README](cloud-native-deployment-lab/README.md)
- [Kubernetes manifests](cloud-native-deployment-lab/k8s/deployment.yaml)
- [Terraform configuration](cloud-native-deployment-lab/terraform/main.tf)

**Cost note:** Applying Terraform can create billable AWS resources. Review the plan and destroy lab resources when finished.

## 3. Lead Intake and Qualification Automation
**Stack:** n8n, Webhooks, JavaScript.

An importable workflow that validates lead data, calculates a transparent qualification score, assigns a priority, and returns a suggested next action. AI/CRM/email integrations are intentionally left optional rather than pretending they are already connected.

- [Project README](ai-lead-management-automation/README.md)
- [Importable workflow JSON](ai-lead-management-automation/workflow/lead-intake.json)
- [Webhook contract](ai-lead-management-automation/docs/WEBHOOK_CONTRACT.md)

## Before showcasing on Fiverr
Run the projects locally, capture genuine screenshots, add a short demo video, and describe exactly what is implemented. Do not claim a cloud deployment or external integration unless you have configured and tested it.
