package com.lifegame.service.impl;

import com.lifegame.entity.PlayerStats;
import com.lifegame.entity.UserTask;
import com.lifegame.mapper.PlayerStatsMapper;
import com.lifegame.mapper.UserTaskMapper;
import com.lifegame.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    /** 完成任务获得的固定经验值 */
    private static final int TASK_EXP_REWARD = 200;

    private final UserTaskMapper userTaskMapper;
    private final PlayerStatsMapper playerStatsMapper;

    public TaskServiceImpl(UserTaskMapper userTaskMapper,
                           PlayerStatsMapper playerStatsMapper) {
        this.userTaskMapper = userTaskMapper;
        this.playerStatsMapper = playerStatsMapper;
    }

    @Override
    public List<UserTask> list() {
        return userTaskMapper.selectList(null);
    }

    @Override
    public UserTask add(UserTask task) {
        userTaskMapper.insert(task);
        return task;
    }

    @Override
    @Transactional
    public String complete(Integer id) {
        UserTask task = userTaskMapper.selectById(id);
        if (task == null) {
            throw new RuntimeException("任务不存在");
        }
        if ("已完成".equals(task.getStatus())) {
            throw new RuntimeException("任务已完成，无需重复完成");
        }

        // 更新任务状态
        task.setStatus("已完成");
        task.setFinishTime(LocalDateTime.now());
        userTaskMapper.updateById(task);

        // 给玩家增加经验
        PlayerStats player = playerStatsMapper.selectById(1);
        if (player == null) {
            throw new RuntimeException("玩家数据不存在");
        }

        int newExp = player.getExp() + TASK_EXP_REWARD;
        String upgradeMsg = null;

        // 判断是否升级（经验溢出则升级，每级清空溢出经验）
        while (newExp >= player.getMaxExp()) {
            newExp -= player.getMaxExp();
            player.setLevel(player.getLevel() + 1);
            // 每升一级提高升级所需经验
            player.setMaxExp(player.getMaxExp() + 500);
            upgradeMsg = "恭喜升级到Lv." + player.getLevel();
        }

        player.setExp(newExp);
        playerStatsMapper.updateById(player);

        return upgradeMsg;
    }
}
