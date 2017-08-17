-- 脚本内容：开发环境增量sql
-- 描述：对base_common_question表字段question_type类型更改
-- 提交人：刘浩
-- 时间：2017/7/27

-- --------------------------------------------------------
-- 主机:                           10.1.10.76
-- 服务器版本:                     5.6.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                 Linux
-- Navicat 版本:                   11.2.7
-- --------------------------------------------------------

alter table `base_common_question` modify `question_type` tinyint(3) NOT NULL COMMENT '问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他';