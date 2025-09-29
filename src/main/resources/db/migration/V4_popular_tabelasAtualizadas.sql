
INSERT INTO filial (id, cidade, nome, pais) VALUES (2, 'Rio de Janeiro', 'Filial RJ Copacabana', 'Brasil');
INSERT INTO filial (id, cidade, nome, pais) VALUES (3, 'Belo Horizonte', 'Filial BH Savassi', 'Brasil');


INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (2, 40.0, 25.0, 2, 'Pátio Copacabana');
INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (3, 40.0, 20.0, 3, 'Pátio Savassi');



INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 2, 1, 'Honda', 'ABC1234', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (1, 2, 2, 'Yamaha', 'DEF5678', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (2, 3, 3, 'BMW', 'GHI9012', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 3, 4, 'Honda', 'JKL3456', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (1, 3, 5, 'Kawasaki', 'MNO7890', 'DISPONIVEL');