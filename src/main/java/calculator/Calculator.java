package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Queue<Double> resultQueue;

    // 생성자를 통해 연산 결과를 저장하는 컬렉션 필드 초기화
    public Calculator() {
        this.resultQueue = new LinkedList<>();
    }

    public Queue<Double> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public void removeResult() {
        Double removeNum = resultQueue.poll();
        System.out.println("가장 먼저 저장된 연산 결과 " + removeNum + "이 삭제되었습니다.");
    }
    public void inquiryResults() {
        int i = 1;
        // 향상된 for문을 활용해 결과값 출력
        for (double R : resultQueue) {
            System.out.println(i+"번째 결과값 = "+R);
            i++;
        }
    }

    public double calculate(double num1, double num2, char operator) throws DivideByZeroException, InvalidOperatorException {
        double result = 0;
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

        // 연산 결과를 저장하는 컬렉션 필드에 추가
        resultQueue.offer(result);


        return result;
    }
}
