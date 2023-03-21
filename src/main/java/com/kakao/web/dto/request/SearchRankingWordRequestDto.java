package com.kakao.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class SearchRankingWordRequestDto {

    @Getter
    @Setter
    public static class RankingWordDto {

        private long limit = 10;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime ago = LocalDateTime.now().minusHours(1);
    }
}
