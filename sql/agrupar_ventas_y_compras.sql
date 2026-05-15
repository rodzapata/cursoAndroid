    drop table dian_calc
	
	CREATE TABLE dian_calc(
        nit_emisor VARCHAR(20) NULL DEFAULT '',
        nomb_emisor VARCHAR(130) NULL DEFAULT '',
        nit_recep VARCHAR(20) NULL DEFAULT '',
        nomb_recep VARCHAR(130) NULL DEFAULT '',
		iva numeric(18, 3) default(0),
		total numeric(18, 3) default(0),
		gravada numeric(18, 3) default(0),
		exenta numeric(18, 3) default(0),
		ID int IDENTITY(1,1)
	)

select  nit_recep, nomb_recep, round(sum(iva),0) as iva, round(sum(total),0) as total,
	round(sum(gravada),0) as gravada, round(sum(exenta),0) as exenta
	from dian_calc
	group by nit_recep, nomb_recep


select  nit_emisor, nomb_emisor, round(sum(iva),0) as iva, round(sum(total),0) as total,
	round(sum(gravada),0) as gravada, round(sum(exenta),0) as exenta
	from dian_calc
	group by nit_emisor, nomb_emisor
