# Online_Gaming_Store
CSCI 366 Database Systems: Final Project: Online Store
CSCI 366 final project

Implement an application with database involved. The application:
1.	Work with Postgresql database server.
2.	Provide a way to “communicate” with end users
a.	Graphic user interface 
b.	Console 
3.	Display meaningful information from database upon user requests 
4.	Update (insert/update/delete) data in database upon user requests
See RUBRIC below for more detailed requirement

Database: Postgresql database server 
Language: Java or C# 
Data model size: at least 4 entities with one-to-many and many-to-many 
Team size: 2 – 3 members per team

* Do not reuse the project you did in other classes. 
* You need to write program to connect to the database server, include SQL statements in program to retrieve and update data. Do not relies on existing frameworks to generate SQL statements. 

What to submit in the final package:
1.	Team members (2 -3 per team)
2.	Report on how the work been distributed among team members
3.	Project requirement doc
a.	Topic (domain) 
b.	List functionalities will be implemented in the project (use bullet items, not paragraph)
4.	ERD for data modeling
5.	Script (.sql file) for creating tables, views, functions, index and inserting initial records 
Views, functions, index are optional
6.	Class design (list classes and methods in each classes) 
7.	Source code (in zip)

RUBRIC
1.	Database design (20)
a.	3NF
b.	Data consistency
c.	No unnecessary tables
2.	Relations (10)
a.	Has one to many relationship
b.	Has many to many relationship
3.	5 tables (5)
4.	Read operation (20)
a.	Read operation with conditions (example: list all employee for a certain department)
b.	Read from multiple tables (example: list employee and the project he/she is working on)
c.	List some data summary information (example: show the most expensive project)
5.	Write operation   (15)
a.	Insert  (example: add a new project and assignment employees to work on it)
b.	update  (example: increase the estimate cost for a project)
c.	delete  (example: cancel the project, and remove the employee assignment)
6.	Function well  (10)
7.	Parameterized sql (secure way to write sql statement) (10)
8.	Class design (10)


Sample ideas (you can use the sample ideas or customize the sample ideas, but you need to finalize the requirement and fill in more details)

Online store:
1.	Track items in inventory
a.	Name, description, category, quantity, current unit price, availability, provider name, provider contact number, provider address  … 
b.	Can filter the list base on certain criteria (provide items provided by a certain provider
c.	Can list the items in a certain category
d.	Can add new items
e.	Can update the information of an item
f.	Can change provider of an item
g.	Can mark an item as not available
2.	Track price change
a.	For which item, original price, reason for changes, when the change happened 
3.	Track customer info
a.	Customer name, contact phone, delivery address
4.	Track customer order
a.	Who ordered what, when the order is placed
b.	List all orders for a single customer
c.	List the most popular item been sold 
d.	Show the most expensive item in store.

