
INSERT INTO filial (id, cidade, nome, pais) VALUES (1, 'São Paulo', 'Filial SP Centro', 'Brasil');
INSERT INTO filial (id, cidade, nome, pais) VALUES (2, 'Rio de Janeiro', 'Filial RJ Copacabana', 'Brasil');
INSERT INTO filial (id, cidade, nome, pais) VALUES (3, 'Belo Horizonte', 'Filial BH Savassi', 'Brasil');


INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (1, 50.0, 30.0, 1, 'Pátio Principal SP');
INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (2, 40.0, 25.0, 1, 'Pátio Secundário SP');
INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (3, 45.0, 28.0, 2, 'Pátio RJ');
INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (4, 35.0, 20.0, 3, 'Pátio BH');



INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 1, 1, 'Honda', 'ABC1D23', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (1, 1, 2, 'Yamaha', 'DEF4G56', 'LIGADO');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (2, 2, 3, 'BMW', 'GHI7J89', 'MANUTENCAO');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 3, 4, 'Honda', 'JKL0M12', 'DESLIGADO');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (1, 3, 5, 'Kawasaki', 'MNO3P45', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (2, 4, 7, 'Ducati', 'PQR6S78', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 1, 8, 'Suzuki', 'STU9V01', 'LIGADO');



INSERT INTO usuario (roles, id, password, username) VALUES (0, 1, '$2a$10$exampleHashedPassword1', 'admin');
INSERT INTO usuario (roles, id, password, username) VALUES (1, 2, '$2a$10$exampleHashedPassword2', 'operador');
INSERT INTO usuario (roles, id, password, username) VALUES (0, 3, '$2a$10$exampleHashedPassword3', 'supervisor');
INSERT INTO usuario (roles, id, password, username) VALUES (1, 4, '$2a$10$exampleHashedPassword4', 'joao.silva');