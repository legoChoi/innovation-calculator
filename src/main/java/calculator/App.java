package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> db = new ArrayList<>();
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int a = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);

            int result = calculator.calculate(a, b, op);

            System.out.println("결과: " + result);
            db.add(result);

            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");
            sc.nextLine();
            
            if (sc.nextLine().equals("remove")) {
                db.remove(0);
            }

            System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

            if (sc.nextLine().equals("inquiry")) {
                for (int i : db) {
                    System.out.print(i + " ");
                }

                System.out.println();
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");

            if (sc.nextLine().equals("exit")) {
                break;
            }

            System.out.println();
        }


        sc.close();
    }
}
