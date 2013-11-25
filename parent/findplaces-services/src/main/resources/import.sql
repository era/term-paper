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
INSERT INTO tb_user_type (id, name) VALUES (9000, 'FACEBOOK_USER');

INSERT INTO tb_user_type (id, name) VALUES (9001, 'COMMON_USER');

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
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(1,'21','eliasojrs@gmail.com','Elias Granja',null,'In a Relationship','1750315906','UNIP',9000);
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

INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(2,'30','maxjuniorbr@gmail.com','Paulo Dianin',null,'Married','100001401841332','UNIP',9000);
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
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(3,'23','eduardo@gmail.com','Eduardo Botelho',null,'Single','100001396002138','UNIP',9000);
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
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(4,'21','mateus@gmail.com','Mateus Coradini',null,'Single','100000485880931','UNIP',9000);
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


--Fake 1
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(5,'21','ricardo@gmail.com','Ricardo da Silva',null,'Single','110000485880931','USP',9000);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('1394081697499186',101,'Feel more',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,1394081697499186,101);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('720745557938669',102,'Citei Frases',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,720745557938669,102);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('449967965107029',103,'Mais um dia',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,449967965107029,103);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('230151130485754',104,'Garota Ciúmes',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,230151130485754,104);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('550019531749655',105,'Pra Toda Mulher',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,550019531749655,105);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('421067194667864',106,'Que Isso Novinha?',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,421067194667864,106);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('83763988990',107,'Wicca',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,83763988990,107);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('391930330905253',108,'Wicca: Magia Natural',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,391930330905253,108);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('442266112475813',109,'Bem+Leve',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,442266112475813,109);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('385991014797696',110,'Leis de Murphy',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,385991014797696,110);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('530833057007725',111,'Gab Z Tattoo',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,530833057007725,111);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('267510033269587',112,'Biblioteca Empoeirada',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,267510033269587,112);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('181059575250734',113,'BABILORENTZ.COM',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,181059575250734,113);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('123928584430020',114,'Every Little Book',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,123928584430020,114);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('389814171106259',115,'Sou Bibliomaníaca',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,389814171106259,115);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('226040377417115',116,'Livros & Fuxicos',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,226040377417115,116);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('114865945264475',117,'Lendo & Comentando',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,114865945264475,117);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('129677350453139',118,'SanguecomAmor"O Recomeço da Eternidade"',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,129677350453139,118);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('410139565669978',119,'Segredos Entre Amigas',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,410139565669978,119);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('209266695796856',120,'Pronome Interrogativo',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,209266695796856,120);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('106411899489478',121,'Moonlight Books',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,106411899489478,121);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('369115576446681',122,'Todas as coisas do meu mundo',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,369115576446681,122);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('531510056888531',123,'The Snow Twins',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,531510056888531,123);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('193522807501735',124,'Blog Mais que Livros',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,193522807501735,124);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('184813508285183',125,'Mundo Otaku',5);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (5,184813508285183,125);


