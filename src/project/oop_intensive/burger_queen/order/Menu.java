package oop_intensive.burger_queen.order;

import oop_intensive.burger_queen.product.Product;
import oop_intensive.burger_queen.product.subproduct.Burger;
import oop_intensive.burger_queen.product.subproduct.Drink;
import oop_intensive.burger_queen.product.subproduct.Side;

import java.util.List;

public class Menu {
    private List<Product> products;

    public Menu(List<Product> products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(40));

        printBurgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(40));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    protected void printDrinks(boolean printPrice) {
        System.out.println("🥤 음료");
        products.forEach(product -> {
            if (product instanceof Drink) {
                printEachProduct(product, printPrice);
            }
        });
        System.out.println();
    }

    protected void printSides(boolean printPrice) {
        System.out.println("🍟 사이드");
        products.forEach(product -> {
            if (product instanceof Side) {
                printEachProduct(product, printPrice);
            }
        });
        System.out.println();
    }

    private void printBurgers(boolean printPrice) {
        System.out.println("🍔 햄버거");
        products.forEach(product -> {
            if (product instanceof Burger) {
                printEachProduct(product, printPrice);
            }
        });
        System.out.println();
    }

    private void printEachProduct(Product product, boolean printPrice) {
        if (printPrice) {
            System.out.printf("   (%d) %s %5dKcal %5d원\n",
                    product.getId(), product.getName(), product.getKcal(), product.getPrice()
            );
        } else {
            System.out.printf("   (%d) %s %5dKcal\n",
                    product.getId(), product.getName(), product.getKcal()
            );
        }
    }
}
