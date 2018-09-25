DROP TABLE IF EXISTS RUOTA;
DROP TABLE IF EXISTS ESTRAZIONE;
DROP TABLE IF EXISTS JOB_CONFIG;
DROP TABLE IF EXISTS STEP_CONFIG;
DROP SEQUENCE IF EXISTS ID_JOB_SEQ;
DROP SEQUENCE IF EXISTS ID_STEP_SEQ;
DROP SEQUENCE IF EXISTS ID_RUOTA_SEQ;
DROP SEQUENCE IF EXISTS ID_ESTRAZIONE_SEQ;

CREATE TABLE JOB_CONFIG (
	ID NUMBER,
	NAME VARCHAR(255),
	PARAMETERS VARCHAR(4000),
	INSERT_TS TIMESTAMP
);

CREATE TABLE STEP_CONFIG (
	ID NUMBER,
	JOB_ID NUMBER,
	NAME VARCHAR(255),
	EXECUTION_ORDER NUMBER,
	CONFIG VARCHAR(4000),
	TYPE VARCHAR(10),
	INSERT_TS TIMESTAMP
);

CREATE TABLE RUOTA (
	ID INTEGER,
	DESCRIZIONE VARCHAR(20),
	DESCRIZIONE_BREVE VARCHAR(2),
	PRIMO_UTILIZZO DATE
);

CREATE TABLE ESTRAZIONE (
	ID INTEGER,
	DATA_ESTRAZIONE DATE,
	RUOTA VARCHAR(2),
	COLONNA1 VARCHAR,
	COLONNA2 VARCHAR,
	COLONNA3 VARCHAR,
	COLONNA4 VARCHAR,
	COLONNA5 VARCHAR
);

CREATE SEQUENCE ID_JOB_SEQ 			START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE ID_STEP_SEQ 		START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE ID_RUOTA_SEQ 		START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE ID_ESTRAZIONE_SEQ 	START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;