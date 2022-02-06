/* 회원 관리 */

create table juser(  /* 회원계정 테이블 */
	user_num number not null,
	id varchar2(10) unique not null,
	auth number (1) default 2 not null, /* 회원등급 : 0(탈퇴), 1(정지), 2(일반), 3(관리자)  */
	constraint juser_pk primary key (user_num)
);

create table juser_detail( /* 회원정보 테이블 */
	user_num number not null,
	name varchar2(30) not null,
	passwd varchar2(12) not null, /* 최대 영문 + 숫자 포함 12글자 */
	phone varchar2(15) not null,
	email varchar2(50) not null,
	zipcode varchar2(5) not null,
	address1 varchar2(90) not null, 
	address2 varchar2(90) not null,
	photo varchar2(150),
	reg_date date default sysdate not null,
	modify_date date,
	constraint juser_detail_pk primary key (user_num),
	constraint juser_detail_fk foreign key (user_num) references juser(user_num)
);

create sequence juser_seq;