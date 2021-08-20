create table paquetes
(
	fechaFin date null,
	nombre varchar(255) null,
	id int auto_increment
		primary key,
	descripcion varchar(255) null,
	fechaInicio date null,
	descuento decimal(10,2) null,
	constraint paquetes_nombre_uindex
		unique (nombre)
);

create table plataformas
(
	url varchar(255) null,
	id int auto_increment
		primary key,
	nombre varchar(255) null,
	descripcion varchar(255) null,
	constraint plataformas_nombre_uindex
		unique (nombre)
);

create table usuarios
(
	clave varchar(255) null,
	id int auto_increment
		primary key,
	tipo varchar(255) not null,
	apellido varchar(255) not null,
	nickname varchar(255) not null,
	nombre varchar(255) not null,
	email varchar(255) null,
	fechaNacimiento date not null,
	constraint espectadores_email_uindex
		unique (email),
	constraint espectadores_nickname_uindex
		unique (nickname)
);

create table datos_artistas
(
	linkUsuario varchar(255) null,
	nickname varchar(255) not null,
	descripcion varchar(255) null,
	biografia varchar(255) null,
	constraint datos_artistas_usuarios_nickname_fk
		foreign key (nickname) references usuarios (nickname)
);

create table espectaculos
(
	espectadoresMinimos int null,
	url varchar(255) null,
	costo decimal(19) null,
	nombre varchar(255) null,
	id int auto_increment
		primary key,
	duracion int not null,
	descripcion varchar(255) null,
	fechaRegistro date null,
	idUsuario int null,
	idPlataforma int null,
	espectadoresMaximos int null,
	constraint espectaculos_nombre_uindex
		unique (nombre),
	constraint espectaculos_plataformas_id_fk
		foreign key (idPlataforma) references plataformas (id),
	constraint espectaculos_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
);

create index espectaculos_artistas_id_fk
	on espectaculos (idUsuario);

create table funciones
(
	idEspectaculo int null,
	fechaRegistro datetime null,
	id int auto_increment
		primary key,
	fechaInicio datetime null,
	nombre varchar(255) not null,
	constraint funciones_nombre_uindex
		unique (nombre),
	constraint funciones_espectaculos_id_fk
		foreign key (idEspectaculo) references espectaculos (id)
);

create table artistas_funciones
(
	idFuncion int null,
	idUsuario int null,
	constraint artistas_funciones_funciones_id_fk
		foreign key (idFuncion) references funciones (id),
	constraint artistas_funciones_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
);

create table espectadores_funciones
(
	idFuncion int null,
	idUsuario int null,
	constraint espectadores_funciones_funciones_id_fk
		foreign key (idFuncion) references funciones (id),
	constraint espectadores_funciones_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
);

create table paquetes_espectaculos
(
	idEspectaculo int null,
	idPaquete int null,
	constraint paquetes_espectaculos_pk
		unique (idEspectaculo, idPaquete),
	constraint paquetes_espectaculos_espectaculos_id_fk
		foreign key (idEspectaculo) references espectaculos (id),
	constraint paquetes_espectaculos_paquetes_id_fk
		foreign key (idPaquete) references paquetes (id)
);

create table paquetes_usuarios
(
	fechaRegistro datetime null,
	idPaquete int null,
	idUsuario int null,
	constraint paquetes_espectadores_paquetes_id_fk
		foreign key (idPaquete) references paquetes (id),
	constraint paquetes_espectadores_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
);

