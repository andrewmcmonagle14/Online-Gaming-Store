
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
