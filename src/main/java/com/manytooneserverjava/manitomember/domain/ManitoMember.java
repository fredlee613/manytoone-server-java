package com.manytooneserverjava.manitomember.domain;

import com.manytooneserverjava.common.persistence.BaseEntity;
import com.manytooneserverjava.manito.domain.Manito;
import com.manytooneserverjava.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString()
public class ManitoMember extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANITO_MEMBER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANITO_ID", nullable = false)
    private Manito manito;

    @Column(name = "MANITO_INVITE_TYPE", nullable = false)
    private Integer status;

    @Column(name = "MANITO_MEMBER_NICKNAME")
    private String nickname;

    @Column(name = "MANITO_WANTED_GIFT")
    private String wantedGift;

    @Column(name = "MANITO_UNWANTED_GIFT")
    private String unwantedGift;

    @Column(name = "MANITO_MEMBER_STATUS", nullable = false)
    private Boolean isLeader;

    public void updateManitoMember(Integer statusUpdateParam, String nicknameUpdateParam,
                                   String wantedGiftUpdateParam, String unwantedGiftUpdateParam,
                                   Boolean isLeaderUpdateParam) {
        this.status = statusUpdateParam;
        this.nickname = nicknameUpdateParam;
        this.wantedGift = wantedGiftUpdateParam;
        this.unwantedGift = unwantedGiftUpdateParam;
        this.isLeader = isLeaderUpdateParam;
    }
}
