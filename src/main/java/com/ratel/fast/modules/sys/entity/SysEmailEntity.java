package com.ratel.fast.modules.sys.entity;

import java.io.Serializable;
import java.util.Map;

public class SysEmailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 收件人email地址
     */
    private String toEmail;
    /**
     * 邮件头名
     */
    private String head;
    /**
     * 邮件内容
     */
    private String message;
    /**
     * 邮件附件，字符串存储文件地址路径，多个文件用逗号分割
     */
    private String files;
    /**
     * 邮件图片，暂时只支持一张图片，后期优化，字符串图片文件地址路径，注意message中图片排版
     */
    private String img;
    /**
     * 发送人姓名（log日志）
     */
    private String fromUsername;
    /**
     * 接收人姓名（log日志）
     */
    private String toUsername;
    /**
     * message中需要替换的参数，替换规则用value替换message中的key值
     */
    private Map<String,String> params;

    public SysEmailEntity(String toEmail, String head, String message, String files, String img, String fromUsername, String toUsername, Map<String, String> params) {
        this.toEmail = toEmail;
        this.head = head;
        this.message = message;
        this.files = files;
        this.img = img;
        this.fromUsername = fromUsername;
        this.toUsername = toUsername;
        this.params = params;
    }

    public SysEmailEntity(){

    }


    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
