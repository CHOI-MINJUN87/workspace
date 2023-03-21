package com.kakao.core.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Value("${kakao.rest-api-key}")
    private String KAKAO_RES_API_KEY;
    private final String KAKAO_API_BASE_URL = "https://dapi.kakao.com";

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
                .baseUrl(KAKAO_API_BASE_URL)
                .defaultHeader(HttpHeaders.AUTHORIZATION, KAKAO_RES_API_KEY).build();
    }
}
