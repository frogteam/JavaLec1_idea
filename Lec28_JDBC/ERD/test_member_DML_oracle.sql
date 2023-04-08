-- 오라클에서 여러 레코드를 한번에 INSERT 하기 
-- INSERT ALL 구문

INSERT INTO test_member VALUES(10, '김철수', SYSDATE)  -- 여러번 하기

-- 한꺼번에는 안된다?  이클립스 문제일듯
INSERT INTO test_member VALUES(5, '박현희', '1994-02-21')
INSERT INTO test_member VALUES(345, '최설현', '1994-02-21')
INSERT INTO test_member VALUES(9, '', '1994-02-21')
INSERT INTO test_member VALUES('', '서  준', '')
INSERT INTO test_member VALUES('', '아이언맨', '1994-02-21')



INSERT ALL
	INTO test_member VALUES(10, '김철수', '1994-02-21')
	INTO test_member VALUES(5, '박현희', '1994-02-21')
	INTO test_member VALUES(345, '최설현', '1994-02-21')
	INTO test_member VALUES(9, '', '1994-02-21')
	INTO test_member VALUES('', '서  준', '')
	INTO test_member VALUES('', '아이언맨', '1994-02-21')
SELECT * 
	FROM dual
;


-- 중간중간에 NULL 이 있다.
SELECT * FROM test_member;


SET LINESIZE 120;
SET PAGESIZE 200;
COL mb_no FOR 999;
COL mb_name FOR a12;
COL mb_birth FOR a10;

