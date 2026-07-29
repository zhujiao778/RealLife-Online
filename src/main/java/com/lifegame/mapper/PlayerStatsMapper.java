package com.lifegame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lifegame.entity.PlayerStats;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayerStatsMapper extends BaseMapper<PlayerStats> {
}
