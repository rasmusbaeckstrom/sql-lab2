-- Skapa Category-tabellen
CREATE TABLE IF NOT EXISTS category
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    symbol VARCHAR(255),
    description TEXT
);

-- Skapa Place-tabellen
CREATE TABLE IF NOT EXISTS place
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    is_public BOOLEAN DEFAULT TRUE,
    last_modified TIMESTAMP,
    description TEXT,
    coordinates GEOMETRY NOT NULL SRID 4326,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);