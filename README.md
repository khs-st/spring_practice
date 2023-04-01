# spring 공부 정리 및 기록
<h2>이 저장소는 [초급~중급] 우아한형제들 기술이사 김영한의 스프링 완전 정복 수업을 듣고 공부 내용을 기록한 저장소입니다.</h2>
<h3>#강의 링크</h3>
<ul>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8" target="_blank" rel="noopener noreferrer">스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술&nbsp;</a></span> <strong>&nbsp;</strong></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8" target="_blank" rel="noopener noreferrer">스프링 핵심 원리 - 기본편</a></span><strong>&nbsp;</strong></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC" target="_blank" rel="noopener noreferrer">모든 개발자를 위한 HTTP 웹 기본 지식</a></span><strong>&nbsp;</strong></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1" target="_blank" rel="noopener">스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술</a></span><strong>&nbsp;</strong></li>
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

#### 2.2. 스프링 핵심 원리 이해1 - 예제 만들기, 스프링 핵심 원리 이해2 - 객체 지향 원리 적용

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
- AppConfig 리팩터링
  - 중복 제거, 역할에 따른 구현이 보이도록 리팩터링
  - MemoryMemberRepository를 다른 구현체로 변경할 때 한 부분만 변경하면 된다.
  - 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악 가능하다.
- 새로운 구조와 할인 정책 적용
  - AppConfig의 할인 정책 역할을 담당하는 구현을 FixDiscountPolicy -> RateDiscountPolicy객체로 변경
- 스프링으로 전환하기
  - AppConfig의 메서드에 Configuration, Bean 어노테이션 설정
  - MemberApp, OrderApp에 스프링 컨테이너 적용
  - ApplicationContext -> 스프링 컨테이너라고 한다. 스프링 컨테이너를 통해 필요한 스프링 빈(객체)를 찾는다.

#### 2.3. 스프링 컨테이너와 스프링 빈

- 스프링 컨테이너 생성
- 컨테이너에 등록된 모든 빈 조회
  - 테스트로 모든 빈 출력, 애플리케이션 빈 출력 해보기
- 스프링 빈 조회 - 기본
  - getBean(빈이름, 타입), getBean(타입)으로 조회 
  - 구체 타입으로 조회하면 변경시 유연성이 떨어진다.
- 스프링 빈 조회 - 동일한 타입이 둘 이상
- 스프링 빈 조회 - 상속 관계
- BeanFactory와 ApplicationContext
- 다양한 설정 형식 지원 - 자바 코드, XML
- 스프링 빈 설정 메타 정보 - BeanDefinition
  - 스프링이 다양한 형태의 설정 정보를 BeanDefinition으로 추상화해서 사용한다.

#### 2.4. 싱글톤 컨테이너

- 웹 애플리케이션과 싱글톤
  - 현재 스프링 없는 순수 DI 컨테이너인 AppConfig는 요청 할 때마다 객체 새로 생성
  - 메모리 낭비 심하다.
  - 해결방안: 객체 딱 1개만 생성, 공유하도록 설계 -> 싱글톤 패턴
- 싱글톤 패턴
  - static 영역에 객체 instance 미리 하나 생성
  - getInstance() 메서드를 통해서만 조회 가능 -> 항상 같은 인스턴스 반환
  - 딱 1개의 객체 인스턴스만 존재해야 한다. -> 외부에서 new로 객체 인스턴스 생성되는 것 막는다.
  - 싱글톤 패턴 문제점
<pre><code>
1. 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
2. 의존관계상 클라이언트가 구체 클래스에 의존한다. DIP를 위반한다.
3. 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
4. 테스트하기 어렵다.
5. 내부 속성을 변경하거나 초기화 하기 어렵다.
6. private 생성자로 자식 클래스를 만들기 어렵다.
7. 결론적으로 유연성이 떨어진다.
8. 안티패턴으로 불리기도 한다.
</code></pre>
- 싱글톤 컨테이너
  - 객체 인스턴스를 싱글톤(1개만 생성)으로 관리한다.
  - 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 된다.
  - 스프링 컨테이너 덕분에 고객의 요청이 올 때마다 객체를 만드는 것이 아니라 이미 만들어진 객체를 공유해서 효율적으로 재사용할 수 있다.
- 싱글톤 방식의 주의점
  - 상태를 유지할 경우 발생하는 문제 -> 공유필드는 조심해야하며 스프링 빈은 항상 무상태로 설계
