-- Insertar datos iniciales
INSERT INTO user (name, last_name, dni, birthdate, profession)
SELECT 'Vicente', 'Llanos', 30312277, '1984-04-19', 'DEVELOPER'
WHERE NOT EXISTS (SELECT 1 FROM user WHERE dni = 30312277);

INSERT INTO user (name, last_name, dni, birthdate, profession)
SELECT 'Maria', 'Db', 30256312, '2000-05-01', 'EMPLEADO_PUBLICO'
WHERE NOT EXISTS (SELECT 1 FROM user WHERE dni = 30256312);

INSERT INTO user (name, last_name, dni, birthdate, profession)
SELECT 'Pedro', 'Martinez', 22256987, '2023-01-01', 'MEDICO'
WHERE NOT EXISTS (SELECT 1 FROM user WHERE dni = 22256987);
