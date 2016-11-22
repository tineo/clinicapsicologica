-- MySQL dump 10.13  Distrib 5.7.12, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: test2
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico` (
  `codigo_diagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `sinopsis` varchar(45) DEFAULT NULL,
  `codigo_terapia` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_diagnostico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen`
--

DROP TABLE IF EXISTS `examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examen` (
  `codigo_examen` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `diagnostico` varchar(45) DEFAULT NULL,
  `fecha_realizo` datetime DEFAULT NULL,
  `fecha_entrega` datetime DEFAULT NULL,
  PRIMARY KEY (`codigo_examen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen`
--

LOCK TABLES `examen` WRITE;
/*!40000 ALTER TABLE `examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `codigo_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `dosis` varchar(45) DEFAULT NULL,
  `unidad` varchar(45) DEFAULT NULL,
  `lapso` int(11) DEFAULT NULL,
  `intervalo` varchar(45) DEFAULT NULL,
  `codigo_observacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `observacion`
--

DROP TABLE IF EXISTS `observacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `observacion` (
  `codigo_observacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `nivel_importancia` varchar(45) DEFAULT NULL,
  `sintoma` varchar(45) DEFAULT NULL,
  `codigo_sesion` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_observacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `observacion`
--

LOCK TABLES `observacion` WRITE;
/*!40000 ALTER TABLE `observacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `observacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `codigo_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `codigo_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'B',8),(2,'A',11);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `psicologo`
--

DROP TABLE IF EXISTS `psicologo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `psicologo` (
  `codigo_psicologo` int(11) NOT NULL AUTO_INCREMENT,
  `especialidad` varchar(45) DEFAULT NULL,
  `cod_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_psicologo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `psicologo`
--

LOCK TABLES `psicologo` WRITE;
/*!40000 ALTER TABLE `psicologo` DISABLE KEYS */;
INSERT INTO `psicologo` VALUES (1,'A','9'),(2,'B','10');
/*!40000 ALTER TABLE `psicologo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesion`
--

DROP TABLE IF EXISTS `sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesion` (
  `codigo_sesion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_reunion` datetime DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `lugar` varchar(45) DEFAULT NULL,
  `codigo_paciente` int(11) DEFAULT NULL,
  `codigo_psicologo` int(11) DEFAULT NULL,
  `duracion` int(11) DEFAULT '0',
  PRIMARY KEY (`codigo_sesion`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
INSERT INTO `sesion` VALUES (2,'2016-07-04 01:29:45','2016-07-12 14:30:00','1','1',1,1,60),(3,'2016-07-04 01:30:20','2016-07-11 15:30:00','1','2',1,1,60),(4,'2016-07-04 01:30:27','2016-07-13 09:30:00','2','1',1,1,60),(5,'2016-07-04 01:30:49','2016-07-14 13:30:00','2','1',1,1,90),(6,'2016-07-04 00:00:00','2016-07-14 10:00:00','1','1471',1,2,60),(7,'2016-07-04 00:00:00','2016-07-16 11:00:00','1','123',2,2,90),(8,'2016-07-04 00:00:00','2016-07-17 12:00:00','1','417',1,2,90),(9,'2016-07-04 00:00:00','2016-07-18 10:00:00','1','65756',2,2,60),(10,'2016-07-04 00:00:00','2016-07-19 13:30:00','1','247',1,2,60),(11,'2016-07-04 00:00:00','2016-07-20 15:00:00','1','25423',2,2,60),(12,'2016-07-04 00:00:00','2016-07-21 13:00:00','1','213',2,2,60),(13,'2016-07-04 00:00:00','2016-07-22 13:00:00','1','74',2,2,90),(14,'2016-07-04 00:00:00','2016-07-23 11:00:00','1','247',2,2,60),(15,'2016-07-04 00:00:00','2016-07-24 12:00:00','1','72452',2,2,60),(16,'2016-07-04 05:59:24','2016-07-24 18:00:00','1','554',2,2,60);
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terapia`
--

DROP TABLE IF EXISTS `terapia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terapia` (
  `codigo_terapia` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` varchar(45) DEFAULT NULL,
  `codigo_medico` int(11) DEFAULT NULL,
  `codigo_paciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_terapia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terapia`
--

LOCK TABLES `terapia` WRITE;
/*!40000 ALTER TABLE `terapia` DISABLE KEYS */;
/*!40000 ALTER TABLE `terapia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codigo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `estado` int(11) DEFAULT '1',
  `fecha_ingreso` datetime DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'debra','12345678',NULL,NULL,NULL,NULL,NULL,1,NULL,'debra'),(2,'Cesar',NULL,'Gutierrez','Tineo','2016-06-07','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-06-20 00:14:11',NULL),(3,'Debra',NULL,'Chacaliaza','Llamosa','2016-06-19','Av Evergreen 10','ewfwe',1,'2016-06-20 00:16:29',NULL),(4,'Jose',NULL,'Soto','wede','2016-06-13','ewrwe','edfwe',1,'2016-06-20 00:20:27',NULL),(5,'Cesar',NULL,'Gutierrez','wqs','2016-06-13','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-06-20 00:22:45',NULL),(6,'Cesar',NULL,'Gutierrez','ewrewr','2016-06-07','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-06-20 00:46:28',NULL),(7,'Cesar',NULL,'Gutierrez','cece','2016-06-07','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-06-20 00:52:25',NULL),(8,'Cesar',NULL,'Gutierrez','cfew','2016-06-06','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-06-20 00:54:09',NULL),(9,'Cesar','12345678','Gutierrez','Tineo','2016-06-09','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-06-20 13:21:20','tineo'),(10,'Jose','12345678','Maria','Jesus','2016-06-21','ewfwf','weewrf',1,'2016-06-26 18:04:27','jesus'),(11,'Cesar',NULL,'Gutierrez','Tineo','2016-07-05','Jr. Moyobamba 741','itsudatte01@gmail.com',1,'2016-07-04 04:06:47',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'test2'
--

--
-- Dumping routines for database 'test2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-04 13:50:49
