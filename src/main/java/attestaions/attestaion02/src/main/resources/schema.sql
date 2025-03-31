CREATE TABLE IF NOT EXISTS users (
    id bigserial PRIMARY KEY,
    fio varchar
);

COMMENT ON TABLE users IS 'Таблица пользователей';
insert into users (id, fio) values  (1,'Иванов Иван Иванович'),
insert into users (id, fio) values  (2,'Петров Петр Петрович'),
insert into users (id, fio) values  (3,'Сидоров Сидр Сидорович'),
insert into users (id, fio) values  (4,'Кузнецов Кузьма Кузьмич'),
insert into users (id, fio) values  (5,'Карпов Карп Карпович'),
insert into users (id, fio) values  (6,'Карпова Алина Карпинична'),
insert into users (id, fio) values  (7,'Сидорова Алина Ивановна'),
insert into users (id, fio) values  (8,'Иванова Татьяна Ивановна'),
insert into users (id, fio) values  (9,'Петрова Ирина Петровна'),
insert into users (id, fio) values  (10,'Сидорова Светлана Сидоровна'),



CREATE TABLE IF NOT EXISTS product (
id bigserial PRIMARY KEY,
name_product VARCHAR,
price numeric,
amount numeric
);
COMMENT ON TABLE product IS 'Таблица продуктов';
insert into product (id, name_product, price, amount) values  (1,'Молоко', 100, 10),
insert into product (id, name_product, price, amount) values  (2,'Хлеб', 10, 100),
insert into product (id, name_product, price, amount) values  (3,'Масло', 1000, 10),
insert into product (id, name_product, price, amount) values  (4,'Сыр', 100, 10),
insert into product (id, name_product, price, amount) values  (5,'Мороженое', 100, 10),
insert into product (id, name_product, price, amount) values  (6,'Кефир', 100, 10),
insert into product (id, name_product, price, amount) values  (7,'Картофель', 100, 10),
insert into product (id, name_product, price, amount) values  (8,'Макароны', 100, 10),
insert into product (id, name_product, price, amount) values  (9,'Мука', 100, 10),
insert into product (id, name_product, price, amount) values  (10,'Масло', 100, 10),






CREATE TABLE IF NOT EXISTS "orders" (
product_id bigint REFERENCES product(id),
users_id bigint REFERENCES users(id),
data_order date,
quantity numeric
);

COMMENT ON TABLE "orders" IS 'Таблица заказов';
insert into "orders" (product_id, users_id, data_order, quantity) values  (1,1,'2021-01-01', 10),
insert into "orders" (product_id, users_id, data_order, quantity) values  (2,5,'2021-01-01', 15);
insert into "orders" (product_id, users_id, data_order, quantity) values  (3,10,'2021-01-01', 10);
insert into "orders" (product_id, users_id, data_order, quantity) values  (4,7,'2021-01-01', 10);
insert into "orders" (product_id, users_id, data_order, quantity) values  (5,9,'2021-01-01', 10);
insert into "orders" (product_id, users_id, data_order, quantity) values  (6,1,'2021-01-01', 10);
insert into "orders" (product_id, users_id, data_order, quantity) values  (7,5,'2021-01-01', 10),
insert into "orders" (product_id, users_id, data_order, quantity) values  (8,3,'2021-01-01', 10),
insert into "orders" (product_id, users_id, data_order, quantity) values  (9,6,'2021-01-01', 10),
insert into "orders" (product_id, users_id, data_order, quantity) values  (10,4,'2021-01-01', 10),