- @Configuration과 싱글톤
- @Configuration과 바이트코드 조작의 마법
  - 직접 출력해보니 출력에 CGLIB가 붙어있었다. -> AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것
  - 스프링은 클래스의 바이트코드를 조작하는 라이브러리를 사용한다.
  - 덕분에 싱글톤이 보장된다.
  - @Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않는다.

#### 2.5. 컴포넌트 스캔

- 컴포넌트 스캔과 의존관계 자동 주입 시작하기
  - 컴포넌트 스캔 -> @Component 가 붙은 모든 클래스를 스프링 빈으로 등록한다
  - @Autowired 의존관계 자동 주입
- 탐색 위치와 기본 스캔 대상
  - 컴포넌트 스캔 기본 대상
    - @Component : 컴포넌트 스캔에서 사용
    - @Controlller : 스프링 MVC 컨트롤러에서 사용
    - @Service : 스프링 비즈니스 로직에서 사용
    - @Repository : 스프링 데이터 접근 계층에서 사용
    - @Configuration : 스프링 설정 정보에서 사용
- 필터
- 중복 등록과 충돌

#### 2.6. 의존관계 자동 주입
- 다양한 의존관계 주입 방법
  - 생성자 주입
    - 특징: 불변, 필수 의존관계에 사용
  - 수정자 주입(setter 주입)
    - 특징: 선택, 변경 가능성이 있는 의존관계에 사용
  - 필드 주입(사용하지 않는 걸 추천)
    - 특징
      - 외부에서 변경이 불가능해서 테스트 하기 힘들다
      - 외부에서 변경이 불가능해서 테스트 하기 힘들다.
      - 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용
  - 일반 메서드 주입
    - 특징: 한번에 여러 필드를 주입 받을 수 있으며 일반적으로 잘 사용하지 않는다.
