

-- Database Lab 6 - Section 323
-- Yanzhang Wu
-- 041056465


-- Create and use database
CREATE DATABASE IF NOT EXISTS lab6;
USE lab6;

-- Delete tables
DROP TABLE IF EXISTS order_lines;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS product_types;


-- Create customer table
CREATE TABLE IF NOT EXISTS customers(
  id INT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(150),
  phone_number VARCHAR(20),
  street_address VARCHAR(50),
  city VARCHAR(30),
  province CHAR(2),
  postal_code CHAR(6),
  CONSTRAINT customers_PK PRIMARY KEY (id)
);

-- Create orders table
CREATE TABLE IF NOT EXISTS orders(
  id INT,
  oder_date DATETIME,
  customer_id INT NOT NULL,
  CONSTRAINT orders_PK PRIMARY KEY (id),
  CONSTRAINT customer_id_FK FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Create product_types table
CREATE TABLE IF NOT EXISTS product_types(
  id INT,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT product_types_PK PRIMARY KEY (id)
);

-- Create products table
CREATE TABLE IF NOT EXISTS products(
  id Int,
  description VARCHAR(75) NOT NULL,
  price DECIMAL(6,2),
  product_type_id INT NOT NULL,
  CONSTRAINT products_PK PRIMARY KEY (id),
  CONSTRAINT product_type_id_FK FOREIGN KEY (product_type_id) REFERENCES product_types(id)
);

-- Create table order_lines
CREATE TABLE IF NOT EXISTS order_lines(
  order_id INT,
  product_id INT,
  quantity INT,
  price DECIMAL(6,2),
  line_total DECIMAL(8,2),
  CONSTRAINT order_lines_PK PRIMARY KEY (order_id,product_id),
  CONSTRAINT order_id_FK FOREIGN KEY (order_id) REFERENCES orders(id),
  CONSTRAINT product_id_FK FOREIGN KEY (product_id) REFERENCES products(id)
);




-- Insert 5 records into customers table
INSERT INTO customers(id, name, email, phone_number, street_address, city, province, postal_code)
VALUES (1,'Tom','tom@gmail.com','6131233210','123 ABC Street','Ottawa','ON','K4H9B4'),
       (2,'Mike','mike@gmail.com','613173210','263 CBC Street','Ottawa','ON','K5H3C2'),
       (3,'Peter','peter@gmail.com','6138569000','3623 CSD Street','Ottawa','ON','K1K4E3'),
       (4,'Lucy','lucy@gmail.com','8193869061','86 IYT Street','Montreal','QC','M2R5T1'),
       (5,'Mike','Tracy@gmail.com','6116748531','953 OPB Street','Toronto','ON','B4UK3L');

-- Insert product types into product_types
INSERT INTO product_types (id, name)
VALUES (1,'Software'),
       (2,'Hardware'),
       (3,'Service');

-- Insert 6 records into the products table
INSERT INTO products(id, description, price, product_type_id)
VALUES (1,'Windows',199.99,1),
       (2,'Visual Studio',89.99,1),
       (3,'Mouse',80.99,2),
       (4,'Keyboard',100.98,2),
       (5,'Software installation',5,3),
       (6,'Malware detection',5,3);

-- Update 2 customers
UPDATE customers
SET phone_number = '9975732638'
WHERE name = 'Tom';

UPDATE customers
SET postal_code = 'I3Y8BT'
WHERE name = 'Lucy';

-- Delete product type "Software"
-- Delete rows in the child table first
/*
 * Alternatively, I can drop the foreign key then delete the product
 * without deleting instances in child table. However, this will
 * result in meaningless product_type_id = '1' in products table.
 */
Delete FROM products WHERE product_type_id = '1';
DELETE FROM product_types WHERE name = 'Software';