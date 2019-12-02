SET MODE MySQL;
SET IGNORECASE=TRUE;

INSERT INTO Types(id, name) VALUES (1, 'ACCELERATION');
INSERT INTO Types(id, name) VALUES (4, 'ASSISTANCE');
INSERT INTO Types(id, name) VALUES (2, 'TUTORING');
INSERT INTO Types(id, name) VALUES (3, 'ADVICE');

INSERT INTO Skills(id, name, description) VALUES (3, 'SQL', 'Programming with SQL.' );
INSERT INTO Skills(id, name, description) VALUES (2, 'Java', 'Programming with Java.');
INSERT INTO Skills(id, name, description) VALUES (1, 'Python', 'Programming with Python.');

insert into Users (id, username, password) values (2, 'gflicker1', 'bpSPOJN');
insert into Users (id, username, password) values (1, 'rstickley0', 'RPdkup');
insert into Users (id, username, password) values (3, 'dfaiers2', '6NDv5Rd');
insert into Users (id, username, password) values (5, 'kbreedy4', 'BMmPsLs');
insert into Users (id, username, password) values (4, 'qumpleby3', 'P0hEGgy');
insert into Users (id, username, password) values (6, 'eradborn5', 'vZfpSUT');
insert into Users (id, username, password) values (7, 'jgeockle6', '7tjwiw');
insert into Users (id, username, password) values (8, 'awoodruffe7', 'HxWUo8AMU');
insert into Users (id, username, password) values (9, 'lmccosker8', 'wOP0ZPQK');
insert into Users (id, username, password) values (10, 'mraselles9', 'Rl9jFm9T');
insert into Users (id, username, password) values (11, 'yscotsona', 'LQloj9cAM');
insert into Users (id, username, password) values (12, 'rmeadenb', 'EzuR5atXg');
insert into Users (id, username, password) values (14, 'atantrumd', 'ArWlFuZt4');
insert into Users (id, username, password) values (13, 'spaddefieldc', 'N25ESc');
insert into Users (id, username, password) values (15, 'gteffreye', 'Jf3luMbu5I5T');
insert into Users (id, username, password) values (17, 'abrilg', '8BxbnL');
insert into Users (id, username, password) values (16, 'karchambaultf', 'xkBiaUopCo');
insert into Users (id, username, password) values (18, 'rmidnerh', 'ppD5GUhMXDQ4');
insert into Users (id, username, password) values (20, 'rgilderoyj', 'K6P0bGf');
insert into Users (id, username, password) values (19, 'djowlingi', 'dCLXK0iGiz2V');
insert into Users (id, username, password) values (22, 'medinburghl', '47qqBATjnTNH');
insert into Users (id, username, password) values (21, 'rdimitrievk', '3oHSn8qA');
insert into Users (id, username, password) values (24, 'emaccostyn', 'YvfK5pMVPO');
insert into Users (id, username, password) values (23, 'aboatm', 'V5QPjBpIz');
insert into Users (id, username, password) values (38, 'rhollingsbee11', '82uYgZ');
insert into Users (id, username, password) values (37, 'brendbaek10', 'Ui14WNbrMnF');
insert into Users (id, username, password) values (36, 'akastingz', 'oSV31wRuNt');
insert into Users (id, username, password) values (35, 'mryally', 'KF657DBHpZD');
insert into Users (id, username, password) values (34, 'rbudikx', 'Rpnyr7RKAM');
insert into Users (id, username, password) values (33, 'llacroixw', 'mG6ICUf');
insert into Users (id, username, password) values (32, 'cbocv', 'rOKZI7P');
insert into Users (id, username, password) values (31, 'bmcmeekinu', 'UMvxGhMpH');
insert into Users (id, username, password) values (30, 'ptomant', 'fqc6ha6JITXX');
insert into Users (id, username, password) values (29, 'apovalls', 'HzjmYwHTie');
insert into Users (id, username, password) values (28, 'jfrangor', 'AIlDME1J5');
insert into Users (id, username, password) values (27, 'msleetq', 's1edGdp');
insert into Users (id, username, password) values (26, 'gkeatp', 'PWEUYqAJF');
insert into Users (id, username, password) values (25, 'cnazairo', '9B4bUm');
insert into Users (id, username, password) values (39, 'Robert', 'password');
insert into Users (id, username, password) values (40, 'Rob', 'password');

insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (1, 'Java', 'Mauvvvvvvvvvvvvv', false, 2.89, '2008-11-11 13:23:44', 1, 2);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (2, 'Python', 'a very coooooool course', true, 0, '2010-11-11 13:23:44', 1, 3);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (3, 'The Course', 'for fun and a good time', true, 0, '2019-11-11 13:23:44', 1, 1);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (4, 'Free flask', 'a very practical course', true, 0, '2019-11-11 13:23:44', 1, 1);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (5, 'Skill share', 'practical and lots of fun', false, 5, '2020-11-11 13:23:44', 1, 2);

