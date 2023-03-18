CREATE TABLE client(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    CONSTRAINT client_name_min_length CHECK (CHAR_LENGTH(name) >= 3)
);

CREATE TABLE planet(
    id VARCHAR(32) PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CONSTRAINT planet_id_check CHECK (id REGEXP '^[A-Z0-9-.,]+$'),
    CONSTRAINT planet_name_min_length CHECK (CHAR_LENGTH(name) >= 1)
);

CREATE TABLE ticket(
    id IDENTITY PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    client_id INTEGER NOT NULL,
    from_planet_id VARCHAR(32) NOT NULL,
    to_planet_id VARCHAR(32) NOT NULL,
    FOREIGN KEY(client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY(from_planet_id) REFERENCES planet(id),
    FOREIGN KEY(to_planet_id) REFERENCES planet(id)
);