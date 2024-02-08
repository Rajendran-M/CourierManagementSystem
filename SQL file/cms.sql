
-- Assignment-Courier Management System
-- TASK 1 
/*Design a SQL schema for a Courier Management System with tables for Customers, Couriers, Orders,
and Parcels. Define the relationships between these tables using appropriate foreign keys. */

use cms;
CREATE table USER
(userID INT PRIMARY KEY, 
Name varchar(255),
Email varchar(255) unique, 
Password VARCHAR(255),
ContactNumber VARCHAR(20),
Address TEXT);
INSERT INTO USER(UserID,Name,Email,Password,contactNumber,Address) 
values
(101,'john kanedy','john123@mail.com','p@$$word',99694685,'456 Oak Avenue, Townsville'),
(102,'ben','ben123@mail.com','p@$$word',99690085,'4/6 navi,Cityville'),
(103,'arun','arun123@mail.com','p@$$Word',99698052,'4 park Avenue, Chennai'),
(104,'jones','jones123@mail.com','p@s$word',90687685,'456 vilage road,  Villagetown'),
(105,'kane','kane123@mail.com','pa$$word',99694005,'4B seruseri, Chennai');
CREATE table Courier
(CourierID INT PRIMARY KEY,
SenderName VARCHAR(255),
SenderAddress TEXT,
ReceiverName VARCHAR(255),
ReceiverAddress TEXT,
Weight DECIMAL(5, 2),
Status VARCHAR(50),
TrackingNumber VARCHAR(20) UNIQUE,
DeliveryDate DATE); 
-- Sample data for the Courier table
INSERT INTO Courier (CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate)
VALUES
    (201, 'kane Danials', '4B seruseri, chennai city', 'jones', '456 tnagarAvenue, Townsville', 2.5, 'In Transit', 'TRK123', '2024-01-15'),
    (202, 'Arun', '789 Pine Road, Villagetown', 'john kanedy', '456 Oak Avenue, metroTownsville', 1.8, 'Delivered', 'TRK456', '2024-01-14'),
    (203, 'David ', '456 Elm Avenue, Boroughburg', 'Ben jack',' 4/6 navi, mumbai', 3.0, 'Pending', 'TRK789', NULL),
     (204, 'kane Danials', '4B seruseri, chennai city', 'jones', '456 tnagarAvenue, Townsville', 2.5, 'In Transit', 'TRK103', '2024-02-29');
CREATE table CourierServices
(ServiceID INT PRIMARY KEY,
ServiceName VARCHAR(100),
Cost DECIMAL(8, 2)); 
INSERT INTO CourierServices (ServiceID, ServiceName, Cost)
VALUES
    (301, 'Standard Shipping', 10.00),
    (302, 'Express Shipping', 20.00),
    (303, 'Overnight Shipping', 30.00);

CREATE table Employee
(EmployeeID INT PRIMARY KEY,
Name VARCHAR(255),
Email VARCHAR(255) UNIQUE,
ContactNumber VARCHAR(20),
Role VARCHAR(50),
Salary DECIMAL(10, 2));
-- Sample data for the Employee table
INSERT INTO Employee (EmployeeID, Name, Email, ContactNumber, Role, Salary)
VALUES    (406,'joe','joe.ee@dmail.com','960-0628-419','Delivery Boy',40000.00),
    (401, 'John Doe', 'john.doe@example.com', '123-456-7890', 'Manager', 60000.00),
    (402, 'Jane Smith', 'jane.smith@example.com', '987-654-3210', 'supervisor', 50000.00),
    (403, 'Alice Johnson', 'alice.johnson@example.com', '555-123-4567', 'Sales Representative', 45000.00),
    (404,'Mikey Dan','mikey.luffy@dmail.com','960-062-2419','Delivery Boy',40000.00),
	(405, 'casce Johnson', 'casce.johnson@example.com', '525-122-4534', 'Customer support', 45000.00);
    
CREATE table Location 
(LocationId INT PRIMARY KEY,
LocationName VARCHAR(100),
Address TEXT);
-- Sample data for the Location table
INSERT INTO Location (LocationID, LocationName, Address)
VALUES
    (60002, 'Headquarters', '123 Main Street, Cityville'),
    (5001, 'Branch A', '456 Oak Avenue, Townsville'),
    (5003, 'Branch B', '789 Pine Road, Villagetown');