- 옵션 처리
  - 자동 주입 대상을 옵션으로 처리하는 방법
    -@Autowired(required=false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
    -org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null이 입력된다.
    -Optional<> : 자동 주입할 대상이 없으면 Optional.empty 가 입력된다.
- 생성자 주입을 선택하라
  - 불변, 누락, final 키워드(생성자 주입을 사용하면 필드에 final 키워드를 사용할 수 있다.)
- 롬복과 최신 트랜드
  - 롬복 라이브러리 적용 방법
- 조회 빈이 2개 이상 - 문제
- @Autowired 필드 명 매칭, @Qualifier, @Primary - 해결
  - @Autowired 필드 명 매칭: @Autowired 는 타입 매칭을 시도하고, 이때 여러 빈이 있으면 필드 이름, 파라미터 이름으로 빈 이름을 추가
매칭한다.
  - @Qualifier: 추가 구분자를 붙여주는 방법
    - 하지만 경험상 @Qualifier를 찾는 용도로만 사용하는게 명확하고 좋다.
  - @Primary: 우선순위를 정하는 방법
    - 메인 데이터베이스의 커넥션을 획득하는 스프링 빈은 @Primary 를 적용해서 조회하는 곳에서 @Qualifier
지정 없이 편리하게 조회하고, 서브 데이터베이스 커넥션 빈을 획득할 때는 @Qualifier 를 지정해서
명시적으로 획득 하는 방식으로 사용하면 코드를 깔끔하게 유지할 수 있다.
 - @Primary보다 @Qualifier가 우선권이 높다
- 애노테이션 직접 만들기
- 조회한 빈이 모두 필요할 때, List, Map
- 자동, 수동의 올바른 실무 운영 기준
  - 편리한 자동 기능을 기본으로 사용하자
  - 직접 등록하는 기술 지원 객체는 수동 등록
  - 다형성을 적극 활용하는 비즈니스 로직은 수동 등록을 고민해보자

#### 2.7. 빈 생명주기 콜백
- 빈 생명주기 콜백 시작
  - 스프링 빈의 이벤트 라이프사이클: 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 
-> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
  - 인터페이스(InitializingBean, DisposableBean)
  - 설정 정보에 초기화 메서드, 종료 메서드 지정
  - @PostConstruct, @PreDestroy 애노테이션 지원
- 인터페이스 InitializingBean, DisposableBean(지금은 거의 사용하지 않는다.)
  - 초기화, 소멸 인터페이스 단점
    - 스프링 전용 인터페이스이다.
    - 초기화, 소멸 메서드의 이름을 변경할 수 없다. 
    - 내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.
- 빈 등록 초기화, 소멸 메서드
  - 설정 정보 사용 특징
    - 메서드 이름을 자유롭게 줄 수 있다.
    - 스프링 빈이 스프링 코드에 의존하지 않는다.
    - 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료
메서드를 적용할 수 있다.
- 애노테이션 @PostConstruct, @PreDestroy(이 방법들을 사용!!!)
  - @PostConstruct, @PreDestroy 애노테이션 특징
    - 최신 스프링에서 가장 권장하는 방법이다.
    - 스프링이 아닌 다른 컨테이너에서도 동작한다.
    - 컴포넌트 스캔과 잘 어울린다.
    - 유일한 단점: 외부 라이브러리에는 적용하지 못한다. -> @Bean 기능 사용하면 된다.

#### 2.8. 빈 스코프
- 빈 스코프란? -> 빈이 존재할 수 있는 범위를 뜻한다.
  - 웹 관련 스코프: request, session, application
- 프로토타입 스코프
  - 싱글톤 스코프의 빈 조회 -> 항상 같은 인스턴스 스프링 빈을 반환.
  - 스프링 컨테이너에 조회 -> 항상 새로운 인스턴스 생성하여 반환.
  - 스프링 컨테이너는 프로토타입 빈 조회, 의존관계 주입, 초기화까지만 관여한다.
  - 종료 메서드 호출되지 않는다.
- 프로토타입 스코프 - 싱글톤 빈과 함께 사용시 문제점
  - 프로토타입 빈이 새로 생성되기는 하지만, 싱글톤 빈과 함께 계속 유지되는 것이 문제다.
  - 문제를 해결 할 수 있지만 지저분한 코드이다.(올바른 방법이 아니다.) 
- 프로토타입 스코프 - 싱글톤 빈과 함께 사용시 Provider로 문제 해결
- 웹 스코프
  - 특징: 웹 환경에서만 동작하며, 프로토타입과 다르게 스프링이 해당 스코프의 종료시점까지 관리한다. 따라서 종료 메서드가 호출된다
  - 종류: request, session, application, websocket
- request 스코프 예제 만들기
- 스코프와 Provider
- 스코프와 프록시
  - proxyMode = ScopedProxyMode.TARGET_CLASS 추가
  - 가짜 프록시 클래스를 만들어두고 HTTP request와 상관 없이 가짜 프록시 클래스를 다른 빈에 미리 주입해 둘 수 있다.
  - 주의점: 마치 싱글톤을 사용하는 것 같지만 다르게 동작하기 때문에 결국 주의해서 사용해야 한다.

</details>
<details>
<summary>3. 모든 개발자를 위한 HTTP 웹 기본 지식</summary>
<a name="for-all-devleop-http-intel"></a>

### 3. 모든 개발자를 위한 HTTP 웹 기본 지식

### 강의 목차
1. 인터넷 네트워크
2. URI와 웹 브라우저 요청 흐름
3. HTTP 기본
4. HTTP 메서드
5. HTTP 메서드 활용
6. HTTP 상태코드
7. HTTP 헤더1 - 일반 헤더
8. HTTP 헤더2 - 캐시와 조건부 요청

#### 3.1. 인터넷 네트워크
- 인터넷 통신
- IP(인터넷 프로토콜)
  - IP 프로토콜의 한계: 비연결성, 비신뢰성, 프로그램 구분
- TCP, UDP
  - TCP 특징: 연결지향, 데이터 전달 보증, 순서 보장, 신뢰 가능한 프로토콜
  - UDP 특징: 연결지향X, 데이터 전달 보증X, 순서 보장X, IP와 거의 비슷하며 단순하고 빠르다.
- PORT
  - 같은 IP 내에서 프로세스 구분
  - FTP: 20, 21
  - TELNET: 23
  - HTTP: 80
  - HTTPS: 443
- DNS
  - 도메인 명, 도메인 명을 IP주소로 변환

#### 3.2. URI와 웹 브라우저 요청 흐름
- URI, URL, URN
  - URI: 로케이터(locator), 이름(name) 또는 둘 다 추가로 분류될 수 있다.
  - URL(Locator): 리소스가 있는 위치를 지정
  - URN(Name): 리소스에 이름을 부여
- 웹 브라우저 요청 흐름

#### 3.3. HTTP 기본
- 모든 것이 HTTP
  - HTTP 특징: 클라이언트 서버 구조, 무상태 프로토콜(Stateless), 비연결성, 단순함, 확장 가능
- 클라이언트 서버 구조
  - Request Response 구조, 클라이언트는 서버에 요청 보내고 응답 대기
- Stateful, Stateless
  - 상태 유지(Stateful): 항상 같은 서버가 유지되어야 한다.
    - 문제점: 중간에 서버 장애나면 다시 요청해야한다.
  - 무상태 프로토콜(Stateless): 서버가 클라이언트의 상태를 보존X
    - 장점: 서버 확장성 높다. 중간에 서버가 장애나도 다른 서버로 전달하여 처리가 가능하다.
    - 단점: 클라이언트가 추가 데이터 전송(데이터를 많이 보낸다.)
  - 실무 한계: 상태 유지는 최소한만 사용(예시: 로그인)
- 비연결성(connectionless)
  - HTTP는 기본이 연결을 유지하지 않으며 서버 자원을 매우 효율적으로 사용할 수 있다.
  - 단점 
    - TCP/IP 연결을 새로 맺어야 하기 때문에 3 way handshake 시간이 추가된다.
    - 웹 브라우저로 사이트 요청 시 수 많은 자원이 함께 다운로드 된다.
  - 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결
  - 대용량 트래픽(선착순, 예약 등) -> 스테이트리스!!!!
- HTTP 메시지
  - HTTP 메시지 구조
  - ![image](https://user-images.githubusercontent.com/64995062/155681132-1ebc4bae-e225-46af-a1da-82d39053ff7b.png)
  - 시작 라인(요청 메시지)
    - 요청 메시지 - HTTP 메서드(GET: 조회, POST: 요청 내역 처리, PUT, DELETE...)
    - 요청 대상 - 절대경로= "/" 로 시작하는 경로
    - HTTP Version
  - 시작 라인(응답 메시지)
    - HTTP 버전, HTTP 상태 코드(요청 성공, 실패를 나타냄 예시: 200, 400, 500 등)
    - 이유 문구
  - HTTP 헤더
    - HTTP 전송에 필요한 모든 부가정보, 필요시 임의의 헤더 추가 가능
  - HTTP 메시지 바디 -> 실제 전송할 데이터, byte로 표현 가능한 모든 데이터 전송 가능
- 단순함 확장 가능

#### 3.4. HTTP 메서드
- HTTP API를 만들어보자
- HTTP 메서드 - GET, POST
- HTTP 메서드 - PUT, PATCH, DELETE
- HTTP 메서드의 속성

</details>
<details>
<summary>4. 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술</summary>
<a name="spring-mvc-backend-1"></a>

### 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술

1. 웹 애플리케이션 이해
2. 서블릿
3. 서블릿, JSP, MVC 패턴
4. MVC 프레임워크 만들기
5. 스프링 MVC - 구조 이해
6. 스프링 MVC - 기본 기능
7. 스프링 MVC - 웹 페이지 만들기

#### 2. 서블릿

 - 프로젝트 생성 및 welcome 페이지 추가
  - Project Metadata
  - Group: hello
  - Artifact: servlet
  - Name: servlet
  - Package name: hello.servlet
  - Packaging: War
  - Java: 11
 - HttpServletRequest 개요
   - HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메시지를 파싱한다. 그리고 그 결과를 HttpServletRequest 객체에 담아서 제공한다.
   - 임시저장소 기능, 세션 관리 기능이 있다.
 - HttpServletRequest - 기본 사용법
   - HttpServletRequest를 통한 HTTP 메시지의 start-line, header 정보 조회 방법 확인
 - Http 요청 데이터 - 개요
  -- GET - 쿼리 파라미터
   - /url?username=hello&age=20
   - 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달
   - 예) 검색, 필터, 페이징등에서 많이 사용하는 방식
  - POST - HTML Form
   - content-type: application/x-www-form-urlencoded
   - 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20
   - 예) 회원 가입, 상품 주문, HTML Form 사용
  - HTTP message body에 데이터를 직접 담아서 요청
   - HTTP API에서 주로 사용, JSON, XML, TEXT
  - 데이터 형식은 주로 JSON 사용
   - POST, PUT, PATCH
 - Http 요청 데이터 - GET 쿼리 파라미터
  - 쿼리 파라미터는 URL에 ?를 시작으로 보낼 수 있다. 추가 파라미터는 &로 구분 하면 된다.
   - 예시: http://localhost:8080/request-param?username=hello&age=20
  - 중복된 파라미터일 경우 getParameterValues()를 사용해야 한다. 중복인 경우에 getParameter() 사용 시 첫 번째 값을 반환한다.
 - HTTP 요청 데이터 - POST HTML Form
  - 특징
    - content-type: application/x-www-form-urlencoded
    - 메시지 바디에 쿼리 파리미터 형식으로 데이터를 전달한다. username=hello&age=20
 - HTTP 요청 데이터 - API 메시지 바디 - JSON
  - JSON 형식 전송 -> JSON 형식으로 파싱할 수  있도록 객체 생성 후 전송
  - 스프링 부트로 Spring MVC를 선택 시 Json 라이브러리 ObjectMapper 제공
 - HttpServletResponse - 기본 사용법
  - HTTP 응답 메시지 생성
    - HTTP 응답코드 지정
    - 헤더 생성
    - 바디 생성
  - 편의 기능 제공
   - Content-Type, 쿠키, Redirect
 - HTTP 응답 데이터 - API JSON
  - HTTP 응답으로 JSON을 반환할 때는 content-type을 application/json 로 지정해야 한다.
    - Jackson 라이브러리가 제공하는 objectMapper.writeValueAsString() 를 사용하면 객체를 JSON 
