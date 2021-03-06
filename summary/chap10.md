#Chapter 10 메서드 호출 단순화  
- 메서드명 변경 Rename Method
- 매개변수 추가 Add Parameter
- 매개변수 제거 Remove Parameter
- 상태 변경 메서드와 값 반환 메서드를 분리 Separate Query from Modifier
- 메서드를 매개변수로 전환 Parameterize Method
- 매개변수를 메서드로 전환 Replace Parameter with Explicit Methods
- 객체를 통째로 전달 Preserve Whole Object
- 매개변수 세트를 메서드로 전환 Replace Parameter with Method
- 매개변수 세트를 객체로 전환 Introduce Parameter Object
- 쓰기 메서드 제거 Remove Setting Method
- 메서드 은폐 Hide Method
- 생성자를 팩토리 메서드로 전환 Replace constructor with Factory Method
- 하향 타입 변환을 캡슐화 Encapsulate Downcast
- 에러 부호를 예외 통지로 교체 Replace Error Code with Exception 
- 예외 처리를 테스트로 교체 Replace Exception with Test

---
## 메서드명 변경 Rename Method
- 메서드명을 봐도 기능을 알 수 없을 땐 메서드명을 직관적인 이름으로 바꾸자.

### 동기
- 메서드 기능을 설명하기 위해 넣는 주석을 떠올린 후 그 주석을 메서드명으로 바꾸는 방법

### 방법
- 메서드 시그니처가 상위클래스나 하위클래스에 구현되어 있는지 검사하자. 만약 구현되어 있다면 각 구현부를 대상으로 다음 단계들을 실시하자.
- 새 이름으로 새 메서드를 선언한다. 코드의 원래 내용을 새 메서드로 복사하고 적절히 수정하자.
- 컴파일  
- 새 메서드를 호출하게 원본 메서드의 내용을 수정 
  - 참조하는 부분이 적다면 skip 가능 
- 원본 메서드 참조 부분을 전부 찾아서 새 메서드를 참조하게 수정
- 원본 메서드 삭제
- 컴파일, 테스트 

---
## 매개변수 추가 Add Parameter
- 메서드가 자신을 호출한 부분의 정보를 더 많이 알아야 할 땐 그 객체에 그 정보를 전달할 수 있는 매개변수를 추가하자.

### 동기
- 다른 방법을 먼저 고려해보고 적용하는 것이 좋다. 
  - 매개변수 나열이 길수록 기억하기 힘들고 데이터 뭉치라는 구린내가 날 가능성이 높다.

---
## 매개변수 제거 Remove Parameter
- 메서드가 어떤 매개변수를 더 이상 사용하지 않을 땐 그 매개변수를 삭제하자

### 동기
- 매개변수 삭제를 꺼려하는 경우가 많다.
  - 그냥 놔둬도 문제가 없고, 나중에 다시 필요해질수도 있다는 생각
- 삭제 해야하는 이유
  - 그 메서드를 사용하는 곳에서 불필요한 추가 작업이 수행된다.
  - 매개변수는 필요한 정보를 나타낸다.
  - 다른 값이 전달되면 결과가 달라진다. 
- 재정의 메서드에 주의
  - 그 메서드의 다른 재정의 메서드에서 매개변수가 사용되지 않는지 확인
    - 호출 부분에서 그 메서드가 정말 필요한 것으로 판단이 되면 별도의 메서드를 추가해야할 수도 있다.

___
## 상태 변경 메서드와 값 반환 메서드를 분리 Separate Query from Modifier
- 값 반환 기능과 객체 상태 변경 기능이 한 메서드에 들어 있을 땐 질의 메서드와 변경 메서드로 분리하자.

### 동기
- 값을 반환하는 메서드가 있는데 그 메서드에 부작용이 있다면 상태 변경 부분과 값 반환 부분을 별도의 메서드로 각각 분리해야 한다.  

### 방법
- 원본 메서드와 같은 값을 반환하는 값 반환 메서드를 작성하자
- 메서드 호출의 결과를 반환하게 원본 메서드를 수정하자 
- 컴파일, 테스트 
- 원본 메서드 호출 뒤에 값 반환 메서드를 추가
- 원본 메서드를 void 타입으로 수정하고 return 문 삭제 


