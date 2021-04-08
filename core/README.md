## 스프링 핵심 원리 - 기본편 
- https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard

### 객체 지향 설계의 5가지 원칙
- SRP 단일 책임 원칙 : 한 클래스는 하나의 책임만 가진다.
- DIP 의존관계 역전 원칙 : 추상화에 의존하고, 구체화에 의존하면 안된다.
- OCP : 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.

### Ioc, DI 그리고 컨테이너
- AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 **DI 컨테이너** 라고 한다.
- 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 한다.

### 프레임워크 VS 라이브러리
- 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다(JUnit)
- 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니고 라이브러리다.

### 스프링 컨테이너
- 'ApplicationContext'를 스프링 컨테이너라 한다.
- 'ApplicationContext'는 인터페이스이다.
- 스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다.

### BeanFactory와 ApplicationContext
**BeanFactory**
- 스프링 컨테이너의 최상위 인터페이스다.
- 스프링 빈을 관리하고 조회하는 역활을 담당한다.
- getBean()을 제공한다.

**ApplicationContext**
- BeanFactory 기능을 모두 상속받아서 제공한다.
- 빈을 관리하고 검색하는 기능을 BeanFactory가 제공하는데, 둘의 차이는?
- MessageSource, EnvironmentCapable, ApplicationEventPublisher, ResourceLoader 등을 상속받음

**정리**
- ApplicationContext는 BeanFactory의 기능을 상속받는다.
- ApplicationContext는 빈 관리기능 + 편리한 부가 기능을 제공한다.
- BeanFactory를 직접 사용할 일은 거의 없다. 부가기능이 포함된 ApplicationContext를 사용한다.
- BeanFactory나 ApplicationContext를 스프링 컨테이너라고 한다.

### 스프링 빈 설정 메타 정보 - BeanDefinition
- 스프링은 어떻게 이런 다양한 설정 형식을 지원하는 것일까? 그 중심에는 'BeanDefinition'이라는 추상화가 있다.
- 쉽게 이야기해서 역활과 구현을 개념적으로 나눈 것 이다.
    - xml을 읽어서 BeanDefinition을 만들면 된다.
    - 자바 코드를 읽어서 BeanDefinition을 만들면 된다.
    - 스프링 컨테이너는 자바 코드인지, XML인지 몰라도 된다. 오직 BeanDefinition만 알면 된다.
- BeanDefinition을 빈 설정 메타 정보라 한다.
- 스프링 컨테이너는 이 메타정보를 기반으로 스프링 빈을 생성한다.

**BeanDefinition 정보**
- BeanClassName : 생성할 빈의 클래스 명
- factoryBeanName : 팩토리 역활의 빈을 사용할 경우 이름, 예) appConfig
- factoryMethodName : 빈을 생성할 팩토리 메서드 지정, 예) memberService
- Scope : 싱글톤(기본값)
- lazyInit : 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
- InitMethodName : 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
- DestoryMethodName : 빈의 생성주기가 끝나서 제거하기 직전에 호출되는 메서드 명
- Constructor arguments, Properties : 의존관계 주입에서 사용한다.

**정리**
- BeanDefinition을 직접 정의해서 스프링 컨테이너에 등록할 수 있다.
- 스프링이 다양한 형태의 설정 정보를 BeanDefinition으로 추상화해서 사용하는 것 정도만 이해하면 된다.