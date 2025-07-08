package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArithemeticCalculator<Double> arithemeticCalculator = new ArithemeticCalculator<>(
                new AddOperator<>(Double.class),
                new SubtractOperator<>(Double.class),
                new MultiplyOperator<>(Double.class),
                new DivideOperator<>(Double.class),
                new ModOperator<>(Double.class),
                Double.class
        );
        CircleCalculator<Double> circleCalculator = new CircleCalculator<>(Double.class);

        Scanner sc = new Scanner(System.in);
        double result;

        while (true) {
            System.out.print("어떤 계산을 진행하시겠습니까? (normal: 일반, circle: 원 넓이 구하기) ");
            String typeCommand = sc.nextLine();

            if (typeCommand.equals("normal")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double a = sc.nextDouble();

                System.out.print("두 번째 숫자를 입력하세요: ");
                double b = sc.nextDouble();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                arithemeticCalculator.setValues(a, b, op);

                result = arithemeticCalculator.calculate();
                System.out.println("결과: " + result);

                arithemeticCalculator.saveResult(result);

                sc.nextLine();

                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");

                if (sc.nextLine().equals("remove")) {
                    arithemeticCalculator.removeFirst();
                }

                System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

                if (sc.nextLine().equals("inquiry")) {
                    arithemeticCalculator.printList();
                }

                System.out.print("저장된 연산결과 중 보다 큰 값을 조회하시겠습니까? (bigger 입력 시 조회) ");

                if (sc.nextLine().equals("bigger")) {
                    System.out.print(">> ");
                    arithemeticCalculator.printBiggerListThan(sc.nextDouble());
                    sc.nextLine();
                }
            }

            if (typeCommand.equals("circle")) {
                System.out.print("반지름을 입력하세요: ");
                double radius = sc.nextInt();

                circleCalculator.setValues(radius);

                result = circleCalculator.calculate();
                System.out.println("결과: " + result);

                circleCalculator.saveResult(result);

                sc.nextLine();

                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");

                if (sc.nextLine().equals("remove")) {
                    circleCalculator.removeFirst();
                }

                System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

                if (sc.nextLine().equals("inquiry")) {
                    circleCalculator.printList();
                }

                System.out.print("저장된 연산결과 중 보다 큰 값을 조회하시겠습니까? (bigger 입력 시 조회) ");

                if (sc.nextLine().equals("bigger")) {
                    System.out.print(">> ");
                    circleCalculator.printBiggerListThan(sc.nextDouble());
                    sc.nextLine();
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
