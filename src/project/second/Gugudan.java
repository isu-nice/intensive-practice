package second;

import java.util.Scanner;

public class Gugudan {
    private static final int LEVEL_MIN = 2;
    private static final int LEVEL_MAX = 9;

    public static void main(String[] args) {
        //TODO:
        // 0. 구구단을 정의하기 전 구구단 연산을 위한 변수를 선언합니다.

        // 1. 단을 입력합니다.
        // 클래스에 포함된 메서드를 활용하기 위해 객체 생성
        // Scanner(클래스명) s(변수명) = new(객체 생성을 위한 키워드) Scanner(클래스명)(System.in);
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력을 받기 위한 안내 문구
        System.out.printf("[안내]희망하는 구구단을 숫자로 입력해 주세요 (%d ~ %d) : ", LEVEL_MIN, LEVEL_MAX);
        // 입력받은 값을 출력합니다.
        int inputLevel = scanner.nextInt();
        System.out.println();
        System.out.printf("%d단이 입력되었습니다.", inputLevel);
        System.out.println();
        // 2. 구구단은 2단에서 9단까지만 가능합니다.
        // 조건 1. 입력값이 min_gugudan(2)보다 작다.
        // 조건 2. 입력값이 max_gugudan(9)보다 크다.
        // 두 조건이 모두 참 인 경우를 판단하여 [경고] 문구 출력(OR 연산자 활용)
        if (isRightRange(inputLevel)) {
            printGugudanTable(inputLevel);
        } else {
            printErrorMessage();
        }

        scanner.close();
    }

    private static void printErrorMessage() {
        System.out.printf("[경고]구구단은 %d단 ~ %d단 까지만 선택할 수 있습니다.", LEVEL_MIN, LEVEL_MAX);
        System.out.println();
        System.out.println("프로그램을 종료합니다.");
    }

    private static boolean isRightRange(int level) {
        return level >= LEVEL_MIN && level <= LEVEL_MAX;
    }

    private static void printGugudanTable(int level) {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d", level, i, level * i);
            System.out.println();
        }
    }
}