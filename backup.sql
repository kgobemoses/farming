CREATE DATABASE  IF NOT EXISTS `test_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test_db`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: test_db
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `ID` bigint(20) NOT NULL,
  `CONTACT` varchar(255) DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `ITEMNAME` varchar(255) DEFAULT NULL,
  `PRICE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (2,'07012345678','C:\\Information\\class.jpg','white board','750'),(6,'0711336130','C:\\Information\\file.jpg','white board','750');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab` (
  `ID` bigint(20) NOT NULL,
  `TIME` varchar(255) DEFAULT NULL,
  `VENUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab`
--

LOCK TABLES `lab` WRITE;
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `ID` bigint(20) NOT NULL,
  `MESSAGE` varchar(255) DEFAULT NULL,
  `RECEIVED` datetime DEFAULT NULL,
  `RECEIVER` int(11) DEFAULT NULL,
  `SENDER` int(11) DEFAULT NULL,
  `viewed` tinyint(1) DEFAULT NULL,
  `hhh` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (300,'c','2016-08-29 20:45:10',2,4,NULL,NULL),(301,'yy','2016-08-29 20:45:23',4,2,NULL,NULL),(302,'eeeee','2016-08-29 20:45:36',2,4,NULL,NULL),(303,'uuuuu','2016-08-29 20:45:41',4,2,NULL,NULL),(304,'he','2016-08-29 20:45:48',2,4,NULL,NULL),(305,'yy','2016-08-29 20:58:55',2,4,NULL,NULL),(306,'t','2016-08-29 20:59:28',2,4,NULL,NULL),(307,'look','2016-08-29 20:59:41',2,4,NULL,NULL),(308,'look','2016-08-29 20:59:57',2,4,NULL,NULL),(309,'t','2016-08-29 21:00:04',4,2,NULL,NULL),(350,'ff','2016-09-15 09:11:02',2,4,NULL,NULL),(351,'ttttgggg','2016-09-15 09:11:15',4,2,NULL,NULL),(352,'gg','2016-09-15 09:11:27',2,4,NULL,NULL),(353,'tt','2016-09-15 09:11:31',4,2,NULL,NULL),(354,'tt','2016-09-15 09:11:38',2,4,NULL,NULL),(355,'ggg','2016-09-15 09:11:59',2,4,NULL,NULL),(356,'gggg','2016-09-15 09:12:08',4,2,NULL,NULL),(357,'uu','2016-09-15 09:13:44',2,4,NULL,NULL),(358,'hhh','2016-09-15 09:13:57',2,4,NULL,NULL),(359,'ffff','2016-09-15 09:14:00',2,4,NULL,NULL),(360,'gg','2016-09-15 09:15:01',4,2,NULL,NULL),(361,'moss','2016-09-15 09:15:56',4,2,NULL,NULL),(362,'thuli','2016-09-15 09:16:22',2,4,NULL,NULL);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('id_gen',399);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test@gmail.com','password','name'),(2,'lerato@gmail.com','1234','lerato'),(4,'thuli@gmail.com','1234','thuli'),(5,'moss@gmail.com','1234','moss'),(6,'tman@gmail.com','1234','Tman'),(8,'lizzy@gmail.com','1234','Lizzy'),(10,'nthabi@gmail.com','1234','nthabi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-21 13:29:20
