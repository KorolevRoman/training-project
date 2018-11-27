CREATE TABLE IF NOT EXISTS Employee (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR (45) NOT NULL,
    second_name VARCHAR (45),
    middle_name VARCHAR (45),
    position VARCHAR (45),
    document_id INTEGER,
    document_date DATE,
    document_number VARCHAR(20),
    citizenship_id INTEGER
);

CREATE TABLE IF NOT EXISTS Citizenship (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  code INTEGER NOT NULL,
  name VARCHAR(45) NOT NULL,
);

CREATE TABLE IF NOT EXISTS Document (
   id INTEGER PRIMARY KEY AUTO_INCREMENT,
   code_document INTEGER NOT NULL,
   name_document VARCHAR(45) NOT NULL,
);