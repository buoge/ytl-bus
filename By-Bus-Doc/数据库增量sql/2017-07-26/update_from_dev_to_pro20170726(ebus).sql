-- 脚本内容：开发环境-生产环境增量sql
-- 提交人：谭园
-- 时间：2017/7/26

-- --------------------------------------------------------
-- 主机:                           10.1.10.76
-- 服务器版本:                        5.6.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 ebus 的数据库结构
CREATE DATABASE IF NOT EXISTS `ebus` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `ebus`;


-- 导出  表 ebus.carpool_order 结构
CREATE TABLE IF NOT EXISTS `carpool_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id，对应base_user',
  `match_id` char(32) DEFAULT NULL COMMENT '与大数据对接的撮合id',
  `old_match_id` char(36) DEFAULT NULL COMMENT '加入失败，记录手动选择要加入的matchId',
  `order_no` char(36) NOT NULL COMMENT '订单编号',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `initial_start_place` varchar(50) NOT NULL COMMENT '初始起点',
  `initial_start_lon` decimal(10,6) unsigned NOT NULL COMMENT '初始起点经度',
  `initial_start_lat` decimal(10,6) unsigned NOT NULL COMMENT '初始起点纬度',
  `initial_end_place` varchar(50) NOT NULL COMMENT '初始终点',
  `initial_end_lon` decimal(10,6) unsigned NOT NULL COMMENT '初始终点经度',
  `initial_end_lat` decimal(10,6) unsigned NOT NULL COMMENT '初始终点纬度',
  `initial_aboard_time` datetime DEFAULT NULL COMMENT '初始上车时间',
  `initial_price` decimal(10,6) unsigned NOT NULL DEFAULT '0.010000' COMMENT '初始估计票价（单个座位，单张票）',
  `seats` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '座位数',
  `paid_price` decimal(10,6) unsigned DEFAULT '0.000000' COMMENT '初始需要支付的金额',
  `arrive_or_start_time` datetime DEFAULT NULL COMMENT '规律型专用：工作日是到达终点时间，非工作日是从起点出发时间',
  `return_time` datetime DEFAULT NULL COMMENT '规律型专用：工作日或非工作日均是从终点返回时间',
  `max_walk_distance` mediumint(8) unsigned DEFAULT '0' COMMENT '能接受的最大步行距离',
  `earliest_start_time` datetime DEFAULT NULL COMMENT '临时型专用：最早出发时间',
  `latest_start_time` datetime DEFAULT NULL COMMENT '临时型专用：最晚出发时间',
  `is_regular` tinyint(3) unsigned DEFAULT '0' COMMENT '是否规律性（0：否，1：是）',
  `regular_detail` tinyint(3) unsigned DEFAULT '0' COMMENT '1:工作日，2:非工作日',
  `city_code` varchar(20) DEFAULT '0' COMMENT '城市编码',
  `initial_line_type` tinyint(3) unsigned DEFAULT '0' COMMENT '初始专线类别。1：直达专线，2：普通专线',
  `real_start_place` varchar(50) DEFAULT NULL COMMENT '实际起点',
  `real_start_lon` decimal(10,6) unsigned DEFAULT NULL COMMENT '实际起点经度',
  `real_start_lat` decimal(10,6) unsigned DEFAULT NULL COMMENT '实际起点纬度',
  `real_end_place` varchar(50) DEFAULT NULL COMMENT '实际终点',
  `real_end_lon` decimal(10,6) unsigned DEFAULT NULL COMMENT '实际终点经度',
  `real_end_lat` decimal(10,6) unsigned DEFAULT NULL COMMENT '实际终点纬度',
  `expect_aboard_time` datetime DEFAULT NULL COMMENT '预计上车时间',
  `expect_off_bus_time` datetime DEFAULT NULL COMMENT '预计下车时间',
  `real_price` decimal(10,6) unsigned DEFAULT NULL COMMENT '实际应该支付的票价金额',
  `match_times` int(10) unsigned DEFAULT '0' COMMENT '该用户被撮合的次数',
  `real_line_type` tinyint(3) unsigned DEFAULT '0' COMMENT '实际专线类别。1：直达专线，2：普通专线',
  `is_need_repay` tinyint(3) unsigned DEFAULT '0' COMMENT '是否需要补差价，0：不需要，1：需要，默认0',
  `need_repay_price` tinyint(4) unsigned DEFAULT '0' COMMENT '需要补差价的金额',
  `repay_order_no` char(36) DEFAULT NULL COMMENT '补差价订单号',
  `apply_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `status` tinyint(3) unsigned DEFAULT '0' COMMENT '0-申请未支付  1-已支付拼车中 2-待发车  3-完成',
  `match_status` tinyint(3) unsigned DEFAULT '0' COMMENT '拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)',
  `send_status` tinyint(3) unsigned DEFAULT '0' COMMENT '发送给大数据的状态(0:未发送，1:已发送-restful接口一定要有返回结果才认为已发送)',
  `contact_name` varchar(50) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(50) DEFAULT NULL COMMENT '联系人电话',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no` (`order_no`),
  KEY `user_id` (`user_id`),
  KEY `match_id` (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户拼车业务订单表';

-- 数据导出被取消选择。


-- 导出  表 ebus.carpool_push_msg 结构
CREATE TABLE IF NOT EXISTS `carpool_push_msg` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` char(36) DEFAULT NULL COMMENT '订单号',
  `push_title` varchar(100) DEFAULT NULL COMMENT '消息标题',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `push_msg` varchar(500) NOT NULL COMMENT '推送内容',
  `push_type` tinyint(3) NOT NULL COMMENT '推送类型（1-通知 2-消息）',
  `img_url` varchar(200) DEFAULT NULL COMMENT '图标存储地址',
  `city_code` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='记录拼车过程中推送的消息';

