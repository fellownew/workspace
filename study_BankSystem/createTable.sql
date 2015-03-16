create table customer(
	customer_id varchar(30) primary key,
	customer_pwd varchar(30) not null,
	customer_name varchar(30) not null,
	credit_rating number(4,2) not null,
	job varchar(30) not null,
	age number(3) not null,
	sex varchar(4) not null,
	phone_Number varchar(30) not null,
	address varchar(30) not null
);

create table account(
	account_id varchar(30) primary key,
	amount number(10) not null,
	account_type varchar(30) not null
);

create table account_type(
	type_name varchar(30) primary key,
	interest number(4,2) not null
);

create table bank(
	amount number(10) not null
);

create table account_list(
	customer_id varchar(30),
	account_id varchar(30),
	constraint cusid_fk foreign key(customer_id) references customer(customer_id),
	constraint accid_fk foreign key(account_id) references account(account_id)
)


drop table customer