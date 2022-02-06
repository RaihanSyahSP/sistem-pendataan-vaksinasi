/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.4.14-MariaDB : Database - vaksin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vaksin` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `vaksin`;

/*Table structure for table `orang` */

DROP TABLE IF EXISTS `orang`;

CREATE TABLE `orang` (
  `nik` varchar(16) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `orang` */

insert  into `orang`(`nik`,`nama`,`alamat`,`tgl_lahir`,`jenis_kelamin`,`no_hp`) values 
('1122','raihan','italia','1911-12-23','laki-laki','08923999'),
('1133','hantu','soreang','2002-01-01','laki-laki','08921221'),
('1144','hanhan','dresden','1928-09-01','laki-laki','0323323'),
('1155','andi','berlin','1912-03-02','laki-laki','0323233'),
('1166','budi','stalinigrad','1910-01-03','laki-laki','021202'),
('1177','churchill','london','1916-06-06','laki-laki','0323323'),
('1188','woodie','chicago','1922-09-04','laki-laki','021212'),
('1199','buzz','moskwa','1934-09-23','laki-laki','021222'),
('1298','rar','sekeloa','2001-02-12','perempuann','0892392929'),
('2200','anna','wales','1950-03-02','perempuan','0323323');

/*Table structure for table `status_vaksin` */

DROP TABLE IF EXISTS `status_vaksin`;

CREATE TABLE `status_vaksin` (
  `kd_status` varchar(11) NOT NULL,
  `dosis` varchar(10) NOT NULL,
  `tgl_vaksin` date NOT NULL,
  `keterangan` varchar(30) NOT NULL,
  `nik` varchar(16) NOT NULL,
  `kd_rs` int(20) DEFAULT NULL,
  PRIMARY KEY (`kd_status`),
  KEY `nik` (`nik`),
  KEY `kd_rs` (`kd_rs`),
  CONSTRAINT `status_vaksin_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `orang` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `status_vaksin_ibfk_2` FOREIGN KEY (`kd_rs`) REFERENCES `tempat_vaksin` (`kd_rs`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `status_vaksin` */

insert  into `status_vaksin`(`kd_status`,`dosis`,`tgl_vaksin`,`keterangan`,`nik`,`kd_rs`) values 
('11','pertama','2022-02-02','belum','1122',101),
('12','kedua','2022-03-02','belum','1122',102),
('14','kedua','2022-03-27','belum','1133',102),
('15','pertama','2022-01-12','sudah','1166',103),
('16','kedua','2022-02-01','sudah','1166',104),
('17','kedua','2022-01-02','sudah','2200',104),
('18','pertama','2022-03-01','belum','1177',105),
('22','pertama','2022-02-03','belum','1133',102);

/*Table structure for table `tempat_vaksin` */

DROP TABLE IF EXISTS `tempat_vaksin`;

CREATE TABLE `tempat_vaksin` (
  `kd_rs` int(11) NOT NULL,
  `nama_rs` varchar(30) DEFAULT NULL,
  `jam_operasional` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kd_rs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tempat_vaksin` */

insert  into `tempat_vaksin`(`kd_rs`,`nama_rs`,`jam_operasional`) values 
(101,'borromeus','09.00-12.00'),
(102,'santo yusup','09.00-10.00'),
(103,'al islam','07.00-10.00'),
(104,'immanuel','08.00-11.00'),
(105,'hasan sadikin','09.00-12.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
