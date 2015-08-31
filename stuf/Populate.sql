insert into userentity (dtype, id, email, firstname, lastname, login, password)
	values ('A' ,1 , 'admin@csw.pt', 'HR', 'Administrator', 'admin', 'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');
	/* pass 123 */

insert into role (userentity_id, role) values ( 1 , 'ADMINISTRATOR');
insert into role (userentity_id, role) values ( 1 , 'MANAGER');
insert into role (userentity_id, role) values ( 1 , 'INTERVIEWER');


insert into userentity (dtype, id, email, firstname, lastname, login, password)
	values ('M' ,2 , 'manager@csw.pt', 'HR', 'Manager', 'manager', 'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');
	/* pass 123 */

insert into role (userentity_id, role) values ( 2 , 'MANAGER');
insert into role (userentity_id, role) values ( 2 , 'INTERVIEWER');

insert into userentity (dtype, id, email, firstname, lastname, login, password)
	values ('I' ,3 , 'interviewer@csw.pt', 'HR', 'Interviewer', 'interviewer', 'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');
	/* pass 123 */

insert into role (userentity_id, role) values ( 3 , 'INTERVIEWER');

insert into candidate (address, city, country, cv, email, firstname, lastname, letter, login, diploma, mobile, password, phone, school, id, role)
	values ('Ladeira dos Sobreiros, 8 - Mogofores', 'Anadia', 'Portugal', 'cv', 'joao.pedro.martins@csw.pt', 'João', 'Martins', 'Joao letter', 'joao', 'Eng. Electronica e Telecomunicações', '933586209', 'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=', '256572970', 'Universidade de Aveiro', '1', 'CANDIDATE');
	/* pass 123 */