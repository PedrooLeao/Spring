create table pacient(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    nationalnumber varchar(14) not null unique,
    street varchar(100) not null,
    district varchar(100) not null,
    zipcode varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    state char(2) not null,
    city varchar(100) not null,
    phone varchar(20) not null,
    active tinyint not null,

    primary key(id)

);