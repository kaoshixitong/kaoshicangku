package com.yitihua3.exam.service.user;

public interface MailService {
    //发送邮件
    void sendMimeMail(String to,String subject,String content);

    void sendInlineResourceMail(String to,String subject,String content,String rscPath,String rscId);
}
