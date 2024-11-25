create table user
(
    uNo       int auto_increment
        primary key,
    uId       varchar(30) not null,
    uPw       varchar(20) not null,
    uNickName varchar(10) not null,
    uMail     varchar(40) not null,
    uPhone    varchar(11) null,
    uRegionA  varchar(10) null,
    uRegionB  varchar(10) null
);

create table freeboard
(
    bNo      int auto_increment
        primary key,
    uNo      int          not null,
    bTitle   varchar(100) not null,
    bContext text         null,
    bDate    datetime     not null,
    constraint FK_user_TO_FreeBoard_1
        foreign key (uNo) references user (uNo)
);

create table freeboard_comment
(
    bcNo      int auto_increment
        primary key,
    bNo       int      not null,
    bcContent text     not null,
    uNo       int      not null,
    bcDate    datetime not null,
    constraint FK_FreeBoard_TO_FreeBoard_comment_1
        foreign key (bNo) references freeboard (bNo),
    constraint FK_user_TO_FreeBoard_comment_1
        foreign key (uNo) references user (uNo)
);

create table futsal
(
    fNo       int auto_increment
        primary key,
    fName     varchar(40)   not null,
    fRegionA  varchar(10)   not null,
    fRegionB  varchar(10)   not null,
    fAddress  varchar(100)  not null comment '지역 입력하면 앞에 자동 입력됨',
    fTime     varchar(30)   null,
    fTel      varchar(11)   null,
    uNo       int           not null,
    fImage    varchar(200)  null comment '(올릴 시 default 추가해야 함)',
    fDetail   text          null,
    fDate     datetime      not null,
    fBookMark int default 0 not null,
    constraint FK_user_TO_futsal_1
        foreign key (uNo) references user (uNo)
);

create table bookmark
(
    bmNo   int auto_increment
        primary key,
    uNo    int      not null,
    fNo    int      not null,
    bmDate datetime not null comment '날짜',
    constraint FK_futsal_TO_bookmark_1
        foreign key (fNo) references futsal (fNo),
    constraint FK_user_TO_bookmark_1
        foreign key (uNo) references user (uNo)
);

create table futsal_comment
(
    fcNo      int auto_increment
        primary key,
    fNo       int      not null,
    fcContent text     not null,
    uNo       int      not null,
    fcDate    datetime not null,
    constraint FK_futsal_TO_futsal_comment_1
        foreign key (fNo) references futsal (fNo),
    constraint FK_user_TO_futsal_comment_1
        foreign key (uNo) references user (uNo)
);

create table notice
(
    nNo      int auto_increment
        primary key,
    uNo      int          not null,
    nTitle   varchar(100) not null,
    nContext text         null,
    nDate    datetime     not null,
    constraint FK_user_TO_Notice_1
        foreign key (uNo) references user (uNo)
);