문자로 변경할 수 있다.
  - application/json은 스펙상 utf-8 형식을 사용하도록 정의되어 있다.

#### 3. 서블릿, JSP, MVC 패턴

 - 회원 관리 웹 애플리케이션 요구사항
   - 기능 요구사항
    - 회원 저장
    - 회원 목록 조회
   - 회원을 저장하고, 목록을 조회하는 테스트를 작성
 - 서블릿으로 회원 관리 웹 애플리케이션 만들기
   - 회원 등록 폼
   - 회원 저장
   - 회원 목록 조회

#### 4. MVC 프레임워크 만들기

 - FrontController 패턴 특징
   - 프론트 컨트롤러가 서블릿 하나로 클라이언트의 요청을 받음
   - 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출
   - 공통 처리 기능
   - 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 됨
 - 프론트 컨트롤러 도입 - v1
   - 클라이언트에서 HTTP 요청
   - URL 매핑 정보에서 컨트롤러 조회
   - 컨트롤러 호출
   - 컨트롤러에서 JSP forward  
   - 클라이언트에게 HTML 응답   
 - View 분리 - v2
   - 모든 컨트롤러에서 뷰로 이동하는 부분에 중복이 있어 깔끔하지 않음.
   - 별도로 View를 처리하는 객체를 만들었다.
   - v2 구조 
     - HTTP 요청
     - URL 매핑 정보에서 컨트롤러 조회
     - 컨트롤러 호출
     - MyView 반환 
     - render() 호출
     - JSP forward
     - HTML 응답
   - 컨트롤러가 뷰를 반환하는 특징이 있다. -> view.render()를 호출하여 fowrard 로직 수행 시 JSP가 실행된다.
   - JSP 만이 아닌 다른 템플릿도 사용할 경우에는 인터페이스로 구현하는게 다양성 활용에 좋다.
 - Model 추가 - v3
   - 서블릿 종속성 제거
     - 요청 파라미터 정보는 Map으로 대신 넘겨 서블릿 기술 몰라도 동작 가능하다.
     - request 객체를 Model로 사용하는 대신 Model 객체 만들어 반환한다.
   - 뷰 이름 중복 제거
   - v3 구조 
     - HTTP 요청
     - 컨트롤러 조회
     - 컨트롤러 호출
     - ModelView 반환 
     - viewResolver 호출
     - MyView 반환
     - render(model)호출
     - HTML 응답
 - 단순하고 실용적인 컨트롤러 - v4
   - 모델 객체 전달(모델 객체를 프론트 컨트롤러에서 생성하여 넘겨준다.)
   - ModelView 반환하지않고 ViewName을 직접 반환한다.
   - V4 구조 
     - HTTP 요청
     - 컨트롤러 조회
     - 컨트롤러 호출(paramMap, model)
     - viewName 반환 
     - viewResolver 호출
     - MyView 반환
     - render(model)호출
     - HTML 응답     
 - 유연한 컨트롤러1 - v5
   - 어댑터 패턴
     - 다양한 방식의 컨트롤러 인터페이스 사용 가능하도록 변경 
   - V5 구조 
     - HTTP 요청
     - 핸들러(컨트롤러) 조회
     - 핸드러를 처리할 수 있는 핸들러 어댑터 조회
     - handle(handler)
     - 핸들러 어댑터
     - handler 호출
     - 핸들러(컨트롤러)
     - ModelView 반환
     - viewResolver 호출
     - MyView 반환
     - render(model) 호출
     - HTML 응답
 - 유연한 컨트롤러2 - v5
   - 어댑터에 v4 추가

