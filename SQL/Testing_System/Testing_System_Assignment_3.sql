USE testing_system_1;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

CREATE VIEW employee_Sale AS
    SELECT 
                FullName
            FROM
                `account`
            WHERE
                DepartmentID = (SELECT 
                        DepartmentID
                    FROM
                        department
                    WHERE
                        DepartmentName = 'sale');
                        
	-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
 
CREATE VIEW Account_Join_Group_Max AS
    SELECT 
        a.*,
        count(b.groupID) as GroupJoin
    FROM
        `account` a
	LEFT JOIN 
		groupaccount b
		ON a.AccountID = b.AccountID
        GROUP BY b.accountID 
        ORDER BY GroupJoin DESC;
        
--  
# cach 2.

 CREATE VIEW Account_Join_Group_Max2 AS
SELECT 
    *
FROM
    `account`
WHERE
    accountID IN (SELECT 
            accountID
        FROM
            groupaccount
        GROUP BY accountID
        HAVING COUNT(*) = (SELECT 
            count(*)
        FROM
            groupaccount
        GROUP BY accountID
        HAVING COUNT(*) 
        LIMIT 1 ));

# Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi


# Question 4 :Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW emp_dep_max AS
SELECT 
    *
FROM
    department
WHERE
    departmentID IN (SELECT 
            departmentID
        FROM
            `account`
        GROUP BY departmentID
        HAVING COUNT(*) = (SELECT 
                count(*)
            FROM
                `account`
            GROUP BY departmentID
            HAVING COUNT(*)
            ORDER BY COUNT(*) DESC
            LIMIT 1))

