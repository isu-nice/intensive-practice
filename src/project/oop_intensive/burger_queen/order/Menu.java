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
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(40));

        printBurgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(40));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    protected void printDrinks(boolean printPrice) {
        System.out.println("๐ฅค ์๋ฃ");
        products.forEach(product -> {
            if (product instanceof Drink) {
                printEachProduct(product, printPrice);
            }
        });
        System.out.println();
    }

    protected void printSides(boolean printPrice) {
        System.out.println("๐ ์ฌ์ด๋");
        products.forEach(product -> {
            if (product instanceof Side) {
                printEachProduct(product, printPrice);
            }
        });
        System.out.println();
    }

    private void printBurgers(boolean printPrice) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        products.forEach(product -> {
            if (product instanceof Burger) {
                printEachProduct(product, printPrice);
            }
        });
        System.out.println();
    }

    private void printEachProduct(Product product, boolean printPrice) {
        if (printPrice) {
            System.out.printf("   (%d) %s %5dKcal %5d์\n",
                    product.getId(), product.getName(), product.getKcal(), product.getPrice()
            );
        } else {
            System.out.printf("   (%d) %s %5dKcal\n",
                    product.getId(), product.getName(), product.getKcal()
            );
        }
    }
}
