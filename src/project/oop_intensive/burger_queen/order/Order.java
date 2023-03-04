package oop_intensive.burger_queen.order;

import oop_intensive.burger_queen.discount.discountCondition.DiscountCondition;

import java.util.List;

public class Order {
    private Cart cart;
    private List<DiscountCondition> discountConditions;

    public Order(Cart cart, List<DiscountCondition> discountConditions) {
        this.cart = cart;
        this.discountConditions = discountConditions;
    }

    public void makeOrder() {

        int totalPrice = cart.computeTotalPrice();
        int finalPrice = totalPrice;

        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
            if (discountCondition.isSatisfied()) {
                finalPrice = discountCondition.applyDiscount(finalPrice);
            }
        }

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItems();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", finalPrice);
    }
}
