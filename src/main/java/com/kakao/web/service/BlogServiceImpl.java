package com.kakao.web.service;

import com.kakao.web.dto.request.BlogRequestDto;
import com.kakao.web.dto.response.BlogResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;


@Slf4j
@Service
public class BlogServiceImpl implements BlogService {
    private final WebClient kakaoWebClient;
    public BlogServiceImpl(WebClient kakaoWebClient) {
        this.kakaoWebClient = kakaoWebClient;
    }

    @Override
    public BlogResponseDto.SearchResultDto requestKakao(BlogRequestDto.SearchDto searchDto) {

        return kakaoWebClient.get()
                .uri("/v2/search/web?" + searchDto.makeUrl())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BlogResponseDto.SearchResultDto>() {
                })
                .timeout(Duration.ofSeconds(5))
                .block();
    }
}
