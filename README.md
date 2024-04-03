# jstg - 연예 엔터테인먼트 프로젝트
------------
## Contents
+ 프레임워크 - spring, springboot
+ mvc패턴
+ springboot 어노테이션 & 사용 기능
----------------
## 1. 프레임워크 - spring, springboot
### spring

  + 엔터프라이즈용 Java 애플리케이션 개발을 편하게 할 수 있게 해주는 오픈소스 경량급 애플리케이션 프레임워크

### springboot

  + 스프링 부트는 스프링으로 애플리케이션을 만들 때에 필요한 설정을 간편하게 처리해주는 별도의 프레임워크
------------------
## 2. mvc 패턴
![mvc패턴](https://github.com/dlaej/jstg/blob/main/mvc.png)

### 정의
   + Model-View-Controller의 약자로, 소프트웨어(어플리케이션)를 역할에 따라 세 가지 모듈로 나누어 구분한 패턴이다.

- 이렇게 세 가지 모듈로 나누어 구분하는 이유 적기

### 모델 (Model)
  + 어플리케이션의 데이터이며, 모든 데이터 정보를 가공하여 가지고 있는 컴포넌트이다.
### 뷰 (View) 
  + 시각적인 UI 요소를 지칭하는 용어이다.
### 컨트롤러 (컨트롤러)
  + 모델과 뷰를 연결해주는 역할을 한다
### mvc 패턴 종류
  + mvc1, mvc2, spring-mvc

  + #### mvc1

![mvc1](https://github.com/dlaej/jstg.firstproject/blob/main/mvc1.png)

브라우저(사용자)로부터 요청이 들어오면 db로부터 필요한 데이터를 받은 model객체를 jsp 페이지에 담아 응답으로 보내는 패턴이다.

즉, jsp가 view와 controller 역할을 모두 담당한다.

(jsp가 의미하는 것이 뭔지 몰랐지만 추후에 공부하기로 하고 일단 pass)

#### mvc2
![mvc2](https://github.com/dlaej/jstg.firstproject/blob/main/mvc2.png)

controller와 view가 분리가 된다.

이 프로젝트는 mvc2 패턴을 사용했다.

추가 공부

#### spring mvc
![spring-mvc](https://github.com/dlaej/jstg.firstproject/blob/main/spring-mvc.png)

mvc2패턴을 좀 더 발전시킨 모델.

1. 클라이언트가 서버에 요청을 하면, front contreoller인 dispatcherServlet 클래스가 요청을 받는다.

2. dispatcherServlet은 프로젝트 파일 내의 servlet-context.xml파일의 @Contreoller 인자를 통해 등록한 요청 위임 컨트롤러를 찾아 매핑된 컨트롤러가 존재하면 @RequestMapping을 통해 요청을 처리할 메소드로 이동한다.

3. 컨트롤러는 해당 요청을 처리한 service를 받아 비즈니스 로직을 서비스에게 위임한다.

4. service는 요청에 필요한 작업을 수행하고, 요청에 대해 db에 접근해야한다면 dao에 요청하여 처리를 위임한다.

5. dao는 db정보를 dto를 통해 받아 서비스에게 전달한다.

6. 서비스는 전달받은 데이터를 컨트롤러에게 전달한다.

7. 컨트롤러는 model 객체에게 요청에 맞는 view 정보를 담아 dispatcherServlet에게 전송한다.

8. dispatcherServlet은 viewResolver에게 전달받은 view 정보를 전달한다.

9. viewResolver는 응답할 view에 대한 jsp를 찾아 dispatcherServlet에게 전달한다.

10. dispatcherServlet은 응답할 뷰의 render를 지시하고 뷰는 로직을 처리한다.

11. dispatcherServlet은 클라이언트에게 rending된 뷰를 응답하며 요청을 마친다.

------------------- 
의문점: 컨트롤러, 뷰는 명확히 클래스로 나타나는 반면 모델은 추상적이어서 어떤 클래스나 역할을 지칭하는지 잘 모르겠음.
jsp가 뭐지?
서블릿이란?
dao랑 dto 차이가 뭐지?

# 컨트롤러, 서비스, 매퍼 구조
# 코드 설명
