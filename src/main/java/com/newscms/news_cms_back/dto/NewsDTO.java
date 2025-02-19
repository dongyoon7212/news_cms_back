package com.newscms.news_cms_back.dto;

import lombok.Data;

@Data
public class NewsDTO {
    private String ctgry;
    private String title;
    private String orgnLnk;
    private String lnk;
    private String dscptn;
    private String pubDt;
}
