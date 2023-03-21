package com.kakao.web.service;

import com.kakao.core.entity.SearchKeywordEntity;
import com.kakao.core.entity.repository.SearchKeywordEntityRepository;
import com.kakao.web.dto.request.SearchRankingWordRequestDto;
import com.kakao.web.dto.response.SearchRankingWordResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchRankingWordServiceImpl implements SearchRankingWordService {

    private final SearchKeywordEntityRepository searchKeywordEntityRepository;

    public SearchRankingWordServiceImpl(SearchKeywordEntityRepository searchKeywordEntityRepository) {
        this.searchKeywordEntityRepository = searchKeywordEntityRepository;
    }

    @Override
    @Transactional
    public void insertKeyword(String query) {
        searchKeywordEntityRepository.save(SearchKeywordEntity.builder()
                .keyword(query)
                .regTime(LocalDateTime.now())
                .build());
    }

    @Override
    public List<SearchRankingWordResponseDto.RankingWordResultDto> selectRankingWord(SearchRankingWordRequestDto.RankingWordDto rankingWordDto) {
        return searchKeywordEntityRepository.selectRankingWordTop(rankingWordDto.getLimit(), rankingWordDto.getAgo());
    }
}
