SELECT
    id,
    name,
    ST_X(coordinates) AS longitude,
    ST_Y(coordinates) AS latitude
FROM
    place
WHERE
    id = 8;

SELECT
    id,
    name,
    ST_X(coordinates) AS longitude,
    ST_Y(coordinates) AS latitude,
    ST_Distance_Sphere(coordinates, ST_GeomFromText('POINT(18.0686 59.3293)', 4326)) AS distance
FROM
    place
WHERE
    ST_Distance_Sphere(coordinates, ST_GeomFromText('POINT(18.0686 59.3293)', 4326)) <= 600;