CREATE table Payment
(PaymentID INT PRIMARY KEY ,
CourierID INT,
LocationId INT,
Amount DECIMAL(10,2),
PaymentDate DATE,
FOREIGN KEY(CourierID) REFERENCES Courier(CourierID),
FOREIGN KEY (LocationId) REFERENCES Location(LocationId));
-- Sample data for the Payment table
INSERT INTO Payment (PaymentID, CourierID, LocationID, Amount, PaymentDate)
VALUES
    (6580,201, 60002, 50.00, '2024-01-15'),
    (6155,202, 5001, 30.00, '2024-01-14'),
    (6425,203, 5003, 25.00, '2024-01-13'),
     (6011,204, 5001, 25.00, '2024-01-13');
-- orders     
CREATE TABLE orders (OrderID INT PRIMARY KEY,UserID INT, 
OrderDate DATE,Deliverydate DATE, TotalAmount DECIMAL(10, 2),serviceid int,paymentId int,
employeeId INT ,status varchar(255),deliveredlocation varchar(255),
Foreign Key(userid) REFERENCES User(userid),Foreign Key(serviceid) REFERENCES courierServices(serviceid),
Foreign Key(Employeeid) REFERENCES Employee(employeeid));
INSERT INTO orders 
VALUES 
  (201, 105, '2024-01-06', '2024-02-15', 50.00, 303, 6580, 404, 'in Transit', '456 tnagarAvenue, Townsville'), 
  (202, 103, '2024-01-05', '2024-01-14', 30.00, 301, 6155, 404, 'Delivered', '456 Oak Avenue, metroTownsville'), 
  (203, NULL, '2024-01-07', NULL, 25.00, 302, 6425, 405, 'pending', '4/6 navi road, mumbai'), 
  (204, 105, '2024-01-19', NULL, 25.00, 301, 6011, NULL, 'canceled', '456 tnagarAvenue, Townsville');


select * from payment;

-- TASK-2
-- Solve the following queries in the Schema that you have created above
-- 1. List all customers:
select name from user;
-- 2. List all orders for a specific customer:
Select * 
from courier 
where ReceiverName ='jones';
-- 3. List all couriers:
select *
from courier;

-- 4. List all packages for a specific order:
SELECT *
FROM courierServices;

-- 5. List all deliveries for a specific courier:
Select courierid,locationId
from payment
where locationid = 5001;

-- 6. List all undelivered packages:
Select * 
from courier where status != 'delivered';
-- 7. List all packages that are scheduled for delivery today:
Select * 
from courier where DeliveryDate = curdate();
-- 8. List all packages with a specific status:
Select * 
from courier where status='delivered';
-- 9. Calculate the total number of packages for each courier.
select count(*) as total_packages
from courier ;
-- 10. Find the average delivery time for each courier
select orderid,concat(round(AVG(DATEDIFF(DeliveryDate, OrderDate))),'days') AS AvgDeliveryTime
FROM orders 
WHERE DeliveryDate IS NOT NULL AND OrderDate IS NOT NULL GROUP BY orderid;
-- 11. List all packages with a specific weight range:
select*
from courier where Weight between 1.0 and 2.0;

-- 12. Retrieve employees whose names contain 'John'
select * from employee where name like '%john%';
-- 13. Retrieve all courier records with payments greater than $50.
select * 
from payment where amount > 50;
-- 13. Retrieve all courier records with payments greater than $50.
SELECT 
    courier.*, payment.amount
FROM
    courier
        INNER JOIN
    payment ON courier.courierid = payment.courierID
WHERE
    payment.amount > 50;

-- ----------Task 3: GroupBy, Aggregate Functions, Having, Order By, where----

-- 14. Find the total number of couriers handled by each employee.
select count(orderid),o.employeeid,name
from orders o,employee e
where o.employeeid= e.employeeid
group by employeeid;

-- 15. Calculate the total revenue generated by each location
SELECT locationId, sum(amount) as 'Totol Revenue'
FROM payment 
group by LocationId;

-- 16. Find the total number of couriers delivered to each location.

