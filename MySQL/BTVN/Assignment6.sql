
-- QUESTION 1 : Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả account thuộc phòng ban đó
SELECT * FROM department;
SELECT * FROM `account`;

-- Khối lệnh dự kiến bên trong store
SELECT * FROM account A
JOIN department D ON A.departmentID = D.departmentID
WHERE D.DepartmentName LIKE 'Bán Hàng';

DELIMITER $$
CREATE PROCEDURE Show_acc(IN IN_departmentName VARCHAR(30),OUT OUT_accountID VARCHAR(50))
BEGIN
	SELECT accountID INTO OUT_accountID
    FROM `account` A
	JOIN department D ON A.departmentID = D.departmentID
	WHERE D.DepartmentName = IN_departmentName;
END $$
DELIMITER ;

CALL show_acc('SALE',@accountID);

SET @accountID = '';

SELECT @accountID;

-- QUESTION 2 : Tạo ra store để in ra số lượng account trong mỗi gr
USE testingsystem;
SELECT * FROM `group`;
SELECT * FROM `groupaccount`;

SELECT GroupID,COUNT(accountID) FROM groupaccount
GROUP BY groupID;

DROP PROCEDURE quantity_acc;

DELIMITER $$
CREATE PROCEDURE Quantity_acc(IN IN_groupID TINYINT,OUT OUT_Quantity_acc INT)
BEGIN
	SELECT COUNT(accountID) `Quantity` INTO OUT_quantity_acc
    FROM groupaccount
    WHERE groupID = IN_groupID
    GROUP BY groupID;
END $$
DELIMITER ;

SET @Quantity = '';

CALL Quantity_acc(1,@Quantity);

SELECT @quantity;

-- QUESTION 3 : Tạo store  để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
SELECT * FROM typeQuestion;
SELECT * FROM question;

DELIMITER $$
CREATE PROCEDURE check_Quantity_follow_month(IN IN_month INT)
BEGIN
	SELECT COUNT(QuestionID)
	FROM question
	WHERE MONTH(CreateDate) = IN_month
	GROUP BY TypeID;
END $$
DELIMITER ;

-- DEMO khối lệnh bên trong
SELECT COUNT(QuestionID)
FROM question
WHERE MONTH(CreateDate) = MONTH(NOW())
GROUP BY TypeID;

CALL check_Quantity_follow_month();

-- QUESTION 4 : tạo ra store để trả ra ID của typeQuestion có nhiều câu hỏi nhất
-- KhỐi lệnh demo
SELECT TypeID,COUNT(QuestionID) quantity 
FROM question
GROUP BY TypeID
HAVING Quantity = (
	SELECT COUNT(QUESTIONID) quantity_Question
	FROM question
	GROUP BY TypeID
	ORDER BY quantity_question DESC
	LIMIT 1) ;
    
DELIMITER $$
CREATE PROCEDURE show_TypeID_have_max_question()
BEGIN
	SELECT TypeID,COUNT(QuestionID) quantity 
	FROM question
	GROUP BY TypeID
	HAVING Quantity = (
			SELECT COUNT(QUESTIONID) quantity_Question
			FROM question
			GROUP BY TypeID
			ORDER BY quantity_question DESC
			LIMIT 1) ;
END $$
DELIMITER ;

CALL show_TypeID_have_max_question;

-- QUESTION 5 : Sử dụng store question 4 để tìm ra tên của type question
USE testingsystem;
SELECT * FROM typequestion;

-- Khối lệnh demo
SELECT Q.TypeID,T.TypeName,COUNT(Q.QuestionID) quantity 
FROM question Q
JOIN typequestion T ON Q.TypeID = T.typeID
GROUP BY Q.TypeID
HAVING Quantity = (
	SELECT COUNT(QUESTIONID) quantity_Question
	FROM question
	GROUP BY TypeID
	ORDER BY quantity_question DESC
	LIMIT 1) ;
    
DELIMITER $$
CREATE PROCEDURE show_TypeID_have_max_question_Update()
BEGIN
		SELECT Q.TypeID,T.TypeName,COUNT(Q.QuestionID) quantity 
		FROM question Q
		JOIN typequestion T ON Q.TypeID = T.typeID
		GROUP BY Q.TypeID
		HAVING Quantity = (
			SELECT COUNT(QUESTIONID) quantity_Question
			FROM question
			GROUP BY TypeID
			ORDER BY quantity_question DESC
			LIMIT 1) ;
END $$
DELIMITER ;

CALL show_TypeID_have_max_question_Update;

-- QUESTION 6 : Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user
-- 				có chứa chuỗi của người dùng nhập vào

SELECT * FROM `group`;
SELECT * FROM `account`;

SELECT groupName FROM `Group`
WHERE GroupName LIKE 'Testing%';

DELIMITER $$
CREATE PROCEDURE find_group_or_user(IN IN_input VARCHAR(50),IN IN_Choice INT)
BEGIN
	IF IN_choice = 1 THEN
		SELECT groupName FROM `Group`
		WHERE GroupName LIKE IN_input;
	ELSE
		SELECT Username FROM `account`
		WHERE Username LIKE IN_input;
    END IF
		;
