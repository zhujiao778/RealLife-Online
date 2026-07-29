package com.lifegame.dto;

/**
 * 番茄钟完成返回体
 */
public class PomodoroCompleteVO {

    /** 升级提示, 如: "恭喜升级到Lv.25" */
    private String upgradeMsg;

    public PomodoroCompleteVO() {}

    public PomodoroCompleteVO(String upgradeMsg) {
        this.upgradeMsg = upgradeMsg;
    }

    public String getUpgradeMsg() { return upgradeMsg; }
    public void setUpgradeMsg(String upgradeMsg) { this.upgradeMsg = upgradeMsg; }
}
