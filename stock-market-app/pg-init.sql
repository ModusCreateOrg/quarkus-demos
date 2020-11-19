CREATE DATABASE operations_service;
CREATE USER operations_service WITH ENCRYPTED PASSWORD 'operations_service';
GRANT ALL PRIVILEGES ON DATABASE operations_service TO operations_service;

\c operations_service;
CREATE EXTENSION "uuid-ossp";