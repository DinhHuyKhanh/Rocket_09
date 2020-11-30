
USE fresher_management;
# =============================Exercise 1: Tiếp tục với Database quản lý Fresher =====================
 -- question 1
-- them 10 ban ghi
#  TRUNCATE table trainee;
INSERT INTO trainee (TaineeID,Full_Name,Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class,Evaluation_Notes)
VALUES 
(1, 'Đình Tuấn'		, '1999-07-23', 'Male'	, 20, 20, 50, 'A007', 'Perfect'),
(2, 'Bảo Anh'		, '1999-10-05', 'Male'	, 10, 10, 25, 'A007', 'Mischief'),
(3, 'Thùy Dương'	, '1999-12-03', 'Female', 14, 16, 45, 'A002', 'Docile'),
(4, 'Quỳnh Anh'		, '1999-12-10', 'Female', 10, 20, 15, 'A001', 'Docile'),
(5, 'Đình Tú'		, '2002-01-22', 'Male'	, 9	, 10, 36, 'A004', 'Mischief'),
(6, 'Đậu Hiền'		, '1999-06-14', 'Female', 3	, 10, 50, 'A002', 'Docile'),
(7, 'Đắc Công'		, '1999-01-01', 'Male'	, 10, 10, 16, 'A006', 'Mischief'),
(8, 'Trà My'		, '1999-03-05', 'Female', 12, 14, 35, 'A001', 'Docile'),
(9, 'Phan Ngọc'		, '1977-06-01', 'Female', 20, 20, 40, 'A003', 'Perfect'),
(10, 'Nguyễn Ngân'	, '1999-07-23', 'Female', 15, 12, 25, 'A005', 'Docile'),
(11, 'Nguyễn Thảo'	, '1999-11-19', 'Female', 1	, 2, 25, 'A003', 'Mischief'),
(12, 'Phương Hoa'	, '1999-04-16', 'Female', 5	, 2, 29, 'A004', 'Docile'),
(13, 'Đức Vượng'	, '1999-07-19', 'Male'	, 15, 12, 45, 'A005', 'Docile');

 
 /* Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, 
 nhóm chúng thành các tháng sinh khác nhau */
 
SELECT 
*, MONTH(Birth_Date) as `Month`
 FROM trainee
WHERE ET_IQ >10
GROUP BY TaineeID
Having `Month`
ORDER BY `MONTH`;


 
 -- ====================================================================================
 /* Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau:
tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table) */

SELECT 
Full_Name, Birth_Date, Gender,Training_Class, char_Length(FULL_Name) as Length_name
FROM 
trainee
WHERE CHAR_LENGTH(FULL_Name) = (SELECT MAX(CHAR_LENGTH(FULL_Name)) from trainee)
ORDER BY char_length(Full_Name)
LIMIT 1;
 
 #Cách 2;
 
SELECT *, char_length(Full_Name) as length_Full_Name FROM 
trainee
ORDER BY length_Full_Name DESC
LIMIT 1;
 /* Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18 */

SELECT * ,( ET_IQ + ET_Gmath) as SUM_IQ_and_Gmath
 FROM 
trainee
WHERE ET_IQ + ET_Gmath >= 20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18;
# Question 5: xóa thực tập sinh có TraineeID = 3

DELETE FROM 
trainee
WHERE TaineeID = 3; 
SELECT * FROM trainee;

/* Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật
thông tin vào database */ 

UPDATE trainee
SET Training_Class=  'A002'
WHERE TaineeID= 5;




 


