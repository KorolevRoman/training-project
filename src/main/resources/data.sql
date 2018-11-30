INSERT INTO Organization (id, name, full_name, inn, kpp, address, is_active) VALUES (1, 'Тройка', 'ООО Тройка', '581214233562', '580336041', 'ул. Ленина, 12', true);
INSERT INTO Organization (id, name, full_name, inn, kpp, address, is_active) VALUES (2, 'АТП', 'Автотранспортное предприятие', '581214234562', '580332051', 'ул. Москвовская, 22', true);

INSERT INTO Office (id, organization_id, name, address, phone, is_active) VALUES (1, 1, 'Центральный', 'ул. Ленина, 12', '78412550012', true);
INSERT INTO Office (id, organization_id, name, address, phone, is_active) VALUES (2, 1, 'Обособленный', 'ул. Пушкина, 45', '78412550014', true);
INSERT INTO Office (id, organization_id, name, address, phone, is_active) VALUES (3, 2, 'Главный', 'ул. Москвовская, 22', '78412680212', true);

INSERT INTO Citizenship (id, code, name) VALUES (1, 643, 'Россия');
INSERT INTO Citizenship (id, code, name) VALUES (2, 112, 'Беларусь');
INSERT INTO Citizenship (id, code, name) VALUES (3, 398, 'Казахстан');

INSERT INTO Document (id, code, name) VALUES (1, 21, 'Паспорт гражданина РФ');
INSERT INTO Document (id, code, name) VALUES (2, 12, 'Вид на жительство');
INSERT INTO Document (id, code, name) VALUES (3, 21, 'Военный билет');
INSERT INTO Document (id, code, name) VALUES (4, 10, 'Иностранный паспорт');

INSERT INTO Employee (id, first_name, second_name, middle_name, position, document_id, document_date, document_number, citizenship_id, office_id)
  VALUES (1, 'Иванов', 'Иван', 'Иванович', 'менеджер', 1, '2001-11-20', '5612 321464', 1, 1);
INSERT INTO Employee (id, first_name, second_name, middle_name, position, document_id, document_date, document_number, citizenship_id, office_id)
  VALUES (2, 'Петров', 'Петр', 'Петрович', 'разработчик', 4, '2005-08-16', '67884304', 2, 2);
INSERT INTO Employee (id, first_name, second_name, middle_name, position, document_id, document_date, document_number, citizenship_id, office_id)
  VALUES (3, 'Васильев', 'Василий', 'Васильевич', 'директор', 1, '2010-04-23', '5612 432942', 1, 3);
INSERT INTO Employee (id, first_name, second_name, position, document_id, document_date, document_number, citizenship_id, office_id)
  VALUES (4, 'Сулейманов', 'Ким', 'аналитик', 2, '2018-04-23', 'ВА 432421', 3, 3);