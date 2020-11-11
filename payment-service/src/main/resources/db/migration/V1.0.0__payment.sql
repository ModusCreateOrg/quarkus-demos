CREATE TABLE payment (
    id varchar not null primary key,
    order_id varchar not null,
    user_id varchar not null,
    value decimal not null
);

insert into payment (id, order_id, user_id, value)
values ('1', '1', '1', 10), ('2', '2', '2', 2), ('3', '3', '3', 30)