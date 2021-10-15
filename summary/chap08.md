#Chapter 08 데이터 체계화
- 필드 자체 캡슐화 Self Encapsulate Field
- 데이터 값을 객체로 전환 Replace Data Value with Object
- 값을 참조로 전환 Change Value to Reference
- 참조를 값으로 전환 Change Reference to Value
- 배열을 객체로 전환 Replace Array with Object 
- 관측 데이터 복제 Duplicate Observed Data
- 클래스의 단방향 연결을 양방향으로 전환 Change Unidirectional Association to Bidirectional
- 클래스의 양방향 연결을 단방향으로 전환 Change Bidirectional Association to Unidirectional
- 마법 숫자를 기호 상수로 전환 Replace Magic Number with Symbolic Constant
- 필드 캡슐화 Encapsulate Field
- 컬렉션 캡슐화 Encapsulate Collection
- 레코드를 데이터 클래스로 전환 Replace Record with Data Class
- 분류 부호를 클래스로 전환 Replace Type Code with Class
- 분류 부호를 하위클래스로 전환 Replace Type Code with Subclasses
- 분류 부호를 상태/전략 패턴으로 전환 Replace Type Code with State/Strategy
- 하위 클래스를 필드로 전환 Replace Subclass with Fields

---

## 필드 자체 캡슐화 Self Encapsulate Field
- 필드에 직접 접근하던 중 그 필드로의 결합에 문제가 생길 땐 그 필드용 읽기/쓰기 메서드를 작성해서 두 메서드를 통해서만 필드에 접근하게 만들자

**[BEFORE]**
```java
private int low, high;
boolean includes (int arg) {
    return arg >= log && arg <= high;
}
```

**[AFTER]**
```java
private int low, high;
boolean includes (int arg) {
    return arg >= getLow() && arg <= getHigh();
}
int getLow() {return log;}
int getHigh() {return high;}
```

### 동기
- 변수 직접 접근파 vs 변수 간접 접근파
- 변수 간접 접근 방식
  - 하위클래스가 메서드에 해당 정보를 가져오는 방식을 재정의할 수 있다
  - 데이터 관리가 유연해진다.
- 변수 직접 접근 방식
  - 코드를 알아보기 쉽다.

### 방법
- 필드 읽기 메서드와 쓰기 메서드를 작성
- 그 필드 참조 부분을 전부 찾아서 읽기 메서드와 쓰기 메서드로 고치자  
- 필드를 private으로 만들자
- 테스트 















