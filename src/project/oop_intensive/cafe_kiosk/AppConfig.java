package oop_intensive.cafe_kiosk;

import oop_intensive.cafe_kiosk.discount.BEDiscountPolicy;
import oop_intensive.cafe_kiosk.discount.DiscountPolicy;

public class AppConfig {

    public DiscountPolicy discountPolicy() {
        return new BEDiscountPolicy(20);
    }
}
