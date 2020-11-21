-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY,
	TotalMember				TINYINT
);
INSERT INTO Department(DepartmentName,TotalMember) 
VALUES
						(N'Marketing'	,1),
						(N'Sale'		,2),
						(N'Bảo vệ'		,3),
						(N'Nhân sự'		,4),
						(N'Kỹ thuật'	,5),
						(N'Tài chính'	,6),
						(N'Phó giám đốc',7),
						(N'Giám đốc'	,8),
						(N'Thư kí'		,9),
						(N'Bán hàng'	,10);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    Member					TINYINT NOT NULL,
    Creator					NVARCHAR(50) NOT NULL,
    CreateDate				DATETIME DEFAULT NOW() -- Cannot update this field
);

INSERT INTO `Group`	(  GroupName			, Member , Creator , CreateDate)
VALUES 				(N'Testing System'		,1,'NAT','2019-03-05'),
					(N'Developement'		,2,'NAT','2020-03-07'),
                    (N'VTI Sale 01'			,3,'NAT','2020-03-09'),
                    (N'VTI Sale 02'			,4,'NAT','2020-03-10'),
                    (N'VTI Sale 03'			,5,'NAT','2020-03-28'),
                    (N'VTI Creator'			,6,'NAT','2020-04-06'),
                    (N'VTI Marketing 01'	,7,'NAT','2020-04-07'),
                    (N'Management'			,8,'NAT','2020-04-08'),
                    (N'Chat with love'		,9,'NAT','2020-04-09'),
                    (N'Vi Ti Ai'			,10,'NAT','2020-04-10');