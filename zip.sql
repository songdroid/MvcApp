CREATE TABLE tblzip(
	zipcode		varchar2(10),
	sido		varchar2(6),
	gugun		varchar2(20),
	dong		varchar2(60),
	bunji		varchar2(20)
);

select * from tblzip where dong like '%¿ª»ï%';