CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(45) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  inn       VARCHAR(12) UNIQUE NOT NULL,
  kpp       VARCHAR(9) NOT NULL,
  address   VARCHAR(100) NOT NULL,
  phone     VARCHAR(11),
  is_active BOOLEAN NOT NULL
);

CREATE INDEX UX_Organization_inn ON Organization (inn);
CREATE INDEX IX_Organization_name ON Organization (name);
CREATE INDEX IX_Organization_full_name ON Organization (full_name);
CREATE INDEX IX_Organization_phone ON Organization (phone);
CREATE INDEX IX_Organization_is_active ON Organization (is_active);

COMMENT ON TABLE Organization IS 'Таблица хранит информацию об организациях';
COMMENT ON COLUMN Organization.address IS 'В колонке хранится юридический адрес организации';
COMMENT ON COLUMN Organization.is_active IS 'Если true, то организация действующая, если false, то закрыта';

-------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Office(
  id              INTEGER PRIMARY KEY AUTO_INCREMENT,
  organization_id INTEGER NOT NULL,
  name            VARCHAR(45) NOT NULL,
  address         VARCHAR(100) NOT NULL,
  phone           VARCHAR(11),
  is_active       BOOLEAN NOT NULL
);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);
CREATE INDEX IX_Office_name ON Office (name);
CREATE INDEX IX_Office_address ON Office(address);
CREATE INDEX IX_Office_phone ON Office(phone);
CREATE INDEX IX_Office_is_active ON Office (is_active);

COMMENT ON TABLE Office IS 'Таблица хранит информацию об офисах организациии';
COMMENT ON COLUMN Office.organization_id IS 'в колонке хранится id организации, которой принадлежит офис';
COMMENT ON COLUMN Office.address IS 'В колонке хранится фактический адрес офиса';
COMMENT ON COLUMN Office.is_active IS 'Если true, то офис действующий, если false, то недействующий';

--------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Citizenship (
  code INTEGER PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

COMMENT ON TABLE Citizenship IS 'Таблица хранит информацию о видах гражданств сотрудников';

--------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Document_type (
  code INTEGER PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

COMMENT ON TABLE Document_type IS 'Таблица хранит информацию о видах документов, удостоверяющих личность';

---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Employee (
id              INTEGER PRIMARY KEY AUTO_INCREMENT,
first_name      VARCHAR(45) NOT NULL,
second_name     VARCHAR(45) NOT NULL,
middle_name     VARCHAR(45),
position        VARCHAR(45) NOT NULL,
citizenship     INTEGER,
office_id       INTEGER NOT NULL
);

COMMENT ON TABLE Employee IS 'Таблица хранит информацию о сотрудниках организации';
COMMENT ON COLUMN Employee.first_name IS 'Фамилия';
COMMENT ON COLUMN Employee.second_name IS 'Имя';
COMMENT ON COLUMN Employee.middle_name IS 'Отчество';
COMMENT ON COLUMN Employee.position IS 'Должность сотрудника';
COMMENT ON COLUMN Employee.citizenship IS 'гражданство сотрудника';
COMMENT ON COLUMN Employee.office_id IS 'офис, в котором работает сотрудник';

ALTER TABLE Employee ADD FOREIGN KEY (citizenship) REFERENCES Citizenship(code);
ALTER TABLE Employee ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Employee_first_name ON Employee (first_name);
CREATE INDEX IX_Employee_second_name ON Employee (second_name);

---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Document (
  id           INTEGER PRIMARY KEY AUTO_INCREMENT,
  employee_id  INTEGER NOT NULL,
  code         INTEGER NOT NULL,
  date_issue   DATE NOT NULL,
  number       VARCHAR(20) UNIQUE NOT NULL,
);

ALTER TABLE Document ADD FOREIGN KEY (code) REFERENCES Document_type(code);
ALTER TABLE Document ADD FOREIGN KEY (employee_id) REFERENCES Employee (id);

COMMENT ON TABLE Document IS 'Таблица хранит информацию о документе, удостоверяющем личность сотрудника';
COMMENT ON COLUMN Document.employee_id IS 'сотрудник, которому принадлежит документ';
COMMENT ON COLUMN Document.date_issue IS 'дата выдачи документа, удостоверяющего личность';
COMMENT ON COLUMN Document.number IS 'серия и номер документа, удостоверяющего личность';

CREATE INDEX UX_Document_number ON Document (number);

----------------------------------------------------------------------------------------------------------------