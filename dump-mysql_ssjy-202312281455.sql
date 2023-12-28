-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: mysql.cnewsfhi3ek0.ap-northeast-2.rds.amazonaws.com    Database: mysql_ssjy
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `ACCUM_RATE`
--

DROP TABLE IF EXISTS `ACCUM_RATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ACCUM_RATE` (
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `section` int DEFAULT NULL,
  `accum_rate` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACCUM_RATE`
--

LOCK TABLES `ACCUM_RATE` WRITE;
/*!40000 ALTER TABLE `ACCUM_RATE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACCUM_RATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAST`
--

DROP TABLE IF EXISTS `CAST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CAST` (
  `movie_idx` int NOT NULL,
  `persion_idx` int NOT NULL,
  `role` varchar(20) DEFAULT NULL,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `cast_gb` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`movie_idx`,`persion_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAST`
--

LOCK TABLES `CAST` WRITE;
/*!40000 ALTER TABLE `CAST` DISABLE KEYS */;
INSERT INTO `CAST` VALUES (1,1,'로버트 오펜하이머','2023-09-14 03:46:33',NULL,NULL,'주연'),(1,2,'키티 오펜하이머','2023-09-14 03:48:32',NULL,NULL,'주연'),(1,3,'레슬리 그로브스','2023-09-14 10:48:04',NULL,NULL,'주연'),(1,4,'루이스 스트로스','2023-09-14 10:48:30',NULL,NULL,'주연'),(1,5,'진 태트록','2023-09-14 10:48:57',NULL,NULL,'주연'),(1,6,NULL,'2023-09-14 10:49:52',NULL,NULL,'주연'),(1,7,NULL,'2023-09-14 10:50:22',NULL,NULL,'주연'),(1,8,NULL,'2023-09-14 10:50:33',NULL,NULL,'주연'),(1,9,'닐스 보어','2023-09-14 10:51:06',NULL,NULL,'주연'),(1,10,'크리스토퍼 놀란','2023-09-14 10:51:36',NULL,NULL,'감독'),(2,11,'김성훈','2023-09-30 08:45:24',NULL,NULL,'감독'),(2,12,'민준','2023-09-30 08:46:50',NULL,NULL,'주연'),(2,13,'판수','2023-09-30 08:47:10',NULL,NULL,'주연');
/*!40000 ALTER TABLE `CAST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FILE`
--

DROP TABLE IF EXISTS `FILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FILE` (
  `file_idx` int NOT NULL AUTO_INCREMENT COMMENT '파일IDX',
  `create_dt` timestamp NOT NULL COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `table_idx` int DEFAULT '0',
  `file_path` varchar(100) DEFAULT NULL,
  `file_name` varchar(50) DEFAULT NULL,
  `table_gb` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '테이블 구분',
  `file_top_path` varchar(100) DEFAULT NULL,
  `file_top_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`file_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FILE`
--

LOCK TABLES `FILE` WRITE;
/*!40000 ALTER TABLE `FILE` DISABLE KEYS */;
INSERT INTO `FILE` VALUES (1,'2023-09-09 08:38:58',NULL,NULL,55,'/img/asd.jpg','asd.jpg','MEMBERS','',''),(12,'2023-10-31 20:20:59',NULL,NULL,55,'/img/Oppenheimer.jpg','Oppenheimer.jpg','movies','/img/Oppenheimer.jpg','Oppenheimer.jpg'),(14,'2023-09-26 10:45:44',NULL,NULL,55,'/img/Informality.jpg','Informality.jpg','movies','/img/Informality.jpg','Informality.jpg'),(15,'2023-09-26 10:47:01',NULL,NULL,55,'/img/Elemental.jpg','Elemental.jpg','movies','/img/Elemental.jpg','Elemental.jpg'),(16,'2023-09-26 10:47:39',NULL,NULL,55,'/img/MissionImpossible.jpg','MissionImpossible.jpg','movies','/img/MissionImpossible.jpg','MissionImpossible.jpg'),(17,'2023-09-26 10:48:09',NULL,NULL,55,'/img/Smuggling.jpg','Smuggling.jpg','movies','/img/Smuggling.jpg','Smuggling.jpg'),(199,'2023-12-27 01:59:59',NULL,NULL,82,NULL,NULL,'movies','/files/그림1.jpg','그림1.jpg'),(200,'2023-12-27 01:59:59',NULL,NULL,84,'/files/그림2.jpg','그림2.jpg','movies',NULL,NULL),(201,'2023-12-27 01:59:59',NULL,NULL,84,'/files/그림11.jpg','그림11.jpg','movies',NULL,NULL),(207,'2023-12-27 02:29:39',NULL,NULL,87,NULL,NULL,'movies','/files/501055cd-d27c-403b-90bc-cd021de6ced5_데이터랩.png','501055cd-d27c-403b-90bc-cd021de6ced5_데이터랩.png'),(208,'2023-12-27 02:29:39',NULL,NULL,87,'/files/153e3166-4efa-488b-9d48-b6d7fc30b933_데이터랩.png','153e3166-4efa-488b-9d48-b6d7fc30b933_데이터랩.png','movies',NULL,NULL),(209,'2023-12-27 02:29:39',NULL,NULL,87,'/files/bb1126d4-b063-4634-b410-2befc9e2720a_데이터랩.png','bb1126d4-b063-4634-b410-2befc9e2720a_데이터랩.png','movies',NULL,NULL),(210,'2023-12-27 03:20:17',NULL,NULL,88,NULL,NULL,'movies','/files/방탈출 노션 QR.jpg','방탈출 노션 QR.jpg'),(211,'2023-12-27 03:20:17',NULL,NULL,88,'/files/그림2.png','그림2.png','movies',NULL,NULL);
/*!40000 ALTER TABLE `FILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MAILAUTH`
--

DROP TABLE IF EXISTS `MAILAUTH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MAILAUTH` (
  `auth_id` int NOT NULL AUTO_INCREMENT COMMENT '메일_IDX',
  `create_dt` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `auth_num` varchar(100) NOT NULL COMMENT '인증번호',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='메일인증번호';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MAILAUTH`
--

LOCK TABLES `MAILAUTH` WRITE;
/*!40000 ALTER TABLE `MAILAUTH` DISABLE KEYS */;
INSERT INTO `MAILAUTH` VALUES (2,'2023-09-10 14:38:54',NULL,NULL,'123'),(3,'2023-09-10 14:39:32',NULL,NULL,'123'),(5,'2023-09-10 14:55:46',NULL,NULL,'802851'),(6,'2023-09-10 14:57:34',NULL,NULL,'892284'),(7,'2023-09-10 15:04:13',NULL,NULL,'824372'),(8,'2023-09-10 15:04:47',NULL,NULL,'824372'),(9,'2023-09-10 15:05:19',NULL,NULL,'824372'),(10,'2023-09-10 15:05:51',NULL,NULL,'824372'),(11,'2023-09-10 15:07:26',NULL,NULL,'824372'),(12,'2023-09-10 15:08:45',NULL,NULL,'824372'),(13,'2023-09-19 12:58:53',NULL,NULL,'331032'),(14,'2023-09-19 13:00:46',NULL,NULL,'331032'),(15,'2023-09-19 13:09:34',NULL,NULL,'331032'),(16,'2023-09-19 13:09:43',NULL,NULL,'331032'),(17,'2023-09-19 13:10:44',NULL,NULL,'331032'),(18,'2023-09-19 13:10:57',NULL,NULL,'331032'),(19,'2023-09-19 13:11:30',NULL,NULL,'331032'),(20,'2023-09-19 13:11:39',NULL,NULL,'331032'),(21,'2023-10-07 07:38:00',NULL,NULL,'279016'),(22,'2023-10-07 08:48:24',NULL,NULL,'843967'),(23,'2023-10-07 10:34:08',NULL,NULL,'416907'),(24,'2023-10-07 10:40:03',NULL,NULL,'106939'),(25,'2023-10-07 10:42:59',NULL,NULL,'106939'),(26,'2023-10-07 11:06:26',NULL,NULL,'733452'),(27,'2023-10-07 11:07:17',NULL,NULL,'733452'),(28,'2023-10-07 11:08:22',NULL,NULL,'516618'),(29,'2023-10-07 11:09:22',NULL,NULL,'516618'),(30,'2023-10-07 11:41:33',NULL,NULL,'901898'),(31,'2023-10-09 06:19:58',NULL,NULL,'029839'),(32,'2023-11-12 05:50:11',NULL,NULL,'833752'),(33,'2023-11-12 05:56:20',NULL,NULL,'833752'),(34,'2023-11-12 06:06:24',NULL,NULL,'376698'),(35,'2023-11-12 06:08:41',NULL,NULL,'376698'),(36,'2023-11-12 06:32:25',NULL,NULL,'537018'),(37,'2023-11-12 06:38:45',NULL,NULL,'334000'),(38,'2023-11-12 07:18:41',NULL,NULL,'742168'),(39,'2023-11-12 07:22:19',NULL,NULL,'061778'),(40,'2023-11-12 07:29:44',NULL,NULL,'061778'),(41,'2023-11-12 07:38:53',NULL,NULL,'061778'),(42,'2023-11-12 07:49:05',NULL,NULL,'061778'),(43,'2023-11-12 07:50:53',NULL,NULL,'061778'),(44,'2023-11-12 08:35:20',NULL,NULL,'836314'),(45,'2023-11-12 08:35:59',NULL,NULL,'454630'),(46,'2023-11-12 08:36:35',NULL,NULL,'454630'),(47,'2023-11-12 09:03:59',NULL,NULL,'721815'),(48,'2023-11-17 11:45:23',NULL,NULL,'278345'),(49,'2023-11-26 10:55:41',NULL,NULL,'684440'),(50,'2023-11-27 07:39:51',NULL,NULL,'659186'),(51,'2023-11-27 07:43:38',NULL,NULL,'917299'),(52,'2023-11-27 07:44:21',NULL,NULL,'659186'),(53,'2023-11-27 11:32:24',NULL,NULL,'308999');
/*!40000 ALTER TABLE `MAILAUTH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEMBERS`
--

DROP TABLE IF EXISTS `MEMBERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MEMBERS` (
  `member_id` varchar(100) NOT NULL COMMENT '회원_IDX',
  `create_dt` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '비밀번호',
  `member_name` varchar(100) NOT NULL COMMENT '이름',
  `member_phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '전화번호',
  `email` varchar(100) NOT NULL COMMENT '이메일',
  `marketing_yn` varchar(1) DEFAULT 'Y' COMMENT '마케팅동의여부',
  `sms_yn` varchar(1) DEFAULT 'Y' COMMENT 'SMS수신여부',
  `email_yn` varchar(1) DEFAULT 'Y' COMMENT '이메일수신여부',
  `kakao_id_gb` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '카카오ID 구분',
  `member_gb` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'U' COMMENT '구분(U:유저, A:관리자)',
  `member_gender` varchar(1) NOT NULL COMMENT '성별',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEMBERS`
--

LOCK TABLES `MEMBERS` WRITE;
/*!40000 ALTER TABLE `MEMBERS` DISABLE KEYS */;
INSERT INTO `MEMBERS` VALUES ('dd123hg','2023-11-27 11:32:36',NULL,NULL,'d23181ec1bbb22d3584a69d5c6d05455f77a5a34565739a50450f1f5314129643a6d15bc58bd45ab664f9d6b93984faaa6f7695a4a2f4d036eebe653f45beb4e','오수민','01052629274','osn9274@naver.com',NULL,NULL,'Y',NULL,'U','M'),('hsyoun1','2023-11-12 07:30:02',NULL,NULL,'cd943dc6fed752ac6e14b8e4ada29f3be7fa4755533057f64cdd7d80c871fb211ff5474be5cb70d4bbba0b7d6bb57617e7a6d01232a5f029111778240114fcef','함세윤','01052629274','osn9274@naver.com','Y','Y','Y',NULL,'U','F'),('KA-3201805429','2023-11-29 09:22:40',NULL,NULL,NULL,'오수민',NULL,'osn9274@naver.com','Y','Y','Y','Y','U','M'),('KA-3214176230','2023-12-07 12:46:10',NULL,NULL,NULL,'함세윤',NULL,'mellovove@naver.com','Y','Y','Y','Y','U','F'),('KA-3222351471','2023-12-13 07:38:51',NULL,NULL,NULL,'오정훈',NULL,'twzt9983@naver.com','Y','Y','Y','Y','U','M'),('osn9274','2023-11-12 06:48:18',NULL,NULL,'cd943dc6fed752ac6e14b8e4ada29f3be7fa4755533057f64cdd7d80c871fb211ff5474be5cb70d4bbba0b7d6bb57617e7a6d01232a5f029111778240114fcef','오수민','01052629274','osn9274@naver.com',NULL,NULL,NULL,NULL,'U','M'),('osn92741','2023-11-12 07:23:29',NULL,NULL,'cd943dc6fed752ac6e14b8e4ada29f3be7fa4755533057f64cdd7d80c871fb211ff5474be5cb70d4bbba0b7d6bb57617e7a6d01232a5f029111778240114fcef','오수민','01052629274','osn9274@naver.com','Y','Y','Y',NULL,'U','M');
/*!40000 ALTER TABLE `MEMBERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MOVIES`
--

DROP TABLE IF EXISTS `MOVIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MOVIES` (
  `movie_idx` int NOT NULL AUTO_INCREMENT COMMENT '영화_IDX',
  `create_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` date DEFAULT NULL COMMENT '종료일',
  `movie_name_hngl` varchar(100) NOT NULL COMMENT '영화명_HNGL',
  `movie_name_eng` varchar(100) DEFAULT NULL COMMENT '영화명_ENG',
  `opening_dt` date DEFAULT NULL COMMENT '개봉일',
  `movie_rate` varchar(100) DEFAULT NULL COMMENT '등급',
  `genre` varchar(100) DEFAULT NULL COMMENT '장르',
  `movie_country` varchar(100) DEFAULT NULL COMMENT '국가',
  `running_time` varchar(100) DEFAULT NULL COMMENT '러닝타임',
  `movie_distributor` varchar(100) DEFAULT NULL COMMENT '배급',
  `movie_info` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '소개글',
  PRIMARY KEY (`movie_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='영화';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MOVIES`
--

LOCK TABLES `MOVIES` WRITE;
/*!40000 ALTER TABLE `MOVIES` DISABLE KEYS */;
INSERT INTO `MOVIES` VALUES (2,'2023-10-31 05:56:37',NULL,'2023-12-29','육펜하이머','uppeheimer','2023-10-31','15','스릴러','미국','150분','쇼박스','과학실험'),(3,'2023-10-31 05:57:11',NULL,'2023-12-30','칠펜하이머','chilppeheimer','2023-10-31','15','스릴러','미국','150분','쇼박스','test'),(84,'2023-12-27 01:59:59',NULL,'2023-12-30','테스트영화','테스트영화제목','2023-12-26','공포','공포','나라','60분','공포','공포공포영화소개'),(87,'2023-12-27 02:29:39',NULL,NULL,'a','a','2023-01-09','a','a','a','a','a','a'),(88,'2023-12-27 03:20:17',NULL,NULL,'3','3','2012-12-27','3','3','3','3','3','3');
/*!40000 ALTER TABLE `MOVIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSON`
--

DROP TABLE IF EXISTS `PERSON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PERSON` (
  `persion_idx` int NOT NULL AUTO_INCREMENT,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `person_name_hngl` varchar(20) DEFAULT NULL,
  `person_name_eng` varchar(50) DEFAULT NULL,
  `person_country` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `birth_dt` varchar(20) DEFAULT NULL,
  `height` varchar(20) DEFAULT NULL,
  `debut_dt` varchar(20) DEFAULT NULL,
  `debut_movie` varchar(20) DEFAULT NULL,
  `movie_idx` int NOT NULL,
  PRIMARY KEY (`persion_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSON`
--

LOCK TABLES `PERSON` WRITE;
/*!40000 ALTER TABLE `PERSON` DISABLE KEYS */;
INSERT INTO `PERSON` VALUES (1,'2023-09-13 11:54:19',NULL,NULL,'킬리언 머피','Cillian Murphy','아일랜드','Man','1976.05.25','175','1996','디스코 피그',1),(2,'2023-09-13 11:57:21',NULL,NULL,'에밀리 블런트','Emily Olivia Leah Blunt','영국','Woman','1983.02.23','170','2003','더 로얄 패밀리',1),(3,'2023-09-13 11:59:44',NULL,NULL,'맷 데이먼','Matt Damon, Matthew Paige Damon','미국','Man','1970.10.08','178','1998','미스틱 피자',1),(4,'2023-09-13 12:01:03',NULL,NULL,'로버트 다우니 주니어','Robert Downey Jr','미국','Man','1965.04.04','174','1970','파운드',1),(5,'2023-09-13 12:03:06',NULL,NULL,'플로렌스 퓨','Florence Pugh','영국',' Woman','1996.01.03','163','2016','폴링',1),(6,'2023-09-13 12:05:29',NULL,NULL,'조쉬 하트넷	','Josh Hartnett','미국',' Man','1978.07.21','191','1998','할로윈 7-H20',1),(7,'2023-09-13 12:06:59',NULL,NULL,'케이시 애플렛','Casey Affleck','미국',' Man','1975.08.12','175','1995','투 다이 포',1),(8,'2023-09-13 12:08:17',NULL,NULL,'라미 말렉','Rami Malek','미국',' Man','1981.05.12','171','2006','박물관이 살아있다!',1),(9,'2023-09-13 12:09:52',NULL,NULL,'케네스 브래너','Kenneth Branagh','영국',' Man','1960.12.10','177','1981','불의 전차',1),(10,'2023-09-13 12:11:04',NULL,NULL,'크리스토퍼 놀란','Christopher Nolan','영국',' Man','1970.07.30','181','1998','미행',1),(11,'2023-09-28 12:26:39',NULL,NULL,'김성훈','Kim Seong Hoon','한국',' Man','1971.02.20','184','2003','오! 해피데이',2),(12,'2023-09-30 08:40:21',NULL,NULL,'하정우','Ha Jeong Woo','한국',' Man','1978.03.11',NULL,'2003','마들렌',2),(13,'2023-09-30 08:42:16',NULL,NULL,'주지훈','Joo Ji Hoon','한국',' Man','1982.05.16','187','2008','서양골동양과자점 엔티크',2);
/*!40000 ALTER TABLE `PERSON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `POINT_USAGE_DETAIL`
--

DROP TABLE IF EXISTS `POINT_USAGE_DETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `POINT_USAGE_DETAIL` (
  `point_usage_detail_idx` varchar(20) DEFAULT NULL,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `member_id` varchar(20) DEFAULT NULL,
  `point_usage` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `POINT_USAGE_DETAIL`
--

LOCK TABLES `POINT_USAGE_DETAIL` WRITE;
/*!40000 ALTER TABLE `POINT_USAGE_DETAIL` DISABLE KEYS */;
/*!40000 ALTER TABLE `POINT_USAGE_DETAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT`
--

DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUCT` (
  `product_idx` int NOT NULL AUTO_INCREMENT,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `product_gb` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '(영화티켓:T , 팝콘 : P , 음료: D, 스낵: S, 기프트카드 : G)',
  `product_name` varchar(20) DEFAULT NULL,
  `product_price` int DEFAULT NULL,
  `product_info` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`product_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES (1,'2023-12-03 07:33:52',NULL,NULL,'T','우대2D',5000,'우대할인 영화 가격'),(2,'2023-12-03 07:37:17',NULL,NULL,'T','조조2D',6000,'조조할인 영화 가격'),(3,'2023-12-03 07:37:30',NULL,NULL,'T','성인2D',8000,'영화 가격');
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PURCHASE_DETAIL`
--

DROP TABLE IF EXISTS `PURCHASE_DETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PURCHASE_DETAIL` (
  `purchase_detail_idx` int NOT NULL AUTO_INCREMENT COMMENT '상품상세정보IDX',
  `create_dt` timestamp NULL DEFAULT NULL COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `product_idx` int NOT NULL COMMENT '구매상품IDX',
  `purchase_info_idx` varchar(50) NOT NULL COMMENT '상품구매정보IDX',
  PRIMARY KEY (`purchase_detail_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원구매내역';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PURCHASE_DETAIL`
--

LOCK TABLES `PURCHASE_DETAIL` WRITE;
/*!40000 ALTER TABLE `PURCHASE_DETAIL` DISABLE KEYS */;
INSERT INTO `PURCHASE_DETAIL` VALUES (1,'2023-12-07 12:48:23',NULL,NULL,3,'KA-3214176230202312341214822'),(2,'2023-12-07 12:48:23',NULL,NULL,3,'KA-3214176230202312341214822'),(3,'2023-12-07 12:48:23',NULL,NULL,2,'KA-3214176230202312341214822'),(4,'2023-12-07 12:48:23',NULL,NULL,1,'KA-3214176230202312341214822'),(5,'2023-12-07 12:52:19',NULL,NULL,3,'KA-3214176230202312341215218'),(6,'2023-12-07 12:52:19',NULL,NULL,3,'KA-3214176230202312341215218'),(7,'2023-12-07 12:52:19',NULL,NULL,3,'KA-3214176230202312341215218'),(8,'2023-12-07 12:52:19',NULL,NULL,3,'KA-3214176230202312341215218'),(9,'2023-12-07 12:52:19',NULL,NULL,3,'KA-3214176230202312341215218'),(10,'2023-12-07 12:52:19',NULL,NULL,3,'KA-3214176230202312341215218'),(11,'2023-12-12 03:47:04',NULL,NULL,2,'KA-3201805429202312346124704'),(12,'2023-12-12 03:48:24',NULL,NULL,2,'KA-3201805429202312346124823'),(13,'2023-12-16 07:13:10',NULL,NULL,3,'KA-3201805429202312350161310'),(14,'2023-12-16 07:13:10',NULL,NULL,2,'KA-3201805429202312350161310'),(15,'2023-12-16 07:13:10',NULL,NULL,1,'KA-3201805429202312350161310'),(16,'2023-12-16 07:13:10',NULL,NULL,3,'KA-3201805429202312350161310'),(21,'2023-12-18 15:57:45',NULL,NULL,2,'KA-3201805429202312353005728'),(22,'2023-12-18 15:57:45',NULL,NULL,2,'KA-3201805429202312353005728'),(23,'2023-12-18 15:57:45',NULL,NULL,3,'KA-3201805429202312353005728'),(24,'2023-12-18 15:57:45',NULL,NULL,1,'KA-3201805429202312353005728');
/*!40000 ALTER TABLE `PURCHASE_DETAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PURCHASE_INFO`
--

DROP TABLE IF EXISTS `PURCHASE_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PURCHASE_INFO` (
  `purchase_info_idx` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '구매정보내역인덱스',
  `create_dt` timestamp NULL DEFAULT NULL COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `member_id` varchar(100) NOT NULL COMMENT '회원IDX',
  `total_price` int NOT NULL COMMENT '총합가격',
  `tid` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '''카카오결제 고유번호''',
  PRIMARY KEY (`purchase_info_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PURCHASE_INFO`
--

LOCK TABLES `PURCHASE_INFO` WRITE;
/*!40000 ALTER TABLE `PURCHASE_INFO` DISABLE KEYS */;
INSERT INTO `PURCHASE_INFO` VALUES ('KA-3201805429202312346124704','2023-12-12 03:47:04',NULL,NULL,'KA-3201805429',6000,''),('KA-3201805429202312346124823','2023-12-12 03:48:24',NULL,NULL,'KA-3201805429',6000,''),('KA-3201805429202312350161310','2023-12-16 07:13:10',NULL,NULL,'KA-3201805429',27000,''),('KA-3201805429202312353005728','2023-12-18 15:57:45',NULL,NULL,'KA-3201805429',25000,'T5806be83c8776d36853'),('KA-3214176230202312341214822','2023-12-07 12:48:23',NULL,NULL,'KA-3214176230',27000,''),('KA-3214176230202312341215218','2023-12-07 12:52:19',NULL,NULL,'KA-3214176230',48000,'');
/*!40000 ALTER TABLE `PURCHASE_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REVIEWS`
--

DROP TABLE IF EXISTS `REVIEWS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REVIEWS` (
  `movie_idx` int NOT NULL,
  `member_id` int NOT NULL,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `star` varchar(20) DEFAULT NULL,
  `review_info` varchar(20) DEFAULT NULL,
  `spo_yn` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`movie_idx`,`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REVIEWS`
--

LOCK TABLES `REVIEWS` WRITE;
/*!40000 ALTER TABLE `REVIEWS` DISABLE KEYS */;
/*!40000 ALTER TABLE `REVIEWS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SCREEN`
--

DROP TABLE IF EXISTS `SCREEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SCREEN` (
  `screen_idx` int NOT NULL AUTO_INCREMENT COMMENT '상영관_IDX',
  `create_dt` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `theater_idx` int NOT NULL COMMENT '극장_IDX',
  `screen_number` varchar(100) NOT NULL COMMENT '상영관번호',
  `floor` varchar(100) NOT NULL COMMENT '층',
  `screen_gb` varchar(100) NOT NULL COMMENT '구분',
  `seat_total` int NOT NULL COMMENT '좌석수',
  PRIMARY KEY (`screen_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상영관';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SCREEN`
--

LOCK TABLES `SCREEN` WRITE;
/*!40000 ALTER TABLE `SCREEN` DISABLE KEYS */;
INSERT INTO `SCREEN` VALUES (1,'2023-09-09 09:05:14',NULL,NULL,1,'1관','7층','4DX',72),(2,'2023-09-09 09:05:43',NULL,NULL,1,'2관','7층','',84),(3,'2023-09-09 09:05:53',NULL,NULL,1,'3관','7층','',60),(4,'2023-09-09 09:05:59',NULL,NULL,1,'4관','7층','',60),(5,'2023-09-09 09:06:24',NULL,NULL,1,'5관','8층','DOLBY',84),(6,'2023-09-09 09:06:30',NULL,NULL,1,'6관','8층','',84),(7,'2023-09-09 09:06:41',NULL,NULL,1,'7관','8층','SCREENX',84),(8,'2023-09-09 09:09:14',NULL,NULL,2,'1관','5층','4DX',72),(9,'2023-09-09 09:09:14',NULL,NULL,2,'2관','5층','',72),(10,'2023-09-09 09:09:14',NULL,NULL,2,'3관','5층','',72),(11,'2023-09-09 09:09:14',NULL,NULL,2,'4관','5층','',60),(12,'2023-09-09 09:09:14',NULL,NULL,2,'5관','6층','DOLBY',60),(13,'2023-09-09 09:09:14',NULL,NULL,2,'6관','6층','',60),(14,'2023-09-09 09:09:14',NULL,NULL,2,'7관','6층','SCREENX',60);
/*!40000 ALTER TABLE `SCREEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SEAT`
--

DROP TABLE IF EXISTS `SEAT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SEAT` (
  `screen_idx` int NOT NULL,
  `seat_number` varchar(20) NOT NULL,
  PRIMARY KEY (`screen_idx`,`seat_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEAT`
--

LOCK TABLES `SEAT` WRITE;
/*!40000 ALTER TABLE `SEAT` DISABLE KEYS */;
INSERT INTO `SEAT` VALUES (1,'A01'),(1,'A02'),(1,'A03'),(1,'A04'),(1,'A05'),(1,'A06'),(1,'A07'),(1,'A08'),(1,'A09'),(1,'A10'),(1,'A11'),(1,'A12'),(1,'B01'),(1,'B02'),(1,'B03'),(1,'B04'),(1,'B05'),(1,'B06'),(1,'B07'),(1,'B08'),(1,'B09'),(1,'B10'),(1,'B11'),(1,'B12'),(1,'C01'),(1,'C02'),(1,'C03'),(1,'C04'),(1,'C05'),(1,'C06'),(1,'C07'),(1,'C08'),(1,'C09'),(1,'C10'),(1,'C11'),(1,'C12'),(1,'D01'),(1,'D02'),(1,'D03'),(1,'D04'),(1,'D05'),(1,'D06'),(1,'D07'),(1,'D08'),(1,'D09'),(1,'D10'),(1,'D11'),(1,'D12'),(1,'E01'),(1,'E02'),(1,'E03'),(1,'E04'),(1,'E05'),(1,'E06'),(1,'E07'),(1,'E08'),(1,'E09'),(1,'E10'),(1,'E11'),(1,'E12'),(1,'F01'),(1,'F02'),(1,'F03'),(1,'F04'),(1,'F05'),(1,'F06'),(1,'F07'),(1,'F08'),(1,'F09'),(1,'F10'),(1,'F11'),(1,'F12'),(2,'A01'),(2,'A02'),(2,'A03'),(2,'A04'),(2,'A05'),(2,'A06'),(2,'A07'),(2,'A08'),(2,'A09'),(2,'A10'),(2,'A11'),(2,'A12'),(2,'B01'),(2,'B02'),(2,'B03'),(2,'B04'),(2,'B05'),(2,'B06'),(2,'B07'),(2,'B08'),(2,'B09'),(2,'B10'),(2,'B11'),(2,'B12'),(2,'C01'),(2,'C02'),(2,'C03'),(2,'C04'),(2,'C05'),(2,'C06'),(2,'C07'),(2,'C08'),(2,'C09'),(2,'C10'),(2,'C11'),(2,'C12'),(2,'D01'),(2,'D02'),(2,'D03'),(2,'D04'),(2,'D05'),(2,'D06'),(2,'D07'),(2,'D08'),(2,'D09'),(2,'D10'),(2,'D11'),(2,'D12'),(2,'E01'),(2,'E02'),(2,'E03'),(2,'E04'),(2,'E05'),(2,'E06'),(2,'E07'),(2,'E08'),(2,'E09'),(2,'E10'),(2,'E11'),(2,'E12'),(2,'F01'),(2,'F02'),(2,'F03'),(2,'F04'),(2,'F05'),(2,'F06'),(2,'F07'),(2,'F08'),(2,'F09'),(2,'F10'),(2,'F11'),(2,'F12'),(2,'G01'),(2,'G02'),(2,'G03'),(2,'G04'),(2,'G05'),(2,'G06'),(2,'G07'),(2,'G08'),(2,'G09'),(2,'G10'),(2,'G11'),(2,'G12'),(3,'A01'),(3,'A02'),(3,'A03'),(3,'A04'),(3,'A05'),(3,'A06'),(3,'A07'),(3,'A08'),(3,'A09'),(3,'A10'),(3,'A11'),(3,'A12'),(3,'B01'),(3,'B02'),(3,'B03'),(3,'B04'),(3,'B05'),(3,'B06'),(3,'B07'),(3,'B08'),(3,'B09'),(3,'B10'),(3,'B11'),(3,'B12'),(3,'C01'),(3,'C02'),(3,'C03'),(3,'C04'),(3,'C05'),(3,'C06'),(3,'C07'),(3,'C08'),(3,'C09'),(3,'C10'),(3,'C11'),(3,'C12'),(3,'D01'),(3,'D02'),(3,'D03'),(3,'D04'),(3,'D05'),(3,'D06'),(3,'D07'),(3,'D08'),(3,'D09'),(3,'D10'),(3,'D11'),(3,'D12'),(3,'E01'),(3,'E02'),(3,'E03'),(3,'E04'),(3,'E05'),(3,'E06'),(3,'E07'),(3,'E08'),(3,'E09'),(3,'E10'),(3,'E11'),(3,'E12'),(4,'A01'),(4,'A02'),(4,'A03'),(4,'A04'),(4,'A05'),(4,'A06'),(4,'A07'),(4,'A08'),(4,'A09'),(4,'A10'),(4,'A11'),(4,'A12'),(4,'B01'),(4,'B02'),(4,'B03'),(4,'B04'),(4,'B05'),(4,'B06'),(4,'B07'),(4,'B08'),(4,'B09'),(4,'B10'),(4,'B11'),(4,'B12'),(4,'C01'),(4,'C02'),(4,'C03'),(4,'C04'),(4,'C05'),(4,'C06'),(4,'C07'),(4,'C08'),(4,'C09'),(4,'C10'),(4,'C11'),(4,'C12'),(4,'D01'),(4,'D02'),(4,'D03'),(4,'D04'),(4,'D05'),(4,'D06'),(4,'D07'),(4,'D08'),(4,'D09'),(4,'D10'),(4,'D11'),(4,'D12'),(4,'E01'),(4,'E02'),(4,'E03'),(4,'E04'),(4,'E05'),(4,'E06'),(4,'E07'),(4,'E08'),(4,'E09'),(4,'E10'),(4,'E11'),(4,'E12'),(5,'A01'),(5,'A02'),(5,'A03'),(5,'A04'),(5,'A05'),(5,'A06'),(5,'A07'),(5,'A08'),(5,'A09'),(5,'A10'),(5,'A11'),(5,'A12'),(5,'B01'),(5,'B02'),(5,'B03'),(5,'B04'),(5,'B05'),(5,'B06'),(5,'B07'),(5,'B08'),(5,'B09'),(5,'B10'),(5,'B11'),(5,'B12'),(5,'C01'),(5,'C02'),(5,'C03'),(5,'C04'),(5,'C05'),(5,'C06'),(5,'C07'),(5,'C08'),(5,'C09'),(5,'C10'),(5,'C11'),(5,'C12'),(5,'D01'),(5,'D02'),(5,'D03'),(5,'D04'),(5,'D05'),(5,'D06'),(5,'D07'),(5,'D08'),(5,'D09'),(5,'D10'),(5,'D11'),(5,'D12'),(5,'E01'),(5,'E02'),(5,'E03'),(5,'E04'),(5,'E05'),(5,'E06'),(5,'E07'),(5,'E08'),(5,'E09'),(5,'E10'),(5,'E11'),(5,'E12'),(5,'F01'),(5,'F02'),(5,'F03'),(5,'F04'),(5,'F05'),(5,'F06'),(5,'F07'),(5,'F08'),(5,'F09'),(5,'F10'),(5,'F11'),(5,'F12'),(5,'G01'),(5,'G02'),(5,'G03'),(5,'G04'),(5,'G05'),(5,'G06'),(5,'G07'),(5,'G08'),(5,'G09'),(5,'G10'),(5,'G11'),(5,'G12'),(6,'A01'),(6,'A02'),(6,'A03'),(6,'A04'),(6,'A05'),(6,'A06'),(6,'A07'),(6,'A08'),(6,'A09'),(6,'A10'),(6,'A11'),(6,'A12'),(6,'B01'),(6,'B02'),(6,'B03'),(6,'B04'),(6,'B05'),(6,'B06'),(6,'B07'),(6,'B08'),(6,'B09'),(6,'B10'),(6,'B11'),(6,'B12'),(6,'C01'),(6,'C02'),(6,'C03'),(6,'C04'),(6,'C05'),(6,'C06'),(6,'C07'),(6,'C08'),(6,'C09'),(6,'C10'),(6,'C11'),(6,'C12'),(6,'D01'),(6,'D02'),(6,'D03'),(6,'D04'),(6,'D05'),(6,'D06'),(6,'D07'),(6,'D08'),(6,'D09'),(6,'D10'),(6,'D11'),(6,'D12'),(6,'E01'),(6,'E02'),(6,'E03'),(6,'E04'),(6,'E05'),(6,'E06'),(6,'E07'),(6,'E08'),(6,'E09'),(6,'E10'),(6,'E11'),(6,'E12'),(6,'F01'),(6,'F02'),(6,'F03'),(6,'F04'),(6,'F05'),(6,'F06'),(6,'F07'),(6,'F08'),(6,'F09'),(6,'F10'),(6,'F11'),(6,'F12'),(6,'G01'),(6,'G02'),(6,'G03'),(6,'G04'),(6,'G05'),(6,'G06'),(6,'G07'),(6,'G08'),(6,'G09'),(6,'G10'),(6,'G11'),(6,'G12'),(7,'A01'),(7,'A02'),(7,'A03'),(7,'A04'),(7,'A05'),(7,'A06'),(7,'A07'),(7,'A08'),(7,'A09'),(7,'A10'),(7,'A11'),(7,'A12'),(7,'B01'),(7,'B02'),(7,'B03'),(7,'B04'),(7,'B05'),(7,'B06'),(7,'B07'),(7,'B08'),(7,'B09'),(7,'B10'),(7,'B11'),(7,'B12'),(7,'C01'),(7,'C02'),(7,'C03'),(7,'C04'),(7,'C05'),(7,'C06'),(7,'C07'),(7,'C08'),(7,'C09'),(7,'C10'),(7,'C11'),(7,'C12'),(7,'D01'),(7,'D02'),(7,'D03'),(7,'D04'),(7,'D05'),(7,'D06'),(7,'D07'),(7,'D08'),(7,'D09'),(7,'D10'),(7,'D11'),(7,'D12'),(7,'E01'),(7,'E02'),(7,'E03'),(7,'E04'),(7,'E05'),(7,'E06'),(7,'E07'),(7,'E08'),(7,'E09'),(7,'E10'),(7,'E11'),(7,'E12'),(7,'F01'),(7,'F02'),(7,'F03'),(7,'F04'),(7,'F05'),(7,'F06'),(7,'F07'),(7,'F08'),(7,'F09'),(7,'F10'),(7,'F11'),(7,'F12'),(7,'G01'),(7,'G02'),(7,'G03'),(7,'G04'),(7,'G05'),(7,'G06'),(7,'G07'),(7,'G08'),(7,'G09'),(7,'G10'),(7,'G11'),(7,'G12'),(8,'A01'),(8,'A02'),(8,'A03'),(8,'A04'),(8,'A05'),(8,'A06'),(8,'A07'),(8,'A08'),(8,'A09'),(8,'A10'),(8,'A11'),(8,'A12'),(8,'B01'),(8,'B02'),(8,'B03'),(8,'B04'),(8,'B05'),(8,'B06'),(8,'B07'),(8,'B08'),(8,'B09'),(8,'B10'),(8,'B11'),(8,'B12'),(8,'C01'),(8,'C02'),(8,'C03'),(8,'C04'),(8,'C05'),(8,'C06'),(8,'C07'),(8,'C08'),(8,'C09'),(8,'C10'),(8,'C11'),(8,'C12'),(8,'D01'),(8,'D02'),(8,'D03'),(8,'D04'),(8,'D05'),(8,'D06'),(8,'D07'),(8,'D08'),(8,'D09'),(8,'D10'),(8,'D11'),(8,'D12'),(8,'E01'),(8,'E02'),(8,'E03'),(8,'E04'),(8,'E05'),(8,'E06'),(8,'E07'),(8,'E08'),(8,'E09'),(8,'E10'),(8,'E11'),(8,'E12'),(8,'F01'),(8,'F02'),(8,'F03'),(8,'F04'),(8,'F05'),(8,'F06'),(8,'F07'),(8,'F08'),(8,'F09'),(8,'F10'),(8,'F11'),(8,'F12'),(9,'A01'),(9,'A02'),(9,'A03'),(9,'A04'),(9,'A05'),(9,'A06'),(9,'A07'),(9,'A08'),(9,'A09'),(9,'A10'),(9,'A11'),(9,'A12'),(9,'B01'),(9,'B02'),(9,'B03'),(9,'B04'),(9,'B05'),(9,'B06'),(9,'B07'),(9,'B08'),(9,'B09'),(9,'B10'),(9,'B11'),(9,'B12'),(9,'C01'),(9,'C02'),(9,'C03'),(9,'C04'),(9,'C05'),(9,'C06'),(9,'C07'),(9,'C08'),(9,'C09'),(9,'C10'),(9,'C11'),(9,'C12'),(9,'D01'),(9,'D02'),(9,'D03'),(9,'D04'),(9,'D05'),(9,'D06'),(9,'D07'),(9,'D08'),(9,'D09'),(9,'D10'),(9,'D11'),(9,'D12'),(9,'E01'),(9,'E02'),(9,'E03'),(9,'E04'),(9,'E05'),(9,'E06'),(9,'E07'),(9,'E08'),(9,'E09'),(9,'E10'),(9,'E11'),(9,'E12'),(9,'F01'),(9,'F02'),(9,'F03'),(9,'F04'),(9,'F05'),(9,'F06'),(9,'F07'),(9,'F08'),(9,'F09'),(9,'F10'),(9,'F11'),(9,'F12'),(10,'A01'),(10,'A02'),(10,'A03'),(10,'A04'),(10,'A05'),(10,'A06'),(10,'A07'),(10,'A08'),(10,'A09'),(10,'A10'),(10,'A11'),(10,'A12'),(10,'B01'),(10,'B02'),(10,'B03'),(10,'B04'),(10,'B05'),(10,'B06'),(10,'B07'),(10,'B08'),(10,'B09'),(10,'B10'),(10,'B11'),(10,'B12'),(10,'C01'),(10,'C02'),(10,'C03'),(10,'C04'),(10,'C05'),(10,'C06'),(10,'C07'),(10,'C08'),(10,'C09'),(10,'C10'),(10,'C11'),(10,'C12'),(10,'D01'),(10,'D02'),(10,'D03'),(10,'D04'),(10,'D05'),(10,'D06'),(10,'D07'),(10,'D08'),(10,'D09'),(10,'D10'),(10,'D11'),(10,'D12'),(10,'E01'),(10,'E02'),(10,'E03'),(10,'E04'),(10,'E05'),(10,'E06'),(10,'E07'),(10,'E08'),(10,'E09'),(10,'E10'),(10,'E11'),(10,'E12'),(10,'F01'),(10,'F02'),(10,'F03'),(10,'F04'),(10,'F05'),(10,'F06'),(10,'F07'),(10,'F08'),(10,'F09'),(10,'F10'),(10,'F11'),(10,'F12'),(11,'A01'),(11,'A02'),(11,'A03'),(11,'A04'),(11,'A05'),(11,'A06'),(11,'A07'),(11,'A08'),(11,'A09'),(11,'A10'),(11,'A11'),(11,'A12'),(11,'B01'),(11,'B02'),(11,'B03'),(11,'B04'),(11,'B05'),(11,'B06'),(11,'B07'),(11,'B08'),(11,'B09'),(11,'B10'),(11,'B11'),(11,'B12'),(11,'C01'),(11,'C02'),(11,'C03'),(11,'C04'),(11,'C05'),(11,'C06'),(11,'C07'),(11,'C08'),(11,'C09'),(11,'C10'),(11,'C11'),(11,'C12'),(11,'D01'),(11,'D02'),(11,'D03'),(11,'D04'),(11,'D05'),(11,'D06'),(11,'D07'),(11,'D08'),(11,'D09'),(11,'D10'),(11,'D11'),(11,'D12'),(11,'E01'),(11,'E02'),(11,'E03'),(11,'E04'),(11,'E05'),(11,'E06'),(11,'E07'),(11,'E08'),(11,'E09'),(11,'E10'),(11,'E11'),(11,'E12'),(12,'A01'),(12,'A02'),(12,'A03'),(12,'A04'),(12,'A05'),(12,'A06'),(12,'A07'),(12,'A08'),(12,'A09'),(12,'A10'),(12,'A11'),(12,'A12'),(12,'B01'),(12,'B02'),(12,'B03'),(12,'B04'),(12,'B05'),(12,'B06'),(12,'B07'),(12,'B08'),(12,'B09'),(12,'B10'),(12,'B11'),(12,'B12'),(12,'C01'),(12,'C02'),(12,'C03'),(12,'C04'),(12,'C05'),(12,'C06'),(12,'C07'),(12,'C08'),(12,'C09'),(12,'C10'),(12,'C11'),(12,'C12'),(12,'D01'),(12,'D02'),(12,'D03'),(12,'D04'),(12,'D05'),(12,'D06'),(12,'D07'),(12,'D08'),(12,'D09'),(12,'D10'),(12,'D11'),(12,'D12'),(12,'E01'),(12,'E02'),(12,'E03'),(12,'E04'),(12,'E05'),(12,'E06'),(12,'E07'),(12,'E08'),(12,'E09'),(12,'E10'),(12,'E11'),(12,'E12'),(13,'A01'),(13,'A02'),(13,'A03'),(13,'A04'),(13,'A05'),(13,'A06'),(13,'A07'),(13,'A08'),(13,'A09'),(13,'A10'),(13,'A11'),(13,'A12'),(13,'B01'),(13,'B02'),(13,'B03'),(13,'B04'),(13,'B05'),(13,'B06'),(13,'B07'),(13,'B08'),(13,'B09'),(13,'B10'),(13,'B11'),(13,'B12'),(13,'C01'),(13,'C02'),(13,'C03'),(13,'C04'),(13,'C05'),(13,'C06'),(13,'C07'),(13,'C08'),(13,'C09'),(13,'C10'),(13,'C11'),(13,'C12'),(13,'D01'),(13,'D02'),(13,'D03'),(13,'D04'),(13,'D05'),(13,'D06'),(13,'D07'),(13,'D08'),(13,'D09'),(13,'D10'),(13,'D11'),(13,'D12'),(13,'E01'),(13,'E02'),(13,'E03'),(13,'E04'),(13,'E05'),(13,'E06'),(13,'E07'),(13,'E08'),(13,'E09'),(13,'E10'),(13,'E11'),(13,'E12'),(14,'A01'),(14,'A02'),(14,'A03'),(14,'A04'),(14,'A05'),(14,'A06'),(14,'A07'),(14,'A08'),(14,'A09'),(14,'A10'),(14,'A11'),(14,'A12'),(14,'B01'),(14,'B02'),(14,'B03'),(14,'B04'),(14,'B05'),(14,'B06'),(14,'B07'),(14,'B08'),(14,'B09'),(14,'B10'),(14,'B11'),(14,'B12'),(14,'C01'),(14,'C02'),(14,'C03'),(14,'C04'),(14,'C05'),(14,'C06'),(14,'C07'),(14,'C08'),(14,'C09'),(14,'C10'),(14,'C11'),(14,'C12'),(14,'D01'),(14,'D02'),(14,'D03'),(14,'D04'),(14,'D05'),(14,'D06'),(14,'D07'),(14,'D08'),(14,'D09'),(14,'D10'),(14,'D11'),(14,'D12'),(14,'E01'),(14,'E02'),(14,'E03'),(14,'E04'),(14,'E05'),(14,'E06'),(14,'E07'),(14,'E08'),(14,'E09'),(14,'E10'),(14,'E11'),(14,'E12');
/*!40000 ALTER TABLE `SEAT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SEAT_RESERVE`
--

DROP TABLE IF EXISTS `SEAT_RESERVE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SEAT_RESERVE` (
  `seat_reserve_idx` int NOT NULL AUTO_INCREMENT,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `screen_idx` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `seat_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `timetable_idx` int DEFAULT NULL,
  `member_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `payment_yn` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'S' COMMENT '(Y: 결제, S: 보류, N:미결제)',
  PRIMARY KEY (`seat_reserve_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEAT_RESERVE`
--

LOCK TABLES `SEAT_RESERVE` WRITE;
/*!40000 ALTER TABLE `SEAT_RESERVE` DISABLE KEYS */;
INSERT INTO `SEAT_RESERVE` VALUES (1,'2023-10-03 19:30:00',NULL,NULL,'1','A01',1,'osn9274','N'),(2,'2023-10-03 19:30:00',NULL,NULL,'1','A02',1,'osn9274','N'),(3,'2023-10-03 19:30:00',NULL,NULL,'1','A03',2,'osn9274','N'),(5,'2023-11-27 15:32:11',NULL,NULL,'1','B12',3,'osn9274','N'),(6,'2023-11-27 15:32:24',NULL,NULL,'1','C12',3,'osn9274','N'),(7,'2023-11-27 15:32:24',NULL,NULL,'1','D12',3,'osn9274','N'),(8,'2023-11-27 15:32:24',NULL,NULL,'1','E12',3,'osn9274','N'),(9,'2023-11-27 15:33:36',NULL,NULL,'1','D08',2,'osn9274','N'),(10,'2023-11-27 15:33:36',NULL,NULL,'1','C08',2,'osn9274','N'),(11,'2023-11-27 15:33:36',NULL,NULL,'1','E08',2,'osn9274','N'),(13,'2023-11-29 10:51:55',NULL,NULL,'1','D11',3,'osn9274','N'),(14,'2023-12-03 05:48:50',NULL,NULL,'1','C12',1,'KA-3201805429','N'),(15,'2023-12-03 05:48:50',NULL,NULL,'1','C11',1,'KA-3201805429','N'),(16,'2023-12-03 09:24:31',NULL,NULL,'1','D07',3,'KA-3201805429','N'),(17,'2023-12-03 09:24:31',NULL,NULL,'1','E07',3,'KA-3201805429','N'),(22,'2023-12-07 12:48:23',NULL,NULL,'1','C10',3,'KA-3214176230','N'),(23,'2023-12-07 12:48:23',NULL,NULL,'1','B10',3,'KA-3214176230','N'),(24,'2023-12-07 12:48:23',NULL,NULL,'1','B07',3,'KA-3214176230','N'),(25,'2023-12-07 12:48:23',NULL,NULL,'1','B04',3,'KA-3214176230','N'),(26,'2023-12-07 12:52:19',NULL,NULL,'1','D08',3,'KA-3214176230','N'),(27,'2023-12-07 12:52:19',NULL,NULL,'1','E08',3,'KA-3214176230','N'),(28,'2023-12-07 12:52:19',NULL,NULL,'1','F08',3,'KA-3214176230','N'),(29,'2023-12-07 12:52:19',NULL,NULL,'1','F07',3,'KA-3214176230','N'),(30,'2023-12-07 12:52:19',NULL,NULL,'1','F05',3,'KA-3214176230','N'),(31,'2023-12-07 12:52:19',NULL,NULL,'1','F06',3,'KA-3214176230','N'),(32,'2023-12-12 03:47:04',NULL,NULL,'2','C10',6,'KA-3201805429','N'),(33,'2023-12-12 03:48:24',NULL,NULL,'2','D11',6,'KA-3201805429','N'),(34,'2023-12-16 07:13:10',NULL,NULL,'2','C05',6,'KA-3201805429','N'),(35,'2023-12-16 07:13:10',NULL,NULL,'2','D06',6,'KA-3201805429','N'),(36,'2023-12-16 07:13:10',NULL,NULL,'2','E07',6,'KA-3201805429','N'),(37,'2023-12-16 07:13:10',NULL,NULL,'2','E08',6,'KA-3201805429','N'),(38,'2023-12-16 08:59:31',NULL,NULL,'2','E12',6,'KA-3201805429','N'),(39,'2023-12-16 08:59:31',NULL,NULL,'2','F12',6,'KA-3201805429','N'),(40,'2023-12-16 09:01:08',NULL,NULL,'3','C12',9,'KA-3201805429','N'),(41,'2023-12-16 09:01:08',NULL,NULL,'3','D12',9,'KA-3201805429','N'),(42,'2023-12-16 09:01:45',NULL,NULL,'3','C12',8,'KA-3201805429','N'),(43,'2023-12-16 09:01:45',NULL,NULL,'3','D12',8,'KA-3201805429','N'),(44,'2023-12-16 09:02:43',NULL,NULL,'3','D09',9,'KA-3201805429','N'),(45,'2023-12-16 09:02:43',NULL,NULL,'3','E09',9,'KA-3201805429','N'),(46,'2023-12-16 09:04:07',NULL,NULL,'3','C06',8,'KA-3201805429','N'),(47,'2023-12-16 09:04:07',NULL,NULL,'3','D06',8,'KA-3201805429','N'),(48,'2023-12-16 09:05:34',NULL,NULL,'2','C12',6,'KA-3201805429','N'),(49,'2023-12-16 09:05:34',NULL,NULL,'2','D12',6,'KA-3201805429','N'),(50,'2023-12-16 09:05:34',NULL,NULL,'2','C11',6,'KA-3201805429','N'),(51,'2023-12-16 09:06:51',NULL,NULL,'2','A12',6,'KA-3201805429','N'),(52,'2023-12-16 09:06:51',NULL,NULL,'2','B12',6,'KA-3201805429','N'),(53,'2023-12-18 14:27:00',NULL,NULL,'2','E11',6,'KA-3201805429','N'),(54,'2023-12-18 14:31:45',NULL,NULL,'2','D09',6,'KA-3201805429','N'),(55,'2023-12-18 14:31:45',NULL,NULL,'2','D10',6,'KA-3201805429','N'),(56,'2023-12-18 14:31:45',NULL,NULL,'2','E10',6,'KA-3201805429','N'),(57,'2023-12-18 14:39:31',NULL,NULL,'2','D02',6,'KA-3201805429','N'),(58,'2023-12-18 14:39:31',NULL,NULL,'2','F02',6,'KA-3201805429','N'),(59,'2023-12-18 14:39:31',NULL,NULL,'2','E02',6,'KA-3201805429','N'),(60,'2023-12-18 14:39:31',NULL,NULL,'2','E04',6,'KA-3201805429','N'),(61,'2023-12-18 14:40:43',NULL,NULL,'2','B08',6,'KA-3201805429','N'),(62,'2023-12-18 14:40:43',NULL,NULL,'2','A08',6,'KA-3201805429','N'),(63,'2023-12-18 14:40:43',NULL,NULL,'2','C08',6,'KA-3201805429','N'),(64,'2023-12-18 14:40:43',NULL,NULL,'2','D07',6,'KA-3201805429','N'),(108,'2023-12-18 15:57:28','2023-12-18 15:57:45',NULL,'2','A04',6,'KA-3201805429','Y'),(109,'2023-12-18 15:57:28','2023-12-18 15:57:45',NULL,'2','B04',6,'KA-3201805429','Y'),(110,'2023-12-18 15:57:28','2023-12-18 15:57:45',NULL,'2','C03',6,'KA-3201805429','Y'),(111,'2023-12-18 15:57:28','2023-12-18 15:57:45',NULL,'2','D03',6,'KA-3201805429','Y');
/*!40000 ALTER TABLE `SEAT_RESERVE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STORE`
--

DROP TABLE IF EXISTS `STORE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `STORE` (
  `product_idx` int NOT NULL AUTO_INCREMENT COMMENT '상품_IDX',
  `create_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `change_dt` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `end_dt` timestamp NULL DEFAULT NULL COMMENT '종료일',
  `product_gb` varchar(100) DEFAULT NULL COMMENT '구분',
  `product_name` varchar(100) NOT NULL COMMENT '상품명',
  `product_price` varchar(100) DEFAULT NULL COMMENT '가격',
  `product_info` varchar(200) DEFAULT NULL COMMENT '소개',
  PRIMARY KEY (`product_idx`),
  KEY `STORE_product_idx_IDX` (`product_idx`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='스토어';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STORE`
--

LOCK TABLES `STORE` WRITE;
/*!40000 ALTER TABLE `STORE` DISABLE KEYS */;
INSERT INTO `STORE` VALUES (1,'2023-08-24 14:37:34',NULL,NULL,'popcorn','고소팝콘','6000원','M'),(2,'2023-08-24 14:38:59',NULL,NULL,'popcorn','고소팝콘','6500원','L'),(3,'2023-08-24 14:39:02',NULL,NULL,'popcorn','달콤팝콘','6000원','M'),(6,'2023-10-09 09:39:18',NULL,NULL,'popcorn','달콤팝콘','6500원','L'),(7,'2023-10-09 09:42:08',NULL,NULL,'popcorn','어니언팝콘','6000원','M'),(8,'2023-10-09 09:42:10',NULL,NULL,'popcorn','어니언팝콘','6500원','L'),(9,'2023-10-14 07:48:26',NULL,NULL,'combo','스몰세트','7000원','팝콘(M) 1 + 탄산음료(M) 1'),(10,'2023-10-14 07:48:28',NULL,NULL,'combo','더블콤보','13000원','팝콘(M) 2 + 탄산음료(M) 2'),(11,'2023-10-14 07:48:34',NULL,NULL,'combo','라지콤보','15000원','팝콘(L) 2 + 탄산음료(L) 2'),(12,'2023-10-14 07:48:35',NULL,NULL,'drink','탄산음료','2500원','M'),(13,'2023-10-14 07:48:36',NULL,NULL,'drink','탄산음료','3000원','L'),(14,'2023-10-14 07:48:37',NULL,NULL,'drink','커피','4000원','ICE'),(15,'2023-10-14 07:48:42',NULL,NULL,'drink','커피','3500원','HOT'),(16,'2023-10-14 07:48:44',NULL,NULL,'drink','에이드','5000원','ONLY ICE');
/*!40000 ALTER TABLE `STORE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `THEATERS`
--

DROP TABLE IF EXISTS `THEATERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `THEATERS` (
  `theater_idx` int NOT NULL AUTO_INCREMENT,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `theater_name` varchar(20) DEFAULT NULL,
  `theater_city` varchar(20) DEFAULT NULL,
  `theater_address` varchar(100) DEFAULT NULL,
  `theater_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`theater_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `THEATERS`
--

LOCK TABLES `THEATERS` WRITE;
/*!40000 ALTER TABLE `THEATERS` DISABLE KEYS */;
INSERT INTO `THEATERS` VALUES (1,'2023-09-09 08:57:13',NULL,NULL,'CGV광교','경기','경기도 수원시 영통구 광교중앙로 124 갤러리아백화점 광교점 10층','1544-1122'),(2,'2023-09-09 08:58:45',NULL,NULL,'CGV등촌','서울','서울특별시 강서구 공항대로45길 63 3층~7층 (등촌동)','1544-1122');
/*!40000 ALTER TABLE `THEATERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIMETABLE`
--

DROP TABLE IF EXISTS `TIMETABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIMETABLE` (
  `timetable_idx` int NOT NULL AUTO_INCREMENT,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `screening_dt` date DEFAULT NULL,
  `movie_idx` int DEFAULT NULL,
  `start_time` varchar(20) DEFAULT NULL,
  `finish_time` varchar(20) DEFAULT NULL,
  `screen_idx` int DEFAULT NULL,
  `dimension_gb` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`timetable_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIMETABLE`
--

LOCK TABLES `TIMETABLE` WRITE;
/*!40000 ALTER TABLE `TIMETABLE` DISABLE KEYS */;
INSERT INTO `TIMETABLE` VALUES (1,'2023-09-09 09:19:58',NULL,NULL,'2023-10-12',1,'12:30','15:30',1,'2D'),(2,'2023-09-09 09:22:02',NULL,NULL,'2023-10-12',1,'16:00','19:00',1,'2D'),(3,'2023-09-09 09:22:30',NULL,NULL,'2023-10-12',1,'19:20','22:20',1,'2D'),(4,'2023-09-09 09:24:27',NULL,NULL,'2023-10-12',2,'12:30','15:30',2,'2D'),(5,'2023-09-09 09:24:27',NULL,NULL,'2023-10-12',2,'16:00','19:00',2,'2D'),(6,'2023-09-09 09:24:27',NULL,NULL,'2023-10-12',2,'19:20','22:20',2,'2D'),(7,'2023-09-09 09:25:41',NULL,NULL,'2023-10-12',3,'12:30','15:30',3,'2D'),(8,'2023-09-09 09:25:41',NULL,NULL,'2023-10-12',3,'16:00','19:00',3,'2D'),(9,'2023-09-09 09:25:41',NULL,NULL,'2023-10-12',3,'19:20','22:20',3,'2D'),(10,'2023-09-09 09:25:59',NULL,NULL,'2023-10-12',4,'12:30','15:30',4,'2D'),(11,'2023-09-09 09:25:59',NULL,NULL,'2023-10-12',4,'16:00','19:00',4,'2D'),(12,'2023-09-09 09:25:59',NULL,NULL,'2023-10-12',4,'19:20','22:20',4,'2D'),(13,'2023-09-09 09:26:35',NULL,NULL,'2023-10-12',5,'12:30','15:30',5,'2D'),(14,'2023-09-09 09:26:35',NULL,NULL,'2023-10-12',5,'16:00','19:00',5,'2D'),(15,'2023-09-09 09:26:35',NULL,NULL,'2023-10-12',5,'19:20','22:20',5,'2D'),(16,'2023-09-09 09:26:48',NULL,NULL,'2023-10-12',6,'12:30','15:30',1,'2D'),(17,'2023-09-09 09:26:48',NULL,NULL,'2023-09-09',6,'16:00','19:00',1,'2D'),(18,'2023-09-09 09:26:48',NULL,NULL,'2023-09-09',6,'19:20','22:20',1,'2D'),(19,'2023-09-09 09:26:58',NULL,NULL,'2023-09-09',7,'12:30','15:30',2,'2D'),(20,'2023-09-09 09:26:58',NULL,NULL,'2023-09-09',7,'16:00','19:00',2,'2D'),(21,'2023-09-09 09:26:58',NULL,NULL,'2023-09-09',7,'19:20','22:20',2,'2D'),(22,'2023-09-09 09:27:09',NULL,NULL,'2023-09-09',8,'12:30','15:30',3,'2D'),(23,'2023-09-09 09:27:09',NULL,NULL,'2023-09-09',8,'16:00','19:00',3,'2D'),(24,'2023-09-09 09:27:09',NULL,NULL,'2023-09-09',8,'19:20','22:20',3,'2D'),(25,'2023-09-09 09:27:25',NULL,NULL,'2023-09-09',9,'12:30','15:30',4,'2D'),(26,'2023-09-09 09:27:25',NULL,NULL,'2023-09-09',9,'16:00','19:00',4,'2D'),(27,'2023-09-09 09:27:25',NULL,NULL,'2023-09-09',9,'19:20','22:20',4,'2D'),(28,'2023-09-09 09:27:35',NULL,NULL,'2023-09-09',10,'12:30','15:30',5,'2D'),(29,'2023-09-09 09:27:35',NULL,NULL,'2023-09-09',10,'16:00','19:00',5,'2D'),(30,'2023-09-09 09:27:35',NULL,NULL,'2023-09-09',10,'19:20','22:20',5,'2D'),(31,'2023-09-09 09:27:47',NULL,NULL,'2023-09-09',11,'12:30','15:30',1,'2D'),(32,'2023-09-09 09:27:47',NULL,NULL,'2023-09-09',11,'16:00','19:00',1,'2D'),(33,'2023-09-09 09:27:47',NULL,NULL,'2023-09-09',11,'19:20','22:20',1,'2D'),(34,'2023-09-09 09:27:55',NULL,NULL,'2023-09-09',12,'12:30','15:30',2,'2D'),(35,'2023-09-09 09:27:55',NULL,NULL,'2023-09-09',12,'16:00','19:00',2,'2D'),(36,'2023-09-09 09:27:55',NULL,NULL,'2023-09-09',12,'19:20','22:20',2,'2D'),(37,'2023-09-09 09:28:04',NULL,NULL,'2023-09-09',13,'12:30','15:30',3,'2D'),(38,'2023-09-09 09:28:04',NULL,NULL,'2023-09-09',13,'16:00','19:00',3,'2D'),(39,'2023-09-09 09:28:04',NULL,NULL,'2023-09-09',13,'19:20','22:20',3,'2D'),(40,'2023-09-09 09:28:17',NULL,NULL,'2023-09-09',14,'12:30','15:30',4,'2D'),(41,'2023-09-09 09:28:17',NULL,NULL,'2023-09-09',14,'16:00','19:00',4,'2D'),(42,'2023-09-09 09:28:17',NULL,NULL,'2023-09-09',14,'19:20','22:20',4,'2D');
/*!40000 ALTER TABLE `TIMETABLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TMP_SEAT_RESERVE`
--

DROP TABLE IF EXISTS `TMP_SEAT_RESERVE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TMP_SEAT_RESERVE` (
  `seat_reserve_idx` int NOT NULL,
  `create_dt` timestamp NULL DEFAULT NULL,
  `change_dt` timestamp NULL DEFAULT NULL,
  `end_dt` timestamp NULL DEFAULT NULL,
  `screen_idx` varchar(20) DEFAULT NULL,
  `seat_number` varchar(20) DEFAULT NULL,
  `timetable_idx` int DEFAULT NULL,
  `reserve_yn` varchar(20) DEFAULT NULL,
  `member_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`seat_reserve_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TMP_SEAT_RESERVE`
--

LOCK TABLES `TMP_SEAT_RESERVE` WRITE;
/*!40000 ALTER TABLE `TMP_SEAT_RESERVE` DISABLE KEYS */;
/*!40000 ALTER TABLE `TMP_SEAT_RESERVE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menu_uid` int NOT NULL,
  `menu_name` varchar(200) DEFAULT NULL,
  `menu_info` varchar(200) DEFAULT NULL,
  `menu_price` int DEFAULT NULL,
  `menu_picture` varchar(1000) DEFAULT NULL,
  `menu_upload_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`menu_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'아이스 아메리카노','맛있는 아이스 아메리카노입니다~',4000,'ice_americano.jpg','2023-04-06 20:13:43'),(2,'카페라떼','은은한 카페라떼입니다~',5000,'cafe_latte.jpg','2023-04-06 20:13:46');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mysql_ssjy'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-28 14:55:51
