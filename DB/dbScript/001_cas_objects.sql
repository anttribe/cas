/*
Navicat MySQL Data Transfer

Source Server         : mycat_localhost
Source Server Version : 50508
Source Host           : localhost:8066
Source Database       : CAS

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2015-11-05 22:23:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cas_t_core_category
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_category`;
CREATE TABLE `cas_t_core_category` (
  `id` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `ordinal` int(11) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类信息表';

-- ----------------------------
-- Table structure for cas_t_core_content
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_content`;
CREATE TABLE `cas_t_core_content` (
  `id` varchar(32) NOT NULL,
  `link` varchar(1024) DEFAULT NULL,
  `content_type` varchar(8) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `website` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容信息表';

-- ----------------------------
-- Table structure for cas_t_core_content_attr
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_content_attr`;
CREATE TABLE `cas_t_core_content_attr` (
  `id` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `content_type` varchar(8) NOT NULL,
  `attr_value_type` varchar(128) DEFAULT NULL,
  KEY `FK_Reference_7` (`id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`id`) REFERENCES `cas_t_core_content_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容属性表';

-- ----------------------------
-- Table structure for cas_t_core_content_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_content_attr_value`;
CREATE TABLE `cas_t_core_content_attr_value` (
  `id` varchar(32) NOT NULL,
  `content` varchar(32) NOT NULL,
  `attr` varchar(32) NOT NULL,
  `attr_value` blob,
  PRIMARY KEY (`id`),
  KEY `FK_content_attr_value_refer` (`attr`),
  KEY `FK_content_value_refer_content` (`content`),
  CONSTRAINT `FK_content_value_refer_content` FOREIGN KEY (`content`) REFERENCES `cas_t_core_content` (`id`),
  CONSTRAINT `FK_content_attr_value_refer` FOREIGN KEY (`attr`) REFERENCES `cas_t_core_content_attr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容属性值';

-- ----------------------------
-- Table structure for cas_t_core_content_type
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_content_type`;
CREATE TABLE `cas_t_core_content_type` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='内容类型表';

-- ----------------------------
-- Table structure for cas_t_core_crawler
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_crawler`;
CREATE TABLE `cas_t_core_crawler` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `website` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `interval_time` int(11) DEFAULT NULL,
  `retry_times` int(11) DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `content_type` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `crawl_time` datetime DEFAULT NULL,
  `state` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `available` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='爬虫信息表';

-- ----------------------------
-- Table structure for cas_t_core_crawler_regular
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_crawler_regular`;
CREATE TABLE `cas_t_core_crawler_regular` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `crawler` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `content_attr` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `attr_rule` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_content_attr_refer_regular` (`content_attr`),
  KEY `FK_crawler_attr_regular` (`crawler`),
  CONSTRAINT `FK_crawler_attr_regular` FOREIGN KEY (`crawler`) REFERENCES `cas_t_core_crawler` (`id`),
  CONSTRAINT `FK_content_attr_refer_regular` FOREIGN KEY (`content_attr`) REFERENCES `cas_t_core_content_attr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='爬虫内容属性规则';

-- ----------------------------
-- Table structure for cas_t_core_website
-- ----------------------------
DROP TABLE IF EXISTS `cas_t_core_website`;
CREATE TABLE `cas_t_core_website` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `site_name` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `domain` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `logo` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `charset` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_agent` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='站点信息表';
