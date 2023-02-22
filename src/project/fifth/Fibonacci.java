package fifth;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        // 1단계. 프로그램 시작을 알리는 출력문 선언
        System.out.println("[안내]피보나치 수열 프로그램 시작.");
        // 사용자의 입력값 받기.
        final int number = inputFibonacciNumber();
        // 2단계. 피보나치 수열의 점화식 코드 작성
        // 피보나치 수열의 첫 번째와 두 번째 값을 변수로 정의합니다.
        final int firstNum = 1;
        final int secondNum = 1;
        // 피보니치 수열이 저장될 배열 객체 선언
        int[] fibonacci = new int[number];
        // 피보나치 수열의 첫 번째, 두 번째 값 할당
        fibonacci[0] = firstNum;
        fibonacci[1] = secondNum;
        // 반복문을 통한 피보나치 수열 점화식 작성
        // 해당 점화식은 첫 번째와 두 번째는 구할 필요 없기에 이를 고려한 반복문의 조건식을 작성합니다.
        // 피보나치 수열의 점화식은 n+2번 째 부터 구현.
        // 피보나치 수열의 n+2번 째 값은 (n + n+1)를 통해 구할 수 있습니다.
        for (int i = 2; i < number; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        // 3단계.
        // 결과 출력을 위한 안내 문구 출력 입니다.
        // 피보나치 수열은 fibonacci 배열에 들어가 있기에 이를 반복문을 통해 호출
        printFibonacci(fibonacci);
        System.out.println("[안내]프로그램을 종료합니다.");
    }

    private static void printFibonacci(int[] fibonacci) {
        System.out.println("[피보나치 수열 출력]");
        for (int number : fibonacci) {
            System.out.println(number);
        }
    }

    private static int inputFibonacciNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
        int number = scanner.nextInt();

        scanner.close();
        return number;
    }
}