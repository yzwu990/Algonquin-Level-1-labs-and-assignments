
/*
 * This is the forth file for assignment02
 * File name: Assignment02_4_Views
 *
 * Group members:
 *  Yanzhang Wu 041056465
 *  Yongjing Ge 041057942
 *  Boling Zhang 041058885
 *
 * Description:
 * The script in this file will create 2 views as defined in the instruction.
*/


-- Use database
USE Assignment02;


-- 1. A dynamic view for query 4 in the previous task
CREATE OR REPLACE VIEW apt_in_ON AS
    SELECT customer_first_name,customer_last_name
    FROM customer
    WHERE mailing_apt_number IS NOT NULL
    AND mailing_province = 'Ontario';


-- 2. A materialized view for query 9 in the previous task
-- Attention: In MySQL MATERIALIZED VIEW is not supported!
CREATE OR REPLACE MATERIALIZED VIEW key_clients AS
    SELECT `order`.customer_customer_id AS customer_id, CONCAT(customer.customer_first_name, ' ', customer.customer_last_name) AS customer_name, SUM(ordered_quantity) AS total_quantity
    FROM `order`
    JOIN order_has_product ON `order`.order_id = order_has_product.order_order_id
    JOIN customer ON `order`.customer_customer_id = customer.customer_id
    GROUP BY `order`.customer_customer_id
    HAVING total_quantity > 5;

-- Check if the views are created successfully
SHOW FULL TABLES;