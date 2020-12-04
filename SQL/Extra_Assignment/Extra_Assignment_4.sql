CREATE DATABASE IF NOT EXISTS employee_ag4; 
-- DROP DATABASE IF EXISTS employee_ag4; 
USE employee_ag4;

CREATE TABLE IF NOT EXISTS Employee
(
	EmployeeID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeLastName		VARCHAR(100),
    EmployeeFirstName		VARCHAR(100),
    EmployeeHireDate		DATETIME,
    EmployeeStatus			TINYINT,
    SupervisorID			INT UNSIGNED,
    SocialSecurityNumber	INT UNSIGNED
);

CREATE TABLE IF NOT EXISTS Projects
(
	ProjectID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    ManagerID				INT UNSIGNED,
    ProjectName				VARCHAR(100),
    ProjectStartDate		DATETIME,
    ProjectDescription		VARCHAR(100),
    ProjectDetailt	 		VARCHAR(100),
	ProjectCompletedON		DATETIME
);

CREATE TABLE IF NOT EXISTS Project_Modules 
(
	ModuleID						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectID						INT UNSIGNED,
    ProjectModulesDate				DATETIME,
    ProjectModulesCompletedOn			DATETIME,
    ProjectModulesDescription		VARCHAR(255)    
);


CREATE TABLE IF NOT EXISTS Work_Done
(
	WorkDoneID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeID			INT UNSIGNED,
    ModuleID			INT UNSIGNED,
    WorkDoneDate		DATETIME,
    WorkDoneDescription	VARCHAR(255),
    WorkDoneStatus		TINYINT
);

-- Thêm contraint 

ALTER TABLE Employee 
ADD FOREIGN KEY(SupervisorID)  	REFERENCES Employee(EmployeeID)			 ON DELETE CASCADE ON UPDATE CASCADE ;

ALTER TABLE work_done
ADD FOREIGN KEY(EmployeeID)  	REFERENCES Employee(EmployeeID) 		ON DELETE CASCADE ON UPDATE CASCADE,
ADD FOREIGN KEY(ModuleID) 		REFERENCES Project_Modules(ModuleID)	ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE Project_Modules
ADD FOREIGN KEY(ProjectID)		REFERENCES 	Projects(ProjectID)			ON DELETE CASCADE ON UPDATE CASCADE;



INSERT INTO 
employee_ag4.employee
		(EmployeeID	,EmployeeLastName,EmployeeFirstName,EmployeeHireDate,EmployeeStatus,SupervisorID,SocialSecurityNumber)
VALUES	('1','Thành'	,'Nguyễn Huy'			,'2019-01-03 00:00:00','1',Null	,'214294'),
		('2','Đông'		,'Công Phượng'			,'2019-01-03 00:00:00','1',1	,'215462'),
        ('3','Trang'	,'Đặng Nguyễn Phương'	,'2019-01-03 00:00:00','1',1	,null	 ),
        ('4','Thủy'		,'Thạch Thanh'			,'2019-01-05 00:00:00','1',Null	,'235454'),
        ('5','Hiệp'		,'Hoàng Mạnh'			,'2019-01-06 00:00:00','1',1	,Null	 ),
        ('6','Hằng'		,'Hồ Thị'				,'2019-02-01 00:00:00','1',4	,'355446'),
        ('7','Anh'		,'Nguyễn tú'			,'2019-03-05 00:00:00','1',4	,Null	 ),
        ('8','Giang'	,'Trần Thị Thu'			,'2019-03-06 00:00:00','1',4	,'332546'),
        ('9','Dũng'		,'Bùi Ngọc'				,'2019-04-03 00:00:00','1',10	,'123654'),
        ('10','Đạt'		,'Giang Tiến'			,'2019-03-08 00:00:00','1',Null	,Null	 ),
        ('11','Kiên'	,'Lại Trung'			,'2019-04-09 00:00:00','1',Null	,'512983'),
        ('12','Anh'		,'Vũ Tuấn'				,'2019-05-01 00:00:00','1',Null	,Null	 ),
        ('13','Thảo'	,'Ngọc Nguyễn'			,'2019-05-01 00:00:00','1',12	,'412123'),
        ('14','An'		,'Lê Ngọc'				,'2019-06-09 00:00:00','1',12	,'135123'),
        ('15','Việt'	,'Nguyễn Việt'			,'2019-04-09 00:00:00','1',2	,'123141'),
        ('16','Hiếu'	,'Đỗ Duy'				,'2019-04-08 00:00:00','1',2	,'1231445');
 
