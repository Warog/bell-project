CREATE TABLE IF NOT EXISTS User (
id INTEGER COMMENT 'Уникальный идентификатор пользователя' PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) COMMENT 'Имя пользователя' NOT NULL,
second_name VARCHAR(50) COMMENT 'Фамилия пользователя',
middle_name VARCHAR(50) COMMENT 'Отчество пользователя',
post VARCHAR(50) COMMENT 'Должность пользователя' NOT NULL,
phone VARCHAR(20) COMMENT 'Номер телефона',
office_id BIGINT COMMENT 'Идентификатор офиса',
citizenship_id INTEGER COMMENT 'Идентификатор гражданства',
is_identified BOOLEAN COMMENT 'Статус'
document_id BIGINT COMMENT 'Идентификатор документа',

FOREIGN KEY (office_id) REFERENCES Office(id),
FOREIGN KEY (citizenship_id) REFERENCES Country(id),
FOREIGN KEY (document_id) REFERENCES Document(id)
);

CREATE TABLE IF NOT EXISTS Country (
id INTEGER COMMENT 'Уникальный идентификатор страны' PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) COMMENT 'Страна',
code INTEGER COMMENT 'Код страны'
);

CREATE TABLE IF NOT EXISTS Document (
id BIGINT COMMENT 'Уникальный идентификатор документа' PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) COMMENT 'Документ',
code INTEGER COMMENT 'Код документа'
);

CREATE TABLE IF NOT EXISTS Office (
id BIGINT COMMENT 'Уникальный идентификатор офиса' PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) COMMENT 'Название офиса',
address VARCHAR(100) COMMENT 'Адрес офиса',
phone VARCHAR(20) COMMENT 'Телефон офиса',
is_Active BOOLEAN COMMENT 'Статус'
);

CREATE TABLE IF NOT EXISTS Organization (
id BIGINT COMMENT 'Уникальный идентификатор организации' PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) COMMENT 'Имя организации' NOT NULL,
full_name VARCHAR(50) COMMENT 'Полное имя организации' NOT NULL,
inn INTEGER COMMENT 'ИНН' NOT NULL,
kpp INTEGER COMMENT 'КПП' NOT NULL,
address VARCHAR(100) COMMENT 'Адрес организации' NOT NULL,
phone BIGINT COMMENT 'Телефон организации',
is_Active BOOLEAN COMMENT 'Статус'
);