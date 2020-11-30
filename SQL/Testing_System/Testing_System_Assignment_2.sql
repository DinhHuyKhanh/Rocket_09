USE testing_system_1;

# Question 1:lấy ra tất cả các phòng ban ;
SELECT *
FROM department;

# Question 2: ấy ra id của phòng ban có tên là "Sale"
SELECT * 
FROM department
WHERE DepartmentName = 'Sale';
# Question 3: lấy ra thông tin account có full name dài nhất

SELECT *,char_length(FullName) as length_full_name
FROM `account`
ORDER BY length_full_name DESC
LIMIT 1;

# Question 4: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT *
 FROM  `group`
WHERE CreateDate > 2019-12-20;
# Question 5: Lấy ra ID của question có >= 4 câu trả lời

SELECT QuestionID , COUNT(QuestionID) as count_content
FROM 
answer
GROUP BY QuestionID
HAVING count_content >=4 ;

# Question 6: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `group`
ORDER BY CreateDate DESC
LIMIT 5;

# Question 8: Xóa tất cả các exam được tạo trước ngày 20/12/2019
/*
DELETE from testing_system_1.exam
WHERE CreateDate >2019-12-20; */

# Question 9: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn

UPDATE   `account`
SET FullName ='Nguyễn Bá Lộc', Email='loc.nguyenba@vti.com.vn'
WHERE AccountID= 5;

#Question 10: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT m.AccountID, m.FullName, m.DepartmentID, d.DepartmentName
FROM `account` m
JOIN Department d ON m.DepartmentID = d.DepartmentID
ORDER BY accountID;

# Question 11: Viết lệnh để lấy ra tất cả các developer
SELECT m.FullName, d.positionName
FROM `account` m
JOIN `position` d ON m.positionID = d.positionID
WHERE d.positionName ='DEV';

# Question 12: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT m.departmentID, m.departmentName, count(d.departmentID) as count_department
FROM department m
JOIN `account` d ON m.departmentID=d.departmentID
GROUP BY m.departmentID
HAVING count_department >3
ORDER BY count_department DESC;

# Question 13: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT m.QuestionID, m.content, count(d.QuestionID) as count_Question
FROM question m
JOIN examquesion d ON m.QuestionID =d.QuestionID
GROUP BY m.questionID
ORDER BY count_question DESC;

# Question 14: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT m.*, count(d.categoryID) as count_category
FROM categoryquesion m
LEFT JOIN question d ON m.categoryID =d.categoryID
GROUP BY m.categoryID
ORDER BY count_category DESC;

# Question 15: Lấy ra Question có nhiều câu trả lời nhất
SELECT m.questionID, m.content, count(d.questionID) as count_question
FROM question m
JOIN answer d ON m.questionID = d.questionID
GROUP BY m.questionID 
 ORDER BY count_question DESC 
 LIMIT 1;

# Question 16: Tìm chức vụ có ít người nhất
SELECT m.* , count(d.positionID) as count_position
FROM `position` m
LEFT JOIN `account` d ON m.positionID = d.positionID
GROUP BY m.positionID
ORDER BY count_position 
LIMIT 1;

# Question 17: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT m.*, d.positionName, count(e.positionID) as count_position
FROM department m
LEFT JOIN `account` e ON e.departmentID =m.departmentID 
LEFT JOIN `position` d ON e.positionID=d.positionID
 GROUP BY m.departmentID , d.positionID
ORDER BY m.departmentID;

/* Question 18: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ... */
SELECT a.QuestionID, a.content, b.TypeName, c.FullName, d.content as Reply_content
FROM question 		a
JOIN typequestion 	b 	ON a.TypeID 	= b.TypeID
JOIN `account` 		c	ON a.CreatorID 	= c.accountID
JOIN answer 		d	ON a.QuestionID = d.questionID
GROUP BY a.questionID
ORDER BY a.questionID;

# Question 19: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT a.*,  count(b.TypeID)
FROM typequestion 	a
JOIN question		b	ON 	a.TypeID = b.TypeID
GROUP BY a.TypeID;