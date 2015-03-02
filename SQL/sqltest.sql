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

delete from department where location like '성남시'
 
