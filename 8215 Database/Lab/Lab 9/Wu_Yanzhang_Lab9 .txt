-- Database Lab 9 - Section 323
-- Yanzhang Wu
-- 041056465



USE flightdb;

-- 1. Provide a query that display the airport name, city and country name for all airports.
SELECT airports.name, airports.city, countries.name FROM airports
JOIN countries ON airports.country_id = countries.id;


-- 2. Provide a query that lists all routes that have a source airport of “Lester B Pearson Intl.  Display the name of the airport, the airline id and codeshare.
SELECT airports.name AS airport_name,routes.airline_id,routes.codeshare
FROM routes
JOIN airports ON routes.source_airport_id = airports.id
WHERE airports.name ='Lester B Pearson Intl';


-- 3. Provide a query that lists all routes that have a source airport of “Lester B Pearson Intl.  Display only the distinct names of the airport and airlines.
SELECT DISTINCT airports.name AS airport_name, airlines.name AS airline_name
FROM airports
JOIN routes ON routes.source_airport_id = airports.id
JOIN airlines ON routes.airline_id = airlines.id
WHERE airports.name ='Lester B Pearson Intl';


-- 4. Provide a query that lists all aircrafts for each airline that operates a route with a source airport of “Lester B Pearson Intl.  Display only the distinct names for the airport, airlines and aircraft description.
SELECT DISTINCT airports.name AS airport_name,airlines.name AS airline_name,aircrafts.description AS `aircraft description`
FROM airports
JOIN routes ON airports.id = routes.source_airport_id
JOIN route_aircrafts ON routes.id = route_aircrafts.route_id
JOIN aircrafts ON aircrafts.id = route_aircrafts.aircraft_id
JOIN airlines ON airlines.id = routes.airline_id
WHERE airports.name = 'Lester B Pearson Intl';


-- 5. Provide a query that display the name of the airline and what country they are based in.
SELECT airlines.name, countries.name
FROM airlines
JOIN countries ON countries.id = airlines.country_id;


-- 6. Provide a query that counts how many airlines are based in which countries.  You must display the name of the country and the airline.

SELECT countries.name AS country_name, COUNT(airlines.name) AS number_of_airlines,
GROUP_CONCAT(airlines.name) AS ailine_names
FROM airlines
JOIN countries ON countries.id = airlines.country_id
GROUP BY countries.name;


-- 7. Provide a query that display the how many different aircraft operate routes that end at airports (destination) in the country of France. You must display the distinct count of aircrafts.

SELECT countries.name AS country_name,COUNT( DISTINCT aircrafts.id) AS distinct_count_of_aircrafts
FROM aircrafts
JOIN route_aircrafts ra ON aircrafts.id = ra.aircraft_id
JOIN routes ON ra.route_id = routes.id
JOIN airports ON airports.id = routes.destination_airport_id
JOIN countries ON countries.id = airports.country_id
WHERE countries.name = 'France';


-- 8. Provide a query that display the how many different airlines that operate routes that end at airports (destination) in the countries of France, Germany, Spain and Italy. You must display the distinct count of airlines and the name of the country .
SELECT countries.name AS country_name,COUNT( DISTINCT airlines.id) AS distinct_count_of_airlines
FROM airlines
JOIN routes ON airlines.id = routes.airline_id
JOIN airports ON airports.id = routes.destination_airport_id
JOIN countries ON countries.id = airports.country_id
WHERE countries.name IN ('France','Germany','Spain','Italy')
GROUP BY countries.name;


-- 9. Provide a query that display the name of the airline, aircraft and country for airlines that operate on routes that end at airports (destination) in the countries of France, Germany, Spain and Italy.
SELECT airlines_in_four_countries.destination_country,airlines_in_four_countries.airline_name,airlines_in_four_countries.aircraft_name,countries.name AS airline_country
FROM (
SELECT airlines.name AS airline_name, airlines.country_id, countries.name AS destination_country,routes.id AS route_id,aircrafts.name AS aircraft_name
FROM airlines
JOIN routes on airlines.id = routes.airline_id
JOIN airports on routes.destination_airport_id = airports.id
JOIN countries on countries.id = airports.country_id
JOIN route_aircrafts ON routes.id = route_aircrafts.route_id
JOIN aircrafts ON aircrafts.id = route_aircrafts.aircraft_id
WHERE countries.name IN ('France','Germany','Spain','Italy')) AS airlines_in_four_countries
JOIN countries ON airlines_in_four_countries.country_id = countries.id
ORDER BY airline_country;


-- 10. Provide a query that display the count of each “wake size” for aircrafts operated by airlines that operate routes that start at airports (destination) in the countries Canada, United States and Mexico.
SELECT countries.name AS source_airport, aircrafts.name AS aircraft_name,
       airlines.name AS airline_name,count(aircrafts.wake_size) AS number_of_wake_size
FROM routes
JOIN airports ON routes.source_airport_id = airports.id
JOIN countries ON airports.country_id = countries.id
JOIN route_aircrafts ON routes.id = route_aircrafts.route_id
JOIN aircrafts ON route_aircrafts.aircraft_id = aircrafts.id
JOIN airlines ON routes.airline_id = airlines.id
WHERE countries.name IN ('Canada','United States','Mexico')
GROUP BY airlines.name;


-- 11. Redo #8 using a subquery in the WHERE clause.

SELECT countries.name AS country_name,COUNT( DISTINCT airlines.name) AS distinct_count_of_airlines
FROM aircrafts
JOIN route_aircrafts ra ON aircrafts.id = ra.aircraft_id
JOIN routes ON ra.route_id = routes.id
JOIN airports ON airports.id = routes.destination_airport_id
JOIN countries ON countries.id = airports.country_id
JOIN airlines ON airlines.id = routes.airline_id
WHERE airports.country_id
IN (
    SELECT countries.id FROM countries
                      WHERE countries.name IN ('France','Germany','Spain','Italy')
          )
GROUP BY countries.name;


-- 12. Redo #7 using a subquery in the FROM clause (Derived or Virtual Table).
SELECT filtered_airline.country_name, COUNT(DISTINCT filtered_airline.aircraft_id) AS distinct_count_of_aircrafts
FROM
    ( SELECT aircrafts.id AS aircraft_id, countries.name AS country_name
      FROM aircrafts
      JOIN route_aircrafts ra ON aircrafts.id = ra.aircraft_id
      JOIN routes ON ra.route_id = routes.id
      JOIN airports ON airports.id = routes.destination_airport_id
      JOIN countries ON countries.id = airports.country_id
      WHERE countries.name = 'France') AS filtered_airline;



