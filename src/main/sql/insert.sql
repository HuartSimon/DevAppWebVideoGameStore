-- Utilisation de la base de données
USE video_game_store;

-- Insertion dans la table `user`
INSERT INTO user (username, first_name, last_name, email, address, password, phone_number, is_man, authorities, non_expired, non_locked, credentials_non_expired, enabled)
VALUES
	('DarkVador0709', 'Simon', 'Huart', 'huart@gmail.com', 'rue random, 99 Quelquepart', 
	'$2a$10$GS6VsE/TH2upMoVkNbfrH..cy2sNRx12gdhNnJYOrVdsD7Jvzh7aa', '0123456789', 1, 'ROLE_ADMIN', 1, 1, 1, 1), -- password : bidondonmaster
	('Nmoad', 'Martin', 'V.', 'vmartin@gmail.com', 'rue random2, 10 ailleurs', 
	'$2a$10$Bl/3tzrhH1XNwEss1b6xFu4ZSxpURI6PAbrcYkKgwJvgB5ZjAVe9K', '987654321', NULL, 'ROLE_USER', 1, 1, 1, 1), -- password : bidondon
    ('johndoe', 'John', 'Doe', 'johndoe@example.com', '123 Elm Street', 'password123', '1234567890', 1, 'ROLE_USER', 1, 1, 1, 1),
    ('janedoe', 'Jane', 'Doe', 'janedoe@example.com', '456 Oak Avenue', 'password123', '0987654321', 0, 'ROLE_USER', 1, 1, 1, 1),
    ('bobsmith', 'Bob', 'Smith', 'bobsmith@example.com', '789 Pine Road', 'password123', '1122334455', 1, 'ROLE_USER', 1, 1, 1, 1),
    ('alicejohnson', 'Alice', 'Johnson', 'alicej@example.com', '101 Maple Blvd', 'password123', '5566778899', 0, 'ROLE_USER', 1, 1, 1, 1),
    ('charliebrown', 'Charlie', 'Brown', 'charliebrown@example.com', '202 Cedar Lane', 'password123', '6677889900', 1, 'ROLE_ADMIN', 1, 1, 1, 1),
    ('davidwhite', 'David', 'White', 'davidw@example.com', '303 Birch Crescent', 'password123', '1233211234', 1, 'ROLE_USER', 1, 1, 1, 1),
    ('emilygreen', 'Emily', 'Green', 'emilyg@example.com', '404 Willow Park', 'password123', '4321234321', 0, 'ROLE_USER', 1, 1, 1, 1),
    ('frankblack', 'Frank', 'Black', 'frankb@example.com', '505 Ash Drive', 'password123', '1122445566', 1, 'ROLE_USER', 1, 1, 1, 1),
    ('georgeharris', 'George', 'Harris', 'georgeh@example.com', '606 Redwood Avenue', 'password123', '6677882244', 1, 'ROLE_USER', 1, 1, 1, 1),
    ('hollydavis', 'Holly', 'Davis', 'hollyd@example.com', '707 Fir Circle', 'password123', '9988776655', 0, 'ROLE_ADMIN', 1, 1, 1, 1);

