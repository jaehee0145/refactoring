package chap08;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DuplicateObservedData {

    class IntervalWindow extends Frame {
        TextField startField;
        TextField endField;
        TextField lengthField;

        class SymFocus extends FocusAdapter {
            public void focusLost(FocusEvent event) {
                Object object = event.getSource();
                if (object == startField) {
                    StartField_FocusLost(event);
                } else if (object == endField) {
                    EndField_FocusLost(event);
                } else if (object == lengthField) {
                    LengthField_FocusLost(event);
                }
            }

            void StartField_FocusLost(FocusEvent event) {
                if (isNotInteger(startField.getText())) {
                    startField.setText("0");
                }
                calculateLength();
            }
            void EndField_FocusLost(FocusEvent event) {
                if (isNotInteger(endField.getText())) {
                    endField.setText("0");
                }
                calculateLength();
            }

            private void calculateLength() {
                try {
                    int start = Integer.parseInt(startField.getText());
                    int end = Integer.parseInt(endField.getText());
                    int length = end - start;
                    lengthField.setText(String.valueOf(length));
                 } catch (NumberFormatException e) {
                    throw new RuntimeException("잘못된 숫자 형식");
                }
             }

            void LengthField_FocusLost(FocusEvent event) {
                if (isNotInteger(lengthField.getText())) {
                    lengthField.setText("0");
                }
                calculateEnd();
            }

            private boolean isNotInteger(String text) {
                return false;
            }

            private void calculateEnd() {
                try {
                    int start = Integer.parseInt(startField.getText());
                    int length = Integer.parseInt(lengthField.getText());
                    int end = start + length;
                    endField.setText(String.valueOf(end));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("잘못된 숫자 형식");
                }
            }
        }
    }
}
