package com.kakao.core.response;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KakaoResponse<T> {

    T data;
}
