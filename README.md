Laboration 2 - Spring Boot Rest API with database persistence.

-------------------------------------


Start the application:

Start docker engine
Run the application (SqlLab2Application)
Connect to database (mydatabase)
Manually insert schema.sql
Manually insert data.sql

-------------------------------------

API endpoints and examples:

GET: Get all categories or specific category.
/api/categories
/api/categories/1

{
    "id": 1,
    "name": "Restaurants",
    "symbol": "🍽️",
    "description": "Places to eat and dine"
}

POST: Create a new category (requires admin role).
/api/categories

{
    "name": "Flower shops",
    "symbol": "🌷",
    "description": "Places to buy your flowers"
}

GET: Get all public places or specific public place (for anonymous users).
/api/places
/api/places/1

GET: Get all public places within specific category.
/api/places/category/1

GET: Get all places (both public and private) for signed-in user.
/api/places/user/rasmus

GET: Get alla places within a certain area.
/api/places/radius?latitude=59.3293&longitude=18.0686&radius=0

{
    "id": 1,
    "name": "The Gourmet Bistro",
    "userId": "rasmus",
    "isPublic": true,
    "description": "A fine dining experience with a selection of international cuisines.",
    "longitude": 18.0686,
    "latitude": 59.3293,
    "category": {
      "id": 1,
      "name": "Restaurants",
      "symbol": "🍽️",
      "description": "Places to eat and dine"
    }
}

POST: Create a new place.
/api/places

PUT: Update a place. 
api/places/1

{   
    "name": "The Gourmet Bistro",
    "userId": "rasmus",
    "isPublic": true,
    "description": "A fine dining experience with a selection of international cuisines.",
    "longitude": 18.0686,
    "latitude": 59.3293,
    "category": {
      "id": 1,
    }
}

DELETE: Delete a place (soft delete). 
api/places/1
