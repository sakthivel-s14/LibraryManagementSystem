📚 Library Management System (LMS) Overview: Library Management System is a simple Java web application developed using Servlets, JDBC, Oracle 11g XE, and Apache Tomcat. It performs basic CRUD operations (Add and View Books) using a layered architecture.

Technologies Used: Java Servlets JDBC Oracle 11g XE Apache Tomcat HTML

Project Structure: bean – Contains AuthorBean, BookBean dao – Contains AuthorDAO, BookDAO service – Business logic (Administrator) servlets – Request handling (MainServlet, ViewServlet) util – Database connection (DBUtil) webapp – HTML pages (AddBook, ViewBook, Menu, Failure, Invalid)

Features: ✔ Add Book ✔ View Book ✔ Author Validation ✔ Exception Handling ✔ MVC Architecture

How to Run: Create tables in Oracle 11g XE. Update database credentials in DBUtil.java. Deploy on Tomcat.
IMAGE:
<img width="959" height="509" alt="image" src="https://github.com/user-attachments/assets/78f97e43-7606-4fe4-b748-e22d740385f2" />
<img width="1919" height="1027" alt="image" src="https://github.com/user-attachments/assets/ea13f281-4514-440e-af9e-a31f24c99da2" />
<img width="1919" height="1021" alt="image" src="https://github.com/user-attachments/assets/28b1456a-e521-4a34-8017-2f78cac4f306" />
<img width="1919" height="1022" alt="image" src="https://github.com/user-attachments/assets/502bf027-247b-4bf1-a583-bf4019776d03" />


