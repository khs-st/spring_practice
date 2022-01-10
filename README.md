# spring 공부 정리 및 기록
<h2>이 저장소는 [초급~중급] 우아한형제들 기술이사 김영한의 스프링 완전 정복 수업을 듣고 공부 내용을 기록한 저장소입니다.</h2>
<h3>#강의 링크</h3>
<ul>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8" target="_blank" rel="noopener noreferrer">스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술&nbsp;</a></span> <strong>&nbsp;(22.01.08 ~)</strong></li>
<li><span style="color: #0075ff;"><a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8" target="_blank" rel="noopener noreferrer">스프링 핵심 원리 - 기본편</a></span></li>
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
<li>1-4-4. 회원 서비스 개발</li>
<li>1-4-5. 회원 서비스 테스트</li>
</ul>