#### 5. 스프링 MVC - 구조 이해

 - 스프링 MVC 전체 구조
 - 서블릿으로 회원 관리 웹 애플리케이션 만들기
   - 회원 등록 폼
   - 회원 저장
   - 회원 목록 조회
 - 스프링 MVC 시작하기
   - @Controller : 스프링이 자동으로 스프링 빈으로 등록한다.
   - @RequestMapping 어노테이션을 사용한 컨트롤러 생성
     - RequestMappingHandlerMapping
     - RequestMappingHandlerAdapter
     - 어노테이션 기반의 컨트롤러를 지원하는 핸들러 매핑과 어댑터
 - 스프링 MVC 컨트롤러 통합
   - 하나의 컨트롤러에 RequestMapping 이용하여 통합
   - RequestMapping 선언하여 중복 제거
 - 스프링 MVC - 실용적인 방식
   - Model 파라미터
   - ViewName 직접 반환
   - @RequestParam 사용(GET 쿼리 파라미터, POST Form 방식 모두 지원)
   - @RequestMapping -> @GetMapping, @PostMapping 
   
#### 6. 스프링 MVC - 기본 기능

 - 프로젝트 생성 및 index.html 생성
 - 로깅 알아보기
   - @Slf4j
   - 로그레벨(LEVEL:  TRACE > DEBUG > INFO > WARN > ERROR)
   - 로그 사용 시 장점
     - 쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 볼 수 있고, 출력 모양을 조정할 수 있다.
     - 로그 레벨에 따라 개발 서버에서는 모든 로그를 출력하고, 운영서버에서는 출력하지 않는 등 로그를 상황에 맞게 조절가능하다.
     - 시스템 아웃 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등, 로그를 별도의 위치에 남길 수 있다.
     - 특히 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능하다.
     - 성능도 일반 System.out 보다 좋다. (내부 버퍼링, 멀티 쓰레드 등등) 그래서 실무에서는 꼭 로그를 사용해야 한다
 - 요청 매핑
   - HTTP 메서드 매핑 축약(GET, POST, PUT, DELETE)
   - 만약 여기에 다른 RequestMethod를 호출하면 스프링 MVC는 HTTP 405 상태코드(Method Not Allowed)를 반환한다.
   - PathVariable(경로 변수) 사용, PathVariable 사용 - 다중
   - 특정 파라미터 조건 매핑
   - 특정 헤더 조건 매핑 - HTTP 헤더를 사용한다.
   - 미디어 타입 조건 매핑 - HTTP 요청 Content-Type, consume
     - HTTP 요청의 Content-Type 헤더를 기반으로 미디어 타입으로 매핑한다.
     - 만약 맞지 않으면 HTTP 415 상태코드(Unsupported Media Type)을 반환한다
   - 미디어 타입 조건 매핑 - HTTP 요청 Accept, produce
     - HTTP 요청의 Accept 헤더를 기반으로 미디어 타입으로 매핑한다.
     - ㅁ만약 맞지 않으면 HTTP 406 상태코드(Not Acceptable)을 반환한다.
 - 요청 매핑 - API 예시
   - 회원 관리 API
     - 회원 목록 조회: GET /users
     - 회원 등록: POST /users
     - 회원 조회: GET /users/{userId}
     - 회원 수정: PATCH /users/{userId}
     - 회원 삭제: DELETE /users/{userId}
 - HTTP 요청 - 기본, 헤더 조회
   - RequestHeaderController 생성 및 @Slf4j 이용한 로그로 헤더 정보 조회
     - 모든 HTTP 헤더를 MultiValueMap 형식으로 조회해보았다.
       - MultiValueMap: 하나의 키에 여러 값을 받을 수 있다.(예시: keyA=value1&keyA=value2)
 - HTTP 요청 파라미터 - 쿼리 파라미터, HTML Form
   - 클라이언트에서 서버로 요청 데이터를 전달하는 방법 3가지
     - GET - 쿼리 파라미터
     - POST - HTML Form
     - HTTP message body에 데이터 직접 담아 요청
 - HTTP 요청 파라미터 - @RequestParam
   - request-param-v2
     - @RequestParam: 파라미터 이름으로 바인딩
     - @ResponseBody: View 조회를 무시, HTTP message body에 직접 해당 내용 입력
   - request-param-v3
     - HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능하다.
   - request-param-v4
     - String, int 등의 단순 타입이면 @RequestParam 도 생략 가능하다.
   - requestParamRequired
     - 파라미터 필수 여부: @RequestParam.required
       - 만약 해당 값이 없다면 400 예외가 발생한다.
       - 파라미터 이름만 있고 값이 없는 경우는 빈문자로 통과한다.
       - 기본형(primitive)에 null 입력 시 500 예외 발생 (예시: int=null -> 해결책은 Integer로 변경하거나 defaultValue를 사용)
   - requestParamDefault
     - 파라미터에 값이 없는 경우 defaultValue 를 사용하면 기본 값을 적용할 수 있다.(빈 문자의 경우에도 설정한 기본 값이 적용된다.)
     - 이미 기본 값 존재하므로 required는 의미가 없다.
   - requestParamMap
     - 파라미터를 Map, MultiValueMap으로 조회 할 수 있다.
       - @RequestParam Map , Map(key=value)
       - @RequestParam MultiValueMap MultiValueMap(key=[value1, value2, ...] ex) (key=userIds, value=[id1, id2])
 - HTTP 요청 파라미터 - @ModelAttribute
   - @ModelAttribute 적용 - modelAttributeV1
     - @Data 이용하여 데이터 생성(@Getter , @Setter , @ToString , @EqualsAndHashCode , @RequiredArgsConstructor 를 자동으로 적용해준다.)
     - 요청 파라미터 이름으로 HelloData 객체의 프로퍼티를 찾아 setter 호출하여 파라미터의 값을 입력(바인딩)한다.
   - @ModelAttribute 생략 - modelAttributeV2
     - @ModelAttribute 는 생략할 수 있다. 하지만 RequestParam도 생략할 수 있어 혼란 발생 가능하다.
     - 스프링에서는 해당 생략 시 아래의 규칙을 적용한다.
       - String , int , Integer 같은 단순 타입 = @RequestParam
       - 나머지 = @ModelAttribute (argument resolver 로 지정해둔 타입 외)
 - HTTP 요청 메시지 - 단순 텍스트
   - HTTP message body에 데이터 직접 담아 요청
     - HTTP API에서 주로 사용, JSON, XML, TEXT
     - 데이터 형식은 주로 JSON 사용
     = POST, PUT, PATCH
   - Body row, Text 선택
   - Input, Output 스트림, Reader
   - HttpEntity: HTTP header, body 정보를 편리하게 조회
     - 메시지 바디 정보를 직접 조회
     - 요청 파라미터를 조회하는 기능과 관계 없다.
     - HTTPEntity는 응답에도 사용 가능하다.
       - 메시지 바디 정보 직접 반환
       - 헤더 정보 포함 가능
       - view 조회X
   - @RequestBody: 바디 정보를 편리하게 조회 할 수 있다.
     - 헤더 정보가 필요하다면 @RequestHeader나 HttpEntity를 사용하면 된다.
     - 메시지 바디를 직접 조회하는 기능은 요청 파라미터를 조회하는 @RequestParam ,
    @ModelAttribute 와는 전혀 관계가 없다.
   - @ResponseBody: 응답 결과를 HTTP 메시지 바디에 직접 담아서 전달 가능하다.(view 사용X)
   - 정리
     - 요청 파라미터를 조회하는 기능: @RequestParam , @ModelAttribute
     - HTTP 메시지 바디를 직접 조회하는 기능: @RequestBody
 - HTTP 요청 메시지 - JSON
   - 문자로 된 JSON 데이터를 Jackson 라이브러리인 objectMapper 를 사용해서 자바 객체로 변환한다.
   - @RequestBody 객체 파라미터 : @RequestBody 에 직접 만든 객체 가능하다.
   - @RequestBody는 생략 불가능
   - 응답의 경우에도 @ResponseBody 를 사용하면 해당 객체를 HTTP 메시지 바디에 직접 넣어줄 수 있다.
 - HTTP 응답 - 정적 리소스, 뷰 템플릿
   - 정적 리소스(스프링부트는 이 디렉토리(/static , /public , /resources , /META-INF/resources)에 있는 정적 리소스를 제공한다.)
   - 뷰 템플릿 사용(경로: src/main/resources/templates)
   - HTTP 메시지 사용: HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보낸다.
   - String을 반환하는 경우 - View or HTTP 메시지
     - @ResponseBody 있는 경우는 뷰를 찾아 렌더링, 없는 경우는 HTTP 메시지 바디에 직접 입력된다.
   - Void를 반환하는 경우
     - @Controller를 사용하고 HTTP 메시지 바디를 처리하는 파라미터가 없으면 요청 URL을 참고해서 논리 뷰 이름으로 사용(권장하지 않는 방식이다.)
 - HTTP 응답 - HTTP API, 메시지 바디에 직접 입력
   - @ResponseBody를 사용하면 view를 사용하지 않고 HTTP 메시지 컨버터를 통해 HTTP 메시지를 직접 입력 할 수 있다.
   - ResponseEntity는 HTTP 응답 코드 설정이 가능한데 @ResponseBody를 사용하면 이런 것을 설정하기 까다롭다. 그래서 @ResponseStatus(HttpStatus.OK)를 사용하면 응답 코드 설정이 가능하다.
 - HTTP 메시지 컨버터
 - 요청 매핑 헨들러 어뎁터 구조

