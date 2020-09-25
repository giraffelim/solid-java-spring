package com.girrafelim.core;

import com.girrafelim.core.member.Grade;
import com.girrafelim.core.member.Member;
import com.girrafelim.core.member.MemberService;
import com.girrafelim.core.order.Order;
import com.girrafelim.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.joinMember(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }

}
