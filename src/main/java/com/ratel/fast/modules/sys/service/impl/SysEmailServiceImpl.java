package com.ratel.fast.modules.sys.service.impl;


import com.ratel.fast.modules.sys.entity.SysConfigEntity;
import com.ratel.fast.modules.sys.entity.SysEmailEntity;
import com.ratel.fast.modules.sys.service.SysConfigService;
import com.ratel.fast.modules.sys.service.SysEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("SysEmailService")
public class SysEmailServiceImpl implements SysEmailService {

    static final Logger log = LoggerFactory.getLogger(SysEmailServiceImpl.class);

    @Autowired
    private SysConfigService sysConfigService;


    /**
     * @param sysEmailEntity 发送邮件的实体
     * @param operation  用于日志记录当前发送邮件的是什么操作
     */
    @Override
    public void sendEmail(SysEmailEntity sysEmailEntity, String operation) {
        Map<String, String> params = sysEmailEntity.getParams();
        // 替换邮件模板中的一些字段
        if(params!=null){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String messageString = sysEmailEntity.getMessage();
                sysEmailEntity.setMessage(messageString.replaceAll(key, params.get(key)));
            }
        }
        this.send(sysEmailEntity, operation);
    }


    /**
     * 发送邮件
     *
     * @throws Exception
     */
    public void send(SysEmailEntity sysEmailEntity, String operation) {

        log.info("开始发送邮件");
        //动态从数据库中获取发送邮件的基本配置信息，便于线上的项目进行动态切换配置信息，而不用重启项目
        SysConfigEntity host = sysConfigService.getByKey("mail.smtp.host");
        SysConfigEntity port = sysConfigService.getByKey("mail.smtp.port");
        SysConfigEntity user = sysConfigService.getByKey("mail.smtp.user");
        SysConfigEntity pass = sysConfigService.getByKey("mail.smtp.pass");
        SysConfigEntity sslEnable = sysConfigService.getByKey("mail.smtp.ssl.enable");
        new Thread() {
            public void run() {
                try {
                    Properties props = new Properties();
                    props.put("mail.smtp.host", host.getParamValue());
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", Integer.valueOf(port.getParamValue()));
                    props.put("mail.smtp.ssl.enable", sslEnable.getParamValue());
                    Session session = Session.getDefaultInstance(props);
                    System.setProperty("mail.mime.charset", "UTF-8");
                    //获取邮件的消息内容实体
                    Message msg = getMimeMessage(session, sysEmailEntity.getToEmail(), sysEmailEntity.getHead(), sysEmailEntity.getMessage(), sysEmailEntity.getFiles(), sysEmailEntity.getImg());
                    Transport transport = session.getTransport("smtp");
                    transport.connect(host.getParamValue(), user.getParamValue(), pass.getParamValue());
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    log.info("操作：" + operation + "," + sysEmailEntity.getFromUsername() + " 发送邮件成功,发送给: " + sysEmailEntity.getToUsername() + ",邮箱地址: " + sysEmailEntity.getToEmail());
                } catch (Exception e) {
                    log.error("操作：" + operation + "," + sysEmailEntity.getFromUsername() + "==>发送邮件失败,发送给: " + sysEmailEntity.getToUsername() + ",邮箱地址: " + sysEmailEntity.getToEmail() + "，错误日志：", e);
                }
            }
        }.start();
    }


    /**
     * 获得创建一封邮件的实例对象
     *
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public MimeMessage getMimeMessage(Session session, String to, String subject, String message, String files, String img) throws Exception {
        SysConfigEntity user = sysConfigService.getByKey("mail.smtp.user");
        //多个文件,分割
//        SysConfigEntity files = sysConfigService.getByKey("mail.smtp.files");
        //1.创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //2.设置发件人地址
        msg.setFrom(new InternetAddress(user.getParamValue()));
        /**
         * 3.设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
        msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        //4.设置邮件主题
        msg.setSubject(subject, "UTF-8");

        //下面是设置邮件正文
        //msg.setContent("简单的纯文本邮件！", "text/html;charset=UTF-8");

        // 5. 创建图片"节点"
        MimeBodyPart image = new MimeBodyPart();
        if (img!=null && !img.isEmpty()) {
            // 读取本地文件
            DataHandler dh = new DataHandler(new FileDataSource(img));
            // 将图片数据添加到"节点"
            image.setDataHandler(dh);
            // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
            image.setContentID("mailTestPic");
        }

        // 6. 创建文本"节点"
        MimeBodyPart text = new MimeBodyPart();
        // 这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
        //text.setContent(message, "text/html;charset=UTF-8");
        //如果图片拼接到邮件正文以后，则图片不会在附件中出现
        message=message+"<img src='cid:mailTestPic'/>";
        text.setContent(message, "text/html;charset=UTF-8");

        // 7. （文本+图片）设置 文本 和 图片"节点"的关系（将 文本 和 图片"节点"合成一个混合"节点"）
        MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        if (img!=null  && !img.isEmpty()) {
            mm_text_image.addBodyPart(image);
        }
        // 关联关系
        mm_text_image.setSubType("related");

        // 8. 将 文本+图片 的混合"节点"封装成一个普通"节点"
        // 最终添加到邮件的 Content 是由多个 BodyPart 组成的 Multipart, 所以我们需要的是 BodyPart,
        // 上面的 mailTestPic 并非 BodyPart, 所有要把 mm_text_image 封装成一个 BodyPart
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mm_text_image);

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合"节点" / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        // 混合关系
        mm.setSubType("mixed");

        if (files!=null  && !files.isEmpty()) {
            String[] fileList = files.split(",");
            for (String file : fileList) {
                // 9. 创建附件"节点"
                MimeBodyPart attachment = new MimeBodyPart();
                // 读取本地文件files
                DataHandler dh2 = new DataHandler(new FileDataSource(file));
                // 将附件数据添加到"节点"
                attachment.setDataHandler(dh2);
                // 设置附件的文件名（需要编码）
                attachment.setFileName(MimeUtility.encodeText(dh2.getName()));
                // 如果有多个附件，可以创建多个多次添加
                mm.addBodyPart(attachment);
            }
        }

        // 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
        msg.setContent(mm);
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());

        return msg;
    }
}
