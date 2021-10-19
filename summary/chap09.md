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
















