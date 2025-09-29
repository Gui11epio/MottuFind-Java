
INSERT INTO filial (id, cidade, nome, pais) VALUES (2, 'Rio de Janeiro', 'Filial RJ Copacabana', 'Brasil');
INSERT INTO filial (id, cidade, nome, pais) VALUES (3, 'Belo Horizonte', 'Filial BH Savassi', 'Brasil');


INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (2, 40.0, 25.0, 2, 'Pátio Secundário SP');
INSERT INTO patio (id, comprimento, largura, filial_id, nome) VALUES (3, 45.0, 28.0, 3, 'Pátio RJ');


INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 2, 1, 'Honda', 'ABC1D23', 'DISPONIVEL');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (1, 2, 2, 'Yamaha', 'DEF4G56', 'LIGADO');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (2, 3, 3, 'BMW', 'GHI7J89', 'MANUTENCAO');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (0, 3, 4, 'Honda', 'JKL0M12', 'DESLIGADO');
INSERT INTO moto (modelo, patio_id, tag_id, marca, placa, status) VALUES (1, 3, 5, 'Kawasaki', 'MNO3P45', 'DISPONIVEL');
