SELECT
    id,
    name,
    ST_X(coordinates) AS longitude,
    ST_Y(coordinates) AS latitude
FROM
    place
WHERE
    id = 8;