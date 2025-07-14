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
    -- French Translations
    ('Consoles Gaming', 'Les meilleures consoles de jeu pour les gamers', 1, 'fr'),
    ('PC Gaming', 'Composants et configurations pour PC gaming', 2, 'fr'),
    ('Consoles Portables', 'Consoles portable pour tous les moments', 3, 'fr'),
    ('Accessoires Gaming', 'Accessoires essentiels pour un jeu de qualité', 4, 'fr'),
    ('Moniteurs Gaming', 'Moniteurs gaming pour des performances exceptionnelles', 5, 'fr'),
    ('Stockage Gaming', 'Solutions de stockage rapide pour vos jeux', 6, 'fr'),
    ('Composants PC', 'Composants PC performants pour un gaming fluide', 7, 'fr'),
    ('Cartes Graphiques', 'Cartes graphiques puissantes pour des visuels réalistes', 8, 'fr'),
    ('Processeurs', 'Processeurs haute performance pour les gamers', 9, 'fr'),
    ('Accessoires Divers', 'Accessoires divers pour le gaming', 10, 'fr'),

    -- English Translations
    ('Gaming Consoles', 'Best gaming consoles for gamers', 1, 'en'),
    ('PC Gaming', 'PC gaming components and setups', 2, 'en'),
    ('Portable Gaming', 'Portable gaming consoles for gaming on the go', 3, 'en'),
    ('Gaming Accessories', 'Essential accessories for quality gaming', 4, 'en'),
    ('Gaming Monitors', 'Gaming monitors for superior performance', 5, 'en'),
    ('Gaming Storage', 'Fast storage solutions for your games', 6, 'en'),
    ('PC Components', 'High-performance PC components for smooth gaming', 7, 'en'),
    ('Graphics Cards', 'Powerful graphics cards for realistic visuals', 8, 'en'),
    ('Processors', 'High-performance processors for gamers', 9, 'en'),
    ('Miscellaneous Gear', 'Various gaming accessories', 10, 'en');



-- Insertion dans la table `product` avec les noms des produits correspondants aux catégories
INSERT INTO product (name, description, price, category)
VALUES
    -- Category 1: Gaming Consoles
    ('PlayStation 5', 'Next-generation gaming console with advanced performance', 549.99, 1),
    ('Xbox Series X', 'Ultra-powerful gaming console with backward compatibility', 499.99, 1),
    ('Nintendo Switch OLED', 'Hybrid console with OLED display for vibrant colors', 349.99, 1),

    -- Category 2: PC Gaming
    ('Predator Gaming PC', 'High-performance gaming PC with Intel i9 and RTX 3080', 1899.99, 2),
    ('Legion Gaming PC', 'Optimized performance gaming PC by Lenovo', 1599.99, 2),
    ('MSI Gaming PC', 'Compact and powerful PC for demanding gamers', 1299.99, 2),

    -- Category 3: Portable Consoles
    ('Steam Deck', 'Powerful handheld console for playing your Steam games', 419.99, 3),
    ('Nintendo Switch Lite', 'Compact and portable version of the Nintendo Switch', 199.99, 3),
    ('Anbernic RG351P', 'Retro handheld console with built-in emulators', 119.99, 3),

    -- Category 4: Gaming Accessories
    ('Razer Gaming Headset', 'Gaming headset with surround sound and removable mic', 79.99, 4),
    ('Logitech Gaming Mouse', 'Precision mouse with adjustable DPI', 49.99, 4),
    ('RGB Gaming Keyboard', 'Mechanical keyboard with customizable backlighting', 99.99, 4),

    -- Category 5: Gaming Monitors
    ('Asus TUF Monitor', '27" monitor with 165Hz refresh rate', 329.99, 5),
    ('MSI Optix Monitor', 'Curved screen for total immersion', 299.99, 5),
    ('Dell UltraSharp Monitor', '4K UHD display with accurate colors', 499.99, 5),

    -- Category 6: Gaming Storage
    ('1TB NVMe SSD', 'Ultra-fast SSD for instant loading times', 149.99, 6),
    ('4TB External Hard Drive', 'Portable storage solution for your games', 119.99, 6),
    ('256GB Memory Card', 'MicroSD card for additional storage', 49.99, 6),

    -- Category 7: PC Components
    ('ASUS ROG Motherboard', 'High-performance motherboard for gaming', 299.99, 7),
    ('Corsair Vengeance 16GB RAM', 'Fast RAM for gaming', 89.99, 7),
    ('EVGA 750W Power Supply', 'Stable and quiet power supply', 109.99, 7),

    -- Category 8: Graphics Cards
    ('NVIDIA GeForce RTX 4080', 'High-end graphics card for gaming and creation', 1199.99, 8),
    ('AMD Radeon RX 7900 XT', 'Performance and efficiency for gaming', 899.99, 8),
    ('NVIDIA GeForce RTX 3060', 'Mid-range graphics card for smooth gaming', 399.99, 8),

    -- Category 9: Processors
    ('Intel Core i7 13700K', 'Powerful processor for multitasking and gaming', 419.99, 9),
    ('AMD Ryzen 5 7600X', 'Balanced processor for performance and price', 299.99, 9),
    ('Intel Core i5 12400F', 'Affordable processor with great value', 189.99, 9),

    -- Category 10: Miscellaneous Accessories
    ('Xbox Elite Controller', 'Premium controller with customizable buttons', 179.99, 10),
    ('RGB Headset Stand', 'Practical accessory with integrated lighting', 29.99, 10),
    ('PS5 Controller Charger', 'Charging station for two PS5 controllers', 39.99, 10);



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
    (1, 499.99, 0.1, 1, 1),
    (2, 799.99, 0.1, 2, 2),
    (1, 69.99, 0.15, 3, 4),
    (3, 299.99, 0.15, 4, 5),
    (1, 119.99, 0.15, 5, 6),
    (2, 499.99, 0.5, 6, 7),
    (1, 699.99, 0.5, 7, 8),
    (1, 359.99, 0.5, 8, 9),
    (1, 49.99, 0.2, 9, 10),
    (1, 999.99, 0.2, 10, 11),
    (1, 129.99, 0.2, 1, 12),
    (2, 79.99, 0.3, 2, 13),
    (1, 399.99, 0.3, 3, 14),
    (1, 149.99, 0.3, 4, 15),
    (1, 499.99, 0.1, 5, 1),
    (1, 699.99, 0.5, 6, 8);