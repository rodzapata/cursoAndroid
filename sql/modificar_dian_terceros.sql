--pagina para consultar empresa
--https://www.datacreditoempresas.com.co/directorio/comercializadora-condimentos-cotty-limitada.html

--select nit, count(nit) as cant from dian_terceros group by nit having count(nit)>1

select * from dian_terceros where nit='1020485835'
select * from dian_terceros where nit='901927181'

update dian_terceros set nombre2='' where nombre2 is null

delete from dian_terceros where id=14966

INSERT INTO dian_terceros
	(nit, a.nit_dian, apellido1, apellido2, nombre1,nombre2, tipo_doc, 
	razon, nomb_terce, direccion,
    codDpto, codMunicipio, unirMunicipio)
SELECT  RTRIM(LTRIM(a.nit)), RTRIM(LTRIM(a.nit)) as nit_dian, a.apellido1, a.apellido2, a.nombre1, a.nombre2, a.tipo_doc, 
	case when a.tipo_doc='31' then a.razon else '' end as razon, case when a.tipo_doc='31' then  rtrim(ltrim(a.nombre1))+rtrim(ltrim(a.nombre2))+rtrim(ltrim(a.apellido1))+rtrim(ltrim(a.apellido2)) else '' end as nomb_terce, 
	a.direccion,
    a.codDpto, a.codMunicipio,  rtrim(ltrim(a.codDpto))+rtrim(ltrim(a.codMunicipio))
	FROM dian_terceros2 a
	WHERE NOT EXISTS (
		SELECT 1
		FROM dian_terceros d
		WHERE LTRIM(RTRIM(d.nit)) = LTRIM(RTRIM(a.nit))
	)

---F1001
select '5007' as concepto, rtrim(ltrim(nit)) as nit_bus, tipo_doc, rtrim(ltrim(nit)) as nit,apellido1, apellido2, nombre1, nombre2,
	razon,  direccion, codDpto, codMunicipio, id  
	from dian_terceros 
	order by tipo_doc, apellido1

select nit, apellido1, apellido2, nombre1, nombre2, tipo_doc, razon,    direccion, codDpto, codMunicipio  from dian_terceros2

select nit, tipo_doc, razon,  apellido1, apellido2, nombre1, nombre2,  direccion, codDpto, codMunicipio  from dian_terceros2

select nit, tipo_doc, razon,  apellido1, apellido2, nombre1, nombre2,  direccion, codDpto, codMunicipio  from dian_terceros2

select nit, tipo_doc, razon,  direccion, codDpto, codMunicipio  from dian_terceros2

select nit, direccion, codDpto, codMunicipio, tipo_doc, razon,  apellido1, apellido2, nombre1, nombre2    from dian_terceros2

select * from dian_terceros2
select rtrim(ltrim(nit)) as nit, direccion, codDpto, codMunicipio, tipo_doc, razon, apellido1, apellido2, nombre1, nombre2,  from dian_terceros2
where len(direccion)=0

delete from dian_terceros2


select * from dian_terceros2 a left join dian_terceros2 b on a.nit=b.nit

update dian_terceros set nit=rtrim(ltrim(nit))
update dian_terceros set nit_dian=rtrim(ltrim(nit_dian))
update dian_terceros set nombre1=rtrim(ltrim(nombre1))
update dian_terceros set nombre2=rtrim(ltrim(nombre2))
update dian_terceros set apellido1=rtrim(ltrim(apellido1))
update dian_terceros set apellido2=rtrim(ltrim(apellido2))
update dian_terceros set razon=rtrim(ltrim(razon))
update dian_terceros set direccion=rtrim(ltrim(direccion))

update dian_terceros set nomb_terce=rtrim(ltrim(razon))
where tipo_doc in ('31','43')

update dian_terceros set nomb_terce=rtrim(ltrim(nombre1))+' '+rtrim(ltrim(nombre2))+' '+
rtrim(ltrim(apellido1))+ ' '+rtrim(ltrim(apellido2))
where tipo_doc='13'

select * from dian_subir where nit_emisor='1104422228'
select * from dian_municipios where codDpto='11'
select * from dian_municipios where nombreciudad like 'yumb%'
select * from dian_dpto

select nit_dian, tipo_doc, apellido1,apellido2,nombre1,nombre2,razon, direccion,codDpto,codMunicipio from  dian_terceros  where nit_dian='900713172'

KM 3 VDA LA TOLVA PAR INSDUSTRIAL EL DORAL BG 14
update dian_terceros set direccion='CL 22-3  92BRCENTRO', codDpto='47', codMunicipio='001' where nit_dian='900713172'

update dian_terceros set razon='', apellido1='FERNANDEZ', apellido2='RIVERA', nombre1='ANGIE', nombre2='PAOLA' where  nit_dian='1050040954'
select * from dian_terceros  where id>=6671 order by id

