# API examples

Set `BASE=http://localhost:8080/api/expenses`.

## Create
```bash
curl -i -X POST "$BASE" -H 'Content-Type: application/json' -d '{"title":"Internet bill","amount":799.00,"category":"UTILITIES","expenseDate":"2026-10-20","notes":"Home broadband"}'
```

## Filter
```bash
curl "$BASE?category=UTILITIES"
curl "$BASE?from=2026-10-01&to=2026-10-31"
```

## Update and delete
```bash
curl -X PUT "$BASE/1" -H 'Content-Type: application/json' -d '{"title":"Updated bill","amount":850.00,"category":"UTILITIES","expenseDate":"2026-10-20","notes":"Updated amount"}'
curl -i -X DELETE "$BASE/1"
```

A missing ID returns HTTP 404. Invalid request fields return HTTP 400 with field-level details.
