# 52100813 - Huỳnh Thanh Liêm
# E - SpringCommerce
# About this project
- Short Desciption
> The project is building a E-Commerce using `Spring boot` (java) as backend, `mysql` as system database,and `reactjs` for frontend part.

> I built an website allow the admin can manange their product as well as sell it online.

- Features
> Use case
![hinh anh](./previews/usecase.png)
- Data management
> class diagram
![class_diagram](./previews/class_diagram.png)
- Development pricples
> The project is develop in Scrum, with the period is 1 week. Every week I will preview the project and plan for what to do in the next week.

- System architecture
> In backend I use monolithic architecture by building REST api

> In frontend part I building Single page application using reactjs

- Demo
> [Click me to view demo](https://drive.google.com/drive/folders/14LbKYMWyzgK59ZyFzle5ccqrzl_Rry8D?usp=sharing)

# About this repo
> This is backend part of the project
> I built with Spring Boot, Spring Data JPA, Spring Security, and MySQL
> The project is a simple e-commerce application
> This project contain some of unit tests is written with in Junit 5 and Mockito

> ![img.png](previews/unitest.png)

> And some api test using Postman
- login:
> ![img.png](previews/authenticate.png)
- get product by slug:
> ![img.png](previews/findBySlug.png)
- register:
> ![img.png](previews/register.png)
> The frontend part is in: [limbanga/shop](https://github.com/limbanga/shop)
- get order details:
> ![img.png](previews/getOrderDetails.png)
- filter products by various criteria:
> ![img.png](previews/filterProduct.png)
- And all CRUD operations for products, categories, and orders.
> Give me a star if you liked this :))
## Project Structure
- `src` - contains all the source code
- `src/controllers` - contains all the controllers
- `src/models` - contains all the models
- `src/config` - contains all the configurations
- `src/exceptionghandlers` - contains all the exception handlers
- `src/helpers` - contains all the helper functions
- `src/services` - contains all the services
- `src/repositories` - contains all the repositories
- `src/requests` - contains all the request DTO classes
- `src/respones` - contains all the response DTO classes
- `src/seeds` - contains seed data class
- `src/resources/application.yml` - contains configurations of the app
- `test` - contains all the test files

## How to Run this project
> required: java >= 21.x

> Steps
1. Clone this repo
2. Open the project in your favorite IDE
3. Configure the `application.yml` file
4. Run `mvn clean install`
5. Run `mvn spring-boot:run`

default admin credentials
```
username: admin@gmail.com
password: 123456
```
> Video guide how to run. [link](https://drive.google.com/drive/folders/14LbKYMWyzgK59ZyFzle5ccqrzl_Rry8D?usp=sharing)



