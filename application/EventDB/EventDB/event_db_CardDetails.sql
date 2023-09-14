-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: event_db
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `CardDetails`
--

DROP TABLE IF EXISTS `CardDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CardDetails` (
  `eventName` char(20) DEFAULT NULL,
  `eventId` int DEFAULT NULL,
  `cardNo` int DEFAULT NULL,
  `expiryDate` date DEFAULT NULL,
  `cvv` int DEFAULT NULL,
  `cardHolderName` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CardDetails`
--

LOCK TABLES `CardDetails` WRITE;
/*!40000 ALTER TABLE `CardDetails` DISABLE KEYS */;
INSERT INTO `CardDetails` VALUES ('Event1',1,123456789,'2026-12-25',123,'John Doe'),('Event2',2,987654321,'2026-06-24',456,'Jane Smith'),('Event3',3,567890123,'2026-09-23',789,'Robert Johnson'),('Event4',4,345678901,'2026-03-27',234,'Emily Davis'),('Event5',5,789012345,'2026-11-26',567,'Michael Wilson');
/*!40000 ALTER TABLE `CardDetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-11 22:37:32
