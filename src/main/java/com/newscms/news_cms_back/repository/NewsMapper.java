package com.newscms.news_cms_back.repository;

import com.newscms.news_cms_back.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NewsMapper {
    int addNews(News news);
}
