package com.lifegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 玩家六维属性表
 */
@TableName("player_attributes")
public class PlayerAttributes {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 关联 player_stats 表 ID */
    private Integer playerId;

    /** 属性名称, 如: 力量(STR) */
    private String name;

    /** 当前值 */
    private Integer value;

    /** 极限值 */
    private Integer maxValue;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getPlayerId() { return playerId; }
    public void setPlayerId(Integer playerId) { this.playerId = playerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getValue() { return value; }
    public void setValue(Integer value) { this.value = value; }

    public Integer getMaxValue() { return maxValue; }
    public void setMaxValue(Integer maxValue) { this.maxValue = maxValue; }
}
