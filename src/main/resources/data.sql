SET MODE MySQL;
SET IGNORECASE=TRUE;

INSERT INTO Types(id, name) VALUES (1, 'ACCELERATION');
INSERT INTO Types(id, name) VALUES (4, 'ASSISTANCE');
INSERT INTO Types(id, name) VALUES (2, 'TUTORING');
INSERT INTO Types(id, name) VALUES (3, 'ADVICE');

INSERT INTO role VALUES (1,'SUPER_USER','This user has ultimate rights for everything');
INSERT INTO role VALUES (2,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO role VALUES (3,'SITE_USER','This user has access to site, after login - normal user');

insert into users (id,username,password,status) values (25,'admin@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED');
insert into user_role (user_id, role_id) values ('1','1');
insert into user_role (user_id, role_id) values ('1','2');
insert into user_role (user_id, role_id) values ('1','3');



