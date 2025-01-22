create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(500) ,
    fechaDeCreacion varchar(200) not null,
    status tinyint(1) not null,
    autor varchar(150) not null,
    nombreCurso varchar(100) not null,
    primary key(id)
    );