package com.lifegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

/**
 * 日常任务表
 */
@TableName("user_task")
public class UserTask {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 任务目标 */
    private String title;

    /** 状态: 未开始 / 已完成 */
    private String status;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 完成时间 */
    private LocalDateTime finishTime;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public LocalDateTime getFinishTime() { return finishTime; }
    public void setFinishTime(LocalDateTime finishTime) { this.finishTime = finishTime; }
}
