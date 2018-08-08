package com.cztek.springboot.job;

import com.cztek.springboot.service.IUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author:杭佳琦
 * @Desciption: Date:Created in 10:59 2018/7/27
 * @Modified by:
 */
@Component
public class Jobs{
    @Autowired
    private JavaMailSender jms;

    @Autowired
    private IUserBookService userBookService;

    //@Scheduled(cron = "*/30 * * * * ?")
    @Scheduled(cron = "0 0 17 ? * MON-FRI")
    public void scheduledMethod(){
        int number=userBookService.findIntradayOrder();
        if(number>0){
            email(number,"彩卓订餐网站","今天已"+number+"有人订餐"+"请在订餐网站确认http://47.96.97.244:9890/");
        }else{
            email(number,"彩卓订餐网站","今天无人订餐");
        }
    }


    private void email(int number,String message,String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送者
        mailMessage.setFrom("info@cz-tek.com");
        //接收者
        mailMessage.setTo("yanhong.liu@cz-tek.com","yanping.lang@cz-tek.com","zimei.wu@cz-tek.com");
        //发送标题
        mailMessage.setSubject(message);
        mailMessage.setText(text);
        jms.send(mailMessage);
    }
}
