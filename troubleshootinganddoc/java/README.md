# Testing Employee API with curl

## Get All Employees
```sh
curl -X GET http://localhost:8080/api/employees
```

## Get Employee by ID
```sh
curl -X GET http://localhost:8080/api/employees/{id}
```
Replace `{id}` with the actual employee ID.

## Create a New Employee
```sh
curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d '{
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com"
}'
```

## Update an Existing Employee
```sh
curl -X PUT http://localhost:8080/api/employees/{id} -H "Content-Type: application/json" -d '{
  "name": "Jane",
  "surname": "Doe",
  "email": "jane.doe@example.com"
}'
```
Replace `{id}` with the actual employee ID.

## Delete an Employee
```sh
curl -X DELETE http://localhost:8080/api/employees/{id}
```
Replace `{id}` with the actual employee ID.
```