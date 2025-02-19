package com.newscms.news_cms_back.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {
    public int addNews();
}