select count(courierId) ,receiveraddress
from courier
group by Receiveraddress   ;

-- 17. Find the courier with the highest average delivery time:

select orderid ,round(avg(datediff(deliverydate,orderdate))) as 'Time'
from orders
group by orderid
order by time desc
limit 1;
-- 18. Find Locations with Total Payments Less Than a Certain Amount
select locationid,sum(amount) as Total
from payment 
group by locationId
having total<50;

-- 19. Calculate Total Payments per Location
select locationid,sum(amount) as total
from payment
group by locationId;

-- 20. Retrieve couriers who have received payments totaling more than $1000 in a specific location(LocationID = X):
select courierId,amount,locationid
from payment
where locationid =5001 
group by courierid
having sum(amount)>1000;

-- 21. Retrieve couriers who have received payments totaling more than $1000 after a certain date(PaymentDate > 'YYYY-MM-DD'):

select courierid,amount,locationid
from payment
where paymentdate>'2024-01-13'
group by courierid
having sum(amount)>1000;

-- 22. Retrieve locations where the total amount received is more than $5000 before a certain date(PaymentDate > 'YYYY-MM-DD')
Select location.*,sum(payment.amount) as total
 from location inner join payment
 on location.locationid= payment.locationId
 where paymentdate>'2024-01-13'
 group by locationID
 having total> 5000;
 
-- Task 4: Inner Join,Full Outer Join, Cross Join, Left Outer Join,Right Outer Join  
-- 23. Retrieve Payments with Courier Information  

select COURIER.*,PAYMENT.*
FROM COURIER INNER JOIN 
PAYMENT ON COURIER.COURIERID = PAYMENT.COURIERID;

-- 24. Retrieve Payments with Location Information  
SELECT 
    payment.*, location.*
FROM
    payment
        INNER JOIN
    location ON payment.locationId = location.locationId;
    
-- 25. Retrieve Payments with Courier and Location Information
Select Payment.*,courier.*,location.*
from payment join courier on payment.courierId=courier.courierId
Inner join location on payment.locationid=location.locationid;
  
-- 26. List all payments with courier details  
SELECT 
    PAYMENT.*, COURIER.*
FROM
    COURIER
        RIGHT JOIN
    PAYMENT ON COURIER.COURIERID = PAYMENT.COURIERID;

-- 27. Total payments received for each courier  
SELECT 
    courier.courierId, SUM(payment.amount) AS total
FROM
    courier
        JOIN
    payment ON courier.courierid = payment.courierid
GROUP BY courierid;

-- 28. List payments made on a specific date 
SELECT * 
FROM payment
Where PaymentDate= '2024-01-13';
-- 29. Get Courier Information for Each Payment  
SELECT courier.*,payment.paymentID
FROM courier join payment ON
courier.courierId = payment.courierId
group by paymentID;

-- 30. Get Payment Details with Location  
SELECT Payment.*,Location.*
FROM Payment inner join location 
ON payment.locationID= location.locationId;

-- 31. Calculating Total Payments for Each Courier  
SELECT Sum(Payment.amount),courier.courierID
from courier join payment on
courier.courierid = payment.courierId
group by courierId ;

-- 32. List Payments Within a Date Range  
SELECT * from payment 
where paymentdate between '2024-01-01'and'2024-01-14';

-- 33. Retrieve a list of all users and their corresponding courier records, including cases where there are  no matches on either side 
SELECT u.Userid, u.name,  courier.*
FROM user u
LEFT JOIN orders o ON u.userid = o.userid
LEFT JOIN courier ON o.orderid = courier.courierid;

-- 34. Retrieve a list of all couriers and their corresponding services, including cases where there are no  matches on either side  
SELECT 
    c.*, cs.*
FROM
    courier c
        LEFT JOIN
    orders o ON c.courierid = o.orderid
        LEFT JOIN
    courierservices cs ON o.serviceid = cs.serviceid;

-- 35. Retrieve a list of all couriers and their corresponding payments, including cases where there are  no matches on either side  
SELECT 
    c.*, p.*
FROM
    courier c
        LEFT JOIN
    payment p ON c.courierid = p.courierid;

-- 36. List all users and all courier services, showing all possible combinations. 
Select * from User
cross join courierServices;

