package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    // static, final 키워드를 활용한 이유
    // 원주율은 변하지 않는 상수이기 때문에 final static 사용함(수정불가, 선언없이 사용가능)
    private static final double PI = 3.141;

    // 생성자를 통해 연산 결과를 저장하는 컬렉션 필드 초기화
    public Calculator() {
        this.resultQueue = new LinkedList<>();
        this.circleAreaQueue = new LinkedList<>();
    }
    private Queue<Double> resultQueue;

    private Queue<Double> circleAreaQueue;

    public Queue<Double> getCircleArea() {
        return circleAreaQueue;
    }

    public void setCircleArea(Queue<Double> circleAreaQueue) {
        this.circleAreaQueue = circleAreaQueue;
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

    public void inquiryCircleResults() {
        int i = 1;
        // 향상된 for문을 활용해 결과값 출력
        for (double R : circleAreaQueue) {
            System.out.println(i+"번째 원의 넓이 결과값 = "+R);
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


        return result;
    }

    public double calculateCircleArea(double rad){
        return rad*rad*PI;
    }


}
