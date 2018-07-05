-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tuntikirjaukset
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `kayttajat`
--

DROP TABLE IF EXISTS `kayttajat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kayttajat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `etunimi` varchar(20) NOT NULL,
  `sukunimi` varchar(50) NOT NULL,
  `osastoid` int(11) DEFAULT NULL,
  `tehtavanimikeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kayttajat`
--

LOCK TABLES `kayttajat` WRITE;
/*!40000 ALTER TABLE `kayttajat` DISABLE KEYS */;
INSERT INTO `kayttajat` VALUES (1,'Erkki','Esimerkki',1,1),(2,'Tapio','Turkka',2,1),(3,'Pertti','Pomo',3,3);
/*!40000 ALTER TABLE `kayttajat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuntienkirjaus`
--

DROP TABLE IF EXISTS `tuntienkirjaus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuntienkirjaus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kayttajaid` int(11) NOT NULL,
  `paivamaara` date DEFAULT NULL,
  `minuutit` int(11) DEFAULT NULL,
  `tehtavakuvaus` varchar(255) DEFAULT NULL,
  `laskutettava` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kayttajaid` (`kayttajaid`),
  CONSTRAINT `tuntienkirjaus_ibfk_1` FOREIGN KEY (`kayttajaid`) REFERENCES `kayttajat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuntienkirjaus`
--

LOCK TABLES `tuntienkirjaus` WRITE;
/*!40000 ALTER TABLE `tuntienkirjaus` DISABLE KEYS */;
INSERT INTO `tuntienkirjaus` VALUES (1,1,'1993-07-05',120,'Tykitin koodii',1),(2,2,'1992-07-05',15,'Katsoin seinää',0),(3,3,'1992-07-06',60,'Pomotin seinää',1),(4,1,'1992-07-05',120,'Koodasin seinää',1),(5,1,'1992-07-05',65,'Paiskin hommii ',0),(8,1,'1994-05-05',50,'Hakkasin koodii',1);
/*!40000 ALTER TABLE `tuntienkirjaus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-05 13:16:15