-- 37. List all employees and all locations, showing all possible combinations:  
SELECT 
    *
FROM
    Employee
        CROSS JOIN
    location;
    
-- 38. Retrieve a list of couriers and their corresponding sender information (if available) 
SELECT 
    courier.*, user.*
FROM
    courier
        LEFT JOIN
    USER ON courier.senderName = user.Name;

-- 39. Retrieve a list of couriers and their corresponding receiver information (if available):  
SELECT 
    courier.*, user.*
FROM
    courier
        LEFT JOIN
    USER ON courier.ReceiverName = user.Name;
    
-- 40. Retrieve a list of couriers along with the courier service details (if available):  
SELECT 
    c.*, cs.*
FROM
    courier c
        INNER JOIN
    orders o ON c.courierid = o.orderid
        LEFT JOIN
    courierservices cs ON o.serviceid = cs.serviceid; 

-- 41. Retrieve a list of employees and the number of couriers assigned to each employee:  
SELECT 
    e.employeeid, e.name, COUNT(*)
FROM
    employee e
        INNER JOIN
    orders o ON e.employeeid = o.employeeid
GROUP BY e.employeeid;

-- 42. Retrieve a list of locations and the total payment amount received at each location:
  select l.*, sum(amount)
  from location l inner join payment p 
  on l.locationid= p.locationid
  group by l.locationid;
  
-- 43. Retrieve all couriers sent by the same sender (based on SenderName).  
select c.*
from courier c join courier d on 
c.sendername= d.sendername
where c.courierid <> d.courierid;

-- 44. List all employees who share the same role.  
SELECT 
    A.*
FROM
    Employee A
        JOIN
    Employee B ON A.role = B.role
WHERE
    a.employeeid <> B.Employeeid;

-- 45. Retrieve all payments made for couriers sent from the same location. 
SELECT 
    P.*, L.LocationId
FROM
    Payment P
        JOIN
    location L ON P.locationId = L.locationId;

 -- 46. Retrieve all couriers sent from the same location (based on SenderAddress). 
 SELECT 
    c.*
FROM
    courier c
        JOIN
    courier o ON c.senderAddress = o.senderaddress
WHERE
    c.courierid <> o.courierId;
 
-- 47. List employees and the number of couriers they have delivered:  
SELECT 
    e.name, COUNT(o.orderid)
FROM
    employee e
        INNER JOIN
    orders o ON e.employeeid = o.employeeid
WHERE
    o.status = 'delivered';
-- 48. Find couriers that were paid an amount greater than the cost of their respective courier services  
SELECT 
    c.*, totalamount, cost
FROM
    courier c
        INNER JOIN
    orders o ON c.courierid = o.orderid
        INNER JOIN
    courierservices cs ON o.serviceid = cs.serviceid
WHERE
    o.totalamount > cs.cost;

-- Scope: Inner Queries, Non Equi Joins, Equi joins,Exist,Any,All

-- 49. Find couriers that have a weight greater than the average weight of all couriers
SELECT *
FROM Courier 
Where weight>(SELECT avg(weight)from courier);
-- 50. Find the names of all employees who have a salary greater than the average salary:
SELECT 
    Name
FROM
    Employee
WHERE
    salary > (SELECT 
            AVG(Salary)
        FROM
            Employee);
            
-- 51. Find the total cost of all courier services where the cost is less than the maximum cost
SELECT 
    SUM(amount)
FROM
    payment
WHERE
    amount < (SELECT MAX(amount)FROM payment);

-- 52. Find all couriers that have been paid for
SELECT 
    *
FROM
    courier
WHERE
    courierid IN (SELECT 
            courierid
        FROM
            payment
        WHERE
            amount IS NOT NULL);
-- 53. Find the locations where the maximum payment amount was made
SELECT *
FROM location
WHERE locationid = (SELECT locationid
        FROM payment
        WHERE amount IN (SELECT MAX(amount) FROM  payment));
        
-- 54. Find all couriers whose weight is greater than the weight of all couriers sent by a specific sender (e.g., 'SenderName'):
SELECT  *
FROM courier
WHERE weight > ALL (SELECT weight
        FROM courier
        WHERE senderName = 'kane Danials');
