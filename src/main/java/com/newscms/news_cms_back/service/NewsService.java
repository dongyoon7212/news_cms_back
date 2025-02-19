package com.newscms.news_cms_back.service;

import com.newscms.news_cms_back.repository.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public int addNews() {
        return  newsMapper.addNews();
    }
}
