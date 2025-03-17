package com.newscms.news_cms_back.controller;

import com.newscms.news_cms_back.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/recent")
    public ResponseEntity<?> getRecentNews() {
        return ResponseEntity.ok().body(newsService.getRecentNews());
    }
}
