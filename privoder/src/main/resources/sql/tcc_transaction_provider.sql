/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : tcc

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2020-09-16 21:17:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tcc_transaction_provider
-- ----------------------------
DROP TABLE IF EXISTS `tcc_transaction_provider`;
CREATE TABLE `tcc_transaction_provider` (
  `TRANSACTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOMAIN` varchar(100) DEFAULT NULL,
  `GLOBAL_TX_ID` varbinary(32) NOT NULL,
  `BRANCH_QUALIFIER` varbinary(32) NOT NULL,
  `CONTENT` varbinary(8000) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `TRANSACTION_TYPE` int(11) DEFAULT NULL,
  `RETRIED_COUNT` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `LAST_UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`TRANSACTION_ID`),
  UNIQUE KEY `UX_TX_BQ` (`GLOBAL_TX_ID`,`BRANCH_QUALIFIER`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
