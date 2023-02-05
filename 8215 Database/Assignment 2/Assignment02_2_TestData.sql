
/*
 * This is the second file for assignment02
 * File name: Assignment02_2_TestData
 *
 * Group members:
 *  Yanzhang Wu 041056465
 *  Yongjing Ge 041057942
 *  Boling Zhang 041058885
 *
 * Description:
 * This script in this file will populate each table.
*/


-- Use database
USE Assignment02;


-- Populate customer table
INSERT INTO customer(customer_id, customer_first_name, customer_last_name, credit_limit, discount_amount, mailing_apt_number, mailing_street_number, mailing_street_name, mailing_city, mailing_province, mailing_zip_code)
VALUES
    ('1', 'Jolie', 'Pratt', 5661, 0.2,NULL, '3927', 'Ac Rd.', 'Richmond', 'Northwest Territories', 'H3S 5C4'),
    ('2', 'Mohammad', 'Puckett', 4598, 0.2, NULL, '3802', 'Mollis Road', 'Canora', 'Saskatchewan', 'Q6P 8Y1'),
    ('3', 'Judith', 'Russo', 6669, 0.2, NULL, '6777', 'Hendrerit Av.', 'Glovertown', 'Ontario', 'U7T 5C0'),
    ('4', 'Suki', 'Crosby', 2024, 0.1, '505', '3352', 'Risus. Road', 'Brandon', 'Prince Edward Island', 'B1H 3B5'),
    ('5', 'Seth', 'Patterson', 1460, 0, '836', '610', 'Neque. Av.', 'Assiniboia', 'Newfoundland and Labrador', 'B9B 3X0'),
    ('6', 'Adrian', 'Norton', 1482, 0, '278', '5162', 'Mollis Rd.', 'Maple Creek', 'Ontario', 'T8B 9B3'),
    ('7', 'Dylan', 'Compton', 9745, 0.3, '474', '3312', 'Habitant Rd.', 'Whitehorse', 'Quebec', 'G1E 2N2'),
    ('8', 'Holly', 'Blackwell', 6333, 0.2, NULL, '2364', 'Donec Road', 'Aylmer', 'Nova Scotia', 'B8C 8X5'),
    ('9', 'Sharon', 'Wilder', 7451, 0.2, '716', '2141', 'Dignissim Avenue', 'Fort Providence', 'Ontario', 'T2T 3X3'),
    ('10', 'Ingrid', 'Norris', 1842, 0, '174', '828', 'Sed St.', 'Guysborough', 'New Brunswick', '15J 7E1');


-- Populate phone_number table
INSERT INTO phone_number (phone_number,customer_customer_id)
VALUES
    ('8675553525', '1'),
    ('3065554531', '2'),
    ('4165557328', '3'),
    ('9025555155', '4'),
    ('7095556295', '5'),
    ('4168543987', '6'),
    ('4186985103', '7'),
    ('9026871536', '8'),
    ('8199247018', '9'),
    ('5067917463', '10');


-- Populate shipping_address table
INSERT INTO shipping_address (customer_customer_id,shipping_apt_number,shipping_street_number,shipping_street_name,shipping_city,shipping_province,shipping_zip_code)
VALUES
    ('1', NULL , '3927', 'Ac Rd.', 'Richmond', 'Northwest Territories', 'H3S 5C4'),
    ('1', '330', '331', 'Main St.', 'Kindersley', 'Saskatchewan', 'S0L 1S0'),
    ('2', NULL, '3802', 'Mollis Road', 'Canora', 'Saskatchewan', 'Q6P 8Y1'),
    ('3', NULL, '6777', 'Hendrerit Av.', 'Glovertown', 'Ontario', 'U7T 5C0'),
    ('4', '505', '3352', 'Risus. Road', 'Brandon', 'Prince Edward Island', 'B1H 3B5'),
    ('5', '836', '610', 'Neque. Av.', 'Assiniboia', 'Newfoundland and Labrador', 'B9B 3X0'),
    ('6', '278', '5162', 'Mollis Rd.', 'Maple Creek', 'Ontario', 'T8B 9B3'),
    ('6', NULL, '336', '5th Avenue', 'Brownvale', 'Alberta', 'T0G 0L0'),
    ('6', NULL, '417', 'Eglinton Avenue', 'Toronto', 'Ontario', 'M4P 1A6'),
    ('7', '474', '3312', 'Habitant Rd.', 'Whitehorse', 'Quebec', 'G1E 2N2'),
    ('7', NULL, '832', 'Nelson St.', 'Cat Lake', 'Ontario', 'P0V 1J0'),
    ('7', '1101', '1226', 'Jade St.', 'West Vancouver', 'British Columbia', 'V7T 2W4'),
    ('9', '716', '2141', 'Dignissim Avenue', 'Fort Providence', 'Ontario', 'T2T 3X3'),
    ('10', '174', '828', 'Sed St.', 'Guysborough', 'New Brunswick', '15J 7E1');


