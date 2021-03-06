INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (100, 'RUNNER', 'run1@run1.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '55565555555', 1);
INSERT INTO PIOTR.RUNNER (ID, DATEOFBIRTH, FIRSTNAME, ISMALE, LASTNAME) VALUES (100, '2008-08-05', 'Adam', 1, 'Ładny');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (110, 'RUNNER', 'run2@run2.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '55515555555', 1);
INSERT INTO PIOTR.RUNNER (ID, DATEOFBIRTH, FIRSTNAME, ISMALE, LASTNAME) VALUES (110, '2006-06-05', 'Ada', 0, 'Fajna');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (130, 'RUNNER', 'run3@run3.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '45515555555', 1);
INSERT INTO PIOTR.RUNNER (ID, DATEOFBIRTH, FIRSTNAME, ISMALE, LASTNAME) VALUES (130, '2001-06-05', 'Natan', 1, 'Piewszy');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (140, 'RUNNER', 'run4@run4.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '25515555555', 1);
INSERT INTO PIOTR.RUNNER (ID, DATEOFBIRTH, FIRSTNAME, ISMALE, LASTNAME) VALUES (140, '2006-06-05', 'Anna', 0, 'Ładna');


INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (150, 'RUNNER', 'run5@run5.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '25515555511', 1);
INSERT INTO PIOTR.RUNNER (ID, DATEOFBIRTH, FIRSTNAME, ISMALE, LASTNAME) VALUES (150, '2006-06-05', 'Walerian', 0, 'Zgrabny');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (120, 'RUNNER', 'run6@run6.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '99515555511', 1);
INSERT INTO PIOTR.RUNNER (ID, DATEOFBIRTH, FIRSTNAME, ISMALE, LASTNAME) VALUES (120, '2006-06-05', 'Józefina', 0, 'Powabna');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (200, 'ADMIN', 'adm1@adm1.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '232323232', 1);
INSERT INTO PIOTR."ADMIN" (ID, ADMINNAME) VALUES (200, 'ADA_RON');


INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (210, 'ADMIN', 'adm2@adm2.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '238823232', 1);
INSERT INTO PIOTR."ADMIN" (ID, ADMINNAME) VALUES (210, 'JANEK B.');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (300, 'ORGANISER', 'org1@org1.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '217787777', 1);
INSERT INTO PIOTR.ORGANISER (ID, ADRESCITY, ADRESSTREET, ADRESZIPCODE, ORGANISERNAME) VALUES (300, NULL, NULL, NULL, 'Biegalnia SA');

INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (310, 'ORGANISER', 'org2@org2.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '21777777', 1);
INSERT INTO PIOTR.ORGANISER (ID, ADRESCITY, ADRESSTREET, ADRESZIPCODE, ORGANISERNAME) VALUES (310, NULL, NULL, NULL, 'Biegowo Sp. z o.o.');


INSERT INTO PIOTR.UZER (ID, "TYPE", EMAIL, PASSWORD, PHONE, VERSION) VALUES (320, 'ORGANISER', 'org3@org3.pl', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '21777777', 1);
INSERT INTO PIOTR.ORGANISER (ID, ADRESCITY, ADRESSTREET, ADRESZIPCODE, ORGANISERNAME) VALUES (320, NULL, NULL, NULL, 'Nasze Biegi - Fundacja');



INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (1000, NULL, 'Płock', NULL, 0, '2018-08-31 23:00:00.0', 0, 44.0, NULL, NULL, 'BIEG Nocny 44', 0, NULL, 3, 'Bieg44', 1, 320);


INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (1100, NULL, 'Płock', NULL, 0, '2018-09-30 23:00:00.0', 0, 44.0, NULL, NULL, 'BIEG Nocny 44 - II edycja', 0, NULL, 3, 'Bieg44 - 2', 1, 320);

INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (1400, NULL, 'Wawa', NULL, 0, '2018-09-22 11:00:00.0', 0, 10.0, NULL, NULL, 'Dyszka Wawska', 1, NULL, 3, 'Dyszka', 1, 310);


INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (1200, NULL, 'Łódź', NULL, 0, '2018-10-22 13:30:00.0', 0, 21.1, NULL, NULL, 'Łódzka połówka maratony', 1, NULL, 3, 'Łódż Półaraton', 1, 300);

INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (1300, NULL, 'Widawa', NULL, 0, '2018-09-07 11:00:00.0', 0, 10.0, NULL, NULL, 'Dyszka w Widawie', 1, NULL, 3, 'Dyszka Widawska', 1, 310);

INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (2300, NULL, 'Łódź', NULL, 0, '2018-11-07 11:00:00.0', 0, 5.0, NULL, NULL, 'Łódzka 5tka', 1, NULL, 3, 'Łódz na 5', 0, 310);

INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (3300, NULL, 'Łódź', NULL, 0, '2019-01-07 11:00:00.0', 0, 5.0, NULL, NULL, 'Łódzka 5tka 3 edycja', 1, NULL, 3, 'Łódz na 5-3', 0, 310);

INSERT INTO PIOTR.COURSE (ID, ADDRESSOFRUNOFFICE, CITYOFCOURS, CITYOFRUNOFFICE, CLIMB, DATEOFSTART, DESCENT, DISTANCE, EMAIL, INFO, "NAME", PAYMENTREQUIRED, PHONE, RUNNERSLIMIT, SHORTNAME, VERSION, ID_ORGANISER) 
	VALUES (4300, NULL, 'Łódź', NULL, 0, '2018-12-07 11:00:00.0', 0, 5.0, NULL, NULL, 'Łódzka 5tka 2 edycja', 1, NULL, 3, 'Łódz na 5-2', 0, 310);

INSERT INTO PIOTR.PAYMENT (ID, COURSEPAYED, VERSION, ID_COURSE, ID_RUNNER) VALUES (10000, 1, 1, 1300, 110);
INSERT INTO PIOTR.PAYMENT (ID, COURSEPAYED, VERSION, ID_COURSE, ID_RUNNER) VALUES (11000, 0, 1, 1300, 120);
INSERT INTO PIOTR.PAYMENT (ID, COURSEPAYED, VERSION, ID_COURSE, ID_RUNNER) VALUES (12000, 1, 1, 1300, 130);
INSERT INTO PIOTR.PAYMENT (ID, COURSEPAYED, VERSION, ID_COURSE, ID_RUNNER) VALUES (13000, 0, 1, 1200, 110);

INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12221, 'sunny',100 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12222, 'sunny',110 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12223, 'sunny',120 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12224, 'sunny',130 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12225, 'sunny',140 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12226, 'sunny',150 , 1);

INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12227, 'sunny',200 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12228, 'sunny',210 , 1);

INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12230, 'sunny',310 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12231, 'sunny',300 , 1);
INSERT INTO PIOTR.UZERTHEME (ID, THEME, UZERID, VERSION) VALUES (12232, 'sunny',320 , 1);
