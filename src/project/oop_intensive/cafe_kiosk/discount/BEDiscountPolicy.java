package oop_intensive.cafe_kiosk.discount;

import java.util.Scanner;

public class BEDiscountPolicy implements DiscountPolicy{
    private int discountRate;

    public BEDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    private boolean isBackEndStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("코드스테이츠 백엔드 코스 수강생이십니까? (1)예 (2)아니오");
        String input = scanner.nextLine();
        return input.equals("1");
    }

    private int computeDiscountPrice(int price) {
        return price - (price * discountRate / 100);
    }

    @Override
    public int discount(int price) {
        if(isBackEndStudent()){
            return computeDiscountPrice(price);
        }
        return price;
    }
}
