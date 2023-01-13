
DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `classid` int NOT NULL COMMENT '班级编号',
  `classname` varchar(50) DEFAULT NULL COMMENT '班级名字',
  `time` date NOT NULL COMMENT '进入班级时间',
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `class` */

insert  into `class`(`classid`,`classname`,`time`) values (1,'1班','2021-10-10'),(2,'2班','2021-10-11'),(3,'3班','2021-10-12'),(4,'4班','2021-10-13'),(5,'5班','2021-10-14');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentid` int NOT NULL COMMENT '学号',
  `studentname` varchar(100) NOT NULL COMMENT '姓名',
  `sex` varchar(1) NOT NULL COMMENT '性别',
  `classid` int NOT NULL COMMENT '班级id',
  `birthday` date NOT NULL COMMENT '出生日期',
  PRIMARY KEY (`studentid`),
  KEY `FK_classid` (`classid`),
  CONSTRAINT `FK_classid` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


