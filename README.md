# Category-Product-Management-System
This project is a Spring Boot application that provides RESTful APIs for managing categories and products. It allows you to perform CRUD (Create, Read, Update, Delete) operations on a category and product entity using MySql as the database. It leverages OpenAPI (Swagger) for API documentation and Maven as the build tool. 

## Prerequisites
* Java 17
* Maven 3.8.8
* MySQL
* Spring Tool Suite (STS) or any IDE of your choice

## API Endpoints
The following CRUD operations are available for the Categories entity:
* Create a Category
  - POST `/api/categories`
  - Request Body:
  ```json
  {
    "name": "Electronics"
  }

* Get All Category
  - GET `/api/categories`
  
*  Get Category by ID
   -  GET `/api/categories/{id}`

* Update Category
  -  PUT `/api/categories/{id}`
  -  Request Body:
  
  ```json
  {
  "name": "Men's Clothing"
  }

*   Delete a Category
    - DELETE `/api/categories/{id}`

The following CRUD operations are available for the Products entity:
*  Create a Product
    -  POST `/api/products`
    -  Request Body:
   ```json
    {
      "name": "Smartphone",
      "price": 799.99,
      "category": {
        "id": 1
      }
    }

  * Get Product by ID
      - GET `/api/products/{id}`

  * Update a Product
     - PUT `/api/products/{id}`
    -  Request Body:
    ```json
    {
      "name": "Laptop",
      "price": 12999.99,
      "category": {
        "id": 1
      }
    }

*   Delete a Product
  -    DELETE `/api/products/{id}`

## API Documentation
Once the application is running, you can access the Swagger UI to explore the API documentation: `https://localhost:8080/swagger-ui.html`

## Dependencies
* Spring Boot Starter Data JPA
* Spring Boot Starter Web
* Spring Boot Starter Test
* Springdoc OpenAPI UI
* Spring Boot DevTools
* H2 Database
* Lombok
* MySQL Connector/J

## Contact
For any issues or inquiries, please contact [deoreharshal711@gmail.com].


