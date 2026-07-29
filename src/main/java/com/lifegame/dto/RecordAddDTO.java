package com.lifegame.dto;

/**
 * 新增修炼记录请求体
 */
public class RecordAddDTO {

    private String date;
    private Integer duration;
    private Integer skillId;

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getSkillId() { return skillId; }
    public void setSkillId(Integer skillId) { this.skillId = skillId; }
}
