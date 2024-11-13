-- Create Category table
CREATE TABLE IF NOT EXISTS category
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    symbol VARCHAR(255),
    description TEXT
);

-- Create Place table
CREATE TABLE IF NOT EXISTS place
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id BIGINT NOT NULL,
    user_id BIGINT,
    is_public BOOLEAN DEFAULT TRUE,
    last_modified TIMESTAMP,
    description TEXT,
    coordinates VARCHAR(255),
    created_at TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category(id)
);