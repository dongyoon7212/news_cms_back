package com.newscms.news_cms_back.service;

import com.newscms.news_cms_back.dto.NewsDTO;
import com.newscms.news_cms_back.repository.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public void addNews(List<NewsDTO> newsDTOList, String category) {
        for (int i = 0; i < newsDTOList.size(); i++) {
            newsMapper.addNews(newsDTOList.get(i).toEntity(category));
        }
    }
}
