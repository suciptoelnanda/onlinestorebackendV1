/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.5.5-10.1.21-MariaDB : Database - simple_store
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`simple_store` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `simple_store`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (2);

/*Table structure for table `master_product` */

DROP TABLE IF EXISTS `master_product`;

CREATE TABLE `master_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `image` text,
  `description` text,
  `create_by` varchar(250) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(250) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

/*Data for the table `master_product` */

insert  into `master_product`(`id`,`name`,`price`,`image`,`description`,`create_by`,`create_date`,`update_by`,`update_date`) values (27,'The Face Shop Coca Cola Lip Tint','500000','190304212102-coca-cola-lipstik.jpg','Fitur Produk\nLip tint\nDengan teksture souffle yang menciptakan sentuhan matte, sementara bagian dalamnya masih berembun dan lembab \nMemiliki aroma coca-cola yang segar dan manis\nKompleks buah merah yang memberikan perawatan pelembab pada bibir (ekstrak apel, ekstrak buah cherry manis, ekstrak jeruk, ekstrak jeruk bali)',NULL,NULL,NULL,NULL),(28,'VIVO Y93 Smartphone [32GB/ 3GB]','2133000','190304215653-hp.jpg','Fitur Produk\nOS : Android 8.1 Oreo\nChipset : Mediatek Helio P22\nKamera : Utama 13MP + 2MP, Depan 8 MP\nLayar : 6.22 Inch HD Ultra All Screen\nBaterai : 4030 mAh',NULL,NULL,NULL,NULL),(29,'Tropical Minyak Goreng [2000 mL/ 1 dus 6 pcs)','20000','190304215821-minyak-goreng.jpg','Tropical Refill Minyak Goreng [2000 mL]\nDengan 2 kali proses penyaringan, sehingga menghasilkan kualitas yang sempurna bening dan jernih\nMengandung asam lemak tak jenuh (omega 9) yang dapat membantu menurunkan kolesterol darah\nDilengkapi Vitamin E sebagai antioksidan dan Pro Vitamin A\nKomposisi : Minyak kelapa sawit, antioksidan, dan vitamin E',NULL,NULL,NULL,NULL),(30,'Amazon 2nd Gen Echo Dot Alexa Smart Voice Control','1000000','190304220022-amazone-specker.jpg','test',NULL,NULL,NULL,NULL),(31,'DIJAMIN MURAH - Xiaomi Mi Band 3 SmartBand Original','3400000','190304220207-xiaomi_xiaomi-miband-3-internasional-version_full05.jpg','Smartband Mi Band 3\nMaterial : Thermoplastic Elastometer & Aluminium Alloy\nDisplay Resolution : 128 x 80\nSensor : Triaxial Accelaration Sensor, PPG Heart Rate Sensor\nWaterproof Rating 5ATM [2]',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
