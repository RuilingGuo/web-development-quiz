create table product
(
    id int primary key auto_increment,
    product_name varchar(50) not null,
    price Float null,
    unit varchar(50) not null,
    img_url varchar(1000) not null
);

