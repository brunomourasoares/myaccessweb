INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destiny, wanted_people, entrance_date) VALUES (random_uuid(), '12345678910', 'Fiat Uno', 'QWE1234', 'Bloco 20 Ap 404', 'Bruno', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destiny, wanted_people, entrance_date) VALUES (random_uuid(), '12345678911', 'Chevrolet Onix', 'ASD1234', 'Bloco 20 Ap 404', 'Marcela', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destiny, wanted_people, entrance_date) VALUES (random_uuid(), '12345678912', 'Ford Ka', 'ZXC1234', 'Bloco 20 Ap 304', 'Carlos', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destiny, wanted_people, entrance_date) VALUES (random_uuid(), '12345678913', 'Volkswagen Fox', 'RTY1234', 'Bloco 20 Ap 304', 'Mariara', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destiny, wanted_people, entrance_date) VALUES (random_uuid(), '12345678914', 'Fiat Palio', 'FGH1234', 'Bloco 20 Ap 201', 'Inda', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destiny, wanted_people, entrance_date) VALUES (random_uuid(), '12345678915', 'Chevrolet Opala', 'VBN1234', 'Bloco 20 Ap 201', 'Flavio', NOW());

INSERT INTO tb_visitor (id, document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678910', 'Bruno Moura Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (id, document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678911', 'Jose Carlos Porto Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (id, document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678912', 'Vera Lucia Moura Soares', 'Female', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (id, document, full_name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678913', 'Douglas Moura Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');


INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (random_uuid(), 'admin@email.com', 'admin', NOW(), NULL, NULL, false);
INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (random_uuid(), 'user1@email.com', 'user1', NOW(), NULL, NULL, false);
INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (random_uuid(), 'user2@email.com', 'user2', NOW(), NULL, NULL, false);
INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (random_uuid(), 'user3@email.com', 'user3', NOW(), NULL, NULL, false);