INSERT INTO Project_Modules
		(ModuleID,ProjectID,ProjectModulesDate,ProjectModulesCompletedOn,ProjectModulesDescription)
VALUES	('1'	,'1','2020-03-01 00:00:00','2020-05-01 00:00:00','web customer'		),
		('2'	,'1','2020-03-01 00:00:00','2020-03-29 00:00:00','web profile'		),
        ('3'	,'1','2020-03-01 00:00:00','2020-08-29 00:00:00','web_report'		),
        ('4'	,'2','2020-03-05 00:00:00','2020-09-15 00:00:00','app driver'		),
        ('5'	,'2','2020-03-05 00:00:00','2020-10-14 00:00:00','app customer'		),
        ('6'	,'3','2020-03-05 00:00:00',NULL					,'app driver'		),
        ('7'	,'3','2020-03-10 00:00:00',NULL					,'app customer'		),
        ('8'	,'4','2020-03-01 00:00:00',NULL					,'Backend web'		),	
        ('9'	,'4','2020-03-01 00:00:00','2020-03-09 00:00:00','Backend database'	),
        ('10'	,'5','2020-04-01 00:00:00','2020-09-01 00:00:00','manual'			),
        ('11'	,'5','2020-04-01 00:00:00','2020-11-14 00:00:00','automation'		);
        
        
INSERT INTO projects
		(ProjectID,managerID,projectName,ProjectStartDate,ProjectDescription,ProjectDetailt,ProjectCompletedOn)
VALUES 	('1','1','Web_MyGo'		,'2020-03-01 00:00:00' 	,'Web for customer'  		,'just a web' 	,'2020-07-15 00:00:00'	),
		('2','1','Android_MyGo'	,'2020-03-05 00:00:00'	,'Android App for customer'	,'just a app' 	,'2020-08-29 00:00:00'	),
        ('3','1','iOS_MyGo' 	,'2020-03-05 00:00:00'	,'iOs App for customer'		,'just a app'	,NULL					),
        ('4','1','Backend_MyGo'	,'2020-03-01 00:00:00'	,'BE for MyGo application'	,'Big BE'		,NULL					),
        ('5','4','Test_MyGo'	,'2020-04-01 00:00:00'	,'Test'						,'Automation'	,'2020-11-01 00:00:00'	);
        
INSERT INTO work_done
			(WorkDoneID,EmployeeID,ModuleID,WorkDoneDate,WorkDoneDescription,WorkDoneStatus)
VALUES
			('1','5','1','2020-01-01 00:00:00','design'					,'1'),
            ('2','5','1','2020-01-01 00:00:00','core js'				,'1'),
            ('3','5','2','2020-01-01 00:00:00','html, css'				,'1'),
            ('4','11','2','2020-01-01 00:00:00','javascrip and vue'		,'1'),
            ('5','14','3','2020-01-01 00:00:00','make data'				,'1'),
            ('6','13','3','2020-01-01 00:00:00','vue design'			,'1'),
            ('7','2','4','2020-01-01 00:00:00','app driver-design'		,'1'),
            ('8','15','4','2020-01-01 00:00:00','app driver-api done'	,'1'),
            ('9','16','5','2020-01-01 00:00:00','app customer-design'	,'1'),
            ('10','2','5','2020-01-01 00:00:00','app customer-api done'	,'1'),
            ('11','9','6','2020-01-01 00:00:00','ios design'			,'1'),
            ('12','10','7','2020-01-01 00:00:00','ios design + api work','1'),
            ('13','11','8','2020-01-01 00:00:00','backend core'			,'1'),
            ('14','12','8','2020-01-01 00:00:00','backend system'		,'1'),
            ('15','4','8','2020-01-01 00:00:00','backend api'			,'1'),
            ('16','1','9','2020-01-01 00:00:00','backend data config'	,'1'),
            ('17','3','9','2020-01-01 00:00:00','backend create'		,'1'),
            ('18','6','10','2020-01-01 00:00:00','write test case'		,'1'),
            ('19','8','10','2020-01-01 00:00:00','sumary test case'		,'1'),
            ('20','7','11','2020-01-01 00:00:00','write	code done'		,'1');
            
	/* b) Viêt thủ tục để Remove toàn bộ thông tin Project đã hoàn thành lâu hơn 3 
    tháng tính từ thời điểm hiện tại. (Ví dụ bh là tháng 03/12 thì những project nào 
    done trước 03/09 ta sẽ remove đi). Đồng thời thống kê số lượng bản ghi bị xóa ở mỗi bảng liên quan. */

