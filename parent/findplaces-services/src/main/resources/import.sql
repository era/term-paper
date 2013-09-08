--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
INSERT INTO tb_user_type(id, name) VALUES (1, 'FACEBOOK_USER');

INSERT INTO tb_user_type(id, name) VALUES (2, 'COMMON_USER');

INSERT INTO tb_place_type(id, name) VALUES (1, 'APART');

INSERT INTO tb_place_type(id, name) VALUES (2, 'HOUSE');

INSERT INTO tb_place_type(id, name) VALUES (3, 'CONTAINER');

INSERT INTO tb_user(id, email, name, password, socialid, type_id)  VALUES (1, 'test@test.com', 'test', 'tst', 1, '2');



INSERT INTO tb_country(id, name)  VALUES (1, 'Brazil');

INSERT INTO tb_region(id, name, country_id)  VALUES (1, 'São Paulo', 1);

INSERT INTO tb_city(id, name, region_id)  VALUES (1, 'Campinas', 1);

INSERT INTO tb_neighborhood(id, hoodname, city_id)  VALUES (1, 'Centro', 1);

INSERT INTO TB_STREET(id, streetname, neighborhood_id)  VALUES (1, 'Barão de Jaguara', 1);