# Chapter 06 메서드 정리

### 메서드 추출 Extract Method
- 어떤 코드를 그룹으로 묶어도 되겠다고 판단될 때 그 코드를 빼내어 목적을 잘 나타내는 직관적 이름의 메서드로 만들자.  

**[BEFORE]**
```java
void printOwing(double amount) {
    printBanner();

    // 세부 정보 출력
    System.out.println("name: " + _name);
    System.out.println("amount: " + amount);
}
```

**[AFTER]**
```java
void printOwing(double amount){
    printBanner();
    printDetails(amount);
}

void printDetails(double amount) {
    System.out.println("name: " + _name);
    System.out.println("amount: " + amount);
}
```
**동기**
- 제일 많이 사용되는 기법. 메서드가 너무 길거나 코드에 주석을 달아야만 의도를 이해할 수 있을때 사용  
- 직관적인 이름의 간결한 메서드가 좋은 이유
  - 다른 메서드에서 쉽게 사용할 수 있다. 
  - 상위 계층의 메서드에서 주석 같은 더 많은 정보를 읽어들일 수 있다.
  - 재정의하기도 훨씬 수월하다.

**방법**
- 목적에 부합하는 이름의 새 메서드를 생성 (원리가 아니라 기능을 나타내는 이름)
- 기존 메서드에서 빼낸 코드를 새로 생성한 메서드로 복사
- 빼낸 코드에서 기존 메서드의 모든 지역변수 참조를 찾아 새 메서드의 지역변수나 매개변수로 수정
- 빼낸 코드 안에서만 사용하는 임시 변수가 있다면 새로 선언
- 추출 코드에 의해 변경되는 지역변수가 있는지 파악
- 빼낸 코드에서 읽어들인 지역변수를 대상 메서드에 배개변수로 전달 
- 컴파일 테스트 

### 메서드 내용 직접 삽입 Inline Method
- 메서드 기능이 너무 단순해서 메서드명만 봐도 너무 뻔할 땐 그 메서드의 기능을 호출하는 메서드에 넣어버리고 그 메서드는 삭제

**[BEFORE]**
```java
int getRating() {
    return (moreThanFiveLateDelivers()) ? 2 : 1;
}
boolean moreThanFiveLateDelivers() {
    return _numberOfLateDelivers > 5;
}
```

**[AFTER]**
```java
int getRating() {
    return (_numberOfLateDelivers > 5) ? 2 : 1;
```

**동기**
- 메서드명에 모든 기능이 반영될 정도로 메서드 기능이 자나치게 단순할 때는 삭제

**방법**
- 메서드가 재정의되어 있지 않은지 확인
  - 없어진 메서드를 재정의하는 일이 생기면 안되니까
- 메서드 호출 하는 부분을 모두 찾자
- 각 호출 부분을 메서드 내용으로 교체
- 테스트 
- 메서드 정의 삭제  

### 임시변수 내용 직접 삽입 Inline Temp
- 간단한 수식을 대입받는 임시변수로 인해 다른 리팩토링 기법 적용이 힘들 땐 그 임시변수를 참조하는 부분을 수식으로 치환하자

**[BEFORE]**
```java
double basePrice = anOrder.basePrice();
return (basePrice > 1000)
```

**[AFTER]**
```java
return (anOrder.basePrice() > 1000)
```

**동기**
- 임시변수 내용 직접 삽입은 입시변수를 메서드 호출로 전환 기법을 실시하는 도중에 병용하게 되는 경우가 보통

**방법**
- 대입문의 우변에 문제가 없는지 확인  
- 문제가 없다면 임시변수를 final로 선언하고 컴파일  
- 임시변수를 참조하는 부분을 찾아서 대입문 우변의 수식으로 바꾸자.
- 컴파일, 테스트 
- 임시변수 선언과 대입문을 삭제  
- 컴파일, 테스트 

### 임시변수를 메서드 호출로 전환 Replace Temp With Query
- 수식의 결과를 저장하는 임시변수가 있을 땐 그 수식을 빼내어 메서드로 만든 후, 임시변수 찹조 부분을 전부 수식으로 교체

**[BEFORE]**
```java
double basePrice = _quantity * _itemPrice;
if (basePrice > 1000) {
    return basePrice * 0.95;
} else {
    return basePrice * 0.95;
}
```

**[AFTER]**
```java
if (basePrice() > 1000) {
    return basePrice() * 0.95;
} else {
    return basePrice() * 0.95;
}
private double basePrice() {
    return _quantity * _itemPrice
}
```

