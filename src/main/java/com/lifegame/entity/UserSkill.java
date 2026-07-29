package com.lifegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

/**
 * 技能树表
 */
@TableName("user_skill")
public class UserSkill {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 技能名称 */
    private String name;

    /** 熟练度等级 */
    private Integer level;

    /** 品质: 1-白, 2-绿, 3-蓝, 4-紫, 5-金 */
    private String quality;

    /** 当前技能经验 */
    private Integer exp;

    /** 技能升级所需经验 */
    private Integer maxExp;

    /** 创建时间 */
    private LocalDateTime createTime;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }

    public String getQuality() { return quality; }
    public void setQuality(String quality) { this.quality = quality; }

    public Integer getExp() { return exp; }
    public void setExp(Integer exp) { this.exp = exp; }

    public Integer getMaxExp() { return maxExp; }
    public void setMaxExp(Integer maxExp) { this.maxExp = maxExp; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
