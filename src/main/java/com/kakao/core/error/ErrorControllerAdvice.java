package com.kakao.core.error;

import com.kakao.core.response.KakaoErrorResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public KakaoErrorResponse<ErrorResponseDto> handleAllExceptions(Exception ex) {
        String errType;

        if (ex != null && ex.toString().length() > 0) {
            errType = StringUtils.split(ex.toString(), ":")[0];
        } else {
            errType = "error";
        }

        return KakaoErrorResponse.<ErrorResponseDto>
                builder()
                .data(ErrorResponseDto
                        .builder()
                        .errorType(errType)
                        .message(errType)
                        .build())
                .build();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ErrorResponseDto {
        private String errorType;
        private String message;
    }
}
