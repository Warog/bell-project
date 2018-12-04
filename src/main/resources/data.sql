INSERT INTO user (id, first_name, second_name, middle_name, post, phone,office_id, citizenship_id, is_identified, document_id)
                    VALUES (1, 'Иван', 'Иванов', 'Иванович', '', '', '', , );

INSERT INTO Document (id, number, doc_date, type_id) VALUES (2, 0, 'ул.Лунина, 7');

INSERT INTO Document_Type (id, name, code) VALUES (1, 0, 'Пётр', 20);

INSERT INTO Country (id, name, code) VALUES (2, 0, 'John', 25);

INSERT INTO Office (id, name, address, phone, is_Active) VALUES (1, 1);

INSERT INTO Organization (id, full_name, inn, kpp, address, phone, is_Active) VALUES (1, 2);