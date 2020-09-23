package com.girrafelim.core.discount;

import com.girrafelim.core.member.Grade;
import com.girrafelim.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }
    
    @Test
    @DisplayName("VIP가 아닌 회원은 10% 할인이 적용되지 않아야 한다")
    public void vip_x() throws Exception {
        // given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}