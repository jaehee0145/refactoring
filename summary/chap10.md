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


