create table department(
	department_id number(3) primary key,
	department_name varchar2(60) not null,
	location varchar2(30)
)

create table department(
	department_id number(3),
	department_name varchar2(60),
	location varchar2(30),
	constraint dept_id_pk primary key(department_id)
	constraint dept_name_nn not null(department_name)
)

select *from tab;
select *from DEPARTMENT 

drop table department;


insert into DEPARTMENT (department_id,department_name,location)values(100,'��ȹ��','����');
insert into DEPARTMENT values(200,'������','������');
insert into DEPARTMENT (department_id,department_name) values(300,'��ȹ��');
insert into DEPARTMENT values(400,'�λ�ó','����');
insert into department (department_id,department_name,location)values(500,'������','����');
insert into department (department_id,department_name) values(600,'���Ȱ�');
insert into department values(700,'�񼭽�','����');
insert into department values(800,'����2��','��õ');
insert into department values(900,'����3��','�λ�')

update department set location='��õ' where location is null

delete from department where location like '������'
 
