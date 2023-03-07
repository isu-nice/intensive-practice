package oop_intensive.burger_queen.order;

import oop_intensive.burger_queen.product.Product;
import oop_intensive.burger_queen.product.ProductRepository;
import oop_intensive.burger_queen.product.subproduct.Burger;
import oop_intensive.burger_queen.product.subproduct.BurgerSet;
import oop_intensive.burger_queen.product.subproduct.Drink;
import oop_intensive.burger_queen.product.subproduct.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

    private List<Product> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private ProductRepository productRepository;
    private Menu menu;

    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    // 장바구니 출력
    public void printCart() {
        System.out.println("🧺 장바구니");

        System.out.println("-".repeat(60));
        printCartItems();
        System.out.println("-".repeat(60));

        System.out.printf("합계 : %d원\n", computeTotalPrice());
        System.out.println("이전으로 돌아가려면 엔터를 누르세요.");
        scanner.nextLine();
    }

    // 장바구니 상품 추가
    public void addToCart(int productId) {
        Product product = productRepository.findById(productId);

        Product newProduct;
        if (product instanceof Burger) newProduct = new Burger((Burger) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else newProduct = new Drink((Drink) product);

        chooseOption(newProduct);

        if (newProduct instanceof Burger) {
            Burger burger = (Burger) newProduct;
            if (burger.isBurgerSet()) {
                newProduct = composeSet(burger);
            }
        }

        items.add(newProduct);
        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }

    // 세트 구성
    private BurgerSet composeSet(Burger burger) {
        System.out.println("사이드를 골라주세요");
        menu.printSides(false);

        String sideId = scanner.nextLine();
        Side side = (Side) productRepository.findById(Integer.parseInt(sideId));
        Side newSide = new Side(side);
        chooseOption(newSide);

        System.out.println("음료를 골라주세요.");
        menu.printDrinks(false);

        String drinkId = scanner.nextLine();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(drinkId));
        Drink newDrink = new Drink(drink);
        chooseOption(newDrink);

        String name = burger.getName() + "세트";
        int price = burger.getBurgerSetPrice();
        int kcal = burger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name, price, kcal, burger, newSide, newDrink);
    }

    // 세트 옵션 선택
    private void chooseOption(Product product) {

        String input;

        if (product instanceof Burger) {
            System.out.printf(
                    "단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)\n",
                    product.getPrice(),
                    ((Burger) product).getBurgerSetPrice()
            );
            input = scanner.nextLine();
            if (input.equals("2")) {
                ((Burger) product).setIsBurgerSet(true);
            }
        } else if (product instanceof Side) {
            System.out.println("케첩은 몇 개가 필요하신가요?");
            input = scanner.nextLine();
            ((Side) product).setKetchupNumber(Integer.parseInt(input));
        } else if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = scanner.nextLine();
            if (input.equals("2")) {
                ((Drink) product).setWithStraw(false);
            }
        }
    }

    // 장바구니 출력
    protected void printCartItems() {
        items.forEach(product -> {
            if (product instanceof BurgerSet) {
                printItemBurgerSet(product);
            } else if (product instanceof Burger) {
                printItemBurger(product);
            } else if (product instanceof Side) {
                printItemSide(product);
            } else if (product instanceof Drink) {
                printItemDrink(product);
            }
        });
    }

    private void printItemDrink(Product product) {
        System.out.printf(
                "  %-8s %7d원 (빨대 %s)\n",
                product.getName(),
                product.getPrice(),
                ((Drink) product).isWithStraw() ? "있음" : "없음"
        );
    }

    private void printItemSide(Product product) {
        System.out.printf(
                "  %-8s %7d원 (케첩 %d개)\n",
                product.getName(),
                product.getPrice(),
                ((Side) product).getKetchupNumber()
        );
    }

    private void printItemBurger(Product product) {
        System.out.printf(
                "  %-8s %7d원 (단품)\n",
                product.getName(),
                product.getPrice()
        );
    }

    private void printItemBurgerSet(Product product) {
        BurgerSet burgerSet = (BurgerSet) product;
        System.out.printf(
                "  %s세트 %7d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                burgerSet.getBurger().getName(),
                product.getPrice(),
                burgerSet.getSide().getName(),
                burgerSet.getSide().getKetchupNumber(),
                burgerSet.getDrink().getName(),
                burgerSet.getDrink().isWithStraw() ? "있음" : "없음"
        );
    }

    protected int computeTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
