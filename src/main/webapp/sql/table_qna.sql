
create table jboard_qna(
    board_qna_num number(10) not null,
    title varchar2(150) not null,
    content clob not null,
    hit number(5) not null,
    viewable_check number(1) not null,
    reg_date date default sysdate not null,
    modify_date date,
    filename varchar2(150),
    ip varchar2(40) not null,
    user_num number(10) not null,
    constraint jboard_qna_pk primary key(board_qna_num),
    constraint jboard_qna_fk foreign key(user_num) references juser(user_num)
);

create sequence jboard_qna_seq;

create table jboard_qna_comment(
    qna_comment_num number(10) not null,
    board_qna_num number(10) not null,
    content varchar2(300) not null,
    reg_date date default sysdate not null,
    modify_date date,
    user_num number(10) not null,
    constraint jboard_qna_comment_pk primary key(qna_comment_num),
    constraint jboard_qna_comment_fk foreign key(board_qna_num) references jboard_qna(board_qna_num),
    constraint jboard_qna_comment_fk2 foreign key(user_num) references juser(user_num)
);

create sequence jboard_qna_comment_seq;