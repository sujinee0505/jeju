create table juser(
    user_num number(10) not null,
    id varchar2(12) not null,
    auth number(10) not null,
    constraint juser_pk primary key(user_num)
);

create sequence juser_seq;

create table juser_detail(
    user_num number(10) not null,
    name varchar2(30) not null,
    passwd varchar2(12) not null,
    phone varchar2(15) not null,
    email varchar2(50) not null,
    zipcode varchar2(5) not null,
	address1 varchar2(90) not null,
	address2 varchar2(90) not null,
    photo varchar2(150),
    reg_date date default sysdate not null,
    modify_date date,
    constraint juser_detail_pk primary key(user_num),
    constraint juser_detail_fk foreign key(user_num) references juser(user_num)
);