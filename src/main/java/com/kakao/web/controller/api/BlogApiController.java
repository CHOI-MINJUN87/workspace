package com.kakao.web.controller.api;

import com.kakao.core.response.KakaoResponse;
import com.kakao.web.service.BlogService;
import com.kakao.web.service.SearchRankingWordService;
import com.kakao.web.dto.request.BlogRequestDto;
import com.kakao.web.dto.response.BlogResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BlogApiController {

    private final BlogService blogService;

    private final SearchRankingWordService searchRankingWordService;

    public BlogApiController(BlogService blogService, SearchRankingWordService searchRankingWordService) {
        this.blogService = blogService;
        this.searchRankingWordService = searchRankingWordService;
    }

    @GetMapping("/v1/search/web")
    public KakaoResponse<BlogResponseDto.SearchResultDto> searchBlog(BlogRequestDto.SearchDto searchDto) {

        try {
            searchRankingWordService.insertKeyword(searchDto.getQuery());
        } catch (Exception e) {
            log.info("BlogApiController.searchBlog keyword insert error : {}", e.getMessage());
        }

        return KakaoResponse.<BlogResponseDto.SearchResultDto>builder()
                .data(blogService.requestKakao(searchDto))
                .build();
    }
}
