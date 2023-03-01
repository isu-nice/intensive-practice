package java_basic.sixth;

public class View {
    private static final String CONTOUR = "-".repeat(30);
    private static final String SYSTEM = "[System] ";

    // 프로그램 정보 출력
    public static void printProgramInfo() {
        System.out.println("[Item_Storage_V3]");
        System.out.println(CONTOUR);
        System.out.printf(SYSTEM + "%s 점장님 어서오세요\n", "코드스테이츠");
        System.out.println(SYSTEM + "해당 프로그램의 기능입니다.");
    }

    // showMenu() 메서드가 호출되면 프로그램의 기능들을 보여줄 수 있도록 정의합니다.
    public static void showMenu() {
        // 사용자를 위해 해당 기능들 앞에 번호를 넣어 알아보기 쉽도록 합니다.
        System.out.println("1. 물건 정보(제품명) 등록하기");
        System.out.println("2. 물건 정보(제품명) 등록 취소하기");
        System.out.println("3. 물건 넣기 (제품 입고)");
        System.out.println("4. 물건 빼기 (제품 출고)");
        System.out.println("5. 재고 조회");
        System.out.println("6. 프로그램 종료");
        System.out.println(CONTOUR);
    }
}
