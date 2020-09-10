-- CREATE DATABASE
CREATE DATABASE manageStudents;
USE manageStudents;

-- CREATE TABLE
DROP TABLE Student;
CREATE TABLE Student(
	RN 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 	VARCHAR(50) 	NOT NULL,
    Age 	INT 			NOT NULL,
    Gender	VARCHAR(50) 	NOT NULL
);

DROP TABLE `Subject`;
CREATE TABLE `Subject`(
	sID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    sName 	VARCHAR(50) NOT NULL
);

DROP TABLE StudentSubject;
CREATE TABLE `StudentSubject`(
	RN 		TINYINT UNSIGNED ,
	sID 	TINYINT UNSIGNED ,
    Mark	INT 		NOT NULL,
    `Date`	DATE		NOT NULL,
	FOREIGN KEY(RN) 	REFERENCES student(RN)		ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(sID) 	REFERENCES `subject`(sID)	ON DELETE CASCADE ON UPDATE CASCADE
);

-- Phần A
-- INSERT DATA VALUES
TRUNCATE TABLE Student;
SELECT * FROM Student;

INSERT INTO Student	(`Name`					,Age	,Gender		)
VALUES				('Nguyen Trung Hieu'	,17		,'Male'		),
					('Nguyen Thanh Nam'		,18		,'Male'		),
                    ('Le My Linh'			,19		,'Female'	);

SELECT * FROM `Subject`;
TRUNCATE TABLE `Subject`;
INSERT INTO `Subject`	(sName		)
VALUES					('Math'		),
						('History'	),
						('Biology'	);
                        
SELECT * FROM StudentSubject;

INSERT INTO StudentSubject	()
VALUES						(1,1,9,'2018-09-20'),
							(2,3,9,'2019-08-21'),
                            (3,3,8,'2020-07-15');

-- Phần B
TRUNCATE TABLE StudentSubject;

-- Lấy ra môn học không có điểm nào
SELECT S.* FROM StudentSubject SS
RIGHT JOIN `subject` S ON SS.sID = S.sID
WHERE Mark IS NULL;

-- Lấy ra môn học có ít nhất 2 điểm
SELECT S.* FROM StudentSubject SS
RIGHT JOIN `subject` S ON SS.sID = S.sID
GROUP BY SS.sID
HAVING COUNT(SS.Mark) >=2 ;

-- Phần C
-- Tạo VIEW chứa các thông tin
CREATE VIEW show_all AS
SELECT S.RN,Su.sID,S.`Name`,S.age,s.gender,Su.sName,ss.mark,ss.`Date` FROM StudentSubject SS
RIGHT JOIN student S ON SS.RN = S.RN
RIGHT JOIN `Subject` Su ON SS.sID = Su.sID;

SELECT * FROM show_all;

-- Phần D
-- Tạo trigger Sửa subject thì update StudentSubject
SELECT * FROM `subject`;
SELECT * FROM `StudentSubject`;

DROP TRIGGER CasUpdate;

TRUNCATE TABLE `Subject`;
TRUNCATE TABLE StudentSubject;

-- Câu lệnh tạo trigger
DELIMITER $$
CREATE TRIGGER CasUpdate
AFTER UPDATE ON `subject`
FOR EACH ROW 
BEGIN
	UPDATE StudentSubject SS
    SET SS.sID = NEW.sID
    WHERE SS.sID = OLD.sID;
END $$
DELIMITER ;

UPDATE `subject`
SET sID = 4
WHERE sID = 3;

-- Xóa 1 student các dữ liệu của table SS cũng sẽ bị xóa

SELECT * FROM student;
SELECT * FROM StudentSubject;

-- Câu lệnh tạo trigger
DELIMITER $$
CREATE TRIGGER casDel
AFTER DELETE ON `Student`
FOR EACH ROW 
BEGIN
	DELETE FROM StudentSubject SS
    WHERE SS.RN = OLD.RN;
END $$
DELIMITER ;

DELETE FROM Student
WHERE RN = 1;

-- Phần E
SELECT * FROM Student;
SELECT * FROM StudentSubject;



DELIMITER $$
CREATE PROCEDURE exam(IN IN_Name VARCHAR(50))
BEGIN
	IF IN_Name = '*'
    THEN
		DELETE FROM StudentSubject;
	ELSE 
        DELETE FROM StudentSubject SS
        WHERE 	SS.RN = (	SELECT RN FROM Student
							WHERE `Name` = IN_name)
				AND SS.Mark < IN_mark;
	END IF;
END $$
DELIMITER ;

CALL exam('Nguyen Trung Hieu',10);

SELECT * FROM studentSubject;
SELECT * FROM Student;
