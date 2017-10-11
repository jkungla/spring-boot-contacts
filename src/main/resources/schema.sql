CREATE TABLE contacts (
  id          INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  email   VARCHAR(64),
  address VARCHAR(128));