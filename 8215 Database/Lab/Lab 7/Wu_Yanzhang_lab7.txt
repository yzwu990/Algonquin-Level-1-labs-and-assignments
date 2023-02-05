
-- Database Lab 7 - Section 323
-- Yanzhang Wu
-- 041056465

-- Select database
USE flightdb;


-- Question 1
-- Select all columns from the aircrafts table.
SELECT * FROM table;

-- Question 2
-- Select the name and description from the aircrafts table.
SELECT name,description FROM aircrafts;

-- Question 3
-- Select the distinct “name” from the aircrafts table.
SELECT DISTINCT name FROM aircrafts;

-- Question 4
-- Select name and city from the airports table.  Alias the name to “Airport name”
SELECT name AS 'Airport name',city FROM airports;

-- Question 5
-- Select name, city and elevation for all airports that have a country id of 24.
SELECT name,city FROM airports WHERE country_id = 24;

-- Question 6
-- Select the country from the country table that has an id of 24.
SELECT name FROM countries WHERE id = 24;

-- Question 7
-- Select airports that have an elevation between 400 and 500.  You must make sure to include 400 and 500.
SELECT name FROM airports WHERE 400 <= elevation <= 500;

-- Question 8
-- Select all airlines who has a name that start with “Air”.
SELECT name FROM airlines WHERE name LIKE 'Air%';

-- Question 9
-- Select all airlines that have a name that contains “International”.
SELECT name FROM airlines WHERE name LIKE '%International%';

-- Question 10
-- Select all airlines that have a name that ends in “Aviation”.
SELECT name FROM airlines WHERE name LIKE '%Aviation';

-- Question 11
-- Select all airports in Canada that have an elevation of 0.  You will need 2 queries to accomplish this.
/*
 * Firstly, find the country id of 'Canada' from table countries
 * Secondly, use this country id to select the airports that have an elevation of 0
 * Alternatively, I can write the same strategy in one query:
 * SELECT name FROM airports WHERE country_id = (SELECT id FROM countries WHERE name = 'Canada') AND elevation = 0;
*/

SELECT id FROM countries WHERE name = 'Canada';
SELECT name FROM airports WHERE country_id = 208 AND elevation = 0;


-- Question 12
-- Select all airlines in France that have an active status of “Y”.
/*
 * Alternatively,
 * SELECT name FROM airlines WHERE country_id = (SELECT id FROM countries WHERE name = 'France') AND active = 'Y';
*/

SELECT id FROM countries WHERE name = 'France';
SELECT name FROM airlines WHERE country_id = 130 AND active = 'Y';
