USE testingsystem;

-- Question 1: Them it nhat 10 record vao moi table
SELECT * FROM Department;
INSERT INTO Department	(	DepartmentName	) 
VALUES			(	'Sale'			),
                        (	'Accountant'	),
			(	'Finance'		),
                        (	'Marketing'		),
                        (	'Operation'		),
                        (	'HR'			),
                        (	'Purchase'		),
			(	'Shareholder'	),
                        (	'Service'		),
                        (	'Delivery'		);


SELECT * FROM `position`;                        
INSERT INTO `position`	(	PositionName	)
VALUES			(	'Dev'			),
			(	'Test'			),
			(	'Scrum Master'	),
			(	'Test'			),
			(	'Dev'			),
			(	'Dev'			),
			(	'Scrum Master'	),
			(	'PM'			),
			(	'Dev'			),
			(	'Scrum Master'	);
                        

SELECT * FROM `account`;                        
INSERT INTO `account`	(Email				,Username	,FullName				,DepartmentID	,PositionID	)
VALUES			('hieuu99@gmail.com','Hieungx'	,'Nguyen Trung Hieu'	,		1		,	1		),
			('hung95@gmail.com'	,'Hung95'	,'Nguyen Quoc Hung'		,		2		,	2		),
			('huyen97@gmail.com','HuyenAnh'	,'Tran Thanh Huyen'		,		3		,	3		),
			('Namm@gmail.com'	,'NamANh'	,'Le Thanh Nam'			,		4		,	4		),
			('Minhh@gmail.com'	,'Minh'		,'Le Quang Minh'		,		5		,	5		),
			('tuan@gmail.com'	,'Tuan'		,'Le Minh Tuan'			,		6		,	6		),
			('longg@gmail.com'	,'Long95'	,'Le Thanh Long'		,		7		,	7		),
			('phuong@gmail.com'	,'phuong'	,'Tran Phuong Phuong'	,		8		,	8		),
			('phanh@gmail.com'	,'PAchua'	,'Ha Phuong Anh'		,		9		,	9		),
			('ann95@gmail.com'	,'Manh An'	,'Dinh Manh An'			,		10		,	10		);

SELECT * FROM `group`;
INSERT INTO `group`		(GroupName	,CreatorID	)
VALUES				('group 1'	,	1		),
				('group 2'	,	2		),
				('group 3'	,	3		),
				('group 4'	,	4		),
				('group 5'	,	5		),
				('group 6'	,	6		),
				('group 7'	,	7		),
				('group 8'	,	8		),
				('group 9'	,	9		),
				('group 10'	,	10		);
                        
SELECT * FROM groupaccount;
INSERT INTO groupaccount	(AccountID	)
VALUES				(	1		),
				(	2		),
				(	3		),
				(	4		),
				(	5		),
				(	6		),
				(	7		),
				(	8		),
				(	9		),
				(	10		);

SELECT * FROM TypeQuestion;
INSERT INTO TypeQuestion(TypeName			)
VALUES			('Multiple-Choice'	),
			('Essay'			),
			('Essay'			),
			('Multiple-Choice'	),
			('Essay'			),
			('Multiple-Choice'	),
			('Multiple-Choice'	),
			('Essay'			),
			('Multiple-Choice'	),
			('Essay'			);

SELECT * FROM CategoryQuestion;
INSERT INTO CategoryQuestion	(CategoryName		)
VALUES				('Java'			),
				('.NET'			),
				('SQL'			),
				('Postman'		),
				('Ruby'			),
				('.NET'			),
				('.NET'			),
				('Java'			),
				('SQL'			),
				('Postman'		);
                            
SELECT * FROM Question;
INSERT INTO Question			(Content	,CategoryID	,TypeID	,CreatorID	)
VALUES					('câu hỏi 1',1			,1		,1			),
					('cnt2'		,2			,2		,2			),
					('cnt3'		,3			,3		,3			),
					('cnt4'		,4			,4		,4			),
					('cnt5'		,5			,5		,5			),
					('câu hỏi 6'	,6			,6		,6			),
					('cnt7'		,7			,7		,7			),
					('cnt8'		,8			,8		,8			),
					('cnt9'		,9			,9		,9			),
					('cnt10'	,10			,10		,10			);
                    
