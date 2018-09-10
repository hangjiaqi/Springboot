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

    //@Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 30 16 ? * MON-FRI")
    public void remindCZ(){
        TZemail("订餐提醒","今日订餐将于17点关闭->http://47.96.97.244:9890/");
    }

    private void TZemail(String message,String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送者
        mailMessage.setFrom("info@cz-tek.com");
        //接收者
        //mailMessage.setTo("jiaqi.hang@cz-tek.com");
        mailMessage.setTo("rui.bai@cz-tek.com","can.cheng@cz-tek.com","chaoying.deng@cz-tek.com","yong.du@cz-tek.com","hong.gao@cz-tek.com","jiahong.guo@cz-tek.com","peixuan.gong@cz-tek.com","jiaqi.hang@cz-tek.com","haoli.li@cz-tek.com","zhongwen.lv@cz-tek.com","jing.mao@cz-tek.com","chuankui.ning@cz-tek.com","ruijie.ruan@cz-tek.com","fuzhen.song@cz-tek.com","song.wang@cz-tek.com","zimei.wu@cz-tek.com","siyuan.yang@cz-tek.com","xiaowei.wu@cz-tek.com","gumin.zhou@cz-tek.com","jie.zhao@cz-tek.com","zeyuan.zhang@cz-tek.com");
        //发送标题
        mailMessage.setSubject(message);
        mailMessage.setText(text);
        jms.send(mailMessage);
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
