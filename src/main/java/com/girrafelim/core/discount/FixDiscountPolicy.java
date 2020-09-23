package com.girrafelim.core.discount;

import com.girrafelim.core.member.Grade;
import com.girrafelim.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // enum type은 ==로 비교하는게 맞음
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}
