-- 1, Tính tổng giá trị của các order đã xuất kho (‘shipped’) trong tháng Tám năm 2004
SELECT SUM(priceEach*quantityOrdered)
FROM orderdetails od
JOIN orders o ON od.orderNumber = o.orderNumber
WHERE o.`status`='Shipped' AND o.shippedDate BETWEEN '2004-08-01' AND '2004-08-31';
-- WHERE o.shippedDate > '2004-08-01' AND o.shippedDate < '2004-08-31' AND o.`status` = 'shipped';