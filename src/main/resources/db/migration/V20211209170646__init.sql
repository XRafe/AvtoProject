create table avto.firmavto
(
    id         int IDENTITY(1,1) primary key,
    firm       varchar(30)     not null
);

create table avto.modelavto
(
    id         int IDENTITY(1,1) primary key,
    model      varchar(30)     not null,
    price      int         not null,
    id_firm    int         not null
        references avto.firmavto (id)
);

create table avto.useravto
(
    id         int IDENTITY(1,1) primary key ,
    login      varchar(30)     not null,
    password   varchar(80)     not null
);

create table avto.orderavto
(
    id         int IDENTITY(1,1) primary key ,
    count      int         not null,
    sum        int         not null,
    id_model   int         not null
        references avto.modelavto (id),
    id_user    int         not null
        references avto.useravto (id)
);

create table avto.role
(
    id   int primary key,
    code varchar(30) not null
);


create table avto.user_role
(
    id      int IDENTITY(1,1) primary key,
    user_id int not null
        references avto.useravto (id),
    role_id int not null
        references avto.role (id)
);
