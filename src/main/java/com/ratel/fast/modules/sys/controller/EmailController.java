package com.ratel.fast.modules.sys.controller;

import com.ratel.fast.common.utils.EmailTemplate;
import com.ratel.fast.common.utils.R;
import com.ratel.fast.modules.sys.dao.SysMessageDao;
import com.ratel.fast.modules.sys.entity.SysEmailEntity;
import com.ratel.fast.modules.sys.entity.SysMessageEntity;
import com.ratel.fast.modules.sys.entity.SysUserEntity;
import com.ratel.fast.modules.sys.service.SysEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @业务描述：
 * @package_name： com.ratel.fast.modules.sys.controller
 * @project_name： ratel-fast
 * @author： ratelfu@qq.com
 * @create_time： 2020-01-02 16:21
 * @copyright (c) ratelfu 版权所有
 */
@RestController
@RequestMapping("/sys/email")
public class EmailController extends AbstractController {
    @Autowired
    private SysEmailService sysEmailService;
    @Autowired
    private SysMessageDao  sysMessageDao;

    @RequestMapping("sendText")
    public R sendText(){
        SysUserEntity sysUserEntity = super.getUser();
        //1.获取数据库配置的邮件模板
        SysMessageEntity sysMessageEntity = sysMessageDao.selectByKey(EmailTemplate.PLAIN_TEXT_EMAIL);
        //2.用于存放模板里需要替换的字段
        Map<String, String> map = new HashMap<>();
        map.put("username", sysUserEntity.getUsername());
        map.put("param1","我是参数1");
        map.put("param2","我是参数2");
        // 邮件授权码 kpzjwlmdmjisbdah
        SysEmailEntity emailEntity = new SysEmailEntity("ratelfu@163.com", sysMessageEntity.getTitle(), sysMessageEntity.getContent(), null, null, "系统提醒", sysUserEntity.getUsername(), map);
        //3.调用邮件发送服务
        sysEmailService.sendEmail(emailEntity,"发送纯文本邮件");
        return R.ok();
    }
    @RequestMapping("sendImag")
    public R sendImag(){
        SysUserEntity sysUserEntity = super.getUser();
        //1.获取数据库配置的邮件模板
        SysMessageEntity sysMessageEntity = sysMessageDao.selectByKey(EmailTemplate.IMG_EMAIL);
        //2.用于存放模板里需要替换的字段
        Map<String, String> map = new HashMap<>();
        map.put("username", sysUserEntity.getUsername());
        map.put("param1","我是参数1");
        map.put("param2","我是参数2");
        // 邮件授权码 kpzjwlmdmjisbdah
        SysEmailEntity emailEntity = new SysEmailEntity("ratelfu@163.com", sysMessageEntity.getTitle(), sysMessageEntity.getContent(), null, sysMessageEntity.getImg(), "系统提醒", sysUserEntity.getUsername(), map);
        //3.调用邮件发送服务
        sysEmailService.sendEmail(emailEntity,"发送纯文本邮件");
        return R.ok();
    }
    @RequestMapping("sendAttr")
    public R sendAttr(){
        SysUserEntity sysUserEntity = super.getUser();
        //1.获取数据库配置的邮件模板
        SysMessageEntity sysMessageEntity = sysMessageDao.selectByKey(EmailTemplate.ATTACHMENT_EMAIL);
        //2.用于存放模板里需要替换的字段
        Map<String, String> map = new HashMap<>();
        map.put("username", sysUserEntity.getUsername());
        map.put("param1","我是参数1");
        map.put("param2","我是参数2");
        // 邮件授权码 kpzjwlmdmjisbdah
        SysEmailEntity emailEntity = new SysEmailEntity("ratelfu@163.com", sysMessageEntity.getTitle(), sysMessageEntity.getContent(), sysMessageEntity.getFiles(), null, "系统提醒", sysUserEntity.getUsername(), map);
        //3.调用邮件发送服务
        sysEmailService.sendEmail(emailEntity,"发送纯文本邮件");
        return R.ok();
    }

    @RequestMapping("sendMix")
    public R sendMix(){
        SysUserEntity sysUserEntity = super.getUser();
        //1.获取数据库配置的邮件模板
        SysMessageEntity sysMessageEntity = sysMessageDao.selectByKey(EmailTemplate.MIX_EMAIL);
        //2.用于存放模板里需要替换的字段
        Map<String, String> map = new HashMap<>();
        map.put("username", sysUserEntity.getUsername());
        map.put("param1","我是参数1");
        map.put("param2","我是参数2");
        // 邮件授权码 kpzjwlmdmjisbdah
        SysEmailEntity emailEntity = new SysEmailEntity("ratelfu@163.com", sysMessageEntity.getTitle(), sysMessageEntity.getContent(), sysMessageEntity.getFiles(), sysMessageEntity.getImg(), "系统提醒", sysUserEntity.getUsername(), map);
        //3.调用邮件发送服务
        sysEmailService.sendEmail(emailEntity,"发送纯文本邮件");
        return R.ok();
    }

}
