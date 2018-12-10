CREATE TABLE IF NOT EXISTS Office (
id BIGINT COMMENT 'Уникальный идентификатор офиса' PRIMARY KEY AUTO_INCREMENT,
version INTEGER COMMENT 'Служебное поле hibernate' NOT NULL,
name VARCHAR(50) COMMENT 'Название офиса',
address VARCHAR(100) COMMENT 'Адрес офиса',
phone VARCHAR(20) COMMENT 'Телефон офиса',
is_Active BOOLEAN COMMENT 'Статус',
org_id BIGINT COMMENT 'id организации' NOT NULL,

FOREIGN KEY (org_id) REFERENCES Organization(id)
);
COMMENT ON TABLE Office IS 'Офисы';

CREATE TABLE IF NOT EXISTS Document_Type (
id BIGINT COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
version INTEGER COMMENT 'Служебное поле hibernate' NOT NULL,
name VARCHAR(50) COMMENT 'Вид/Тип документа',
code VARCHAR(10) COMMENT 'Код типа документа'
);
COMMENT ON TABLE Document_Type IS 'Тип документа пользователя';

CREATE TABLE IF NOT EXISTS Country (
id INTEGER COMMENT 'Уникальный идентификатор страны' PRIMARY KEY AUTO_INCREMENT,
version INTEGER COMMENT 'Служебное поле hibernate' NOT NULL,
name VARCHAR(50) COMMENT 'Страна',
code VARCHAR(10) COMMENT 'Код страны'
);
COMMENT ON TABLE Country IS 'Страны';

CREATE TABLE IF NOT EXISTS Organization (
id BIGINT COMMENT 'Уникальный идентификатор организации' PRIMARY KEY AUTO_INCREMENT,
version INTEGER COMMENT 'Служебное поле hibernate' NOT NULL,
name VARCHAR(50) COMMENT 'Имя организации' NOT NULL,
full_name VARCHAR(50) COMMENT 'Полное имя организации' NOT NULL,
inn VARCHAR(50) COMMENT 'ИНН' NOT NULL,
kpp VARCHAR(50) COMMENT 'КПП' NOT NULL,
address VARCHAR(100) COMMENT 'Адрес организации' NOT NULL,
phone VARCHAR(20) COMMENT 'Телефон организации',
is_Active BOOLEAN COMMENT 'Статус'
);
COMMENT ON TABLE Organization IS 'Организации';

CREATE TABLE IF NOT EXISTS Document (
id BIGINT COMMENT 'Уникальный идентификатор документа' PRIMARY KEY AUTO_INCREMENT,
version INTEGER COMMENT 'Служебное поле hibernate' NOT NULL,
number VARCHAR(20) COMMENT 'Номер документа',
doc_date DATE COMMENT 'Дата получения документа',
type_id BIGINT COMMENT 'ID типа документа',

FOREIGN KEY (type_id) REFERENCES Document_Type(id)
);
COMMENT ON TABLE Document IS 'Документы пользователей';

CREATE TABLE IF NOT EXISTS Client (
id INTEGER COMMENT 'Уникальный идентификатор пользователя' PRIMARY KEY AUTO_INCREMENT,
version INTEGER COMMENT 'Служебное поле hibernate' NOT NULL,
first_name VARCHAR(50) COMMENT 'Имя пользователя' NOT NULL,
second_name VARCHAR(50) COMMENT 'Фамилия пользователя',
middle_name VARCHAR(50) COMMENT 'Отчество пользователя',
post VARCHAR(50) COMMENT 'Должность пользователя' NOT NULL,
phone VARCHAR(20) COMMENT 'Номер телефона',
citizenship_id VARCHAR(10) COMMENT 'Идентификатор гражданства',
is_identified BOOLEAN COMMENT 'Статус',

FOREIGN KEY (office_id) REFERENCES Office(id),
FOREIGN KEY (citizenship_id) REFERENCES Country(id),
FOREIGN KEY (document_id) REFERENCES Document(id)
);
COMMENT ON TABLE Client IS 'Пользователи';

----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS User_Document (
document_id INTEGER COMMENT 'Идентификатор документа',
user_id INTEGER COMMENT 'Идентификатор пользователя',

PRIMARY KEY (document_id, user_id),

FOREIGN KEY (user_id) REFERENCES Client(id)
);
COMMENT ON TABLE User_Document IS 'Связующая(кросс) таблица пользователь --> документы';

CREATE TABLE IF NOT EXISTS User_Office (
user_id INTEGER COMMENT 'Идентификатор пользователя',
office_id INTEGER COMMENT 'Идентификатор офиса',

PRIMARY KEY (user_id, office_id),

FOREIGN KEY (user_id) REFERENCES Client(id)
FOREIGN KEY (office_id) REFERENCES Office(id)
);
COMMENT ON TABLE User_Office IS 'Связующая(кросс) таблица "пользователь --> офисы"';

CREATE INDEX IX_Client_Office_Id ON Office (id);
CREATE INDEX IX_Client_Citizenship_Id ON Country (id);
CREATE INDEX IX_Client_Document_Id ON Document (id);
CREATE INDEX IX_Document_Type_Id ON Document_Type (id);
CREATE INDEX IX_Document_User_Id ON User_Document (user_id);
CREATE INDEX IX_User_Office_User_Id ON User_Office (user_id);
CREATE INDEX IX_User_Office_Office_Id ON User_Office (office_id);
CREATE INDEX IX_User_Document_User_Id ON User_Document (user_id);
CREATE INDEX IX_Office_Organization_Id ON Organization (id);

--CREATE INDEX UX_User_id ON User (id);
--CREATE INDEX UX_Country_id ON Country(id);
--CREATE INDEX UX_User_Document_id ON User_Document(id);
--CREATE INDEX UX_Office_Id ON Office(id);
--CREATE INDEX UX_Organization_id ON Organization(id);
