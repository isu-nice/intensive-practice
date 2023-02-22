package project.sixth;

import jdk.jshell.Snippet;

import java.util.Scanner;

public class MyStorage {
    public static int currentItemNumber = 0;
    public static final int NUM_OF_ITEM = 5;
    // showMenu() 메서드가 호출되면 프로그램의 기능들을 보여줄 수 있도록 정의합니다.
    static void showMenu(){
        // 사용자를 위해 해당 기능들 앞에 번호를 넣어 알아보기 쉽도록 합니다.
        //TODO:
        System.out.println("------------------------------\n" +
                "1. 물건 정보(제품명) 등록하기\n" +
                "2. 물건 정보(제품명) 등록 취소하기\n" +
                "3. 물건 넣기 (제품 입고)\n" +
                "4. 물건 빼기 (제품 출고)\n" +
                "5. 재고 조회\n" +
                "6. 프로그램 종료\n" +
                "------------------------------");
    }

    static void showItems(String[] items, int[] volumes){
        System.out.println("[System] 현재 등록된 제품 목록 ▼");
        for(int i = 0; i<NUM_OF_ITEM;i++)
            System.out.println("> "+items[i]+" :    "+volumes[i]+"개");
    }

    // selectMenu() 메서드는 사용자가 프로그램의 기능을 선택할 수 있도록 합니다.
    // 인자는 입력을 받기 위한 Scanner 클래스의 객체(s) 를 전달받습니다.
    static int selectMenu(Scanner s){
        // 해당 메서드가 호출되면 프로그램의 기능을 호출할 수 있도록 안내 메시지를 출력합니다.
        //TODO:
        // 프로그램의 기능은 번호(정수)로 전달받습니다.
        // 해당 프로그램은 사용자가 선택한 번호(select)를 반환하도록 합니다.
        System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
        return s.nextInt();
    }
    static void itemRegister(String[] items, Scanner s){
        System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
        String itemName = s.next();
        if(NUM_OF_ITEM<=currentItemNumber){
            System.out.println("[System] 제품 등록이 불가능합니다.");
            return;
        }
        items[currentItemNumber++] = itemName;
        System.out.println("[System]등록이 완료됬습니다.");
        System.out.println("[System] 현재 등록된 제품 목록 ▼");
        for(int i = 0; i<NUM_OF_ITEM;i++)
            System.out.println("> "+items[i]);
    }

    static void itemDelete(String[] items, int[] volumes, Scanner s){
        System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String itemName = s.next();
        int num = searchItem(items, itemName);
        if(num == -1){
            System.out.println("[System] 존재하지 않는 제품명입니다.");
            return;
        }

        items[num] = "등록 가능";
        volumes[num] = 0;
        currentItemNumber--;
        System.out.println("[System] 제품 취소가 완료됬습니다.");
    }

    static int searchItem(String[] items, String item){
        for(int i = 0; i < currentItemNumber; i++)
            if(items[i].equals(item))
                return i;
        return -1;
    }

    static void store(String[] items, int[] volumes, Scanner s){
        System.out.println("[System] 물건의 수량을 추가합니다.(입고)");
        showItems(items, volumes);
        System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String itemName = s.next();
        if(searchItem(items, itemName)==-1) {
            System.out.println("[System] 존재하지 않는 제품명입니다.");
            return;
        }else{
            System.out.print("[System] 추가할 수량을 입력해주세요 : ");
            int numOfItem = s.nextInt();
            volumes[searchItem(items, itemName)] += numOfItem;
        }

        System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료되었습니다.");
        showItems(items, volumes);
    }

    static void release(String[] items, int[] volumes, Scanner s){
        System.out.println("[System] 제품의 출고를 진행합니다.");
        showItems(items, volumes);
        System.out.print("[System] 출고를 진행할 제품명을 입력하세요 : ");
        String itemName = s.next();
        int num = searchItem(items, itemName);
        if(num==-1) {
            System.out.println("[System] 존재하지 않는 제품명입니다.");
            return;
        }else{
            System.out.print("[System] 원하는 출고량을 입력하세요 :");
            int numOfItem = s.nextInt();
            if(numOfItem>volumes[num]){
                System.out.println("[System] 재고가 부족합니다.");
                return;
            }
            volumes[searchItem(items, itemName)] -= numOfItem;
        }

        System.out.println("[Clear] 출고가 완료되었습니다.");
        showItems(items, volumes);
    }
    // main() 메서드는 점장님의 이름을 인자(args)로 전달 받습니다.
    public static void main(String[] args){
        // 해당 프로그램의 버전, 점장님의 이름, 프로그램의 기능을 출력합니다.
        //TODO:
        System.out.println("[Item_Storage_V3]");
        System.out.println("[System] "+args[0]+"님 어서오세요.");
        System.out.println("[System] 해당 프로그램의 기능입니다.");
        // 위에서 정의한 메서드들을 알맞게 배치하여 줍니다.
        // 사용자의 기능 입력을 받기 위한 Scanner() 메서드를 사용합니다.

        String[] items = new String[NUM_OF_ITEM];
        for(int i = 0; i<NUM_OF_ITEM; i++)
            items[i] = "등록 가능";
        int[] volumes = new int[NUM_OF_ITEM];

        Scanner sc = new Scanner(System.in);
        while(true){
            // 프로그래밍 요청사항 6번을 확인해 보세요.
            // 사용자가 특정 번호를 입력하기 전 까지 프로그램은 종료되지 않도록 합니다.
            showMenu();
            // 사용자의 입력에 따라 프로그램의 기능들이 실행될 수 있도록 합니다.
            // switch() 를 사용하여 줍니다.
            switch (selectMenu(sc)){
                case 1 : //물건등록
                    itemRegister(items, sc);
                    break;
                case 2 : //물건등록취소
                    itemDelete(items, volumes, sc);
                    break;
                case 3 : //제품 입고
                    store(items, volumes, sc);
                    break;
                case 4 : //제품 출고
                    release(items, volumes, sc);
                    break;
                case 5 : //재고 조회
                    showItems(items, volumes);
                    break;
                case 6 :
                    System.exit(1);
                default:
                    System.out.println("없는 번호입니다.");
            }

        }

    }
}
