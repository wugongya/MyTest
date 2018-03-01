/*
Navicat MySQL Data Transfer

Source Server         : WuGongVmLinux
Source Server Version : 50711
Source Host           : 192.168.1.148:3306
Source Database       : vip

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-02-26 09:38:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_phone
-- ----------------------------
DROP TABLE IF EXISTS `t_phone`;
CREATE TABLE `t_phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `add_user_id` bigint(20) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `delete_flag` int(1) DEFAULT '0',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_phone
-- ----------------------------
INSERT INTO `t_phone` VALUES ('1', '1', '1', '2018-02-23 14:49:26', '0', '18353131182');
INSERT INTO `t_phone` VALUES ('2', '1', '1', '2018-02-23 15:27:14', '0', '18765413758');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user_id` bigint(20) DEFAULT NULL COMMENT '添加人',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '吴工', 'wugong', '2018-02-23 14:14:29', '1', '0');
INSERT INTO `t_user` VALUES ('2', '管理员', 'admin', '2018-02-23 14:43:02', '1', '0');
INSERT INTO `t_user` VALUES ('3', '平台账号-000', 'plat', '2018-02-23 16:09:07', null, '1');
INSERT INTO `t_user` VALUES ('4', '平台账号-001', 'plat', '2018-02-23 16:10:57', null, '0');
INSERT INTO `t_user` VALUES ('5', '平台账号', 'plat', '2018-02-23 16:11:33', null, '0');
INSERT INTO `t_user` VALUES ('6', '平台账号', 'plat', '2018-02-23 16:11:50', null, '0');
INSERT INTO `t_user` VALUES ('7', '事务1', 'plat', '2018-02-23 16:49:58', null, '0');
INSERT INTO `t_user` VALUES ('8', '事务2', 'plat', '2018-02-23 16:56:54', null, '0');
INSERT INTO `t_user` VALUES ('11', '事务3', 'plat', '2018-02-23 17:05:59', null, '0');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='shiro权限验证演示users表，因为shiro读取的指定表名称、字段名称';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'wugong', '123456');
