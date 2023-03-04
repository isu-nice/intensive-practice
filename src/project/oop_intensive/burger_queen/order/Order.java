package oop_intensive.burger_queen.order;

import oop_intensive.burger_queen.discount.discountCondition.CozDiscountCondition;
import oop_intensive.burger_queen.discount.discountCondition.KidDiscountCondition;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder() {
        CozDiscountCondition cozDiscountCondition = new CozDiscountCondition();
        KidDiscountCondition kidDiscountCondition = new KidDiscountCondition();

        cozDiscountCondition.checkDiscountCondition();
        kidDiscountCondition.checkDiscountCondition();

        int totalPrice = cart.computeTotalPrice();
        int finalPrice = totalPrice;

        if (cozDiscountCondition.isSatisfied()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);
        if (kidDiscountCondition.isSatisfied()) finalPrice = kidDiscountCondition.applyDiscount(finalPrice);

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItems();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", finalPrice);
    }
}
