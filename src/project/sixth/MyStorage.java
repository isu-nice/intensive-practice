package sixth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyStorage {
    private static final String SYSTEM = "[System] ";
    private static final String CLEAR = "[Clear] ";
    private static final String POINT = "> ";
    private static final String CONTOUR = "-".repeat(30);
    private static final int REGISTER_QUANTITY = 5;

    static Map<String, Integer> products = new HashMap<>();

    // main() 메서드는 점장님의 이름을 인자(args)로 전달 받습니다.
    public static void main(String[] args) {
        // 해당 프로그램의 버전, 점장님의 이름, 프로그램의 기능을 출력합니다.
        //TODO:
        View.printProgramInfo();
        // 위에서 정의한 메서드들을 알맞게 배치하여 줍니다.
        // 사용자의 기능 입력을 받기 위한 Scanner() 메서드를 사용합니다.
        Scanner scanner = new Scanner(System.in);

        // 프로그래밍 요청사항 6번을 확인해 보세요.
        // 사용자가 특정 번호를 입력하기 전 까지 프로그램은 종료되지 않도록 합니다.

        // 사용자의 입력에 따라 프로그램의 기능들이 실행될 수 있도록 합니다.
        // switch() 를 사용하여 줍니다.

        while (true) {
            View.showMenu();
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
                    prod_amount_decrease(scanner, products);
                    break;
                case 5:
                    prod_search();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }

    // 6. 프로그램 종료
    private static void exit() {
        System.out.println(SYSTEM + "프로그램을 종료합니다.");
        System.out.println(SYSTEM + "감사합니다.");
        System.exit(0);
    }

    // 5. 재고 조회
    private static void prod_search() {
        printProductNamesAndAmount();
    }

    // 4. 제품 출고
    private static void prod_amount_decrease(Scanner scanner, Map<String, Integer> products) {
        System.out.println(SYSTEM + "제품의 출고를 진행합니다.");
        printProductNamesAndAmount();

        System.out.print(SYSTEM + "출고를 진행할 제품명을 입력하세요 : ");
        String productName = scanner.next();
        System.out.print(SYSTEM + "원하는 출고량을 입력하세요 : ");
        int productAmount = scanner.nextInt();

        products.put(productName, products.get(productName) - productAmount);
        System.out.println(CLEAR + "정상적으로 출고되었습니다.");
        printProductNamesAndAmount();
        System.out.println(CONTOUR);
    }

    // 3. 제품 입고
    private static void prod_amount_add(Scanner scanner) {
        System.out.println(SYSTEM + "물건의 수량을 추가합니다.(입고)");
        printProductNamesAndAmount();

        System.out.print(SYSTEM + "수량을 추가할 제품명을 입력하세요 : ");
        String productName = scanner.next();
        System.out.print(SYSTEM + "추가할 수량을 입력하세요 : ");
        int productAmount = scanner.nextInt();

        products.put(productName, products.get(productName) + productAmount);
        System.out.println(CLEAR + "정상적으로 제품의 수량 추가가 완료되었습니다.");
        printProductNamesAndAmount();
        System.out.println(CONTOUR);
    }

    // 2. 제품명 등록 취소
    private static void prod_remove(Scanner scanner) {
        System.out.print(SYSTEM + "제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String productName = scanner.next();
        products.remove(productName);
        System.out.println(CLEAR + "제품 취소가 완료되었습니다.");
    }

    // 1. 제품명 등록
    private static void prod_input(Scanner scanner) {
        System.out.print(SYSTEM + "제품 등록을 원하는 제품명을 입력하세요 : ");
        String productName = scanner.next();
        products.put(productName, 0);
        System.out.println(CLEAR + "등록이 완료되었습니다.");
        printProductNames();
    }

    private static void printProductNames() {
        System.out.println(SYSTEM + "현재 등록된 제품 목록 ▼");

        for (String name : products.keySet()) {
            System.out.println(POINT + name);
        }

        int count = products.size();
        while (count < REGISTER_QUANTITY) {
            System.out.println(POINT + "등록 가능");
            count++;
        }
        System.out.println(CONTOUR);
    }

    private static void printProductNamesAndAmount() {
        System.out.println(SYSTEM + "현재 등록된 제품 및 수량 ▼");

        for (String name : products.keySet()) {
            System.out.print(POINT + name + " : ");
            System.out.println(products.get(name) + "개");
        }

        int count = products.size();
        while (count < REGISTER_QUANTITY) {
            System.out.println(POINT + "등록 가능 : 0 개");
            count++;
        }
    }

    // selectMenu() 메서드는 사용자가 프로그램의 기능을 선택할 수 있도록 합니다.
    // 인자는 입력을 받기 위한 Scanner 클래스의 객체(s) 를 전달받습니다.
    static int selectMenu(Scanner scanner) {
        // 해당 메서드가 호출되면 프로그램의 기능을 호출할 수 있도록 안내 메시지를 출력합니다.
        //TODO:
        // 프로그램의 기능은 번호(정수)로 전달받습니다.
        // 해당 프로그램은 사용자가 선택한 번호(select)를 반환하도록 합니다.
        System.out.print(SYSTEM + "원하는 기능의 번호를 입력하세요 : ");
        return scanner.nextInt();
    }
}