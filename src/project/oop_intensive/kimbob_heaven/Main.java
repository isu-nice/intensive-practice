package oop_intensive.kimbob_heaven;

public class Main {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        Kiosk kiosk = new Kiosk(
                appConfig.productRepository(),
                appConfig.menu(),
                appConfig.order()
        );
        kiosk.start();
    }
}
