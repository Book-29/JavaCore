select * from "public".users u where u.id=2
select * from users
delete from users where id=2

select * from orders where users_id=5
select * from orders
delete from orders where users_id=5

select * from product
select * from product where id=8
insert into product (id, name_product, price, amount) values (11,'test', 100, 15)
update product set name_product='test' where id=8
