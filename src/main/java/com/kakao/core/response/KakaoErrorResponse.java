package com.kakao.core.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KakaoErrorResponse<T> {
    T data;
}
