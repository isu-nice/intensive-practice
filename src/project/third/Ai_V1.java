package third;

import java.util.Scanner;

public class Ai_V1 {
    private static final String SYSTEM = "[System]";
    private static final String INFO = "[안내]";
    private static final int A = 2;
    private static final int B = 1;

    public static void main(String[] args) {
        //TODO:
        // 사용자의 입력을 받기 위한 Scanner 객체를 생성합니다.

        // 시스템 프로그램 안내 출력문을 정의합니다.
        System.out.println("[인공지능 프로그램 V1]");
        System.out.println("=".repeat(30));
        // 수식에 필요한 변수를 먼저 정의하여 줍니다. (※ 수식과 똑같은 변수명으로 정의 )
        int advertisingFee = inputAdvertisingFee();
        // 안내 사항에 나온 것 처럼 임의의 값으로 정의합니다.
        System.out.printf(INFO + " 입력된 광고비는 %d 원 입니다.", advertisingFee);
        System.out.println();
        // 웹 페이지 방문자 수를 예측하기 위한 수식을 코드로 정의합니다.
        int visitorNumber = (A * advertisingFee) + B;

        // 결과로 나온 값은 printf()를 통해 출력합니다.
        System.out.printf(INFO + " AI의 예측(클릭 수)은  %d회 입니다.", visitorNumber);
    }

    private static int inputAdvertisingFee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(SYSTEM + " 예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) : ");
        int advertisingFee = scanner.nextInt();

        scanner.close();
        return advertisingFee;
    }
}