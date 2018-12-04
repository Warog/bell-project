INSERT INTO Office (id, name, address, phone, is_Active) VALUES (1, 'Спартак', 'Новоданиловская набережная, 17', '9612369', TRUE);
INSERT INTO Country (id, name, code) VALUES (1, 'Россия', '+7');
INSERT INTO Document_Type (id, name, code) VALUES(1, 'Паспорт', 1);
INSERT INTO Document (id, number, doc_date, type_id) VALUES (1, '210928', {ts '2012-09-17 18:47:52.69'}, 1);
INSERT INTO Client (id, first_name, second_name, middle_name, post, phone, office_id, citizenship_id, is_identified, document_id)
                    VALUES (1, 'Иван', 'Иванов', 'Иванович', 'Охранник', '234567', '1', '1', TRUE, 1);

