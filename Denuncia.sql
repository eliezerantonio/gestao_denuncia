-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: denuncias
-- ------------------------------------------------------
-- Server version	5.7.21-1

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
-- Table structure for table `denuncia`
--

DROP TABLE IF EXISTS `denuncia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `denuncia` (
  `id_denuncia` int(11) NOT NULL AUTO_INCREMENT,
  `id_municipio` int(11) NOT NULL,
  `tipo_denuncia` int(11) NOT NULL,
  `descricao_denuncia` text NOT NULL,
  `data_registro_denuncia` date NOT NULL,
  `nome_cidadao` varchar(100) CHARACTER SET utf8 NOT NULL,
  `telefone_cidadao` varchar(100) CHARACTER SET utf8 NOT NULL,
  `email_cidadao` varchar(100) CHARACTER SET utf8 NOT NULL,
  `data_ocorrencia` date NOT NULL,
  PRIMARY KEY (`id_denuncia`),
  UNIQUE KEY `email_cidadao` (`email_cidadao`),
  KEY `id_municipo_fk` (`id_municipio`),
  KEY `id_tipo_denucia_fk` (`tipo_denuncia`),
  CONSTRAINT `id_municipo_fk` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE CASCADE,
  CONSTRAINT `id_tipo_denucia_fk` FOREIGN KEY (`tipo_denuncia`) REFERENCES `tipo_denuncia` (`id_tipo_denuncia`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `denuncia`
--

LOCK TABLES `denuncia` WRITE;
/*!40000 ALTER TABLE `denuncia` DISABLE KEYS */;
INSERT INTO `denuncia` VALUES (1,1,7,'Meu vizinho passa a vida a agredir a sua esposa','2019-08-31','Eliezer','924033375','eliezerfernandoantonio@gmail.com','2019-08-31');
/*!40000 ALTER TABLE `denuncia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despacho`
--

DROP TABLE IF EXISTS `despacho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `despacho` (
  `id_despacho` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) NOT NULL,
  `id_denucia` int(11) NOT NULL,
  `data_despacho` datetime NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_despacho`),
  KEY `id_funcionario_fk` (`id_funcionario`),
  KEY `id_denucia_fk` (`id_denucia`),
  KEY `id_estado_fk` (`id_estado`),
  CONSTRAINT `id_denucia_fk` FOREIGN KEY (`id_denucia`) REFERENCES `denuncia` (`id_denuncia`) ON DELETE CASCADE,
  CONSTRAINT `id_estado_fk` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE CASCADE,
  CONSTRAINT `id_funcionario_fk` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despacho`
--

LOCK TABLES `despacho` WRITE;
/*!40000 ALTER TABLE `despacho` DISABLE KEYS */;
INSERT INTO `despacho` VALUES (1,1,1,'2019-08-31 00:00:00',1),(2,1,1,'2019-08-31 00:00:00',1),(4,3,1,'2019-08-31 00:00:00',1),(6,3,1,'2019-09-01 10:38:38',2),(7,1,1,'2019-09-02 23:08:31',1),(11,1,1,'2019-09-02 23:18:14',3);
/*!40000 ALTER TABLE `despacho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_estado` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_estado`),
  UNIQUE KEY `descricao_estado` (`descricao_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (2,'A analisar'),(3,'Pendente'),(1,'Resolvido');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `foto_funcionario` longblob,
  `nome_funcionario` varchar(100) CHARACTER SET utf8 NOT NULL,
  `sobrenome_funcionario` varchar(100) CHARACTER SET utf8 NOT NULL,
  `telefone_funcionario` varchar(100) CHARACTER SET utf8 NOT NULL,
  `email_funcionario` varchar(100) CHARACTER SET utf8 NOT NULL,
  `senha_funcionario` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Sexo` varchar(15) DEFAULT NULL,
  `tipo_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `email_funcionario` (`email_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,NULL,'Eliezer','Antonio','924033375','eliezer@gmail.com','1111','M',1),(3,NULL,'Vasco','Antonio','924033375','eliezera@gmail.com','1111','M',1),(6,NULL,'Romeu','Antonio','924033375','eliezesdsdr@gmail.com','1111','M',1),(7,NULL,'Gonza','Antonio','924033375','eliezesdsdssdsr@gmail.com','1111','M',1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_municipio` varchar(50) CHARACTER SET utf8 NOT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `id_provincia_fk` (`id_provincia`),
  CONSTRAINT `id_provincia_fk` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'Lubango',1),(2,'Humpata',1),(3,'Chibía',1),(4,'Matala',1);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_provincia`),
  UNIQUE KEY `nome_provincia` (`nome_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (3,'Cuando Cubango'),(1,'Huíla'),(2,'Luanda'),(4,'Namibe');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_denuncia`
--

DROP TABLE IF EXISTS `tipo_denuncia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_denuncia` (
  `id_tipo_denuncia` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_denuncia` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_tipo_denuncia`),
  UNIQUE KEY `descricao_denucia` (`descricao_denuncia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_denuncia`
--

LOCK TABLES `tipo_denuncia` WRITE;
/*!40000 ALTER TABLE `tipo_denuncia` DISABLE KEYS */;
INSERT INTO `tipo_denuncia` VALUES (4,'Agressão ao Ambiente'),(2,'Burla'),(3,'Furto/Roubo'),(8,'Homicídio'),(9,'Maus Tratos'),(6,'Ofenda à Integridade Física'),(1,'Queixa Simples'),(5,'Tafico de Pessoas'),(7,'Violência Doméstica');
/*!40000 ALTER TABLE `tipo_denuncia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_funcionario`
--

DROP TABLE IF EXISTS `tipo_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_funcionario` (
  `id_tipo_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_tipo_funcionario` varchar(11) NOT NULL,
  PRIMARY KEY (`id_tipo_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_funcionario`
--

LOCK TABLES `tipo_funcionario` WRITE;
/*!40000 ALTER TABLE `tipo_funcionario` DISABLE KEYS */;
INSERT INTO `tipo_funcionario` VALUES (1,'Normal'),(2,'Admin');
/*!40000 ALTER TABLE `tipo_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'denuncias'
--

--
-- Dumping routines for database 'denuncias'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-06 10:45:22