select nit_dian, tipo_doc, razon, apellido1,apellido2,nombre1,nombre2 from  dian_terceros  where nit_dian='1050040954'
select nit_dian, tipo_doc, apellido1,apellido2,nombre1,nombre2,razon from  dian_terceros  where nit_dian=''
select tipo_doc,nit_dian, apellido1,apellido2,nombre1,nombre2,razon from  dian_terceros  where nit_dian=''
select nit_dian,tipo_doc,nombre1,nombre2,apellido1,apellido2,razon from  dian_terceros  where nit_dian=''
select * from  dian_terceros  where nit_dian='901387193'

delete from dian_terceros where id>=4013 order by id


update dian_terceros set excluir_compras=1
where nit_dian in ('819003851','830122566','830131993','890107487','890208788',
'890300225','890903790','890904996','900515140','1047429430','811008012',
'890902875','900534356','900355222','860016640','860519235','890400869','890107487','812000577','805003626',
'901743465','800242106','890903407','860009578','890903790','812002235','900245841','900298002','830018214',
'800176628','901213712','6881029','901138873','900491889','43082261','900215056','900192769','860002400',
'901144507','8064117','70353742','901296635','900402733','811045607','800251569','812003293','900749571',
'901363412','900355557','901419883','900053978','900231775','900219834','830051440','890100531','830507952',
'830054581','900747987','901695089','830003584','11051545','900377621','811009788','900358833',
'830011670','800153993','900434863','900342297','800153993','900816838','901265547','900122353',
'900158685','6894638','900200435','891080019','860002184','800157892','900881888','891001109','830053812',
'70160738','800165720','805011074','830033050',
'900710267','892300072','900200435','811007713','800060828','890208788','890480041','830114921','800153993','830131993',
'800251569','890903790','890903407','890902875','800128735')

---901572025	BET SUPPLIER SAS


update dian_terceros set excluir_compras=0 where nit_dian='800251569'
select * from dian_terceros where nit_dian='900921089'
select * from dian_subir    where nit_recep='9009210891'

update dian_subir set nit_recep='900921089' where nit_recep='9009210891'


delete from dian_terceros where id=2011
update dian_terceros set excluir_compras=0 where excluir_compras is null


update dian_terceros set unirMunicipio=rtrim(ltrim(codDpto))+rtrim(ltrim(codMunicipio))

ALTER TABLE dian_terceros
ALTER COLUMN nomb_terce CHAR(130);

ALTER TABLE dian_terceros
ALTER COLUMN direccion CHAR(90);

ALTER TABLE dian_terceros2
ALTER COLUMN razon CHAR(130);

select * from dian_subir where cod_emp='AMJG' and year(fch_emision)=2024
select sum(total) from dian_subir where cod_emp='AMJG' and year(fch_emision)=2024 and nit_emisor='70353742'

EXEC carga_masiva 'JAGM',2024,'C:\proveedorSQL\exogenas\pruebas\datos_JAGM.txt'



declare @cod_emp char(10), @ano numeric(4), @tipo numeric(2)
set @cod_emp='JAGM'
set @ano=2024
set @tipo=2 -- donde 1 es vemtas 2 es compras y  3 es nomina
EXEC exogena_calculo @cod_emp, @ano, @tipo


declare @cod_emp char(10), @ano numeric(4), @tipo numeric(2)
set @cod_emp='LRQ'
set @ano=2025
set @tipo=2 -- donde 1 es vemtas 2 es compras y  3 es nomina
EXEC exogena_calculo @cod_emp, @ano, @tipo

declare @cod_emp char(10), @ano numeric(4), @tipo numeric(2)
set @cod_emp='MLC'
set @ano=2025
set @tipo=2 -- donde 1 es vemtas 2 es compras y  3 es nomina
EXEC exogena_calculo @cod_emp, @ano, @tipo

declare @cod_emp char(10), @ano numeric(4), @tipo numeric(2)
set @cod_emp='WCF'
set @ano=2025
set @tipo=2 -- donde 1 es vemtas 2 es compras y  3 es nomina
EXEC exogena_calculo @cod_emp, @ano, @tipo

select *  from dian_subir where cod_emp='LRQ' 
select *  from dian_subir where cod_emp='WCF'

--apliamos el tamaño del campo folio
alter table dian_subir alter column folio varchar(30)

select * from dian_terceros  where nit_dian='70352072'
update dian_terceros set tipo_doc='31' where nit_dian='901788496'

delete from dian_terceros where id=2271

update dian_terceros set apellido1='GAMARRA', apellido2='SIERRA', nombre1='JOSE', nombre2='ROSARIO'
where nit_dian='79146107'

update dian_terceros set apellido1='EL REDA', apellido2='AWADA', nombre1='ALI', nombre2='RIAD'
where nit_dian='1126038685'

update dian_terceros set apellido1='MANZO', apellido2='REVUELTA', nombre1='LUIS', nombre2='ALBERTO'
where nit_dian='77103792'
