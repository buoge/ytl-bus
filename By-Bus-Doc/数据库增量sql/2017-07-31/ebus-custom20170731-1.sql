-- �ű����ݣ�������������sql
-- ��������carpool_order���ֶ�match_status����
-- �ύ�ˣ�̷԰
-- ʱ�䣺2017/7/31

use ebus;
ALTER TABLE `carpool_order`
	CHANGE COLUMN `match_status` `match_status` TINYINT(3) NULL DEFAULT '0' COMMENT 'ƴ��״̬(0:�����У�1: ƴ����, 2: ƴ���ɹ�, 3: �ѷ���, 4: �û����ϳ�, 5: �û������³��㣬9: �����յ�, 10: �û������ۣ�-1: ƴ��ʧ��)' AFTER `status`;