# ************************************************************
# Antares - SQL Client
# Version 0.7.13
# 
# https://antares-sql.app/
# https://github.com/antares-sql/antares
# 
# Host: 127.0.0.1 (mariadb.org binary distribution 10.4.25)
# Database: recipe-management-system
# Generation time: 2023-07-08T06:27:25+07:00
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bahan_baku
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bahan_baku`;

CREATE TABLE `bahan_baku` (
  `id_bahan_baku` int(11) NOT NULL AUTO_INCREMENT,
  `no_bahan_baku` varchar(20) DEFAULT NULL,
  `nama_bahan` varchar(255) DEFAULT NULL,
  `foto` blob DEFAULT NULL,
  `keterangan` text DEFAULT NULL,
  PRIMARY KEY (`id_bahan_baku`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `bahan_baku` WRITE;
/*!40000 ALTER TABLE `bahan_baku` DISABLE KEYS */;

INSERT INTO `bahan_baku` (`id_bahan_baku`, `no_bahan_baku`, `nama_bahan`, `foto`, `keterangan`) VALUES
	(3, "BBK3", "Cabai Merah", NULL, "Pedesnya ndak ada, dekorasi aja"),
	(4, "BBK4", "Cabai Gendot", NULL, "Pedas Banget buasdaset"),
	(5, "BBK5", "Cabai merah^2", X'61736461', NULL),
	(6, "m", "cumbersome-real.net", NULL, "/tmp"),
	(7, "n", "sick-cheddar.org", NULL, "/usr/X11R6"),
	(8, "x", "responsible-printer.biz", NULL, "/rescue"),
	(9, "a", "empty-waterspout.com", NULL, "/usr/local/bin"),
	(10, "1", "growling-software.net", NULL, "/usr"),
	(11, "g", "phony-squeegee.biz", NULL, "/etc/ppp"),
	(12, "z", "broken-woolens.org", NULL, "/opt/bin"),
	(13, "h", "livid-innovation.info", NULL, "/home/user/dir"),
	(14, "4", "spirited-herbs.biz", NULL, "/root"),
	(15, "i", "muted-crinoline.name", NULL, "/root"),
	(16, "x", "another-overflight.com", NULL, "/proc"),
	(17, "3", "youthful-buzz.name", NULL, "/usr/libexec"),
	(18, "q", "worn-sprag.org", NULL, "/lib"),
	(19, "k", "defiant-fatigue.biz", NULL, "/opt/bin"),
	(20, "g", "uncomfortable-leg.info", NULL, "/lib"),
	(21, "v", "secret-tenet.info", NULL, "/proc"),
	(22, "k", "sad-lover.info", NULL, "/selinux"),
	(23, "c", "unlucky-appliance.org", NULL, "/usr/lib"),
	(24, "k", "ironclad-transition.org", NULL, "/etc/namedb"),
	(25, "z", "glorious-processor.name", NULL, "/home"),
	(26, "s", "decimal-night.org", NULL, "/etc/periodic"),
	(27, "c", "peppery-gastronomy.info", NULL, "/Users"),
	(28, "r", "male-sock.biz", NULL, "/Users"),
	(29, "2", "appropriate-derrick.com", NULL, "/opt"),
	(30, "y", "secret-fix.com", NULL, "/usr/ports"),
	(31, "a", "drab-class.info", NULL, "/media"),
	(32, "3", "grouchy-full.net", NULL, "/bin"),
	(33, "m", "dual-brand.name", NULL, "/etc"),
	(34, "w", "nutritious-orator.biz", NULL, "/var/spool"),
	(35, "6", "unknown-brunch.name", NULL, "/boot");

/*!40000 ALTER TABLE `bahan_baku` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table bahan_baku_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bahan_baku_detail`;

