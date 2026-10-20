# Webhook contract

**Method:** POST  
**Path:** `/webhook/lead-intake`  
**Content-Type:** `application/json`

Example request:
```json
{
  "name": "Asha Sharma",
  "email": "asha@example.com",
  "company": "Acme",
  "need": "Spring Boot API development",
  "budget": 2500,
  "timeline": "30 days",
  "source": "Fiverr"
}
```

Successful response includes normalized fields, numeric score, priority, received timestamp, and next action. Missing name/email/need or invalid email raises a workflow error. For a public production webhook, add authentication, request-size limits, and controlled error handling before integrating external services.
