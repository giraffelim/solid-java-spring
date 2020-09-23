package com.girrafelim.core.order;

import com.girrafelim.core.AppConfig;
import com.girrafelim.core.member.Grade;
import com.girrafelim.core.member.Member;
import com.girrafelim.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }

    @Test
    public void 주문_테스트() throws Exception {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.joinMember(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
