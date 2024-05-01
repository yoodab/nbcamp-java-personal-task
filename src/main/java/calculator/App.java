package calculator;

import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InvalidOperatorException, DivideByZeroException {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator ariCa = new ArithmeticCalculator(new AddOperator(), new SubtractOperator(),
                                        new MultiplyOperator(), new DivideOperator());
        CircleCalculator cirCa = new CircleCalculator();

        while (true) {
            // 사칙연산을 할지 계산을 할지 선택
            System.out.println("계산 방식을 선택해주세요 (원의 넓이 : cir ,계산기 : cal)");
            String resp = sc.next();


            if (resp.equals("cal")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                ariCa.setNumOperator(num1, num2, operator);
                double result = ariCa.calculate();

                //결과 출력
                System.out.println("결과: " + result);

                // 결과값 resultQueue에 저장
                Queue<Double> currentResultQueue = ariCa.getResultQueue();
                currentResultQueue.offer(result);
                ariCa.setResultQueue(currentResultQueue);

                // 삭제 여부 묻고 remove 입력 시 삭제
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String remove = sc.next();
                if (remove.equals("remove")) {
                    // 큐로 먼저 가장 먼저 저장된 연산 결과 제거
                    ariCa.removeResult();
                }

                // 저장된 연산결과 조회할지 묻고 inquiry 입력 시 조회
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.next();
                if (inquiry.equals("inquiry")) {
                    ariCa.inquiryResults();
                }


                // 종료 여부 묻고 exit 입력 시 종료
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exit = sc.next();
                if (exit.equals("exit")) {
                    break;
                }
            } else if (resp.equals("cir")) {
                System.out.print("반지름을 입력하세요: ");
                double rad = sc.nextInt();
                cirCa.setRad(rad);
                double result = cirCa.calculate();
                //결과 출력
                System.out.println("결과: " + result);

                // 결과값 resultQueue에 저장
                Queue<Double> currentResultQueue = cirCa.getResultQueue();
                currentResultQueue.offer(result);
                cirCa.setResultQueue(currentResultQueue);

                // 저장된 원의 넓이 값들 바로 전체 조회
                cirCa.inquiryResults();


                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exit = sc.next();
                if (exit.equals("exit")) {
                    break;
                }

            } else {
                System.out.println("계산 방식을 잘못 입력하셨습니다.");
            }


        }

    }
}