---
## 메서드를 매개변수로 전환 Parameterize Method
- 여러 메서드가 기능은 비슷하고 안에 든 값만 다를 땐 서로 다른 값을 하나의 매개변수로 전달받는 메서드를 하나 작성하자.

---
## 매개변수를 메서드로 전환 Replace Parameter with Explicit Methods
- 매개변수로 전달된 값에 따라 메서드가 다른 코드를 실행할 땐 그 매개변수로 전달될 수 있는 모든 값에 대응하는 메서드를 각각 작성하자.

### 동기
- 이 리팩토링 기법은 일반적으로 한 매개변수의 값이 여러 개가 될 수 있을 때 조건문 안에서 각 값을 검사하여 다른 기능을 수행하는 메서드에 적용  

---
## 객체를 통째로 전달 Preserve Whole Object
- 객체에서 가져온 여러 값을 메서드 호출에서 매개변수로 전달할 땐 그 객ㄱ체를 통째로 전달하게 수정하자.
[BEFORE]
```java
int low = daysTempRange().getLow();
int high = daysTempRange().getHign();
withinPlan = plan.withinRange(low, high);
```
[AFTER]
```java
withinPlan = plan.withinRange(daysTempRange());
```

### 동기
- 장점
  - 매개변수 세트 변경의 편의성 뿐 아니라 코드를 알아보기도 쉬워진다.
- 단점
  - 통 객체를 전달하면 통 객체와 호출된 객체가 서로 의존하게 된다.
  - 이것이 의존성 구조를 망가뜨릴 것 같으면 사용하면 안되는 방법

---
## 매개변수 세트를 메서드로 전환 Replace Parameter with Method
- 여러 개의 매개변수가 항상 붙어 다닐 땐 그 매개변수들을 객체로 바꾸자

### 동기
  - 특정 매개변수들이 함께 전달되는 경우, 이 매개변수들을 객체로 바꾸는 것이 좋다.
  - 장점
    - 매개변수 세트가 짧게 줄어서 좋다.
    - 새 객체에 정의된 속성 접근 메서드로 인해 코드 일관성 개선
    - 결과적으로 코드를 이해, 유지보수가 쉽다.
    - 기능을 새 클래스로 옮길 수 있어서 좋다.
      - 메서드 안에 매개변수 값에 대한 공통적인 조작, 중복코드를 개선
    
### 방법  
  - 대체할 매개변수 그룹에 해당하는 새 클래스를 작성, 변경불가 클래스로 만들자
  - 컴파일
  - 새 데이터 뭉치에 매개변수 추가를 적용
  - 각 매개변수마다 시그니처에서 해당 매개변수를 삭제
  - 매개변수를 옮길 때마다 컴파일, 테스트 
  - 매개변수 삭제를 완료하면 메서드 이동을 적용해서 매개변수 객체로 옮길 수 있는 기능을 찾자

---
## 쓰기 메서드 제거 Remove Setting Method
- 생성할 때 지정한 필드 값이 절대로 변경되지 말아야 할 땐 그 필드를 설정하는 모든 쓰기 메서드를 삭제하자  

### 동기
- 객체가 생성된 후에 필드가 변경되지 말아야 한다면 setter 삭제
  - 의도가 달성되고 필드가 수정될 가능성을 차단 
  - 간접적인 변수 접근을 맹목적으로 이용할 때 실시해야 한다.

### 방법
- 쓰기 메서드가 생성할 때나 생성자가 호출하는 메서드에서만 호출되는지 검사
- 컴파일, 테스트 
- 쓰기 메서드가 생성자 안이나 생성자가 호출한 메서드 안에서만 호출되는지 검사 
- 변수에 직접 접근할 수 있게 생성자 수정 
  - 상위클래스의 private 필드를 설정하는 하위클래스가 있으면 생성자를 변수에 직접 접근하게 수정할 수 없다.
  - 이럴 땐 상위클래스에 private 필드 값을 설정하는 protected 메서드를 넣어야 한다.
    
---
## 메서드 은폐 Hide Method
- 메서드가 다른 클래스에 사용되지 않을 땐 그 메서드의 반환 타입을 private으로 만들자

