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



insert into DEPARTMENT (department_id,department_name,location)values(100,'기획부','서울');
insert into DEPARTMENT values(200,'재정부','성남시');
insert into DEPARTMENT (department_id,department_name) values(300,'기획부');
insert into DEPARTMENT values(400,'인사처','서울');
insert into department (department_id,department_name,location)values(500,'영업부','서울');
insert into department (department_id,department_name) values(600,'보안과');
insert into department values(700,'비서실','서울');
insert into department values(800,'영업2부','인천');
insert into department values(900,'영업3부','부산')

update department set location='인천' where location is null

delete from department 
where location like '성남시'
 
select department_id,department_name 
from department 
where location='서울'

select department_name
from department

select department_id 부서아이디,department_name 부서이름, location 지역
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

--부서테이블의 department_id를 참조함.
--foreign를 할경우.
--constraint 이름 foreign key(컬럼) references 참조할(부모)테이블


select department_id,department_name from DEPARTMENT
insert into employee values (001,'나사장','master@kosta.co.kr','사장',7000000,'20090301',100);
insert into employee values (002,'김철수','kcs@kosta.co.kr','과장',3500000,'20091127',600);
insert into employee values (003,'최영희','cyh@kosta.co.kr','사원',2000000,'20120718',800);
insert into employee values (004,'임꺽정','lkj@kosta.co.kr','사원',2000000,'20120512',500);
insert into employee values (005,'장길산','jks@kosta.co.kr','부장',4500000,'20100101',200);
insert into employee values (006,'이순신','lss@kosta.co.kr','실장',5000000,'20090301',700);
insert into employee values (008,'홍길동','hkd@kosta.co.kr','대리',3000000,'20100101',200);


select *from employee order by employee_id
update employee set employee_id='001' where employee_id='007'

--join, 다른 테이블끼리의 정보를 조회함.
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