CREATE TABLE `bahan_baku_detail` (
  `id_bahan_baku` int(11) NOT NULL,
  `harga` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  KEY `bahan_baku_detail_fk0` (`id_bahan_baku`),
  CONSTRAINT `bahan_baku_detail_fk0` FOREIGN KEY (`id_bahan_baku`) REFERENCES `bahan_baku` (`id_bahan_baku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





# Dump of table detail_bahan_resep
# ------------------------------------------------------------

DROP TABLE IF EXISTS `detail_bahan_resep`;

CREATE TABLE `detail_bahan_resep` (
  `id_resep` int(11) NOT NULL,
  `no_bahan_resep` varchar(255) DEFAULT NULL,
  `id_bahan_baku` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `id_metric` int(11) DEFAULT NULL,
  `foto` blob DEFAULT NULL,
  KEY `detail_bahan_resep_fk0` (`id_resep`),
  KEY `detail_bahan_resep_fk1` (`id_bahan_baku`),
  KEY `detail_bahan_resep_fk2` (`id_metric`),
  CONSTRAINT `detail_bahan_resep_fk0` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id_resep`),
  CONSTRAINT `detail_bahan_resep_fk1` FOREIGN KEY (`id_bahan_baku`) REFERENCES `bahan_baku` (`id_bahan_baku`),
  CONSTRAINT `detail_bahan_resep_fk2` FOREIGN KEY (`id_metric`) REFERENCES `jenis_metric` (`id_metric`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `detail_bahan_resep` WRITE;
/*!40000 ALTER TABLE `detail_bahan_resep` DISABLE KEYS */;

INSERT INTO `detail_bahan_resep` (`id_resep`, `no_bahan_resep`, `id_bahan_baku`, `qty`, `id_metric`, `foto`) VALUES
	(1, "BHR1", 4, 12, 1, NULL),
	(1, "BHR1", 4, 15, 1, NULL);

/*!40000 ALTER TABLE `detail_bahan_resep` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table detail_instruksi_resep
# ------------------------------------------------------------

DROP TABLE IF EXISTS `detail_instruksi_resep`;

CREATE TABLE `detail_instruksi_resep` (
  `id_resep` int(11) NOT NULL,
  `no_instruksi_resep` varchar(50) DEFAULT NULL,
  `instruksi` text DEFAULT NULL,
  `foto` blob DEFAULT NULL,
  KEY `detail_instruksi_resep_fk0` (`id_resep`),
  CONSTRAINT `detail_instruksi_resep_fk0` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id_resep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





# Dump of table jenis_metric
# ------------------------------------------------------------

DROP TABLE IF EXISTS `jenis_metric`;

CREATE TABLE `jenis_metric` (
  `id_metric` int(11) NOT NULL AUTO_INCREMENT,
  `no_metric` varchar(50) DEFAULT NULL,
  `nama_metric` varchar(255) DEFAULT NULL,
  `keterangan` text DEFAULT NULL,
  PRIMARY KEY (`id_metric`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `jenis_metric` WRITE;
/*!40000 ALTER TABLE `jenis_metric` DISABLE KEYS */;

INSERT INTO `jenis_metric` (`id_metric`, `no_metric`, `nama_metric`, `keterangan`) VALUES
	(1, "UNIT1", "gr", "Gram");

/*!40000 ALTER TABLE `jenis_metric` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table kategori
# ------------------------------------------------------------

DROP TABLE IF EXISTS `kategori`;

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL AUTO_INCREMENT,
  `no_kategori` varchar(50) DEFAULT NULL,
  `nama_kategori` varchar(255) DEFAULT NULL,
  `id_taggable` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_kategori`),
  KEY `FK_S5WU` (`id_taggable`),
  CONSTRAINT `FK_S5WU` FOREIGN KEY (`id_taggable`) REFERENCES `taggable` (`id_taggable`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `kategori` WRITE;
/*!40000 ALTER TABLE `kategori` DISABLE KEYS */;

INSERT INTO `kategori` (`id_kategori`, `no_kategori`, `nama_kategori`, `id_taggable`) VALUES
	(1, "KTG1", "buah", 1),
	(2, "KTG2", "Hewan", 1);

/*!40000 ALTER TABLE `kategori` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table kategori_bahan_baku
# ------------------------------------------------------------

DROP TABLE IF EXISTS `kategori_bahan_baku`;

CREATE TABLE `kategori_bahan_baku` (
  `id_kategori` int(11) NOT NULL,
  `id_bahan_baku` int(11) NOT NULL,
  KEY `kategori_bahan_baku_fk0` (`id_kategori`),
  KEY `kategori_bahan_baku_fk1` (`id_bahan_baku`),
  CONSTRAINT `kategori_bahan_baku_fk0` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`),
  CONSTRAINT `kategori_bahan_baku_fk1` FOREIGN KEY (`id_bahan_baku`) REFERENCES `bahan_baku` (`id_bahan_baku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `kategori_bahan_baku` WRITE;
/*!40000 ALTER TABLE `kategori_bahan_baku` DISABLE KEYS */;

INSERT INTO `kategori_bahan_baku` (`id_kategori`, `id_bahan_baku`) VALUES
	(1, 4),
	(1, 5),
	(2, 5);

/*!40000 ALTER TABLE `kategori_bahan_baku` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table kategori_resep
# ------------------------------------------------------------

DROP TABLE IF EXISTS `kategori_resep`;

CREATE TABLE `kategori_resep` (
  `id_kategori` int(11) NOT NULL,
  `id_resep` int(11) NOT NULL,
  KEY `kategori_resep_fk0` (`id_kategori`),
  KEY `kategori_resep_fk1` (`id_resep`),
  CONSTRAINT `kategori_resep_fk0` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`),
  CONSTRAINT `kategori_resep_fk1` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id_resep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





# Dump of table resep
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resep`;

CREATE TABLE `resep` (
  `id_resep` int(11) NOT NULL,
  `no_resep` varchar(50) DEFAULT NULL,
  `nama_resep` varchar(255) DEFAULT NULL,
  `deskripsiField` varchar(255) DEFAULT NULL,
  `fotoField` blob DEFAULT NULL,
  PRIMARY KEY (`id_resep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `resep` WRITE;
/*!40000 ALTER TABLE `resep` DISABLE KEYS */;

INSERT INTO `resep` (`id_resep`, `no_resep`, `nama_resep`, `deskripsiField`, `fotoField`) VALUES
	(1, "RSP1", "testOnly", "testOnly", X'');

/*!40000 ALTER TABLE `resep` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table taggable
# ------------------------------------------------------------

DROP TABLE IF EXISTS `taggable`;

CREATE TABLE `taggable` (
  `id_taggable` int(11) NOT NULL AUTO_INCREMENT,
  `no_taggable` varchar(50) DEFAULT NULL,
  `tipe_taggable` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_taggable`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `taggable` WRITE;
/*!40000 ALTER TABLE `taggable` DISABLE KEYS */;

INSERT INTO `taggable` (`id_taggable`, `no_taggable`, `tipe_taggable`) VALUES
	(1, "TAG1", "Bahan Baku"),
	(2, "TAG2", "Resep");

/*!40000 ALTER TABLE `taggable` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of views
# ------------------------------------------------------------

# Creating temporary tables to overcome VIEW dependency errors


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

# Dump completed on 2023-07-08T06:27:25+07:00
