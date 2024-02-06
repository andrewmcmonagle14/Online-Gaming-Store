-- Database: postgres

-- DROP DATABASE IF EXISTS postgres;

CREATE DATABASE CSCI 366 Final Project
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE postgres
    IS 'default administrative connection database';
	
CREATE TABLE customer(
customerID int primary key,
customer_name varchar(50) not null,
email varchar(100) not null,
phone_number char(10) not null,
address varchar(100) not null,
city varchar(50) not null,
state varchar(50) not null,
zip_code varchar(10) not null
);

CREATE TABLE product(
productID varchar(10) primary key,
price decimal(7,2) not null,
description varchar(200),
product_name varchar(50) not null
); 

CREATE TABLE console(
productID varchar(10) primary key,
console_platform varchar(20) not null,
foreign key (productID) references product(productID)
);

CREATE TABLE pc(
productID varchar(10) primary key,
brand varchar(20) not null,
foreign key (productID) references product(productID)
);

CREATE TABLE orders(
order_number int primary key,
order_status varchar(30),
quantity int not null,
order_date Date not null,
customerID int,
foreign key (customerID) references customer(customerID)
);

CREATE TABLE product_order(
productID varchar(10),
order_number int,
quantity int not null,
primary key (productID, order_number),
foreign key (productID) references product(productID),
foreign key (order_number) references orders(order_number)
);

CREATE TABLE review(
reviewID varchar(10) primary key,
rating int not null,
comment varchar(50),
productID varchar(10),
foreign key (productID) references product(productID)
);

Insert into customer(customerID, customer_name, email, phone_number, address, city, state, zip_code)
values(1, 'Bryan Gallager', 'brygall@abc.com', '1234567890', '4th street north', 'Plymouth', 'MN', '55346'),
		(2, 'Jarred Frank', 'jarrfrank@abc.com', '3245679087', '15th ave west', 'St. Paul', 'MN', '55656'),
		(3, 'Jake Luck', 'jackluck@abc.com', '1112223333', '20th ave west', 'Fargo', 'ND', '58102'),
		('4', 'Andrew McMonagle', 'amcmon@abc.com', '9998887777', '44th street N', 'Fargo', 'ND', '58102');


		
Insert into product(productID, price, description, product_name)
values('A', 499.99, 'Great gaming console', 'PS5 Deluxe'),
		('B', 999.99, 'Outstanding gaming PC', 'MSI prebuilt gaming PC'),
		('C', 109.99, 'Product C description', 'C Name'),
		('D', 72.00, 'Great Game', 'God Of War'),
		('CORSAIR_HS', 100.00, 'Great headset', 'Corsair Gaming Headset');




Insert into console(productID, console_platform)
values('A', 'PS5'),
		('CORSAIR_HS', 'PS5 and XBOX');

Insert into pc(productID, brand)
values('B', 'MSI'),
		('C', 'Generic'),
        ('D', 'Steam');

Insert into orders(order_number, order_status, quantity, customerID)
values(1, 'in transit', 2, '2019-05-07', 1),
		(2, 'delivered', 1, '2020-08-20', 2),
		(3, 'in transit', 1, '2018-04-08', 3),
		(4, 'delivered', 1, '2020-11-07', 4);


        
Insert into product_order(order_number, productID, quantity)
values(1, 'A', 1),
		(1, 'B', 1),
        (2, 'B', 1),
		(3, 'CORSAIR_HS', 2),
		(4, 'A', 1);



Insert into review(reviewID, rating, comment, productID)
values('1', 95, 'Great product!', 'A'),
		('2', 80, 'Pretty good product!', 'B');
		
		

	