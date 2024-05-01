package calculator;

import java.util.LinkedList;
import java.util.Queue;

abstract class Calculator {

    private Queue<Double> resultQueue;

    public Calculator() {
        this.resultQueue = new LinkedList<>();
    }


    abstract double calculate() throws DivideByZeroException, InvalidOperatorException;


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



}