-- Insertion dans la table `language`
INSERT INTO language (label)
VALUES
    ('English'),
    ('French'),
    ('Spanish'),
    ('German'),
    ('Italian'),
    ('Portuguese'),
    ('Russian'),
    ('Chinese'),
    ('Japanese'),
    ('Arabic');

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
    ('Gaming Consoles', 'Les meilleures consoles de jeu pour les gamers', 1, 'French'),
    ('PC Gaming', 'Composants et configurations pour PC gaming', 2, 'French'),
    ('Portable Gaming', 'Jeux sur console portable pour tous les moments', 3, 'French'),
    ('Gaming Accessories', 'Accessoires essentiels pour un jeu de qualité', 4, 'French'),
    ('Gaming Monitors', 'Moniteurs gaming pour des performances exceptionnelles', 5, 'French'),
    ('Gaming Storage', 'Solutions de stockage rapide pour vos jeux', 6, 'French'),
    ('PC Components', 'Composants PC performants pour un gaming fluide', 7, 'French'),
    ('Graphics Cards', 'Cartes graphiques puissantes pour des visuels réalistes', 8, 'French'),
    ('Processors', 'Processeurs haute performance pour les gamers', 9, 'French'),
    ('Miscellaneous Gear', 'Accessoires divers pour le gaming', 10, 'French'),

    ('Gaming Consoles', 'Best gaming consoles for gamers', 1, 'English'),
    ('PC Gaming', 'PC gaming components and setups', 2, 'English'),
    ('Portable Gaming', 'Portable gaming consoles for gaming on the go', 3, 'English'),
    ('Gaming Accessories', 'Essential accessories for quality gaming', 4, 'English'),
    ('Gaming Monitors', 'Gaming monitors for superior performance', 5, 'English'),
    ('Gaming Storage', 'Fast storage solutions for your games', 6, 'English'),
    ('PC Components', 'High-performance PC components for smooth gaming', 7, 'English'),
    ('Graphics Cards', 'Powerful graphics cards for realistic visuals', 8, 'English'),
    ('Processors', 'High-performance processors for gamers', 9, 'English'),
    ('Miscellaneous Gear', 'Various gaming accessories', 10, 'English'),

    ('Gaming Consoles', 'Las mejores consolas de juego para los gamers', 1, 'Spanish'),
    ('PC Gaming', 'Componentes y configuraciones para PC de juego', 2, 'Spanish'),
    ('Portable Gaming', 'Consolas de juego portátiles para jugar en cualquier lugar', 3, 'Spanish'),
    ('Gaming Accessories', 'Accesorios esenciales para un juego de calidad', 4, 'Spanish'),
    ('Gaming Monitors', 'Monitores de juego para un rendimiento excepcional', 5, 'Spanish'),
    ('Gaming Storage', 'Soluciones de almacenamiento rápidas para tus juegos', 6, 'Spanish'),
    ('PC Components', 'Componentes de PC de alto rendimiento para un juego fluido', 7, 'Spanish'),
    ('Graphics Cards', 'Tarjetas gráficas potentes para visuales realistas', 8, 'Spanish'),
    ('Processors', 'Procesadores de alto rendimiento para gamers', 9, 'Spanish'),
    ('Miscellaneous Gear', 'Accesorios diversos para gaming', 10, 'Spanish'),

    ('Gaming Consoles', 'Le migliori console da gioco per i gamer', 1, 'Italian'),
    ('PC Gaming', 'Componenti e configurazioni per PC da gioco', 2, 'Italian'),
    ('Portable Gaming', 'Console da gioco portatili per ogni momento', 3, 'Italian'),
    ('Gaming Accessories', 'Accessori essenziali per un gioco di qualità', 4, 'Italian'),
    ('Gaming Monitors', 'Monitor da gioco per prestazioni superiori', 5, 'Italian'),
    ('Gaming Storage', 'Soluzioni di archiviazione rapida per i tuoi giochi', 6, 'Italian'),
    ('PC Components', 'Componente PC ad alte prestazioni per un gioco fluido', 7, 'Italian'),
    ('Graphics Cards', 'Schede grafiche potenti per visuali realistici', 8, 'Italian'),
    ('Processors', 'Processori ad alte prestazioni per i gamer', 9, 'Italian'),
    ('Miscellaneous Gear', 'Accessori vari per il gaming', 10, 'Italian');



-- Insertion dans la table `product` avec les noms des produits correspondants aux catégories
INSERT INTO product (name, description, price, category)
VALUES
    ('Gaming Consoles - Bundle', 'Pack complet de consoles de jeux', 499.99, 1),
    ('PC Gaming Setup', 'Configuration PC gaming haut de gamme', 799.99, 2),
    ('Portable Gaming Kit', 'Kit complet pour jeux portables', 299.99, 3),
    ('Gaming Accessories - Razer Bundle', 'Accessoires de jeu haut de gamme Razer', 69.99, 4),
    ('Ultra Gaming Monitor', 'Moniteur de jeu incurvé avec une haute résolution', 299.99, 5),
    ('High-Speed Gaming Storage', 'Disque SSD rapide pour le stockage de jeux', 119.99, 6),
    ('Gaming PC Components - Bundle', 'Composants PC pour un PC de jeu sur mesure', 499.99, 7),
    ('High-End Graphics Cards', 'Carte graphique performante pour gaming', 699.99, 8),
    ('Gaming Processors - Ryzen Series', 'Processeur de jeu Ryzen haut de gamme', 359.99, 9),
    ('Miscellaneous Gaming Gear', 'Accessoires divers pour gamers', 49.99, 10);


-- Insertion dans la table `discount`
INSERT INTO discount (discount_val, begin_date, end_date, category)
VALUES
    (10.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 1),
    (15.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 2),
    (5.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 3),
    (20.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 4),
    (30.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 5),
    (25.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 6),
    (10.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 7),
    (50.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 8),
    (40.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 9),
    (5.00, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 10);

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
    (1, 499.99, 10, 1, 1),
    (2, 299.99, 5, 2, 2),
    (1, 69.99, 0, 3, 4),
    (3, 129.99, 20, 4, 5),
    (1, 299.99, 0, 5, 6),
    (2, 119.99, 25, 6, 7),
    (1, 79.99, 10, 7, 8),
    (1, 699.99, 50, 8, 9),
    (1, 359.99, 30, 9, 10),
    (2, 299.99, 5, 10, 1);
