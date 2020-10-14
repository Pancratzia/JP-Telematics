-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-06-2020 a las 20:14:59
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `jp_tel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditorias`
--

CREATE TABLE IF NOT EXISTS `auditorias` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `Operacion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `hora_y_fecha` datetime NOT NULL,
  PRIMARY KEY (`id_auditoria`),
  KEY `id_producto` (`id_producto`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `auditorias`
--

INSERT INTO `auditorias` (`id_auditoria`, `id_producto`, `id_usuario`, `Operacion`, `hora_y_fecha`) VALUES
(1, 1, 1, 'CREADO', '2020-06-14 00:33:30'),
(2, 2, 1, 'CREADO', '2020-06-14 00:33:52'),
(3, 3, 1, 'CREADO', '2020-06-14 14:35:53'),
(4, 4, 1, 'CREADO', '2020-06-14 14:37:08'),
(5, 5, 1, 'CREADO', '2020-06-14 14:37:54'),
(6, 6, 1, 'CREADO', '2020-06-14 14:38:50'),
(7, 7, 1, 'CREADO', '2020-06-14 14:41:00'),
(8, 8, 1, 'CREADO', '2020-06-14 14:42:56'),
(9, 9, 1, 'CREADO', '2020-06-14 14:44:13'),
(10, 8, 1, 'MODIFICADO', '2020-06-14 14:46:27'),
(11, 10, 1, 'CREADO', '2020-06-14 14:49:29'),
(12, 11, 1, 'CREADO', '2020-06-14 14:50:28'),
(13, 12, 1, 'CREADO', '2020-06-14 14:51:42'),
(14, 13, 1, 'CREADO', '2020-06-14 14:53:06'),
(15, 14, 1, 'CREADO', '2020-06-14 14:53:57'),
(16, 15, 1, 'CREADO', '2020-06-14 14:54:44'),
(17, 16, 1, 'CREADO', '2020-06-14 14:56:00'),
(18, 17, 1, 'CREADO', '2020-06-14 14:57:00'),
(19, 18, 1, 'CREADO', '2020-06-14 15:04:14'),
(20, 19, 1, 'CREADO', '2020-06-14 15:05:27'),
(21, 20, 1, 'CREADO', '2020-06-14 15:06:20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `rif` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_tipo_persona` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `borrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_vendedor` (`id_vendedor`),
  KEY `id_tipo-persona` (`id_tipo_persona`),
  KEY `id_estado` (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `rif`, `direccion`, `telefono`, `id_vendedor`, `id_tipo_persona`, `id_estado`, `borrado`) VALUES
