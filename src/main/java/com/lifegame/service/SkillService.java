package com.lifegame.service;

import com.lifegame.entity.UserSkill;
import java.util.List;

/**
 * 技能树服务接口
 */
public interface SkillService {

    /** 获取全部技能列表 */
    List<UserSkill> list();

    /** 新增技能 */
    UserSkill add(UserSkill skill);

    /** 修改技能 */
    UserSkill update(UserSkill skill);

    /** 删除技能 */
    void delete(Integer id);
}
