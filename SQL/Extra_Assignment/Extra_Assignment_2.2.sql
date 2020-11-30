# =============================Exercise 2 ===========================
# 	Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
/* Department (Department_Number, Department_Name)
Employee_Table (Employee_Number, Employee_Name,
Department_Number)
Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered) */


CREATE DATABASE IF NOT EXISTS employees;
USE employees;
#  tao bang Department

 CREATE TABLE IF NOT EXISTS Department
 (
 Department_Number 		INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
 Department_Name 		VARCHAR(100)
 );
  # TAO TABLE  :  Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered) 
  CREATE TABLE IF NOT EXISTS Employee_Skill_Table
 (
	Employee_Number		 INT UNSIGNED AUTO_INCREMENT NOT NULL,
    Skill_Code			 Varchar(100) ,
    Date_Registered		DATE,
    CONSTRAINT fk_skill PRIMARY KEY ( Employee_Number, Skill_Code)
 );
 # Tạo bảng Emplouyee_Table (Employee_Number, Employee_Name,  Department_Number)
 

 CREATE TABLE IF NOT EXISTS Department_Table 
 (
	Employee_Number 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Employee_Name 			VARCHAR(100),
    Department_Number		INT UNSIGNED,
   CONSTRAINT fk_ten  		FOREIGN KEY  (Employee_Number) REFERENCES Employee_Skill_Table ( Employee_Number),
   CONSTRAINT fk_ten_dep 	FOREIGN KEY ( Department_Number) REFERENCES Department(Department_Number)
 );


 
 # 	Question 2: Thêm ít nhất 10 bản ghi vào table
 
 -- Thêm vào bảng Department
 INSERT INTO employees.department 
 VALUES 
 ('1'			,'SAMSUNG'	),
 ('2'			,'SONY'		),
 ('3'			,'LG'		),
 ('4'			,'CANOT'	);

 INSERT INTO employees.employee_skill_table 
 VALUES 
		('1'	, 'JAVA'	, 	'2020-11-28'),
        ('2'	, 'PYTHON' 	, 	'2020-11-28'),
        ('3'	, 'HTML'	, 	'2020-11-28'),
        ('4'	, 'CSS'		, 	'2020-11-28'),
        ('5'	, 'JAVA' 	, 	'2020-11-28'),
        ('6'	, 'C#'		, 	'2020-11-28'),
        ('7'	, 'SQL'		, 	'2020-11-28'),
        ('8'	, 'PHOTOSHOP', 	'2020-11-28'),
        ('9'	, 'JAVA'	, 	'2020-11-28'),
        ('10'	, 'JAVA'	, 	'2020-11-28'),
        ('11'	, 'HTML' 	, 	'2020-11-28'),
        ('12'	, 'C#'		, 	'2020-11-28');
	
 
 
 INSERT INTO employees.department_table
 VALUES
('1'		,'Soobin Hoang Son'		,'2'		),
('2'		,'Tran Thanh MC'		,'3'		),
('3'		,'Truong Giang MC'		,'1'		),
('4'		,'Quan AP'				,'4'		),
('5'		,'My Tam'				,'1'		),
('6'		,'Dam Vinh Hung'		,'3'		),
('7'		,'Binz'					,'2'		),
('8'		,'SuBoi'				,'1'		),
('9'		,'Big Daddy'			,'2'		),
('10'		,'Erik'					,'3'		),
('11'		,'Duc Phuc'				,'4'		),
('12'		,'Hari Won'				,'2'		);
	

#Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java Hướng dẫn: sử dụng UNION

/*
SELECT Employee_Number FROM employees_test.employee_skill_table
UNION ALL
SELECT Employee_Number FROM employees_test.department_table ; */

SELECT d.Employee_Number, d.Employee_Name, m.Skill_Code
FROM department_table d
JOIN employee_skill_table m ON d.Employee_Number = m.Employee_Number
WHERE m.Skill_Code = 'JAVA';

# Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 
m.Department_Number,COUNT(m.Department_Number)  as COUNT, d.Department_Name
FROM 
department_table m
JOIN Department d ON m.Department_Number = d.Department_Number
Group By m.Department_Number;

/* Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
 Hướng dẫn: sử dụng GROUP BY */
SELECT d.Department_Number, d.Department_Name, m.Employee_Name,m.Employee_Number
FROM Department d
JOIN Department_table m ON m.Department_Number = d.Department_Number
ORDER BY d.Department_Number ;
-----
 /* Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
 Hướng dẫn: sử dụng DISTINCT */
 SELECT 
 m.Employee_Number ,m.Employee_Name, count(d.Skill_Code)
 FROM department_table m
 JOIN employee_skill_table d ON m.Employee_Number = d.Employee_Number
 Group by d.Employee_Number
 HAVING count(d.Skill_Code)>1;