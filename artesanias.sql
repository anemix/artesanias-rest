create database artesanias;

use artesanias;

drop table product;

create table product(
	id int primary key auto_increment,
	name varchar(200),
    price double,
    description text
)

select * from product;