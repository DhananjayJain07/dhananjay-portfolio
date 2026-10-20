# Expense Management REST API

A portfolio-ready Java 17 / Spring Boot REST API for managing personal expenses. Demonstrates layered architecture, DTO validation, persistence, API error handling, Docker, PostgreSQL, and CI.

## Features
- Create, list, view, update, and delete expenses
- Filter by category and date range
- Bean Validation and consistent JSON errors
- PostgreSQL via Docker Compose; H2 for tests
- OpenAPI/Swagger UI and GitHub Actions test workflow

## Run locally
Prerequisites: Java 17+, Maven 3.9+, Docker (optional).

```bash
cp .env.example .env
docker compose up --build
```
API: http://localhost:8080/api/expenses  
Swagger UI: http://localhost:8080/swagger-ui.html

Without Docker: `mvn spring-boot:run` (uses H2 by default). Run tests with `mvn test`.

## Example
```bash
curl -X POST http://localhost:8080/api/expenses -H 'Content-Type: application/json' -d '{"title":"Internet bill","amount":799.00,"category":"UTILITIES","expenseDate":"2026-10-20","notes":"Home broadband"}'
curl http://localhost:8080/api/expenses
```

## Endpoints
| Method | Path | Description |
|---|---|---|
| GET | /api/expenses | List, optional `category`, `from`, `to` |
| GET | /api/expenses/{id} | Fetch one |
| POST | /api/expenses | Create |
| PUT | /api/expenses/{id} | Replace editable fields |
| DELETE | /api/expenses/{id} | Delete |

## Project structure
`controller` handles HTTP; `service` holds business logic; `repository` uses Spring Data JPA; `dto` validates input; `exception` standardizes failures.

## Production hardening ideas
Add authentication/authorization, pagination, migrations (Flyway), structured logs, metrics, rate limiting, and cloud deployment. This sample is for demonstration and is not a financial product.
