package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 결과값을 저장하기 위한 큐 사용
        Queue<Double> resultQueue = new LinkedList<>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

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
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        result = num1 / num2;
                    }
                    break;

                // +, -, *, / 이외의 값이 들어오면 default로 가서
                // "사칙연산 기호를 잘못입력하였습니다." 출력
                default:
                    System.out.println("사칙연산 기호를 잘못입력하였습니다.");
                    break;
            }
            System.out.println("결과: " + result);

            // 결과값 resultQueue에 저장
            resultQueue.offer(result);

            // 삭제 여부 묻고 remove 입력 시 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("remove")) {
                // 큐로 먼저 가장 먼저 저장된 연산 결과 제거
                Double removeNum = resultQueue.poll();
                System.out.println("가장 먼저 저장된 연산 결과 " + removeNum + "이 삭제되었습니다.");
            }

            // 종료 여부 묻고 exit 입력 시 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                System.out.println("전체 결과값 = " + Arrays.toString(resultQueue.toArray()));
                break;
            }
        }

    }
}
