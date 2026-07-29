package com.lifegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 玩家核心状态表
 */
@TableName("player_stats")
public class PlayerStats {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 当前等级 */
    private Integer level;

    /** 当前经验值 */
    private Integer exp;

    /** 升级所需经验 */
    private Integer maxExp;

    /** 当前体力 */
    private Integer hp;

    /** 最大体力 */
    private Integer maxHp;

    /** 当前精力 */
    private Integer mp;

    /** 最大精力 */
    private Integer maxMp;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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
}
