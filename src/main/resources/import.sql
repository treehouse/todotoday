-- Insert role
insert into role (name) values ('ROLE_USER');

-- Insert two users
insert into user (username,enabled,password,role_id) values ('user',true,'password',1);
insert into user (username,enabled,password,role_id) values ('user2',true,'password',1);

-- Insert tasks
insert into task (complete,description) values (true,'Code Task entity');
insert into task (complete,description) values (false,'Discuss users and roles');
insert into task (complete,description) values (false,'Enable Spring Security');
insert into task (complete,description) values (false,'Test application');