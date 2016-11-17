create database if not exists artesanias;

use artesanias;

create table product(
	id int primary key auto_increment,
	name varchar(200),
    price double,
    description text
);

create TRIGGER sell_out after INSERT on shopping
  FOR EACH ROW
   update product set stock = stock - new.quantity where id = new.product_id