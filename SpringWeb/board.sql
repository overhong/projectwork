create table board
(
   num number not null,  --글번호
   userid varchar2(50) null,  -- 사용자id
   title varchar2(50) not null,  --제목
   regdate date null,  --작성일자
   content varchar2(500) not null,   --내용
   count number null,  -- 조회수
   filename varchar2(20) null,  --파일명
   ref number null,  -- 참조글
   re_step number default 0,  
   re_level number default 0,
   primary key (num),
   foreign key(userid) references userinfo(userid)
)
CREATE TABLE USERINFO (
      USERID VARCHAR2(50) NOT NULL,
      PASSWORD VARCHAR2(50) NOT NULL,
      NAME VARCHAR2(50) NOT NULL,
      EMAIL VARCHAR2(50) NOT NULL,
      ROLE VARCHAR2(20)
   );

CREATE UNIQUE INDEX SYS_C0010823 ON USERINFO (USERID ASC);

ALTER TABLE USERINFO ADD CONSTRAINT SYS_C0010823 PRIMARY KEY (USERID);



--시퀀스 설정
create sequence board_seq 
increment by 1
start with 1
maxvalue 10000;

insert into board(num, userid, title, regdate, 
content, count, filename, ref, re_step, re_level)
values(
board_seq.nextval,'dugohr89','제목입니다',sysdate,'내용입니다',0,'이승철.jpg',1,1,1
)

select * from board order by num desc
select * from userinfo;
delete from userinfo where userid like '%mail%';

select * from (
select a.*, rownum rnum
from
(select * from board
order by num desc)a)
where rnum>=1 and rnum<=5

select * from board order by num asc


insert into USERINFO values('test6','6','hong1','hong6@naver.com')
insert into USERINFO values('test7','7','7','7@naver.com')
insert into USERINFO values('test8','7','hong8','hong8@naver.com')
insert into USERINFO values('neckon','83mapka1217','양재홍','overhong@hotmail.com','admin')

select * from USERINFO

alter table userInfo add (role varchar2(20))--role이란 컬럼 추가

create table boardFile(
	num number(22,0) not null primary key,
	boardnum number(22,0) not null,
	filename varchar2(100)
);
select * from boardFile

CREATE SEQUENCE BOARDFILE_SEQ;--시쿼드 디폴트는 1이다.

ALTER TABLE BOARDFILE 
ADD CONSTRAINT FK_BOARDFILE FOREIGN KEY (BOARDNUM)
   REFERENCES BOARD (NUM);





















