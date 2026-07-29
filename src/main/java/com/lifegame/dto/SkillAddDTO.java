package com.lifegame.dto;

/**
 * 新增技能请求体
 */
public class SkillAddDTO {

    private String name;
    private String quality;
    private Integer level;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getQuality() { return quality; }
    public void setQuality(String quality) { this.quality = quality; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
}
