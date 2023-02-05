-- Database Lab 10 - Section 323
-- Yanzhang Wu
-- 041056465

USE flightdb;

ALTER TABLE `flightdb`.`countries` ENGINE = InnoDB ;

-- 1. Provide a query that will create a view for task 8 from Lab 9.
CREATE OR REPLACE VIEW country_airlines AS

    SELECT countries.name AS country_name,COUNT( DISTINCT airlines.id) AS distinct_count_of_airlines
    FROM airlines
    JOIN routes ON airlines.id = routes.airline_id
    JOIN airports ON airports.id = routes.destination_airport_id
    JOIN countries ON countries.id = airports.country_id
    WHERE countries.name IN ('France','Germany','Spain','Italy')
    GROUP BY countries.name;

-- 2. Provide a query that would create an index that would improve the performance of searches against the elevation field.

CREATE INDEX elevation_index ON airports (elevation);

-- 3. Provide a query that would create an index that would improve the performance of searches against both the source and destination airport field.
CREATE INDEX airport_index ON routes(source_airport_id,destination_airport_id);

-- 4. How many rows are in the countries table.  Provide the actual number
-- 240
SELECT COUNT(*) FROM countries;

-- 5. Open a second connection to your local MySQL server.
-- 6. Start a transaction in the first connection and insert a row in the countries table.
SET autocommit = 0;
START TRANSACTION; 
INSERT INTO countries VALUES (241,'TestCountry');

-- 7. In the first connection, how many rows are in the countries table now?
-- 241
SELECT COUNT(*) FROM countries;

-- 8. In the second connection, how many rows are reported in the countries table?
-- 240

-- 9. Commit the transaction in the first connection.
COMMIT;

-- 10. In the second connection, how many rows are reported in the countries table?
-- 241

-- 11. Again, start a transaction in the first connection.
START TRANSACTION; 

-- 12. Delete the row you just added.
DELETE FROM countries WHERE id = 241;

-- 13. In the first connection, how many rows are in the countries table now?
-- 240
SELECT COUNT(*) FROM countries;

-- 14. In the second connection, how many rows are reported in the countries table?
-- 241

-- 15. Commit the transaction in the first connection.
COMMIT;

-- 16. In the second connection, how many rows are reported in the countries table?
-- 240












