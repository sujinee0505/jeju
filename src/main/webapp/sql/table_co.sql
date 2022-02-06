/*추천 코스 테이블*/
create table jboard_co(
    board_co_num number(10) not null,
    title varchar2(150) not null,
    content clob not null,
    hit number(5) not null,
    reg_date date default sysdate not null,
    modify_date date,
    filename varchar2(150),
    ip varchar2(40) not null,
    user_num number(10) not null,
    constraint jboard_co_pk primary key(board_co_num),
    constraint jboard_co_fk foreign key(user_num) references juser(user_num)
);
create sequence jboard_co_seq;

/*추천 코스 좋아요*/
create table jboard_co_like(
    board_co_num number(10) not null,
    user_num number(10) not null,
    like1 number(1) not null,
    constraint jboard_co_like_fk foreign key(board_co_num) references jboard_co(board_co_num),
    constraint jboard_co_like_fk2 foreign key(user_num) references juser(user_num)
);

/*추천 코스 코멘트*/
create table jboard_co_comment(
    co_comment_num number(10) not null,
    board_co_num number(10) not null,
    content varchar2(300) not null,
    reg_date date default sysdate not null,
    modify_date date,
    user_num number(10) not null,
    constraint jboard_co_comment_pk primary key(co_comment_num),
    constraint jboard_co_comment_fk foreign key(board_co_num) references jboard_co(board_co_num),
    constraint jboard_co_comment_fk2 foreign key(user_num) references juser(user_num)
);

create sequence jboard_co_comment_seq;

/*추천 코스 코멘트 좋아요*/
create table jboard_co_comment_like(
    co_comment_num number(10) not null,
    user_num number(10) not null,
    like1 number(1) not null,
    constraint jboard_co_comment_like_fk foreign key(co_comment_num) references jboard_co_comment(co_comment_num),
    constraint jboard_co_comment_like_fk2 foreign key(user_num) references juser(user_num)
);
