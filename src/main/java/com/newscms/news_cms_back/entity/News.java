package com.newscms.news_cms_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class News {
    private Long newsId;  // Primary Key (AUTO_INCREMENT)
    private String title;
    private String orgnLnk;
    private String lnk;
    private String dscptn;
    private String pubDt;
    private String ctgry;  // "속보"로 저장
    private LocalDateTime regDt;  // 현재 시간
    private LocalDateTime updDt;  // 현재 시간
    private String sttsCd;  // "1"로 저장
}
