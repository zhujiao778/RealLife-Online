CREATE DATABASE IF NOT EXISTS life_game_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE life_game_db;

-- 1. 玩家核心状态表
CREATE TABLE `player_stats` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `level` INT NOT NULL DEFAULT 1 COMMENT '当前等级',
  `exp` INT NOT NULL DEFAULT 0 COMMENT '当前经验值',
  `max_exp` INT NOT NULL DEFAULT 1000 COMMENT '升级所需经验',
  `hp` INT NOT NULL DEFAULT 100 COMMENT '当前体力',
  `max_hp` INT NOT NULL DEFAULT 100 COMMENT '最大体力',
  `mp` INT NOT NULL DEFAULT 100 COMMENT '当前精力',
  `max_mp` INT NOT NULL DEFAULT 100 COMMENT '最大精力'
) ENGINE=InnoDB COMMENT='玩家状态表';

-- 玩家六维属性表 (拆分表方便扩展，也可以并入上表)
CREATE TABLE `player_attributes` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `player_id` INT NOT NULL COMMENT '关联player_stats',
  `name` VARCHAR(50) NOT NULL COMMENT '属性名(如: 力量(STR))',
  `value` INT NOT NULL DEFAULT 10 COMMENT '当前值',
  `max_value` INT NOT NULL DEFAULT 100 COMMENT '极限值'
) ENGINE=InnoDB COMMENT='玩家六维属性表';

-- 2. 技能树表
CREATE TABLE `user_skill` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL COMMENT '技能名称',
  `level` INT NOT NULL DEFAULT 1 COMMENT '熟练度等级',
  `quality` VARCHAR(10) NOT NULL DEFAULT '1' COMMENT '品质:1白,2绿,3蓝,4紫,5金',
  `exp` INT NOT NULL DEFAULT 0 COMMENT '当前技能经验',
  `max_exp` INT NOT NULL DEFAULT 1000 COMMENT '技能升级所需经验',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB COMMENT='技能树表';

-- 3. 任务表
CREATE TABLE `user_task` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL COMMENT '任务目标',
  `status` VARCHAR(20) NOT NULL DEFAULT '未开始' COMMENT '状态:未开始,已完成',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `finish_time` DATETIME DEFAULT NULL
) ENGINE=InnoDB COMMENT='日常任务表';

-- 4. 专注修炼记录表 (番茄钟记录)
CREATE TABLE `focus_record` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `date_str` VARCHAR(20) NOT NULL COMMENT '记录周期(如: 周一)',
  `duration` INT NOT NULL COMMENT '专注时长(分钟)',
  `skill_id` INT DEFAULT NULL COMMENT '关联修炼的技能ID',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB COMMENT='专注修炼记录表';

-- 插入一条初始玩家数据
INSERT INTO player_stats (level, exp, max_exp, hp, max_hp, mp, max_mp) VALUES (24, 3650, 5000, 85, 100, 60, 100);
INSERT INTO player_attributes (player_id, name, value) VALUES 
(1, '力量 (STR)', 45), (1, '敏捷 (AGI)', 65), (1, '体质 (VIT)', 75), 
(1, '智力 (INT)', 88), (1, '魅力 (CHA)', 55), (1, '幸运 (LUK)', 42);