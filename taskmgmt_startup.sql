CREATE DATABASE IF NOT EXISTS `taskmgmt` ;
USE `taskmgmt`;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `dob` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='store user registration details';

INSERT INTO `taskmgmt`.`user` (`user_name`,`password`,`name`,`email_id`,`dob`,`gender`,`role`) 
VALUES ("nithya", "test", "Nithyanandam T", "nithyanmobile@gmail.com", "01/01/1990", "M", "ADMIN"),
("hari", "test", "Hari S", "haritest1234@gmail.com", "01/01/1990", "M", "MANAGER"),
("srini", "test", "Srini B", "srinitest1234@gmail.com", "01/01/1990", "M", "DEVELOPER");


