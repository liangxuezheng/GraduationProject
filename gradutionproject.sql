/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : gradutionproject
Target Host     : localhost:3306
Target Database : gradutionproject
Date: 2019-12-19 10:36:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `act_aid` int(10) NOT NULL AUTO_INCREMENT,
  `act_name` varchar(20) DEFAULT NULL COMMENT '标题',
  `creat_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `act_body` varchar(50) DEFAULT NULL,
  `act_yhl` decimal(10,2) DEFAULT NULL,
  `state` int(1) DEFAULT '0' COMMENT '0关闭，1开启，状态',
  PRIMARY KEY (`act_aid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('5', '活动一', '2019-04-05 00:00:00', '2019-04-16 00:00:00', '全是', '0.70', '0');
INSERT INTO `activity` VALUES ('6', '活动二', '2019-04-05 00:00:00', '2019-04-10 00:00:00', '千瓦时', '0.80', '0');
INSERT INTO `activity` VALUES ('7', '活动三', '2019-04-05 00:00:00', '2019-04-18 00:00:00', '洒下', '0.90', '1');
INSERT INTO `activity` VALUES ('8', '活动四', '2019-04-09 00:00:00', '2019-04-18 00:00:00', '权威', '0.50', '0');
INSERT INTO `activity` VALUES ('9', 'qweqwe', '2019-04-16 00:00:00', '2019-04-18 00:00:00', 'qweeqw', '0.50', '0');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `good_gid` int(20) NOT NULL AUTO_INCREMENT,
  `shop_sid` int(20) DEFAULT NULL,
  `good_name` varchar(50) DEFAULT NULL,
  `good_info` varchar(100) DEFAULT NULL,
  `good_liebei` varchar(20) DEFAULT NULL,
  `good_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `good_price` double(20,1) DEFAULT NULL,
  `good_hdprice` double(20,1) DEFAULT NULL,
  `good_manner` varchar(20) DEFAULT NULL,
  `good_ynact` varchar(2) DEFAULT NULL,
  `good_p1` varchar(100) DEFAULT NULL,
  `good_p2` varchar(100) DEFAULT NULL,
  `good_p3` varchar(100) DEFAULT NULL,
  `good_p4` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`good_gid`),
  KEY `shopsid` (`shop_sid`),
  CONSTRAINT `shopsid` FOREIGN KEY (`shop_sid`) REFERENCES `usershop` (`shop_sid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('17', '7', '可爱短袖', '好看的短袖', '衣服', '2019-04-05 17:10:57', '54.0', '54.0', null, '否', 'http://localhost:8084/imgs/4cc6bb63-e2c9-43e1-91d6-65499fdb45a6.jpg', null, null, null);
