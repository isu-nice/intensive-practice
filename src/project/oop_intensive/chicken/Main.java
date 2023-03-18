package oop_intensive.chicken;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        ChickenNation chickenNation = new ChickenNation(
                appConfig.registerRestaurant(),
                appConfig.registerOrder(),
                appConfig.manageStar()
        );

        chickenNation.start();
    }
}
