-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2021 at 02:53 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coronatickets`
--

-- --------------------------------------------------------

--
-- Table structure for table `artistas_funciones`
--

CREATE TABLE `artistas_funciones` (
  `idFuncion` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `datos_artistas`
--

CREATE TABLE `datos_artistas` (
  `linkUsuario` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `biografia` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `espectaculos`
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
  `estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `espectadores_funciones`
--

CREATE TABLE `espectadores_funciones` (
  `idFuncion` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaRegistro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `costo` decimal(19,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `funciones`
--

CREATE TABLE `funciones` (
  `idEspectaculo` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `id` int(11) NOT NULL,
  `fechaInicio` datetime DEFAULT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paquetes`
--

CREATE TABLE `paquetes` (
  `fechaFin` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paquetes_espectaculos`
--

CREATE TABLE `paquetes_espectaculos` (
  `idEspectaculo` int(11) DEFAULT NULL,
  `idPaquete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paquetes_usuarios`
--

CREATE TABLE `paquetes_usuarios` (
  `fechaRegistro` datetime DEFAULT NULL,
  `idPaquete` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `plataformas`
--

CREATE TABLE `plataformas` (
  `url` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
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

-- --------------------------------------------------------

--
-- Table structure for table `usuarios_seguidores`
--

CREATE TABLE `usuarios_seguidores` (
  `idUsuario` int(11) NOT NULL,
  `idSeguidor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artistas_funciones`
--
ALTER TABLE `artistas_funciones`
  ADD KEY `artistas_funciones_funciones_id_fk` (`idFuncion`),
  ADD KEY `artistas_funciones_usuarios_id_fk` (`idUsuario`);

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `categorias_nombre_unidex` (`nombre`);

--
-- Indexes for table `datos_artistas`
--
ALTER TABLE `datos_artistas`
  ADD KEY `datos_artistas_usuarios_nickname_fk` (`nickname`);

--
-- Indexes for table `espectaculos`
--
ALTER TABLE `espectaculos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `espectaculos_nombre_uindex` (`nombre`),
  ADD KEY `espectaculos_plataformas_id_fk` (`idPlataforma`),
  ADD KEY `espectaculos_artistas_id_fk` (`idUsuario`),
  ADD KEY `espectaculos_categorias_id_fk` (`idCategoria`);

--
-- Indexes for table `espectadores_funciones`
--
ALTER TABLE `espectadores_funciones`
  ADD UNIQUE KEY `espectadores_funciones_pk` (`idFuncion`,`idUsuario`),
  ADD KEY `espectadores_funciones_usuarios_id_fk` (`idUsuario`);

--
-- Indexes for table `funciones`
--
ALTER TABLE `funciones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `funciones_nombre_uindex` (`nombre`),
  ADD KEY `funciones_espectaculos_id_fk` (`idEspectaculo`);

--
-- Indexes for table `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `paquetes_nombre_uindex` (`nombre`);

--
-- Indexes for table `paquetes_espectaculos`
--
ALTER TABLE `paquetes_espectaculos`
  ADD UNIQUE KEY `paquetes_espectaculos_pk` (`idEspectaculo`,`idPaquete`),
  ADD KEY `paquetes_espectaculos_paquetes_id_fk` (`idPaquete`);

--
-- Indexes for table `paquetes_usuarios`
--
ALTER TABLE `paquetes_usuarios`
  ADD KEY `paquetes_espectadores_paquetes_id_fk` (`idPaquete`),
  ADD KEY `paquetes_espectadores_usuarios_id_fk` (`idUsuario`);

--
-- Indexes for table `plataformas`
--
ALTER TABLE `plataformas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plataformas_nombre_uindex` (`nombre`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `espectadores_nickname_uindex` (`nickname`),
  ADD UNIQUE KEY `espectadores_email_uindex` (`email`);

--
-- Indexes for table `usuarios_seguidores`
--
ALTER TABLE `usuarios_seguidores`
  ADD KEY `usuario_id_fk` (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `espectaculos`
--
ALTER TABLE `espectaculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `funciones`
--
ALTER TABLE `funciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `plataformas`
--
ALTER TABLE `plataformas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artistas_funciones`
--
ALTER TABLE `artistas_funciones`
  ADD CONSTRAINT `artistas_funciones_funciones_id_fk` FOREIGN KEY (`idFuncion`) REFERENCES `funciones` (`id`),
  ADD CONSTRAINT `artistas_funciones_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `datos_artistas`
--
ALTER TABLE `datos_artistas`
  ADD CONSTRAINT `datos_artistas_usuarios_nickname_fk` FOREIGN KEY (`nickname`) REFERENCES `usuarios` (`nickname`);

--
-- Constraints for table `espectaculos`
--
ALTER TABLE `espectaculos`
  ADD CONSTRAINT `espectaculos_categorias_id_fk` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`id`),
  ADD CONSTRAINT `espectaculos_plataformas_id_fk` FOREIGN KEY (`idPlataforma`) REFERENCES `plataformas` (`id`),
  ADD CONSTRAINT `espectaculos_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `espectadores_funciones`
--
ALTER TABLE `espectadores_funciones`
  ADD CONSTRAINT `espectadores_funciones_funciones_id_fk` FOREIGN KEY (`idFuncion`) REFERENCES `funciones` (`id`),
  ADD CONSTRAINT `espectadores_funciones_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `funciones`
--
ALTER TABLE `funciones`
  ADD CONSTRAINT `funciones_espectaculos_id_fk` FOREIGN KEY (`idEspectaculo`) REFERENCES `espectaculos` (`id`);

--
-- Constraints for table `paquetes_espectaculos`
--
ALTER TABLE `paquetes_espectaculos`
  ADD CONSTRAINT `paquetes_espectaculos_espectaculos_id_fk` FOREIGN KEY (`idEspectaculo`) REFERENCES `espectaculos` (`id`),
  ADD CONSTRAINT `paquetes_espectaculos_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`);

--
-- Constraints for table `paquetes_usuarios`
--
ALTER TABLE `paquetes_usuarios`
  ADD CONSTRAINT `paquetes_espectadores_paquetes_id_fk` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`),
  ADD CONSTRAINT `paquetes_espectadores_usuarios_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `usuarios_seguidores`
--
ALTER TABLE `usuarios_seguidores`
  ADD CONSTRAINT `usuario_id_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