INSERT INTO `goods` VALUES ('18', '7', '时尚短袖', '便宜甩卖', '衣服', '2019-04-05 17:10:58', '26.0', '26.0', null, '否', 'http://localhost:8084/imgs/1ba3b233-0d16-4436-ba6d-74ee35ad8c7e.jpg', null, null, null);
INSERT INTO `goods` VALUES ('19', '7', '三只松鼠坚果', '好吃', '零食', '2019-04-05 17:11:00', '13.0', '13.0', null, '否', 'http://localhost:8084/imgs/022003bc-4b7f-4baf-bca0-58a745693155.jpg', null, null, null);
INSERT INTO `goods` VALUES ('20', '7', '零食大礼包', '好吃', '零食', '2019-04-05 17:11:01', '78.0', '78.0', null, '是', 'http://localhost:8084/imgs/70231d0e-5a82-46e1-b228-f16863a110e3.jpg', null, null, null);
INSERT INTO `goods` VALUES ('21', '7', '二手苹果手机', '108G手机', '电子', '2019-04-05 17:11:06', '600.0', '600.0', null, '否', 'http://localhost:8084/imgs/3d8723d4-b264-4dc5-a158-24c507078f0c.jpg', null, null, null);
INSERT INTO `goods` VALUES ('22', '7', '二手笔记本', '华硕电子', '电子', '2019-04-05 17:11:10', '3000.0', '3000.0', null, '是', 'http://localhost:8084/imgs/d289f975-89c1-4862-9692-7ec542d35d42.jpg', null, null, null);
INSERT INTO `goods` VALUES ('23', '8', 'asda', 'fwa', '衣服', '2019-04-12 15:20:28', '1333.0', '1333.0', null, '是', 'http://localhost:8084/imgs/a39b30b2-0e89-49d8-ac46-f5d61a92e0c6.jpg', null, null, null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_oid` int(20) NOT NULL AUTO_INCREMENT,
  `user_uid` int(20) DEFAULT NULL,
  `add_aid` int(20) DEFAULT NULL,
  `sh_sid` int(20) DEFAULT NULL,
  `good_gid` int(10) DEFAULT NULL,
  `good_name` varchar(20) DEFAULT NULL,
  `order_allpri` double(20,1) DEFAULT NULL,
  `order_time` varchar(50) DEFAULT NULL,
  `order_state` varchar(20) DEFAULT '未发货',
  `order_rate` varchar(100) DEFAULT NULL,
  `upda_time` varchar(50) DEFAULT '',
  PRIMARY KEY (`order_oid`),
  KEY `orderuid` (`user_uid`),
  KEY `orderaid` (`add_aid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('16', '1', '1', '7', '17', '可爱短袖', '54.0', '2019-04-04 10:23:05', '已发货', null, '2019-04-04 10:23:48');
INSERT INTO `orders` VALUES ('17', '1', '1', '7', '22', '二手笔记本', '3000.0', '2019-04-04 10:23:05', '订单完成', null, '2019-04-04 10:27:24');
INSERT INTO `orders` VALUES ('18', '1', '1', '7', '22', '二手笔记本', '3000.0', '2019-04-05 18:06:16', '未发货', null, '');
INSERT INTO `orders` VALUES ('19', '1', '1', '7', '22', '二手笔记本', '2700.0', '2019-04-05 18:09:08', '未发货', null, '');
INSERT INTO `orders` VALUES ('20', '14', '3', '7', '20', '零食大礼包', '54.6', '2019-04-12 15:19:57', '未发货', null, '');
INSERT INTO `orders` VALUES ('21', '14', '3', '7', '21', '二手苹果手机', '600.0', '2019-04-12 15:19:57', '未发货', null, '');
INSERT INTO `orders` VALUES ('22', '14', '3', '7', '20', '零食大礼包', '70.2', '2019-04-12 15:24:16', '未发货', null, '');
INSERT INTO `orders` VALUES ('23', '15', '4', '7', '20', '零食大礼包', '70.2', '2019-04-13 11:07:29', '未发货', null, '');
INSERT INTO `orders` VALUES ('24', '16', '5', '7', '20', '零食大礼包', '70.2', '2019-04-14 10:05:41', '未发货', null, '');
INSERT INTO `orders` VALUES ('25', '16', '5', '7', '21', '二手苹果手机', '600.0', '2019-04-14 10:05:41', '未发货', null, '');

-- ----------------------------
-- Table structure for shipaddress
-- ----------------------------
DROP TABLE IF EXISTS `shipaddress`;
CREATE TABLE `shipaddress` (
  `add_aid` int(20) NOT NULL AUTO_INCREMENT,
  `user_uid` int(20) DEFAULT NULL,
  `add_name` varchar(20) DEFAULT NULL,
  `add_address` varchar(100) DEFAULT NULL,
  `add_phone` varchar(11) DEFAULT NULL,
  `add_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`add_aid`),
  KEY `uuid` (`user_uid`),
  CONSTRAINT `uuid` FOREIGN KEY (`user_uid`) REFERENCES `user` (`user_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipaddress
-- ----------------------------
INSERT INTO `shipaddress` VALUES ('1', '1', '王五', '河北经贸大学', '15243303211', '1');
INSERT INTO `shipaddress` VALUES ('2', '7', '梁学政', '河北经贸大学', '15243303203', '1');
INSERT INTO `shipaddress` VALUES ('3', '14', '1was', 'wqeqw', '1515', '1');
INSERT INTO `shipaddress` VALUES ('4', '15', '周思通', '河北经贸', '15243303200', '1');
INSERT INTO `shipaddress` VALUES ('5', '16', 'qe', 'qeqe', '1213', '1');

-- ----------------------------
-- Table structure for shipping
-- ----------------------------
DROP TABLE IF EXISTS `shipping`;
CREATE TABLE `shipping` (
  `sh_sid` int(20) NOT NULL AUTO_INCREMENT,
  `user_uid` int(20) DEFAULT NULL,
  `good_gid` int(20) DEFAULT NULL,
  `good_name` varchar(50) DEFAULT NULL,
  `good_jianjie` varchar(100) DEFAULT NULL,
  `good_p1` varchar(100) DEFAULT NULL,
  `good_price` double(20,1) DEFAULT NULL,
  PRIMARY KEY (`sh_sid`),
  KEY `suid` (`user_uid`),
  KEY `sgid` (`good_gid`),
  CONSTRAINT `sgid` FOREIGN KEY (`good_gid`) REFERENCES `goods` (`good_gid`),
  CONSTRAINT `suid` FOREIGN KEY (`user_uid`) REFERENCES `user` (`user_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipping
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_uid` int(20) NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(11) NOT NULL,
  `user_pass` varchar(50) NOT NULL,
  `user_salt` varchar(20) NOT NULL,
  `user_flag` int(1) NOT NULL DEFAULT '2',
  PRIMARY KEY (`user_uid`),
  UNIQUE KEY `user_phone_unique` (`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '15243303200', '123456', 'aasq', '2');
INSERT INTO `user` VALUES ('2', '13180366565', '123', 'rldhcx', '2');
INSERT INTO `user` VALUES ('4', '123456789', '123', 'pianll', '1');
INSERT INTO `user` VALUES ('5', '13930621049', '1234', 'yxztga', '2');
INSERT INTO `user` VALUES ('6', '15243303206', '123', 'csmyrj', '2');
INSERT INTO `user` VALUES ('7', '15243303203', '123456', 'prqcih', '2');
INSERT INTO `user` VALUES ('14', '15243303100', '123456', 'ptcgnb', '2');
INSERT INTO `user` VALUES ('15', '13831606556', '123456', 'ficaic', '2');
INSERT INTO `user` VALUES ('16', '15243303211', '123', 'tbjpps', '2');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `info_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_uid` int(20) NOT NULL,
  `info_nc` varchar(20) DEFAULT NULL,
  `info_name` varchar(20) DEFAULT NULL,
  `info_idcard` varchar(18) DEFAULT NULL,
  `info_sex` varchar(2) DEFAULT NULL,
  `info_school` varchar(50) DEFAULT NULL,
  `info_qq` varchar(20) DEFAULT NULL,
  `info_email` varchar(50) DEFAULT NULL,
  `info_grade` varchar(20) NOT NULL DEFAULT '一级会员',
  `info_balance` int(20) DEFAULT '0',
  `info_touxiang` varchar(255) DEFAULT NULL,
  `email_code` varchar(20) DEFAULT NULL,
  `email_state` varchar(20) NOT NULL DEFAULT '未认证',
  `idcard_state` varchar(20) DEFAULT '未认证',
  PRIMARY KEY (`info_id`),
  UNIQUE KEY `nc_unique` (`info_nc`),
  UNIQUE KEY `idcard_unique` (`info_idcard`),
  KEY `user_uid` (`user_uid`),
  CONSTRAINT `user_uid` FOREIGN KEY (`user_uid`) REFERENCES `user` (`user_uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('10', '1', '荧幕', '梁学政', '13102619960215861X', '男', '河北经贸大学', '1609078897', '1609078897@qq.com', '一级会员', '0', 'http://localhost:8084/imgs/tupian4.jpg', '141651', '已认证', '已认证');
INSERT INTO `userinfo` VALUES ('11', '2', '爱猫的老鼠', '梁学政', '1231515', '男', '河北', '1609078897', null, '一级会员', '0', 'http://localhost:8084/imgs/tupian3.jpg', null, '未认证', '已认证');
INSERT INTO `userinfo` VALUES ('14', '5', '爱心', '切勿啊', '13123', '男', '123', '1312', null, '一级会员', '0', 'http://localhost:8084/imgs/tupian2.jpg', null, '未认证', '已认证');
INSERT INTO `userinfo` VALUES ('15', '6', '清完啊', '企鹅', '131', '男', '全是', '131', null, '一级会员', '0', 'http://localhost:8084/imgs/tupian1.jpg', null, '未认证', '已认证');
INSERT INTO `userinfo` VALUES ('16', '4', null, null, null, null, null, null, null, '一级会员', '0', '', null, '未认证', '未认证');
INSERT INTO `userinfo` VALUES ('17', '7', '咖啡猫', '梁学政', '131026199602158611', '男', '河北经贸大学', '1609078897', '1609078897@qq.com', '一级会员', '0', 'http://localhost:8084/imgs/609ae8f1-6537-436e-9bdb-67afeddacf87.jpg', '762844', '已认证', '已驳回');
INSERT INTO `userinfo` VALUES ('19', '14', 'asd', 'sda', '13102619911115', '男', 'sdasd', '1609078897', '1609078897@qq.com', '一级会员', '0', 'http://localhost:8084/imgs/47306793-cea1-419f-a582-0b287fdbecc5.jpg', '502064', '已认证', '已认证');
INSERT INTO `userinfo` VALUES ('20', '15', '小狗', '周思通', '131026199602158520', '女', '河北经贸大学', '1609078897', '1609078897@qq.com', '一级会员', '0', 'http://localhost:8084/imgs/784e228a-8156-4db0-980e-ba8eaec95028.jpg', '943551', '已认证', '已认证');
INSERT INTO `userinfo` VALUES ('21', '16', 'qwq', 'qeq', '131313', '男', 'qw', '1213', '1609078897@qq.com', '一级会员', '0', 'http://localhost:8084/imgs/d5f713f9-d027-4ae3-bd54-bf884d78eb7b.jpg', '484321', '已认证', '已认证');

-- ----------------------------
-- Table structure for usershop
-- ----------------------------
DROP TABLE IF EXISTS `usershop`;
CREATE TABLE `usershop` (
  `shop_sid` int(20) NOT NULL AUTO_INCREMENT,
  `user_uid` int(20) DEFAULT NULL,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_state` varchar(20) DEFAULT '审核中',
  `shop_jianjie` varchar(255) DEFAULT NULL,
  `shop_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`shop_sid`),
  KEY `useruid` (`user_uid`),
  CONSTRAINT `useruid` FOREIGN KEY (`user_uid`) REFERENCES `user` (`user_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usershop
-- ----------------------------
INSERT INTO `usershop` VALUES ('4', '1', '小猫咪零食店', '已审核', '我的零食最好吃', '2019-04-04 13:58:20');
INSERT INTO `usershop` VALUES ('5', '4', '1214', '已审核', '1233', '2019-03-04 15:40:28');
INSERT INTO `usershop` VALUES ('6', '2', '爱迪达衣服', '已审核', '衣服', '2019-03-17 16:18:53');
INSERT INTO `usershop` VALUES ('7', '7', '小猫咪店铺', '已审核', '专卖各种二手物品', '2019-04-04 09:46:22');
INSERT INTO `usershop` VALUES ('8', '14', 'sadasd', '已审核', 'qwee', '2019-04-12 15:18:20');
INSERT INTO `usershop` VALUES ('9', '15', '阿迪达斯二手店铺', '已审核', '正品阿迪达斯', '2019-04-13 11:21:46');
INSERT INTO `usershop` VALUES ('10', '16', 'qwqeqe', '已审核', '12qwqe', '2019-04-14 10:06:11');
