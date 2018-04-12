CREATE DATABASE  IF NOT EXISTS `pzhu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pzhu`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pzhu
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

-- USERS IN pzhu
INSERT INTO ACCOUNT(account_name , password) VALUES('springboot', '{bcrypt}$2a$10$1h1SU3yaMe0nlgLhBBeccu7mOs9fwiTVoHad6R.d4grdrrTV0gZ7S');
INSERT INTO ACCOUNT(account_name , password) VALUES('springsecurity', '{bcrypt}$2a$10$xtqCwu.WnsWuDJU5z3ob9OdqXw7Dy3HdD.YoZ7AYnhNhdOZg7op6C');