package com.lifegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

/**
 * 专注修炼记录表（番茄钟记录）
 */
@TableName("focus_record")
public class FocusRecord {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 记录周期, 如: 周一 */
    private String dateStr;

    /** 专注时长（分钟） */
    private Integer duration;

    /** 关联修炼的技能 ID */
    private Integer skillId;

    /** 创建时间 */
    private LocalDateTime createTime;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDateStr() { return dateStr; }
    public void setDateStr(String dateStr) { this.dateStr = dateStr; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getSkillId() { return skillId; }
    public void setSkillId(Integer skillId) { this.skillId = skillId; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
