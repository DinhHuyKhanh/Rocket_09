CREATE DATABASE IF NOT EXISTS ThucTap;
-- DROP DATABASE ThucTap;
USE ThucTap;
CREATE TABLE IF NOT EXISTS Country(
country_id			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
country_name 		VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Location(
location_id			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
street_address		VARCHAR(255),
postal_code			VARCHAR(255),
country_id			INT UNSIGNED,
CONSTRAINT fk_l_country FOREIGN KEY (country_id) REFERENCES Country(country_id)
 );
 
 CREATE TABLE IF NOT EXISTS Employee(
 employee_id		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 full_name			VARCHAR(255),
 email				VARCHAR(255) UNIQUE KEY,
 location_id		INT UNSIGNED,
 CONSTRAINT fk_e_loca	FOREIGN KEY (location_id) REFERENCES Location(location_id)
 );
 
 INSERT INTO Country(country_id,country_name)
 VALUES (1,		'Viet Nam'	),
		(2,		'Phap'		),
        (3,		'My'		),
        (4,		'Nhat'		);
        
INSERT INTO Location(location_id,street_address,postal_code,country_id)
VALUES	(1,'dinh cong','VN',1),
		(2,'AQH',	'VN',1),
		(3,'KAJA'	,'A',2),
		(4,'MCK'	,'B',3),
		(5,'QDK'	,'C',4),
		(6,'AAABBB'	,'D',1),
		(7,'Hoang Quoc Viet','VN',1);


INSERT INTO Employee(employee_id,full_name,email,location_id)
VALUES 	(1,'Dinh Huy Khanh','khanhdinh141@gmail.com',1),
		(2,'Truong Thanh Dat','thanhdat123@gmail.com',1),
		(3,'Nguyen Thi Chinh','nguyenthichinh123@gmail.com',2),
		(4,'Tran Thuy Trang','thuytrang123@gmail.com',3),
		(5,'Nguyen Van A','thanhdt123@gmail.com',4),
		(6,'jack sol','nn03@gmail.com',5),
		(7,'master noosy','thanh123@gmail.com',6);
        
-- Cau 2
-- a Lấy tất cả các nhân viên thuộc Việt nam; 
SELECT 
    *
FROM
    employee
WHERE
    location_id IN (SELECT 
            location_id
        FROM
            location
        WHERE
            country_id = (SELECT 
                    country_id
                FROM
                    country
                WHERE
                    country_name = 'Viet Nam'));

-- b Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT 
    country_name
FROM
    country
WHERE
    country_id = (SELECT 
            country_id
        FROM
            location
        WHERE
            location_id = (SELECT 
                    location_id
                FROM
                    employee
                WHERE
                    email = 'nn03@gmail.com'));


-- c Thống kê mỗi country, mỗi location có bao nhiêu employee đang  làm việc.
WITH soluong_location AS
 ( SELECT location_id,street_address, country_id, (SELECT count(*) FROM employee WHERE location_id =a.location_id) as soluong_location FROM location a)
SELECT location_id as location_and_country, street_address as street_address_and_country_name ,soluong_location as sl_location_and_country FROM soluong_location
UNION 
SELECT a.country_id, a.country_name, sum(soluong_location) FROM country a  LEFT JOIN soluong_location b ON a.country_id = b.country_id GROUP BY country_id;

-- 3: Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS emp_khongqua_10; 
DELIMITER $$
	CREATE TRIGGER  emp_khongqua_10
	BEFORE INSERT ON `employee`
	FOR EACH ROW
    BEGIN 
		IF (SELECT count(*) from employee WHERE location_id IN (SELECT location_id FROM location WHERE country_id= (SELECT country_id FROM location WHERE location_id = 1 )) )=10  THEN 
         SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT ='khong the them nhan vien vi da co 10 nhan vien tai quoc gia nay';
        END IF;
    END $$
DELIMITER ;

# cau 4 : Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null
DROP TRIGGER IF EXISTS emp_update; 
DELIMITER $$
	CREATE TRIGGER  emp_update
	BEFORE DELETE ON `location`
	FOR EACH ROW
    BEGIN 
		UPDATE employee SET location_id = NULL WHERE location_id = old.location_id;
    END $$
DELIMITER ;

DELETE FROM location WHERE location_id= 1;
