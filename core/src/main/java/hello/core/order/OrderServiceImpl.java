package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //새로운 할인 정책 적용 -> OCP 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //해결방법: 추상인터페이스만 의존하도록 변경!
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    //수정자 주입(setter 주입) -> 자바빈 프로퍼티 규약
    /*private DiscountPolicy discountPolicy2;
    private MemberRepository memberRepository2;

    @Autowired
    public void setDiscountPolicy2(DiscountPolicy discountPolicy2) {
        this.discountPolicy2 = discountPolicy2;
    }

    @Autowired
    public void setMemberRepository2(MemberRepository memberRepository2) {
        this.memberRepository2 = memberRepository2;
    }*/

    //생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다.
    //물론 스프링 빈에만 해당한다.
    @Autowired
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
    
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
