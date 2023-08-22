/*
MySQL Data Transfer
Source Host: localhost
Source Database: elm_admin
Target Host: localhost
Target Database: elm_admin
Date: 2021/11/12 8:38:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `adminName` varchar(20) NOT NULL COMMENT '管理员名称',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `adminName_UNIQUE` (`adminName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `businessId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家编号',
  `password` varchar(20) NOT NULL COMMENT '商家密码',
  `businessName` varchar(40) NOT NULL COMMENT '商家名称',
  `businessAddress` varchar(50) DEFAULT NULL COMMENT '商家地址',
  `businessExplain` varchar(40) DEFAULT NULL COMMENT '商家介绍',
  `starPrice` decimal(5,2) DEFAULT '0.00' COMMENT '起送费',
  `deliveryPrice` decimal(5,2) DEFAULT '0.00' COMMENT '配送费',
  PRIMARY KEY (`businessId`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `foodId` int(11) NOT NULL AUTO_INCREMENT COMMENT '食品编号',
  `foodName` varchar(30) NOT NULL COMMENT '食品名称',
  `foodExplain` varchar(30) DEFAULT NULL COMMENT '食品介绍',
  `foodPrice` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '食品价格',
  `businessId` int(11) NOT NULL COMMENT '所属商家编号',
  PRIMARY KEY (`foodId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '王磊', '123');
INSERT INTO `business` VALUES ('10001', '123', '万家饺子（软件园E18店）', '沈阳市浑南区软件园E18楼1-121-3号', '各种饺子', '18.00', '3.50');
INSERT INTO `business` VALUES ('10002', '123', '小锅饭豆腐馆（全运店）', '沈阳市全运路126号', '小锅套餐', '15.00', '3.00');
INSERT INTO `business` VALUES ('10003', '123', '麦当劳麦乐送（全运路店）', '沈阳市全运路53号麦当劳', '汉堡薯条', '25.00', '4.00');
INSERT INTO `business` VALUES ('10004', '123', '米村拌饭（浑南店）', '沈阳市浑南区彩霞街26号', '拌饭套餐', '18.00', '3.00');
INSERT INTO `business` VALUES ('10005', '123', '申记串道（中海康城店）', '沈阳市中海康城社区48号', '烤串炸串', '20.00', '4.00');
INSERT INTO `business` VALUES ('10006', '123', '半亩良田排骨米饭', '沈阳市和平区三好街126号', '排骨米饭', '22.00', '4.00');
INSERT INTO `business` VALUES ('10007', '123', '茶兮鲜果饮品（国际软件园店）', '沈阳市和平区南京南街345号', '甜品饮品', '20.00', '3.00');
INSERT INTO `food` VALUES ('1', '纯肉鲜肉（水饺）', '纯肉馅饺子', '16.00', '10001');
INSERT INTO `food` VALUES ('2', '玉米鲜肉（水饺）', '玉米清香', '18.00', '10001');
INSERT INTO `food` VALUES ('3', '虾仁三鲜（蒸饺）', '三鲜馅饺子', '22.00', '10001');
INSERT INTO `food` VALUES ('4', '素三鲜（蒸饺）', '韭菜鸡蛋虾皮', '15.00', '10001');
INSERT INTO `food` VALUES ('5', '角瓜鸡蛋（蒸饺）', '角瓜鸡蛋', '16.00', '10001');
INSERT INTO `food` VALUES ('6', '蛋黄焗豆花', '蛋黄豆花', '8.00', '10002');
INSERT INTO `food` VALUES ('7', '麻婆豆腐', '麻辣味', '12.00', '10002');
