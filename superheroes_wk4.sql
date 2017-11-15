-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: superheroes
-- ------------------------------------------------------
-- Server version	5.7.9

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

DROP DATABASE IF EXISTS `superheroes`;

CREATE DATABASE `superheroes`;

USE `superheroes`;

--
-- Table structure for table `city_table`
--

DROP TABLE IF EXISTS `city_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `population` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_table`
--

LOCK TABLES `city_table` WRITE;
/*!40000 ALTER TABLE `city_table` DISABLE KEYS */;
INSERT INTO `city_table` VALUES (1,'Galway','Ireland',75000),(2,'Gotham City','USA',15000000),(3,'Metropolis','USA',22250000),(4,'New York','USA',8500000),(5,'Springfield','USA',20000);
/*!40000 ALTER TABLE `city_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superhero_city_table`
--

DROP TABLE IF EXISTS `superhero_city_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `superhero_city_table` (
  `name` varchar(20) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`name`,`id`),
  KEY `id` (`id`),
  CONSTRAINT `superhero_city_table_ibfk_1` FOREIGN KEY (`name`) REFERENCES `superhero_table` (`name`),
  CONSTRAINT `superhero_city_table_ibfk_2` FOREIGN KEY (`id`) REFERENCES `city_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superhero_city_table`
--

LOCK TABLES `superhero_city_table` WRITE;
/*!40000 ALTER TABLE `superhero_city_table` DISABLE KEYS */;
INSERT INTO `superhero_city_table` VALUES ('Batgirl',2),('Batman',2),('Batman',3),('Spiderman',3),('Superman',3),('Spiderman',4),('Radioactiveman',5);
/*!40000 ALTER TABLE `superhero_city_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superhero_table`
--

DROP TABLE IF EXISTS `superhero_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `superhero_table` (
  `name` varchar(20) NOT NULL,
  `real_first_name` varchar(20) DEFAULT NULL,
  `real_surname` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `powers` double(5,2) DEFAULT '77.88',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superhero_table`
--

LOCK TABLES `superhero_table` WRITE;
/*!40000 ALTER TABLE `superhero_table` DISABLE KEYS */;
INSERT INTO `superhero_table` VALUES ('Batgirl','Barbara','Gordon','1995-12-07',98.05),('Batman','Bruce','Wayne','1960-11-12',97.45),('Radioactiveman','Alan','Jones','2000-07-04',76.88),('Spiderman','Peter','Parker','1980-01-27',71.04),('Superman','Clark','Kent','1980-11-22',99.00);
/*!40000 ALTER TABLE `superhero_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-30 17:13:29
