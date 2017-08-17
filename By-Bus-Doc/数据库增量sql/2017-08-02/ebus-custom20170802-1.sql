-- 脚本内容：开发环境增量sql
-- 描述：对carpool_route表字段类型更改
-- 提交人：杨阳
-- 时间：2017/08/02

use ebus;
ALTER TABLE `carpool_route`
	CHANGE COLUMN `status` `status` TINYINT(4) NOT NULL DEFAULT '-1' COMMENT '1:工作日规律性，2:非工作日规律性,-1：非规律性' AFTER `end_station`;
ALTER TABLE `carpool_route`
	CHANGE COLUMN `price` `price` VARCHAR(20) NULL DEFAULT NULL COMMENT '票价(单位：元)' AFTER `distance`;
ALTER TABLE `carpool_route`
	CHANGE COLUMN `depart_time` `depart_time` DATETIME NULL DEFAULT NULL COMMENT '发车时间' AFTER `depart_times`,
	CHANGE COLUMN `arrive_time` `arrive_time` DATETIME NULL DEFAULT NULL COMMENT '到达时间' AFTER `depart_time`;
ALTER TABLE `carpool_route`
	COMMENT='拼车撮合中形成的线路信息表';