/*

DELIMITER $$
CREATE PROCEDURE done_3_month_ago () 
	BEGIN
		SELECT count(*) as  soluong_projected
        FROM Projects
        WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month);
        
        SELECT count(*) as soluong_Project_Modules
        FROM project_modules 
        WHERE projectID IN (Select projectID FROM projects WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month));
        
        SELECT count(*) as soluong_Project_Work_Done
        FROM work_done
        WHERE ModuleID IN  ( SELECT ModuleID 
        FROM project_modules 
        WHERE projectID IN (Select projectID FROM projects WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month)));
    END $$
DELIMITER ;
*/ 


DELIMITER $$
CREATE PROCEDURE soluong_project_done(OUT a INT(11))
	BEGIN
		SELECT count(*) as  soluong_projected  INTO a
        FROM Projects
        WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month);
	END $$
 DELIMITER ;
 
DELIMITER $$
CREATE PROCEDURE soluong_project_modules(out b int(11) )
	BEGIN
		SELECT count(*) as soluong_Project_Modules INTO b
        FROM project_modules 
        WHERE projectID IN (Select projectID FROM projects WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month));
	END $$
 DELIMITER ;
 
 DELIMITER $$
CREATE PROCEDURE soluong_work_done(out c int(11)) 
	BEGIN
		SELECT count(*) as soluong_Project_Work_Done INTO c
        FROM work_done
        WHERE ModuleID IN  ( SELECT ModuleID 
        FROM project_modules 
        WHERE projectID IN (Select projectID FROM projects WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month)));
	END $$
 DELIMITER ;
 
DELIMITER $$
CREATE PROCEDURE Remove_done_3_month_ago()
	BEGIN
		SET @a ='';
        SET @b='';
        SET @c='';
        Set @d='';
        
        CALL soluong_project_done(@a);
        CALL soluong_project_modules(@b);
        CALL soluong_work_done(@c);
        CALL soluong_project_done(@d);
        
        SELECT 
        @a as soluong_project_done,
		@b as soluong_project_modules_done,
        @c as soluong_work_modules_done,
        @d as soluong_project_done_now;
        IF(@a = @d ) THEN 
         DELETE FROM projects WHERE ProjectCompletedON <= DATE_SUB(now(),INTERVAL 3 month);
		END IF;
	END $$
 DELIMITER ;

# c) Viết stored procedure để in ra các module đang được thực hiện. 
DELIMITER $$
CREATE PROCEDURE ALL_modules_unfinished()
	BEGIN 
		SELECT * 
        FROM 
			project_modules   
        WHERE  ProjectModulesCompletedOn IS NULL  ;
    END $$
DELIMITER ;
/* stored procedure  có parameter. Hiểu :  tìm  project_modules chưa hoàn thành của 1 dự án  */ 
DELIMITER $$
CREATE PROCEDURE project_modules_unfinished(IN projectID1 int(11))
	BEGIN 
		SELECT * 
        FROM 
			project_modules  
        WHERE  ProjectModulesCompletedOn IS NULL AND projectID = projectID1 ;
    END $$
DELIMITER ;
--
DELIMITER $$
CREATE PROCEDURE self_emp_worker(IN projectID1 int(11))
	BEGIN 
	SELECT 
    *
FROM
    employee
WHERE
    SupervisorID IS NULL
        AND EmployeeID IN (SELECT 
            EmployeeID
        FROM
            work_done
        WHERE
            moduleID IN (SELECT 
                    ModuleID
                FROM
                    project_modules
                WHERE
                    projectID = projectID1));
	
    END $$
DELIMITER ;

SET @project1 = 3;
CALL self_emp_worker(@project1);

