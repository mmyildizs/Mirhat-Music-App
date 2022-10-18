-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: mirhats_project
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mirhats_account`
--

DROP TABLE IF EXISTS `mirhats_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mirhats_account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `tür` varchar(30) NOT NULL,
  `üyelik` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mirhats_account`
--

LOCK TABLES `mirhats_account` WRITE;
/*!40000 ALTER TABLE `mirhats_account` DISABLE KEYS */;
INSERT INTO `mirhats_account` VALUES (1,'Mirhat M.','Yıldız','AdminMirhat','137666','Admin','Admin'),(6,'Paul','Licker','pau77','77pau77','Kullanıcı','Normal'),(7,'Halil','Gazoz','hgazoz18','18halilgg','Kullanıcı','Normal'),(8,'James','Harden','JH13Nba','jharden13','Kullanıcı','Premium'),(9,'Hakan','San','hsan3','3hsan3','Kullanıcı','Premium'),(10,'karim','benzema','kkbenz','kkbenz23','Kullanıcı','Premium');
/*!40000 ALTER TABLE `mirhats_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mirhats_albüm`
--

DROP TABLE IF EXISTS `mirhats_albüm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mirhats_albüm` (
  `AlbümID` int NOT NULL AUTO_INCREMENT,
  `Albüm` varchar(50) NOT NULL,
  `SanatciName` varchar(45) NOT NULL,
  `SarkiName` varchar(50) NOT NULL,
  `ÇıkışTarihi` varchar(45) NOT NULL,
  `Tür` varchar(45) NOT NULL,
  PRIMARY KEY (`AlbümID`),
  UNIQUE KEY `AlbümID_UNIQUE` (`AlbümID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mirhats_albüm`
--

LOCK TABLES `mirhats_albüm` WRITE;
/*!40000 ALTER TABLE `mirhats_albüm` DISABLE KEYS */;
INSERT INTO `mirhats_albüm` VALUES (4,'Kamikaze','Eminem','The Ringer','2018','Rap'),(5,'Kamikaze','Eminem','Greatest','2018','Rap');
/*!40000 ALTER TABLE `mirhats_albüm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mirhats_sanatci`
--

DROP TABLE IF EXISTS `mirhats_sanatci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mirhats_sanatci` (
  `sanatci_id` int NOT NULL AUTO_INCREMENT,
  `SanatciName` varchar(30) NOT NULL,
  `Ülke` varchar(45) NOT NULL,
  PRIMARY KEY (`sanatci_id`),
  UNIQUE KEY `sanatci_id_UNIQUE` (`sanatci_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mirhats_sanatci`
--

LOCK TABLES `mirhats_sanatci` WRITE;
/*!40000 ALTER TABLE `mirhats_sanatci` DISABLE KEYS */;
INSERT INTO `mirhats_sanatci` VALUES (1,'Roger Waters','İngiltere'),(5,'David Gilmour','İngiltere'),(6,'Kurt Covain','ABD'),(7,'Pentagram','Türkiye'),(8,'Tarkan','Türkiye');
/*!40000 ALTER TABLE `mirhats_sanatci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mirhats_sarki`
--

DROP TABLE IF EXISTS `mirhats_sarki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mirhats_sarki` (
  `SarkiID` int NOT NULL AUTO_INCREMENT,
  `SarkiName` varchar(50) NOT NULL,
  `SanatciName` varchar(30) NOT NULL,
  `Albüm` varchar(45) NOT NULL,
  `ÇıkışTarihi` varchar(30) NOT NULL,
  `Tür` varchar(30) NOT NULL,
  `Süre` varchar(30) NOT NULL,
  `DinlenmeSayisi` int NOT NULL,
  `Ülke` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`SarkiID`),
  UNIQUE KEY `SarkiID_UNIQUE` (`SarkiID`),
  UNIQUE KEY `SarkiName_UNIQUE` (`SarkiName`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mirhats_sarki`
--

LOCK TABLES `mirhats_sarki` WRITE;
/*!40000 ALTER TABLE `mirhats_sarki` DISABLE KEYS */;
INSERT INTO `mirhats_sarki` VALUES (3,'Another Brick in the Wall: Part 1','Pink Floyd','The Wall','1979','Rock','3:21',17,'İngiltere'),(11,'Another Brick in the Wall: Part 2','Pink Floyd','The Wall','1979','Rock','3:21',20,'İngiltere'),(12,'Without Me','Eminem','The Eminem Show','2002','Rap','4:57',19,'ABD'),(13,'Bir','Pentagram','Bir','2002','Rock','4:05',34,'Türkiye'),(14,'Tigris','Pentagram','Bir','2002','Rock','1:36',10,'Türkiye'),(15,'Hotter Than Hell','Dua Lipa','The Only EP','2017','Pop','3:08',24,'İngiltere'),(16,'Suspus','Ceza','Suspus','2015','Rap','4:10',18,'Türkiye'),(17,'Thunderstruck','AC/DC','The Razors Edge','1990','Rock','4:53',43,'Avustralya'),(18,'The Ecstasy of Gold','Metallica','S&M2','2020','Rock','2:41',18,'ABD'),(19,'Duman','Manga','Şehr-i Hüzün','2009','Rock','3:43',20,'Türkiye'),(20,'Kıl Oldum','Tarkan','Yine Sensiz','1992','Pop','4:12',5,'Türkiye'),(23,'','','','','','',0,NULL),(26,'Mirhat','','','','','',0,NULL),(27,'Sonsuz','Pentagram','Sonsuz','2018','Rock','3:08',0,NULL),(28,'Aklımda Bir Kördüğüm','Second','Second','2021','Rock','2:01',0,NULL);
/*!40000 ALTER TABLE `mirhats_sarki` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-18 10:45:03
