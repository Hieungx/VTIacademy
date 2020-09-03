USE testingsystem;

SELECT * FROM account;
SELECT * FROM department;
-- QUESTION 1 : Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
-- lấy ra Id phòng ban sale
SELECT DepartmentID FROM Department
WHERE DepartmentName = 'Sale';

CREATE VIEW accountOfSale
AS
SELECT * FROM `account`
WHERE DepartmentID IN (	SELECT DepartmentID FROM Department
						WHERE DepartmentName = 'Sale');
                        
-- QUESTION 2 : tạo view có chứa thông tin account tham gia vào nhiều group nhất
-- Đoạn lệnh tìm ra số phòng ban mà accout tham gia nhiều gr nhất tham gia
CREATE VIEW Inf_Account_Join_MaxGR
AS
SELECT A.*, G.QuantityGR FROM `account` A
JOIN	(	SELECT AccountID , COUNT(accountID) QuantityGR FROM groupaccount 
			GROUP BY accountID ) G
ON A.accountID = G.accountID
WHERE G.QuantityGR = (	SELECT MAX(A.QuantityGR) 
						FROM (	SELECT AccountID , COUNT(accountID) QuantityGR 
								FROM groupaccount 
								GROUP BY accountID) A 
								);
                                
-- QUESTION 3 : Tạo view có chứa câu hỏi có những content quá dài (Content > 300 từ) và xóa nó đi
CREATE VIEW BigConten
AS
SELECT QuestionID
FROM Question
WHERE QuestionID IN	(
						SELECT QuestionID FROM question
						WHERE LENGTH(content) >= 18
						GROUP BY questionID	);

DELETE FROM Question
WHERE QuestionID IN (SELECT * FROM Bigconten);

-- QUESTION 4 : Tạo danh sách các phòng ban có chưa nhiều nhân viên nhất
CREATE VIEW phong_ban_n_nvien
AS
SELECT De.DepartmentID,De.DepartmentName,A.`Count` FROM Department De
JOIN (	SELECT DepartmentID,COUNT(DepartmentID) `count` FROM account
		GROUP BY DepartmentID) A ON De.DepartmentID = A.departmentID
WHERE count IN (	SELECT MAX(A.`count`)
					FROM (	SELECT *,COUNT(DepartmentID) `count` FROM account
							GROUP BY DepartmentID) A);
                            
-- QUESTION 5 : Tạo view có tất cả các câu hỏi do User họ "Nguyễn" tạo
SELECT * FROM question;
SELECT * FROM `Account`;

CREATE VIEW Question_OF_Nguyen
AS
SELECT Q.QuestionID,Q.Content FROM `account` A
JOIN question Q ON A.accountID = Q.creatorID
WHERE FullName LIKE'Nguyen%'; 