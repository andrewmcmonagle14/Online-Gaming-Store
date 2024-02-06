Online_Gaming_Store
CSCI 366 Database Systems: Final Project: Online Store CSCI 366 final project

Implement an application with database involved. The application:

Work with Postgresql database server.
Provide a way to “communicate” with end users a. Graphic user interface b. Console
Display meaningful information from database upon user requests
Update (insert/update/delete) data in database upon user requests See RUBRIC below for more detailed requirement
Database: Postgresql database server Language: Java or C# Data model size: at least 4 entities with one-to-many and many-to-many Team size: 2 – 3 members per team

Do not reuse the project you did in other classes.
You need to write program to connect to the database server, include SQL statements in program to retrieve and update data. Do not relies on existing frameworks to generate SQL statements.
What to submit in the final package:

Team members (2 -3 per team)
Report on how the work been distributed among team members
Project requirement doc a. Topic (domain) b. List functionalities will be implemented in the project (use bullet items, not paragraph)
ERD for data modeling
Script (.sql file) for creating tables, views, functions, index and inserting initial records Views, functions, index are optional
Class design (list classes and methods in each classes)
Source code (in zip)
RUBRIC

Database design (20) a. 3NF b. Data consistency c. No unnecessary tables
Relations (10) a. Has one to many relationship b. Has many to many relationship
5 tables (5)
Read operation (20) a. Read operation with conditions (example: list all employee for a certain department) b. Read from multiple tables (example: list employee and the project he/she is working on) c. List some data summary information (example: show the most expensive project)
Write operation (15) a. Insert (example: add a new project and assignment employees to work on it) b. update (example: increase the estimate cost for a project) c. delete (example: cancel the project, and remove the employee assignment)
Function well (10)
Parameterized sql (secure way to write sql statement) (10)
Class design (10)
Sample ideas (you can use the sample ideas or customize the sample ideas, but you need to finalize the requirement and fill in more details)

Online store:

Track items in inventory a. Name, description, category, quantity, current unit price, availability, provider name, provider contact number, provider address … b. Can filter the list base on certain criteria (provide items provided by a certain provider c. Can list the items in a certain category d. Can add new items e. Can update the information of an item f. Can change provider of an item g. Can mark an item as not available
Track price change a. For which item, original price, reason for changes, when the change happened
Track customer info a. Customer name, contact phone, delivery address
Track customer order a. Who ordered what, when the order is placed b. List all orders for a single customer c. List the most popular item been sold d. Show the most expensive item in store.
