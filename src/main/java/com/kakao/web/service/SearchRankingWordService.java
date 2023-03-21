package com.kakao.web.service;

import com.kakao.web.dto.request.SearchRankingWordRequestDto;
import com.kakao.web.dto.response.SearchRankingWordResponseDto;

import java.util.List;

public interface SearchRankingWordService {
    void insertKeyword(String query);

    List<SearchRankingWordResponseDto.RankingWordResultDto> selectRankingWord(SearchRankingWordRequestDto.RankingWordDto searchRankingWordRequestDto);
}
