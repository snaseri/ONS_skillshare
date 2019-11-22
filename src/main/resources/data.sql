SET MODE MySQL;
SET IGNORECASE=TRUE;

INSERT INTO Types(id, name) VALUES (1, 'ACCELERATION');
INSERT INTO Types(id, name) VALUES (4, 'ASSISTANCE');
INSERT INTO Types(id, name) VALUES (2, 'TUTORING');
INSERT INTO Types(id, name) VALUES (3, 'ADVICE');

INSERT INTO Skills(id, name, description) VALUES (1, 'Python', 'Programming with Python.');
INSERT INTO Skills(id, name, description) VALUES (2, 'Java', 'Programming with Java.');
INSERT INTO Skills(id, name, description) VALUES (3, 'SQL', 'Programming with SQL.' );