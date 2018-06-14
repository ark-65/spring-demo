package com.ark.demo.service.impl;


import com.ark.demo.service.ISendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 18/6/6
 * Time: 下午3:19
 **/
@Service
public class SendMailServiceImpl implements ISendMailService {

    @Autowired
    private JavaMailSender mailSender;


    /**
     * 普通邮箱
     */
    @Override
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("805363013@qq.com");
        message.setTo("345549325@qq.com");
        message.setSubject("主题：我的springboot学习代码发送邮件测试");
        message.setText("测试邮件");

        mailSender.send(message);

    }

    /**
     * 附件邮箱
     */
    @Override
    public void sendSimpleMailFuJian() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");

        helper.setFrom("805363013@qq.com");
        helper.setTo("wufangzhou.liu@pactera.com");
        helper.setSubject("主题：有附件的测试");
        helper.setText("有附件");

        FileSystemResource file = new FileSystemResource(new File("/Users/puo/Desktop/服务器地址.md"));
        String name = new String("附件.md");
        helper.addAttachment(name, file);
        helper.addAttachment("服务器地址.md", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 静态邮箱
     */
    @Override
    public void sendInlineMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        helper.setFrom("805363013@qq.com");
        helper.setTo("345549325@qq.com");
        helper.setSubject("主题：蓝胖子");
        helper.setText("<html><body><img src=\\\"cid:weixin\\\" ></body></html>");

        FileSystemResource file = new FileSystemResource(new File("/Users/puo/Downloads/test.jpg"));
        helper.addInline("weixin", file);

        mailSender.send(mimeMessage);
    }
}