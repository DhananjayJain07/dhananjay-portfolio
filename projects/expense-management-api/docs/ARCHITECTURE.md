# Architecture

The service follows a small layered Spring Boot design:

```text
HTTP client
  -> ExpenseController (routes, query parameters)
  -> ExpenseService (use cases and date-range validation)
  -> ExpenseRepository (Spring Data JPA)
  -> H2 for local/test runs or PostgreSQL in Docker Compose
```

The request DTO separates API input from the persistence entity and applies Bean Validation. `GlobalExceptionHandler` maps missing records to HTTP 404, invalid inputs to HTTP 400, and validation failures to a field-level details map.

## Data model
Expense: id, title, amount (decimal), category, expenseDate, notes.

## Deliberate demo limitations
This is a single-user portfolio sample. It does not implement login, authorization, paging, currency conversion, or database migrations. Add those before treating it as a production service.
