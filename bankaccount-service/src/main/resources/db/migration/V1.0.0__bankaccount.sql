CREATE TABLE bank_account (
    id uuid default uuid_generate_v4(),
    user_id varchar not null,
    name varchar not null,
    status varchar not null,
    primary key (id)
);
