package chap07;

import java.util.Date;

public class IntroduceLocalExtension {

    // 새 클래스를 원본 Date 클래스의 하위 클래스로 작성
    class mfDateSub extends Date {
        // 원본 Date 클래스의 생성자는 간단한 위임을 통해 다음과 같이 반복시켜야 한다.
        public mfDateSub (String dateString) {
            super (dateString);
        }
        // 원본 Date 클래스를 인자로 받는 변환 생성자 추가
        public mfDateSub (Date arg) {
            super (arg.getTime());
        }
    }

    // 래퍼 클래스
    class mfDateWrap {
        private Date original;
    }
}
