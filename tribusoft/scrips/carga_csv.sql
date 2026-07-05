select * from municipio;

delete from departamento;

COPY departamento(
    codigo,
    nombre
)
FROM 'C:\tribusoft\excel\dptos.csv'
DELIMITER ';'
CSV HEADER;

COPY municipio(
    codigo,
    nombre,
	codigo_departamento
)
FROM 'C:\tribusoft\excel\municipios.csv'
DELIMITER ';'
CSV HEADER;