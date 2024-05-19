# Challenge Loans With Clean Arch

This project is one of several possible solutions to the challenge created by [backend-br](https://github.com/backend-br/desafios)

## Getting Started

### Java Version
This project uses `Java 21`

### Run with Docker
```
docker build . -t loans-service

docker run loans-service
```

### Run with docker-compose

```
docker-compose up --build 
```

### Try out

**[POST]** `{{host}}/customer-loans`

```json
{
  "age": 18,
  "cpf": "000.000.000-00",
  "name": "Customer Name",
  "income": 1000.00,
  "location": "SP"
}
```
