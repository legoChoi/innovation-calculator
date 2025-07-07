package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int a = sc.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int b = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char op = sc.next().charAt(0);

        int result = 0;

        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                result = a / b;
                break;
            default:
                System.out.println("잘못된 연산자 입니다.");
        }

        System.out.println("결과: " + result);

        sc.close();
    }
}
