CREATE TABLE stock_operation (
    id uuid default uuid_generate_v4(),
    stock varchar not null,
    operation_type varchar not null,
    quantity integer not null,
    value double precision not null,
    primary key (id)
);
