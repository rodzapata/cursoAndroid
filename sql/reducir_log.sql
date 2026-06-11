-- Cambiar a modo SIMPLE
ALTER DATABASE proveedor SET RECOVERY SIMPLE;
GO

-- Reducir el log
DBCC SHRINKFILE (proveedor, 1)
DBCC SHRINKFILE (proveedor_log, 1)

GO

-- (Opcional) Volver a modo FULL si quieres
ALTER DATABASE proveedor SET RECOVERY FULL;
GO

--verificamo cual es el nombre logico de los archivo no es el nombre fisico de la base de datos
SELECT
    name AS LogicalName,
    physical_name
FROM sys.database_files;