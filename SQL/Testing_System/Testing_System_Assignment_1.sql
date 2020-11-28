# Testing system 1

DROP DATABASE IF EXISTS Testing_System_1;
CREATE DATABASE Testing_System_1;
USE Testing_System_1;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department
(
	DepartmentID		INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    DepartmentName 		nvarchar(255) UNIQUE KEY
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`
(
	PositionID			INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    PositionName 		ENUM('DEV','Test','Scrum Master','PM')
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
AccountID 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Email 			VARCHAR(255) UNIQUE KEY,
UserName		VARCHAR(255) UNIQUE KEY,
FullName		VARCHAR(255),
DepartmentID 	INT UNSIGNED NOT NULL,
PositionID		INT UNSIGNED NOT NULL,
CreateDate		DATE,
CONSTRAINT fk_position_Account FOREIGN KEY(PositionID)  REFERENCES Position (PositionID),
CONSTRAINT fk_deparment_account FOREIGN KEY(DepartmentID)  REFERENCES Department(DepartmentID)

);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`
(
GROUPID 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
GROUPNAME 		VARCHAR(255),
CreatorID		INT UNSIGNED NOT NULL,
CreateDate		DATE NOT NULL,
 CONSTRAINT fk_Group_Account FOREIGN KEY(CreatorID)  REFERENCES Account(AccountID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount
(
	GroupID 	INT UNSIGNED ,
    AccountID	INT UNSIGNED ,
    JoinDate 	DATE NOT NULL,
    CONSTRAINT fk_GrAccount_Account FOREIGN KEY(AccountID)  REFERENCES Account(AccountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion
(
	TypeID		INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    TypeName 	ENUM('Essay','Multiple-Choise') NOT NULL
);
DROP TABLE IF EXISTS CategoryQuesion;
CREATE TABLE CategoryQuesion
(
	CategoryID		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName 	nvarchar(255)
);

# TABLE 8 : QUESION
DROP TABLE IF EXISTS Question;
CREATE TABLE Question
(
	QuestionID 		INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    Content 		TEXT,
    CategoryID		INT UNSIGNED NOT NULL,
    TypeID			INT UNSIGNED NOT NULL,
    CreatorID		INT UNSIGNED NOT NULL,
	CreateDate		DATE NOT NULL,
     CONSTRAINT fk_quesion_typequesion FOREIGN KEY(TypeID)  REFERENCES TypeQuestion(TypeID),
	CONSTRAINT fk_GrAccount_CategoryQuesion FOREIGN KEY(CategoryID)  REFERENCES CategoryQuesion(CategoryID),
	CONSTRAINT fk_Quesion_Account FOREIGN KEY(CreatorID)  REFERENCES Account(AccountID)
     );


# TABLE 9
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer
(
	AnswerID 		INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Content			TEXT,
    QuestionID 		INT UNSIGNED,
    isCorrect 		BOOLEAN,
     CONSTRAINT fk_Answer_Quesion FOREIGN KEY(QuestionID)  REFERENCES Question(QuestionID)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam
(
	ExamID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 			nvarchar(20) NOT NULL,
    Title			TEXT,
    CategoryID		INT UNSIGNED NOT NULL,
    Duration		INT ,
    CreatorID 		INT UNSIGNED NOT NULL,
    CreateDate		DATE,
    CONSTRAINT fk_Exam_Quesion FOREIGN KEY(CategoryID)  REFERENCES Question(QuestionID),
    CONSTRAINT fk_Exam_Account FOREIGN KEY(CreatorID)  REFERENCES Account(AccountID)
);

DROP TABLE IF EXISTS ExamQuesion;
CREATE TABLE ExamQuesion
(
	ExamID 		INT UNSIGNED,
    QuestionID	INT UNSIGNED,
    CONSTRAINT fk_ExQ_Quesion FOREIGN KEY(QuestionID)  REFERENCES Question(QuestionID),
    CONSTRAINT fk_ExQ_Exam FOREIGN KEY(ExamID) REFERENCES Exam(ExamID)
);

/* ============================================== QUESION 3 =========================================================
 ============================================== INSERT  TABLE =========================================================*/

INSERT INTO Department
		(DepartmentID	,	DepartmentName		)
VALUES		
		("1"			,	"Quản lí"	),
        ("2"			,	"Thiết kế"	),
        ("3"			,	"Nhân sự"	),
        ("4"			,	"sale"	),
		("5"			,	"marketing"	),
        ("6"			,	"Tài vụ"	);
        

INSERT INTO testing_system_1.`position`
		(PositionID	,	PositionName)
VALUES 	("1"		,	"Dev"			),
		("2"		,	"Test"			),
        ("3"		,	"Scrum Master"	),
        ("4"		,	"PM"			);
        
INSERT INTO testing_system_1.`account`
			(AccountID	,	Email 					, Username 		, FullName			, DepartmentID	,PositionID	,CreateDate		)
VALUES		("1"		,	"khanhdinh141@gmail.com","dinhkhanh141"	," Đinh Huy Khánh" 	, "1"			,"1"		,"2020-11-27" 	),
			("2"		,	"anloc145@gmail.com"	,"anloc145"		," Nguyễn An Lộc" 	, "2"			,"1"		,"2020-11-27" 	),
			("3"		,	"nguyenthu151@gmail.com","nguyenthu151"	," Nguyễn Thị THu" 	, "3"			,"2"		,"2020-11-27" 	),
            ("4"		,	"phamvinh2001@gmail.com","phamvinh2001"	," Phạm Xuân Vinh" 	, "4"			,"2"		,"2020-11-27" 	),
            ("5"		,	"nguyenhoa131@gmail.com","nguyenhoa131"	," Nguyễn Thị Hoa" 	, "2"			,"2"		,"2020-11-27" 	),
            ("6"		,	"thuhuong191@gmail.com"	,"thuhuong191"	," Nguyễn Thu Hương", "5"			,"1"		,"2020-11-27" 	),
            ("7"		,	"nguyenhoai91@gmail.com","nguyenhoai91"	," Nguyễn Thị Hoài"	, "6"			,"4"		,"2020-11-27" 	),
            ("8"		,	"phamtien921@gmail.com"	,"phamtien921"	," Phạm Văn Tiến" 	, "1"			,"3"		,"2020-11-27" 	);
        
INSERT INTO testing_system_1.`Group`
			(GroupID	,GroupName					,CreatorID	,CreateDate)
Values		("1"		,"404 Not Found"			,"2"		,"2019-1-1"),
			("2"		,"CLB người cao tuổi"		,"1"		,"2019-1-1"),
            ("3"		,"Viện tâm thần"			,"3"		,"2019-1-1"),
			("4"		,"FA xấu nhất xã"			,"5"		,"2019-1-1"),
            ("5"		,"Yêu là tới, lớ xớ là bỏ"	,"4"		,"2019-1-1"),
            ("6"		,"Group bựa nhất làng"		,"6"		,"2019-1-1"),
			("7"		,"Không sợ vợ"				,"8"		,"2019-1-1");
            
INSERT INTO testing_system_1.groupaccount
			(GroupID	,AccountID	,JoinDate)
VALUES		("1"		,"2"		,"2019-1-1"),
			("1"		,"1"		,"2019-1-1"),
            ("1"		,"4"		,"2019-2-1"),
            ("2"		,"1"		,"2019-1-1"),
            ("2"		,"4"		,"2019-2-1"),
            ("3"		,"2"		,"2019-1-1"),
            ("3"		,"1"		,"2019-2-1"),
            ("4"		,"7"		,"2019-1-1"),
            ("4"		,"6"		,"2019-2-1"),
            ("5"		,"8"		,"2019-1-1"),
            ("5"		,"1"		,"2019-2-1"),
            ("6"		,"4"		,"2019-1-1"),
            ("6"		,"5"		,"2019-2-1"),
            ("1"		,"3"		,"2019-1-1"),
            ("7"		,"3"		,"2019-2-1"),
            ("2"		,"7"		,"2019-1-1"),
            ("7"		,"6"		,"2019-2-1"),
            ("6"		,"8"		,"2019-1-1"),
            ("7"		,"2"		,"2019-2-1");
            
	
INSERT INTO testing_system_1.typequestion
		(TypeID		,TypeName			)
VALUES 	("1"		,"Essay"			),
		("2"		,"Multiple-Choise"	);
      
        
INSERT INTO testing_system_1.categoryquesion
		(CategoryID		, CategoryName		)
VALUES	("1"			,"JAVA"				),
		("2"			,"PHP"				),
        ("3"			,"SQL"				),
        ("4"			,"C/C++"			),
        ("5"			,"CTDL-GT"			),
        ("6"			,"HTML"				),
        ("7"			,"CSS"				),
        ("8"			,".NET"				),
        ("9"			,"Python"			),
        ("10"			,"Postman"			),
		("11"			,"Ruby"				);
        
INSERT INTO testing_system_1.question
		(QuestionID	,Content										, CategoryID		,TypeID		,CreatorID	,CreateDate		)
VALUES 	("1"		,"Sự khác nhau giữa JDK,JRE và JVM?"			,"1"				,"2"		,"1"		,"2020-11-27"	),
		("2"		,"Classloader trong java là gì?"				,"1"				,"1"		,"1"		,"2020-11-27"	),
        ("3"		,"Platform là gì??"								,"1"				,"1"		,"1"		,"2020-11-27"	),
        ("4"		,"Giá trị mặc định của các biến local là gì?"	,"1"				,"2"		,"1"		,"2020-11-27"	),
        ("5"		,"Constructor là gì?"							,"1"				,"1"		,"1"		,"2020-11-27"	),
        ("6"		,"Biến static là gì?"							,"1"				,"1"		,"1"		,"2020-11-27"	);
 
INSERT INTO Answer
		(AnswerID	, Content		, QuestionID 	)
VALUES 	("1"		,""				,"1"			),
		("2"		,""				,"2"			),
		("3"		,""				,"3"			),
        ("4"		,""				,"4"			),
        ("5"		,""				,"5"			),
        ("6"		,""				,"6"			);
        
INSERT INTO Exam
		(ExamID	,	`Code`	,Title		,CategoryID		,Duration	,CreatorID		,CreateDate)
VALUES 	("1"	,"A100"		,"EXAM_1"	,"1"			,"90"	,"1"			,"2020-1-1"),
		("2"	,"A101"		,"EXAM_2"	,"2"			,"90"	,"1"			,"2020-1-1"),
        ("3"	,"A102"		,"EXAM_3"	,"3"			,"90"	,"1"			,"2020-1-1"),
        ("4"	,"A103"		,"EXAM_4"	,"4"			,"90"	,"1"			,"2020-1-1"),
        ("5"	,"A104"		,"EXAM_5"	,"5"			,"90"	,"1"			,"2020-1-1"),
        ("6"	,"A105"		,"EXAM_6"	,"6"			,"90"	,"1"			,"2020-1-1");
        
INSERT INTO testing_system_1.examquesion
		(ExamID		, QuestionID)
VALUES	("1"		,"1"),
		("2"		,"2"),
        ("3"		,"3"),
        ("4"		,"4"),
        ("5"		,"5"),
        ("6"		,"6");
	

        


        