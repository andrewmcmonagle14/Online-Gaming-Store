select * from Customer
select * from Orders
select * from Product
select * from product_order
select * from review
select * from pc
select * from console

ALTER TABLE product
DROP COLUMN type;

delete from product where productid = '444'

insert into pc(productid, brand)
values ('D', 'Steam')

insert into product_order(order_number, productid, quantity)
values ('4', 'A', 1)

insert into product(productid, price, description, product_name)
values ('D', 69.99, 'Great Game', 'God of War') 

insert into customer(customer_name, email, phone_number, address, customerid)
values ('Jake Luck', 'jackluck@abc.com', '1112223333', '60th ave n', 3)

insert into customer(customer_name, email, phone_number, address, customerid)
values ('Andrew McMonagle', 'amcmon@abc.com', '9998887777', '34th street N', 4)

insert into orders(order_number, order_status, quantity, shipping_address, order_date, customerid)
values(4, 'not delivered', 1, '19th street south', '2020-11-07', 4)

insert into orders(order_number, order_status, quantity, shipping_address, order_date, customerid)
values(3, 'in transit', 1, '12th ave north', '2018-04-08', 3)

insert into pc(productid, brand)
values ('C', 'Generic')

insert into Console(productid, console_platform)
values ('CORSAIR_HS', 'PS5 and XBOX')

--Read Operation--
--1--
SELECT p.productID, p.price, p.description, p.product_name, pc.brand
FROM product p 
INNER JOIN pc pc ON p.productID = pc.productID
WHERE p.price < 1000;


--2--
SELECT DISTINCT c.*
FROM customer c
JOIN orders o ON c.customerID = o.customerID
WHERE o.order_date >= '2020-01-01' AND o.order_date <= '2020-12-31';

--3--
SELECT p.product_name, p.price 
FROM product p
INNER JOIN pc c ON p.productID = c.productID
ORDER BY p.price DESC
LIMIT 1;


--Write Operation--
--1--
INSERT INTO product (productID, price, description, product_name)
VALUES ('RAZOR_HS', 200.00, 'High-quality gaming headset by Razor', 'Razor gaming headset');

--2--
UPDATE product
SET price = price * 1.1
WHERE product_name = 'MSI prebuilt gaming PC';

--3--
DELETE FROM orders
WHERE customerID = (SELECT customerID FROM customer WHERE customer_name = 'Jake Luck');

--c. c.	Search for a past order based off of product name and price
SELECT o.order_number, o.order_date, o.order_status, p.product_name, p.price, po.quantity
FROM orders o
JOIN product_order po ON o.order_number = po.order_number
JOIN product p ON po.productID = p.productID
WHERE p.product_name = 'PS5 Deluxe';

--Search for review based off of rating
SELECT rating, comment
FROM review
WHERE rating >= 85;