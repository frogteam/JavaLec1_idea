
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE test_member
(
	-- 회원번호
	mb_no number,
	-- 회원이름
	mb_name varchar2(40) NOT NULL,
	-- 회원생일
	mb_birthdate date
);


/* Comments */

COMMENT ON COLUMN test_member.mb_no IS '회원번호';
COMMENT ON COLUMN test_member.mb_name IS '회원이름';
COMMENT ON COLUMN test_member.mb_birthdate IS '회원생일';

-- 시퀀스 추가
DROP SEQUENCE test_member_seq;
CREATE SEQUENCE test_member_seq;

SELECT * FROM test_member;

-- 화면 표시 세팅
SET LINESIZE 120;
SET PAGESIZE 120;
COL mb_no FOR 999;
COL mb_name FOR a10;
COL mb_birthdate FOR a14;



