INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_Active) VALUES (1, 1, 'МТС', 'Мобильные ТелеСистемы', 3123, 312312, 'ул. Тверская-Ямкая, 32', '567281828', TRUE);
INSERT INTO Office (id, version, name, address, phone, is_Active, org_id) VALUES (1, 1, 'Спартак', 'Новоданиловская набережная, 17', '9612369', TRUE, 1);
INSERT INTO Country (id, version, name, code) VALUES (1, 1, 'Россия', '+7');
INSERT INTO Document_Type (id, version, name, code) VALUES(1, 1, 'Паспорт', 1);
INSERT INTO Document (id, version, number, doc_date, type_id) VALUES (1, 1, '210928', {ts '2012-09-17 18:47:52.69'}, 1);
INSERT INTO Client (id, version, first_name, second_name, middle_name, post, phone, citizenship_id, is_identified)
                    VALUES (1, 1, 'Иван', 'Иванов', 'Иванович', 'Охранник', '234567', '1', TRUE);

