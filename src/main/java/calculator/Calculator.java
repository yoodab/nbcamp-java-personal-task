package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Queue<Double> resultQueue = new LinkedList<>();

    public Queue<Double> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public double calculate(double num1, double num2, char operator) throws DivideByZeroException,InvalidOperatorException{
        double result=0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // 두번째 정수가 0이 들어가는 경우
                if (num2 == 0) {
                    // 두번째 정수가 0이 들어가는 경우 DivideByZeroException 예외를 던집니다.
                    throw new DivideByZeroException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                // 잘못된 연산자 기호가 들어오는 경우 InvalidOperatorException 예외를 던집니다.
                throw new InvalidOperatorException("잘못된 연산자 기호가 입력되었습니다.");
        }
        return result;
    }
}
