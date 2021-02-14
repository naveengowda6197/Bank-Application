# Bank-Application
A bank application is developed using spring mvc And Hibernate. Here Admin can create and edit bank accounts for users.As bank account data should not be deleted at any time I have not provided delete autherization for admin.

admin can login using Username: admin@gmail.com and password : admin

After you create some accounts using admin login and Use created credential for login.

STEPS:
1)Please import this project as maven project
2)setup database using details of java class Application.java and change table name in Application.java according to your database name. 
3)Build and run the project on server.http://localhost:8080/SpringMVCHibernateCRUD/

You can use this Sql create statement for createing database

CREATE TABLE `emp_tbl` (
  `ac_no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `balance` int DEFAULT NULL,
  PRIMARY KEY (`ac_no`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
