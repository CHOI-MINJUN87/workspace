package com.kakao.core.paging;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPaging {

    private Integer page;

    private Integer size;

    @ApiParam(hidden = true)
    private final int maxSize = 50;

    public Integer getSize() {
        if (size == null) {
            return null;
        } else {
            return size > maxSize ? maxSize : size;
        }
    }
}
