package java_basic.fourth;

import java.util.Arrays;
import java.util.Scanner;

public class YoutubeSub {
    //TODO:
    /**
     * 관리자의 계정 정보는 다음과 같이 변하지 않도록 정의하여 줍니다.
     * static final 과 final static 은 차이가 없습니다.
     * 다만 static final 이 눈에 익숙합니다.
     * */

    /**
     * @static 은 별도의 객체 생성 없이 바로 사용이 가능 합니다.
     * 본 프로그램의 금칙어 리스트와 대체어 리스트를 배열로 정의합니다.
     */

    public static final String ID = "admin";
    public static final String PASSWORD = "0000";
    private static final String SYSTEM = "[시스템]";
    private static final String INFO = "[안내]";
    private static final String REPORT = "[알림]";
    public static final String ALERT = "[경고]";

    public static void main(String[] args) {
        // 사용자의 입력을 받기위한 Scanner s 객체 생성
        Scanner scanner = new Scanner(System.in);
        //TODO:
        /**
         * 시스템 로그인을 위한 아이디 및 비밀번호 입력 시스템을 정의 합니다.
         */
        System.out.print(SYSTEM + " 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
        String userId = scanner.nextLine();
        System.out.print(SYSTEM + " 유튜브 계정의 비밀번호를 입력하세요 {Ex - 0000} : ");
        String password = scanner.nextLine();

        // 사용자 입력에 따른 로그인 및 경고 문구 출력
        // 문자열 비교를 위해 equals() 활용
        // ID와 PW 모두 동일해야 하므로 AND(&&) 논리 연산자 활용   } else {
        // 로그인 정보가 다르다면 [경고] 문구 출력 및 조기 리턴
        if (!isCorrectAccount(userId, password)) {
            System.out.print(ALERT + " 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
            return;
        }

        printSubtitleGuide(userId);
        String subtitle = scanner.nextLine();
        /** 자막을 입력 받고 금칙어를 대체어로 전환하는 과정입니다.
         * @nextLine() 는 이전에 next() 메서드가 사용된 경우
         * 한번 더 nextLine() 메서드를 사용해 줘야 합니다.
         */

        // 금칙어를 대체어로 전환하는 과정은 다음과 같습니다.
        // 1. 금칙어 배열에서 하나씩 불러옵니다.
        final String[] forbiddenWords = {"킹", "시발", "꺼져", "미친"};
        final String[] substituteWords = {"열", "사랑", "용기", "희망"};
        printForbiddenWords(forbiddenWords);

        // 2. 해당 금칙어가 자막에 포함되어 있는지 확인합니다.
        // 3. 만약 포함되어 있다면 replace()를 통해 금칙어와 대체어를 전환하여 저장합니다.
        String refinedSubtitle = subtitle;
        for (int i = 0; i < forbiddenWords.length; i++) {
            if (refinedSubtitle.contains(forbiddenWords[i])) {
                refinedSubtitle = refinedSubtitle.replaceAll(forbiddenWords[i], substituteWords[i]);
            }
        }

        /**
         * 전환된 자막을 출력하여 줍니다.
         * 금칙어 또한 안내사항으로 출력하여 줍니다.
         * @Arrays.toString() : 배열에 저장된 문자열를 출력합니다.
         * */
        System.out.println(REPORT + " 자막 순화 프로그램 결과입니다.");
        System.out.printf(">>> %s", refinedSubtitle);
        System.out.println();
        System.out.println(INFO + " 프로그램을 종료합니다.");
    }

    private static boolean isCorrectAccount(String userId, String password) {
        return userId.equals(ID) && password.equals(PASSWORD);
    }

    private static void printSubtitleGuide(String userId) {
        System.out.println();
        System.out.printf(INFO + " 안녕하세요 %s님.", userId);
        System.out.println();
        System.out.println(INFO + " 유튜브 영상의 자막을 생성해 주세요");
    }

    private static void printForbiddenWords(String[] forbiddenWords) {
        System.out.println("=".repeat(40));
        System.out.println(REPORT + " 프로그램의 금칙어 리스트입니다.");
        System.out.println(Arrays.toString(forbiddenWords));
        System.out.println("=".repeat(40));
    }
}