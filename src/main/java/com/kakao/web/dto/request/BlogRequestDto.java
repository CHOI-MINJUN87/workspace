package com.kakao.web.dto.request;

import com.kakao.core.enums.PagingSort;
import com.kakao.core.paging.RequestPaging;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class BlogRequestDto {

    @Getter
    @Setter
    public static class SearchDto extends RequestPaging {

        @ApiParam(required = true)
        private String query;

        @Schema(description = "sort")
        private PagingSort sort;

        public String getQuery() {
            return query != null ? query.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", " ").replaceAll("\\s+", " ") : "";
        }

        public String makeUrl() {

            StringBuffer b = new StringBuffer();
            b.append("query="+ getQuery());

            if (super.getSize() != null) {
                b.append("&" + "size=" + super.getSize());
            }

            if (super.getPage() != null) {
                b.append("&" + "page=" + super.getPage());
            }

            if (sort != null) {
                b.append("&" + "sort=" + sort.c());
            }

            return b.toString();
        }
    }
}
