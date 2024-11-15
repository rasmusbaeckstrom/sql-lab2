-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE place;
TRUNCATE TABLE category;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Category table
INSERT INTO category (name, symbol, description)
VALUES ('Restaurants', '🍽️', 'Places to eat and dine');

INSERT INTO category (name, symbol, description)
VALUES ('Grocery Stores', '🛒', 'Places to buy food and other essentials');

INSERT INTO category (name, symbol, description)
VALUES ('Pharmacies', '💊', 'Places to buy medicine and health products');

INSERT INTO category (name, symbol, description)
VALUES ('Gym and Fitness', '🏋️', 'Places to exercise and stay fit');

-- Restaurants
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES
    ('The Gourmet Bistro', 1, 101, TRUE, NOW(), 'A fine dining experience with a selection of international cuisines.', ST_GeomFromText('POINT(59.3293 18.0686)'), NOW()),
    ('Pasta Paradise', 1, 102, TRUE, NOW(), 'An Italian restaurant famous for its handmade pasta.', ST_GeomFromText('POINT(59.3326 18.0649)'), NOW()),
    ('Sushi World', 1, 103, TRUE, NOW(), 'Sushi and other Japanese delicacies prepared with fresh ingredients.', ST_GeomFromText('POINT(59.3227 18.0708)'), NOW()),
    ('Veggie Delight', 1, 104, TRUE, NOW(), 'A vegetarian restaurant with a wide variety of plant-based dishes.', ST_GeomFromText('POINT(59.3254 18.0721)'), NOW());

-- Grocery Stores
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES
    ('City Market', 2, 201, TRUE, NOW(), 'A large grocery store offering fresh produce and a variety of products.', ST_GeomFromText('POINT(59.3298 18.0627)'), NOW()),
    ('Organic Goods', 2, 202, TRUE, NOW(), 'A grocery store specializing in organic and sustainable products.', ST_GeomFromText('POINT(59.3205 18.0679)'), NOW()),
    ('Foodies Hub', 2, 203, TRUE, NOW(), 'A modern grocery store with a wide selection of international foods.', ST_GeomFromText('POINT(59.3158 18.0632)'), NOW()),
    ('FreshMart', 2, 204, TRUE, NOW(), 'A neighborhood grocery store known for its fresh fruits and vegetables.', ST_GeomFromText('POINT(59.3170 18.0703)'), NOW());

-- Pharmacies
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES
    ('Healthy Life Pharmacy', 3, 301, TRUE, NOW(), 'A pharmacy offering a wide range of medicines and health products.', ST_GeomFromText('POINT(59.3263 18.0702)'), NOW()),
    ('WellCare Pharmacy', 3, 302, TRUE, NOW(), 'Pharmacy focused on customer health and providing advice on wellness products.', ST_GeomFromText('POINT(59.3241 18.0625)'), NOW()),
    ('PharmaPlus', 3, 303, TRUE, NOW(), 'A convenient pharmacy offering both prescription and over-the-counter medicines.', ST_GeomFromText('POINT(59.3281 18.0730)'), NOW()),
    ('MedCure Pharmacy', 3, 304, TRUE, NOW(), 'A pharmacy providing a variety of health and beauty products, along with professional medical advice.', ST_GeomFromText('POINT(59.3223 18.0690)'), NOW());

-- Gym and Fitness
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES
    ('FitZone Gym', 4, 401, TRUE, NOW(), 'A modern gym offering state-of-the-art equipment and fitness classes.', ST_GeomFromText('POINT(59.3274 18.0630)'), NOW()),
    ('PowerHouse Gym', 4, 402, TRUE, NOW(), 'A fitness center with a focus on weight training and strength building.', ST_GeomFromText('POINT(59.3229 18.0703)'), NOW()),
    ('Wellness Studio', 4, 403, TRUE, NOW(), 'A boutique fitness studio offering yoga, pilates, and personal training.', ST_GeomFromText('POINT(59.3247 18.0650)'), NOW()),
    ('Cardio Fitness Center', 4, 404, TRUE, NOW(), 'A gym specialized in cardio exercises and fitness classes.', ST_GeomFromText('POINT(59.3200 18.0683)'), NOW());