#### 7. 스프링 MVC - 웹 페이지 만들기

 - 프로젝트 생성
   - Project Metadata
     - Group: hello
     - Artifact: item-service
     - Name: item-service
     - Package name: hello.itemservice
     - Packaging: Jar (주의!)
     - Java: 11
     - Dependencies: Spring Web, Thymeleaf, Lombok
 - 상품 도메인 개발
   - Item 상품객체 생성
   - ItemRepository 상품저장소 생성
   - ItemRepositoryTest 상품저장소 테스트 생성 후 테스트 완료 
 - 상품 서비스 HTML
   - bootstrap.min.css 파일 추가
   - 상품목록 HTML, 상품 상세 HTML, 상품 등록 폼 HTML, 상품 수정 폼 HTML 추가
 - 상품 목록 - 타임리프
   - BasicController 생성 및 상품목록 테스트용 데이터 추가(@PostConstruct 이용)
   - @RequiredArgsConstructor
     - final 이 붙은 멤버변수만 사용해서 생성자를 자동으로 만들어줌.
   - 뷰 템플릿에 타임리프 추가
 - 상품 상세 및 등록
   - 상품 상세 매핑값 추가
   - 상품 등록 폼 매핑값 추가
   - 상품 등록 폼 생성
   - 상품 등록 매핑값 추가
 - POST, Redirect GET
   -POST 등록 후 새로고침 시 서버에 마지막 데이터 재전송 오류 수정  
 - RedirectAttributes
   - 사용자 입장에서 저장 유무를 보기 힘들어 RedirectAttributes 이용하여 메시지 추가

