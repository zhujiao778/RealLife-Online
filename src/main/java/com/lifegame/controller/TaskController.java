package com.lifegame.controller;

import com.lifegame.common.Result;
import com.lifegame.dto.TaskAddDTO;
import com.lifegame.entity.UserTask;
import com.lifegame.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 任务模块
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /** 3.1 获取任务列表 */
    @GetMapping("/list")
    public Result<List<UserTask>> list() {
        return Result.success(taskService.list());
    }

    /** 3.2 接取新任务 */
    @PostMapping("/add")
    public Result<UserTask> add(@RequestBody TaskAddDTO dto) {
        UserTask task = new UserTask();
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus() != null ? dto.getStatus() : "未开始");
        return Result.success(taskService.add(task));
    }

    /** 3.3 完成任务 —— 后端处理玩家获得 EXP 的逻辑 */
    @PutMapping("/complete/{id}")
    public Result<Map<String, String>> complete(@PathVariable Integer id) {
        String upgradeMsg = taskService.complete(id);
        if (upgradeMsg != null) {
            return Result.success(Map.of("upgradeMsg", upgradeMsg));
        }
        return Result.success(Map.of("upgradeMsg", ""));
    }
}
