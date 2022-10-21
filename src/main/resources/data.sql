-----------------------------------------Inserts Cliente-----------------------------------------
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

-----------------------------------------Inserts Colaborador-----------------------------------------
INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2022-10-21', '2022-10-20', '2022-10-23', 'Jose Francisco Silva', '35998877898', null, 1);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2020-02-20', '2020-02-15', '2020-02-21', 'Bruna Ferreira Bontempo', '35988567845', '2022-10-01', 1);

INSERT INTO t_employee (admission_date, created_at, integration_date, name, phone_number, resignation_date, client_id)
VALUES('2022-01-05', '2022-01-05', '2022-01-06', 'Gisele Almeida', '35999235165', null, 1);
