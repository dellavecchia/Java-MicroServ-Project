# Product-Micro-services-Project
*This is a project of a simple microservices system, with 2 services (Product-ms and Warehouse-ms), CRUD and business rules.*


# Product-ms

## Endpoints
- BaseURL: /products
- POST: create()
- GET: getAll()
- GET /{id}: getById()
- PUT /{id}: update()
- DELETE /{id}: inactive()

## Model
```json
{
    "id": 1,
    "name": "PlayStation 5",
    "description": "Sony last generation console",
    "price": 3499.90,
    "isAvailable": true
}
```

## Business Rules
- It is only possible to create products with a positive value of price; 
- It's not possible to search products that aren't available;
- It's not possible to insert descriptions with less than 50 characters. (@Size)

# Warehouse-ms

## Endpoints
- BaseURL: /warehouses
- POST: create()
- GET: getAll()
- GET /{id}: getById()
- PUT /{id}: update()


## Model
```json
{
    "id": 1,
    "productid": 1,
    "quantity": 10,
}
```
## Business Rules
- The warehouse is responsible for notifying if a product is available or not. So, if the quantity = 0, the warehouse should notify the "product-ms" service;
- Isn't allowed more than one line of the same product on the database.

