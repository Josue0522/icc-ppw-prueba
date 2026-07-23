INSERT INTO roles (id, name) VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_COORDINATOR'),
  (3, 'ROLE_STUDENT');

INSERT INTO users (id, full_name, email, password_hash, age, active, deleted) VALUES
  (1, 'Pablo Administrador', 'admin@ups.edu.ec', '$2y$10$4SkFzZFGgS.OwMDmxoKw6eQ6xtWxMs/ASlgzb18QrJlS4V.SoWpqW', 40, TRUE, FALSE),
  (2, 'Carla Coordinadora', 'coord@ups.edu.ec', '$2y$10$I6TSn6/4CJGYegsFQ7fncuJdj0YeS4.Cq162N2EhKicbZw97he6Zi', 32, TRUE, FALSE),
  (3, 'Ana Estudiante', 'ana@est.ups.edu.ec', '$2y$10$lYyqARDipgEtelJyCONr6e7D07k50IxGSJEro.v1bwG61BXnladcK', 19, TRUE, FALSE),
  (4, 'Luis Menor', 'luis@est.ups.edu.ec', '$2y$10$lYyqARDipgEtelJyCONr6e7D07k50IxGSJEro.v1bwG61BXnladcK', 17, TRUE, FALSE),
  (5, 'Maria Inactiva', 'maria@est.ups.edu.ec', '$2y$10$1xmmpg4kHmX/D7fwJXIBruTAabYpa.AkVaQQViNN.hZB30lx4Se4W', 25, FALSE, FALSE),
  (6, 'Beto Eliminado', 'beto@est.ups.edu.ec', '$2y$10$lYyqARDipgEtelJyCONr6e7D07k50IxGSJEro.v1bwG61BXnladcK', 30, TRUE, TRUE),
  (7, 'Diego Estudiante', 'diego@est.ups.edu.ec', '$2y$10$lYyqARDipgEtelJyCONr6e7D07k50IxGSJEro.v1bwG61BXnladcK', 22, TRUE, FALSE),
  (8, 'Elena Estudiante', 'elena@est.ups.edu.ec', '$2y$10$lYyqARDipgEtelJyCONr6e7D07k50IxGSJEro.v1bwG61BXnladcK', 18, TRUE, FALSE);

INSERT INTO user_roles (user_id, role_id) VALUES
  (1, 1), (1, 2),
  (2, 2),
  (3, 3), (4, 3), (5, 3), (6, 3), (7, 3), (8, 3);

INSERT INTO campuses (id, name, city, active, deleted) VALUES
  (1, 'Campus El Vecino', 'Cuenca', TRUE, FALSE),
  (2, 'Campus Sur', 'Quito', TRUE, FALSE),
  (3, 'Campus Centenario', 'Guayaquil', FALSE, FALSE);

INSERT INTO laboratories (id, code, name, capacity, active, campus_id, deleted) VALUES
  (1, 'LAB-CUE-01', 'Laboratorio de Desarrollo Web', 20, TRUE, 1, FALSE),
  (2, 'LAB-CUE-02', 'Laboratorio de Arquitectura de Software', 30, TRUE, 1, FALSE),
  (3, 'LAB-CUE-03', 'Laboratorio de Redes', 40, FALSE, 1, FALSE),
  (4, 'LAB-QUI-01', 'Laboratorio de Inteligencia Artificial', 35, TRUE, 2, FALSE),
  (5, 'LAB-QUI-02', 'Laboratorio de Sistemas Operativos', 15, TRUE, 2, FALSE),
  (6, 'LAB-GYE-01', 'Laboratorio de Computación Gráfica', 50, TRUE, 3, FALSE);

INSERT INTO equipment (id, name, active, deleted) VALUES
  (1, 'Computador de escritorio', TRUE, FALSE),
  (2, 'Proyector', TRUE, FALSE),
  (3, 'Pizarra digital', TRUE, FALSE),
  (4, 'Router administrable', TRUE, FALSE);

INSERT INTO laboratory_equipment (laboratory_id, equipment_id, quantity) VALUES
  (1, 1, 20), (1, 2, 1),
  (2, 1, 30), (2, 2, 1), (2, 3, 1),
  (3, 1, 40), (3, 4, 8),
  (4, 1, 35), (4, 2, 1),
  (5, 1, 15),
  (6, 1, 50), (6, 2, 1);

INSERT INTO supplies (id, name, description, quantity, minimum_stock, unit_price, active, deleted) VALUES
  (1, 'Cable UTP Cat 6', 'Cable de red por metro', 8, 10, 0.85, TRUE, FALSE),
  (2, 'Conector RJ45', 'Conector para cableado estructurado', 60, 20, 0.25, TRUE, FALSE),
  (3, 'Marcador borrable', 'Marcador negro para pizarra', 4, 5, 1.50, TRUE, FALSE),
  (4, 'Papel A4', 'Resma de papel de 500 hojas', 0, 3, 5.25, TRUE, FALSE),
  (5, 'Toner impresora', 'Toner de reemplazo para impresora', 2, 2, 48.90, FALSE, FALSE),
  (6, 'Mouse USB', 'Mouse óptico de respaldo', 6, 5, 8.75, TRUE, TRUE);

ALTER TABLE roles ALTER COLUMN id RESTART WITH 10;
ALTER TABLE users ALTER COLUMN id RESTART WITH 20;
ALTER TABLE campuses ALTER COLUMN id RESTART WITH 10;
ALTER TABLE laboratories ALTER COLUMN id RESTART WITH 20;
ALTER TABLE equipment ALTER COLUMN id RESTART WITH 20;
ALTER TABLE supplies ALTER COLUMN id RESTART WITH 20;
