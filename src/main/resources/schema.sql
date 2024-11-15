-- Skapa Category-tabellen
CREATE TABLE IF NOT EXISTS category
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,        -- Namn på kategorin
    symbol VARCHAR(255),               -- Symbol (kan vara en emoji eller något annat)
    description TEXT                   -- Beskrivning av kategorin
);

-- Skapa Place-tabellen
CREATE TABLE IF NOT EXISTS place
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,        -- Namn på platsen (obligatoriskt fält)
    user_id BIGINT NOT NULL,          -- Användar-ID som skapade platsen
    is_public BOOLEAN DEFAULT TRUE,    -- Status om platsen är offentlig (standard: TRUE)
    last_modified TIMESTAMP,           -- Datum och tid för senaste ändring
    description TEXT,                  -- Beskrivning av platsen
    coordinates GEOMETRY,              -- Koordinater som spatial data (GEOMETRY är typ för geografiska data)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Datum och tid när platsen skapades
    category_id BIGINT NOT NULL,       -- Kategori-ID som refererar till en befintlig kategori
    FOREIGN KEY (category_id) REFERENCES category(id)   -- Utländsk nyckel som refererar till Category-tabellen
);