CREATE TABLE "User" (
    id varchar not null primary key,
    email varchar not null unique,
    name varchar,
    password varchar not null,
    birth_date timestamp not null,
    status varchar not null
)