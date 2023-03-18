INSERT INTO client(id, name) VALUES(1, 'Vova');
INSERT INTO client(id, name) VALUES(2, 'Stas');
INSERT INTO client(id, name) VALUES(3, 'Grisha');
INSERT INTO client(id, name) VALUES(4, 'Sasha');
INSERT INTO client(id, name) VALUES(5, 'Nikita');
INSERT INTO client(id, name) VALUES(6, 'Makar');
INSERT INTO client(id, name) VALUES(7, 'Danya');
INSERT INTO client(id, name) VALUES(8, 'Misha');
INSERT INTO client(id, name) VALUES(9, 'Oleg');
INSERT INTO client(id, name) VALUES(10, 'Natasha');

INSERT INTO planet(id, name) VALUES('MRS', 'Mars');
INSERT INTO planet(id, name) VALUES('EU', 'Europe(Jupiter satellite)');
INSERT INTO planet(id, name) VALUES('MN', 'Moon');
INSERT INTO planet(id, name) VALUES('KOI-1361.01', 'Kepler-61 b');
INSERT INTO planet(id, name) VALUES('E', 'Earth');

INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(1, CURRENT_TIMESTAMP, 1, 'EU', 'E');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(2, CURRENT_TIMESTAMP, 2, 'E', 'KOI-1361.01');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(3, CURRENT_TIMESTAMP, 3, 'MRS', 'KOI-1361.01');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(4, CURRENT_TIMESTAMP, 4, 'MN', 'E');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(5, CURRENT_TIMESTAMP, 5, 'EU', 'MN');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(6, CURRENT_TIMESTAMP, 6, 'KOI-1361.01', 'MN');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(7, CURRENT_TIMESTAMP, 7, 'EU', 'KOI-1361.01');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(8, CURRENT_TIMESTAMP, 8, 'KOI-1361.01', 'E');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(9, CURRENT_TIMESTAMP, 9, 'KOI-1361.01', 'MN');
INSERT INTO ticket(id, created_at, client_id, from_planet_id, to_planet_id) VALUES(10, CURRENT_TIMESTAMP, 10, 'EU', 'E');