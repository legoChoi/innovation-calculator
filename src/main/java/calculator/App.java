package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArithemeticCalculator arithemeticCalculator = new ArithemeticCalculator(
                new AddOperator(),
                new SubtractOperator(),
                new MultiplyOperator(),
                new DivideOperator()
        );
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in);
        double result;

        while (true) {
            System.out.print("어떤 계산을 진행하시겠습니까? (normal: 일반, circle: 원 넓이 구하기) ");
            String typeCommand = sc.nextLine();

            if (typeCommand.equals("normal")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int a = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                int b = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                arithemeticCalculator.setValues(a, b, op);

                result = arithemeticCalculator.calculate();
                System.out.println("결과: " + result);

                arithemeticCalculator.saveResult(result);

                sc.nextLine();

                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");

                if (sc.nextLine().equals("remove")) {
                    arithemeticCalculator.removeFirst(typeCommand);
                }

                System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

                if (sc.nextLine().equals("inquiry")) {
                    arithemeticCalculator.printList();
                }
            }

            if (typeCommand.equals("circle")) {
                System.out.print("반지름을 입력하세요: ");
                int radius = sc.nextInt();

                circleCalculator.setValues(radius);

                result = circleCalculator.calculate();
                System.out.println("결과: " + result);

                circleCalculator.saveResult(result);

                sc.nextLine();

                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");

                if (sc.nextLine().equals("remove")) {
                    circleCalculator.removeFirst(typeCommand);
                }

                System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

                if (sc.nextLine().equals("inquiry")) {
                    circleCalculator.printList();
                }
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
