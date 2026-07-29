package com.lifegame.service.impl;

import com.lifegame.entity.FocusRecord;
import com.lifegame.entity.UserSkill;
import com.lifegame.mapper.FocusRecordMapper;
import com.lifegame.mapper.UserSkillMapper;
import com.lifegame.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    /** 每分钟专注 = 10 技能经验 */
    private static final int EXP_PER_MINUTE = 10;

    private final FocusRecordMapper focusRecordMapper;
    private final UserSkillMapper userSkillMapper;

    public RecordServiceImpl(FocusRecordMapper focusRecordMapper,
                             UserSkillMapper userSkillMapper) {
        this.focusRecordMapper = focusRecordMapper;
        this.userSkillMapper = userSkillMapper;
    }

    @Override
    public List<FocusRecord> list() {
        return focusRecordMapper.selectList(null);
    }

    @Override
    @Transactional
    public FocusRecord add(FocusRecord record) {
        focusRecordMapper.insert(record);

        // 如果关联了技能, 给技能增加经验
        if (record.getSkillId() != null) {
            UserSkill skill = userSkillMapper.selectById(record.getSkillId());
            if (skill != null) {
                int gainedExp = record.getDuration() * EXP_PER_MINUTE;
                int newExp = skill.getExp() + gainedExp;

                // 判断技能是否升级
                while (newExp >= skill.getMaxExp()) {
                    newExp -= skill.getMaxExp();
                    skill.setLevel(skill.getLevel() + 1);
                    // 技能每升一级, 升级所需经验提高
                    skill.setMaxExp(skill.getMaxExp() + 500);
                }
                skill.setExp(newExp);
                userSkillMapper.updateById(skill);
            }
        }

        return record;
    }

    @Override
    public void delete(Integer id) {
        focusRecordMapper.deleteById(id);
    }
}
