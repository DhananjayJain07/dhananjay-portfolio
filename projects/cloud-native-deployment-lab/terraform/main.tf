provider "aws" {
  region = var.aws_region
}
data "aws_availability_zones" "available" { state = "available" }
module "vpc" {
  source = "terraform-aws-modules/vpc/aws"
  version = "5.19.0"
  name = "${var.project_name}-vpc"
  cidr = "10.0.0.0/16"
  azs = slice(data.aws_availability_zones.available.names, 0, 2)
  private_subnets = ["10.0.1.0/24", "10.0.2.0/24"]
  public_subnets = ["10.0.101.0/24", "10.0.102.0/24"]
  enable_nat_gateway = false
  enable_dns_hostnames = true
  tags = { Project = var.project_name, ManagedBy = "Terraform" }
}
module "eks" {
  source = "terraform-aws-modules/eks/aws"
  version = "20.37.1"
  cluster_name = "${var.project_name}-eks"
  cluster_version = "1.31"
  vpc_id = module.vpc.vpc_id
  subnet_ids = module.vpc.private_subnets
  enable_cluster_creator_admin_permissions = true
  eks_managed_node_groups = {
    general = { instance_types = ["t3.medium"], min_size = 1, max_size = 2, desired_size = 1 }
  }
  tags = { Project = var.project_name, ManagedBy = "Terraform" }
}
output "cluster_name" { value = module.eks.cluster_name }
output "cluster_endpoint" { value = module.eks.cluster_endpoint }