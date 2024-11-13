-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE place;
TRUNCATE TABLE category;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Insert data into Category table
INSERT INTO category (name, symbol, description) VALUES ('Category1', 'C1', 'Description for Category1');
INSERT INTO category (name, symbol, description) VALUES ('Category2', 'C2', 'Description for Category2');
INSERT INTO category (name, symbol, description) VALUES ('Category3', 'C3', 'Description for Category3');

-- Insert data into Place table
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Place1', 1, 1, true, '2023-10-01 12:00:00', 'Description for Place1', 'Coordinates1', '2023-10-01 12:00:00');
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Place2', 2, 2, true, '2023-10-02 12:00:00', 'Description for Place2', 'Coordinates2', '2023-10-02 12:00:00');
INSERT INTO place (name, category_id, user_id, is_public, last_modified, description, coordinates, created_at)
VALUES ('Place3', 3, 3, true, '2023-10-03 12:00:00', 'Description for Place3', 'Coordinates3', '2023-10-03 12:00:00');