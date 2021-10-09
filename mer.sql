create table categorias
(
	id int auto_increment
		primary key,
	nombre varchar(255) not null,
	constraint categorias_nombre_unidex
		unique (nombre)
)
charset=utf8mb4;

create table paquetes
(
	fechaFin date null,
	nombre varchar(255) null,
	id int auto_increment
		primary key,
	descripcion varchar(255) null,
	fechaInicio date null,
	descuento decimal(10,2) null,
	fechaRegistro datetime null,
	imagen varchar(255) null,
	constraint paquetes_nombre_uindex
		unique (nombre)
)
charset=utf8mb4;

create table plataformas
(
	url varchar(255) null,
	id int auto_increment
		primary key,
	nombre varchar(255) null,
	descripcion varchar(255) null,
	constraint plataformas_nombre_uindex
		unique (nombre)
)
charset=utf8mb4;

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
	imagen varchar(255) null,
	constraint espectadores_email_uindex
		unique (email),
	constraint espectadores_nickname_uindex
		unique (nickname)
)
charset=utf8mb4;

create table datos_artistas
(
	linkUsuario varchar(255) null,
	nickname varchar(255) not null,
	descripcion varchar(255) null,
	biografia varchar(255) null,
	constraint datos_artistas_usuarios_nickname_fk
		foreign key (nickname) references usuarios (nickname)
)
charset=utf8mb4;

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
	idCategoria int null,
	estado varchar(255) null,
	imagen varchar(255) null,
	constraint espectaculos_nombre_uindex
		unique (nombre),
	constraint espectaculos_categorias_id_fk
		foreign key (idCategoria) references categorias (id),
	constraint espectaculos_plataformas_id_fk
		foreign key (idPlataforma) references plataformas (id),
	constraint espectaculos_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
)
charset=utf8mb4;

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
	imagen varchar(255) null,
	constraint funciones_nombre_uindex
		unique (nombre),
	constraint funciones_espectaculos_id_fk
		foreign key (idEspectaculo) references espectaculos (id)
)
charset=utf8mb4;

create table artistas_funciones
(
	idFuncion int null,
	idUsuario int null,
	constraint artistas_funciones_funciones_id_fk
		foreign key (idFuncion) references funciones (id),
	constraint artistas_funciones_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
)
charset=utf8mb4;

create table espectadores_funciones
(
	idFuncion int null,
	idUsuario int null,
	fechaRegistro timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
	costo decimal(19) null,
	constraint espectadores_funciones_pk
		unique (idFuncion, idUsuario),
	constraint espectadores_funciones_funciones_id_fk
		foreign key (idFuncion) references funciones (id),
	constraint espectadores_funciones_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
)
charset=utf8mb4;

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
)
charset=utf8mb4;

create table paquetes_usuarios
(
	fechaRegistro datetime null,
	idPaquete int null,
	idUsuario int null,
	constraint paquetes_espectadores_paquetes_id_fk
		foreign key (idPaquete) references paquetes (id),
	constraint paquetes_espectadores_usuarios_id_fk
		foreign key (idUsuario) references usuarios (id)
)
charset=utf8mb4;

create table usuarios_seguidores
(
	idUsuarioSeguido int not null,
	idUsuarioSeguidor int not null,
	constraint usuarios_seguidores_pk
		unique (idUsuarioSeguido, idUsuarioSeguidor),
	constraint usuario_id_fk
		foreign key (idUsuarioSeguido) references usuarios (id),
	constraint usuarios_seguidores_usuarios_id_fk
		foreign key (idUsuarioSeguidor) references usuarios (id)
)
charset=utf8mb4;

