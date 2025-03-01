package com.newscms.news_cms_back.dto;

import com.newscms.news_cms_back.entity.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private String title;
    private String originallink;
    private String link;
    private String description;
    private String pubDate;

    public News toEntity(String category) {
        return News.builder()
                .ctgry(category)
                .title(this.title)
                .orgnLnk(this.originallink)
                .lnk(this.link)
                .dscptn(this.description)
                .pubDt(this.pubDate)
                .regDt(LocalDateTime.now())
                .updDt(LocalDateTime.now())
                .sttsCd("1")
                .build();
    }
}
