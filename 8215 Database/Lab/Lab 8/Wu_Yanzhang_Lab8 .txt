
-- Database Lab 8 - Section 323
-- Yanzhang Wu
-- 041056465


-- Use database
USE flightdb;

-- 1. Count how many rows are present in the airlines table.
SELECT COUNT(*) FROM airlines;

-- 2. Calculate the average elevation in the airports tables.
SELECT AVG(elevation) FROM airports;

-- 3. Calculate the maximum and minimum elevations in the airports table.
SELECT MAX(elevation),MIN(elevation) FROM airports;

-- 4. Calculate the average elevation, grouped by country id, in the airports table.
SELECT country_id, AVG(elevation) FROM airports GROUP BY country_id;

-- 5. Calculate the average elevation, grouped by country id, in the airports table ordered by country id.
SELECT country_id, AVG(elevation) FROM airports Group By country_id ORDER BY country_id;

-- 6. Calculate the average elevation, grouped by country id, in the airports table ordered by the average elevation in descending order.
SELECT country_id, AVG(elevation) FROM airports Group By country_id ORDER BY AVG(elevation) DESC;

-- 7. Calculate the average elevation, grouped by country id, in the airports table ordered by the average elevation in descending order for any country that has an average elevation of at least 300.
SELECT country_id, AVG(elevation) FROM airports Group By country_id HAVING AVG(elevation)>=300 ORDER BY AVG(elevation) DESC;

-- 8. Provide the query to determine how many aircrafts does “Boeing” have that starts with “74”.
SELECT COUNT(name = 'Boeing') FROM aircrafts WHERE description LIKE '74%';

-- 9. Provide the query to determine how many different wake sizes do “Boeing” and “Airbus” have?
SELECT name, COUNT(DISTINCT wake_size) FROM aircrafts WHERE name IN ('Boeing','Airbus')  GROUP BY name ;

-- 10. Provide the query to determine how many active airlines are present in Canada.  You  will need 2 queries.
/*
 * Alternatively, in one query
 * SELECT COUNT(active) FROM airlines WHERE country_id = (SELECT id FROM countries WHERE name = 'Canada') AND active = 'Y';
*/

SELECT id FROM countries WHERE name = 'Canada';
SELECT COUNT(active) FROM airlines WHERE country_id = 208 AND active = 'Y';