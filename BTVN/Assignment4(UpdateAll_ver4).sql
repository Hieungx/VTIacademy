USE classicmodels;

SELECT * FROM orders;
SELECT * FROM orderdetails
WHERE orderNumber = 10136;
SELECT buyPrice FROM products
WHERE ProductCode IN('S18_1129','S18_1984','S18_3232');
SELECT * FROM customers;


-- 1, Tính tổng giá trị của các order đã xuất kho (‘shipped’) trong tháng Tám năm 2004
SELECT SUM(priceEach*quantityOrdered) Total_value
FROM orderdetails od
JOIN orders o ON od.orderNumber = o.orderNumber
WHERE o.`status`='Shipped' AND o.shippedDate BETWEEN '2004-08-01' AND '2004-08-31';
-- WHERE (o.shippedDate >= '2004-08-01' AND o.shippedDate <= '2004-08-31') AND o.`status` = 'shipped';

-- 2, Tính lợi nhuận (profit) thu được từ mỗi khách hàng dựa trên các orders mà họ thực hiện. Liệt kê theo tên khách hàng
SELECT o.orderNumber,c.CustomerName,SUM(od.quantityOrdered),SUM(od.quantityOrdered*(od.priceEach -p.buyPrice)) profit
FROM orderdetails od
JOIN orders o 		ON od.orderNumber = o.orderNumber
JOIN products p 	ON od.productCode = p.productCode
JOIN customers c 	ON o.customerNumber = c.CustomerNumber
GROUP BY c.CustomerName
ORDER BY c.CustomerName;

-- JOIN các bảng của bài 2
SELECT  o.orderNumber,c.CustomerName, od.quantityOrdered,od.priceEach,p.buyPrice
FROM orderdetails od
JOIN orders o 		ON od.orderNumber = o.orderNumber
JOIN products p 	ON od.productCode = p.productCode
JOIN customers c 	ON o.customerNumber = c.CustomerNumber
ORDER BY c.CustomerName;


-- 3, Tính doanh thu (revenue) mà mỗi sản phẩm mang lại. Liệt kê theo tên sản phẩm.
SELECT p.Productcode,p.ProductName,SUM(od.QuantityOrdered*(od.PriceEach-p.buyPrice)) Revenue
FROM orderDetails od
JOIN products p ON od.productCode = p.productCode
GROUP BY od.ProductCode;

-- JOIN các bảng của bài 3
SELECT p.Productcode,od.QuantityOrdered,od.PriceEach,p.buyPrice
FROM orderDetails od
JOIN products p ON od.productCode = p.productCode;
