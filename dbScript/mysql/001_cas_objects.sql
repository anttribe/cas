/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : cas

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-24 17:45:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_cas_content`
-- ----------------------------
DROP TABLE IF EXISTS `t_cas_content`;
CREATE TABLE `t_cas_content` (
  `contentId` varchar(32) NOT NULL COMMENT '内容id',
  `title` varchar(256) NOT NULL COMMENT '标题',
  `author` varchar(32) DEFAULT NULL COMMENT '作者',
  `publishTime` varchar(32) DEFAULT NULL COMMENT '发布时间',
  `tags` varchar(256) DEFAULT NULL COMMENT '标签',
  `topic` varchar(32) DEFAULT NULL COMMENT '主题',
  `website` varchar(32) NOT NULL COMMENT '所属站点',
  `link` varchar(1024) DEFAULT NULL COMMENT '原文链接',
  `brief` varchar(512) DEFAULT NULL COMMENT '摘要',
  `content` longtext COMMENT '内容',
  `thumbnail` varchar(1024) DEFAULT NULL COMMENT '缩略图',
  `contentType` varchar(32) NOT NULL,
  PRIMARY KEY (`contentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cas_content
-- ----------------------------

-- ----------------------------
-- Table structure for `t_cas_content_attrxpath`
-- ----------------------------
DROP TABLE IF EXISTS `t_cas_content_attrxpath`;
CREATE TABLE `t_cas_content_attrxpath` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `website` varchar(32) NOT NULL COMMENT '所属站点',
  `contentsXpath` varchar(256) NOT NULL COMMENT '内容列表xpath',
  `titleXpath` varchar(256) NOT NULL COMMENT '标题xpath',
  `briefXpath` varchar(256) DEFAULT NULL COMMENT '文章摘要xpath',
  `authorXpath` varchar(256) DEFAULT NULL COMMENT 'author作者xpath',
  `publishTimeXpath` varchar(256) DEFAULT NULL COMMENT '发布时间',
  `tagsXpath` varchar(256) DEFAULT NULL COMMENT '标签xpath',
  `contentXpath` varchar(256) DEFAULT NULL COMMENT '内容xpath',
  `linkXpath` varchar(256) DEFAULT NULL COMMENT '文章链接',
  `thumbnailXpath` varchar(256) DEFAULT NULL COMMENT '缩略图xpath',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cas_content_attrxpath
-- ----------------------------
INSERT INTO t_cas_content_attrxpath VALUES ('1', '4', '//div[@class=\'article-list\']', '//header[@class=\'single-post-header__meta\']/h1[@class=\'single-post__title\']/text()', null, '//div[@class=\'author\']/a/span[@class=\'name\']/text()', '//div[@class=\'author\']/span/time/@datetime', null, '//section[@class=\'article\']/html()', 'http://36kr.com/p/\\w+.html', '//div[@class=\'single-post-header__headline\']/img/@src');