--fake 2
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(6,'21','js@gmail.com','José da Silva',null,'Single','110100485880931','USP',9000);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('199483006752626',127,'El Cabriton',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,199483006752626,127);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('5718758966',128,'Gizmodo',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,5718758966,128);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('124493634232128',129,'UOL Notícias',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,124493634232128,129);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('168803467003',130,'Bad Religion',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,168803467003,130);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('345454685555554',131,'Procurei em Sonhos',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,345454685555554,131);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('170901143077174',132,'Best Vines',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,170901143077174,132);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('501741936570355',133,'VYNE',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,501741936570355,133);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('233180966721555',134,'Animal Crossing: New Leaf',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,233180966721555,134);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('144765615556287',135,'Uma familia da pesada',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,144765615556287,135);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('7807422276',136,'How I Met Your Mother',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,7807422276,136);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('101401456710000',137,'Raspberry Pi',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,101401456710000,137);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('208858059145942',138,'Pragmatismo Político',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,208858059145942,138);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('119702488081975',139,'Skrillex',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,119702488081975,139);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('355748217780706',140,'Domínio Público - Movimento Estudantil',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,355748217780706,140);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('203702669733223',141,'Flisolcampinas',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,203702669733223,141);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('138562632977557',142,'Joan Cornellà',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,138562632977557,142);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('192940197458210',143,'Cachorro Grande',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,192940197458210,143);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('416489695095902',144,'Dev Camp',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,416489695095902,144);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('274236662698155',145,'Woods',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,274236662698155,145);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('19292868552',146,'Facebook Developers',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,19292868552,146);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('470397299693185',147,'Denise Carreiro Semi Jóias',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,470397299693185,147);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('204520732988',148,'Não Salvo',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,204520732988,148);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('112401055439442',149,'GitHub',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,112401055439442,149);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('112170668795185',150,'Raimundos',6);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (6,112170668795185,150)

--fake 3
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(7,'41','breakingbad@gmail.com','Walter White',null,'Married','10100485880931','Unicamp',9000);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('286857427988',151,'Henri Cartier-Bresson',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,286857427988,151);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('180176758708116',152,'Grass: The History of Marijuana',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,180176758708116,152);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('335237883171442',153,'Leonardo Sakamoto',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,335237883171442,153);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('6002137995',154,'Gorillaz',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,6002137995,154);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('250276871743419',155,'Caetano Veloso',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,250276871743419,155);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('365967726042',156,'Fernanda Takai',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,365967726042,156);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('225782532925',157,'Mallu Magalhães',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,225782532925,157);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('11955325695',158,'Bob Dylan',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,11955325695,158);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('115786371936',159,'revista piauí',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,115786371936,159);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('38858586087',160,'Jimi Hendrix',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,38858586087,160);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('333587596787257',161,'Andorinhas Jornalismo Independente',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,333587596787257,161);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('232843116758475',162,'Delta Blues Bar',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,232843116758475,162);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('541465049252652',163,'ALÉM',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,541465049252652,163);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('6798562721',164,'Breaking Bad',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,6798562721,164);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('111900243908',165,'Pina Bausch',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,111900243908,165);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('104152332963030',166,'Gilberto Gil',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,104152332963030,166);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('210278425667315',167,'Dixie Arte e Estilo',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,210278425667315,167);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('89511870952',168,'Lou Reed',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,89511870952,168);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('164188247072662',169,'NINJA',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,164188247072662,169);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('414328301991113',170,'José Celso Martinez Corrêa',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,414328301991113,170);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('180554365374752',171,'Teat(r)o Oficina Uzyna Uzona',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,180554365374752,171);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('148714591835821',172,'Downton Abbey',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,148714591835821,172);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('125213514291',173,'Charlotte Gainsbourg',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,125213514291,173);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('155347691187734',174,'Frases do Calvin',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,155347691187734,174);
INSERT INTO tb_user_likes(socialid,id,name,user_id) VALUES('470580662953557',175,'Gado da Pira',7);
INSERT INTO tb_user_tb_user_likes(tb_user_id, likes_socialid, likes_id) VALUES (7,470580662953557,175);


ALTER SEQUENCE hibernate_sequence  INCREMENT 50  MINVALUE 5000  MAXVALUE 9223372036854775807  START 5001  RESTART 5000  CACHE 1;
--fakes sem likes
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(8,'41','joeytribianni@gmail.com','Joey Tribianne',null,'Married','11101485880931','UNIP',9000);
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(9,'38','rachelgreen@gmail.com','Rachel Green',null,'Married','12101485880931','UNIP',9000);
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(10,'21','monica@gmail.com','Monica Green',null,'Married','12101485880921','UNIP',9000);
INSERT INTO tb_user(id,age,email,name,password,relationship,socialid,studyat,type_id) VALUES(11,'22','ross@gmail.com','Ross Green',null,'Married','111051485880921','UNIP',9000);

