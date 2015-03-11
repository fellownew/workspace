create table stock(
stock_name varchar(50) primary key,
stock_type varchar(20) not null,
stock_price number(10) not null
)

create table havestock(
havestock_name varchar(50),
havestock_num number(5) not null,
 constraint have_fk foreign key havestock_name references stock(stock_name)
)
String id, String password, String name,ArrayList<HaveStock> haveStock)

create table investor(
investor_id varchar(50) primary key,
investor_pwd varchar(50) not null,
investor_name varchar(50) not null,
investor_have CLOB not null
)





