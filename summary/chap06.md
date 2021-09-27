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
  - 상위 계층의 메서드에서 주석 같은 더 많은 정보를 읽어들일 수 있다. ??
  - 재정의하기도 훨씬 수월하다.

**방법**
- 목적에 부합하는 이름의 새 메서드를 생성 (원리가 아니라 기능을 나타내는 이름)
- 기존 메서드에서 빼낸 코드를 새로 생성한 메서드로 복사
- 빼낸 코드에서 기존 메서드의 모든 지역변수 참조를 찾아 새 메서드의 지역변수나 매개변수로 수정
- 빼낸 코드 안에서만 사용하는 임시 변수가 있다면 새로 선언
- 추출 코드에 의해 변경되는 지역변수가 있는지 파악 ??
- 빼낸 코드에서 읽어들인 지역변수를 대상 메서드에 배개변수로 전달 
- 컴파일 테스트 