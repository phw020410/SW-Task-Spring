use prototype;

alter table record drop foreign key record_ibfk_1;
alter table workflow drop foreign key workflow_ibfk_1;

drop table if exists member;
create table member(
idx int primary key,
username varchar(32) not null,
email varchar(32) not null unique,
passwd varchar(32) not null
);

drop table if exists project;
create table project(
idx int primary key,
name varchar(32) not null,
date datetime,
author varchar(32),
content text
);

drop table if exists workflow;
create table workflow(
idx int primary key,
pro_fk int not null,
foreign key(pro_fk) references project(idx)
);

drop table if exists record;
create table record(
work_fk int not null,
foreign key (work_fk) references workflow(idx),
title varchar(32),
master varchar(32),
comment text,
date datetime default(now())
);