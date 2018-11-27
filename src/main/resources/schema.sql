CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(45) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  inn       VARCHAR(12) UNIQUE NOT NULL,
  kpp       VARCHAR(9) NOT NULL,
  adres     VARCHAR(100) NOT NULL,
  phone     VARCHAR (11),
  is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office(
  id              INTEGER PRIMARY KEY AUTO_INCREMENT,
  organization_id INTEGER NOT NULL,
  name            VARCHAR (45),
  adres           VARCHAR (100),
  phone           VARCHAR (11),
  is_active       BOOLEAN
);

ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE TABLE IF NOT EXISTS Citizenship (
  id   INTEGER PRIMARY KEY AUTO_INCREMENT,
  code INTEGER NOT NULL,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
  id            INTEGER PRIMARY KEY AUTO_INCREMENT,
  code_document INTEGER NOT NULL,
  name_document VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee (
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR (45) NOT NULL,
    second_name     VARCHAR (45),
    middle_name     VARCHAR (45),
    position        VARCHAR (45),
    document_id     INTEGER,
    document_date   DATE,
    document_number VARCHAR(20),
    citizenship_id  INTEGER,
    office_id       INTEGER NOT NULL
);

ALTER TABLE Employee ADD FOREIGN KEY (document_id) REFERENCES Document(id);
ALTER TABLE Employee ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);
ALTER TABLE Employee ADD FOREIGN KEY (office_id) REFERENCES Office(id);



