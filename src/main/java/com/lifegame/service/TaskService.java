package com.lifegame.service;

import com.lifegame.entity.UserTask;
import java.util.List;

/**
 * 任务服务接口
 */
public interface TaskService {

    /** 获取任务列表 */
    List<UserTask> list();

    /** 新增任务 */
    UserTask add(UserTask task);

    /**
     * 完成任务 —— 将状态改为"已完成"并给玩家增加 200 EXP
     * @return 升级提示, 未升级则返回 null
     */
    String complete(Integer id);
}
