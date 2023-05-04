# Product-Micro-services-Project
*This is a project of a simple micro-services system, with 2 services (Products and Warehouse), CRUD and business rules.*


# Products-ms

## Endpoints
- BaseURL: /products
- POST: create()
- GET: getAll()
- GET /{id}: getById()
- PUT /{id}: update()
- DELETE /{id}: delete()

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
- It's only possible to create products with a positive value of price;
- It's not possible to search products that aren't available;
- It's not possible to insert descriptions with less than 50 characters.

# Warehouses-ms

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

