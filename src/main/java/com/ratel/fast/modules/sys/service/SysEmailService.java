package com.ratel.fast.modules.sys.service;


import com.ratel.fast.modules.sys.entity.SysEmailEntity;

public interface SysEmailService {
    /**
     * @param sysEmailEntity 发送邮件的实体
     * @param operation  用于日志记录当前发送邮件的是什么操作
     */
    void sendEmail(SysEmailEntity sysEmailEntity, String operation);
}
