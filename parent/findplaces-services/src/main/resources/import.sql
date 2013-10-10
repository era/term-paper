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
INSERT INTO tb_user_type (id, name) VALUES (1, 'FACEBOOK_USER');

INSERT INTO tb_user_type (id, name) VALUES (2, 'COMMON_USER');

INSERT INTO TB_PLACE_TYPE (id, name) VALUES (1, 'APARTMENT');

INSERT INTO TB_PLACE_TYPE (id, name) VALUES (2, 'HOUSE');


INSERT INTO tb_country (id, name)  VALUES (1, 'Brazil');

INSERT INTO tb_region (id, name, alias, country_id)  VALUES (1, 'Acre', 'AC', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (2, 'Alagoas', 'AL', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (3, 'Amapá','AP', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (4, 'Amazonas','AM', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (5, 'Bahia','BA', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (6, 'Ceará','CE', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (7, 'Distrito Federal','DF', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (8, 'Espírito Santo','ES', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (9, 'Goiás','GO', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (10, 'Maranhão','MA', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (11, 'Mato Grosso','MT', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (12, 'Mato Grosso do Sul','MS', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (13, 'Minas Gerais','MG', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (14, 'Pará','PA', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (15, 'Paraíba','PB', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (16, 'Paraná','PR', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (17, 'Pernambuco','PE', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (18, 'Piauí','PI', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (19, 'Rio de Janeiro','RJ', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (20, 'Rio Grande do Norte','RN', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (21, 'Rio Grande do Sul','RS', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (22, 'Rondônia','RO', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (23, 'Roraima','RR', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (24, 'Santa Catarina','SC', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (25, 'São Paulo','SP', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (26, 'Sergipe','SE', 1);
INSERT INTO tb_region (id, name, alias, country_id)  VALUES (27, 'Tocatins','TO', 1);


INSERT INTO TB_SELL_TYPE(id,name) VALUES(1,'BOUGHT');
INSERT INTO TB_SELL_TYPE(id,name) VALUES(2,'RENT');
INSERT INTO TB_SELL_TYPE(id,name) VALUES(3,'RENT TEMPORARY');




