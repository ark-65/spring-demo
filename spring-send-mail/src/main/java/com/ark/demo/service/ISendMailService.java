package com.ark.demo.service;

import javax.mail.MessagingException;

public interface ISendMailService {

    public void sendSimpleMail() throws Exception;

    public void sendSimpleMailFuJian() throws MessagingException;

    public void sendInlineMail() throws MessagingException;

}