CREATE DATABASE user_service;
CREATE USER user_service WITH ENCRYPTED PASSWORD 'user_service';
GRANT ALL PRIVILEGES ON DATABASE user_service TO user_service;

CREATE DATABASE people_service;
CREATE USER people_service WITH ENCRYPTED PASSWORD 'people_service';
GRANT ALL PRIVILEGES ON DATABASE people_service TO people_service;

CREATE DATABASE bankaccount_service;
CREATE USER bankaccount_service WITH ENCRYPTED PASSWORD 'bankaccount_service';
GRANT ALL PRIVILEGES ON DATABASE bankaccount_service TO bankaccount_service;

\c bankaccount_service;
CREATE EXTENSION "uuid-ossp";