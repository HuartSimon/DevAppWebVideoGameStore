-- Utilisation de la base de données
USE video_game_store;

-- Insertion dans la table `user`
INSERT INTO user (username, first_name, last_name, email, address, password, phone_number, is_man, authorities, non_expired, non_locked, credentials_non_expired, enabled)
VALUES
	('DarkVador0709', 'Simon', 'Huart', 'huart@gmail.com', 'rue random, 99 Quelquepart', 
	'$2a$10$GS6VsE/TH2upMoVkNbfrH..cy2sNRx12gdhNnJYOrVdsD7Jvzh7aa', '0123456789', 1, 'ROLE_ADMIN', 1, 1, 1, 1), -- password : bidondonmaster
	('Nmoad', 'Martin', 'V.', 'vmartin@gmail.com', 'rue random2, 10 ailleurs', 
	'$2a$10$Bl/3tzrhH1XNwEss1b6xFu4ZSxpURI6PAbrcYkKgwJvgB5ZjAVe9K', '987654321', 1, 'ROLE_USER', 1, 1, 1, 1), -- password : bidondon
    ('WOLF', 'Emilien', 'Berlemont', 'berlemontemilien@gmail.com', 'rue random, 69 autre part', '$2a$10$Bl/3tzrhH1XNwEss1b6xFu4ZSxpURI6PAbrcYkKgwJvgB5ZjAVe9K', '198273645', 1, 'ROLE_ADMIN', 1, 1, 1, 1), -- password : bidondon
    ('johndoe', 'John', 'Doe', 'johndoe@example.com', '123 Elm Street', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '1234567890', 1, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('janedoe', 'Jane', 'Doe', 'janedoe@example.com', '456 Oak Avenue', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '0987654321', 0, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('bobsmith', 'Bob', 'Smith', 'bobsmith@example.com', '789 Pine Road', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '1122334455', 1, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('alicejohnson', 'Alice', 'Johnson', 'alicej@example.com', '101 Maple Blvd', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '5566778899', 0, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('charliebrown', 'Charlie', 'Brown', 'charliebrown@example.com', '202 Cedar Lane', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '6677889900', 1, 'ROLE_ADMIN', 1, 1, 1, 1), -- password : password123
    ('davidwhite', 'David', 'White', 'davidw@example.com', '303 Birch Crescent', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '1233211234', 1, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('emilygreen', 'Emily', 'Green', 'emilyg@example.com', '404 Willow Park', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '4321234321', 0, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('frankblack', 'Frank', 'Black', 'frankb@example.com', '505 Ash Drive', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '1122445566', 1, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('georgeharris', 'George', 'Harris', 'georgeh@example.com', '606 Redwood Avenue', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '6677882244', 1, 'ROLE_USER', 1, 1, 1, 1), -- password : password123
    ('hollydavis', 'Holly', 'Davis', 'hollyd@example.com', '707 Fir Circle', '$2a$10$Q2HnK8lzcou6KzCAF1B0cuSJ0sEkjMyJzJT4K8f.lo3ajcNKPQXly', '9988776655', 0, 'ROLE_ADMIN', 1, 1, 1, 1); -- password : password123

-- Insertion dans la table `language`
INSERT INTO language (label)
VALUES
    ('en'),
    ('fr');

-- Insertion dans la table `category`
INSERT INTO category ()
VALUES
    (),
    (),
    (),
    (),
    (),
    (),
    (),
    (),
    (),
    ();

-- Insertion dans la table `translation`
-- Insertion dans la table `translation` avec des traductions pour les catégories
INSERT INTO translation (name, description, category, language)
VALUES
    -- French Translations (Genres de jeux vidéo)
    ('Action', 'Jeux rapides mettant l\'accent sur la coordination et les réflexes', 1, 'fr'),
    ('Aventure', 'Explorez des mondes et vivez des histoires captivantes', 2, 'fr'),
    ('Jeux de Rôle', 'Incarnez des personnages et vivez des quêtes épiques', 3, 'fr'),
    ('Stratégie', 'Jeux de réflexion tactique en temps réel ou au tour par tour', 4, 'fr'),
    ('Simulation', 'Simulez la réalité dans des environnements immersifs', 5, 'fr'),
    ('Jeux de Sport', 'Retrouvez vos sports préférés en version vidéoludique', 6, 'fr'),
    ('Course', 'Jeux de vitesse et de conduite automobile', 7, 'fr'),
    ('Puzzle', 'Défiez votre logique avec des casse-têtes stimulants', 8, 'fr'),
    ('Horreur', 'Jeux effrayants pour amateurs de sensations fortes', 9, 'fr'),
    ('Multijoueur en ligne', 'Affrontez ou coopérez avec des joueurs du monde entier', 10, 'fr'),

    -- English Translations (Video Game Genres)
    ('Action', 'Fast-paced games focused on reflexes and coordination', 1, 'en'),
    ('Adventure', 'Explore worlds and experience immersive stories', 2, 'en'),
    ('Role-Playing Games', 'Take on characters and go on epic quests', 3, 'en'),
    ('Strategy', 'Tactical thinking games, real-time or turn-based', 4, 'en'),
    ('Simulation', 'Realistic environments and life-like experiences', 5, 'en'),
    ('Sports Games', 'Play your favorite sports virtually', 6, 'en'),
    ('Racing', 'High-speed driving and racing games', 7, 'en'),
    ('Puzzle', 'Logic-based games and brain teasers', 8, 'en'),
    ('Horror', 'Scary games for thrill-seekers', 9, 'en'),
    ('Online Multiplayer', 'Compete or cooperate with players worldwide', 10, 'en');


-- Insertion dans la table `product` avec les noms des produits correspondants aux catégories
INSERT INTO product (name, description, price, category)
VALUES
    -- Category 1: Action
    ('God of War: Ragnarok', 'Mythological action-adventure with epic combat', 69.99, 1),
    ('Marvel\'s Spider-Man 2', 'Web-slinging open-world action in New York City', 69.99, 1),
    ('Bayonetta 3', 'Stylish hack-and-slash action with witch powers', 59.99, 1),

    -- Category 2: Adventure
    ('The Legend of Zelda: Tears of the Kingdom', 'Epic open-world adventure with creative exploration', 69.99, 2),
    ('Uncharted: Legacy of Thieves Collection', 'Cinematic treasure-hunting adventure', 49.99, 2),
    ('Life is Strange: True Colors', 'Emotional narrative-driven adventure', 39.99, 2),

    -- Category 3: Role-Playing Games
    ('Elden Ring', 'Dark fantasy RPG with vast open world and tough combat', 69.99, 3),
    ('Final Fantasy XVI', 'Story-rich RPG with real-time combat', 69.99, 3),
    ('Persona 5 Royal', 'Stylish turn-based RPG set in modern Tokyo', 59.99, 3),

    -- Category 4: Strategy
    ('Age of Empires IV', 'Historical real-time strategy with multiple civilizations', 59.99, 4),
    ('XCOM 2', 'Turn-based tactical strategy game with aliens', 29.99, 4),
    ('Fire Emblem: Engage', 'Tactical RPG with permadeath and epic battles', 59.99, 4),

    -- Category 5: Simulation
    ('The Sims 4', 'Life simulation game with endless customization', 39.99, 5),
    ('Microsoft Flight Simulator', 'Realistic flight simulation with stunning visuals', 59.99, 5),
    ('Farming Simulator 22', 'Farm-building and management simulation', 49.99, 5),

    -- Category 6: Sports
    ('FIFA 24', 'Realistic football simulation with global teams', 69.99, 6),
    ('NBA 2K24', 'Basketball simulation with lifelike gameplay', 69.99, 6),
    ('Tony Hawk\'s Pro Skater 1+2', 'Remake of classic skateboarding games', 39.99, 6),

    -- Category 7: Racing
    ('Gran Turismo 7', 'Realistic racing sim with licensed cars and tracks', 69.99, 7),
    ('Forza Horizon 5', 'Open-world arcade racer in a vibrant environment', 69.99, 7),
    ('Mario Kart 8 Deluxe', 'Fun, chaotic kart racing with Nintendo characters', 59.99, 7),

    -- Category 8: Puzzle
    ('Tetris Effect: Connected', 'Classic puzzle game with hypnotic visuals', 39.99, 8),
    ('Portal 2', 'First-person puzzle game with dark humor', 19.99, 8),
    ('The Witness', 'Beautiful open-world filled with logic puzzles', 29.99, 8),

    -- Category 9: Horror
    ('Resident Evil 4 Remake', 'Survival horror reimagined with modern visuals', 69.99, 9),
    ('Dead Space Remake', 'Sci-fi horror with atmospheric tension and gore', 69.99, 9),
    ('Phasmophobia', 'Co-op ghost hunting horror game', 13.99, 9),

    -- Category 10: Online Multiplayer
    ('Call of Duty: Modern Warfare III', 'Fast-paced FPS with online multiplayer modes', 69.99, 10),
    ('Fortnite', 'Battle royale with building mechanics and seasonal events', 9.99, 10),
    ('Apex Legends', 'Hero-based battle royale shooter', 4.99, 10);


-- Insertion dans la table `discount`
INSERT INTO discount (discount_val, begin_date, end_date, category)
VALUES
    (0.1, '2024-11-01 00:00:00', '2026-01-30 23:59:59', 1),
    (0.15, '2024-11-01 00:00:00', '2026-01-30 23:59:59', 2),
    (0.5, '2024-11-01 00:00:00', '2026-01-30 23:59:59', 3),
    (0.2, '2024-11-01 00:00:00', '2026-01-30 23:59:59', 4),
    (0.3, '2024-11-01 00:00:00', '2026-01-30 23:59:59', 5),
    (0.25, '2024-11-01 00:00:00', '2026-01-30 23:59:59', 6),
    (0.1, '2024-11-01 00:00:00', '2025-01-30 23:59:59', 7),
    (0.5, '2024-11-01 00:00:00', '2025-01-30 23:59:59', 8),
    (0.4, '2024-11-01 00:00:00', '2025-01-30 23:59:59', 9),
    (0.05, '2024-11-01 00:00:00', '2025-01-30 23:59:59', 10);

-- Insertion dans la table `order`
INSERT INTO `order` (order_date, is_payed, user)
VALUES
    ('2024-11-10 14:30:00', 1, 'johndoe'),
    ('2024-11-11 15:45:00', 1, 'janedoe'),
    ('2024-11-12 16:00:00', 0, 'bobsmith'),
    ('2024-11-13 17:20:00', 1, 'alicejohnson'),
    ('2024-11-14 18:35:00', 0, 'charliebrown'),
    ('2024-11-15 19:50:00', 1, 'davidwhite'),
    ('2024-11-16 20:05:00', 1, 'emilygreen'),
    ('2024-11-17 21:10:00', 0, 'frankblack'),
    ('2024-11-18 22:25:00', 1, 'georgeharris'),
    ('2024-11-19 23:40:00', 0, 'hollydavis');

-- Insertion dans la table `order_line`
INSERT INTO order_line (quantity, price, discount, `order`, product)
VALUES
    (1, 69.99, 0.10, 1, 1),   -- God of War: Ragnarok
    (2, 69.99, 0.10, 2, 2),   -- Marvel's Spider-Man 2
    (1, 69.99, 0.15, 3, 4),   -- Zelda: Tears of the Kingdom
    (3, 39.99, 0.15, 4, 6),   -- Life is Strange: True Colors
    (1, 59.99, 0.15, 5, 9),   -- Persona 5 Royal
    (2, 59.99, 0.50, 6, 10),  -- Age of Empires IV
    (1, 29.99, 0.50, 7, 11),  -- XCOM 2
    (1, 59.99, 0.50, 8, 12),  -- Fire Emblem: Engage
    (1, 49.99, 0.20, 9, 13),  -- The Sims 4
    (1, 59.99, 0.20, 10, 15), -- Farming Simulator 22
    (1, 69.99, 0.20, 1, 17),  -- NBA 2K24
    (2, 39.99, 0.30, 2, 18),  -- Tony Hawk's Pro Skater 1+2
    (1, 69.99, 0.30, 3, 19),  -- Gran Turismo 7
    (1, 59.99, 0.30, 4, 21),  -- Mario Kart 8 Deluxe
    (1, 19.99, 0.10, 5, 23),  -- Portal 2
    (1, 69.99, 0.50, 6, 24);  -- Resident Evil 4 Remake
