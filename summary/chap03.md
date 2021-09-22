# Chapter 03 코드의 구린내

### 중복 코드 Duplicated Code
- 똑같은 코드 구조가 두 군데 이상 있을 때는 그 부분을 하나로 통일  
- 예 1) 한 클래스의 두 메서드 안에 같은 코드가 들어 있는 경우
  - 메서드 추출 기법을 적용
- 예 2) 한 클래스의 두 하위 클래스에 같은 코드가 들어 있는 경우
  - 메서드 추출 + 메서드 상향 
  - 코드가 똑같지 않고 비슷하다면 메서드추출을 적용해서 같은 부분과 다른 부분을 분리

### 장황한 메서드 Long Method
### 방대한 클래스 Large Class
### 과다한 매개변수 Long Parameter List
### 수정의 산발 Divergent Change
### 기능의 산재 Shotgun Surgery
### 잘못된 소속 Feature Envy
### 데이터 뭉치 Data Clumps
### 강박적 기본 타입 사용 Primitive Obsession
### switch 문 Switch Statements
### 평행 상속 계층 Parallel Inheritance Hierarchies
### 직무유기 클래스 Lazy Class
### 막연한 범용 코드 Speculative Generality
### 임시 필드 Temporary Field
### 메시지 체인 Message Chains
### 과잉 중개 메서드 Middle Man
### 지나친 관여 Inappropriate Intimacy
### 인터페이스가 다른 대용 클래스 Alternative Classes with Different Interfaces
### 미흡한 라이브러리 클래스 Incomplete Library Class
### 데이터 클래스 Data Class
### 방치된 상속물 Refused Bequest
### 불필요한 주석 Comments 
