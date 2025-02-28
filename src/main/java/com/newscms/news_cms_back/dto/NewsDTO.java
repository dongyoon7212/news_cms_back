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
    private String pubdate;

    public News toEntity() {
        return News.builder()
                .ctgry("속보")
                .title(this.title)
                .orgLnk(this.originallink)
                .link(this.link)
                .dscptn(this.description)
                .pubDt(this.pubdate)
                .regDt(LocalDateTime.now())
                .updDt(LocalDateTime.now())
                .sttsCd("1")
                .build();
    }
}
