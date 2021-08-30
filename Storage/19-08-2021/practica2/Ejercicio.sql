USE MOVIES_DB;

--Ejercicio 1

--La normalizacion de utiliza para eliminar la redundancia de datos, y reducir el tiempo en las consultas


--Ejercicio 2

INSERT INTO MOVIES (CREATED_AT, UPDATED_AT, TITLE, RATING, AWARDS, RELEASE_DATE, LENGTH, GENRE_ID)
VALUES (NULL, NULL, "Volver al futuro", 10.0, 4, NOW(), 180, 8);


--Ejercicio 3

INSERT INTO GENRES (CREATED_AT, UPDATED_AT, NAME, RANKING, ACTIVE)
VALUES (NOW(), NULL, "Suspenso Insostenible", 13, 1);


--Ejercicio 4

UPDATE MOVIES SET GENRE_ID = (SELECT ID FROM GENRES WHERE NAME = "Suspenso Insostenible")
WHERE TITLE = "Volver al futuro";


--Ejercicio 5

UPDATE ACTORS SET FAVORITE_MOVIE_ID = (SELECT ID FROM MOVIES WHERE TITLE = "Volver al futuro")
WHERE FIRST_NAME = 'JON';


--Ejercicio 6

CREATE TEMPORARY TABLE TEMP_MOVIES
SELECT * FROM MOVIES;


--Ejercicio 7

DELETE FROM TEMP_MOVIES WHERE AWARDS < 5;


--Ejercicio 8

SELECT DISTINCT G.* 
FROM GENRES G
INNER JOIN MOVIES M ON G.ID = M.GENRE_ID;


--Ejercicio 9

SELECT A.*
FROM ACTORS A
INNER JOIN MOVIES M ON A.FAVORITE_MOVIE_ID = M.ID
WHERE M.AWARDS >3;


--Ejercicio 10

EXPLAIN SELECT * FROM TEMP_MOVIES;


--Ejercicio 11

EXPLAIN DELETE FROM TEMP_MOVIES WHERE AWARDS < 5;


--Ejercicio 12

-- Son un mecanismo que se usa para optimizas las consultas y mejorar los tiempos de respuesta
-- No se debe usar en consultas muy grandes, se usa mas para consultas pequeñas


--Ejercicio 13

CREATE INDEX MOVIES_INDEX ON MOVIES(ID);


--Ejercicio 14

SHOW INDEX FROM MOVIES;