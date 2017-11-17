package com.wl.blog.entity;

/**
 * @Author: wl
 * @Description:标签
 * @Date:Create in 2017/11/8-15:06
 */
public class Label {

    private int labelId;

    private String labelName;

    private int labelStatus;

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public int getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(int labelStatus) {
        this.labelStatus = labelStatus;
    }
}
