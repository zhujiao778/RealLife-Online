package com.lifegame.dto;

import java.util.List;

/**
 * 玩家整体状态视图对象
 */
public class PlayerStatsVO {

    private Integer level;
    private Integer exp;
    private Integer maxExp;
    private Integer hp;
    private Integer maxHp;
    private Integer mp;
    private Integer maxMp;
    private List<AttributeVO> attributes;

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }

    public Integer getExp() { return exp; }
    public void setExp(Integer exp) { this.exp = exp; }

    public Integer getMaxExp() { return maxExp; }
    public void setMaxExp(Integer maxExp) { this.maxExp = maxExp; }

    public Integer getHp() { return hp; }
    public void setHp(Integer hp) { this.hp = hp; }

    public Integer getMaxHp() { return maxHp; }
    public void setMaxHp(Integer maxHp) { this.maxHp = maxHp; }

    public Integer getMp() { return mp; }
    public void setMp(Integer mp) { this.mp = mp; }

    public Integer getMaxMp() { return maxMp; }
    public void setMaxMp(Integer maxMp) { this.maxMp = maxMp; }

    public List<AttributeVO> getAttributes() { return attributes; }
    public void setAttributes(List<AttributeVO> attributes) { this.attributes = attributes; }
}
