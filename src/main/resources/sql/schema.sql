create table if not exists account_info
(
    id      serial primary key,
    balance bigint not null
);


create table if not exists payment_info
(
    paymentId   bigint,
    accountId   bigint references account_info(id),
    paymentDate varchar,
    amount      bigint
);
