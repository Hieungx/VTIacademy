USE classicmodels;

SELECT * FROM orders;
SELECT * FROM orderdetails;
SELECT * FROM products;
SELECT * FROM customers;

-- 1, Tính tổng giá trị của các order đã xuất kho (‘shipped’) trong tháng Tám năm 2004
SELECT COUNT(od.priceEach)
FROM orderdetails od
JOIN orders o ON od.orderNumber = o.orderNumber
WHERE o.shippedDate > '2004-08-01' AND o.shippedDate < '2004-08-31';

-- 2, Tính lợi nhuận (profit) thu được từ mỗi khách hàng dựa trên các orders mà họ thực hiện. Liệt kê theo tên khách hàng
SELECT c.CustomerName,COUNT(od.priceEach) Orders,SUM(od.priceEach) profit
FROM orderdetails od
JOIN orders o 		ON od.orderNumber = o.orderNumber
JOIN customers c 	ON o.customerNumber = c.CustomerNumber
GROUP BY o.CustomerNumber
ORDER BY c.CustomerName;

-- 3, Tính doanh thu (revenue) mà mỗi sản phẩm mang lại. Liệt kê theo tên sản phẩm.
SELECT p.Productcode,p.ProductName,SUM(od.PriceEach) Revenue
FROM orderDetails od
JOIN products p ON od.productCode = p.productCode
GROUP BY od.ProductCode;
