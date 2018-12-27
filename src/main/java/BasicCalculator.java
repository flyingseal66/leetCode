package main.java;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        // state
        final String START_STATE = "0";
        final String NUMBER_STATE = "1";
        final String OPERATION_STATE = "2";
        String STATE = "0";

        s = s.replace(" ", "");
        s = "(" + s +")";

        Stack<Integer> numStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        int number = 0;
        int calculateFlag = 0;

        // use state machine to split the string
        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            switch (STATE) {
                case START_STATE :
                    if (Character.isDigit(charI)) {
                        STATE = NUMBER_STATE;
                    } else {
                        STATE = OPERATION_STATE;
                    }
                    i --;
                    break;
                case NUMBER_STATE:
                    if (Character.isDigit(charI)) {
                        number = 10 * number + Integer.valueOf(charI);
                    } else {
                        if (charI == '(') {
                            continue;
                        }
                        numStack.add(number);
                        if (calculateFlag == 1) {
                            compute(numStack, operStack);
                        }
                        number = 0;
                        STATE = OPERATION_STATE;
                        i--;
                    }
                    break;
                case OPERATION_STATE:
                    if ('(' == charI) {
                        calculateFlag = 0;
                        STATE = NUMBER_STATE;
                    }
                    if ('+' == charI || '-' == charI) {
                        calculateFlag = 1;
                        operStack.add(String.valueOf(charI));
                    }
                    if (Character.isDigit(charI)) {
                        STATE = NUMBER_STATE;
                        i--;
                    }
                    if (charI == ')') {
                        compute(numStack, operStack);
                    }
                    break;
            }

        }

        return numStack.peek();
    }

    private void compute(Stack<Integer> intStack, Stack<String> strStack) {
            if (intStack.size() <= 1) {
                return;
            }
            int tempInt = 0;
            String oper = strStack.pop();
            int first = intStack.pop();
            int second = intStack.pop();
            if (oper.equals("+")) {
                tempInt = second + first;
            } else {
                tempInt = second - first;
            }
            intStack.add(tempInt);

    }


    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));

    }
}
