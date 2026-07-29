package com.lifegame.controller;

import com.lifegame.common.Result;
import com.lifegame.dto.RecordAddDTO;
import com.lifegame.entity.FocusRecord;
import com.lifegame.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 修炼记录模块
 */
@RestController
@RequestMapping("/api")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    /** 4.1 获取本周所有修炼记录 */
    @GetMapping("/record/list")
    public Result<List<FocusRecord>> list() {
        return Result.success(recordService.list());
    }

    /** 4.2 手动录入记录 —— 同步增加技能 EXP */
    @PostMapping("/record/add")
    public Result<FocusRecord> add(@RequestBody RecordAddDTO dto) {
        FocusRecord record = new FocusRecord();
        record.setDateStr(dto.getDate());
        record.setDuration(dto.getDuration());
        record.setSkillId(dto.getSkillId());
        return Result.success(recordService.add(record));
    }

    /** 4.4 删除记录 */
    @DeleteMapping("/record/delete/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        recordService.delete(id);
        return Result.success();
    }
}
