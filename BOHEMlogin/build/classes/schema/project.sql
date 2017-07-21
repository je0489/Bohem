create table recipe(
recipeindex number,
recipetitle varchar2(1000) ,
recipesrc varchar2(1000),
recipecontent varchar2(3000),
constraint pk_recipe primary key(recipeIndex)
);

create table userinfo(
userindex number,
userid varchar2(20),
userpwd varchar2(20),
username varchar2(20),
usernum varchar2(20),
useremail varchar2(20)
constraint pk_userinfo primary key(userindex)
);

create table coment(
comentIndex number,
comentComent varchar2(100) not null,
userIndex number,
recipeIndex number,
comentDate date,
constraint pk_coment primary key(comentIndex)
);

create sequence coment_seq nocache;

ALTER TABLE coment
ADD CONSTRAINT FK_coment FOREIGN KEY(userindex)
REFERENCEs userinfo(userindex);

ALTER TABLE coment
ADD CONSTRAINT FK_coment2 FOREIGN KEY(recipeindex)
REFERENCEs recipe(recipeindex);