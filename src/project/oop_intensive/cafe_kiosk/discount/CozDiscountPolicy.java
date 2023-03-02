package oop_intensive.cafe_kiosk.discount;

import java.util.Scanner;

public class CozDiscountPolicy implements DiscountPolicy{

    private int discountAmount;

    public CozDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    private boolean isCozStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("코드스테이츠 수강생이십니까? (1)예 (2)아니오");

        String input = scanner.nextLine();
        return input.equals("1");
    }

    private int computeDiscountPrice(int price) {
        return price - discountAmount;
    }

    @Override
    public int discount(int price) {
        if(isCozStudent()){
            return computeDiscountPrice(price);
        }
        return price;
    }
}
