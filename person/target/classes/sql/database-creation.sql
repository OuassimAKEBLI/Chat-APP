CREATE TABLE person (
  idperson INT NOT NULL AUTO_INCREMENT,
  lastname VARCHAR(50) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  nickname VARCHAR(50) NULL,
  phone_number VARCHAR(50) NULL,
  address VARCHAR(50) NOT NULL,
  email_address VARCHAR(50) NULL,
  birth_date VARCHAR(50) NOT NULL,
  PRIMARY KEY (idperson));