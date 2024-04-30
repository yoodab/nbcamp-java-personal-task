package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 결과값을 저장하기 위한 배열 선언
        double[] resultArr = new double[10];
        int index = 0;
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

            // index가 마지막 들어간 숫자의 index++이 되기 때문에
            // index == 10에 값을 넣어야하는 경우 숫자 하나를 지우고 추가함
            if (index == 10) {
                // 배열을 한개씩 당기고
                for (int i = 0; i < index-1; i++) {
                    resultArr[i] = resultArr[i + 1];
                }
                // resultArr[9]에 숫자를 넣는다
                resultArr[index-1] = result;
            } else {
                // resultArr에 index값에 맞춰 결과값을 넣어준다
                resultArr[index] = result;
                // index값 1 증가
                index++;
            }


            // 종료 여부 묻고 exit 입력 시 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                System.out.println("Arrays.toString(resultArr) = " + Arrays.toString(resultArr));
                break;
            }
        }

    }
}
