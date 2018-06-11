create database academic_db;
use academic_db;
select * from aluno;

insert into professor
values (123456,'123-456-789-00','TADS','Professor 01','senha','M');

insert into disciplina
values (1,'50horas','8h - 9h','disciplina 01',1,'Nenhuma',123456);
insert into disciplina
values (2,'48horas','10h - 11h','disciplina 03',3,'disciplina 01',123456);