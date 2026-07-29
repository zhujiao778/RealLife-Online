package com.lifegame.service.impl;

import com.lifegame.entity.UserSkill;
import com.lifegame.mapper.UserSkillMapper;
import com.lifegame.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final UserSkillMapper userSkillMapper;

    public SkillServiceImpl(UserSkillMapper userSkillMapper) {
        this.userSkillMapper = userSkillMapper;
    }

    @Override
    public List<UserSkill> list() {
        return userSkillMapper.selectList(null);
    }

    @Override
    public UserSkill add(UserSkill skill) {
        userSkillMapper.insert(skill);
        return skill;
    }

    @Override
    public UserSkill update(UserSkill skill) {
        userSkillMapper.updateById(skill);
        return userSkillMapper.selectById(skill.getId());
    }

    @Override
    public void delete(Integer id) {
        userSkillMapper.deleteById(id);
    }
}