### 동기
- 메서드의 개방도를 바꾸는 경우
  - 공개적으로 만드는 경우
    - 다른 클래스가 그 메서드를 사용하는 경우
  - 비공개적으로 만드는 경우
    - 판단이 비교적 어려움
    - 더 많은 기능이 든 리치 인터페이스를 작성할 때 
      - 클래스 안에 넣은 기능이 많을수록 대부분의 읽기/쓰기 메서드를 은폐하게 된다.

### 방법
- 메서드의 개방도를 낮출 여지가 있느지 정기적으로 검사하자
- 각 메서드를 가능하면 private 타입으로 만들자
- private 타입으로 만들때마다 테스트를 실시

--
## 생성자를 팩토리 메서드로 전환 Replace constructor with Factory Method
- 객체를 생성할 때 단순한 생성만 수행하게 해야 할 땐 생성자를 팩토리 메서드로 교체하자

[BEFORE]
```java
Employee (int type) {
    this.type = type;
}
```
[AFTER]
```java
static Employee create(int type) {
    return new Employee(type);
}
```

### 동기
- 가장 확실한 상황 : 분류 부호를 하위클래스로 바꿀 때 
  - 분류 부호를 사용해 작성한 객체가 있는데 하위클래스가 필요해진 경우
    - 어느 하위 클래스를 사용할지는 분류 부호에 따라 달라지는데 생성자는 요청된 객체의 인스턴스만 반환할 수 있으니
    - 생성자를 팩토리 메서드로 바꿔야 한다.  
- 생성자가 너무 제한되는 상황에서도 사용
  - 팩토리 메서드는 값을 참조로 전환을 실시하기 위해 꼭 필요하다.

### 방법 
- 팩토리 메서드 작성. 그 메서드의 내용을 기존의 생성자 호출로 수정
- 모든 생성자 호출을 팩토리 메서드 호출로 바꾸자.
- 컴파일, 테스트
- 생성자를 private으로 선언
- 컴파일

---

## 하향 타입 변환을 캡슐화 Encapsulate Downcast
- 메서드가 반환하는 객체를 호출 부분에서 하향 타입 변환해야 할 땐 하향 타입 변환 기능을 메서드 안으로 옮기자
[BEFORE]
```java
Object lastReading() {
    return readings.lastElement();
}
```
[AFTER]
```java
Reading lastReading() {
    return (Reading) readings.lastElement();
}
```
---
## 에러 부호를 예외 통지로 교체 Replace Error Code with Exception 
- 메서드가 에러를 나타내는 특수한 부호를 반환할 땐 그 부호 반환 코드를 예외 통지 코드로 바꾸자 

[BEFORE]
```java
int withdraw(int amount) {
    if (amount > balance) {
        return -1;  
    } else {
      balance -= amount;
      return 0;
    }
}
```
[AFTER]
```java
int withdraw(int amount) throws BalnaceException {
    if (amount > balance) throw new BalanceException();
    balance -= amount;
}
```

### 동기
- 예외는 에러 처리를 일반적인 처리와 확실히 분리시키기 때문에 좋다.

### 방법
- 확인된 예외와 미확인 예외 중 어느 것을 사용해야 할지 판단한다
  - 호출 전에 호출하는 부분이 조건을 검사해야 한다면 미확인 예외
  - 예외가 확인된 것이라면 새 예외를 작성하거나 기존 예외를 사용 
- 호출 부분을 전부 찾아서 그 예외를 사용하게 수정
  - 미확인 예외일 땐 호출 부분이 메서드 호출 전에 적절한 검사를 하게 하자
  - 확인된 예외일 땐 호출 부분이 try절 안에서 메서드를 호출하게 하자 
- 메서드 시그니처를 수정해서 새로운 용도를 반영하자

---
## 예외 처리를 테스트로 교체 Replace Exception with Test
- 호출 부분에 사전 검사 코드를 넣으면 될 상황인데 예외 통지를 사용했을 땐 호출 부분이 사전 검사를 실시하게 수정하자


[BEFORE]
```java
double getValueForPeriod (int periodNumber) {
    try {
        return values[periodNumber];    
    } catch (ArrayIndexOutOfBoundsException e) {
        return 0;    
    }
}
```
[AFTER]
```java
double getValueForPeriod (int periodNumber) {
    if (periodNumber >= values.length) return 0;
    return values[periodNumber];
}
```
### 동기
- 예외 처리를 조건문 대용으로 사용해선 안된다.






















