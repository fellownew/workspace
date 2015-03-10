create table customer(
customer_id varchar(20) primary key,
customer_pwd varchar(20) not null,
customer_name varchar(20) not null,
customer_pnumber varchar(30) not null,
customer_email varchar(30) not null,
customer_mileage number(7) not null
)





update customer set employee_id='001' where employee_id='007'