package oop_intensive.cafe_kiosk.products;

import java.util.Scanner;

public class Tea extends Product{

    private boolean removeTeaBag;

    public Tea(int id, String name, int price, boolean removeTeaBag) {
        super(id, name, price);
        this.removeTeaBag = removeTeaBag;
    }

    private void setRemoveTeaBag(boolean removeTeaBag){
        this.removeTeaBag = removeTeaBag;
    }

    @Override
    public void applyOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("티백을 제거하시겠습니까? (1)예 (2)아니오");

        int option = Integer.parseInt(scanner.nextLine());
        if(option == 1) {
            setRemoveTeaBag(true);
        }
    }

    @Override
    public String getOptionToString() {
        if(removeTeaBag) {
            return "(티백 제거)";
        }
        return "";
    }
}
