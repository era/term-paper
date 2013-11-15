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








-- Elias user
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(1,'21','eliasojrs@gmail.com','Elias Granja',null,'In a Relationship','1750315906','UNIP',1);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('218624958315883',1,'Node JS São Paulo',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,218624958315883,1);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('224471551037461',2,'IFind Platform',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,224471551037461,2);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('168803467003',3,'Bad Religion',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,168803467003,3);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('136715906514765',4,'O Beco em Campinas',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,136715906514765,4);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('355748217780706',5,'Domínio Público - Movimento Estudantil',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,355748217780706,5);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('134997079926680',6,'Dce Unicamp',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,134997079926680,6);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('466088016748221',7,'Dutch Pub',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,466088016748221,7);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('189741452187',8,'CI&T',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,189741452187,8);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('545662975467630',9,'Jean Galvão',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,545662975467630,9);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('172603662808685',10,'The King of Queens',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,172603662808685,10);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('109595682393753',11,'The Lord of the Rings',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,109595682393753,11);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('147408255302548',12,'Kristina Svechinskaya',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,147408255302548,12);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('147625925327941',13,'Dekode',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,147625925327941,13);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('342401129191152',14,'Campinas Rock',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,342401129191152,14);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('104095292959576',15,'Java',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,104095292959576,15);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('328721007208148',16,'Frontinsampa',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,328721007208148,16);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('248868078515154',17,'As Crônicas de Gelo e Fogo',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,248868078515154,17);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('271216762999421',18,'The Lord of the Rings',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,271216762999421,18);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('230037937022490',19,'Grainnes Campinas',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,230037937022490,19);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('285812901524037',20,'Coaching-Colabora',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,285812901524037,20);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('408360409216772',21,'Lean Solution',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,408360409216772,21);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('362098707198223',22,'Estampa Sorvete no Camiseteria.com. Autoria de Leandro Jorge',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,362098707198223,22);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('425145710871367',23,'StartupConn',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,425145710871367,23);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('109766852429151',24,'Piece Project',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,109766852429151,24);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('167874336559108',25,'Allcenter',1);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (1,167874336559108,25);




--Paulo User

INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(2,'30','maxjuniorbr@gmail.com','Paulo Dianin',null,'Married','100001401841332','UNIP',1);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('72493026282',26,'CounterStrike',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,72493026282,26);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('215459165171017',27,'Temple Run',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,215459165171017,27);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('384930808273236',28,'Crayola Fem',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,384930808273236,28);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('190023831153085',29,'Splinter Cell',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,190023831153085,29);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('506784339344483',30,'Balão da Informática',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,506784339344483,30);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('581532358560041',31,'Emedals Militaria & Historica',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,581532358560041,31);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('299489723516999',32,'Juliana Modas',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,299489723516999,32);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('154213784747095',33,'Robert Downey Jr',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,154213784747095,33);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('244031735674147',34,'Colégio São Francisco de Assis',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,244031735674147,34);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('112321138961122',35,'Google Keep',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,112321138961122,35);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('209211948001',36,'RAGE',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,209211948001,36);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('365303330233117',37,'Casamento Franciele e Anderson 04 MAIO 2013',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,365303330233117,37);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('521908544493502',38,'Gravata & Cia',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,521908544493502,38);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('355972521160537',39,'FreedomSponsors',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,355972521160537,39);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('322410337838911',40,'BrazilJS Foundation',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,322410337838911,40);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('268057946570390',41,'Shopping Parque das Bandeiras',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,268057946570390,41);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('153678038020813',42,'RuPy Conference',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,153678038020813,42);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('153066921414654',43,'Tire aquela musica de sua cabeça!',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,153066921414654,43);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('48541472233',44,'AZUL - Linhas Aéreas Brasileiras',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,48541472233,44);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('328721007208148',45,'Frontinsampa',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,328721007208148,45);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('106097402755882',46,'Ci&T',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,106097402755882,46);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('105996556149218',47,'UNICAMP',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,105996556149218,47);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('425145710871367',48,'StartupConn',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,425145710871367,48);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('231118320236226',49,'Smartzone | Vida Mobile',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,231118320236226,49);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('258610387577227',50,'Panacea',2);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (2,258610387577227,50);


