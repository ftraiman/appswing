-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2021 a las 05:55:43
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coronatickets`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas_funciones`
--

CREATE TABLE `artistas_funciones` (
  `idFuncion` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`) VALUES
(1, 'comedia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_artistas`
--

CREATE TABLE `datos_artistas` (
  `linkUsuario` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `biografia` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datos_artistas`
--

INSERT INTO `datos_artistas` (`linkUsuario`, `nickname`, `descripcion`, `biografia`) VALUES
('https://www.youtube.com', 'darius', 'hola', 'soy');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectaculos`
--

CREATE TABLE `espectaculos` (
  `espectadoresMinimos` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `costo` decimal(19,0) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `duracion` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idPlataforma` int(11) DEFAULT NULL,
  `espectadoresMaximos` int(11) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `espectaculos`
--

INSERT INTO `espectaculos` (`espectadoresMinimos`, `url`, `costo`, `nombre`, `id`, `duracion`, `descripcion`, `fechaRegistro`, `idUsuario`, `idPlataforma`, `espectadoresMaximos`, `idCategoria`, `estado`, `imagen`) VALUES
(2, 'https://www.youtube.com', '1', 'z', 1, 4, 'soy youtube', '2021-01-01', 1, 1, 3, 1, 'Ingresado', 'imagen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectadores_funciones`
--

CREATE TABLE `espectadores_funciones` (
  `idFuncion` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaRegistro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `costo` decimal(19,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funciones`
--

CREATE TABLE `funciones` (
  `idEspectaculo` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `id` int(11) NOT NULL,
  `fechaInicio` datetime DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `funciones`
--

INSERT INTO `funciones` (`idEspectaculo`, `fechaRegistro`, `id`, `fechaInicio`, `nombre`, `imagen`) VALUES
(1, '2021-10-06 00:00:00', 1, '2022-01-01 00:00:00', 'f1', 'imagen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE `paquetes` (
  `fechaFin` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes`
--

INSERT INTO `paquetes` (`fechaFin`, `nombre`, `id`, `descripcion`, `fechaInicio`, `descuento`, `fechaRegistro`, `imagen`) VALUES
('2021-02-02', 'paquete1', 1, 'soy un paquete', '2021-01-01', '1.00', '2021-10-06 00:00:00', 'imagen'),
('2022-01-01', 'paquete2', 3, 'dawdawd', '2021-01-01', '2.00', '2021-10-07 00:00:00', 'imagen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes_espectaculos`
--

CREATE TABLE `paquetes_espectaculos` (
  `idEspectaculo` int(11) DEFAULT NULL,
  `idPaquete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes_espectaculos`
--

INSERT INTO `paquetes_espectaculos` (`idEspectaculo`, `idPaquete`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes_usuarios`
--

CREATE TABLE `paquetes_usuarios` (
  `fechaRegistro` datetime DEFAULT NULL,
  `idPaquete` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataformas`
--

CREATE TABLE `plataformas` (
  `url` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plataformas`
--

INSERT INTO `plataformas` (`url`, `id`, `nombre`, `descripcion`) VALUES
('https://www.youtube.com', 1, 'youtube', 'soy youtube');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `clave` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`clave`, `id`, `tipo`, `apellido`, `nickname`, `nombre`, `email`, `fechaNacimiento`, `imagen`) VALUES
(NULL, 1, 'artista', 'de sosa', 'darius', 'dariel', 'darieldesosa@gmail.com', '1900-01-01', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_seguidores`
--

CREATE TABLE `usuarios_seguidores` (
  `idUsuario` int(11) NOT NULL,
  `idSeguidor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artistas_funciones`
--
ALTER TABLE `artistas_funciones`
  ADD KEY `artistas_funciones_funciones_id_fk` (`idFuncion`),
  ADD KEY `artistas_funciones_usuarios_id_fk` (`idUsuario`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `categorias_nombre_unidex` (`nombre`);

--
-- Indices de la tabla `datos_artistas`
--
ALTER TABLE `datos_artistas`
  ADD KEY `datos_artistas_usuarios_nickname_fk` (`nickname`);

--
-- Indices de la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `espectaculos_nombre_uindex` (`nombre`),
  ADD KEY `espectaculos_plataformas_id_fk` (`idPlataforma`),
  ADD KEY `espectaculos_artistas_id_fk` (`idUsuario`),
  ADD KEY `espectaculos_categorias_id_fk` (`idCategoria`);

--
-- Indices de la tabla `espectadores_funciones`
--
ALTER TABLE `espectadores_funciones`
  ADD UNIQUE KEY `espectadores_funciones_pk` (`idFuncion`,`idUsuario`),
  ADD KEY `espectadores_funciones_usuarios_id_fk` (`idUsuario`);

--
-- Indices de la tabla `funciones`
--
ALTER TABLE `funciones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `funciones_nombre_uindex` (`nombre`),
  ADD KEY `funciones_espectaculos_id_fk` (`idEspectaculo`);

--
-- Indices de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `paquetes_nombre_uindex` (`nombre`);

--
-- Indices de la tabla `paquetes_espectaculos`
--
ALTER TABLE `paquetes_espectaculos`
  ADD UNIQUE KEY `paquetes_espectaculos_pk` (`idEspectaculo`,`idPaquete`),
  ADD KEY `paquetes_espectaculos_paquetes_id_fk` (`idPaquete`);

--
-- Indices de la tabla `paquetes_usuarios`
--
ALTER TABLE `paquetes_usuarios`
  ADD KEY `paquetes_espectadores_paquetes_id_fk` (`idPaquete`),
  ADD KEY `paquetes_espectadores_usuarios_id_fk` (`idUsuario`);

--
-- Indices de la tabla `plataformas`
--
ALTER TABLE `plataformas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plataformas_nombre_uindex` (`nombre`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `espectadores_nickname_uindex` (`nickname`),
  ADD UNIQUE KEY `espectadores_email_uindex` (`email`);

--
-- Indices de la tabla `usuarios_seguidores`
--
ALTER TABLE `usuarios_seguidores`
  ADD KEY `usuario_id_fk` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `funciones`
--
ALTER TABLE `funciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `plataformas`
--
ALTER TABLE `plataformas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artistas_funciones`
--
ALTER TABLE `artistas_funciones`
  ADD CONSTRAINT `artistas_funciones_funciones_id_fk` FOREIGN KEY (`idFuncion`) REFERENCES `funciones` (`id`),
  ADD CONSTRAINT `artistas_funciones_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `datos_artistas`
--
ALTER TABLE `datos_artistas`
  ADD CONSTRAINT `datos_artistas_usuarios_nickname_fk` FOREIGN KEY (`nickname`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  ADD CONSTRAINT `espectaculos_categorias_id_fk` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`id`),
  ADD CONSTRAINT `espectaculos_plataformas_id_fk` FOREIGN KEY (`idPlataforma`) REFERENCES `plataformas` (`id`),
  ADD CONSTRAINT `espectaculos_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `espectadores_funciones`
--
ALTER TABLE `espectadores_funciones`
  ADD CONSTRAINT `espectadores_funciones_funciones_id_fk` FOREIGN KEY (`idFuncion`) REFERENCES `funciones` (`id`),
  ADD CONSTRAINT `espectadores_funciones_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `funciones`
--
ALTER TABLE `funciones`
  ADD CONSTRAINT `funciones_espectaculos_id_fk` FOREIGN KEY (`idEspectaculo`) REFERENCES `espectaculos` (`id`);

--
-- Filtros para la tabla `paquetes_espectaculos`
--
ALTER TABLE `paquetes_espectaculos`
  ADD CONSTRAINT `paquetes_espectaculos_espectaculos_id_fk` FOREIGN KEY (`idEspectaculo`) REFERENCES `espectaculos` (`id`),
  ADD CONSTRAINT `paquetes_espectaculos_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`);

--
-- Filtros para la tabla `paquetes_usuarios`
--
ALTER TABLE `paquetes_usuarios`
  ADD CONSTRAINT `paquetes_espectadores_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`),
  ADD CONSTRAINT `paquetes_espectadores_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios_seguidores`
--
ALTER TABLE `usuarios_seguidores`
  ADD CONSTRAINT `usuario_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
