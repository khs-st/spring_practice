# spring 공부 정리 및 기록
<h2>이 저장소는 [초급~중급] 우아한형제들 기술이사 김영한의 스프링 완전 정복 수업을 듣고 공부 내용을 기록한 저장소입니다.</h2>
<h3>#강의 링크</h3>
<ul>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8" target="_blank" rel="noopener noreferrer">스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술&nbsp;</a></span> <strong>&nbsp;(22.01.08 ~ 22.01.16)</strong></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8" target="_blank" rel="noopener noreferrer">스프링 핵심 원리 - 기본편</a></span><strong>&nbsp;(22.01.26 ~ )</strong></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC" target="_blank" rel="noopener noreferrer">모든 개발자를 위한 HTTP 웹 기본 지식&nbsp;</a></span></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1" target="_blank" rel="noopener">스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술</a></span></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-2" target="_blank" rel="noopener">스프링 MVC 2편 - 백엔드 웹 개발 활용 기술</a></span></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B3%A0%EA%B8%89%ED%8E%B8" target="_blank" rel="noopener">스프링 핵심 원리 - 고급편</a></span></li>
</ul>
<h3>#로드맵 링크</h3>
<ul><li><a href="https://www.inflearn.com/roadmaps/373" target="_blank" title="로드맵 링크 새창 열기">https://www.inflearn.com/roadmaps/373</li></ul>

