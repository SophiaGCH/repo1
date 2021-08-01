package com.gch.thread;

/**
 * @author: Sophia
 * @description: 包子实体类
 * @date: Create in 2021/7/31 9:09
 */
public class Bun {

    private String skin; // 包子皮
    private String filling; // 包子馅
    private boolean flag = false;

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
