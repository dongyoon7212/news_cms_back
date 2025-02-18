package com.newscms.news_cms_back.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class NaverApiBatchController {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
        System.out.println("test");
    }

}