## 제가 공부한 순서입니다.
1. [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](#spring-introduction)
2. [스프링 핵심 원리 - 기본편](#spring-main-principle)
3. [모든 개발자를 위한 HTTP 웹 기본 지식](#for-all-devleop-http-intel)
4. [스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술](#spring-mvc-backend-1)
5. [스프링 MVC 2편 - 백엔드 웹 개발 핵심 기술](#spring-mvc-backend-2)
6. [스프링 핵심 원리 - 고급편](#example)

<details>
<summary>1. 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술 정리</summary>
<a name="spring-introduction"></a>
<h2>1. 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술</h2>
<h4>이 강의에서는 실제 동작하는 간단한 웹 애플리케이션을 다음 순서로 빠르게 만들어보았습니다.</h4>
<ul>
<li>스프링 프로젝트 생성</li>
<li>스프링 부트로 웹 서버 실행</li>
<li>회원 도메인 개발</li>
<li>웹 MVC 개발</li>
<li>DB 연동 - JDBC, JPA, 스프링 데이터 JPA</li>
<li>테스트 케이스 작성</li>
</ul>
<h3>1-1. 정적 컨텐츠</h3>
<p>스프링 컨테이너에 매핑과 관련 컨트롤러 존재하지 않는다.</p>
<p>그래서 resource: static/index.html 찾아서 반환한다.</p>
<h4>실행</h4>
<p>http://localhost:8080/index.html</p>
<h3>1-2. MVC와 템플릿 엔진</h3>
<p>MVC: Model, View, Controller</p>
<p><img src="https://user-images.githubusercontent.com/64995062/148678681-dc08d789-0234-43a8-8f8b-3c4f4463f925.png" alt="MVC 이미지"></p>
<h3>1-3. API</h3>
<p><img src="https://user-images.githubusercontent.com/64995062/148678761-2abe6f0d-55e1-475d-ab4e-48e1c5b9f7da.png" alt="API 이미지"></p>
<h4>@ResponseBody 문자 반환</h4>
 -> @ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않는다.
대신에 HTTP의 BODY에 문자 내용을 직접 반환(HTML BODY TAG를 말하는 것이 아님)
<h4>@ResponseBody 객체 반환</h4>
 -> @ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨
<h3>1-4. 백엔드 개발 - 회원 관리 예제</h3>
<ul>
<li>1-4-1. 비지니스 요구사항 정리
<ul>
 <li>데이터: 회원ID, 이름</li>
<li>기능: 회원 등록, 조회</li>
 <li>일반적인 웹 어플리케이션 계층 구조</li><br>
 <p>-컨트롤러: 웹 MVC의 컨트롤러 역할<br><br>
-서비스: 핵심 비즈니스 로직 구현<br><br>
-리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리<br><br>
-도메인: 비즈니스 도메인 객체, 예) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨</p>
 </ul>
</li>
 <li>1-4-2. 회원 도메인과 레포지토리 만들기
<ul>
<li>회원 객체 - Member.java</li>
<li>회원 레포지토리 인터페이스 - MemberRepository.interface</li>
<li>회원 리포지토리 메모리 구현체 - MemoryMemberRepository.java</li>
</ul></li>
<li>1-4-3. 회원 레포지토리 테스트 케이스 작성
<ul>
<li>JUnit이라는 프레임워크로 테스트</li>
<li>회원 레포지토리 메모리 구현체 테스트 - MemoryMemberRepositoryTest.java</li>
<li>테스트는 순서와 관계없이, 서로 의존관계 없이 설계가 되어야 한다. 그러기 위해선 하나의 테스트가 실행되면 공용 데이터는 지워져야한다. - afterEach() 메서드 참고</li>
</ul></li>
<li>1-4-4. 회원 서비스 개발
<ul>
<li>회원서비스 생성 - MemberService.java</li>
<li>회원가입, 전체 회원 조회, 회원 단일 조회 기능 생성</li>
</ul>
</li>
<li>1-4-5. 회원 서비스 테스트</li>
<ul>
<li>회원서비스 생성 - MemberServiceTest.java</li>
<li>회원가입, 전체 회원 조회, 회원 단일 조회 기능 테스트</li>
<li>테스트 생성 후 테스트 도중 기존 코드의 <br>
MemberService에서 memberRepostiory의 내용물이 달라질 가능성이 있어<br>
동일한 memberRepository를 사용하도록 코드 수정하였다. -> Dependency Injection</li>
</ul>
<li>1-4-6. 스프링 빈과 의존관계</li>
<ul>
<li>컴포넌트 스캔과 자동 의존관계 설정
<ul>
<li>회원 컨트롤러가 회원서비스와 회원 리포지토리를 사용할 수 있게 의존관계</li>
<li>생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. <br>
이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.</li>
<li>스프링 빈을 등록하는 2가지 방법<br>
 - 컴포넌트 스캔과 자동 의존관계 설정<br>
 - 자바 코드로 직접 스프링 빈 등록하기</li>
<li>컴포넌트 스캔으로 자동 의존관계 설정하기<br>
<br>★ 컴포넌트 스캔 원리<br>1. @Component 애노테이션이 있으면 스프링 빈으로 자동 등록된다.<br>
2. @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다.
<br>3. @Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다.(@Controller, @Service, @Repository)
<br><br>
★ 자바 코드로 직접 스프링 빈 등록하기 - 생성자 주입
<br>1. MemberService.java의 @Service와 @Autowired 어노테이션 제거
<br>2. MemoryMemberRepository.java의 @Repository 어노테이션 제거
<br>3. SpringConfig.java 생성 후 @Configuration 과 @Bean 어노테이션 이용하여 직접 스프링 빈 등록(memberRepository())
<br><br> - 장점: 설정파일 즉 SpringConfig.java에서 MemoryMemberRepository 대신 다른 Repository로 변경 가능하다.(상황에 따라 구현클래스 변경이 가능하다.)
<br><br> - 단점: 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
</li>
</ul>
</li>
</ul>
<li>1-4-7. 회원 웹 기능 - 홈 화면 추가
<ul>
<li>HomeController.java 생성</li>
<li>home.html 생성</li>
</ul>
</li>
<li>1-4-8. 회원 웹 기능 - 등록
<ul>
<li>MemberController.java - 회원 목록 등록 기능 추가</li>
<li>createMemberForm.html 생성</li>
</ul>
</li>
<li>1-4-9. 회원 웹 기능 - 조회 및 등록
<ul>
<li>MemberController.java - 회원 목록 조회 기능 추가</li>
<li>memberList.html 생성 - 반복문으로 member의 list 조회</li>
</ul>
</li>
<li>1-4-10. H2 데이터베이스 설치 및 테스트
<ul>
<li>jdbc:h2:tcp://localhost/~/test</li>
<li>테이블 생성(id bigint generated by default as identity,name varchar(255), primary key (id)
</li>
</ul>
</li>
<li>1-4-11. 순수 JDBC
<ul>
<li>application.properties 파일에 스프링 부트 데이터베이스 연결 설정 추가</li>
<li>build.gradle 파일에 jdbc, h2 데이터베이스 관련 라이브러리 추가</li>
<li>JdbcMemberRepository.java 생성 - 예전 개발자 방식</li>
<li>기존 코드는 건들지 않고 SpringConfig.java 코드안의 구현체 변경(JdbcMemberRepository로 변경)으로 인한 편리하다.</li>
<p><img src="https://user-images.githubusercontent.com/64995062/149610165-b52338dc-5fd5-453c-a0be-3203751788e4.png" alt="구현체 변경"></p>
</ul>
</li>
<li>1-4-12. 스프링 통합 테스트
<ul>
<li>MemberServiceIntegrationTest.java 생성 -> @SpringBootTest, @Transactional 어노테이션 활용</li>
<li>스프링 컨테이너와 DB까지 연결한 통합 테스트 진행.</li>
</ul>
</li>
<li>1-4-13. 스프링 JdbcTemplate
<ul>
<li>순수 Jdbc와 동일한 환경설정</li>
<li>JdbcTemplate을 사용하도록 SpringConfig.java 수정</li>
<li>MemberServiceIntegrationTest로 테스트 완료</li>
</ul>
</li>
<li>1-4-14. JPA
<ul>
<li>JPA는 기존 반복 코드 및 기본적인 SQL도 직접 만들어서 실행해준다.</li>
<li>JPA 사용 시 SQL과 데이터 중심 설계 -> 객체 중심 설계로 전환 가능하다.</li>
<li>JPA 사용하면 개발 생산성을 크게 높일 수 있다.</li>
</ul>
</li>
<li>1-4-14. 스프링 데이터 JPA
<ul>
<li>스프링 데이터 JPA 사용 시 레포지토리에 구현 클래스 없이 인터페이스 만으로 개발 완료 가능하다.</li>
<li>스프링 데이터 JPA 회원 레포지토리</li>
<li>스프링 데이터 JPA 회원 레포지토리를 사용하도록 스프링 설정 변경</li>
<li>스프링 데이터 JPA 제공 기능
<ul>
<li>인터페이스를 통한 기본적인 CRUD</li>
<li>findByName() , findByEmail() 처럼 메서드 이름 만으로 조회 기능 제공</li>
<li>페이징 기능 자동 제공</li>
</ul>
</li>
</ul>
</li>
<li>1-4-15. AOP 및 AOP 적용
<ul>
<li>MemberService 회원 조회 시간 측정 추가</li>
<li>공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 분리</li>
<li>시간 측정 AOP 등록 - TimeTraceAop.java 추가</li>
</ul>
</li>
</ul>
</details>

<details>
<summary>2. 스프링 핵심 원리 - 기본편</summary>
<a name="spring-main-principle"></a>

### 2. 스프링 핵심 원리 - 기본편

### 강의 목차
1. 객체 지향 설계와 스프링(이론위주)<br>
2. 스프링 핵심 원리 이해1 - 예제 만들기<br>
3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용<br>
4. 스프링 컨테이너와 스프링 빈<br>
5. 싱글톤 컨테이너<br>
6. 컴포넌트 스캔<br>
7. 의존관계 자동 주입<br>
8. 빈 생명주기 콜백<br>
9. 빈 스코프

#### 2.2. 스프링 핵심 원리 이해1 - 예제 만들기

- 프로젝트 생성
- 비즈니스 요구사항과 설계
  - 회원
    - 회원가입 및 조회
    - 회원등급 -> 일반, VIP
    - 회원 데이터는 자체 DB 구축 가능, 외부 시스템과 연동 가능(미확정)
  - 주문과 할인 정책
    - 회원은 상품을 주문할 수 있다.
    - 회원 등급에 따라 할인 정책을 적용할 수 있다.
    - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
    - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다.  최악의 경우 할인을 적용하지 않을 수도 있다. (미확정)
- 회원 도메인 설계
  - 회원 도메인 요구사항
    - 회원을 가입하고 조회할 수 있다.
    - 회원은 일반과 VIP 두 가지 등급이 있다.
    - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
- 회원 도메인 개발
- 회원 도메인 실행과 테스트
- 주문과 할인 도메인 설계( 예제가 너무 복잡해 질 수 있어서 생략하고, 단순히 주문결과를 반환)
  1. 주문 생성: 클라이언트는 주문 서비스에 주문 생성을 요청한다.
  2. 회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
  3. 할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
  4. 주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.

![image](https://user-images.githubusercontent.com/64995062/151371215-84465194-b6a2-42d3-92cc-ee61a869e9f3.png)

- 주문과 할인 도메인 개발
  - 메모리 회원 리포지토리와, 고정 금액 할인 정책을 구현체로 생성
- 주문과 할인 도메인 실행과 테스트
- 새로운 할인 정책 개발
  - 새로운 할인 정책으로 확장 
  - RateDiscountPolicy 추가
- 새로운 할인 정책 적용과 문제점
  - 문제점: 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있고 OCP(변경하지않고 확장 가능)가 불가능하다.
  - 해결방안: 인터페이스에만 의존하도록 의존관계를 변경(OrderServiceImpl 에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입)
- 관심사의 분리
  - AppConfig에서 생성자 주입으로 관심사 분리
  - MemberServiceImpl, OrderServiceImpl 수정(기능을 실행하는 책임만 지도록)
  - 테스트 코드 오류 수정

</details>