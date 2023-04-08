
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE phonebook
(
	Id number NOT NULL,
	Name varchar2(40) NOT NULL,
	Phonenum varchar2(40),
	Email varchar2(80),
	RegDate date,
	PRIMARY KEY (Id)
);

-- 시퀀스 객체도 생성하자
DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;


SET LINESIZE 120;
SET PAGESIZE 150;
COL id for 9999;
COL name for a8;
COL phonenum for a14;
COL email for a18;
COL regdate for a10;





