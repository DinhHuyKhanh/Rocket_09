USE testing_system_1;

/* Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
 account thuộc phòng ban đó */
 
 DELIMITER $$
	CREATE PROCEDURE `emp_account`(IN name_dept VARCHAR(100))
    BEGIN 
		SELECT 
    *
FROM
    `account`
WHERE
    DepartmentID = (SELECT 
            departmentID
        FROM
            department
        WHERE
            departmentName = name_dept);
    END $$
 DELIMITER ;
 
 
 # Question 2: Tạo store để in ra số lượng account trong mỗi group
 DELIMITER $$
	CREATE PROCEDURE `sl_acc_in_group`(IN name_dept VARCHAR(100))
    BEGIN 
		SELECT 
    GroupName,
    (SELECT 
            COUNT(*)
        FROM
            groupaccount
        WHERE
            GroupID = a.GroupID
        GROUP BY groupID) AS `so_luong`
FROM
    `group` a;
    END $$
 DELIMITER ;
 
 # Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
 DELIMITER $$
 CREATE PROCEDURE sl_typequestion_month()
	BEGIN 
		SELECT
    TypeName,
    (SELECT 
            COUNT(*)
        FROM
            question
        WHERE
            MONTH(CreateDate) = MONTH(NOW())
                AND YEAR(CreateDate) = YEAR(NOW())
                 AND TypeID = a.TypeID
        GROUP BY TypeID ) as soluong 
FROM
    typequestion a;
    END $$ 
 DELIMITER ;
 
 #  Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
 DELIMITER $$
	CREATE PROCEDURE id_typequestion_max(OUT TypeID_Max_ques int(11))
    BEGIN 
		SELECT TypeID INTO TypeID_Max_ques
        FROM question
        GROUP BY TypeID
        HAVING count(*) = (SELECT count(*) FROM question GROUP BY TypeID ORDER BY count(*) DESC LIMIT 1 ); 
    END $$
 DELIMITER ;
 
 # Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
 
 $ DELIMITER $$
 CREATE PROCEDURE search_typequestion( OUT TypeName_1 VARCHAR(100))
	BEGIN
		SET @TypeID_1 =0;
        CALL id_typequestion_max(@TypeID_1);
SELECT 
    TypeName
FROM
    typequestion
WHERE
    TypeID = @TypeID_1;
	END $$
 DELIMITER ;
 
 /* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
 chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
 chuỗi của người dùng nhập vào
 */
 DELIMITER $$
CREATE PROCEDURE Q_6_group (IN chuoi varchar(100), OUT x INT(11))
	BEGIN
		SELECT 
    COUNT(*)
FROM
    `group`
WHERE
    GroupName LIKE CONCAT('%', chuoi, '%');
    END $$
    DELIMITER ;

DELIMITER $$
CREATE PROCEDURE Q_6_User (IN chuoi varchar(100), OUT x int(11) )
	BEGIN
		SELECT count(*) INTO x FROM `account` WHERE UserName LIKE CONCAT('%',chuoi,'%'); 
    END $$
    DELIMITER ;
 
    DELIMITER $$
CREATE PROCEDURE ques_6 (IN chuoi varchar(100) )
	BEGIN
		SET @x =0;
        SET @y=0;
        SET @QK ='Không thỏa mãn';
        CALL Q_6_group(@x);
        CALL Q_6_user(@y);
        IF (x<>0) THEN SELECT GroupName FROM `group`  WHERE GroupName LIKE CONCAT('%',chuoi,'%');
			ELSEIF(y<>0)  THEN SELECT UserName FROM `account`	WHERE UserName LIKE CONCAT('%',chuoi,'%');
				ELSE SELECT @KQ;
        END IF;
    END $$
    DELIMITER ;
    /*
    CÁCH 2:  Dùng CTE IN  Store Procedure 
    
    
    */
    /* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
 trong store sẽ tự động gán:
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
 Sau đó in ra kết quả tạo thành công */
 -- Mạc định phòng chờ là 999
 DELIMITER $$
 CREATE PROCEDURE Q_7 (IN fullname_1 varchar(100), IN email_1 varchar(100) )
 BEGIN
	INSERT INTO `account`(FullName, UserName, Email,departmentID, positionID)
    VALUES(fullname_1, (SELECT SUBSTRING(email_1,1,'@'),email_1, 999), (SELECT positionID FROM `position` WHERE PositionName='DEV'));
    
     SET @`values` = 'Khởi tạo thành công';
     SELECT @`values`;
 END $$
 
 DELIMITER ;
 
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có conten max
    
DELIMITER $$
CREATE PROCEDURE Q_8(IN TypeName_1 enum('Eassy','Multiple-Choice'))
BEGIN 
	WITH Q_8_1 AS 
    (SELECT 
    questionID,
    content,
    (SELECT 
            TypeName
        FROM
            typequestion
        WHERE
            TypeID = a.TypeID) as TypeName
FROM
    question a) 
SELECT 
    *
FROM
    Q_8_1
WHERE
    TypeName = TypeName_1
        AND CHARACTER_LENGTH(content) = (SELECT 
            MAX(CHARACTER_LENGTH(content))
        FROM
            Q_8_1
        WHERE
            TypeName = TypeName_1);
    
END $$
DELIMITER ;
    
    
# Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DELIMITER $$
CREATE PROCEDURE Q_9(IN examID_1 int(11))
BEGIN 
	DELETE FROM exam 
    WHERE ExamID = examID_1; 
    SET @x = 'Xóa thành công';
    SELECT @x;
END $$
DELIMITER ;
/*
Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
 dụng store ở câu 9 để xóa)
 Sau đó in số lượng record đã remove từ các table liên quan trong khi
 removing */
 
 DELIMITER 	$$
 CREATE PROCEDURE Q_10()
 BEGIN
	SET @x=0;
	SELECT ExamID INTO @x FROM exam WHERE subdate(CreateDate, INTERVAL 3 YEAR) =subdate(now(), INTERVAL 3 YEAR);
    CALL Q_9(@x);
 END $$
 DELIMITER ;

/* Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
 nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
 chuyển về phòng ban default là phòng ban chờ việc
*/
DELIMITER $$
CREATE PROCEDURE Q_11(in dep_name varchar(100))
BEGIN 
	UPDATE `account`
    SET departmentID = '999'
    WHERE departmentName = dep_name;
END $$
DELIMITER ;

/*
Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
 nay
 */
 DELIMITER $$
CREATE PROCEDURE Q_12(in year_1 int(11))
BEGIN 
	SELECT MONTH(CreateDate),count(*) as dem
    FROM 
		Question
	WHERE YEAR(CreateDate) = year_1;
END $$
DELIMITER ;

