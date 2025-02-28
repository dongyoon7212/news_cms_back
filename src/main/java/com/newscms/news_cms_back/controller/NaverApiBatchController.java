package com.newscms.news_cms_back.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.newscms.news_cms_back.dto.NewsDTO;
import com.newscms.news_cms_back.entity.News;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class NaverApiBatchController {

    @Value("${naver.api.client-id}")
    private String clientId;

    @Value("${naver.api.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate = new RestTemplate();
    private final List<String> categories = Arrays.asList("속보", "정치", "경제", "IT", "스포츠", "연예");


    @Scheduled(cron = "0/5 * * * * ?")
    public void naverNewsApi() {
        for (String category : categories) {
            String url = buildUrl(category);
            String result = getNewsFromApi(url);

            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject)parser.parse(result.toString());
//            System.out.println(obj.get("items"));
            Gson gson = new Gson();
            List<NewsDTO> newsDTOList = gson.fromJson(obj.get("items"), new TypeToken<List<NewsDTO>>(){}.getType());
            System.out.println(newsDTOList);



            // 카테고리별 뉴스 결과 출력
//            System.out.println("=== [" + category + " 뉴스] ===");
//            System.out.println(result);
//            System.out.println("=============================");
        }
    }

    private String buildUrl(String query) {
        // 쿼리 파라미터를 URL에 추가
        return "https://openapi.naver.com/v1/search/news.json?query=" + query;
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
