INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destination, wanted_people, entrance_date) VALUES (random_uuid(), '12345678910', 'Fiat Uno', 'QWE1234', 'Bloco 20 Ap 404', 'Bruno', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destination, wanted_people, entrance_date) VALUES (random_uuid(), '12345678911', 'Chevrolet Onix', 'ASD1234', 'Bloco 20 Ap 404', 'Marcela', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destination, wanted_people, entrance_date) VALUES (random_uuid(), '12345678912', 'Ford Ka', 'ZXC1234', 'Bloco 20 Ap 304', 'Carlos', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destination, wanted_people, entrance_date) VALUES (random_uuid(), '12345678913', 'Volkswagen Fox', 'RTY1234', 'Bloco 20 Ap 304', 'Mariara', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destination, wanted_people, entrance_date) VALUES (random_uuid(), '12345678914', 'Fiat Palio', 'FGH1234', 'Bloco 20 Ap 201', 'Inda', NOW());
INSERT INTO tb_entrance (entrance_id, document, car_model, car_plate, destination, wanted_people, entrance_date) VALUES (random_uuid(), '12345678915', 'Chevrolet Opala', 'VBN1234', 'Bloco 20 Ap 201', 'Flavio', NOW());

INSERT INTO tb_visitor (id, document, name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678910', 'Bruno Moura Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (id, document, name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678911', 'Jose Carlos Porto Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (id, document, name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678912', 'Vera Lucia Moura Soares', 'Female', '12345678910', '', NOW(), NULL, '', false, '');
INSERT INTO tb_visitor (id, document, name, gender, contact_number, company, create_date, update_date, observation, blocked, photo_url) VALUES (random_uuid(), '12345678913', 'Douglas Moura Soares', 'Male', '12345678910', '', NOW(), NULL, '', false, '');


INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (0xc337f53e94c949689cd4e06b45b1c5c8, 'admin@email.com', 'admin', '2023-12-22 01:29:11.697558', NULL, NULL, b'0');
INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (0x034e35dffceb4d01b8152c18e3779fe2, 'user1@email.com', 'user1', '2023-12-25 02:38:31.797558', NULL, NULL, b'0');
INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (0x0784f313571f4b24b9d980e3a30f54d8, 'user2@email.com', 'user2', '2023-12-26 03:47:51.897558', NULL, NULL, b'0');
INSERT INTO tb_user (id, email, password, create_date, update_date, login_date, blocked) VALUES (0x0fb7404143c44fe8a253593175ca4c8b, 'user3@email.com', 'user3', '2023-12-28 04:56:21.997558', NULL, NULL, b'0');