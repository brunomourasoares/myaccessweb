INSERT INTO tb_visitor (document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES ('12345678910', 'Bruno Moura Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES ('12345678911', 'Jose Carlos Porto Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES ('12345678912', 'Vera Lucia Moura Soares', 'Female', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES ('12345678913', 'Douglas Moura Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');


INSERT INTO tb_user (username, password, email, create_date, update_date, blocked) VALUES ('admin', 'admin', 'admin@email.com', NOW(), NULL, false);
INSERT INTO tb_user (username, password, email, create_date, update_date, blocked) VALUES ('user1', 'user1', 'user1@email.com', NOW(), NULL, false);
INSERT INTO tb_user (username, password, email, create_date, update_date, blocked) VALUES ('user2', 'user2', 'user2@email.com', NOW(), NULL, false);
INSERT INTO tb_user (username, password, email, create_date, update_date, blocked) VALUES ('user3', 'user3', 'user3@email.com', NOW(), NULL, false);