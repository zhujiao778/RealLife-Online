package com.lifegame.dto;

/**
 * 修改技能请求体
 */
public class SkillUpdateDTO {

    private Integer id;
    private String name;
    private String quality;
    private Integer level;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getQuality() { return quality; }
    public void setQuality(String quality) { this.quality = quality; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
}
