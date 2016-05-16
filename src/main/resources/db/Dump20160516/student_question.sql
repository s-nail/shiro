CREATE DATABASE  IF NOT EXISTS `student` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `student`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: student
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `idquestion` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `option1` varchar(45) NOT NULL,
  `option2` varchar(45) NOT NULL,
  `option3` varchar(45) NOT NULL,
  `option4` varchar(45) NOT NULL,
  `answer` varchar(45) NOT NULL,
  `point` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `flag` varchar(45) NOT NULL,
  PRIMARY KEY (`idquestion`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (10,'Are there any _____ on the farm? Yes,there are some.','horse','sheep1','duck','chicken','B','5','english','Yes'),(12,'Mr,lin often gives us _____ by E-mail. ','some good information ','some good informations','good informations','a good information','A','5','english','Yes'),(13,'He gave us ______ on how to learn English well. ','some advices','many advices','some advice','an advice','C','5','english','Yes'),(15,'nihaihaoma?','nice','alone','happy','fine','B','5','english','Yes'),(21,'1+1=','1','2','3','4','B','5','math','Yes'),(22,'1+2=','1','2','3','4','C','5','math','Yes'),(23,'3*7=','12','37','28','21','D','5','math','Yes'),(24,'5+5=','10','15','13','11','A','5','math','Yes'),(25,'sdsd','','','','','','5','null','Yes'),(27,'sdsd','sdsd','wew','sd','','A','5','english','Yes'),(28,'q','q','','','','q','5','math','Yes');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16 19:01:22
