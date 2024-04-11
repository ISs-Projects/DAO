-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.2-alpha-community-nt-debug


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema miniagenda
--

CREATE DATABASE IF NOT EXISTS miniagenda;
USE miniagenda;

--
-- Definition of table `Contactos`
--

DROP TABLE IF EXISTS `Contactos`;
CREATE TABLE `Contactos` (
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Contactos`
--

/*!40000 ALTER TABLE `Contactos` DISABLE KEYS */;
INSERT INTO `Contactos` (`nombre`,`telefono`,`email`) VALUES 
 ('adf','adf','adsf'),
 ('Juan Penas','7262-8292','juan@correo.com.cx'),
 ('Laura Zarco','2737-9212','lauris@micorreo.com'),
 ('Pepe Pecas','8282-7272','pepe@hotmail.net');
/*!40000 ALTER TABLE `Contactos` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
