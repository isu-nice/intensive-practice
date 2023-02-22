package project.fifth;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        // 1단계. 프로그램 시작을 알리는 출력문 선언
        System.out.println("[안내]피보나치 수열 프로그램 시작.");
        // 사용자의 입력값 받기.

        int num = getUserInput();
        // 2단계. 피보나치 수열의 점화식 코드 작성
        // 피보나치 수열의 첫 번째와 두 번째 값을 변수로 정의합니다.
        // 피보니치 수열이 저장될 배열 객체 선언

        int[] fibArray = new int[num];
        // 피보나치 수열의 첫 번째, 두 번째 값 할당
        // 반복문을 통한 피보나치 수열 점화식 작성
        // 해당 점화식은 첫 번째와 두 번째는 구할 필요 없기에 이를 고려한 반복문의 조건식을 작성합니다.
        // 피보나치 수열의 점화식은 n+2번 째 부터 구현.
        // 피보나치 수열의 n+2번 째 값은 (n + n+1)를 통해 구할 수 있습니다.

        getFibonacci(fibArray);
        // 3단계.
        // 결과 출력을 위한 안내 문구 출력 입니다.
        // 피보나치 수열은 fibonacci 배열에 들어가 있기에 이를 반복문을 통해 호출

        printNumbers(fibArray);

        System.out.println("[안내]프로그램을 종료합니다.");
    }
    static int getUserInput(){
        System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    static void getFibonacci(int[] fibArray){
        int a = 1, b =1;
        fibArray[0] = 1;
        fibArray[1] = 1;

        for(int i = 2; i<fibArray.length;i++){
            fibArray[i] = a+b;
            a = b;
            b = fibArray[i];
        }
    }
    static void printNumbers(int[] fibArray){
        System.out.println("[피보나치 수열 출력]");

        for(int i =0; i<fibArray.length;i++)
            System.out.println(fibArray[i]);
    }
    static int fibo(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        return fibo(n-2)+fibo(n-1);
    }
}
