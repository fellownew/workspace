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

delete from department 
where location like '������'
 
select department_id,department_name 
from department 
where location='����'

select department_name
from department

select department_id �μ����̵�,department_name �μ��̸�, location ����
from department


drop table employee

create table employee(
employee_id number(3),
employee_name varchar2(30) not null,
email varchar2(50) not null,
job_position varchar2(30) not null,
salary number not null,
hire_date date not null,
department_id number(3),
constraint em_id_pk primary key(employee_id),
constraint em_dept_fk foreign key(department_id) references department(department_id)
);

--�μ����̺��� department_id�� ������.
--foreign�� �Ұ��.
--constraint �̸� foreign key(�÷�) references ������(�θ�)���̺�


select department_id,department_name from DEPARTMENT
insert into employee values (001,'������','master@kosta.co.kr','����',7000000,'20090301',100);
insert into employee values (002,'��ö��','kcs@kosta.co.kr','����',3500000,'20091127',600);
insert into employee values (003,'�ֿ���','cyh@kosta.co.kr','���',2000000,'20120718',800);
insert into employee values (004,'�Ӳ���','lkj@kosta.co.kr','���',2000000,'20120512',500);
insert into employee values (005,'����','jks@kosta.co.kr','����',4500000,'20100101',200);
insert into employee values (006,'�̼���','lss@kosta.co.kr','����',5000000,'20090301',700);
insert into employee values (008,'ȫ�浿','hkd@kosta.co.kr','�븮',3000000,'20100101',200);


select *from employee order by employee_id
update employee set employee_id='001' where employee_id='007'

--join, �ٸ� ���̺����� ������ ��ȸ��.
select e.employee_id,e.employee_name,e.salary,d.department_id,d.department_name,d.location
from employee e,department d
where e.department_id=d.department_id
order by employee_id

select employee_id,employee_name,department_id
from employee
where employee_id=1

select department_id,department_name,location
from DEPARTMENT
where department_id=100

select e.employee_id,e.employee_name,e.salary,d.department_id,d.department_name,d.location
from employee e,department d
where e.department_id=d.department_id(+)
and e.employee_id=2
order by employee_id
