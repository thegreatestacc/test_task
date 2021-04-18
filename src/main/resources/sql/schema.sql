create table if not exists account
(
    id      serial primary key,
    balance bigint not null
);