--seller configurations
INSERT INTO tb_seller(id,user_id) VALUES(1,1);
INSERT INTO tb_seller(id,user_id) VALUES(2,2);
INSERT INTO tb_seller(id,user_id) VALUES(3,3);
INSERT INTO tb_seller(id,user_id) VALUES(4,4);


--Facilities
INSERT INTO tb_townhouse(id, air, automaticdoor, barbecue, bathboxglass, bathroomcloset, bathtub, bedroomcloset, gasshower, gastubing, gatekeeper, gym, internet, kitchencabinet, laundry, name, partyroom, playground, pool, price, roofing, sauna, sportarea, terrace, townbarbecue,townpool)VALUES (500, false, true, false, true, true, false, true, false, true, true, false, false, false, true, 'Ed. Andrea', true, true, false, 400, false, false, false, false, false, false);

INSERT INTO tb_townhouse(id, air, automaticdoor, barbecue, bathboxglass, bathroomcloset, bathtub, bedroomcloset, gasshower, gastubing, gatekeeper, gym, internet, kitchencabinet, laundry, name, partyroom, playground, pool, price, roofing, sauna, sportarea, terrace, townbarbecue,townpool)VALUES (501, false, true, false, true, true, true, true, false, true, true, false, false, false, true, 'Ed. Cambui', true, true, false, 700, false, false, false, false, false, false);

INSERT INTO tb_townhouse(id, air, automaticdoor, barbecue, bathboxglass, bathroomcloset, bathtub, bedroomcloset, gasshower, gastubing, gatekeeper, gym, internet, kitchencabinet, laundry, name, partyroom, playground, pool, price, roofing, sauna, sportarea, terrace, townbarbecue,townpool)VALUES (502, false, true, false, true, true, true, true, false, true, true, false, false, false, true, 'Ed. Lamana', true, true, false, 350, false, false, false, false, false, false);

INSERT INTO tb_townhouse(id, air, automaticdoor, barbecue, bathboxglass, bathroomcloset, bathtub, bedroomcloset, gasshower, gastubing, gatekeeper, gym, internet, kitchencabinet, laundry, name, partyroom, playground, pool, price, roofing, sauna, sportarea, terrace, townbarbecue,townpool)VALUES (503, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 'Casa', false, false, false, 0, false, false, false, false, false, false);

INSERT INTO tb_townhouse(id, air, automaticdoor, barbecue, bathboxglass, bathroomcloset, bathtub, bedroomcloset, gasshower, gastubing, gatekeeper, gym, internet, kitchencabinet, laundry, name, partyroom, playground, pool, price, roofing, sauna, sportarea, terrace, townbarbecue,townpool)VALUES (504, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 'Casa', false, false, false, 0, false, false, false, false, false, false);


--Espaciais

--Barao de Jaguara 141
INSERT INTO tb_place_f(id, geom) VALUES (3000, ST_GeomFromText('POINT(-22.912438 -47.055014)', 4326));

--Padre almeida 278
INSERT INTO tb_place_f(id, geom) VALUES (3001, ST_GeomFromText('POINT(-22.89732 -47.049932)', 4326));

--Av. Francisco Glicério, 1357
INSERT INTO tb_place_f(id, geom) VALUES (3002, ST_GeomFromText('POINT(-22.903465 -47.060464)', 4326));

--R. Benedito Otávio, 2-112 - Vila Industrial
INSERT INTO tb_place_f(id, geom) VALUES (3003, ST_GeomFromText('POINT(-22.909486 -47.075164)', 4326));

--R. Tabira, 122 - Jardim Amazonas
INSERT INTO tb_place_f(id, geom) VALUES (3004, ST_GeomFromText('POINT(-22.94305 -47.036989)', 4326));

--Places

