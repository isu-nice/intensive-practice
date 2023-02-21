package project.third;


import java.util.Scanner;

public class Ai_V2 {
    public static void main(String[] args) {
        /*
         * 인공지능 예측에 필요한 변수를 정의합니다.
         * a,b    : 예측에 필요한 요소
         * x_list : 예측에 필요한 광고비 배열
         * y      : 예측한 결과값(웹 페이지 방문자 수)
         * y_list :
         */
        int a=2 , b=1;


        //TODO:

        // 사용자의 입력을 받기 위한 Scanner 객체를 생성합니다.
        Scanner sc = new Scanner(System.in);
        // 시스템 시작 안내 문구
        System.out.println("[인공지능 프로그램 V2]\n" + "==============================");
        // 이전 버전과 달리 다수의 '광고비'를 '배열'로 정의합니다.
        double[] x_list  = {580.0, 700.0, 810.0, 840.0};
        // 반복문을 활용하여 광고비 배열을 출력합니다.
        System.out.println("[안내] 입력된 '광고비'는 다음과 같습니다.");
        for(int i =0; i<x_list.length;i++)
            System.out.print(i+" 번째)"+x_list[i]+"    ");

        // 한 줄 띄기 및 예측 결과 안내 문구 출력
        System.out.println("\n");
        System.out.println("[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.\n");

        // 반복문을 활용해 다수의 광고비(x_list)를 호출하여 방문자 수 예측값을 연산합니다.
        for(int i =0; i<x_list.length;i++)
            System.out.println(i+ "번째 예측) "+a*x_list[i]+b+"회 방문");
    }
}
