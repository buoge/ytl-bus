-- 脚本内容：开发环境增量sql
-- 描述：对carpool_order表字段match_status更改
-- 提交人：谭园
-- 时间：2017/7/31

use ebus;
ALTER TABLE `carpool_order`
	CHANGE COLUMN `match_status` `match_status` TINYINT(3) NULL DEFAULT '0' COMMENT '拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)' AFTER `status`;