(1, 'KATHERINNE ROMANO', '263526373', 'CALLE 4, RESIDENCIA VILLA ACROPOLIS, EL TOCUYO', '04128574584', 2, 2, 13, 0),
(2, 'DAISY COLMENARES', '219437393', 'CALLE 1, RESIDENCIA LAS FLORES, CHACAO', '04126764372', 2, 1, 15, 0),
(3, 'CRISALIDA GUTIERREZ', '274637281', 'CALLE 2, URBANIZACION LA ROSA ENTRE CARRERA 13 Y 14, PORLAMAR', '04167284931', 3, 2, 17, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE IF NOT EXISTS `departamentos` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `departamento` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `codigo` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `borrado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`id_departamento`, `departamento`, `codigo`, `borrado`) VALUES
(1, 'Recursos Humanos', 'RRHH', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE IF NOT EXISTS `estados` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_estado` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=25 ;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id_estado`, `nombre_estado`) VALUES
(1, 'Amazonas'),
(2, 'Anzoátegui'),
(3, 'Apure'),
(4, 'Aragua'),
(5, 'Barinas'),
(6, 'Bolívar'),
(7, 'Carabobo'),
(8, 'Cojedes'),
(9, 'Delta Amacuro'),
(10, 'Distrito Capital'),
(11, 'Falcón'),
(12, 'Guárico'),
(13, 'Lara'),
(14, 'Mérida'),
(15, 'Miranda'),
(16, 'Monagas'),
(17, 'Nueva Esparta'),
(18, 'Portuguesa'),
(19, 'Sucre'),
(20, 'Táchira'),
(21, 'Trujillo'),
(22, 'Vargas'),
(23, 'Yaracuy'),
(24, 'Zulia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ivas`
--

CREATE TABLE IF NOT EXISTS `ivas` (
  `id_iva` int(11) NOT NULL AUTO_INCREMENT,
  `porcentaje` double NOT NULL,
  PRIMARY KEY (`id_iva`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `ivas`
--

INSERT INTO `ivas` (`id_iva`, `porcentaje`) VALUES
(1, 7),
(2, 9),
(3, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `id_pregunta` int(11) NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_pregunta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id_pregunta`, `pregunta`) VALUES
(1, '¿Cual es su animal favorito?'),
(2, '¿Cual es el nombre de su tio?'),
(3, '¿Donde fue su hogar de infancia?'),
(4, '¿Cual es la marca de su vehiculo?'),
(5, '¿Cual es su hobby favorito?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_producto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `costo` double NOT NULL,
  `borrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `costo` (`costo`),
  KEY `borrado` (`borrado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `codigo`, `nombre_producto`, `costo`, `borrado`) VALUES
(1, 'JP01', 'ROUTER WIFI JP TELEMATICS ULTRA', 60, 0),
(2, 'JP02', 'MODEM INTERNET JP TELEMATICS VER 1', 35.1, 0),
(3, 'JP03', 'CONECTOR MULTIPLICADOR HUB 6 PUERTOS USB', 15, 0),
(4, 'JP04', 'HUB USB 7 PUERTOS JP TELEMATICS VERSION 1', 35, 0),
(5, 'JP05', 'HUB PORTATIL DE 4 PUERTOS USB ', 15, 0),
(6, 'JP06', 'ADAPTADOR HUB TIPO-C 4 PUERTOS', 17.5, 0),
(7, 'JP07', 'HUB MULTIPLICADOR 4 PUERTOS TP-LINK USB', 15, 0),
(8, 'JP08', 'HUB 7 PUERTOS USB 2.0 480MBPS BELKIN PARA MAC', 19, 0),
(9, 'JP09', 'HUB USB 7 PUERTOS CON CARGADOR DE PARED', 10, 0),
(10, 'JP10', 'MODEM ABA BANDA ANCHA HG-A1101 GS XPLORE', 28, 0),
(11, 'JP11', 'MODEM ROUTER BANDA ANCHA ULTIMATE INTERNET EXPLORER JP TELEMATICS', 35, 0),
(12, 'JP12', 'MODEM BANDA ANCHA ADSL HUAWEI SMARTAX MT880D ', 24.75, 0),
(13, 'JP13', 'ROUTER MODEM INALAMBRICO 300MBPS JP TELEMATICS', 43, 0),
(14, 'JP14', 'MODEM ADSL NET CORE BANDA ANCHA', 23, 0),
(15, 'JP15', 'PAQUETE REPUESTOS DE CABLES DE CONEXION PARA MODEM ', 14, 0),
(16, 'JP16', 'MODEM ROUTER HUAWEI 4G LTE', 60, 0),
(17, 'JP17', 'MODEM ADSL2 TP-LINK TD-8616', 38, 0),
(18, 'JP18', 'MODEM ROUTER W896 TP-LINK', 46, 0),
(19, 'JP19', 'MODEM ROUTER BANDA ANCHA 4G JP TELEMATICS', 21.5, 0),
(20, 'JP20', 'ROUTER WIFI X4637 TP-LINK', 24, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_personas`
--

CREATE TABLE IF NOT EXISTS `tipo_personas` (
  `id_tipo_persona` int(11) NOT NULL AUTO_INCREMENT,
  `t_nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `identificador` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  `borrado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_tipo_persona`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tipo_personas`
--

INSERT INTO `tipo_personas` (`id_tipo_persona`, `t_nombre`, `identificador`, `borrado`) VALUES
(1, 'JURIDICA', 'J', 0),
(2, 'VENEZOLANO', 'V', 0),
(3, 'EXTRANJERO', 'E', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `clave` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `administrador` tinyint(4) NOT NULL,
  `id_pregunta` int(11) NOT NULL,
  `respuesta` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `borrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_pregunta` (`id_pregunta`),
  KEY `id_departamento` (`id_departamento`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `clave`, `administrador`, `id_pregunta`, `respuesta`, `nombre`, `id_departamento`, `borrado`) VALUES
(1, 'rootuser', '12345678', 1, 1, 'Delfin', 'Administrador', 1, 0),
(2, 'nonadmin', '12345678', 0, 3, 'Barquisimeto', 'No Administrador', 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE IF NOT EXISTS `vendedores` (
  `id_vendedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_vendedor` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `cedula_vendedor` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `id_zona` int(11) NOT NULL,
  `borrado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_vendedor`),
  KEY `id_zona` (`id_zona`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`id_vendedor`, `nombre_vendedor`, `cedula_vendedor`, `telefono`, `id_zona`, `borrado`) VALUES
(1, 'ARMANDO ALVARADO', '20458328', '04267484756', 1, 0),
(2, 'JULIAN SANCHEZ', '17826439', '04126375844', 2, 0),
(3, 'ABRAHAM HERNANDEZ', '17638292', '04127583758', 5, 0),
(4, 'LUISANA TORRES', '19374839', '04269274821', 14, 0),
(5, 'MARIBEL ANGULO', '20148372', '04142812748', 21, 0),
(6, 'EZEQUIEL BARRETO ', '9473821', '04240137001', 18, 0),
(7, 'LORIANNY VARGAS', '24374383', '04123874673', 3, 0),
(8, 'ENRIQUE ANTEQUERA', '20183900', '04262392012', 12, 0),
(9, 'MIGUEL SANDOVAL', '23919280', '04143018721', 10, 0),
(10, 'ANTONIO PERAZA', '10289431', '04267389201', 2, 0),
(11, 'LORENA GUTIERREZ', '19463722', '04125389082', 2, 0),
(12, 'JUAN PEREIRA', '25238291', '04261948910', 27, 0),
(13, 'MARIBEL GARCIA', '22843791', '04146372792', 10, 0),
(14, 'ELISMAR DURAN', '26428191', '04247001213', 28, 0),
(15, 'ALVIN LOPEZ', '21563718', '04162748891', 18, 0),
(16, 'YAMILETH ALMAO', '25438191', '56729101234', 4, 0),
(17, 'JUAN ALVAREZ', '11285739', '04164728292', 11, 0),
(18, 'SANTIAGO SUAREZ', '27453628', '04126473819', 5, 0),
(19, 'HILDA CAMPOS', '9761820', '04167281911', 10, 0),
(20, 'INGRID VELASQUEZ', '14628172', '04162854923', 4, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` double NOT NULL,
  `id_iva` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  `iva_calculado` double NOT NULL,
  `hora_y_fecha` datetime NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_producto` (`id_producto`),
  KEY `id_iva` (`id_iva`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `id_cliente`, `id_producto`, `cantidad`, `total`, `id_iva`, `subtotal`, `iva_calculado`, `hora_y_fecha`) VALUES
(1, 1, 1, 2, 130.8, 2, 120, 10.8, '2020-06-14 00:43:47'),
(2, 2, 2, 1, 37.557, 1, 35.1, 2.457, '2020-06-14 00:46:44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE IF NOT EXISTS `zonas` (
  `id_zona` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_zona` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `borrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_zona`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `zonas`
--

INSERT INTO `zonas` (`id_zona`, `codigo`, `nombre_zona`, `borrado`) VALUES
(1, '0001', 'ZONA 1', 0),
(2, '0002', 'ZONA 2', 0),
(3, '0003', 'ZONA 3', 0),
(4, '0004', 'ZONA 4', 0),
(5, '0005', 'ZONA 5', 0),
(6, '0006', 'ZONA 6', 0),
(7, '0007', 'ZONA 7 ', 0),
(8, '0008', 'ZONA 8', 0),
(9, '0009', 'ZONA 9', 0),
(10, '0010', 'ZONA 10', 0),
(11, '0011', 'ZONA 11', 0),
(12, '0012', 'ZONA 12', 0),
(13, '0013', 'ZONA 13', 0),
(14, '0014', 'ZONA 14', 0),
(15, '0015', 'ZONA 15', 0),
(16, '0016', 'ZONA 16', 0),
(17, '0017', 'ZONA 17', 0),
(18, '0018', 'ZONA 18', 0),
(19, '0019', 'ZONA 19', 0),
(20, '0020', 'ZONA 20', 0),
(21, '0021', 'ZONA 21', 0),
(22, '0022', 'ZONA 22', 0),
(23, '0023', 'ZONA 23', 0),
(24, '0024', 'ZONA 24', 0),
(25, '0025', 'ZONA 25', 0),
(26, '0026', 'ZONA 26', 0),
(27, '0027', 'ZONA 27', 0),
(28, '0028', 'ZONA 28', 0),
(29, '0029', 'ZONA 29', 0),
(30, '0030', 'ZONA 30', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona_estados`
--

CREATE TABLE IF NOT EXISTS `zona_estados` (
  `id_zona` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `id_zona_estado` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_zona_estado`),
  KEY `id_estado` (`id_estado`),
  KEY `id_zona` (`id_zona`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=91 ;

--
-- Volcado de datos para la tabla `zona_estados`
--

INSERT INTO `zona_estados` (`id_zona`, `id_estado`, `id_zona_estado`) VALUES
(1, 11, 1),
(1, 23, 2),
(1, 7, 3),
(2, 4, 4),
(2, 10, 5),
(2, 22, 6),
(3, 11, 7),
(3, 13, 8),
(3, 16, 9),
(4, 12, 10),
(4, 8, 11),
(4, 4, 12),
(5, 17, 13),
(5, 9, 14),
(5, 19, 15),
(6, 23, 16),
(6, 13, 17),
(6, 24, 18),
(7, 3, 19),
(7, 12, 20),
(7, 16, 21),
(8, 10, 22),
(8, 8, 23),
(8, 4, 24),
(9, 20, 25),
(9, 21, 26),
(9, 14, 27),
(10, 1, 28),
(10, 5, 29),
(10, 22, 30),
(11, 12, 31),
(11, 15, 32),
(11, 7, 33),
(12, 10, 34),
(12, 24, 35),
(12, 20, 36),
(13, 18, 37),
(13, 15, 38),
(13, 16, 39),
(14, 10, 40),
(14, 13, 41),
(14, 23, 42),
(15, 21, 43),
(15, 18, 44),
(15, 11, 45),
(16, 9, 46),
(16, 3, 47),
(16, 4, 48),
(17, 17, 49),
(17, 8, 50),
(17, 22, 51),
(18, 5, 52),
(18, 14, 53),
(18, 20, 54),
(19, 24, 55),
(19, 16, 56),
(19, 8, 57),
(20, 10, 58),
(20, 2, 59),
(20, 22, 60),
(21, 7, 61),
(21, 12, 62),
(21, 8, 63),
(22, 9, 64),
(22, 6, 65),
(22, 19, 66),
(23, 22, 67),
(23, 7, 68),
(23, 10, 69),
(24, 12, 70),
(24, 8, 71),
(24, 16, 72),
(25, 1, 73),
(25, 8, 74),
(25, 6, 75),
(26, 14, 76),
(26, 13, 77),
(26, 18, 78),
(27, 20, 79),
(27, 12, 80),
(27, 5, 81),
(28, 21, 82),
(28, 18, 83),
(28, 23, 84),
(29, 13, 85),
(29, 10, 86),
(29, 7, 87),
(30, 17, 88),
(30, 9, 89),
(30, 19, 90);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `cliente` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedores` (`id_vendedor`),
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`),
  ADD CONSTRAINT `estado` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`),
  ADD CONSTRAINT `tipo_persona` FOREIGN KEY (`id_tipo_persona`) REFERENCES `tipo_personas` (`id_tipo_persona`),
  ADD CONSTRAINT `vendedor` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedores` (`id_vendedor`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuario_departameto` FOREIGN KEY (`id_departamento`) REFERENCES `departamentos` (`id_departamento`),
  ADD CONSTRAINT `usuario_preguntas` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id_pregunta`);

--
-- Filtros para la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD CONSTRAINT `zona_vendedor` FOREIGN KEY (`id_zona`) REFERENCES `zonas` (`id_zona`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_iva`) REFERENCES `ivas` (`id_iva`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Filtros para la tabla `zona_estados`
--
ALTER TABLE `zona_estados`
  ADD CONSTRAINT `registro_estado` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`),
  ADD CONSTRAINT `registro_zona` FOREIGN KEY (`id_zona`) REFERENCES `zonas` (`id_zona`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
