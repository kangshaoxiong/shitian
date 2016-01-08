/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50709
Source Host           : 127.0.0.1:3306
Source Database       : shitian

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-01-08 23:49:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键：用户id',
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `realityName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `cardId` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `sex` bit(1) DEFAULT b'1' COMMENT '性别 (0 女 1男)',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加密串',
  `isLock` bit(1) DEFAULT b'0' COMMENT '是否锁定(0 否  1是)',
  `loginIP` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录id',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_users
-- ----------------------------
