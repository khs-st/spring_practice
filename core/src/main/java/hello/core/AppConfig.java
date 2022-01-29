package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    
    //생성자 주입 이용하여 관심사 분리
    //객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)
    
    //MemberServiceImpl -> MemoryMemberRepository
    //AppConfig 리팩토링
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    //OrderServiceImpl -> MemoryMemberRepository , FixDiscountPolicy
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
        //할인 정책 변경
        //return new RateDiscountPolicy();
    }
}
