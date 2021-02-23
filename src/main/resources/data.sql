create table person (
id integer not null,
name varchar(255) not null,
location varchar(255) not null,
birth_date timestamp,
primary key (id)
);

insert into person(id,name,location,birth_date)
values (1,'Vali','Tashkent',now());