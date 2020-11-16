CREATE TABLE payment (
    id uuid default uuid_generate_v4(),
    order_id varchar not null,
    user_id varchar not null,
    value decimal not null,
    primary key (id)
);

insert into payment (order_id, user_id, value)
values ('1', '1', 10), ('2', '2', 2), ('3', '3', 30)