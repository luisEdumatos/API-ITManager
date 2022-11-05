-----------------------------------------Inserts Clientes-----------------------------------------
INSERT INTO t_client (address, cnpj, name)
VALUES('Avenida Celina Ferreira Ottoni, 225, Sion',
       '12345678000112',
       'XYZ da Reforma a Construção LTDA');

INSERT INTO t_client (address, cnpj, name)
VALUES('Avenida Rio Branco, 1850, Centro',
       '84675891000185',
       'Centro de Oftalmologia do Sul de Minas');

INSERT INTO t_client (address, cnpj, name)
VALUES('Estrada rural via Carmo da Cachoeira, 500, Zona Rural',
       '63487254000215',
       'Mineradora Brasil S/A');

-----------------------------------------Inserts Colaboradores-----------------------------------------
INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2022-10-21', '2022-10-20', '2022-10-23', 'Jose Francisco Silva', '35998877898', null, 1);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2020-02-20', '2020-02-15', '2020-02-21', 'Bruna Ferreira Bontempo', '35988567845', '2022-10-01', 1);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2022-01-05', '2022-01-05', '2022-01-06', 'Gisele Almeida', '35999235165', null, 1);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2022-05-02', '2022-04-30', '2022-05-02', 'João Paulo Assis', '35988672477', null, 2);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2021-06-05', '2021-06-04', '2021-06-05', 'Tayná Borges de Jesus', '35999856214', null, 2);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2022-03-01', '2022-02-25', '2022-03-02', 'Rangel de Oliveira Filho', '11987564188', null, 2);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2018-08-15', '2018-08-10', '2018-08-17', 'Julia da Silva Rocha', '35999884563', null, 3);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2019-01-05', '2018-12-30', '2019-01-05', 'Denilson Carvalho Neto', '32998564120', null, 3);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2021-03-01', '2021-03-01', '2021-03-02', 'Bianca Costa da Silva', null, '2021-06-01', 3);

-----------------------------------------Inserts Equipamentos e Estações de trabalho-----------------------------------------
--Devices
INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'Dell', 'Servidor', 'Servidor Proxy PfSense', '192.168.1.1', '01:23:45:67:89:AB', 'Power Edge 300', 1);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'Dell', 'Servidor', 'Servidor Arquivo/Dominio', '192.168.1.250', '8A:52:HB:7E:89:2F', 'Power Edge 350', 1);

--WorkStations
INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '192.168.1.10', '1A:25:4G:87:5H:99', 'Latitute 5022', 'Excelente', '10', 'SSD 480GB', 'XYZ12', 'Escritorio', '2018-05-01', 'Windows 10', 'intel i7', '8GB', 1);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '192.168.1.15', '55:S3:87:EE:5R:7A', 'Inspiron 4020', 'Ruim', '4', 'HD 500GB', 'XYZ15', 'Depósito', '2014-03-01', 'Windows 10', 'intel i3', '4GB', 1);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '192.168.1.16', 'A5:SW:27:EF:52:8Q', 'Inspiron 4880', 'Meio-Termo', '7', 'SSD 240GB', 'XYZ13', 'RH', '2016-02-01', 'Windows 10', 'intel i5', '8GB', 1);

--Devices
INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'IntelBras', 'Access Point', 'Access Point Bridge', '192.168.2.1', '54:72:F5:EE:7A:6W', 'A52S', 2);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'Dell', 'Servidor', 'Servidor Arquivo/Dominio', '192.168.2.200', '83:C2:K7:96:8I:8F', 'Power Edge 320', 2);

--WorkStations
INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'HP', 'Estação de trabalho', 'Disponivel', '192.168.2.50', '3A:85:DT:35:7P:OT', 'EliteBook 550', 'Excelente', '12', 'SSD 480GB', 'CTO04', 'Recepção', '2020-05-01', 'Windows 11', 'intel i7', '8GB', 2);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '192.168.1.15', '55:S3:87:EE:5R:7A', 'Inspiron 4020', 'Ruim', '4', 'HD 500GB', 'CTO05', 'Depósito', '2014-03-01', 'Windows 10', 'intel i3', '4GB', 2);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '192.168.1.16', 'A5:SW:27:EF:52:8Q', 'Inspiron 4880', 'Meio-Termo', '7', 'SSD 240GB', 'CTO06', 'RH', '2016-02-01', 'Windows 10', 'intel i5', '8GB', 2);

--Devices
INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'IntelBras', 'Roteador', 'Roteador', '10.20.4.1', '85:AQ:7C:32:7V:X2', 'BXZ87', 3);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'Dell', 'Servidor', 'Servidor Arquivo/Dominio', '10.20.4.250', '89:W4:4D:83:CX:08', 'Power Edge 350', 3);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, client_id)
VALUES(1, 'HP', 'Servidor', 'Servidor de Aplicativos', '10.20.4.251', 'C7:21:8A:9P:7Q:5L', 'EliteServer 780', 3);

--WorkStations
INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Pichau', 'Estação de trabalho', 'Disponivel', '10.20.4.11', '4J:36:79:Z7:8Q:34', 'Montado', 'Ruim', '8', 'SSD 240GB', 'MNB04', 'Recepção', '2020-05-01', 'Windows 10', 'AMD rx', '8GB', 3);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '10.20.4.12', 'W5:S3:29:EE:5R:XZ', 'Inspiron 4020', 'Ruim', '4', 'HD 500GB', 'MNB05', 'Depósito', '2014-03-01', 'Windows 10', 'intel i3', '4GB', 3);

INSERT INTO t_device (dtype, brand, category, description, ip_address, mac_address, model, condition, gen_processor, hdssd, label, location, manufacturing_date, operational_system, processor, ram, client_id)
VALUES(2, 'Dell', 'Estação de trabalho', 'Disponivel', '10.20.4.13', '23:SW:27:EF:52:13', 'Inspiron 4880', 'Meio-Termo', '7', 'SSD 240GB', 'MNB07', 'RH', '2016-02-01', 'Windows 10', 'intel i5', '8GB', 3);

