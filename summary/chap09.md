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


