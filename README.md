# Souvenir shop app

This application is a basic version of application for a small business owners (e.g. a souvenir shop) who would like to collect an information about their income and get annual income statistics. Application uses H2 in memory database for saving information about purchases.

## Getting started
### Prerequisites
In order to run this application you will need
- Git
- JDK 11
- Maven 3.3 or later
- Spring Boot 2.1

### Clone
At first you should clone project by Git using URL
`git clone https://github.com/nazarvladyka/souvenir_shop.git`

### Build an run
To run this application you will need to run this app in your IDE, and edit configuration:
1. set *environment variable* (**accessKey** = [yourKey]), (e.g. **accessKey** = x7xg6gfh7fgfch6fhff6hdfh8), this key you can get from http://fixer.io (register for a free plan).
2. Run application.

### Endpoints
If you have Postman you can "Import by Link" this colletion: https://www.getpostman.com/collections/2f215b0fb8a06f84b28d

------------



- **AUTOPOPULATE** (Add 5 purchases to the DB)

**[GET]** `localhost:8080/purchase/autopopulate`

- **ADD PURCHASE**

**[POST]** `localhost:8080/purchase`
*e.g. body:*
```json
{
    "date": "2017-04-30",
    "price": 29,
    "currency": "PLN",
    "productName": "Magnit"
}
```
*e.g. response:*
```json
{
    "dailyPurchases": [
        {
            "date": "2017-04-30",
            "purchases": [
                {
                    "productName": "Beer",
                    "price": 25,
                    "currency": "EUR"
                },
                {
                    "productName": "Magnit",
                    "price": 29,
                    "currency": "PLN"
                }
            ]
        },
        {
            "date": "2018-03-25",
            "purchases": [
                {
                    "productName": "Photo",
                    "price": 2.5,
                    "currency": "USD"
                }
            ]
        }
    ]
}
```
------------

- **GET ALL PURCHASES**

**[GET]**  `localhost:8080/purchase/all`

*e.g. response:*
```json
{
    "dailyPurchases": [
        {
            "date": "2017-04-30",
            "purchases": [
                {
                    "productName": "Beer",
                    "price": 25,
                    "currency": "EUR"
                },
                {
                    "productName": "Like",
                    "price": 29,
                    "currency": "PLN"
                }
            ]
        },
        {
            "date": "2018-03-25",
            "purchases": [
                {
                    "productName": "Photo",
                    "price": 2.5,
                    "currency": "USD"
                }
            ]
        }
    ]
}
```
------------
- **CLEAR**

**[DELETE]** `localhost:8080/purchase/clear?date=2018-03-25`

*e.g. response:*
```json
{
    "dailyPurchases": [
        {
            "date": "2017-04-30",
            "purchases": [
                {
                    "productName": "Beer",
                    "price": 25,
                    "currency": "EUR"
                },
                {
                    "productName": "Like",
                    "price": 29,
                    "currency": "PLN"
                }
            ]
        }
    ]
}
```
------------

- **REPORT**

**[GET]** `localhost:8080/report?year=2019&currency=USD`

*e.g. response:*
```json
{
    "sum": 28.84,
    "currency": "USD"
}
```
Author: [Nazar Vladyka](https://github.com/nazarvladyka "Nazar Vladyka")
nazarvladyka00@gmail.com