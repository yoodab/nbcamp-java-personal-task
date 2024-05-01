package calculator;

import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InvalidOperatorException, DivideByZeroException {
        Scanner sc = new Scanner(System.in);
        Calculator ca = new Calculator();



        while (true) {
            // 사칙연산을 할지 계산을 할지 선택
            System.out.println("계산 방식을 선택해주세요 (원의 넓이 : cir ,계산기 : cal)");
            String resp = sc.next();


            if(resp.equals("cal")){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                double result = ca.calculate(num1,num2,operator);
                //결과 출력
                System.out.println("결과: " + result);

                // 계산하는 메서드에 저장하는 기능 분리함
                // 결과값 resultQueue에 저장
                Queue<Double> currentResultQueue = ca.getResultQueue();
                currentResultQueue.offer(result);
                ca.setResultQueue(currentResultQueue);

                // 삭제 여부 묻고 remove 입력 시 삭제
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String remove = sc.next();
                if (remove.equals("remove")) {
                    // 큐로 먼저 가장 먼저 저장된 연산 결과 제거
                    ca.removeResult();
                }

                // 저장된 연산결과 조회할지 묻고 inquiry 입력 시 조회
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.next();
                if (inquiry.equals("inquiry")) {
                    ca.inquiryResults();
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
                double result = ca.calculateCircleArea(rad);
                //결과 출력
                System.out.println("결과: " + result);

                // 계산하는 메서드에 저장하는 기능 분리함
                // 결과값 resultQueue에 저장
                Queue<Double> currentResultQueue = ca.getCircleArea();
                currentResultQueue.offer(result);
                ca.setCircleArea(currentResultQueue);

                // 저장된 원의 넓이 값들 바로 전체 조회
                ca.inquiryCircleResults();


                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exit = sc.next();
                if (exit.equals("exit")) {
                    break;
                }

            }else{
                System.out.println("계산 방식을 잘못 입력하셨습니다.");
            }



        }

    }
}
