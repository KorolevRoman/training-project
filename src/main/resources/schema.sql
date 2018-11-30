CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(45) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  inn       VARCHAR(12) UNIQUE NOT NULL,
  kpp       VARCHAR(9) NOT NULL,
  address   VARCHAR(100) NOT NULL,
  phone     VARCHAR(11),
  is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office(
  id              INTEGER PRIMARY KEY AUTO_INCREMENT,
  organization_id INTEGER NOT NULL,
  name            VARCHAR(45) NOT NULL,
  address         VARCHAR(100) NOT NULL,
  phone           VARCHAR(11),
  is_active       BOOLEAN NOT NULL
);

ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);
CREATE INDEX IX_Office_organization_id ON Office (organization_id);

CREATE TABLE IF NOT EXISTS Citizenship (
  id   INTEGER PRIMARY KEY AUTO_INCREMENT,
  code INTEGER NOT NULL,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
  id   INTEGER PRIMARY KEY AUTO_INCREMENT,
  code INTEGER NOT NULL,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee (
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(45) NOT NULL,
    second_name     VARCHAR(45) NOT NULL,
    middle_name     VARCHAR(45),
    position        VARCHAR(45) NOT NULL,
    document_id     INTEGER,
    document_date   DATE,
    document_number VARCHAR(20) UNIQUE NOT NULL,
    citizenship_id  INTEGER,
    office_id       INTEGER NOT NULL
);

ALTER TABLE Employee ADD FOREIGN KEY (document_id) REFERENCES Document(id);
ALTER TABLE Employee ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);
ALTER TABLE Employee ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Employee_document_id ON Employee (document_id);
CREATE INDEX IX_Employee_citixenship_id ON Employee (citizenship_id);
CREATE INDEX IX_Employee_office_id ON Employee (office_id);

CREATE INDEX UX_Employee_document_number ON Employee (document_number);
CREATE INDEX IX_Employee_first_name ON Employee (first_name);
CREATE INDEX IX_Employee_second_name ON Employee (second_name);

CREATE INDEX UX_Organization_inn ON Organization (inn);
CREATE INDEX IX_Organization_name ON Organization (name);
CREATE INDEX IX_Organization_full_name ON Organization (full_name);
CREATE INDEX IX_Organization_phone ON Organization (phone);
CREATE INDEX IX_Organization_is_active ON Organization (is_active);

CREATE INDEX IX_Office_name ON Office (name);
CREATE INDEX IX_Office_is_active ON Office (is_active);


