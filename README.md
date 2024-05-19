# Challenge Loans

This project is one of several possible solutions to the challenge created by [backend-br](https://github.com/backend-br/desafios)

## 💡 Tech List 💡

* Java 21
* Spring Boot 3
* JUnit
* Clean Arch

## Run with Docker
```
docker build . -t loans-service

docker run loans-service
```

## Run with docker-compose

```
docker-compose up --build 
```

## Try out

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

### Developed by eckelp
