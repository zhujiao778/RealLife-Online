package com.lifegame.controller;

import com.lifegame.common.Result;
import com.lifegame.dto.SkillAddDTO;
import com.lifegame.dto.SkillUpdateDTO;
import com.lifegame.entity.UserSkill;
import com.lifegame.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 技能树模块
 */
@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    /** 2.1 获取技能列表 */
    @GetMapping("/list")
    public Result<List<UserSkill>> list() {
        return Result.success(skillService.list());
    }

    /** 2.2 新增技能 */
    @PostMapping("/add")
    public Result<UserSkill> add(@RequestBody SkillAddDTO dto) {
        UserSkill skill = new UserSkill();
        skill.setName(dto.getName());
        skill.setQuality(dto.getQuality());
        skill.setLevel(dto.getLevel() != null ? dto.getLevel() : 1);
        return Result.success(skillService.add(skill));
    }

    /** 2.3 修改技能 */
    @PutMapping("/update")
    public Result<UserSkill> update(@RequestBody SkillUpdateDTO dto) {
        UserSkill skill = new UserSkill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setQuality(dto.getQuality());
        skill.setLevel(dto.getLevel());
        return Result.success(skillService.update(skill));
    }

    /** 2.4 遗忘(删除)技能 */
    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        skillService.delete(id);
        return Result.success();
    }
}