--Barao de Jaguara
INSERT INTO tb_place(id, address, bathroom, bedroom, cellphone, cellphone2, code, condominiumprice, contract_time, deposit, description, garage, internet, iptu, m2, packtime, placefloor, price, qtdplacefloor, rent, rentmonths, room, suite, totalprice, tv, facilities_id, seller_id, spatial_id, type_id, user_id) VALUES (1, 'Rua Barao de Jaguara n 141 Ap 34, Jd. Bosque, Campinas, São Paulo', 1, 3, '1111-2222', '2222-1111', 'APC1', 400, 12, 800, 'Apartamento com otima localizacao.', 1, 0, 200, 140, 3, 3, 800, 3, 800, 12, 1, 1,  1200, 0, 500, 4 , 3000 , 1 , 4);

--Padre almeida
INSERT INTO tb_place(id, address, bathroom, bedroom, cellphone, cellphone2, code, condominiumprice, contract_time, deposit, description, garage, internet, iptu, m2, packtime, placefloor, price, qtdplacefloor, rent, rentmonths, room, suite, totalprice, tv, facilities_id, seller_id, spatial_id, type_id, user_id) VALUES (2, 'Rua Padre almeida n 278 Ap 56, Cambui, Campinas, São Paulo', 1, 2, '1111-2222', '2222-1111', 'APC2', 600, 12, 1000, 'Apartamento com otima vista, reformado, e otimo bairro.', 1, 0, 180, 130, 3, 5, 800, 3, 800, 12, 1, 1, 1600, 0, 501, 4 , 3001 , 1 , 4);

--Francisco Glicerio
INSERT INTO tb_place(id, address, bathroom, bedroom, cellphone, cellphone2, code, condominiumprice, contract_time, deposit, description, garage, internet, iptu, m2, packtime, placefloor, price, qtdplacefloor, rent, rentmonths, room, suite, totalprice, tv, facilities_id, seller_id, spatial_id, type_id, user_id) VALUES (3, 'Av. Francisco Glicério, AP 31 1357 Centro, Campinas, São Paulo', 1, 2, '1111-2222', '2222-1111', 'APC3', 350, 12, 900, 'Apartamento novo.', 1, 0, 220, 160, 3, 3, 800, 3, 800, 12, 1, 1,  1250, 0, 502, 4 , 3002 , 1 , 4);

--R. Benedito Otávio, 2-112 - Vila Industrial
INSERT INTO tb_place(id, address, bathroom, bedroom, cellphone, cellphone2, code, condominiumprice, contract_time, deposit, description, garage, internet, iptu, m2, packtime, placefloor, price, qtdplacefloor, rent, rentmonths, room, suite, totalprice, tv, facilities_id, seller_id, spatial_id, type_id, user_id) VALUES (4, 'R. Benedito Otávio, 100, Vila Industrial, Campinas, São Paulo', 0, 2, '1111-2222', '2222-1111', 'CAC31', 0, 12, 750, 'Casa Reformada.', 1, 0, 90, 140, 3, 0, 800, 3, 800, 12, 1, 1,  750, 0, 503, 4 , 3003 , 2 , 4);

--R. Tabira, 122 - Jardim Amazonas
INSERT INTO tb_place(id, address, bathroom, bedroom, cellphone, cellphone2, code, condominiumprice, contract_time, deposit, description, garage, internet, iptu, m2, packtime, placefloor, price, qtdplacefloor, rent, rentmonths, room, suite, totalprice, tv, facilities_id, seller_id, spatial_id, type_id, user_id) VALUES (5, 'R. Tabira, 122 - Jardim Amazonas, Campinas, São Paulo', 1, 2, '1111-2222', '2222-1111', 'CAC31', 0, 12, 750, 'Casa Reformada.', 1, 0, 140, 100, 3, 0, 800, 3, 800, 12, 1, 1,  1200, 0, 504, 1 , 3004 , 2 , 1);
