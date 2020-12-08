USE testing_system_1;

/* Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước  */
DROP TRIGGER IF EXISTS Q_1; 
DELIMITER $$
	CREATE TRIGGER Q_1
		BEFORE INSERT ON `groupaccount`
        FOR EACH ROW
	BEGIN 
		IF DATE_SUB(now(), INTERVAL 1 YEAR) > (SELECT CreateDate FROM `group` WHERE groupID = NEW.groupID) THEN 
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT ='khong the them vao group da tao truoc 1 nam';
        END IF;
	END $$
DELIMITER ;

INSERT INTO `groupaccount`
VALUES ('6', '7', '2019-01-01');

-- Ques2 
DROP TRIGGER IF EXISTS Q_2; 
DELIMITER $$
	CREATE TRIGGER  Q_2
	BEFORE INSERT ON `account`
	FOR EACH ROW
    BEGIN 
		IF NEW.departmentID = (SELECT departmentID FROM department WHERE departmentName = 'sale')  THEN 
         SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT ='Department "Sale" cannot add more user';
        END IF;
    END $$
DELIMITER ;
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Q_3; 
DELIMITER $$
	CREATE TRIGGER  Q_3
	BEFORE INSERT ON `groupaccount`
	FOR EACH ROW
    BEGIN 
		IF (SELECT count(*) from groupaccount WHERE groupID=NEW.groupID) =5  THEN 
         SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT ='khong the them vao group da co 5 account';
        END IF;
    END $$
DELIMITER ;

# Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS Q_4; 
DELIMITER $$
	CREATE TRIGGER  Q_4
	BEFORE INSERT ON `examquesion`
	FOR EACH ROW
    BEGIN 
		IF (SELECT count(*) from examquesion WHERE examID =NEW.examID) =10 THEN 
         SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT ='khong the them  quesion vao exam da co 10 quesion';
        END IF;
    END $$
DELIMITER ;


-- Q5 
DROP TRIGGER IF EXISTS Q_5; 
DELIMITER $$
	CREATE TRIGGER  Q_5
	BEFORE DELETE ON `account`
	FOR EACH ROW
    BEGIN 
		IF (SELECT old.email FROM `account` WHERE old.email = 'admin@gmail.com') THEN 
         SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT ='đây là tài khoản admin, không cho phép user xóa';
        END IF;
    END $$
DELIMITER ;
-- Q6
DROP TRIGGER IF EXISTS Q_6; 
DELIMITER $$
	CREATE TRIGGER  Q_6
	BEFORE INSERT ON `account`
	FOR EACH ROW
    BEGIN 
		IF NEW.`DepartmentID`is NULL THEN 
			SET NEW.`DepartmentID` = (SELECT DepartmentID FROM department WHERE DepartmentName ='waiting Department');
        END IF;
    END $$
DELIMITER ;

-- Q7
DROP TRIGGER IF EXISTS Q_7; 
DELIMITER $$
	CREATE TRIGGER  Q_7
	BEFORE INSERT ON `answer`
	FOR EACH ROW
    BEGIN 
		IF (SELECT count(*) FROM answer WHERE answerID = NEW.answerID )=4 THEN 
			 SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT ='đã có đủ 4 câu trả lời';
        END IF;
		IF (SELECT count(*) FROM answer WHERE isCorrect ='1')=2 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT ='đã có 2 câu trả lời đúng';
        END IF;
    END $$
DELIMITER ;

-- Q8;

# gender column  doesn't exist in table account.

-- Q9  Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Q_9; 
DELIMITER $$
	CREATE TRIGGER  Q_9
	BEFORE DELETE ON `exam`
	FOR EACH ROW
    BEGIN 
		IF OLD.CreateDate >= DATE_SUB(now(),INTERVAL 2 DAY) THEN 
			 SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT ='bài thi  mới tạo được 2 ngày, chưa thể xóa !!!';
        END IF;
    END $$
DELIMITER ;

-- Q10
DROP TRIGGER IF EXISTS Q_10;
DROP TRIGGER IF EXISTS Q_10_D; 
DELIMITER $$
	CREATE TRIGGER  Q_10 
	BEFORE UPDATE ON  `question`  
    FOR EACH ROW
    BEGIN 
		IF QuestionID IN (SELECT QuestionID FROM examquesion )  THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT ='Không thể update vì question đã cho vào đề thi !!!';
        END IF;
    END;
    
	CREATE TRIGGER Q_10_D
     BEFORE DELETE ON  `question`
     FOR EACH ROW 
     BEGIN 
			IF OLD.QuestionID IN (SELECT questionID FROM examquesion )  THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT ='Không thể xóa vì question đã cho vào đề thi !!!';
            END IF ;
     END $$
DELIMITER ;

