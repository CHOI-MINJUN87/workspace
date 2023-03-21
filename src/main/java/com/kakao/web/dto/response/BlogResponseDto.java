package com.kakao.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class BlogResponseDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchResultDto {
        private BlogMeta meta;
        private List<BlogDocument> documents;
    }

    @Getter
    @Setter
    public static class BlogMeta {

        @JsonProperty("total_count")
        private Integer totlaCount;

        @JsonProperty("pageable_count")
        private Integer pageableCount;
        @JsonProperty("is_end")
        private Boolean isEnd;
    }

    @Getter
    @Setter
    public static class BlogDocument {
        private ZonedDateTime datetime;
        private String contents;
        private String title;
        private String url;

        public ZonedDateTime getDatetime() {
            return datetime.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
        }
    }

}
