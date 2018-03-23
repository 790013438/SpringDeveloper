CREATE DATABASE  IF NOT EXISTS `journal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `journal`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: journal
-- ------------------------------------------------------
-- Server version	5.7.21

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

-- SECURITY: USER ACCOUNT
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (`ACCOUNT_NAME` VARCHAR(255) NOT NULL, `PASSWORD` VARCHAR(255) NOT NULL, `ID` SERIAL, `ENABLED` BOOL DEFAULT true);

-- USERS IN JOURNAL
INSERT INTO ACCOUNT(account_name , password) VALUES('springboot', '{bcrypt}$2a$10$1h1SU3yaMe0nlgLhBBeccu7mOs9fwiTVoHad6R.d4grdrrTV0gZ7S');
INSERT INTO ACCOUNT(account_name , password) VALUES('springsecurity', '{bcrypt}$2a$10$xtqCwu.WnsWuDJU5z3ob9OdqXw7Dy3HdD.YoZ7AYnhNhdOZg7op6C');

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry` (`id` bigint(20) NOT NULL AUTO_INCREMENT, `created` datetime DEFAULT NULL, `summary` varchar(255) DEFAULT NULL, `title` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
INSERT INTO `entry` VALUES (1,'2016-01-02 00:00:00','Today I will learn Spring Boot','Get to know Spring Boot'),(2,'2016-01-03 00:00:00','I will do my first Spring Boot project','Simple Spring Boot Project'),(3,'2016-02-02 00:00:00','Read more about Spring Boot','Spring Boot Reading'),(4,'2016-02-05 00:00:00','Learn Spring Boot using Cloud Foundry','Spring Boot in the Cloud');
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-20 10:28:18
