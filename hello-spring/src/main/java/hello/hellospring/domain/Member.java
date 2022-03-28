package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//JPA 엔티티 매핑
@Getter
// 기본 생성자 자동 추가
// public Posts(){}와 같은 효과
@NoArgsConstructor
@Entity
public class Member {

    // Entity에는 setter를 만들지 말라고함, 영적인 데이터객체이기 떄문에 set으로 데이터를 넣지말라고 하네연 껄껄껄

   //DB가 자동 생성 -> IDENTITY
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 사용시 ex)
    // repositoryMember.save(Member.builder()
    //                             .id(id)
    //                             .name(name)
    //                             .build());
    @Builder
    public Member (Long id, String name){
        this.id = id;
        this.name = name;
    }


}
