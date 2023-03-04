package oop_intensive.burger_queen;

import oop_intensive.burger_queen.discount.Discount;
import oop_intensive.burger_queen.discount.discountCondition.CozDiscountCondition;
import oop_intensive.burger_queen.discount.discountCondition.KidDiscountCondition;
import oop_intensive.burger_queen.discount.discountPolicy.FixedAmountDiscountPolicy;
import oop_intensive.burger_queen.discount.discountPolicy.FixedRateDiscountPolicy;
import oop_intensive.burger_queen.order.Cart;
import oop_intensive.burger_queen.order.Menu;
import oop_intensive.burger_queen.order.Order;
import oop_intensive.burger_queen.product.ProductRepository;

import java.util.List;

public class AppConfig {

    private Cart cart = new Cart(productRepository(), menu());

    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    public Menu menu() {
        return new Menu(productRepository().getProducts());
    }

    public Cart cart() {
        return cart;
    }

    public Discount discount() {
        return new Discount(List.of(
                new CozDiscountCondition(new FixedRateDiscountPolicy(10)),
                new KidDiscountCondition(new FixedAmountDiscountPolicy(500))

        ));
    }

    public Order order() {
        return new Order(cart(), discount());
    }
}
