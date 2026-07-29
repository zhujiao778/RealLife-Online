package com.lifegame.dto;

/**
 * 六维属性视图对象
 */
public class AttributeVO {

    private String name;
    private Integer value;
    private Integer max;

    public AttributeVO() {}

    public AttributeVO(String name, Integer value, Integer max) {
        this.name = name;
        this.value = value;
        this.max = max;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getValue() { return value; }
    public void setValue(Integer value) { this.value = value; }

    public Integer getMax() { return max; }
    public void setMax(Integer max) { this.max = max; }
}
