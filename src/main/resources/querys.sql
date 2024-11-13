-- Category table
INSERT INTO category (name, symbol, description)
VALUES ('Restaurants', '🍽️', 'Places to eat and dine');

INSERT INTO category (name, symbol, description)
VALUES ('Grocery Stores', '🛒', 'Places to buy food and other essentials');

INSERT INTO category (name, symbol, description)
VALUES ('Pharmacies', '💊', 'Places to buy medicine and health products');

INSERT INTO category (name, symbol, description)
VALUES ('Gym and Fitness', '🏋️', 'Places to exercise and stay fit');

-- Places table for the category 'Restaurants'
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Joe\'s Diner', 1, 1, true, '2023-10-10 12:00:00', 'A cozy place for breakfast and lunch', 'POINT(40.7128 -74.0060)', '2023-10-10 12:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Bella Italia', 1, 1, true, '2023-10-11 15:00:00', 'An Italian restaurant with authentic pasta dishes', 'POINT(40.7132 -74.0059)', '2023-10-11 15:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Sushi World', 1, 2, true, '2023-10-12 18:00:00', 'A Japanese sushi bar with fresh seafood', 'POINT(40.7125 -74.0065)', '2023-10-12 18:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('The Burger Joint', 1, 2, true, '2023-10-13 12:00:00', 'A trendy spot for gourmet burgers and fries', 'POINT(40.7130 -74.0070)', '2023-10-13 12:00:00');

-- Places table for the category 'Grocery Stores'
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Fresh Mart', 2, 3, true, '2023-10-11 12:00:00', 'A grocery store with fresh produce and daily essentials', 'POINT(40.7128 -74.0060)', '2023-10-11 12:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Green Grocers', 2, 3, true, '2023-10-14 12:00:00', 'Organic produce and healthy snacks', 'POINT(40.7135 -74.0062)', '2023-10-14 12:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Market Square', 2, 4, true, '2023-10-15 09:00:00', 'A farmers market with a variety of local goods', 'POINT(40.7123 -74.0058)', '2023-10-15 09:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('FoodLand', 2, 4, true, '2023-10-16 10:00:00', 'Discounts on bulk groceries and household items', 'POINT(40.7127 -74.0064)', '2023-10-16 10:00:00');

-- Places table for the category 'Pharmacies'
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Green Pharmacy', 3, 5, true, '2023-10-12 12:00:00', 'A pharmacy with a wide range of medicines and health products', 'POINT(40.7128 -74.0060)', '2023-10-12 12:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Healthy Life Pharmacy', 3, 5, true, '2023-10-17 12:00:00', 'Personalized health consultations and wellness products', 'POINT(40.7130 -74.0057)', '2023-10-17 12:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('MediQuick', 3, 6, true, '2023-10-18 14:00:00', '24-hour pharmacy with emergency medications', 'POINT(40.7126 -74.0063)', '2023-10-18 14:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Family Pharmacy', 3, 6, true, '2023-10-19 08:00:00', 'A family-owned pharmacy with friendly staff', 'POINT(40.7134 -74.0066)', '2023-10-19 08:00:00');

-- Places table for the category 'Gym and Fitness'
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Fit Zone', 4, 7, true, '2023-10-13 12:00:00', 'A gym and fitness center with modern equipment and classes', 'POINT(40.7128 -74.0060)', '2023-10-13 12:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Yoga Hub', 4, 7, true, '2023-10-20 09:00:00', 'Peaceful yoga studio with daily sessions', 'POINT(40.7129 -74.0059)', '2023-10-20 09:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Strength House', 4, 8, true, '2023-10-21 18:00:00', 'A gym specializing in strength training', 'POINT(40.7131 -74.0061)', '2023-10-21 18:00:00');

INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Cardio Central', 4, 8, true, '2023-10-22 07:00:00', 'A fitness center with cardio equipment and classes', 'POINT(40.7133 -74.0062)', '2023-10-22 07:00:00');
