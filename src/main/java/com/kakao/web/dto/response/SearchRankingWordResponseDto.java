package com.kakao.web.dto.response;

public class SearchRankingWordResponseDto {

    public interface RankingWordResultDto {
        String getKeyword();
        long getCount();
    }
}
