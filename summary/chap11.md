#Chapter 11 일반화 처리
- 필드 상향 Pull Up Field
- 메서드 상향 Pull Up Method
- 생성자 내용 상향 Pull Up Constructor Body
- 메서드 하향 Push Down Method
- 필드 하향 Push Down Field
- 하위클래스 추출 Extract Subclass
- 상위클래스 추출 Extract Superclass
- 인터페이스 추출 Extract Interface
- 계층 병합 Collapse Hierarchy
- 템플릿 메서드 형성 Form Template Method
- 상속을 위임으로 전환 Replace Inheritance with Delegation
- 위임을 상속으로 전환 Replace Delegation with Inheritance

---
## 필드 상향 Pull Up Field
- 두 하위 클래스에 같은 필드가 들어 있을 땐 필드를 상위클래스로 옮기자

### 동기
- 중복된 필드가 서로 비슷한 방식으로 사용된다면 그 필드를 일반화
  - 일반화: 상위클래스로 옮기는 작업
- 두 가지 측면에서 중복 제거
  1) 데이터 선언의 중복
  2) 해당 필드를 사용하는 기능의 중복

### 방법
- 상위 클래스로 옮길 필드가 사용된 모든 부분을 검사해서 같은 방식으로 사용하는지 확인
- 필드의 이름이 같지 않다면 변경
- 컴파일, 테스트
- 상위클래스 안에 새 필드 작성
- 하위 클래스 필드 삭제
- 컴파일, 테스트 
- 새 필드에 필드 자체 캡슐화 적용 고려 
  - 필드 자체 캡슐화: getter, setter만을 통해서 해당 필드에 접근하게 만드는 방법

---
## 메서드 상향 Pull Up Method
- 기능이 같은 메서드가 여러 하위클래스에 들어 있을 땐 그 메서드를 상위클래스로 옮기자

### 동기
- 중복된 기능을 없애는 일은 중요하다. 기능이 중복된 두 메서드가 문제없이 돌아가더라도... 향후 발생할 버그의 온상

### 방법
- 메서드가 서로 같은지 검사
  - 거의 비슷하면 알고리즘 전환을 적용해 메서드를 똑같이 만들자
- 메서드의 시그니처가 서로 다르면 모든 시그니처를 상위 클래스에 사용하고자 하는 시그니처로 수정
- 상위클래스 안에 새 메서드를 작성하고 새 메서드 안에 같은 메서드의 내용을 복사 
- 하위클래스 메서드 삭

























