package calculator;

public class CircleCalculator extends Calculator {

    // static, final 키워드를 활용한 이유
    // 원주율은 변하지 않는 상수이기 때문에 final static 사용함(수정불가, 선언없이 사용가능)
    private static final double PI = 3.141;

    private double rad;

    @Override
    double calculate() throws InvalidOperatorException {
        return this.rad * this.rad * PI;
    }
    public void setRad(double rad) {
        this.rad = rad;
    }

}