END $$
DELIMITER ;

CALL find_group_or_user('d%',2);

-- QUESTION 7 :
SELECT * FROM `account`;
SELECT * FROM department;
SELECT * FROM `position`;

DELIMITER $$
CREATE PROCEDURE Insert_account (IN IN_email VARCHAR(50),IN IN_FullName VARCHAR(50))
BEGIN
	DECLARE UserName VARCHAR(50) DEFAULT SUBSTRING_INDEX(IN_email,'@',1);
    DECLARE DepartmentID TINYINT DEFAULT 5;
    DECLARE PositionID TINYINT DEFAULT 1;
    DECLARE CreateDate DATETIME DEFAULT NOW();
    
    INSERT INTO `Account`	(email		,UserName	,FullName	,DepartmentID,PositionID,CreateDate)
    VALUES					(IN_email	,UserName	,IN_FullName,DepartmentID,PositionID,CreateDate);
    
    SELECT * FROM `account`
    WHERE email = IN_email;
END $$
DELIMITER ;

DROP PROCEDURE Insert_account;

SELECT * FROM `account`;
CALL Insert_account('Thaotrinh@gmail.com','Le Thao Trinh');

-- QUESTION 8 :
SELECT * FROM typequestion;

SELECT MAX(LENGTH(Q.content)) `length` ,T.typename, Q.TypeID FROM question Q
JOIN typequestion T ON Q.typeID = T.TypeID
WHERE TypeName = 'essay';

DELIMITER $$
CREATE PROCEDURE Find_max_content(IN IN_typeName VARCHAR(50))
BEGIN
	SELECT MAX(LENGTH(Q.content)) `length` ,T.typename, Q.TypeID FROM question Q
	JOIN typequestion T ON Q.typeID = T.TypeID
	WHERE TypeName = IN_typeName;
END $$
DELIMITER ;

CALL find_max_content('essay');
CALL find_max_content('multiple-Choice');

-- QUESTION 9 : Xóa exam dựa vào ID
INSERT INTO exam(Code,Title,CategoryID,Duration,CreatorID)
VALUES('VTIQ011','Đề thi Python',1,60,1);

SELECT * FROM exam;

DELIMITER $$
CREATE PROCEDURE delete_exam(IN IN_examID TINYINT)
BEGIN
		DELETE FROM exam
		WHERE ExamID = IN_examID;
END $$
DELIMITER ;

CALL delete_exam(11);

-- QUESTION 10 :
SELECT * FROM exam;

DELETE FROM exam
WHERE examID = (SELECT A.examID FROM(SELECT examID FROM exam
					WHERE YEAR(CreateDate) = Year(Now())-3	
                    LIMIT 1
                    ) A);
DELIMITER $$
CREATE PROCEDURE Delete_exam_3yago()
BEGIN
	WITH Find_exam_3Yago AS(SELECT examID FROM exam
							WHERE YEAR(CreateDate) = Year(Now())-3	
								)	
	DELETE FROM exam
	WHERE examID = (SELECT * FROM Find_exam_3Yago);
END $$
DELIMITER ;

-- QUESTION 11 :
SELECT * FROM department;
SELECT * FROM `account`;

DELIMITER $$
CREATE PROCEDURE del_dept(IN IN_deptName VARCHAR(30))
BEGIN
		UPDATE `account`
        SET DepartmentID = 11
        WHERE DepartmentID = (	SELECT DepartmentID FROM department
								WHERE DepartmentName = IN_deptName
								);
		DELETE FROM Department
        WHERE DepartmentName = IndeptName;
END $$
DELIMITER ;

-- QUESTION 12 :
SELECT * FROM question;
USE testingsystem;

SELECT * FROM Question;

SELECT EachMonth.`Month`,COUNT(QuestionID)
FROM(	SELECT 1 `Month`
		UNION SELECT 2
        UNION SELECT 3
        UNION SELECT 4
        UNION SELECT 5
        UNION SELECT 6
        UNION SELECT 7
        UNION SELECT 8
        UNION SELECT 9
        UNION SELECT 10
        UNION SELECT 11
        UNION SELECT 12
        ) EachMonth
LEFT JOIN Question ON EachMonth.Month = Month(CreateDate)
GROUP BY EachMonth.`Month`
ORDER BY EachMonth.`Month` ASC;

DELIMITER $$
CREATE PROCEDURE Each_month_question()
BEGIN
	SELECT EachMonth.`Month`,COUNT(QuestionID)
	FROM(	SELECT 1 `Month`
			UNION SELECT 2
			UNION SELECT 3
			UNION SELECT 4
			UNION SELECT 5
			UNION SELECT 6
			UNION SELECT 7
			UNION SELECT 8
			UNION SELECT 9
			UNION SELECT 10
			UNION SELECT 11
			UNION SELECT 12
			) EachMonth
	LEFT JOIN Question ON EachMonth.Month = Month(CreateDate)
	GROUP BY EachMonth.`Month`
	ORDER BY EachMonth.`Month` ASC;
END $$
DELIMITER ;

CALL each_month_question();