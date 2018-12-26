INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, is_active) VALUES (1, 0, 'Тройка', 'ООО Тройка', '581214233562', '580336041', 'ул. Ленина, 12', true);
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, is_active) VALUES (2, 0, 'АТП', 'Автотранспортное предприятие', '581214234562', '580332051', 'ул. Москвовская, 22', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active) VALUES (1, 0, 1, 'Центральный', 'ул. Ленина, 12', '78412550012', true);
INSERT INTO Office (id, version, organization_id, name, address, phone, is_active) VALUES (2, 0, 1, 'Обособленный', 'ул. Пушкина, 45', '78412550014', true);
INSERT INTO Office (id, version, organization_id, name, address, phone, is_active) VALUES (3, 0, 2, 'Главный', 'ул. Москвовская, 22', '78412680212', true);

INSERT INTO Citizenship (code, name) VALUES (643, 'Россия');
INSERT INTO Citizenship (code, name) VALUES (112, 'Беларусь');
INSERT INTO Citizenship (code, name) VALUES (398, 'Казахстан');

INSERT INTO Document_type (code, name) VALUES (21, 'Паспорт гражданина РФ');
INSERT INTO Document_type (code, name) VALUES (12, 'Вид на жительство');
INSERT INTO Document_type (code, name) VALUES (07, 'Военный билет');
INSERT INTO Document_type (code, name) VALUES (10, 'Иностранный паспорт');

INSERT INTO Employee (id, version, first_name, second_name, middle_name, position, citizenship, office_id)
VALUES (1, 0, 'Иванов', 'Иван', 'Иванович', 'менеджер', 643, 1);
INSERT INTO Employee (id, version, first_name, second_name, middle_name, position, citizenship, office_id)
VALUES (2, 0, 'Петров', 'Петр', 'Петрович', 'разработчик', 112, 2);
INSERT INTO Employee (id, version, first_name, second_name, middle_name, position, citizenship, office_id)
VALUES (3, 0, 'Васильев', 'Василий', 'Васильевич', 'директор', 643, 3);
INSERT INTO Employee (id, version, first_name, second_name, position, citizenship, office_id)
VALUES (4, 0, 'Сулейманов', 'Ким', 'аналитик', 398, 3);

INSERT INTO Document (id, employee_id, code, date_issue, number) VALUES (1, 1, 21, '2001-11-20', '5612 321464');
INSERT INTO Document (id, employee_id, code, date_issue, number) VALUES (2, 2, 10, '2005-08-16', '67884304');
INSERT INTO Document (id, employee_id, code, date_issue, number) VALUES (3, 3, 21, '2010-04-23', '5612 432942');
INSERT INTO Document (id, employee_id, code, date_issue, number) VALUES (4, 4, 12, '2018-04-23', 'ВА 432421');
INSERT INTO Document (id, employee_id, code, date_issue, number) VALUES (5, 2, 07, '2005-08-30', 'I-КИ 432351');
