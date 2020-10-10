DROP DATABASE IF EXISTS qlyuser;
CREATE DATABASE qlyuser;
USE qlyuser;

CREATE TABLE IF NOT EXISTS `employee` (
	id INT AUTO_INCREMENT,
    fullname VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
	projectId INT NOT NULL,
    projectSkill VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `project` (
	id INT auto_increment,
    teamSize INT NOT NULL,
    idManager INT NOT NULL,
    idEmployee INT NOT NULL,
    PRIMARY KEY (id)
);

select * from employee;
INSERT INTO employee (fullname,email,pass,projectId,projectSkill)
VALUES ('Hoang Van Truong','truong97@vti.com.vn','Truong123',2,'test');

select * from manager;
INSERT INTO manager (fullname,email,pass,expInYear)
VALUES ('Ha Thuy Duong','Duong 94@vti.com.vn','Duong123',4);

select * from project;
INSERT INTO project (id,teamSize,idManager,idEmployee)
VALUES (1,2,1,1);
INSERT INTO project (id,teamSize,idManager,idEmployee)
VALUES (2,2,2,2);

select * from `employee` where email = 'hieuu99@vti.com.vn' and pass = 'Hieu123';

