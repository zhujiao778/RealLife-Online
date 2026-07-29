package com.lifegame.service;

import com.lifegame.entity.FocusRecord;
import java.util.List;

/**
 * 修炼记录服务接口
 */
public interface RecordService {

    /** 获取所有修炼记录 */
    List<FocusRecord> list();

    /**
     * 新增修炼记录, 同时给关联技能增加 EXP (1分钟=10EXP), 并判断技能是否升级
     */
    FocusRecord add(FocusRecord record);

    /** 删除记录 */
    void delete(Integer id);
}
