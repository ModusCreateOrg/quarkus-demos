CREATE TABLE person (
    id varchar not null primary key,
    email varchar not null unique,
    first_name varchar not null,
    middle_name varchar,
    last_name varchar not null,
    birth_date timestamp not null,
    register_date timestamp not null,
    social_security varchar not null,
    status varchar not null default 'ACTIVE',
    issued_state varchar not null
)