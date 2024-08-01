INSERT INTO GENEROS (id, nombre) VALUES (10, 'Accion'),
                                        (11, 'Porno');

INSERT INTO JUEGOS (id, nombre, release_date, precio, id_genero, logros, developer, publisher, rating) VALUES (100,'Quake III', CURRENT_TIMESTAMP , 150, 10, 23, 'id Software', 'Activision', 'T'),
                                                                                                              (101,'Granja de Elfas Eroticas', CURRENT_TIMESTAMP, 6000,11,69,'Leche Software', 'Grupo 5', 'A');

INSERT INTO USUARIOS (id, email, password, nombre, pais, last_login, created_at, nivel) VALUES (100, 'aguz@yahoo.com', 'bokita123', 'Agu', 'Argentina', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 50),
                                                                              (101, 'matiiiiii@gmail.com', 'cacaman',  'Mati', 'Argentina', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 41);

INSERT INTO BIBLIOTECAS (id, id_juego, id_usuario, horas, logros, review) VALUES (100, 101, 100, 575, 69, 'Aguante la merca');

