package com.lifegame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lifegame.dto.AttributeVO;
import com.lifegame.dto.PlayerStatsVO;
import com.lifegame.entity.PlayerAttributes;
import com.lifegame.entity.PlayerStats;
import com.lifegame.mapper.PlayerAttributesMapper;
import com.lifegame.mapper.PlayerStatsMapper;
import com.lifegame.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerStatsMapper playerStatsMapper;
    private final PlayerAttributesMapper playerAttributesMapper;

    public PlayerServiceImpl(PlayerStatsMapper playerStatsMapper,
                             PlayerAttributesMapper playerAttributesMapper) {
        this.playerStatsMapper = playerStatsMapper;
        this.playerAttributesMapper = playerAttributesMapper;
    }

    @Override
    public PlayerStatsVO getPlayerStats() {
        // 默认玩家 ID = 1
        PlayerStats stats = playerStatsMapper.selectById(1);

        List<PlayerAttributes> attrList = playerAttributesMapper.selectList(
                new LambdaQueryWrapper<PlayerAttributes>()
                        .eq(PlayerAttributes::getPlayerId, 1)
        );

        List<AttributeVO> attrVOList = attrList.stream()
                .map(a -> new AttributeVO(a.getName(), a.getValue(), a.getMaxValue()))
                .collect(Collectors.toList());

        PlayerStatsVO vo = new PlayerStatsVO();
        vo.setLevel(stats.getLevel());
        vo.setExp(stats.getExp());
        vo.setMaxExp(stats.getMaxExp());
        vo.setHp(stats.getHp());
        vo.setMaxHp(stats.getMaxHp());
        vo.setMp(stats.getMp());
        vo.setMaxMp(stats.getMaxMp());
        vo.setAttributes(attrVOList);
        return vo;
    }
}
