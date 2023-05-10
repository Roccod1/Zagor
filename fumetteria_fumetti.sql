CREATE DATABASE  IF NOT EXISTS `fumetteria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fumetteria`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: fumetteria
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `fumetti`
--

DROP TABLE IF EXISTS `fumetti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fumetti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` text,
  `titolo` text,
  `numero` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fumetti`
--

LOCK TABLES `fumetti` WRITE;
/*!40000 ALTER TABLE `fumetti` DISABLE KEYS */;
INSERT INTO `fumetti` VALUES (1,'./img/001.jpg','Zagor',1),
(2,'./img/002.jpg','Terrore',2),
(3,'./img/003.jpg','L\' oro del fiume',3),
(4,'./img/004.jpg','Corvo Giallo',4),
(6,'./img/005.jpg','I due Sosia',5),
(7,'./img/006.jpg','La Lancia Spezzata',6),
(8,'./img/007.jpg','Il Popolo della Palude',7),
(9,'./img/008.jpg','La Vendetta di Zagor',8),
(10,'./img/009.jpg','La Legge Rossa',9),
(11,'./img/010.jpg','La Danza della Scure',10),
(12,'./img/011.jpg','L isola della Paura',11),
(13,'./img/012.jpg','Sulle Orme di Titan',12),
(14,'./img/013.jpg','L abbisso Verde',13),
(15,'./img/014.jpg','I Mercanti di Schiavi',14),
(16,'./img/015.jpg','Iron-Man',15),
(17,'./img/016.jpg','I Padroni del Fuoco',16),
(18,'./img/017.jpg','Condanna a Morte',17),
(19,'./img/018.jpg','Ombre !',18),
(20,'./img/019.jpg','Territorio Indiano',19),
(21,'./img/020.jpg','L Inferno dei Vivi',20),
(22,'./img/021.jpg','La Furia di Zagor',21),
(23,'./img/022.jpg','L Avvoltoio',22),
(24,'./img/023.jpg','La Lunga Notte',23),
(25,'./img/024.jpg','Le Jene del Mare',24),
(26,'./img/025.jpg','La Traccia',25),
(27,'./img/026.jpg','Il Nemico nell Ombra',26),
(28,'./img/027.jpg','Zagor Attacca',27),
(29,'./img/028.jpg','Clark City',28),
(30,'./img/029.jpg','I Cacciatori di Uomini',29),
(31,'./img/030.jpg','La Preda Umana',30),
(32,'./img/031.jpg','Guerra',31),
(33,'./img/032.jpg','Il Fuggiasco',32),
(34,'./img/033.jpg','La Casa del Terrore',33),
(35,'./img/034.jpg','Gli Sciacalli della Foresta',34),
(36,'./img/035.jpg','I Ricattatori',35),
(37,'./img/036.jpg','Solo contro Tutti',36),
(38,'./img/037.jpg','L Ultima Sfida',37),
(39,'./img/038.jpg','Prigioniero',38),
(40,'./img/039.jpg','Odio !',39),
(41,'./img/040.jpg','Lo Spettro del Passato',40),
(42,'./img/041.jpg','Vittoria !',41),
(43,'./img/042.jpg','Il Mostro della Laguna',42),
(44,'./img/043.jpg','Seminoles',43),
(45,'./img/044.jpg','I Vendicatori',44),
(46,'./img/045.jpg','Satko !',45),
(47,'./img/046.jpg','Il FAnte di Picche',46),
(48,'./img/047.jpg','La Pista di Sangue',47),
(49,'./img/048.jpg','Belve !',48),
(50,'./img/049.jpg','L Uomo Lupo',49),
(51,'./img/050.jpg','La Citta Nascosta',50),
52,'./img/051.jpg','Gli Evasi',51),
(53,'./img/052.jpg','Morte sul Fiume',52),
(54,'./img/053.jpg','La Dea Nera',53),
(55,'./img/054.jpg','Natale Calibro 45',54),
(56,'./img/055.jpg','Zagor racconta...',55),
(57,'./img/056.jpg','Il Re di Darkwood',56),
(58,'./img/057.jpg','Mohican Jack',57),
(59,'./img/058.jpg','La Carica Suicida',58),
(60,'./img/059.jpg','Servizio Segreto',59),
(61,'./img/060.jpg','Fucilazione !',60),
(62,'./img/061.jpg','L Arciere Rosso',61),
(63,'./img/062.jpg','La Freccia Mortale',62),
(64,'./img/063.jpg','Sfida all Ignoto',63),
(65,'./img/064.jpg','Ramath il Fakiro',64),
(66,'./img/065.jpg','La Nave Pirata',65),
(67,'./img/066.jpg','Magic-Bat',66),
(68,'./img/067.jpg','Il Re delle Aquile',67),
(69,'./img/068.jpg','Lo Spettro',68),
(70,'./img/069.jpg','I Sei della Blue Star',69),
(71,'./img/070.jpg','Fiamme nella Notte',70),
(72,'./img/071.jpg','Il Fiore che Uccide',71),
(73,'./img/072.jpg','Terra senza Legge',72),
(74,'./img/073.jpg','Lo strano Mister Smith',73),
(75,'./img/074.jpg','La Stella di Latta',74),
(76,'./img/075.jpg','La Mano di Allah',75),
(77,'./img/076.jpg','Lo Sceicco Nero',76),
(78,'./img/077.jpg','Molok !',77),
(79,'./img/078.jpg','I Falchi delle Nevi',78),
(80,'./img/079.jpg','Eskimo',79),
(81,'./img/080.jpg','Zagor Story',80),
(82,'./img/081.jpg','La Rivolta dei Trappers',81),
(83,'./img/082.jpg','La Strada di Ferro',82),
(84,'./img/083.jpg','La Maschera Bianca',83),
(85,'./img/084.jpg','Indian Circus',84),
(86,'./img/085.jpg','Angoscia !',85),
(87,'./img/086.jpg','Zagor contro il Vampiro',86),
(88,'./img/087.jpg','Alba Tragica',87),
(89,'./img/088.jpg','Odissea Americana',88),
(90,'./img/089.jpg','La Nebbia Infernale',89),
(91,'./img/090.jpg','Zagor, il Ribelle',90),
(92,'./img/091.jpg','Liberta o Morte',91),
(93,'./img/092.jpg','All Ultimo Sangue',92),
(94,'./img/093.jpg','Vudu !',93),
(95,'./img/094.jpg','La Notte dei Maghi',94),
(96,'./img/095.jpg','Zombi !',95),
(97,'./img/096.jpg','Hammad, l Egiziano',96),
(98,'./img/097.jpg','Oceano',97),
(99,'./img/098.jpg','Bandiera Nera',98),
(100,'./img/099.jpg','Capitan Serpente',99),
(101,'./img/100.jpg','Il mio Amico Guitar Jim',100),
(102,'./img/101.jpg','Tragico Carnevale',101),
(103,'./img/102.jpg','I Ribelli della Louisiana',102),
(104,'./img/103.jpg','I Congiurati',103),
(105,'./img/104.jpg','Il Buono e il Cattivo',104),
(106,'./img/105.jpg','Le Montagne di Sangue',105),
(107,'./img/106.jpg','Terre Bruciate',106),
(108,'./img/107.jpg','Ritorno a Darkwood',107),
(109,'./img/108.jpg','Ora Zero !',108),
(110,'./img/109.jpg','Minaccia dallo Spazio',109),
(111,'./img/110.jpg','3 Uomini in Pericolo',110),
(112,'./img/111.jpg','Acque Misteriose',111),
(113,'./img/112.jpg','La Capanna Maledetta',112),
(116,'./img/113.jpg','Messagi di Morte',113),
(117,'./img/114.jpg','La Marcia della Disperazione',114),
(118,'./img/115.jpg','La Sabbia e Rossa !',115),
(119,'./img/116.jpg','L Ultima Vittima',116),
(120,'./img/117.jpg','Arrivano i Samurai',117),
(121,'./img/118.jpg','La Scure e la Sciabola',118),
(122,'./img/119.jpg','La Rabbia degli Osages',119),
(123,'./img/120.jpg','Arrestate Billy Boy !',120),
(124,'./img/121.jpg','Il Giorno della Giustizia',121),
(125,'./img/122.jpg','Addio Fratello Rosso !',122),
(126,'./img/123.jpg','L Avventuriero',123),
(127,'./img/124.jpg','Zagor contro Supermike',124),
(128,'./img/125.jpg','La Settima Prova',125),
(129,'./img/126.jpg','Agli Ordini dello Zar ',126),
(130,'./img/127.jpg','La Fossa della Morte',127),
(131,'./img/128.jpg','La Fine di un Tiranno',128),
(132,'./img/129.jpg','Follia Omicida',129),
(133,'./img/130.jpg','Il Fantasma di Stone Hill',130),
(134,'./img/131.jpg','Kandrax il Mago',131),
(135,'./img/132.jpg','La Sesta Luna',132),
(136,'./img/133.jpg','Sandy River',133),
(137,'./img/134.jpg','Spedizione Punitiva',134),
(138,'./img/135.jpg','Il Palo della Tortura',135),
(139,'./img/136.jpg','Tigre !',136),
(140,'./img/137.jpg','Dharma la Strega',137),
(141,'./img/138.jpg','L Orrenda Magia',138),
(142,'./img/139.jpg','Il Cavaliere Misterioso',139),
(143,'./img/140.jpg','Pericolo Biondo',140);
/*!40000 ALTER TABLE `fumetti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