-- Populate part table
INSERT INTO part (part_number,part_description,part_quantity)
VALUES
    ('WOOD223', '1 X 2 - 30" WOOD', 50),
    ('WOOD475', '1 X 2 - 40" WOOD', 80),
    ('WOOD422', '1 X 1 - 10" WOOD', 61),
    ('WOOD589', '2 X 2 - 20" WOOD', 49),
    ('WOOD995', '2 X 4 - 48" WOOD', 35),
    ('SCRW110', '1.25" SCREWS', 57),
    ('SCRW111', '1.5" SCREWS', 86),
    ('SCRW112', '1.75" SCREWS', 178),
    ('SCRW113', '2" SCREWS', 767),
    ('NAIL114', '1.25" NAILS', 90),
    ('NAIL115', '1.5" NAILS', 724),
    ('NAIL116', '1.75" NAILS', 784),
    ('COBR660', '1.5" CORNER BRACE', 704),
    ('COBR770', '2" CORNER BRACE', 299),
    ('COBR880', '3" CORNER BRACE', 937);


-- Populate product table
INSERT INTO product (product_code,product_description,product_quantity,unit_price)
VALUES
    ('CH089', 'PATIO CHAIRS', 5, 39.99),
    ('CH122', 'PATIO CHAIRS', 0, 33.98),
    ('CH237', 'PATIO CHAIRS', 59, 98.98),
    ('CH334', 'PATIO CHAIRS', 288, 19.99),
    ('TB101', 'PATIO TABLE', 14, 177.99),
    ('TB202', 'PATIO TABLE', 18, 299.98),
    ('TB203', 'PATIO TABLE', 0, 299.98),
    ('TB204', 'PATIO TABLE', 0, 299.98),
    ('FR223', 'HALF SIZE REFRIGERATOR', 10, 750.99),
    ('FR224', 'HALF SIZE REFRIGERATOR', 8, 750.99),
    ('MW001', 'MICROWAVE', 56, 49.99),
    ('MW237', 'MICROWAVE', 0, 129.99),
    ('MW331', 'MICROWAVE', 21, 199.99);


-- Populate product_has_part table
INSERT INTO product_has_part (product_product_code,part_part_number,required_quantity)
VALUES
    ('CH089', 'WOOD223', 8),
    ('CH089', 'SCRW110', 26),
    ('CH089', 'COBR660', 4),
    ('CH122', 'WOOD475', 8),
    ('CH122', 'SCRW111', 8),
    ('CH122', 'COBR770', 4),
    ('TB204', 'WOOD995', 1),
    ('TB204', 'WOOD422', 2),
    ('TB204', 'SCRW113', 8),
    ('TB204', 'COBR880', 4),
    ('TB203', 'WOOD995', 1),
    ('TB203', 'WOOD589', 1),
    ('TB203', 'SCRW112', 8),
    ('TB203', 'COBR770', 4);


-- Populate order table
INSERT INTO `order` (customer_customer_id,order_date)
VALUES
    ('1', '2021-09-12'),
    ('2', '2021-11-15'),
    ('2', '2022-01-06'),
    ('4', '2022-03-05'),
    ('7', '2022-03-18'),
    ('8', '2022-04-11'),
    ('3', '2022-04-25'),
    ('5', '2022-05-05'),
    ('8', '2022-05-22'),
    ('9', '2022-06-06');


-- Populate order_has_product table
INSERT INTO order_has_product (order_order_id,product_product_code,ordered_quantity)
VALUES
    (1,'CH089', 1),
    (2,'CH089', 1),
    (2,'CH237', 1),
    (3,'TB101', 1),
    (3,'CH334', 4),
    (4,'FR223', 1),
    (5,'MW001', 1),
    (6,'TB203', 1),
    (6,'TB202', 1),
    (6,'CH089', 4),
    (6,'CH122', 4),
    (7,'FR224', 1),
    (7,'MW237', 1),
    (8,'TB204', 2),
    (9,'CH334', 4),
    (10,'FR224', 1),
    (10,'MW001', 1),
    (10,'TB101', 1),
    (10,'CH334', 4);