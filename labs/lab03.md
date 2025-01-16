### Lab 03
* Create Spring Boot REST API (**lab03-api**) for managing a simple inventory system that tracks product restocking and sales.
* No need for database integration; the service will mock data storage.
* Write unit tests for the **ProductService** and **ProductController** using Mockito. Use mocks to simulate behavior and interactions with a mock repository. 

#### Requirements
* ProductController -> ProductService -> Product

* Product Attributes: String id (unique identifier); String name; int quantity (current stock)

* REST Endpoints:
 
```
GET /products/{id}: Fetch details of a specific product by its ID.
```
<hr/>

```
POST /products/restock: Restock a product with additional quantity.
```

* Request Body:
```json
{
  "id": "123",
  "quantity": 10
}
```
<hr/>

```
POST /products/sell: Record a sale of a product, reducing its stock.
```
``` json
{
  "id": "123",
  "quantity": 5
}
```

* **Service**: ProductService

```
Product getProductById(String id) returns the product by ID.
void restockProduct(String id, int quantity) increases the product stock.
void sellProduct(String id, int quantity) decreases the product stock, throws an exception if the requested quantity is greater than available stock. (HTTP Status: 400 Bad Request; Message: "Insufficient stock for product with ID: {id}")
```

