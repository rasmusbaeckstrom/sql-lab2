## Laboration 2 - Spring Boot Rest API with Database Persistence

### Start the Application

1. **Start Docker Engine**:
   Ensure Docker is installed and running on your machine.

2. **Run the Application**:
   Start the Spring Boot application (`SqlLab2Application`).

3. **Connect to Database**:
   Connect to the `mydatabase` database.

4. **Manually Insert Schema**:
   Execute the `schema.sql` script to create the necessary tables.

5. **Manually Insert Data**:
   Execute the `data.sql` script to populate the database with initial data.

### API Endpoints and Examples

#### Categories

- **GET**: Get all categories or a specific category.
  - `/api/categories`
  - `/api/categories/1`

  ```json
  {
      "id": 1,
      "name": "Restaurants",
      "symbol": "🍽️",
      "description": "Places to eat and dine"
  }
  ```

- **POST**: Create a new category (requires admin role).
  - `/api/categories`

  ```json
  {
      "name": "Flower shops",
      "symbol": "🌷",
      "description": "Places to buy your flowers"
  }
  ```

#### Places

- **GET**: Get all public places or a specific public place (for anonymous users).
  - `/api/places`
  - `/api/places/1`

- **GET**: Get all public places within a specific category.
  - `/api/places/category/1`

- **GET**: Get all places (both public and private) for the signed-in user.
  - `/api/places/user/rasmus`

- **GET**: Get all places within a certain area.
  - `/api/places/radius?latitude=59.3293&longitude=18.0686&radius=0`

  ```json
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
  ```

- **POST**: Create a new place.
  - `/api/places`

- **PUT**: Update a place.
  - `/api/places/1`

  ```json
  {   
      "name": "The Gourmet Bistro",
      "userId": "rasmus",
      "isPublic": true,
      "description": "A fine dining experience with a selection of international cuisines.",
      "longitude": 18.0686,
      "latitude": 59.3293,
      "category": {
        "id": 1
      }
  }
  ```

- **DELETE**: Delete a place (soft delete).
  - `/api/places/1`
