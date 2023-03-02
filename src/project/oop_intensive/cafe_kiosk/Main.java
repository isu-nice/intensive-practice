package oop_intensive.cafe_kiosk;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Kiosk kiosk = new Kiosk(appConfig.discountPolicy());
        kiosk.operate();
    }
}

/*
 * 커피, 차              : Coffee, Tea -> Product
 * 상품들의 목록 및 저장소 : ProductRepository
 * 할인 조건              : CozDiscountCondition
 * 프로그램의 메인 로직    : Kiosk
 * */
