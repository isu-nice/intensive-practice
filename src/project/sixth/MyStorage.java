package sixth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyStorage {
    private static final String VERSION = "[Item_Storage_V3]";
    private static final String SYSTEM = "[System]";
    private static final String CLEAR = "[Clear]";
    private static final String CONTOUR = "-".repeat(30);
    private static final int REGISTER_QUANTITY = 5;

    static Map<String, Integer> products = new HashMap<>();

    // main() 메서드는 점장님의 이름을 인자(args)로 전달 받습니다.
    public static void main(String[] args) {
        // 해당 프로그램의 버전, 점장님의 이름, 프로그램의 기능을 출력합니다.
        //TODO:
        printProgramInfo();
        // 위에서 정의한 메서드들을 알맞게 배치하여 줍니다.
        // 사용자의 기능 입력을 받기 위한 Scanner() 메서드를 사용합니다.
        Scanner scanner = new Scanner(System.in);

        // 프로그래밍 요청사항 6번을 확인해 보세요.
        // 사용자가 특정 번호를 입력하기 전 까지 프로그램은 종료되지 않도록 합니다.

        // 사용자의 입력에 따라 프로그램의 기능들이 실행될 수 있도록 합니다.
        // switch() 를 사용하여 줍니다.

        while (true) {
            int number = selectMenu(scanner);

            switch (number) {
                case 1:
                    prod_input(scanner);
                    break;
                case 2:
                    prod_remove(scanner);
                    break;
                case 3:
                    prod_amount_add(scanner);
                    break;
                case 4:
                    prod_amount_remove(scanner);
                    break;
                case 5:
                    compute(scanner);
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("[ERROR] 잘못된 입력입니다.");
                    continue;
            }
        }
    }

    private static void compute(Scanner scanner) {

    }

    private static void exit() {

    }

    private static void prod_amount_remove(Scanner scanner) {

    }

    private static void prod_amount_add(Scanner scanner) {

    }

    private static void prod_remove(Scanner scanner) {

    }

    private static void prod_input(Scanner scanner) {
        System.out.print(SYSTEM + " 제품 등록을 원하는 제품명을 입력하세요 : ");
        String productName = scanner.next();
        System.out.println();
        products.put(productName, 0);
        System.out.println(SYSTEM + " 등록이 완료되었습니다.");
        printProductNames();
    }

    private static void printProductNames() {
        System.out.println(SYSTEM + " 현재 등록된 제품 목록 ▼");

        for (String name : products.keySet()) {
            System.out.println("> " + name);
        }

        int count = products.size();
        while (count < REGISTER_QUANTITY) {
            System.out.println("> 등록 가능");
            count++;
        }
        System.out.println(CONTOUR);
    }

    private static void printProgramInfo() {
        System.out.println(VERSION);
        System.out.println(CONTOUR);
        System.out.printf(SYSTEM + " %s 점장님 어서오세요\n", "코드스테이츠");
        System.out.println(SYSTEM + " 해당 프로그램의 기능입니다.");
        showMenu();
    }

    // showMenu() 메서드가 호출되면 프로그램의 기능들을 보여줄 수 있도록 정의합니다.
    static void showMenu() {
        // 사용자를 위해 해당 기능들 앞에 번호를 넣어 알아보기 쉽도록 합니다.
        System.out.println("1. 물건 정보(제품명) 등록하기");
        System.out.println("2. 물건 정보(제품명) 등록 취소하기");
        System.out.println("3. 물건 넣기 (제품 입고)");
        System.out.println("4. 물건 빼기 (제품 출고)");
        System.out.println("5. 재고 조회");
        System.out.println("6. 프로그램 종료");
        System.out.println(CONTOUR);
    }

    // selectMenu() 메서드는 사용자가 프로그램의 기능을 선택할 수 있도록 합니다.
    // 인자는 입력을 받기 위한 Scanner 클래스의 객체(s) 를 전달받습니다.
    static int selectMenu(Scanner scanner) {
        // 해당 메서드가 호출되면 프로그램의 기능을 호출할 수 있도록 안내 메시지를 출력합니다.
        //TODO:
        // 프로그램의 기능은 번호(정수)로 전달받습니다.
        // 해당 프로그램은 사용자가 선택한 번호(select)를 반환하도록 합니다.
        System.out.print(SYSTEM + " 원하는 기능의 번호를 입력하세요 : ");
        return scanner.nextInt();
    }
}