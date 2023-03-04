package oop_intensive.burger_queen;

public class Main {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        OrderApp orderApp = new OrderApp(
                appConfig.productRepository(),
                appConfig.menu(),
                appConfig.cart(),
                appConfig.order()
        );

        orderApp.run();
    }
}
