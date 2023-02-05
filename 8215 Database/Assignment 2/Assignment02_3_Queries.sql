
/*
 * This is the third file for assignment02
 * File name: Assignment02_3_Queries
 *
 * Group members:
 *  Yanzhang Wu 041056465
 *  Yongjing Ge 041057942
 *  Boling Zhang 041058885
 *
 * Description:
 * The script in this file will finish 11 tasks as defined in the instruction.
*/



-- Use database
USE Assignment02;



-- 1. A simple query that pulls all columns and rows from a table
-- Show all from customer table
SELECT * FROM customer;

-- 2. A query that displays a subset of columns
-- Show customers' full names and cities of mailing address
SELECT CONCAT(customer_first_name,' ', customer_last_name) AS full_name, mailing_city
FROM customer;

-- 3. A query that displays a subset of columns with a single clause (predicate) WHERE statement
-- Show out of stock products (quantity = 0)
SELECT product_code,product_description,product_quantity
FROM product
WHERE product_quantity = 0;

-- 4. A query that displays a subset of columns with a multi-clause (predicate) WHERE statement using AND/OR
-- Show customers whose mailing address is an apartment (have apartment number) in Ontario
SELECT CONCAT(customer_first_name,' ',customer_last_name) AS customer_name
FROM customer
WHERE mailing_apt_number IS NOT NULL
AND mailing_province = 'Ontario';


-- 5. A query that performs a single table join. In other words, you are joining 2 tables.
-- Show customers' ID, name and phone number

SELECT customer.customer_id,CONCAT(customer.customer_first_name,' ',customer.customer_last_name) AS full_name,phone_number.phone_number
FROM customer
INNER JOIN phone_number
ON customer.customer_id = phone_number.customer_customer_id
ORDER BY customer.customer_last_name, customer.customer_first_name;


-- 6. A query that performs a multi-table join. In other words, you are joining 3 or more tables.
-- For customers who placed orders, show their ID, name, phone number and oder ID

SELECT customer.customer_id, CONCAT(customer.customer_first_name,' ', customer.customer_last_name) AS full_name ,phone_number.phone_number,GROUP_CONCAT(`order`.order_id) AS orders
FROM customer
INNER JOIN phone_number ON customer.customer_id = phone_number.customer_customer_id
INNER JOIN `order` ON phone_number.customer_customer_id = `order`.customer_customer_id
GROUP BY customer.customer_id
ORDER BY customer.customer_id;


-- 7. A query that performs an aggregate (count, min, max, sum, avg, etc.).
-- Show average credit limit of all customers
SELECT ROUND(AVG(credit_limit),2) AS average_credit FROM customer;


-- 8. A query that performs an aggregate (count, min, max, sum, avg, etc.) with a GROUP BY.
-- If a customer has shipping addresses,show customer name, customer id and how many shipping addresses does each customer has
SELECT CONCAT(customer.customer_first_name, ' ', customer.customer_last_name) AS customer_name, shipping_address.customer_customer_id AS customer_id, COUNT(shipping_address_id) AS numbers_of_shipping_address
FROM shipping_address
INNER JOIN customer
ON shipping_address.customer_customer_id = customer.customer_id
GROUP BY customer_customer_id;


-- 9. A query that performs an aggregate (count, min, max, sum, avg, etc.). with a GROUP BY and a HAVING clause
-- If a customer ordered more than 5 products in one order, show customer's id, name, and the quantity of their ordered products
-- This query also uses join like task 11

SELECT `order`.customer_customer_id AS customer_id, CONCAT(customer.customer_first_name, ' ', customer.customer_last_name) AS customer_name, SUM(ordered_quantity) AS total_quantity
FROM `order`
INNER JOIN order_has_product ON `order`.order_id = order_has_product.order_order_id
INNER JOIN customer ON `order`.customer_customer_id = customer.customer_id
GROUP BY `order`.customer_customer_id
HAVING total_quantity > 5;


-- 10. A query that performs a subquery either as part of the WHERE clause or as a derived/virtual table.
-- Show the phone number, id, and name of the customer who ordered a table

SELECT CONCAT(customer.customer_first_name, ' ', customer.customer_last_name) AS customer_name, phone_number,customer_customer_id
FROM phone_number
INNER JOIN customer
ON phone_number.customer_customer_id = customer.customer_id
WHERE customer_customer_id
IN(
    SELECT customer_customer_id
    FROM `order`
    WHERE order_id
    IN (
        SELECT order_order_id
        FROM order_has_product
        WHERE product_product_code
        LIKE 'TB%'));


-- 11. A query that performs an aggregate with a join and a group by.
-- Show order id, customer id, customer name and total amount for the order with total amount >=500 before discount
SELECT `order`.order_id, `order`.customer_customer_id AS customer_id, CONCAT(customer.customer_first_name, ' ', customer.customer_last_name) AS customer_name, SUM(product.unit_price * order_has_product.ordered_quantity) AS total_amount_before_discount
FROM `order`
INNER JOIN order_has_product ON `order`.order_id = order_has_product.order_order_id
INNER JOIN product ON product.product_code = order_has_product.product_product_code
INNER JOIN customer ON `order`.customer_customer_id = customer.customer_id
GROUP BY `order`.order_id
HAVING total_amount_before_discount >=500;


