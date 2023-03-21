package com.kakao.web.service;

import com.kakao.web.dto.request.BlogRequestDto;
import com.kakao.web.dto.response.BlogResponseDto;

public interface BlogService {

    BlogResponseDto.SearchResultDto requestKakao(BlogRequestDto.SearchDto searchDto);
}
