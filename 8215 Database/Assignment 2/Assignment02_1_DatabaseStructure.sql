
/*
 * This is the first file for assignment02
 * File name: Assignment02_1_DatabaseStructure
 *
 * Group members:
 *  Yanzhang Wu 041056465
 *  Yongjing Ge 041057942
 *  Boling Zhang 041058885
 *
 * Description:
 * The scripts in this file will create tables and constraints between tables.
*/


-- Create and use database

DROP DATABASE IF EXISTS Assignment02;

CREATE DATABASE IF NOT EXISTS Assignment02;

USE Assignment02;

/*
 * DDL Create tables
 */

-- Create customer table
CREATE TABLE IF NOT EXISTS customer (
    customer_id CHAR (10),
    customer_first_name VARCHAR(25) NOT NULL,
    customer_last_name VARCHAR(25) NOT NULL,
    credit_limit DECIMAL(7,2) UNSIGNED NOT NULL ,
    discount_amount DECIMAL(3,2) UNSIGNED NOT NULL,
    mailing_apt_number VARCHAR (10),
    mailing_street_number VARCHAR(10) NOT NULL,
    mailing_street_name VARCHAR(50) NOT NULL,
    mailing_city VARCHAR(50) NOT NULL,
    mailing_province VARCHAR(50) NOT NULL,
    mailing_zip_code CHAR(7) NOT NULL,
    CONSTRAINT customer_PK PRIMARY KEY (customer_id)
);

-- Create phone number table
CREATE TABLE IF NOT EXISTS phone_number(
    phone_number CHAR(10),
    customer_customer_id Char(10) NOT NULL,
    CONSTRAINT phone_number_PK PRIMARY KEY (phone_number,customer_customer_id),
    CONSTRAINT phone_number_FK FOREIGN KEY (customer_customer_id) REFERENCES customer(customer_id)
);

-- Create shipping address table
CREATE TABLE IF NOT EXISTS shipping_address (
    shipping_address_id INT AUTO_INCREMENT,
    customer_customer_id CHAR (10) NOT NULL,
    shipping_apt_number VARCHAR (10),
    shipping_street_number VARCHAR(10) NOT NULL,
    shipping_street_name VARCHAR(50) NOT NULL,
    shipping_city VARCHAR(50) NOT NULL,
    shipping_province VARCHAR(50) NOT NULL,
    shipping_zip_code CHAR(7) NOT NULL,
    CONSTRAINT shipping_address_PK PRIMARY KEY (shipping_address_id,customer_customer_id),
    CONSTRAINT shipping_address_FK FOREIGN KEY (customer_customer_id) REFERENCES customer(customer_id)
);

-- Create part table
CREATE TABLE IF NOT EXISTS part (
    part_number CHAR(7),
    part_description VARCHAR(50) NOT NULL,
    part_quantity INT UNSIGNED NOT NULL,
    CONSTRAINT part_PK PRIMARY KEY (part_number)
);

-- Create product table
CREATE TABLE IF NOT EXISTS product(
    product_code CHAR(5),
    product_description VARCHAR(50) NOT NULL,
    product_quantity INT UNSIGNED NOT NULL,
    unit_price DECIMAL(7,2) UNSIGNED NOT NULL,
    CONSTRAINT product_PK PRIMARY KEY (product_code)
);

-- Create product_has_part
CREATE TABLE IF NOT EXISTS product_has_part(
    product_product_code CHAR(5),
    part_part_number CHAR(7),
    required_quantity INT UNSIGNED NOT NULL,
    CONSTRAINT product_has_part_PK PRIMARY KEY (product_product_code,part_part_number),
    CONSTRAINT product_part_product_FK FOREIGN KEY (product_product_code) REFERENCES product(product_code),
    CONSTRAINT product_part_part_FK FOREIGN KEY (part_part_number)REFERENCES part(part_number)
);

-- Create order table
CREATE TABLE IF NOT EXISTS `order` (
    order_id INT AUTO_INCREMENT,
    customer_customer_id CHAR(10) NOT NULL,
    order_date DATE,
    CONSTRAINT order_PK PRIMARY KEY (order_id),
    CONSTRAINT order_customer_FK FOREIGN KEY (customer_customer_id) REFERENCES customer(customer_id)
);

-- Create order_has_product
CREATE TABLE IF NOT EXISTS order_has_product(
    order_order_id INT,
    product_product_code CHAR(5),
    ordered_quantity INT UNSIGNED NOT NULL,
    CONSTRAINT order_has_product_PK PRIMARY KEY (order_order_id,product_product_code),
    CONSTRAINT order_product_order_FK FOREIGN KEY (order_order_id) REFERENCES `order`(order_id),
    CONSTRAINT order_product_product_FK FOREIGN KEY (product_product_code) REFERENCES product(product_code)
)

