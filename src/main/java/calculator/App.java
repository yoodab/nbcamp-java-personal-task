package calculator;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InvalidOperatorException, DivideByZeroException {
        Scanner sc = new Scanner(System.in);
        Calculator ca = new Calculator();


        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            double result = ca.calculate(num1,num2,operator);

            System.out.println("결과: " + result);

            // 결과값 currentResultQueue에 추가후 setter로 resultQueue에 저장
            Queue<Double> currentResultQueue = ca.getResultQueue();
            currentResultQueue.offer(result);
            ca.setResultQueue(currentResultQueue);

            // 삭제 여부 묻고 remove 입력 시 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("remove")) {
                // 큐로 먼저 가장 먼저 저장된 연산 결과 제거
                Double removeNum = ca.getResultQueue().poll();
                System.out.println("가장 먼저 저장된 연산 결과 " + removeNum + "이 삭제되었습니다.");
            }

            // 저장된 연산결과 조회할지 묻고 inquiry 입력 시 조회
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.next();
            if (inquiry.equals("inquiry")) {
                int i = 1;
                // 향상된 for문을 활용해 결과값 출력
                for (double R : ca.getResultQueue()) {
                    System.out.println(i+"번째 결과값 = "+R);
                    i++;
                }
            }


            // 종료 여부 묻고 exit 입력 시 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                System.out.println("전체 결과값 = " + Arrays.toString(ca.getResultQueue().toArray()));
                break;
            }
        }

    }
}
