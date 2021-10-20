#Chapter 09 조건문 간결화
- 조건문 쪼개기 Decompose Conditional
- 중복 조건식 통합 Consolidate Conditional Expression
- 조건문의 공통 실행 코드 빼내기 Consolidate Duplicate Conditional Fragments
- 제어 플래그 제거 Remove Control Flag
- 여러 겹의 조건문을 감시 절로 전환 Replace Nested Conditional with Guard Clauses
- 조건문을 재정의로 전환 Replace Conditional with Polymorphism
- NULL 검사를 객체로 위임 Introduce Null Object
- Assertion 넣기 Introduce Assertion

---
## 조건문 쪼개기 Decompose Conditional
- 복잡한 조건문이 있을 땐 if, then, else 부분을 각각 메서드로 빼내자

**[BEFORE]**
```java
if (date.before (SUMMER_START) || date.after(SUMMER_END))
    charge = quantity * winterRate + winterServiceCharge;
else charge = quantity * summerRate;
```
**[AFTER]**
```java
if (notSummer(date))
    charge = winterCharge(quantity);
else charge = summerCharge(quantity);
```

### 동기
- 큰 덩어리의 코드를 잘개 쪼개고 각 코드 조각을 용도에 맞는 이름의 메서드 호출로 바꾸면 코드의 용도가 분명히 드러난다.  

### 방법 
- if 절을 별도의 메서드로 빼내자
- then 절과 else 절을 각각의 메서드로 빼내자  

---
## 중복 조건식 통합 Consolidate Conditional Expression
- 여러 조건 검사식의 결과가 같을 땐 하나의 조건문으로 합친 후 메서드로 빼내자 

### 동기 
- 여러 개의 조건 검사식이 있는데 조건에 따른 결과가 모두 같을 때 논리 연산자를 사용해서 합쳐야 한다.
- 이유 1) OR 연산자로 연결해서 실제로 하나의 검사 수행을 표현
- 이유 2) 메서드 추출을 적용할 수 있는 기반  

### 방법
- 모든 조건문에 부작용이 없는지 검사?
- 여러 개의 조건문을 논리 연산자를 사용해 하나의 조건문으로 바꾸자 
- 컴파일, 테스트
- 합친 조건문에서 메서드 추출 적용을 고려  

---
## 조건문의 공통 실행 코드 빼내기 Consolidate Duplicate Conditional Fragments
- 조건문의 모든 절에 같은 실행 코드가 있을 땐 같은 부분을 조건문 밖으로 빼자  


---
## 제어 플래그 제거 Remove Control Flag
- 논리 연산식의 제어 플래그 역할을 하는 변수가 있을 땐 그 변수를 break 문이나 return 문으로 바꾸자  

### 동기 
- 제어 플래그는 구조적 프로그래밍의 문법적 잔재
- 복잡한 조건문을 방지하는 break, continue 를 사용하자.

### 방법
- 논리문을 빠져나오게 하는 제어 플래그 값을 찾자 
- 그 제어 플래그 값을 대입하는 코드를 break나 continue로 바꾸자
- 컴파일, 테스트

---
## 여러 겹의 조건문을 감시 절로 전환 Replace Nested Conditional with Guard Clauses
- 메서드에 조건문이 있어서 정상적인 실행 경로를 파악하기 힘들 땐 모든 특수한 경우에 감시 절을 사용하자  

### 동기
- if - else : 둘 다 정상 동작일때
- 감시절 : 특이한 조건일때 

---
## 조건문을 재정의로 전환 Replace Conditional with Polymorphism
- 객체 타입에 따라 다른 기능을 실행하는 조건문이 있을 땐 조건문의 각 절을 하위 클래스의 재정의 메서드 안으로 옮기고, 원본 메서드는 abstract 타입으로 수정하자  

### 동기 
- 재정의의 본질은 타입에 따라 기능이 달라지는 여러 객체가 있을 때 일일이 조건문을 작성하지 않아도 다형적으로 호출되게 할 수 있다는 것  
- 타입을 추가할 때 모든 조건문을 찾아서 수정할 필요 없이, 새 하위 클래스를 작성하고 메서드를 구현하면 된다

### 방법 
- 해당 기법을 적용하기 전에 상속구조로 만들어야 한다. 
    1) 분류 부호를 하위 클래스로 전환 
       - 제일 간단하므로 가능하면 
    2) 분류 부호를 상태/전략 패턴으로 전환 
        - 이 클래스에 이미 하위클래스를 작성한 경우
- 조건문이 메서드 코드의 일부라면 메서드 추출을 적용
- 필요하다면 메서드 이동을 적용해서 조건문을 최상위 클래스로 이동
- 하위클래스 중 하나를 택해서 조건문 메서드를 재정의하는 메서드를 작성. 조건문의 해당 절에 있는 코드를 하위 클래스 메서드로 옮기고 적절히 수정
- 컴파일, 테스트 
- 메서드로 복사해 넣은 조건문 안의 절은 삭제
- 컴파일, 테스트
- 조건문의 나머지 절의 코드도 마찬가지로 하위 클래스 메서드 안으로 옮기자 
- 상위클래스 메서드를 abstract 타입으로 만들자 













