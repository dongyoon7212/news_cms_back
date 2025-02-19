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
    private int id;                     //뉴스 고유번호
    private String ctgry;               //뉴스 카테고리
    private String title;               //뉴스 제목
    private String orgnlnk;             //뉴스 원문 링크
    private String lnk;                 //뉴스 네이버 링크
    private String descpt;              //뉴스 간략 내용
    private String pubDt;               //뉴스 네이버 등록일시
    private LocalDateTime regDt;        //등록일시
    private LocalDateTime updDt;        //수정일시
    private String sttsCd;              //상태코드
}