-- 数据导出被取消选择。


-- 导出  表 ebus.carpool_push_template 结构
CREATE TABLE IF NOT EXISTS `carpool_push_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) NOT NULL COMMENT '模板名称',
  `title` varchar(200) NOT NULL COMMENT '推送标题',
  `content` varchar(500) NOT NULL COMMENT '推送内容',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `field1` varchar(100) DEFAULT NULL,
  `field2` varchar(100) DEFAULT NULL,
  `field3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='拼车模块消息推送模板表';

-- 数据导出被取消选择。


-- 导出  表 ebus.carpool_route 结构
CREATE TABLE IF NOT EXISTS `carpool_route` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `carpool_route_id` char(32) NOT NULL COMMENT '线路ID',
  `carpool_route_name` varchar(100) NOT NULL COMMENT '线路名称',
  `carpool_route_type` int(1) unsigned NOT NULL DEFAULT '1' COMMENT '1：普通专线，2：直达专线',
  `distance` decimal(10,6) unsigned DEFAULT NULL COMMENT '线路里程',
  `price` decimal(10,6) unsigned DEFAULT NULL COMMENT '票价(单位：元)',
  `start_station` varchar(50) NOT NULL COMMENT '始发站',
  `end_station` varchar(50) NOT NULL COMMENT '终点站',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '线路状态(1:临时 2:已开通)',
  `city_code` varchar(20) NOT NULL COMMENT '城市编码',
  `depart_times` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '发车次数',
  `depart_time` time DEFAULT NULL COMMENT '发车时间',
  `arrive_time` time DEFAULT NULL COMMENT '到达时间',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `carpool_route_id` (`carpool_route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='拼车撮合后形成的线路信息表';

-- 数据导出被取消选择。


-- 导出  表 ebus.carpool_route_assit_station 结构
CREATE TABLE IF NOT EXISTS `carpool_route_assit_station` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `carpool_route_id` char(32) NOT NULL COMMENT '线路ID',
  `station_map` text NOT NULL COMMENT '辅助站点信息,100.1,12.1|100.2,12.2',
  `city_code` varchar(20) NOT NULL COMMENT '城市编码',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `carpool_route_id` (`carpool_route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='拼车撮合后行程的线路辅助站点表';

-- 数据导出被取消选择。


-- 导出  表 ebus.carpool_route_station 结构
CREATE TABLE IF NOT EXISTS `carpool_route_station` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `carpool_route_id` char(36) NOT NULL COMMENT '线路ID',
  `station_id` varchar(20) NOT NULL COMMENT '站点id',
  `station_name` varchar(100) DEFAULT NULL COMMENT '站点名称',
  `station_lon` decimal(10,6) unsigned DEFAULT NULL COMMENT '站点经度',
  `station_lat` decimal(10,6) unsigned DEFAULT NULL COMMENT '站点纬度',
  `station_no` int(11) unsigned NOT NULL COMMENT '在该线路中是几站',
  `arrive_time` datetime NOT NULL COMMENT '预计到达该站点时间',
  `up_num` tinyint(4) unsigned DEFAULT NULL COMMENT '上车人数',
  `down_num` tinyint(4) unsigned DEFAULT NULL COMMENT '下车人数',
  `station_type` tinyint(4) unsigned DEFAULT NULL COMMENT '站点类型：1-起点 2-中途站点 3-终点',
  `city_code` varchar(20) NOT NULL COMMENT '城市编码',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `carpool_route_id` (`carpool_route_id`,`station_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='拼车撮合后形成的线站关系表';

-- 数据导出被取消选择。


-- 导出  表 ebus.carpool_setting 结构
CREATE TABLE IF NOT EXISTS `carpool_setting` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户ID',
  `walk_type` tinyint(1) DEFAULT '5' COMMENT '可接受步行范围:5-上车步行不超过500米（默认） 4-上车步行不超过400米 3-上车步行不超过300米',
  `delay_minute` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '可接受延迟时间：分钟',
  `early_minute` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '可接受提前时间：分钟',
  `price_type` tinyint(1) DEFAULT NULL COMMENT '可接受车票范围:0-不接受票价变动 1-接受票价的合理波动1-2元 2-接受票价的合理波动3-5元',
  `car_type` tinyint(1) DEFAULT NULL COMMENT '可接受车辆类型:0-不接受车型变化 1-优先拼单，合理调配车型',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `city_code` varchar(50) DEFAULT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户拼车设置表';

-- 数据导出被取消选择。


-- 导出  表 ebus.driver_school_contact_record 结构
CREATE TABLE IF NOT EXISTS `driver_school_contact_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `signup_id` char(36) NOT NULL COMMENT '报名id，对应driver_school_signup主键',
  `contact_time` datetime NOT NULL COMMENT '联系时间',
  `contact_record` varchar(500) NOT NULL COMMENT '联系记录',
  PRIMARY KEY (`id`),
  KEY `signup_id` (`signup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='驾校报名联系记录';

-- 数据导出被取消选择。


-- 导出  表 ebus.driver_school_signup 结构
CREATE TABLE IF NOT EXISTS `driver_school_signup` (
  `id` char(36) NOT NULL COMMENT '主键',
  `driver_school_id` char(36) NOT NULL COMMENT '驾校id，对应base_driver_school主键（通过驾校id也就可以查询到citycode了）',
  `license_type` tinyint(3) unsigned NOT NULL COMMENT '驾照类型',
  `name` varchar(20) NOT NULL COMMENT '报名人姓名',
  `sex` tinyint(3) unsigned DEFAULT NULL COMMENT '性别(0:女 1:男)',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `tel` varchar(20) NOT NULL COMMENT '手机号码',
  `signup_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报名时间',
  `last_contact_time` datetime DEFAULT NULL COMMENT '最后一次联系时间',
  `contact_person` varchar(20) DEFAULT NULL COMMENT '联系人',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态。1：待联系，2：下次联系，3：已报名',
  PRIMARY KEY (`id`),
  KEY `driver_school_id` (`driver_school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='驾校报名';

-- 数据导出被取消选择。


-- 导出  表 ebus.my_trail_line_path 结构
CREATE TABLE IF NOT EXISTS `my_trail_line_path` (
  `id` varchar(36) NOT NULL COMMENT 'ID',
  `myTrailId` int(11) NOT NULL COMMENT '行程ID',
  `longitude` decimal(10,6) NOT NULL COMMENT '经度',
  `latitude` decimal(10,6) NOT NULL COMMENT '纬度',
  `usePosTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据上传时间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `myTrailId` (`myTrailId`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 ebus.neighbouringtour_tourist_settings 结构
CREATE TABLE IF NOT EXISTS `neighbouringtour_tourist_settings` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '中文姓名',
  `idcard_no` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '身份证号',
  `phone_no` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '联系电话',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `city_code` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '城市编码',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `field1` varchar(500) CHARACTER SET utf8 DEFAULT '' COMMENT '备用字段1',
  `field2` varchar(500) CHARACTER SET utf8 DEFAULT '' COMMENT '备用字段2',
  `field3` varchar(500) CHARACTER SET utf8 DEFAULT '' COMMENT '备用字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='周边游常用旅客表';

-- 数据导出被取消选择。


-- 导出  表 ebus.op_line_point 结构
CREATE TABLE IF NOT EXISTS `op_line_point` (
  `ID` decimal(18,0) NOT NULL,
  `lineId` decimal(12,0) DEFAULT NULL,
  `Longitude` decimal(10,6) DEFAULT NULL,
  `Latitude` decimal(10,6) DEFAULT NULL,
  `direction` int(1) DEFAULT '0' COMMENT '上下行（0:上行 1:下行）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 ebus.questionnaire_survey 结构
CREATE TABLE IF NOT EXISTS `questionnaire_survey` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `url` varchar(250) NOT NULL COMMENT '问卷星中对应问卷的URL',
  `title` varchar(50) NOT NULL COMMENT '问卷标题',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `field1` varchar(500) DEFAULT NULL COMMENT '备用字段1',
  `field2` varchar(500) DEFAULT NULL COMMENT '备用字段2',
  `field3` varchar(500) DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`),
  KEY `gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='问卷调查';

-- 数据导出被取消选择。


-- 导出  表 ebus.travel_around 结构
CREATE TABLE IF NOT EXISTS `travel_around` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `travel_type` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '类型。1：探险旅游，2：美食外卖，3：雅致生活',
  `template_type` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '模版类型。1：普通模版，2：极简模版',
  `city_code` varchar(20) NOT NULL COMMENT '城市编码，-1代表所有城市',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `location` varchar(150) NOT NULL COMMENT '地点',
  `brief_introduction` varchar(500) NOT NULL COMMENT '简介',
  `is_permanent_valid` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否永久有效，0：否，1：是。默认0.',
  `start_valid_period` datetime DEFAULT NULL COMMENT '有效期起始时间',
  `end_valid_period` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `trip_date` varchar(1000) NOT NULL COMMENT '可出行日期，多个用逗号分个',
  `original_price` decimal(10,6) unsigned NOT NULL COMMENT '原价',
  `current_price` decimal(10,6) unsigned NOT NULL COMMENT '现价',
  `ticket_num` int(11) unsigned NOT NULL COMMENT '票数',
  `is_ticket_num_shown` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '页面是否显示库存，0：不显示，1：显示。默认1.',
  `person_limit_num` int(11) unsigned NOT NULL DEFAULT '5' COMMENT '每人限购数量',
  `pics` varchar(800) NOT NULL COMMENT '图片，多条用逗号分隔',
  `is_recommended` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否开启推荐，0：否，1：是。默认0.',
  `related_customline` varchar(1000) DEFAULT NULL COMMENT '关联的专线，多条用逗号分隔',
  `event_detail` varchar(5000) NOT NULL COMMENT '活动详情',
  `ticket_note` varchar(5000) NOT NULL COMMENT '购票须知',
  `pv` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'pv数',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `field1` varchar(500) DEFAULT '',
  `field2` varchar(500) DEFAULT '',
  `field3` varchar(500) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `city_code` (`city_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周边游';

-- 数据导出被取消选择。


-- 导出  表 ebus.user_od 结构
CREATE TABLE IF NOT EXISTS `user_od` (
  `id` varchar(36) NOT NULL COMMENT '记录od唯一号',
  `calculated_date` date NOT NULL COMMENT '计算出来日期',
  `type` int(11) unsigned NOT NULL COMMENT '消息属性(1:已消费，2:收藏，3:搜索计算，4:热点站点)',
  `week` int(11) unsigned NOT NULL COMMENT '星期(1:周一，2：周二，依此类推)',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `registration_id` varchar(100) DEFAULT NULL COMMENT '手机注册号',
  `start_station` varchar(128) NOT NULL COMMENT '起点站(备用)',
  `start_longitude` decimal(10,6) NOT NULL COMMENT 'O点经度',
  `start_latitude` decimal(10,6) NOT NULL COMMENT 'O点纬度',
  `start_radius` int(11) unsigned NOT NULL COMMENT 'o点半径(单位:米)',
  `start_time` time NOT NULL COMMENT 'O点平均起始时间',
  `end_station` varchar(128) NOT NULL COMMENT '终点站（备用）',
  `end_longitude` double NOT NULL COMMENT 'D点经度',
  `end_latitude` double NOT NULL COMMENT 'D点纬度',
  `end_radius` int(11) unsigned NOT NULL COMMENT 'd点半径(单位:米)',
  `od_distance` double unsigned NOT NULL COMMENT 'od的距离(单位:米)',
  `end_time` time NOT NULL COMMENT 'D点平均结束时间',
  `priority` int(11) unsigned DEFAULT NULL COMMENT '条件优先级(查询数据中TOP5的排序)',
  `city_code` varchar(20) NOT NULL COMMENT '城市编码',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city_code` (`city_code`),
  KEY `week` (`week`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户od表';

-- 数据导出被取消选择。


-- 导出  表 ebus.weather_notice 结构
CREATE TABLE IF NOT EXISTS `weather_notice` (
  `ID` varchar(36) NOT NULL COMMENT '主键',
  `IMPORTANT_GRADE` tinyint(1) DEFAULT NULL COMMENT '重要性等级（1-一般  2-较重要  3-非常重要）',
  `NOTICE_RANGE` tinyint(1) DEFAULT NULL COMMENT '通知范围（1-所有城市 2-全城 3-指定地点范围 4-指定线路范围）',
  `DISTANCE_RANGE` int(10) DEFAULT NULL COMMENT '距离范围（单位米）按指定地点范围发送时有值',
  `CITY_CODE` varchar(20) DEFAULT NULL COMMENT '城市编码(按全城发布和按线路发布时填写)',
  `ROUTE_STR` varchar(255) DEFAULT NULL COMMENT '已选线路（多条线路中间以逗号分割）按线路发布时填写',
  `CONTENT` varchar(120) NOT NULL COMMENT '通知内容',
  `PUBLISH_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `PUBLISH_STATUS` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1-未发布 2-已发布',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 ebus.weather_notice_history 结构
CREATE TABLE IF NOT EXISTS `weather_notice_history` (
  `ID` varchar(36) NOT NULL COMMENT '主键',
  `NOTICE_ID` varchar(36) DEFAULT NULL COMMENT '天气紧急通知ID',
  `USER_ID` varchar(36) NOT NULL COMMENT '按所有城市发布-ALL_USER；按全城发布-城市cityCode；其他-App用户ID',
  `CONTENT` varchar(120) NOT NULL COMMENT '通知内容',
  `BUS_COMPANY_TITLE` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '公交公司标题',
  `IMG_URL` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '公交公司图片地址',
  `NOTICE_TYPE` tinyint(3) unsigned DEFAULT NULL COMMENT '通知类别(1：图文消息、2：拼车动态、3：广告H5)',
  `ENTITY_ID` int(10) unsigned DEFAULT NULL COMMENT '实体id(如拼车id)，与NOTICE_URL不可同时为空',
  `NOTICE_URL` varchar(150) DEFAULT NULL COMMENT '跳转url，与ENTITY_ID不可同时为空',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 ebus.weather_notice_point 结构
CREATE TABLE IF NOT EXISTS `weather_notice_point` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `noticeId` varchar(36) NOT NULL COMMENT '通知主键',
  `longitude` double(10,6) NOT NULL COMMENT '经度',
  `latitude` double(10,6) NOT NULL COMMENT '纬度',
  PRIMARY KEY (`id`),
  KEY `noticeIdIndex` (`noticeId`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

drop table if exists my_trail;
CREATE TABLE `my_trail` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`routeId` VARCHAR(20) NULL DEFAULT NULL COMMENT '线路ID',
	`direction` INT(1) NULL DEFAULT NULL COMMENT '线路方向',
	`vehicleId` VARCHAR(36) NULL DEFAULT NULL COMMENT '车辆编号',
	`busPlateNumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '车牌号',
	`driverNumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '司机编号',
	`driverName` VARCHAR(50) NULL DEFAULT NULL COMMENT '司机名称',
	`userId` INT(11) NULL DEFAULT NULL COMMENT '用户id',
	`startStationId` INT(11) NULL DEFAULT NULL COMMENT '上车站点id',
	`startLongitude` DECIMAL(10,6) NULL DEFAULT NULL COMMENT '上车站经度',
	`startLatitude` DECIMAL(10,6) NULL DEFAULT NULL COMMENT '上车站纬度',
	`startTime` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
	`endStationId` INT(11) NULL DEFAULT NULL COMMENT '下车站点id',
	`endLongitude` DECIMAL(10,6) NULL DEFAULT NULL COMMENT '下车站经度',
	`endLatitude` DECIMAL(10,6) NULL DEFAULT NULL COMMENT '下车站纬度',
	`endTime` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
	`createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`cityCode` VARCHAR(50) NULL DEFAULT NULL COMMENT '城市编码',
	`trailDistance` DOUBLE(10,2) NULL DEFAULT NULL COMMENT '总行程（km）',
	`routeName` VARCHAR(100) NULL DEFAULT NULL COMMENT '线路名称',
	`carbonEmission` DOUBLE NULL DEFAULT NULL COMMENT '碳排放（KG）',
	`evaluateStatus` INT(1) NOT NULL DEFAULT '0' COMMENT '评价状态（0-未评价 1-已评价）',
	PRIMARY KEY (`id`)
)
COMMENT='我的行程'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4;

CREATE TABLE `base_booktravel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `goods_id` varchar(50) NOT NULL COMMENT '商品id',
  `travel_around_id` varchar(36) NOT NULL COMMENT '周边游ID',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `location` varchar(150) DEFAULT NULL COMMENT '地点',
  `pics` varchar(800) DEFAULT NULL COMMENT '图片url，多条用逗号分隔',
  `trip_date` varchar(1000) DEFAULT NULL COMMENT '可出行日期，多个用逗号分个',
  `tourist_id` varchar(150) DEFAULT NULL COMMENT '旅客ID，多个ID用逗号分隔',
  `user_id` int(10) unsigned DEFAULT NULL COMMENT '用户id，对应base_user',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `single_price` decimal(10,6) unsigned NOT NULL COMMENT '单张票价',
  `ticket_num` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '票数',
  `status` varchar(1) NOT NULL DEFAULT '0' COMMENT '周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效',
  `city_code` varchar(20) NOT NULL COMMENT '城市编码',
  `field1` varchar(500) DEFAULT '' COMMENT '备用字段1',
  `field2` varchar(500) DEFAULT '' COMMENT '备用字段2',
  `field3` varchar(500) DEFAULT '' COMMENT '备用字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周边游订单详情表';


CREATE TABLE `base_circular_tour` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tour_name` varchar(50) NOT NULL COMMENT '游玩名称',
  `tour_url` varchar(250) NOT NULL COMMENT '游玩url',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `city_code` varchar(50) NOT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周边游主表';


CREATE TABLE `base_common_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `question_type` tinyint(1) NOT NULL COMMENT '问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他',
  `question_title` varchar(150) NOT NULL COMMENT '标题',
  `question_icon_url` varchar(250) DEFAULT NULL COMMENT '图片url',
  `question_content` varchar(500) DEFAULT NULL COMMENT '内容',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `city_code` varchar(50) DEFAULT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='常用问题表';


CREATE TABLE `base_driver_school` (
  `id` char(36) NOT NULL COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '驾校名称',
  `image` varchar(150) NOT NULL COMMENT '照片',
  `introduction` text NOT NULL COMMENT '简介',
  `location` varchar(150) NOT NULL COMMENT '地址',
  `tel` varchar(20) NOT NULL COMMENT '联系方式',
  `accept_licenses` varchar(30) NOT NULL COMMENT '能报名的驾照类型，用逗号分隔',
  `citycode` varchar(20) NOT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`),
  KEY `citycode` (`citycode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='驾校基本信息';


CREATE TABLE `base_evaluation_general` (
  `id` varchar(36) NOT NULL COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '评价人',
  `route_name` varchar(50) DEFAULT NULL COMMENT '线路名称（当评价对象是站台时为空）',
  `direction` int(2) DEFAULT NULL COMMENT '线路方向（0-上行 1-下行 2-环线）',
  `driver` varchar(50) DEFAULT NULL COMMENT '司机',
  `bus_plate_number` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `comment` text COMMENT '评价（更多细节）',
  `kind` int(2) DEFAULT '0' COMMENT '评价纬度（0-综合评价，后续可能会把车辆评价和站台评价整合进来）',
  `city_code` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `attach_paths` varchar(400) DEFAULT NULL COMMENT '车辆到站速度',
  `bus_arrive_speed_star` tinyint(2) DEFAULT NULL COMMENT '星级-车辆到达及时度',
  `comfort_in_bus_star` tinyint(2) DEFAULT NULL COMMENT '车内舒适度',
  `service_for_driver_star` tinyint(2) DEFAULT NULL COMMENT '司机服务态度',
  `station_facilities_star` tinyint(2) DEFAULT NULL COMMENT '站台设施齐全度',
  `riding_place_reasonable_star` tinyint(2) DEFAULT NULL COMMENT '乘车点是否合理',
  `position` varchar(100) DEFAULT NULL COMMENT '位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='综合评价表';


CREATE TABLE `base_evaluation_general_tag` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `bus_arrive_speed_star` tinyint(2) NOT NULL DEFAULT '5' COMMENT '星级-车辆到达及时度',
  `comfort_in_bus_star` tinyint(2) NOT NULL DEFAULT '5' COMMENT '星级-车内舒适度',
  `service_for_driver_star` tinyint(2) NOT NULL DEFAULT '5' COMMENT '星级-司机服务态度',
  `station_facilities_star` tinyint(2) NOT NULL DEFAULT '5' COMMENT '星级-站台设施齐全度',
  `riding_place_reasonable_star` tinyint(2) NOT NULL DEFAULT '5' COMMENT '星级-乘车点是否合理',
  `comment` text NOT NULL COMMENT '描述客户想说的话',
  `count` int(20) unsigned NOT NULL DEFAULT '1' COMMENT '被使用次数',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='综合评价自定义标签信息表';


CREATE TABLE `base_favorite_tag` (
  `id` char(36) NOT NULL COMMENT '主键id',
  `name` varchar(200) NOT NULL COMMENT '标签名称',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `citycode` varchar(20) NOT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户自定义标签表';


alter table `base_order` modify `payType` tinyint(4) DEFAULT '100' COMMENT '支付方式：1-支付宝 2-微信 3-其他 4-钱包 100-默认值无意义';


alter table `base_order_detail` modify `type` tinyint(4) DEFAULT NULL COMMENT '订单类型 1-预定车票 2-包车（专车）3-拼车订单 4-周边游订单';


alter table `base_route` add `intervals` varchar(100) DEFAULT NULL COMMENT '发车间隔';


alter table `base_service_ip` modify `authority` smallint(1) DEFAULT NULL COMMENT '权限  (0：只有资讯；1：有资讯有专车专线无钱包我的订单；2：有资讯有钱包我的订单无专车专线；3：有资讯有专车专线有钱包我的订单)';

ALTER TABLE `base_service_ip` ADD `authDesc` VARCHAR(500) DEFAULT NULL COMMENT '具体权限描述';
ALTER TABLE `base_service_ip` ADD `busCompanyTitle` VARCHAR(100) DEFAULT NULL COMMENT '公交公司标题';
ALTER TABLE `base_service_ip` ADD `tel` VARCHAR(20) DEFAULT NULL COMMENT '公交公司联系电话(客服电话)';


ALTER TABLE base_user DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

alter table `base_user` modify `userName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
modify  `phoneNo` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
modify  `wechatNo` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信号',
modify  `qqNo` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'QQ号码',
modify  `microBlogNo` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微博号',
modify  `nickName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
modify  `sex` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '0:女 1:男',
modify  `iconURL` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片URL',
modify  `cityName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所在城市',
modify  `cityCode` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '城市编码',
modify  `registrationId` varchar(100) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '极光返回的唯一码',
modify  `backURL` varchar(2000) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '背景URL',
modify  `sign` varchar(200) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '个人签名';

alter table `base_user` add `lastLoginSysType` int(1) DEFAULT NULL COMMENT '最后登入系统类型(1-ANDROID 2-IOS)';


CREATE TABLE `base_user_address_setting` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `address_user_id` int(11) unsigned NOT NULL COMMENT '用户ID',
  `firm_name` varchar(150) DEFAULT '' COMMENT '公司/学校名称',
  `home_name` varchar(150) DEFAULT '' COMMENT '家名称',
  `firm_longitude` decimal(10,6) unsigned DEFAULT NULL COMMENT '公司经度',
  `firm_latitude` decimal(10,6) unsigned DEFAULT NULL COMMENT '公司纬度',
  `home_longitude` decimal(10,6) unsigned DEFAULT NULL COMMENT '家经度',
  `home_latitude` decimal(10,6) unsigned DEFAULT NULL COMMENT '家纬度',
  `up_time` varchar(20) DEFAULT NULL COMMENT '上班时间',
  `down_time` varchar(20) DEFAULT NULL COMMENT '下班时间',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `city_code` varchar(50) DEFAULT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`),
  KEY `address_user_id` (`address_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址设置表';


CREATE TABLE `bd_common_search` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `route_id` varchar(20) NOT NULL COMMENT '线路id',
  `direction` int(11) NOT NULL COMMENT '线路方向 0:上行 1:下行',
  `route_name` varchar(100) NOT NULL COMMENT '线路名称',
  `aboard_station_id` int(11) NOT NULL COMMENT '上车站点id',
  `aboard_station_name` varchar(100) NOT NULL COMMENT '上车站点名称',
  `aboard_position` varchar(100) NOT NULL COMMENT '上车位置',
  `aboard_time` datetime NOT NULL COMMENT '上车时间',
  `longitude` decimal(10,6) NOT NULL COMMENT '位置精度',
  `latitude` decimal(10,6) NOT NULL COMMENT '位置纬度',
  `citycode` varchar(20) NOT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='大数据常用查询对接表';


CREATE TABLE `carpool_match` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `match_id` char(32) DEFAULT NULL COMMENT '撮合id',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `match_status` tinyint(4) unsigned NOT NULL COMMENT '拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)',
  `match_persons` tinyint(4) unsigned DEFAULT NULL COMMENT '已拼车人数',
  `required_persons` tinyint(4) unsigned DEFAULT NULL COMMENT '需要人数',
  `depart_bus_seats` tinyint(4) unsigned DEFAULT NULL COMMENT '实际发车车型座位数',
  `match_times` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '撮合次数',
  `depart_time` datetime DEFAULT NULL COMMENT '发车时间',
  `dynamic_msg` varchar(500) DEFAULT NULL COMMENT '动态拼车信息，多条用;隔开',
  `match_expect_time` int(10) DEFAULT NULL COMMENT '拼车预计时间，只有在拼车中时才需要，拼车完成后不再关注，单位：秒',
  `carpool_route_id` char(32) DEFAULT NULL COMMENT '撮合生成的临时线路id',
  `city_code` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `vehicle_id` varchar(20) DEFAULT NULL COMMENT '车辆编号',
  `bus_plate_number` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `depart_bus_type` int(1) unsigned DEFAULT NULL COMMENT '车型',
  `driver_id` varchar(20) DEFAULT NULL COMMENT '司机编号',
  `driver_name` varchar(100) DEFAULT NULL COMMENT '司机姓名',
  `driver_phone_no` varchar(20) DEFAULT NULL COMMENT '司机手机号码',
  `driver_judgement` varchar(200) DEFAULT NULL COMMENT '司机评价等级',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `match_id` (`match_id`),
  KEY `carpool_route_id` (`carpool_route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态撮合表(拼车业务)';


CREATE TABLE `carpool_match_progress` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `match_id` char(36) DEFAULT NULL COMMENT '对应carpool_match的撮合id',
  `progess_type` tinyint(1) DEFAULT '2' COMMENT '撮合类型:1-首次撮合 2-正在撮合 3-最后一次撮合',
  `progess_no` char(36) DEFAULT NULL COMMENT '撮合进度号：代表第几次撮合',
  `progess_order_no` char(36) DEFAULT NULL COMMENT '此次撮合对应的拼车订单号',
  `progress_detail` varchar(500) DEFAULT NULL COMMENT '撮合详情',
  `city_code` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='撮合进度表(拼车业务)';