-- ----------------------------
-- Table structure for `t_cas_theme`
-- ----------------------------
DROP TABLE IF EXISTS `t_cas_theme`;
CREATE TABLE `t_cas_theme` (
  `themeId` varchar(32) NOT NULL DEFAULT '' COMMENT '皮肤id',
  `priority` int(8) DEFAULT NULL COMMENT '优先级, 数字越小，优先级越高',
  `available` int(8) DEFAULT '1' COMMENT '是否可用',
  `themeName` varchar(256) NOT NULL DEFAULT '' COMMENT '皮肤名称',
  PRIMARY KEY (`themeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cas_theme
-- ----------------------------
INSERT INTO t_cas_theme VALUES ('charisma-cerulean', '1', '1', 'app.themes.charisma-cerulean');
INSERT INTO t_cas_theme VALUES ('charisma-classic', '2', '1', 'app.themes.charisma-classic');
INSERT INTO t_cas_theme VALUES ('charisma-cyborg', '3', '1', 'app.themes.charisma-cyborg');
INSERT INTO t_cas_theme VALUES ('charisma-darkly', '4', '1', 'app.themes.charisma-darkly');
INSERT INTO t_cas_theme VALUES ('charisma-lumen', '5', '1', 'app.themes.charisma-lumen');
INSERT INTO t_cas_theme VALUES ('charisma-simplex', '9', '1', 'app.themes.charisma-simplex');
INSERT INTO t_cas_theme VALUES ('charisma-slate', '6', '1', 'app.themes.charisma-slate');
INSERT INTO t_cas_theme VALUES ('charisma-spacelab', '8', '1', 'app.themes.charisma-spacelab');
INSERT INTO t_cas_theme VALUES ('charisma-united', '7', '1', 'app.themes.charisma-united');

-- ----------------------------
-- Table structure for `t_cas_topic`
-- ----------------------------
DROP TABLE IF EXISTS `t_cas_topic`;
CREATE TABLE `t_cas_topic` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'id',
  `topicName` varchar(256) DEFAULT '' COMMENT '主题名称',
  `parent` varchar(32) DEFAULT NULL COMMENT '父分类',
  `type` varchar(128) NOT NULL DEFAULT '' COMMENT '分类类型',
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cas_topic
-- ----------------------------
INSERT INTO t_cas_topic VALUES ('1', '移动互联', null, '');
INSERT INTO t_cas_topic VALUES ('101', '业界科技', '2', 'SITE');
INSERT INTO t_cas_topic VALUES ('102', '移动开发', '1', 'SITE');
INSERT INTO t_cas_topic VALUES ('103', '后端技术', '7', 'SITE');
INSERT INTO t_cas_topic VALUES ('104', '程序设计', '5', 'SITE');
INSERT INTO t_cas_topic VALUES ('105', '技术纵横', '7', 'SITE');
INSERT INTO t_cas_topic VALUES ('106', '移动互联', '1', 'SITE');
INSERT INTO t_cas_topic VALUES ('107', '创业投资', '2', 'SITE');
INSERT INTO t_cas_topic VALUES ('108', '手机数码', '3', 'SITE');
INSERT INTO t_cas_topic VALUES ('109', '产品设计', '4', 'SITE');
INSERT INTO t_cas_topic VALUES ('110', '营销推广', '2', 'SITE');
INSERT INTO t_cas_topic VALUES ('111', '企业应用', '6', 'SITE');
INSERT INTO t_cas_topic VALUES ('112', '技术综合', '7', 'SITE');
INSERT INTO t_cas_topic VALUES ('113', '前端开发', '7', 'SITE');
INSERT INTO t_cas_topic VALUES ('2', '科技业界', null, '');
INSERT INTO t_cas_topic VALUES ('3', '手机数码', null, '');
INSERT INTO t_cas_topic VALUES ('4', '产品设计', null, '');
INSERT INTO t_cas_topic VALUES ('5', '编程语言', null, '');
INSERT INTO t_cas_topic VALUES ('6', '架构存储', null, '');
INSERT INTO t_cas_topic VALUES ('7', '技术纵横', null, '');

-- ----------------------------
-- Table structure for `t_cas_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_cas_user`;
CREATE TABLE `t_cas_user` (
  `userId` varchar(32) NOT NULL COMMENT '用户id',
  `username` varchar(256) NOT NULL COMMENT '用户名',
  `email` varchar(256) NOT NULL COMMENT '用户邮箱',
  `password` varchar(64) NOT NULL COMMENT '密码',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cas_user
-- ----------------------------
INSERT INTO t_cas_user VALUES ('1', 'anttribe', 'anshenglimin@163.com', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for `t_cas_website`
-- ----------------------------
DROP TABLE IF EXISTS `t_cas_website`;
CREATE TABLE `t_cas_website` (
  `siteName` varchar(256) NOT NULL DEFAULT '' COMMENT '站点名',
  `siteId` varchar(32) NOT NULL COMMENT '站点id',
  `domain` varchar(256) DEFAULT NULL COMMENT '站点域名',
  `logo` varchar(256) DEFAULT NULL COMMENT 'logo图标地址',
  `topic` varchar(32) NOT NULL COMMENT '站点所属主题',
  `charset` varchar(64) DEFAULT 'UTF-8' COMMENT '站点数据字符集',
  `userAgent` varchar(256) DEFAULT NULL COMMENT '用户代理',
  `intervalTime` int(11) DEFAULT '100' COMMENT '处理2个page之间的间隔时间',
  `retryTimes` int(11) DEFAULT '3' COMMENT '处理失败之后的重复次数',
  `timeout` int(11) DEFAULT '6000' COMMENT '超时时长',
  PRIMARY KEY (`siteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cas_website
-- ----------------------------
INSERT INTO t_cas_website VALUES ('钛媒体', '1', 'http://www.tmtpost.com/', 'static/img/sites/tmtpost.png', '101', 'UTF-8', null, '100', '3', '6000');
INSERT INTO t_cas_website VALUES ('虎嗅网', '2', 'http://wwww.huxiu.com/', 'static/img/sites/huxiu.png', '101', 'UTF-8', null, '100', '3', '6000');
INSERT INTO t_cas_website VALUES ('PingWest', '3', 'http://www.pingwest.com/', 'static/img/sites/pingwest.png', '101', 'UTF-8', null, '100', '3', '6000');
INSERT INTO t_cas_website VALUES ('36氪', '4', 'http://www.36kr.com/', 'static/img/sites/36kr.png', '101', 'UTF-8', null, '100', '3', '6000');