--Eduardo user
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(3,'23','eduardo@gmail.com','Eduardo Botelho',null,'Single','100001396002138','UNIP',1);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('411615882230084',51,'Gui Rebustini',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,411615882230084,51);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('226246694196893',52,'Este é alguém',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,226246694196893,52);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('216630021727132',53,'Netflix Brasil',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,216630021727132,53);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('572798476071875',54,'Genesis Moda Urbana',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,572798476071875,54);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('367682813259391',55,'Street Company',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,367682813259391,55);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('362771317140778',56,'MauroHenrique',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,362771317140778,56);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('195327086257',57,'Revista Arkade',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,195327086257,57);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('110455108974424',58,'GameStop',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,110455108974424,58);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('151685068208263',59,'Pelotão Dos Games',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,151685068208263,59);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('390138978985',60,'Fake Science',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,390138978985,60);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('491459520926736',61,'Vôlei Brasil Kirin',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,491459520926736,61);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('213110905425722',62,'Nuuvem Platform',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,213110905425722,62);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('445007015579033',63,'Adoração Ágape',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,445007015579033,63);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('317306115062741',64,'I Like',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,317306115062741,64);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('109177065832890',65,'Mok',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,109177065832890,65);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('363954017011102',66,'Zig Store',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,363954017011102,66);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('411797008889746',67,'Poetas Incompreendidos',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,411797008889746,67);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('215240665284535',68,'Cosplayly',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,215240665284535,68);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('244830742251856',69,'SMBC Comics',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,244830742251856,69);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('138018053004284',70,'Nintendista',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,138018053004284,70);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('367116489976035',71,'I fucking love science',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,367116489976035,71);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('67919847338',72,'Steam',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,67919847338,72);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('179415908839187',73,'Alvanista',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,179415908839187,73);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('201236053355806',74,'Road Mice',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,201236053355806,74);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('112467815440978',75,'CDRStation Games',3);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (3,112467815440978,75);



--Mateus user
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(4,'21','mateus@gmail.com','Mateus Coradini',null,'Single','100000485880931','UNIP',1);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('229899403738458',76,'Call of Duty',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,229899403738458,76);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('406433779383',77,'Dwayne The Rock Johnson',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,406433779383,77);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('189534907741676',78,'Espaço Ética',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,189534907741676,78);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('130835497057566',79,'Legião dos Heróis',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,130835497057566,79);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('292135314261350',80,'Sampa angels',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,292135314261350,80);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('190950799085',81,'Caelum - Ensino e Inovação',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,190950799085,81);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('157011322564',82,'Eeyore',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,157011322564,82);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('124200947660478',83,'Pietra Principe',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,124200947660478,83);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('248183641886114',84,'PlayStation',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,248183641886114,84);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('169552423070535',85,'Steve-O',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,169552423070535,85);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('108810312545663',86,'The Hobbit',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,108810312545663,86);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('58151482037',87,'Chris Rock',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,58151482037,87);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('351415451630678',88,'BTOA',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,351415451630678,88);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('9098498615',89,'Adam Sandler',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,9098498615,89);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('173146689397335',90,'CPqD',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,173146689397335,90);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('186313488067086',91,'Fundação CPqD Centro de Pesquisa e Desenvolvimento em Telecomunicações',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,186313488067086,91);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('497252540321903',92,'Shared MP3',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,497252540321903,92);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('204520732988',93,'Não Salvo',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,204520732988,93);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('460302177372261',94,'É o que tem pra hoje',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,460302177372261,94);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('526273837416216',95,'Que País é Esse?',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,526273837416216,95);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('144902595554',96,'Woody',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,144902595554,96);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('128303638019',97,'Buzz Lightyear',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,128303638019,97);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('141253185941143',98,'Kboing',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,141253185941143,98);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('130297048172',99,'Tony Parker',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,130297048172,99);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('8245623462',100,'NBA',4);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (4,8245623462,100);




--seller configurations
INSERT INTO tb_seller(id,user_id) VALUES(1,1);
INSERT INTO tb_seller(id,user_id) VALUES(2,2);
INSERT INTO tb_seller(id,user_id) VALUES(3,3);
