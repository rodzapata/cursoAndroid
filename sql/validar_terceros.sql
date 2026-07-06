use proveedor
ALTER TABLE dian_terceros
ADD tipo_doc_excepcion numeric(1) default (0)

----terceros
select rtrim(ltrim(nit)) as nit, rtrim(ltrim(nomb_terce)) as nomb_terce, tipo_doc,  rtrim(ltrim(apellido1)) as apellido1, 
	rtrim(ltrim(apellido2)) as apellido2, 
	rtrim(ltrim(nombre1)) as nombre1, rtrim(ltrim(nombre2)) as nombre2,  rtrim(ltrim(razon)) as razon, '169' as pais,
	direccion, codDpto, codMunicipio
	from dian_terceros
	order by tipo_doc,  rtrim(ltrim(apellido1))

---terceros de gatos
select rtrim(ltrim(nit)) as nit, rtrim(ltrim(nomb_terce)) as nomb_terce, tipo_doc,  rtrim(ltrim(apellido1)) as apellido1, 
	rtrim(ltrim(apellido2)) as apellido2, 
	rtrim(ltrim(nombre1)) as nombre1, rtrim(ltrim(nombre2)) as nombre2,  rtrim(ltrim(razon)) as razon, '169' as pais,
	direccion, codDpto, codMunicipio
	from dian_terceros where excluir_compras=1
	order by tipo_doc,  rtrim(ltrim(apellido1))

---f1007 ventas
select '4001' as concepto, tipo_doc, rtrim(ltrim(nit)) as nit,  rtrim(ltrim(apellido1)) as apellido1, rtrim(ltrim(apellido2)) as apellido1, 
	rtrim(ltrim(nombre1)) as nombre1, rtrim(ltrim(nombre2)) as nombre2,  rtrim(ltrim(razon)) as razon, '169' as pais
	from dian_terceros

--F1001 compras
select '5007' as concepto, tipo_doc, rtrim(ltrim(nit)) as nit,  rtrim(ltrim(apellido1)) as apellido1, rtrim(ltrim(apellido2)) as apellido1, 
	rtrim(ltrim(nombre1)) as nombre1, rtrim(ltrim(nombre2)) as nombre2,  rtrim(ltrim(razon)) as razon, direccion, codDpto, codMunicipio, '169' as pais
	from dian_terceros

--F1005 IVA por pagar (ventas)
select tipo_doc,  rtrim(ltrim(nit)) as nit, '' as dv, rtrim(ltrim(apellido1)) as apellido1, rtrim(ltrim(apellido2)) as apellido1, 
	rtrim(ltrim(nombre1)) as nombre1, rtrim(ltrim(nombre2)) as nombre2,  rtrim(ltrim(razon)) as razon
	from dian_terceros

select * from dian_terceros where nit='7594564'

update dian_terceros set tipo_doc_excepcion=0
select * from dian_terceros where nit='80888291'

update dian_terceros set apellido1='LOPEZ', apellido2='ZULUAGA', nombre1='LAURA', nombre2='STEFANIA', razon='', tipo_doc='13' where nit='1000633561'
update dian_terceros set apellido1='PIMENTEL', apellido2='MARQUEZ', nombre1='ANYELA', nombre2='', razon='', tipo_doc='13' where nit='34946031'
update dian_terceros set apellido1='MERISALDE', apellido2='ARANGO', nombre1='ALVARO', nombre2='GILVERTO', razon='', tipo_doc='31', tipo_doc_excepcion=1 where nit='705589541'
update dian_terceros set tipo_doc='31' where nit='812004443'
insert dian_terceros(nit, razon, tipo_doc,direccion, coddpto, codmunicipio)
values('901652159','JK63 SAS','31','CARRERA 51 55 48','05','001')
update dian_terceros set tipo_doc='31', tipo_doc_excepcion=1 where nit='349410073'
insert dian_terceros(nit, razon, tipo_doc,direccion, coddpto, codmunicipio)
values('901609830','JUNTA DE ACCION CUMUNAL DEL BARRIO BEJAMIN PORRAS PEÑA','31','Carrera 16a No. 14 – 42','70','708')
update dian_terceros set apellido1='LOBO', apellido2='URQUIJIO', nombre1='ANTONIO', nombre2='', razon='', tipo_doc='13' where nit='13360203'
update dian_terceros set apellido1='ZULUAGA', apellido2='ARISTIZABAL', nombre1='ALBEIRO', nombre2='DE JESUS', razon='', tipo_doc='13' where nit='16786732'     
update dian_terceros set apellido1='LOPEZ', apellido2='POLO', nombre1='JHON', nombre2='FREDY', razon='', tipo_doc='13' where nit='73215282' 
update dian_terceros set apellido1='RUEDA', apellido2='BELRAN', nombre1='JOAQUIN', nombre2='HERNANDO', razon='', tipo_doc='13' where nit='91262686' 
update dian_terceros set apellido1='FRANCO', apellido2='DUQUE', nombre1='MAIRON', nombre2='ANDRES', razon='', tipo_doc='13' where nit='1079932843' 
update dian_terceros set apellido1='ARISTIZABAL', apellido2='GOMEZ', nombre1='JOHAN', nombre2='ANDRES', razon='', tipo_doc='13' where nit='1098779292' 

select * from dian_terceros where nit='812004443'
update dian_terceros set razon='MOTO HIT LTDA', apellido1='', apellido2='', nombre1='', nombre2='', nomb_terce='MOTO HIT LTDA'
	where nit='812004443'

update dian_terceros set codDpto='11', codMunicipio='001' where nit='900742091'
 	 	 	
--planeta rica JUAN GABRIEL GIRALDO
insert dian_terceros(nit, razon, tipo_doc,direccion, coddpto, codmunicipio)
values('830090773','MASSY ENERGY COLOMBIA SAS','31','Carrera 45A No. 93','11','001')
insert dian_terceros(nit, razon, tipo_doc,direccion, coddpto, codmunicipio)
values('812004673','I.E LOMA AZUL LOMA AZUL','31',' Loma Azul: Kilometro 4, vía Montería','23','555')
insert dian_terceros(nit, razon, tipo_doc,direccion, coddpto, codmunicipio)
values('901698448','JUNTA DE ACCION COMUNAL VEREDA VILLA NUEVA','31','Vereda Villanueva','23','555')




update dian_terceros set apellido1='' where apellido1 is null
update dian_terceros set apellido2='' where apellido2 is null
update dian_terceros set nombre1='' where nombre1 is null
update dian_terceros set nombre2='' where nombre2 is null
update dian_terceros set razon='' where razon is null
update dian_terceros set direccion=rtrim(ltrim(direccion))

update dian_terceros set nomb_terce=rtrim(ltrim(razon))
where tipo_doc in ('31','43') AND tipo_doc_excepcion=0

update dian_terceros set nomb_terce=rtrim(ltrim(apellido1))+ ' '+rtrim(ltrim(apellido2))+' '+rtrim(ltrim(nombre1))+' '+rtrim(ltrim(nombre2))
where tipo_doc='13' AND tipo_doc_excepcion=0

select * from dian_terceros where tipo_doc_excepcion=1
                                                           
        