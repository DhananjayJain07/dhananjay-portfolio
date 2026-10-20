# AI Lead Management Automation

An n8n workflow starter that accepts a lead through a webhook, normalizes the payload, scores readiness using transparent rules, and returns a structured record for downstream CRM, email, or spreadsheet integrations.

## Included
- Importable n8n workflow JSON
- Webhook input contract and curl example
- Rule-based score and priority (no paid AI API required)
- Placeholders for optional AI enrichment and integrations

## Run
1. Install or start n8n using the official deployment guidance.
2. Import `workflow/lead-intake.json` in the n8n editor.
3. Use the test webhook URL while testing; activate to use the production webhook URL.
4. Send the sample request below.

```bash
curl -X POST 'http://localhost:5678/webhook-test/lead-intake' \
  -H 'Content-Type: application/json' \
  -d '{"name":"Asha Sharma","email":"asha@example.com","company":"Acme","need":"Spring Boot API development","budget":2500,"timeline":"30 days","source":"Fiverr"}'
```

## Input fields
Required: `name`, `email`, `need`. Optional: `company`, `budget`, `timeline`, `source`.

## Score rules
- +30 if budget is at least 1000
- +25 if timeline mentions 30 days, 1 month, or ASAP
- +20 if company is supplied
- +25 if need contains API, automation, cloud, or development
Priority: Hot (70+), Warm (40–69), otherwise Nurture.

## Production notes
Use synthetic demo data. Add webhook authentication, validation, rate limits, and retention rules before public use. Store API credentials in n8n credentials, not workflow JSON. This starter does not call an LLM or send emails by default; connect and test those nodes deliberately.
