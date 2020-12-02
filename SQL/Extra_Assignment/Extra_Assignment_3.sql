USE adventureworks;

/* ================================Exercise 1: Subquery =============================== */

/* Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name
của ProductSubcategory là 'Saddles'.
Hướng dẫn:
Sử dụng Sub Query để lấy ra tất cả các ID của ProductSubcategory có name =
'Saddles'.
Sau đó trong outer query, sử dụng kết quả từ Sub Query để lấy ra yêu cầu của đề bài. */
SELECT `Name` FROM  product 
WHERE ProductSubcategoryID  IN (SELECT ProductSubcategoryID FROM productsubcategory WHERE productsubcategory.Name = 'Saddles');

# Question 2: Thay đổi câu Query 1 để lấy được kết quả sau. 
SELECT `Name`
FROM adventureworks.product
WHERE   ProductSubcategoryID IN (SELECT ProductSubcategoryID FROM productsubcategory WHERE `Name` LIKE 'Bo%');

/* Question 3:
Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring
Bike (nghĩa là ProductSubcategoryID = 3)
Hướng dẫn: sử dụng hàm MIN() trong subquery để trả về ListPrice thấp nhất */

SELECT Name,ListPrice
FROM 
Product
WHERE ProductSubcategoryID ='3'
GROUP BY Name
HAVING MIN(ListPrice);

# 

SELECT `Name`,ListPrice
FROM 
Product 
WHERE listPrice = (SELECT MIN(ListPrice) FROM Product WHERE productsubcategoryID = 3 );


#  JOIN nhiều bảng 
SELECT 
    a.Name AS Country, b.Name AS Province
FROM
    stateprovince a
        LEFT JOIN
    countryregion b ON a.CountryRegionCode = b.CountryRegionCode;
-- Cach 2
-- su dung subqueri
SELECT (SELECT `Name`  FROM countryregion WHERE CountryRegionCode = a.CountryRegionCode) as Country , a.Name as province
FROM stateprovince a;
# question3 
SELECT 
    a.SalesOrderID,
    a.OrderDate,
    a.SalesPersonID,
    b.SalesPersonID AS BusinessEntityID,
    b.Bonus,
    b.SalesYTD
FROM
    salesorderheader a
        LEFT JOIN
    salesperson b ON a.SalesPersonID = b.SalesPersonID
WHERE
    a.OnlineOrderFlag <> 1;
-- 



SELECT 
    a.SalesOrderID,
    a.OrderDate,
    c.Title as Jobtitle,
    b.Bonus,
    b.SalesYTD
FROM
    salesorderheader a
        LEFT JOIN
    salesperson b ON a.SalesPersonID = b.SalesPersonID
    LEFT JOIN 
    Employee c ON  	a.SalesPersonID = c.EmployeeID
WHERE
    a.OnlineOrderFlag <> 1;
    
