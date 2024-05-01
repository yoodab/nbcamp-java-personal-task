package calculator;

public class ArithmeticCalculator extends Calculator {
    private int num1;
    private int num2;
    private char operator;

    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;

    public ArithmeticCalculator(AddOperator addOperator,SubtractOperator subtractOperator,
                                MultiplyOperator multiplyOperator,DivideOperator divideOperator){
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;

    }


    @Override
    double calculate() throws DivideByZeroException, InvalidOperatorException {
        int result = 0;
        switch (operator) {
            case '+':
                result = addOperator.operate(this.num1,this.num2);
                break;
            case '-':
                result = subtractOperator.operate(this.num1,this.num2);
                break;
            case '*':
                result = multiplyOperator.operate(this.num1,this.num2);
                break;
            case '/':
                // 두번째 정수가 0이 들어가는 경우
                if (this.num2 == 0) {
                    // 두번째 정수가 0이 들어가는 경우 DivideByZeroException 예외를 던집니다.
                    throw new DivideByZeroException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else {
                    result = divideOperator.operate(this.num1,this.num2);
                }
                break;
            default:
                // 잘못된 연산자 기호가 들어오는 경우 InvalidOperatorException 예외를 던집니다.
                throw new InvalidOperatorException("잘못된 연산자 기호가 입력되었습니다.");
        }
        return result;
    }



    public void setNumOperator(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
}