</details>

<details>
<summary>5. 스프링 MVC 2편 - 백엔드 웹 개발 핵심 기술</summary>
<a name="spring-mvc-backend-2"></a>

### 5. 스프링 MVC 2편 - 백엔드 웹 개발 핵심 기술

### 강의 목차
1. 타임리프 - 기본 기능
2. 타임리프 - 스프링 통합과 폼
3. 메시지, 국제화
4. 검증1 - Validation
5. 검증2 - Bean Validation
6. 로그인 처리1 - 쿠키, 세션
7. 로그인 처리2 - 필터, 인터셉터
8. 예외 처리와 오류 페이지
9. API 예외 처리
10. 스프링 타입 컨버터
11. 파일 업로드

#### 1. 타임리프 - 기본 기능

- 프로젝트 생성 및 index.html 생성
  - Project: Gradle - Groovy Project
    - Language: Java
    - Spring Boot: 2.7.9
    - Project Metadata
    - Group: hello
    - Artifact: thymeleaf-basic
    - Name: thymeleaf-basic
    - Package name: hello.thymeleaf
    - Packaging: Jar
    - Java: 11
    - Dependencies: Spring Web, Lombok , Thymeleaf
 - 타임리프 텍스트 - text,utext
 - 변수 - springEL
 - 기본객체들
 - 유틸리티 객체와 날짜
 - URL 링크
 - 리터럴
 - 연산  
 - 속성 값 설정
 - 반복
 - 조건부 평가
 - 주석
 - 블록
 - 자바스크립트 인라인
 - 템플릿 조각
 - 템플릿 레이아웃1, 2


</details>