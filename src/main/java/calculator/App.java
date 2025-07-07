package calculator;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] db = new int[10];
        int curIdx = 0;

        while (true) {
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
            }

            System.out.println("결과: " + result);
            db[curIdx] = result;
            curIdx++;

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            sc.nextLine();
            String command = sc.nextLine();

            if (command.equals("exit")) {
                break;
            }
        }

        sc.close();
    }
}
