package com.newscms.news_cms_back.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.newscms.news_cms_back.dto.NewsDTO;
import com.newscms.news_cms_back.entity.News;
import com.newscms.news_cms_back.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/naver")
public class NaverApiController {

    @Value("${naver.api.client-id}")
    private String clientId;

    @Value("${naver.api.client-secret}")
    private String clientSecret;

    @Autowired
    private NewsService newsService;

    private final RestTemplate restTemplate = new RestTemplate();
    private final List<String> categories = Arrays.asList("주식");

    @GetMapping("/list")
    public List<News> getNaverNewsList(@RequestParam String display, @RequestParam String start) {
        List<News> newsList = new ArrayList<>();

        for (String category : categories) {
            String url = buildUrl(category, display, start);
            String result = getNewsFromApi(url);

            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject)parser.parse(result.toString());
            Gson gson = new Gson();
            List<NewsDTO> newsDTOList = gson.fromJson(obj.get("items"), new TypeToken<List<NewsDTO>>(){}.getType());
            for (NewsDTO newsDto : newsDTOList) {
                newsList.add(newsDto.toEntity(category));
            }

        }

        return newsList;
    }



    private String buildUrl(String query, String display, String start) {
        // 쿼리 파라미터를 URL에 추가
        return "https://openapi.naver.com/v1/search/news.json?sort=date&query=" + query + "&display=" + display + "&start=" + start;
    }

    private String getNewsFromApi(String url) {
        // 헤더에 클라이언트 ID와 클라이언트 Secret 추가
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(createHeaders()),
                String.class
        ).getBody();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        return headers;
    }

}