SELECT * FROM Answer;
INSERT INTO Answer	(Content	,QuestionID		,IsCorrect		)
VALUES			('cnt1'		,1			,0			),
			('cnt2'		,2			,1			),
			('cnt3'		,3			,0			),
			('cnt4'		,4			,0			),
			('cnt5'		,5			,1			),
			('cnt6'		,6			,0			),
			('cnt7'		,7			,0			),
			('cnt8'		,8			,1			),
			('cnt9'		,9			,1			),
			('cnt10'	,10			,0			);
                    
SELECT * FROM Exam;
INSERT INTO Exam	(Code	,Title	,CategoryID		,CreatorID		,Duration		)
VALUES			('a1'	,'thi1'	,1			,1			,60			),
			('a2'	,'thi2'	,2			,2			,45			),
			('a3'	,'thi3'	,3			,3			,120			),
			('a4'	,'thi4'	,4			,4			,60			),
			('a5'	,'thi5'	,5			,5			,120			),
			('a6'	,'thi6'	,6			,6			,90			),
			('a7'	,'thi7'	,7			,7			,45			),
			('a8'	,'thi8'	,8			,8			,15			),
			('a9'	,'thi9'	,9			,9			,15			),
			('a10'	,'thi10',10			,10			,60			);

SELECT * FROM ExamQUestion;
INSERT INTO ExamQUestion(ExamID		,QuestionID		)
VALUES			(	1	,		1	),
			(	2	,		2	),
			(	3	,		3	),
			(	4	,		4	),
			(	5	,		5	),
			(	6	,		6	),
			(	7	,		7	),
			(	8	,		8	),
			(	9	,		9	),
			(	10	,		10	);
                        
-- Question 2 : Lay ra tat ca cac phong ban
SELECT * FROM Department;

-- Question 3 : Lay ra ID phong ban SALE
SELECT DepartmentID FROM Department
WHERE DepartmentName = 'Sale';

-- Question 4 : Lay ra thong tin acc co full name dai nhat roi sap xep giam dan
SELECT * FROM `Account`
WHERE LENGTH(FullName)=(SELECT MAX(LENGTH(FullName)) FROM Account)
ORDER BY FullName DESC;

-- Question 5 : Lay ra thong tin acc co full name dai nhat va thuoc phong ban co ID = 3
SELECT * FROM `account`
WHERE DepartmentID =3 AND LENGTH(FullName)=(SELECT MAX(LENGTH(FullName)) FROM Account WHERE DepartmentID =3);

-- Question 6 : Lay ra ten GR da tham gia trc ngay 20/12/2019
SELECT GroupName FROM `Group`
WHERE CreateDate < '2019-12-20';

-- Question 7 : Lay ra cac IDquestion co >= 4 cau tra loi
-- Em chua hieu cau hoi

-- Question 8 : lay ra ca ma de thi co thoi gian thi > 60 va tao trc ngay 20/12/2019
SELECT ExamID FROM exam
Where Duration > 60 AND CreateDate < '2021-12-20';

-- Question 9 : lay ra 5 Group dc tao gan day nhat
SELECT * FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5 ;

-- Question 10 : Dem so nhan vien thuoc Dept co ID = 2
SELECT * FROM account;
SELECT COUNT(AccountID) FROM `account`
GROUP BY DepartmentID
HAVING DepartmentID =2; 

-- Question 11 :Lay ra nhan vien co ten bat dau bang chu D va ket thuc bang chu o;
INSERT INTO `account`	(Email				,Username	,FullName				,DepartmentID	,PositionID	)
VALUES					('ngo@gmail.com','Ngo Dinh'		,'Dinh Tien Ngo'		,		1		,	9		);

SELECT * FROM `account`
WHERE FullName LIKE 'D%o';

-- Question 12 : xoa tat ca cac exam dc tao trc ngay 20/12/2019
DELETE FROM exam
WHERE CreateDate = '2019/12/20';

-- Question 13 : Xoa tat ca cac Question co noi Dung bat dau bang cau hoi
SELECT * FROM Question;

DELETE FROM Question
WHERE Content LIKE 'câu%' ;

-- Question 14 : update thong tin cua account id = 5 
UPDATE `account`
SET Email = 'loc.nguyenba@vti.com.vn', FullName = 'Nguyen Ba Loc'
WHERE AccountID = 5;
SELECT * FROM `account`;

-- Question 15 : ID = 5 -> 4
UPDATE `account`
SET AccountID = 4
WHERE AccountID = 5;
