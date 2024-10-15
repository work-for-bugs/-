/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.5-10.6.5-MariaDB-1:10.6.5+maria~focal : Database - teamdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teamdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `teamdb`;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `send_user_id` int(11) NOT NULL,
  `receive_user_id` int(11) NOT NULL,
  `handle_state` int(11) DEFAULT 0,
  `team_id` int(11) NOT NULL,
  `result` int(11) DEFAULT NULL,
  `examine` int(11) DEFAULT 0,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

/*Data for the table `message` */

insert  into `message`(`message_id`,`send_user_id`,`receive_user_id`,`handle_state`,`team_id`,`result`,`examine`) values (9,1,20,1,6,1,1),(10,1,2,1,2,1,1),(11,1,4,0,3,NULL,1),(12,2,12,0,7,NULL,1),(13,3,6,1,8,1,1),(14,22,21,0,9,NULL,1),(15,21,22,1,10,1,1),(16,21,7,0,4,NULL,1),(17,24,20,0,6,NULL,1),(18,26,21,1,13,1,1),(19,28,21,1,14,1,1);

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `activity_name` varchar(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `activity_image` varchar(20) DEFAULT 'default.png',
  `activity_state` int(11) DEFAULT 0,
  `activity_description` varchar(200) NOT NULL,
  `total_num` int(11) NOT NULL,
  `remain_num` int(11) NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `end_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `request` varchar(200) DEFAULT NULL,
  `examine` int(11) DEFAULT 0,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `team` */

insert  into `team`(`team_id`,`category_id`,`activity_name`,`user_id`,`activity_image`,`activity_state`,`activity_description`,`total_num`,`remain_num`,`start_time`,`end_time`,`request`,`examine`) values (1,1,'数学建模',1,'default.png',1,'数学建模比赛组队',6,5,'2022-07-04 00:00:00','2022-08-04 00:00:00','数学专业',1),(2,3,'校园歌手',2,'default.png',0,'校园歌手合唱组队',6,4,'2022-07-09 02:09:17','2022-06-06 00:00:00','喜欢唱歌',0),(3,2,'校园篮球赛',4,'default.png',2,'校园篮球赛组队',5,3,'2022-07-08 23:22:06','2022-09-03 00:00:00','喜欢篮球',1),(4,5,'威海站拼车',7,'default.png',0,'威海站拼车组队',3,2,'2022-07-09 02:09:20','2022-08-23 00:00:00','当天拼车',0),(5,6,'宿舍合租',11,'default.png',0,'山东大学校内合租',3,2,'2022-07-09 02:09:23','2022-04-12 00:00:00','性格和善',1),(6,1,'计算机竞赛',20,'default.png',1,'计算机竞赛组队',5,3,'2022-04-04 00:00:00','2022-04-12 00:00:00','计算机专业',1),(7,2,'校园足球赛',12,'default.png',0,'校园足球赛组队',10,8,'2022-07-08 23:28:08','2022-03-04 00:00:00','喜欢足球',0),(8,3,'校园舞者',6,'default.png',0,'校园歌手组队',6,5,'2022-07-09 02:09:31','2022-06-07 00:00:00','喜欢唱歌',1),(9,3,'啊啊啊啊',21,'../../img/1.jpg',0,'啊啊啊啊',8,7,'2022-07-09 02:09:34','2022-07-19 00:00:00','啊啊啊',0),(10,1,'test',22,'../../img/1.jpg',0,'test',6,2,'2022-07-09 00:45:35','2022-07-17 00:00:00','test',1),(11,4,'aaadadada',23,'../../img/1.jpg',1,'wdadasdwa',9,5,'2022-07-09 02:09:37','2022-07-20 00:00:00','wuyaoxiu',1),(12,4,'秋季出游',25,'../../img/1.jpg',0,'秋季出去玩耍',9,6,'2022-08-10 00:00:00','2022-08-11 00:00:00','无',1),(13,4,'夏季游玩',21,'../../img/1.jpg',0,'夏季游玩',7,4,'2022-07-09 08:16:57','2022-07-15 00:00:00','无',1),(14,1,'校园计算机竞赛',21,'../../img/1.jpg',0,'校园计算机竞赛',5,2,'2022-07-09 10:20:17','2022-07-10 00:00:00','对计算机了解',1);

/*Table structure for table `team_category` */

DROP TABLE IF EXISTS `team_category`;

CREATE TABLE `team_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `team_category` */

insert  into `team_category`(`category_id`,`category_name`) values (1,'竞赛'),(2,'体育'),(3,'文艺'),(4,'出游'),(5,'拼车'),(6,'合租');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(10) NOT NULL,
  `user_password` varchar(16) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_account`,`user_password`) values (1,'2019008001','123456'),(2,'2019008002','123456'),(3,'2019008003','123'),(4,'2019008004','123456'),(5,'2019008005','123456'),(6,'2019008006','123456'),(7,'2019008007','123456'),(8,'2019008008','123456'),(9,'2019008009','123456'),(10,'2019008010','123456'),(11,'2019008011','123456'),(12,'2019008012','123456'),(13,'2019008013','123456'),(14,'2019008014','123456'),(15,'2019008015','123456'),(16,'2019008016','123456'),(17,'2019008017','123456'),(18,'2019008018','123456'),(19,'2019008019','123456'),(20,'2019008020','123456'),(21,'wjl','wjl'),(22,'wzj','wzj1'),(23,'aaa','aaa'),(24,'wjl111','wjl111'),(25,'aaaaa','aaaaaa'),(26,'testuser','testuser'),(27,'zpjjj','zpjj'),(28,'testuser1','test');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `gender` char(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `user_description` varchar(100) DEFAULT NULL,
  `signature` varchar(100) DEFAULT '这个人很懒，什么都没有留下',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`user_name`,`gender`,`age`,`user_description`,`signature`) values (1,'威斯布鲁克','男',22,NULL,'喜欢数学'),(2,'杜兰特','女',21,NULL,'喜欢唱歌'),(3,'哈登','男',22,NULL,'喜欢运动'),(4,'伊巴卡','女',23,NULL,'喜欢文化'),(5,'亚当斯','男',24,NULL,'这个人很懒，什么都没有留下'),(6,'佩恩','女',23,NULL,'喜欢数学'),(7,'乔治','女',22,NULL,'喜欢语文'),(8,'安东尼','男',22,NULL,'喜欢文化'),(9,'格兰特','男',23,NULL,'喜欢唱歌'),(10,'诺尔','男',24,NULL,'喜欢篮球'),(11,'罗伯森','男',35,NULL,'喜欢画画'),(12,'弗格森','男',34,NULL,'喜欢篮球'),(13,'赛芙萝莎','男',33,NULL,'喜欢乒乓球'),(14,'费舍尔','男',39,NULL,'喜欢足球'),(15,'帕金斯','男',34,NULL,'喜欢做饭'),(16,'休斯蒂斯','女',33,NULL,'喜欢吃饭'),(17,'韦斯特','男',44,NULL,'喜欢跳高'),(18,'迪亚罗','男',33,NULL,'喜欢跳舞'),(19,'施罗德','女',22,NULL,'喜欢生物'),(20,'坎特','男',33,NULL,'喜欢计算机'),(21,'wjl','男',12,'jijijiji','这个人很懒，'),(22,'wujingzi','男',20,NULL,'这个人很懒，什么都没有留下'),(23,'未更新','男',0,NULL,'这个人很懒，什么都没有留下'),(24,'未更新','男',0,NULL,'这个人很懒，什么都没有留下'),(25,'test','女',20,'矛','这个人很懒，'),(26,'测试用户','男',20,'测试系统所用的用户','这个人很懒，什么都没有留下'),(27,'未更新','男',0,NULL,'这个人很懒，什么都没有留下'),(28,'wjl','女',20,'aaa','这个人很懒，什么都没');

/*Table structure for table `user_team_relation` */

DROP TABLE IF EXISTS `user_team_relation`;

CREATE TABLE `user_team_relation` (
  `join_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`join_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_team_relation` */

insert  into `user_team_relation`(`join_id`,`user_id`,`team_id`) values (7,1,6),(8,2,2),(9,4,3),(10,1,3),(11,2,7),(12,12,7),(13,1,2),(14,3,8),(15,22,9),(16,21,9),(17,21,10),(18,7,4),(19,21,4),(20,25,12),(21,21,13),(22,26,13),(23,21,14),(24,28,14);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
