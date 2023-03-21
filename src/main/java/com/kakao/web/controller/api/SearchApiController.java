package com.kakao.web.controller.api;


import com.kakao.core.response.KakaoResponse;
import com.kakao.web.service.SearchRankingWordService;
import com.kakao.web.dto.request.SearchRankingWordRequestDto;
import com.kakao.web.dto.response.SearchRankingWordResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SearchApiController {

    private final SearchRankingWordService searchRankingWordService;

    public SearchApiController(SearchRankingWordService searchRankingWordService) {
        this.searchRankingWordService = searchRankingWordService;
    }

    @GetMapping("/v1/search/word/ranking")
    public KakaoResponse<List<SearchRankingWordResponseDto.RankingWordResultDto>> searchRankingWord(SearchRankingWordRequestDto.RankingWordDto rankingWordDto) {
        return KakaoResponse.<List<SearchRankingWordResponseDto.RankingWordResultDto>>
                builder()
                .data(searchRankingWordService.selectRankingWord(rankingWordDto))
                .build();
    }
}
