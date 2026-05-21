-- 1. ASOCIACIONES (image_358e1f.png)
-- Agregamos país y presidente para que no queden nulos si son requeridos
INSERT INTO asociaciones (nombre, pais, presidente) VALUES ('FIFA', 'Suiza', 'Gianni Infantino');

-- 2. ENTRENADORES (image_358afb.png)
-- Tu clase tiene nombre, apellido, edad y nacionalidad
INSERT INTO entrenadores (nombre, apellido, edad, nacionalidad) VALUES ('Pep', 'Guardiola', 53, 'Española');

-- 3. JUGADORES (image_358ade.png)
-- Tu clase tiene nombre, apellido, numero y posicion
INSERT INTO jugadores (nombre, apellido, numero, posicion) VALUES ('Lionel', 'Messi', 10, 'Delantero');

-- 4. COMPETICIONES (image_358da6.png)
-- OJO: Tu clase se llama 'Competecion' pero la tabla es 'competiciones'. 
-- El campo montoPremio se convierte en 'monto_premio' por estándar de Spring.
INSERT INTO competiciones (nombre, monto_premio, fecha_inicio, fecha_fin) VALUES ('Copa Libertadores', 5000000, '2026-01-01', '2026-12-01');

-- 5. CLUBES (image_358dc6.png)
-- Como Club tiene relación con Asociación, primero debe existir la Asociación (ID 1)
INSERT INTO club (nombre, asociacion_id) VALUES ('Real Santander', 1);'Copa Libertadores');