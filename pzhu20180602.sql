CREATE DATABASE  IF NOT EXISTS `pzhu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pzhu`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pzhu
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `ACCOUNT_NAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ID` varchar(255) NOT NULL,
  `ENABLED` tinyint(1) DEFAULT '1',
  `created_date` date DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `user_entity_id` varchar(45) DEFAULT NULL,
  `confirmation_token` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('springboot','{bcrypt}$2a$10$mNOy4yL5peIPYODZibtJzuWXdRIcgzbI20unf7ddhlRQCCDwOBc5G','1',1,NULL,NULL,NULL,'1',NULL),('1','{bcrypt}$2a$10$mNOy4yL5peIPYODZibtJzuWXdRIcgzbI20unf7ddhlRQCCDwOBc5G','2',1,NULL,NULL,NULL,'1',NULL),('790013438@qq.com','{bcrypt}$2a$10$1C2P08uXD1tda0/YN3rZgO9ITYr34JeOzx8tPQp2sAKQLVk85192.','4028ab0f63269c660163269eba1d0001',1,NULL,NULL,NULL,'4028ab0f63269c660163269eb9a50000',NULL),('floyd','{bcrypt}$2a$10$9XMYhd3JIwOiDlN5MHDpCOvynpYuoEBG5eEkWSfUzWivuIlinBvbK','4028ab0f63269c660163269eba310002',1,NULL,NULL,NULL,'4028ab0f63269c660163269eb9a50000',NULL),('734731527@qq.com','{bcrypt}$2a$10$/WUjXB/mG48qZJfRnRh1..wBZZ9Jlwbd.t.1QTvbXxwBFD.AgXgfG','4028ab0f6349ef61016349f44f890007',1,NULL,NULL,NULL,'4028ab0f6349ef61016349f44f790006',NULL),('lin','{bcrypt}$2a$10$Ml7OI6oZsyMBWOQgs6guJO2cdcQfym2N7BLROWpA4cFkk8DdskuSO','4028ab0f6349ef61016349f44f9d0008',1,NULL,NULL,NULL,'4028ab0f6349ef61016349f44f790006',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blank_entity`
--

DROP TABLE IF EXISTS `blank_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blank_entity` (
  `id` varchar(45) NOT NULL,
  `answer` varchar(45) DEFAULT NULL,
  `survey_answer_entity_id` varchar(45) DEFAULT NULL,
  `survey_entity_id` varchar(45) DEFAULT NULL,
  `question_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blank_entity`
--

LOCK TABLES `blank_entity` WRITE;
/*!40000 ALTER TABLE `blank_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `blank_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkbox_entity`
--

DROP TABLE IF EXISTS `checkbox_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkbox_entity` (
  `id` varchar(45) NOT NULL,
  `otherText` varchar(45) DEFAULT NULL,
  `question_entity_id` varchar(45) DEFAULT NULL,
  `survey_entity_id` varchar(45) DEFAULT NULL,
  `survey_answer_entity_id` varchar(45) DEFAULT NULL,
  `q_checkbox_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkbox_entity`
--

LOCK TABLES `checkbox_entity` WRITE;
/*!40000 ALTER TABLE `checkbox_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkbox_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choice_entity`
--

DROP TABLE IF EXISTS `choice_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choice_entity` (
  `id` varchar(45) NOT NULL,
  `other_text` varchar(45) DEFAULT NULL,
  `survery_entity_id` varchar(45) DEFAULT NULL,
  `survey_answer_entity_id` varchar(45) DEFAULT NULL,
  `question_entity_id` varchar(45) DEFAULT NULL,
  `q_choice_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choice_entity`
--

LOCK TABLES `choice_entity` WRITE;
/*!40000 ALTER TABLE `choice_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `choice_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_entity`
--

DROP TABLE IF EXISTS `comment_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_entity` (
  `id` varchar(45) NOT NULL,
  `user_entity_id` varchar(45) DEFAULT NULL,
  `content` longtext,
  `created_date` date DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_entity`
--

LOCK TABLES `comment_entity` WRITE;
/*!40000 ALTER TABLE `comment_entity` DISABLE KEYS */;
INSERT INTO `comment_entity` VALUES ('2','4028ab0f63269c660163269eb9a50000','贫对富，塞对通，野叟对溪童。鬓皤对眉绿，齿皓对唇红。天浩浩，日融融，佩剑对弯弓。半溪流水绿，千树落花红。野渡燕穿杨柳雨，芳池鱼戏芰荷风。女子眉纤，额下现一弯新月；男儿气壮，胸中吐万丈长虹。','2018-05-12',NULL,NULL),('4028ab0f63afc0df0163afe6cfc20000','1','算法大家谈','2018-05-30',NULL,NULL),('4028ab0f63afc0df0163aff685d60001','1','It’s like going to a movie with your friends and finding a place','2018-05-30',NULL,NULL),('4028ab0f63afc0df0163b00781f50002','1','云对雨，雪对风，晚照对晴空。来鸿对去燕，宿鸟对鸣虫。三尺剑，六钧弓，岭北对江东。人间清暑殿，天上广寒宫。两岸晓烟杨柳绿，一园春雨杏花红。两鬓风霜，途次早行之客；一蓑烟雨，溪边晚钓之翁。','2018-05-30',NULL,NULL),('4028ab0f63afc0df0163b007b7aa0003','1','沿对革，异对同，白叟对黄童。江风对海雾，牧子对渔翁。颜巷陋，阮途穷，冀北对辽东。池中濯足水，门外打头风。梁帝讲经同泰寺，汉皇置酒未央宫。尘虑萦心，懒抚七弦绿绮；霜华满鬓，羞看百炼青铜。','2018-05-30',NULL,NULL),('4028ab0f63afc0df0163b007e5190004','1','贫对富，塞对通，野叟对溪童。鬓皤对眉绿，齿皓对唇红。天浩浩，日融融，佩剑对弯弓。半溪流水绿，千树落花红。野渡燕穿杨柳雨，芳池鱼戏芰荷风。女子眉纤，额下现一弯新月；男儿气壮，胸中吐万丈长虹。','2018-05-30',NULL,NULL),('4028ab0f63afc0df0163b00822db0005','1','春对夏，秋对冬，暮鼓对晨钟。观山对玩水，绿竹对苍松。冯妇虎，叶公龙，舞蝶对鸣蛩。衔泥双紫燕，课蜜几黄蜂。春日园中莺恰恰，秋天塞外雁雍雍。秦岭云横，迢递八千远路；巫山雨洗，嵯峨十二危峰。','2018-05-30',NULL,NULL);
/*!40000 ALTER TABLE `comment_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
INSERT INTO `entry` VALUES (1,'2016-01-02 05:00:00','Today I will learn Spring Boot','Get to know Spring Boot'),(2,'2016-01-03 00:00:00','I will do my first Spring Boot project','Simple Spring Boot Project'),(3,'2016-02-02 00:00:00','Read more about Spring Boot','Spring Boot Reading'),(4,'2016-02-05 00:00:00','Learn Spring Boot using Cloud Foundry','Spring Boot in the Cloud');
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson_entity`
--

DROP TABLE IF EXISTS `lesson_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_entity` (
  `id` varchar(45) NOT NULL,
  `created_date` date DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `student_entity_id` varchar(45) DEFAULT NULL,
  `teacher_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_entity`
--

LOCK TABLES `lesson_entity` WRITE;
/*!40000 ALTER TABLE `lesson_entity` DISABLE KEYS */;
INSERT INTO `lesson_entity` VALUES ('1',NULL,NULL,NULL,'4028ab0f6349ef61016349f44f790006','1'),('2',NULL,NULL,NULL,'4028ab0f63269c660163269eb9a50000','1');
/*!40000 ALTER TABLE `lesson_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `q_checkbox_entity`
--

DROP TABLE IF EXISTS `q_checkbox_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `q_checkbox_entity` (
  `id` varchar(45) NOT NULL,
  `question_entity_id` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `checkType` int(10) DEFAULT NULL,
  `queue` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `q_checkbox_entity`
--

LOCK TABLES `q_checkbox_entity` WRITE;
/*!40000 ALTER TABLE `q_checkbox_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `q_checkbox_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `q_choice_entity`
--

DROP TABLE IF EXISTS `q_choice_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `q_choice_entity` (
  `id` varchar(45) NOT NULL,
  `optionName` varchar(45) DEFAULT NULL,
  `orderById` int(11) DEFAULT NULL,
  `question_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `q_choice_entity`
--

LOCK TABLES `q_choice_entity` WRITE;
/*!40000 ALTER TABLE `q_choice_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `q_choice_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_entity`
--

DROP TABLE IF EXISTS `question_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_entity` (
  `id` varchar(255) NOT NULL,
  `survey_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_entity`
--

LOCK TABLES `question_entity` WRITE;
/*!40000 ALTER TABLE `question_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_anwser_entity`
--

DROP TABLE IF EXISTS `survey_anwser_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_anwser_entity` (
  `id` varchar(45) NOT NULL,
  `user_entity_id` varchar(45) DEFAULT NULL,
  `survey_entity_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_anwser_entity`
--

LOCK TABLES `survey_anwser_entity` WRITE;
/*!40000 ALTER TABLE `survey_anwser_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_anwser_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_entity`
--

DROP TABLE IF EXISTS `survey_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_entity` (
  `id` varchar(45) NOT NULL,
  `answer_number` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `html_path` varchar(45) DEFAULT NULL,
  `sid` varchar(45) DEFAULT NULL,
  `survey_name` varchar(45) DEFAULT NULL,
  `survey_question_num` int(11) DEFAULT NULL,
  `survey_status` varchar(45) DEFAULT NULL,
  `User_Entity_id` varchar(45) NOT NULL,
  `last_modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`User_Entity_id`),
  KEY `fk_SurveyDirectoryEntity_UserEntity1_idx` (`User_Entity_id`),
  CONSTRAINT `fk_SurveyDirectoryEntity_UserEntity1` FOREIGN KEY (`User_Entity_id`) REFERENCES `user_entity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_entity`
--

LOCK TABLES `survey_entity` WRITE;
/*!40000 ALTER TABLE `survey_entity` DISABLE KEYS */;
INSERT INTO `survey_entity` VALUES ('1',1,'2018-01-01',NULL,NULL,'模拟试卷1',NULL,NULL,'1',NULL,NULL),('2',0,'2018-02-01',NULL,NULL,'模拟试卷2',NULL,NULL,'1',NULL,NULL),('3',0,'2018-05-08',NULL,NULL,'模拟试卷3',NULL,NULL,'4028ab0f63269c660163269eb9a50000',NULL,NULL),('4',0,'2018-05-08',NULL,NULL,'模拟试卷4',NULL,NULL,'4028ab0f63269c660163269eb9a50000',NULL,NULL),('5',0,'2018-05-08',NULL,NULL,'模拟试卷5',NULL,NULL,'4028ab0f63269c660163269eb9a50000',NULL,NULL),('6',0,'2018-05-08',NULL,NULL,'模拟试卷6',NULL,NULL,'1',NULL,NULL),('7',0,'2018-05-08',NULL,NULL,'模拟试卷7',NULL,NULL,'1',NULL,NULL),('8',0,'2018-05-08',NULL,NULL,'模拟试卷8',NULL,NULL,'1',NULL,NULL);
/*!40000 ALTER TABLE `survey_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_app_entity`
--

DROP TABLE IF EXISTS `user_app_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_app_entity` (
  `id` varchar(45) NOT NULL,
  `app_link` varchar(45) DEFAULT NULL,
  `app_image` varchar(45) DEFAULT NULL,
  `app_name` varchar(45) DEFAULT NULL,
  `user_entity_id` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_app_entity`
--

LOCK TABLES `user_app_entity` WRITE;
/*!40000 ALTER TABLE `user_app_entity` DISABLE KEYS */;
INSERT INTO `user_app_entity` VALUES ('1','/file','1','课件信息的管理','','TEACHER'),('10','/share','10','相关学习资料',NULL,'STUDENT'),('11','/','11','在线测试',NULL,'STUDENT'),('12','/video/playlist','12','视频点播',NULL,'STUDENT'),('2','/video/playlist','2','视频点播模块','','TEACHER'),('3','/file','3','作业管理模块','','TEACHER'),('4','/surveys','4','在线测试模块','','TEACHER'),('5','/admin','5','系统管理模块','','TEACHER'),('6','/comment','6','留言板','','TEACHER'),('7','/comment','7','留言板','','STUDENT'),('8','/file','8','作业提交',NULL,'STUDENT'),('9','/share','9','分享学习资源',NULL,'TEACHER');
/*!40000 ALTER TABLE `user_app_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_entity`
--

DROP TABLE IF EXISTS `user_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_entity` (
  `id` varchar(45) NOT NULL,
  `out_date` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `display_name` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_modified_date` varchar(45) DEFAULT NULL,
  `version` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `confirmation_token` varchar(45) DEFAULT NULL,
  `student_id` varchar(45) DEFAULT NULL,
  `last_login_time` varchar(45) DEFAULT NULL,
  `profile_picture` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_entity`
--

LOCK TABLES `user_entity` WRITE;
/*!40000 ALTER TABLE `user_entity` DISABLE KEYS */;
INSERT INTO `user_entity` VALUES ('1',NULL,'13550907617@163.com','Floyd','程淼','{bcrypt}$2a$10$mLBUJlHtRh0XIApQottLFOiuHL6GkMvXzBVk0pB1j3d0lDWdNuCXa','2018-02-01',NULL,NULL,NULL,NULL,'2','201410804000',NULL,NULL),('4028ab0f63269c660163269eb9a50000','2018-05-15','790013438@qq.com','程立果','floyd','{bcrypt}$2a$10$vtWWgs5VU8Gona5.Fy1TAO7VUcp99A/k0qUbXewcBGd/.0zOj4HTe','2018-02-03',NULL,NULL,NULL,NULL,'','201410804001',NULL,NULL);
/*!40000 ALTER TABLE `user_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_entity`
--

DROP TABLE IF EXISTS `user_role_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role_entity` (
  `id` varchar(45) NOT NULL,
  `user_entity_id` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_entity`
--

LOCK TABLES `user_role_entity` WRITE;
/*!40000 ALTER TABLE `user_role_entity` DISABLE KEYS */;
INSERT INTO `user_role_entity` VALUES ('1','1','TEACHER',NULL,NULL,NULL),('4028ab0f6349fd8e01634a02dace0000','4028ab0f6349ef61016349f44f790006','STUDENT','2018-05-10',NULL,NULL),('4028ab0f635d626901635d65a9350000','4028ab0f63269c660163269eb9a50000','STUDENT','2018-05-14',NULL,NULL);
/*!40000 ALTER TABLE `user_role_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_entity`
--

DROP TABLE IF EXISTS `video_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video_entity` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `uuid` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_entity`
--

LOCK TABLES `video_entity` WRITE;
/*!40000 ALTER TABLE `video_entity` DISABLE KEYS */;
INSERT INTO `video_entity` VALUES ('1','北大公开课_算法设计与分析屈婉玲教授1.mp4','2.mp4','2018-05-12',NULL,NULL),('4028ab0f639f9a7001639fa642fd0001','北大公开课_算法设计与分析屈婉玲教授5.mp4','61c9249a-c57d-4666-a187-c1277e1195f8','2018-05-27',NULL,NULL);
/*!40000 ALTER TABLE `video_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pzhu'
--

--
-- Dumping routines for database 'pzhu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-02  0:11:04
