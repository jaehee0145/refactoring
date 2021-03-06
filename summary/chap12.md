#Chapter 12 복합 리팩토링
- 상속 구조 정리 Tease Apart Inheritance
- 절차 코드를 객체로 전환 Convert Procedural Design to Objects
- 도메인 로직을 표현과 분리 Separate Domain from Presentation
- 계층구조 추출 Extract Hierarchy

--
##상속 구조 정리 Tease Apart Inheritance
- 하나의 상속 계층이 두 작업을 동시에 수행할 땐 상속 계층을 하나 더 만들어서 위임을 통해 다른 계층을 호출하자

### 동기
- 상속 계층이 엉키면 코드 중복이 생기는 문제

### 방법
- 계층구조에 의해 수행되는 각종 기능들을 확인 
- 기능의 우선순위를 정하고, 어떤 기능을 현재 계층에 남기고 어떤 기능을 다른 계층으로 옮길지 정하기
- 공통 상위클래스에 클래스 추출을 적용해서 원본 계층에 있는 각 하위클래스별 객체를 작성하고 이 객체를 저장할 인스턴스 변수를 선언
- 공통 상위클래스에 클래스 추출을 적용해서 원본 클래스 안 각 하위클래스를 추출한 객체의 하위클래스로 만들자.
앞 단계에서 선언한 인스턴스 변수를 이 하위클래스의 안스턴스로 초기화
- 하위클래스마다 메서드 이동을 실시해서 하위클래스의 해당 기능을 관련된 추출 객체로 옮기자
- 하위클래스에 남아 있는 코드가 없으면 각 하위클래스를 삭제
- 부수적인 하위클래스를 모두 삭제할 때까지 반복 
- 새 계층구조를 보면서 메서드 상향이나 필드 상향 같은 리팩토링 기법을 실시할 여지가 있는지 확인 

--
## 절차 코드를 객체로 전환 Convert Procedural Design to Objects
- 코드가 절차식으로 작성되어 있을 땐 데이터 레코드를 객체로 바꾸고, 기능을 쪼개서 각각의 객체로 옮기자 

### 방법
- 각 레코드 타입을 읽기/쓰기 메서드만 있는 덤 데이터 객체로 바꾸자
- 모든 절차 코드를 하나의 클래스에 넣자 
  - 그 클래스를 싱글턴으로 만들거나 메서드를 static 타입으로 만들자. 싱글턴으로 만드는 방법은 다시 초기화할때 쉽다
- 긴 프로시저를 대상으로 메서드 추출과 관련된 리팩토링 기법을 실시해서 쪼개자.
프로시저를 쪼개면서 메서드 이동을 적용해서 각각을 적절한 덤 데이터 클래스로 옮기자.
- 원본 클래스에서 모든 기능을 삭제하게 될 때까지 반복

--
## 도메인 로직을 표현과 분리 Separate Domain from Presentation
- 도메인 로직이 들어있는 GUI 클래스가 있을 땐 도메인 로직을 별도의 도메인 클래스로 떼어내자

### 동기 
- MVC 패턴의 핵심은 사용자 인터페이스 코드(뷰, 표현)와 도메인 로직(모델)을 분리하는 것
  - 프로그램의 복잡한 두 부분이 수정하기 쉬운 조각으로 분리
  - 하나의 비즈니스 로직에 여러 개의 표현을 구현할 수 있음

### 방법
- 각 window 클래스가 사용할 도메인 클래스를 작성
- 테이블이 있으면 그 테이블의 행을 나타내는 클래스를 작성 
  - 도메인 클래스 안에 window 클래스가 행 도메인 객체 저장에 사용할 컬렉션을 선언
- window 클래스의 데이터를 검사
  - 사용자 인터페이스에서 사용: window 클래스
  - 도메인 클래스에서 사용: 메서드 이동으로 도메인 객체로 이동
  - 둘다: 관측 데이터 복제로 두 클래스에서 동기화 유지
- 표현 클래스에 로직이 있는지 검사해서 메서드 추출

---
## 계층구조 추출 Extract Hierarchy
- 한 클래스에 기능이 너무 많고 일부분에라도 조건문이 많을 땐 각 조건에 해당하는 하위클래슬 작성해서 계층구조를 만들자

### 방법
1. 각 기능을 어디에 넣을지 모를 때
   - 각 기능을 확인하고 구분짓자
     - 객체가 존재할 동안 각 기능이 변할 수 있다면 클래스 추출을 실시해서 각각의 클래스로 빼내자
   - 해당 특수 상황별 하위클래스를 작성하고 원본 클래스에 생성자를 팩토리 메서드로 전환
     - 적절한 하위클래스의 인스턴스를 반환하게 팩토리 메서드를 수정
   - 조건문이 든 메서드를 한 번에 하나씩 하위클래스로 복사한 후 상위클래스와 하위클래스의 메서드 기능을 알맞게 제한하여 단순화
     - 필요하다면 상위클래스에 메서드 추출
   - 상위클래스의 모든 메서드에 하위클래스 구현부가 들어갈 때까지 위의 단계를 반복
   - 모든 하위클래스 안에 재정의한 메서드를 상위클래스에서 삭제하고 상위클래스를 abstract 타입으로 변경
2. 각 기능이 확실히 구분될 때
   - 각 기능별 하위클래스를 작성
   - 생성자를 팩토리 메서드로 전환을 적용해서 각 기능에 대응하는 하위클래스르 반환하게 하자
   - 조건문이 있는 메서드마다 조건문을 재정으로 전환
     - 각 메서드가 일부 코드만 다를 땐 다른 부분에만 메서드 추출을 적용 