**동기**
- 임시변수는 일시적이고 국소적 범위로 제한된다는 단점이 있다.
- 메서드 호출로 수정하면 클래스 안 모든 메서드가 그 정보에 접근할 수 있다. 
- 지역변수가 많을수록 메서드 추출이 힘들어지므로 보통 메서드 추출을 적용하기 전에 하게된다. 

**방법**
- 값이 한 번만 대입되는 임시변수를 찾자
  - 값이 여러 번 대입되는 임시변수가 있으면 임시변수 분리 기법을 고려
- 그 임시변수를 final로 선언
- 컴파일 (이것으로 임시변수에 값을 한 번만 대입할 수 있다.)
- 대입문 우변을 빼내어 메서드로 만들자
  - 처음엔 메서드를 private으로 선언, 호출 범위가 넓어지면 접근 제한을 완화하기
  - 추출 메서드에 문제가 없는지 (즉, 객체를 변경하진 않는지) 확인하자. 만약 객체 변경 등의 문제가 있으면 상태변경 메서드와 값 반환 메서드를 분리기법 실시
- 컴파일, 테스트
- 임시변수를 대상으로 임시변수 내용 직접 삽입 기법을 실시 

### 직관적 임시변수 사용 Introduce Explaining Variable
- 사용된 수식이 복잡할 땐 수식의 결과나 수식의 일부분을 용도에 부합하는 직관적 이름의 임시변수에 대입하자

**[BEFORE]**
```java
if ((platform.toUpperCase().indexOf("MAC") > -1) &&
        browser.toUpperCase().indexOf("IE") > -1) &&
        wasInitialized() && resize > 0 ) {
    //   기능 코드
}
```

**[AFTER]**
```java
final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
final boolean wasResized = resize > 0;
if (isMacOs && isIEBrowser && wasInitialized() && wasResized) {
    //   기능 코드
}
```

**동기**
- 수식이 너무 복잡해서 이해하기 힘들면 임시변수를 사용
- 되도록이면 사용을 자제하고 메서드 추출을 사용하는 것이 좋다.


**방법**
- 임시변수를 final로 선언하고, 복잡한 수식에서 한 부분의 결과를 임시변수에 대입
- 수식에서 한 부분의 결과를 임시변수 값으로 교체
- 컴파일, 테스트
- 다른 부분을 대상으로 반복  

### 임시변수 분리 Split Temporary Variable
- 루프 변수나 값 누적용 임시변수가 아닌 임시변수에 여러 번 값이 대입될 땐 각 대입마다 다른 임시변수를 사용하자.

**[BEFORE]**
```java
double temp = 2 * (height + width);
System.out.println(temp);
temp = height * width;
System.out.println(temp);
```

**[AFTER]**
```java
final double perimeter = 2 * (height + width);
System.out.println(perimeter);
final doublie area = height * width;
System.out.println(area);
```

### 매개변수로의 값 대입 제거 Remove Assignments to Parameters
- 매개변수로 값을 대입하는 코드가 있을 때 매개변수 대신 임시변수를 사용하게 수정하자.

**[BEFORE]**
```java
int discount (int inputVal, int quantity, int yearToDate) {
    if (inputVal > 50) inputVal -= 2;
}
```

**[AFTER]**
```java
int discount (int inputVal, int quantity, int yearToDate) {
    int result = inputVal;
    if (inputVal > 50) result -= 2;
}
```

**동기**
 ```java
void aMethod(Object foo) {
    foo.modifyInSomeWay();  // ok
    foo = anotherObject;    // not ok - foo의 값에 다른 객체 참조를 대입
}
```
- 전달받은 매개변수에 다른 객체 참조를 대입하면 
  - 코드의 명료성이 떨어진다.
  - '값을 통한 전달'과 '참조를 통한 전달'을 혼동하게 된다.
    - 자바는 '값을 통한 전달'만 사용한다.
      - 값을 통한 전달: 어떠한 매개변수 값 변화도 호출한 루틴에 반영되지 않는다. ??
  - 메서드 안의 코드 자체도 혼동된다.
    - 용도의 일관성

**방법**
- 매개변수 대신 사용할 임시변수를 선언
- 매개변수 값을 대입하는 코드 뒤에 나오는 매개변수 참조를 전부 임시변수로 수정
- 매개변수로의 값 대입을 임시변수로의 값 대입으로 수정
- 컴파일, 테스트














