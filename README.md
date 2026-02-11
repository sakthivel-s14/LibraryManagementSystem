📚 Library Management System (LMS) Overview: Library Management System is a simple Java web application developed using Servlets, JDBC, Oracle 11g XE, and Apache Tomcat. It performs basic CRUD operations (Add and View Books) using a layered architecture.

Technologies Used: Java Servlets JDBC Oracle 11g XE Apache Tomcat HTML

Project Structure: bean – Contains AuthorBean, BookBean dao – Contains AuthorDAO, BookDAO service – Business logic (Administrator) servlets – Request handling (MainServlet, ViewServlet) util – Database connection (DBUtil) webapp – HTML pages (AddBook, ViewBook, Menu, Failure, Invalid)

Features: ✔ Add Book ✔ View Book ✔ Author Validation ✔ Exception Handling ✔ MVC Architecture

How to Run: Create tables in Oracle 11g XE. Update database credentials in DBUtil.java. Deploy on Tomcat.
