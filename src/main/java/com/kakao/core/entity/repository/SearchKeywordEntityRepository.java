package com.kakao.core.entity.repository;

import com.kakao.core.entity.SearchKeywordEntity;
import com.kakao.web.dto.response.SearchRankingWordResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchKeywordEntityRepository extends JpaRepository<SearchKeywordEntity, Long> {

    @Query(value = "" +
            "SELECT a.keyword, COUNT(a.keyword) AS count " +
            "FROM sc_keyword a " +
            "WHERE a.reg_time > :ago " +
            "GROUP BY a.keyword " +
            "ORDER BY COUNT(a.keyword) DESC " +
            "LIMIT :limit"
            , nativeQuery = true)
    List<SearchRankingWordResponseDto.RankingWordResultDto> selectRankingWordTop(@Param("limit") long limit, @Param("ago") LocalDateTime ago);

}
