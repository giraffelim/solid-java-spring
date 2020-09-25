package com.girrafelim.core;

import com.girrafelim.core.discount.DiscountPolicy;
import com.girrafelim.core.discount.FixDiscountPolicy;
import com.girrafelim.core.discount.RateDiscountPolicy;
import com.girrafelim.core.member.MemberRepository;
import com.girrafelim.core.member.MemberService;
import com.girrafelim.core.member.MemberServiceImpl;
import com.girrafelim.core.member.MemoryMemberRepository;
import com.girrafelim.core.order.OrderService;
import com.girrafelim.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 * 스프링의 DI 컨테이너 역할
 */
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
