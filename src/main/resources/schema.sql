create table if not exists `user`
(
    id       varchar(50) not null,
    password varchar(50) not null,
    age      int         not null,
    primary key (id)
);
