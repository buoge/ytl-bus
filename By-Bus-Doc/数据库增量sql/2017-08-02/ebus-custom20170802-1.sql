-- �ű����ݣ�������������sql
-- ��������carpool_route���ֶ����͸���
-- �ύ�ˣ�����
-- ʱ�䣺2017/08/02

use ebus;
ALTER TABLE `carpool_route`
	CHANGE COLUMN `status` `status` TINYINT(4) NOT NULL DEFAULT '-1' COMMENT '1:�����չ����ԣ�2:�ǹ����չ�����,-1���ǹ�����' AFTER `end_station`;
ALTER TABLE `carpool_route`
	CHANGE COLUMN `price` `price` VARCHAR(20) NULL DEFAULT NULL COMMENT 'Ʊ��(��λ��Ԫ)' AFTER `distance`;
ALTER TABLE `carpool_route`
	CHANGE COLUMN `depart_time` `depart_time` DATETIME NULL DEFAULT NULL COMMENT '����ʱ��' AFTER `depart_times`,
	CHANGE COLUMN `arrive_time` `arrive_time` DATETIME NULL DEFAULT NULL COMMENT '����ʱ��' AFTER `depart_time`;
ALTER TABLE `carpool_route`
	COMMENT='ƴ��������γɵ���·��Ϣ��';