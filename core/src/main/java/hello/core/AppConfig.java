package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
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
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    //OrderServiceImpl -> MemoryMemberRepository , FixDiscountPolicy
    public OrderService orderService() {
        return new OrderServiceImpl(new FixDiscountPolicy(), new MemoryMemberRepository());
    }

}
