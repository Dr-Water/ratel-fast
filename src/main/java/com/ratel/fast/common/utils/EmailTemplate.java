package com.ratel.fast.common.utils;

/**
  *@业务描述： 消息模板常量类，避免魔法数字和提高代码可读性
  *@author： fuyongnan
  *@create_time： 2020/1/2 15:56
  */
public interface EmailTemplate {
    /**
     * 重置密码
     */
    String CHANGE_PASSWORD = "CHANGE_PASSWORD";
    /**
     *发送纯文本测试常量
     */
    String PLAIN_TEXT_EMAIL = "PLAIN_TEXT_EMAIL";
    /**
     * 带附件的邮箱
     */
    String ATTACHMENT_EMAIL= "ATTACHMENT_EMAIL";

    /**
     * 带图片的email
     */
    String IMG_EMAIL="IMG_EMAIL";

    /**
     * 带附件和文件的email
     */
    String MIX_EMAIL="MIX_EMAIL";


}
