-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2021 a las 22:28:34
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

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

--
-- Volcado de datos para la tabla `artistas_funciones`
--

INSERT INTO `artistas_funciones` (`idFuncion`, `idUsuario`) VALUES
(30, 4),
(30, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canjes_tres_por_uno`
--

CREATE TABLE `canjes_tres_por_uno` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idFuncionObtenida` int(11) DEFAULT NULL,
  `funcionesCanjeadas` varchar(20) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL
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
(4, 'Alternativo'),
(3, 'Clasico'),
(2, 'Pop'),
(1, 'Rock');

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
('www.jaime.com', 'jaimeross', 'La nueva descripcion de Jaime', 'La biografia de Jaime'),
('http://localhost:8080/webV2/usuario/miperfil.jsp', 'shakira', 'La descripcion de Shakira nueva', 'La biografia de Shakira'),
('www.enanovela.com', 'enanodelavela', 'La descripcion de enano de la vela', 'La biografia del enano'),
('www.queen.com', 'fredy', 'La descripcion de Fredy', 'La biografia de Fredy'),
('www.beatles.com', 'paulmakarni', 'La descripcion de Paul', 'La biografia de los Beatles'),
('https://es.wikipedia.org/wiki/Elvis_Presley', 'elvis', 'El rey del rock', 'Una gran biografia');

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
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `espectaculos`
--

INSERT INTO `espectaculos` (`espectadoresMinimos`, `url`, `costo`, `nombre`, `id`, `duracion`, `descripcion`, `fechaRegistro`, `idUsuario`, `idPlataforma`, `espectadoresMaximos`, `idCategoria`, `estado`, `imagen`) VALUES
(100, 'www.superjaime.com', '1000', 'Jaime Ross online', 1, 90, 'Jaime Ross nuevo disco', '2021-10-07', 1, 1, 1000, 1, 'aceptado', 'jaimerossonline.jpg'),
(1, 'www.superpique.com', '1001', 'Shakira en twitch', 2, 60, 'Shakira y Pique', '2021-10-07', 2, 3, 3, 1, 'aceptado', 'shakiraentwitch.jpg'),
(2, 'www.shakira.com', '4', 'Shakira recien ingresado', 3, 1, 'la descripcion del espectaculo de shakira', '2021-10-13', 2, 1, 100, 4, 'ingresado', 'Shakirashakira2.jpg'),
(100, 'www.shakira.com', '1245', 'Shakira cantando bien', 5, 90, 'la descripcion del espectaculo de shakira', '2021-10-13', 2, 1, 500, 2, 'aceptado', 'shakiraacompaniada.jpg'),
(100, 'www.shakira.com', '250', 'Shakira cantando mal', 6, 90, 'la descripcion del espectaculo de shakira', '2021-10-13', 2, 2, 500, 4, 'rechazado', 'Shakirashakira2.jpg'),
(100, 'url', '340', 'Shakira en vivio', 9, 45, 'descripcion', '2021-10-13', 2, 2, 500, 4, 'aceptado', 'shakirashow.jpg'),
(100, 'url', '340', 'Shakira en vivo 2', 10, 45, 'descripcion', '2021-10-13', 2, 2, 500, 4, 'aceptado', 'shakiravivo.jpg'),
(120, 'www.shakira.com', '450', 'Shakira clásico', 11, 80, 'Shakira cantando musica clásica', '2021-10-19', 2, 2, 240, 3, 'ingresado', 'Shakiraclasico.jpg'),
(100, 'www.twitch.com', '1000', 'El pollo asado nos ataca?', 12, 120, 'Descripcion de Twitch', '2022-01-01', 5, 3, 125, 4, 'Aceptado', 'imagen'),
(150, 'www.twitch.com', '100', 'Secuelas del pollo', 13, 180, 'Descripcion de Twitch', '2022-03-01', 5, 3, 200, 4, 'Ingresado', 'imagen'),
(50, 'www.twitch.com', '300', 'Pesca de lombrices', 14, 240, 'Descripcion de Twitch', '2025-02-01', 3, 3, 75, 4, 'Aceptado', 'imagen');

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

--
-- Volcado de datos para la tabla `espectadores_funciones`
--

INSERT INTO `espectadores_funciones` (`idFuncion`, `idUsuario`, `fechaRegistro`, `costo`) VALUES
(4, 2, '2021-10-21 21:43:47', '1200'),
(4, 34, '2021-10-21 03:00:00', '1001'),
(1, 1, '2021-10-21 15:14:16', '100'),
(4, 1, '2021-10-22 12:01:20', '200'),
(5, 1, '2021-10-22 12:01:41', '345'),
(30, 35, '2021-11-13 03:00:00', '300'),
(30, 34, '2021-11-13 03:00:00', '300'),
(30, 12, '2021-11-13 03:00:00', '300'),
(30, 15, '2021-11-13 03:00:00', '300'),
(30, 6, '2021-11-13 03:00:00', '300'),
(30, 8, '2021-11-13 03:00:00', '300');

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
  `imagen` varchar(255) DEFAULT NULL,
  `sorteo` tinyint(1) DEFAULT NULL,
  `descripcionPremios` varchar(255) DEFAULT NULL,
  `cantidadPremios` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `funciones`
--

INSERT INTO `funciones` (`idEspectaculo`, `fechaRegistro`, `id`, `fechaInicio`, `nombre`, `imagen`, `sorteo`, `descripcionPremios`, `cantidadPremios`) VALUES
(5, '2021-10-14 00:00:00', 1, '2021-10-24 00:00:00', 'Shakira el domingo', NULL, 1, NULL, NULL),
(2, '2021-10-15 00:00:00', 4, '2021-10-19 00:00:00', 'Shakira el martes', NULL, 1, 'Pañuelo usado', 2),
(9, '2021-10-19 00:00:00', 5, '2021-10-28 00:00:00', 'Funcion el Jueves', NULL, 0, NULL, NULL),
(10, '2021-10-19 00:00:00', 6, '2021-10-31 00:00:00', 'Shakira el Domingo de tarde', NULL, NULL, NULL, NULL),
(5, '2021-10-14 00:00:00', 7, '2021-10-25 00:00:00', 'Shakira el Lunes', NULL, NULL, NULL, NULL),
(5, '2021-10-14 00:00:00', 8, '2021-10-26 21:30:00', 'Shakira el Martes 2', NULL, NULL, NULL, NULL),
(5, '2021-10-14 00:00:00', 9, '2021-10-27 22:30:00', 'Shakira el Miercoles', NULL, NULL, NULL, NULL),
(5, '2021-10-14 00:00:00', 10, '2021-10-28 21:00:00', 'Shakira el Jueves 2', NULL, NULL, NULL, NULL),
(5, '2021-10-14 00:00:00', 11, '2021-10-29 21:00:00', 'Shakira el Viernes', NULL, NULL, NULL, NULL),
(2, '2021-10-15 00:00:00', 12, '2021-11-25 00:00:00', 'Shakira con Pique el Lunes', NULL, NULL, NULL, NULL),
(2, '2021-10-15 00:00:00', 13, '2021-11-26 00:00:00', 'Shakira con Pique el Martes', NULL, NULL, NULL, NULL),
(2, '2021-10-15 00:00:00', 14, '2021-11-27 00:00:00', 'Shakira con Pique el Miercoles', NULL, NULL, NULL, NULL),
(2, '2021-10-15 00:00:00', 15, '2021-11-28 00:00:00', 'Shakira con Pique el Jueves', NULL, NULL, NULL, NULL),
(9, '2021-10-15 00:00:00', 16, '2021-12-25 00:00:00', 'Shakira Shakira en vivio el Lunes', NULL, NULL, NULL, NULL),
(9, '2021-10-15 00:00:00', 17, '2021-12-26 00:00:00', 'Shakira Shakira en vivio el Martes', NULL, NULL, NULL, NULL),
(9, '2021-10-15 00:00:00', 18, '2021-12-27 00:00:00', 'Shakira Shakira en vivio el Miercoles', NULL, NULL, NULL, NULL),
(9, '2021-10-15 00:00:00', 19, '2021-12-28 00:00:00', 'Shakira Shakira en vivio el Jueves', NULL, NULL, NULL, NULL),
(1, '2021-10-15 00:00:00', 20, '2021-11-15 00:00:00', 'Jaime con los murguistas funcion 1', NULL, NULL, NULL, NULL),
(1, '2021-10-15 00:00:00', 21, '2021-11-16 00:00:00', 'Jaime con los murguistas funcion 2', NULL, NULL, NULL, NULL),
(1, '2021-10-15 00:00:00', 22, '2021-11-17 00:00:00', 'Jaime con los murguistas funcion 3', NULL, NULL, NULL, NULL),
(1, '2021-10-15 00:00:00', 23, '2021-11-18 00:00:00', 'Jaime con los murguistas funcion 4', NULL, NULL, NULL, NULL),
(1, '2021-10-15 00:00:00', 24, '2021-11-19 00:00:00', 'Jaime con los murguistas funcion 5', NULL, NULL, NULL, NULL),
(10, '2022-01-15 00:00:00', 25, '2022-01-25 00:00:00', 'Shakira Shakira en vivio 2 el Lunes', NULL, NULL, NULL, NULL),
(10, '2021-01-15 00:00:00', 26, '2021-01-26 00:00:00', 'Shakira Shakira en vivio 2 el Martes', NULL, NULL, NULL, NULL),
(10, '2021-01-15 00:00:00', 27, '2021-01-27 00:00:00', 'Shakira Shakira en vivio 2 el Miercoles', NULL, NULL, NULL, NULL),
(10, '2021-01-15 00:00:00', 28, '2021-01-28 00:00:00', 'Shakira Shakira en vivio 2 el Jueves', NULL, NULL, NULL, NULL),
(12, '2021-11-13 00:00:00', 29, '2022-01-01 00:00:00', '1er Acto - Desplumar al pollo', 'imagen', NULL, NULL, NULL),
(14, '2021-01-01 00:00:00', 30, '2021-01-21 00:00:00', 'Worms', 'imagen', 1, NULL, NULL);

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
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes`
--

INSERT INTO `paquetes` (`fechaFin`, `nombre`, `id`, `descripcion`, `fechaInicio`, `descuento`, `fechaRegistro`, `imagen`) VALUES
('2022-10-12', 'Paqueton Shakira', 1, 'Descripcion Prueba paquete Shakira', '2021-10-19', '20.00', '2021-10-18 00:00:00', 'Paquete1.jpg'),
('2021-10-22', 'Paqueton economico de Shakira', 2, 'Paqueton economico de Shakira para fanaticos', '2021-10-01', '12.00', '2021-10-18 00:00:00', 'Paquete2.jpg'),
('2021-10-22', 'Super paquete feliz', 3, 'Paqueton feliz de Shakira para fanaticos', '2021-10-01', '12.00', '2021-10-18 00:00:00', 'ElPaquetedeShakira.jpg'),
('2021-10-30', 'Super paqueton', 4, 'Buen paquete', '2021-10-21', '15.00', '2021-10-20 00:00:00', 'Paquete3.jpg'),
('2021-10-31', 'Paquetón Jaime Ross', 6, 'El paquete de Jaime', '2021-10-29', '30.00', '2021-10-20 00:00:00', 'Paquete4.jpg'),
('2021-10-29', 'Otro paquete de Jaime', 7, 'Otro paqueton', '2021-10-22', '45.00', '2021-10-20 00:00:00', 'Paquete5.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes_artistas`
--

CREATE TABLE `paquetes_artistas` (
  `idArtista` int(11) DEFAULT NULL,
  `idPaquete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes_artistas`
--

INSERT INTO `paquetes_artistas` (`idArtista`, `idPaquete`) VALUES
(1, 6),
(1, 7);

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
(1, 7),
(2, 3),
(5, 2),
(5, 3),
(5, 4),
(9, 2),
(9, 3),
(10, 2),
(10, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes_espectaculos_utilizados`
--

CREATE TABLE `paquetes_espectaculos_utilizados` (
  `idUsuario` int(11) DEFAULT NULL,
  `idPaquete` int(11) DEFAULT NULL,
  `idEspectaculo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes_usuarios`
--

CREATE TABLE `paquetes_usuarios` (
  `fechaRegistro` datetime DEFAULT NULL,
  `idPaquete` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes_usuarios`
--

INSERT INTO `paquetes_usuarios` (`fechaRegistro`, `idPaquete`, `idUsuario`) VALUES
('2021-10-22 23:20:04', 1, 1),
('2021-10-22 23:20:06', 2, 1),
('2021-10-22 23:20:07', 3, 1),
('2021-10-22 23:20:08', 4, 1),
('2021-10-22 23:20:09', 6, 1),
('2021-10-22 23:20:10', 7, 1),
('2021-10-20 15:40:43', 1, 2),
('2021-10-20 19:13:57', 3, 16);

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
('www.Facebook.com', 1, 'Facebook', 'Descripcion de Facebook'),
('www.twitter.com', 2, 'Twitter', 'Descripcion de Twitter'),
('www.twitch.com', 3, 'Twitch', 'Descripcion de Twitch');

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
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 1, 'artista', 'Ross', 'jaimeross', 'Jaime', 'jaimito@gmail.com', '2021-10-07', 'jaimeross.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 2, 'artista', 'Shakira', 'shakira', 'shakira', 'shakira@gmail.com', '2021-10-07', 'shakira.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 3, 'artista', 'De la vela', 'enanodelavela', 'Enano', 'enanodepresivo@gmail.com', '2021-10-07', 'enanodelavela.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 4, 'artista', 'Mercury', 'fredy', 'Fredy', 'fredyqueen@gmail.com', '2021-10-07', 'fredy.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 5, 'artista', 'LaCarni', 'paulmakarni', 'Pon', 'paul@beatles.com', '2021-10-07', 'paulmakarni.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 6, 'espectador', 'Desprolijo bueno', 'charlygood', 'Carlos', 'charlygood@penadoy.com', '2021-10-07', 'charlygood.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 7, 'espectador', 'Castro', 'elchory', 'No me acuerdo', 'chori@naciomal.com', '2021-10-07', 'elchory.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 8, 'espectador', 'Forlan', 'cachibacha', 'Diego10', 'diego@teRajaronAPatadasDelDelManya.com', '2021-10-07', 'cachibacha.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 9, 'espectador', 'Suarez', 'lucho', 'Luis', 'luisito@paraDeMorder.com', '2021-10-07', 'lucho.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 10, 'espectador', 'Balotelli', 'mario', 'Mario', 'marito@hagocagadas.com', '2021-10-07', 'mario.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 11, 'artista', 'Presley', 'elvis', 'Elvis', 'elvis@fenomeno.com', '2021-10-07', 'elvis.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 12, 'espectador', 'afdads', 'elnicknameloco', 'Fede', 'dsafadsf@hom.com', '2021-10-08', 'elnicknameloco.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 13, 'espectador', 'adsf', 'user1', 'adsf', 'dsafadsf@hosm.com', '2021-10-08', 'user1.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 14, 'espectador', 'adsfadfa', 'sholooo', 'adsfasdf', 'dsafadsf@hotmail.com', '2021-10-07', 'sholooo.jpg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 15, 'espectador', 'Imba', 'colimba', 'Col', 'hola@hola.com', '2021-10-04', 'colimba.jpeg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 16, 'espectador', 'Traiman', 'fede', 'Federico', 'fede@montevideo.com.uy', '2021-10-06', 'fede.jpeg'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 17, 'espectador', 'Nombre prueba', 'prueba', 'Nombre prueba', 'prueba@prueba.com', '2021-10-04', 'prueba.png'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 34, 'espectador', 'Messi', 'messi', 'Lionel', 'messi@messi.com', '2000-08-11', 'messi.png'),
('a35b1968765a9df8ab3fbb183fb26c44869f84404e2b68e47ba09f646141870c212f2a392e67f6c50466b0fc9068100d2ab35ee2ed39d36449b6ded24610de88', 35, 'espectador', 'Ferreira', 'haff', 'Henry', 'henryferreira133@gmail.com', '1999-12-06', 'haff.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_ganadores`
--

CREATE TABLE `usuarios_ganadores` (
  `id` int(11) NOT NULL,
  `idUsuario` int(255) DEFAULT NULL,
  `idFuncion` int(255) DEFAULT NULL,
  `premio` varchar(255) DEFAULT NULL,
  `fechaSorteo` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios_ganadores`
--

INSERT INTO `usuarios_ganadores` (`id`, `idUsuario`, `idFuncion`, `premio`, `fechaSorteo`) VALUES
(13, 1, 4, 'Pañuelo usado', '2021-11-14'),
(14, 34, 4, 'Pañuelo usado', '2021-11-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_seguidores`
--

CREATE TABLE `usuarios_seguidores` (
  `idUsuarioSeguido` int(11) NOT NULL,
  `idUsuarioSeguidor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios_seguidores`
--

INSERT INTO `usuarios_seguidores` (`idUsuarioSeguido`, `idUsuarioSeguidor`) VALUES
(1, 2),
(1, 4),
(1, 6),
(1, 7),
(1, 13),
(1, 16),
(2, 5),
(3, 1),
(6, 5),
(6, 8),
(6, 11),
(11, 16),
(16, 2),
(16, 4),
(16, 6);

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
-- Indices de la tabla `canjes_tres_por_uno`
--
ALTER TABLE `canjes_tres_por_uno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `canjes_tres_por_uno_usuarios_id_fk` (`idUsuario`);

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
  ADD KEY `espectaculos_categorias_id_fk` (`idCategoria`),
  ADD KEY `espectaculos_plataformas_id_fk` (`idPlataforma`),
  ADD KEY `espectaculos_artistas_id_fk` (`idUsuario`);

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
-- Indices de la tabla `paquetes_artistas`
--
ALTER TABLE `paquetes_artistas`
  ADD UNIQUE KEY `paquetes_artistas_pk` (`idArtista`,`idPaquete`),
  ADD KEY `paquetes_artistas_paquetes_id_fk` (`idPaquete`);

--
-- Indices de la tabla `paquetes_espectaculos`
--
ALTER TABLE `paquetes_espectaculos`
  ADD UNIQUE KEY `paquetes_espectaculos_pk` (`idEspectaculo`,`idPaquete`),
  ADD KEY `paquetes_espectaculos_paquetes_id_fk` (`idPaquete`);

--
-- Indices de la tabla `paquetes_espectaculos_utilizados`
--
ALTER TABLE `paquetes_espectaculos_utilizados`
  ADD KEY `paquetes_espectaculos_utilizados_espectaculos_id_fk` (`idEspectaculo`),
  ADD KEY `paquetes_espectaculos_utilizados_paquetes_id_fk` (`idPaquete`),
  ADD KEY `paquetes_espectaculos_utilizados_usuarios_id_fk` (`idUsuario`);

--
-- Indices de la tabla `paquetes_usuarios`
--
ALTER TABLE `paquetes_usuarios`
  ADD PRIMARY KEY (`idUsuario`,`idPaquete`),
  ADD KEY `paquetes_espectadores_paquetes_id_fk` (`idPaquete`);

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
-- Indices de la tabla `usuarios_ganadores`
--
ALTER TABLE `usuarios_ganadores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idFuncion` (`idFuncion`);

--
-- Indices de la tabla `usuarios_seguidores`
--
ALTER TABLE `usuarios_seguidores`
  ADD UNIQUE KEY `usuarios_seguidores_pk` (`idUsuarioSeguido`,`idUsuarioSeguidor`),
  ADD KEY `usuarios_seguidores_usuarios_id_fk` (`idUsuarioSeguidor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `canjes_tres_por_uno`
--
ALTER TABLE `canjes_tres_por_uno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `funciones`
--
ALTER TABLE `funciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `plataformas`
--
ALTER TABLE `plataformas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `usuarios_ganadores`
--
ALTER TABLE `usuarios_ganadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

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
-- Filtros para la tabla `canjes_tres_por_uno`
--
ALTER TABLE `canjes_tres_por_uno`
  ADD CONSTRAINT `canjes_tres_por_uno_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

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
-- Filtros para la tabla `paquetes_artistas`
--
ALTER TABLE `paquetes_artistas`
  ADD CONSTRAINT `paquetes_artistas_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`),
  ADD CONSTRAINT `paquetes_artistas_usuarios_id_fk` FOREIGN KEY (`idArtista`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `paquetes_espectaculos`
--
ALTER TABLE `paquetes_espectaculos`
  ADD CONSTRAINT `paquetes_espectaculos_espectaculos_id_fk` FOREIGN KEY (`idEspectaculo`) REFERENCES `espectaculos` (`id`),
  ADD CONSTRAINT `paquetes_espectaculos_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`);

--
-- Filtros para la tabla `paquetes_espectaculos_utilizados`
--
ALTER TABLE `paquetes_espectaculos_utilizados`
  ADD CONSTRAINT `paquetes_espectaculos_utilizados_espectaculos_id_fk` FOREIGN KEY (`idEspectaculo`) REFERENCES `espectaculos` (`id`),
  ADD CONSTRAINT `paquetes_espectaculos_utilizados_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`),
  ADD CONSTRAINT `paquetes_espectaculos_utilizados_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `paquetes_usuarios`
--
ALTER TABLE `paquetes_usuarios`
  ADD CONSTRAINT `paquetes_espectadores_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`),
  ADD CONSTRAINT `paquetes_espectadores_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios_ganadores`
--
ALTER TABLE `usuarios_ganadores`
  ADD CONSTRAINT `usuarios_ganadores_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `usuarios_ganadores_ibfk_2` FOREIGN KEY (`idFuncion`) REFERENCES `funciones` (`id`);

--
-- Filtros para la tabla `usuarios_seguidores`
--
ALTER TABLE `usuarios_seguidores`
  ADD CONSTRAINT `usuario_id_fk` FOREIGN KEY (`idUsuarioSeguido`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `usuarios_seguidores_usuarios_id_fk` FOREIGN KEY (`idUsuarioSeguidor`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
