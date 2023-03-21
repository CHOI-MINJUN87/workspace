package com.kakao.core.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@Entity
@Table(name = "sc_keyword", indexes = @Index(name="idx__reg__time1", columnList = "reg_time"))
@EntityListeners({AuditingEntityListener.class})
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeywordEntity implements Persistable<Long> {
    @Id
    @GeneratedValue(generator = "no", strategy = GenerationType.AUTO)
    private Long no;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "reg_time")
    private LocalDateTime regTime;

    @Column(name = "reg_ts")
    @CreatedDate
    private LocalDateTime regTs;

    @Column(name = "reg_id")
    @CreatedBy
    private String regId;

    @Column(name = "md_ts")
    @LastModifiedDate
    private LocalDateTime modTs;

    @Column(name = "md_id")
    @LastModifiedBy
    private String modId;

    @Override
    public Long getId() {
        return no;
    }

    @Override
    public boolean isNew() {
        return regTs == null;
    }
}
