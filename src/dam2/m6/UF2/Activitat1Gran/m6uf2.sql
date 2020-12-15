-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-12-2020 a las 19:17:58
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `m6uf2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnes`
--

CREATE TABLE `alumnes` (
  `nom` varchar(30) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `dataNaixement` date NOT NULL,
  `adreca` varchar(30) NOT NULL,
  `sexe` varchar(5) NOT NULL,
  `codiPostal` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnes`
--

INSERT INTO `alumnes` (`nom`, `dni`, `dataNaixement`, `adreca`, `sexe`, `codiPostal`) VALUES
('Yang', '123456S', '1999-11-11', 'Reus', 'Home', 43204),
('David Jose', '1237889W', '2002-02-02', 'Avenida Casas', 'Home', 43211),
('Rosa', '12738979e', '2006-05-05', 'Plaza Tarraco', 'Dona', 43211),
('Maria', '789234R', '1997-05-12', 'Carrer Vent', 'Dona', 43204),
('Ian', '78947382R', '2001-01-01', 'Hotel Trivago', 'Home', 43204);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacions`
--

CREATE TABLE `poblacions` (
  `codiPostal` int(5) NOT NULL,
  `nomPoblacio` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `poblacions`
--

INSERT INTO `poblacions` (`codiPostal`, `nomPoblacio`) VALUES
(43204, 'Reus'),
(43211, 'Tarragona');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `codiPostal` (`codiPostal`);

--
-- Indices de la tabla `poblacions`
--
ALTER TABLE `poblacions`
  ADD PRIMARY KEY (`codiPostal`),
  ADD KEY `codiPostal` (`codiPostal`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`codiPostal`) REFERENCES `poblacions` (`codiPostal`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
