package oop_intensive.chicken;

import oop_intensive.chicken.order.RegisterOrder;
import oop_intensive.chicken.restaurant.RegisterRestaurant;
import oop_intensive.chicken.view.InputView;
import oop_intensive.chicken.view.OutputView;

public class ChickenNation {
    private RegisterRestaurant registerRestaurant;
    private RegisterOrder registerOrder;

    public ChickenNation(RegisterRestaurant registerRestaurant, RegisterOrder registerOrder) {
        this.registerRestaurant = registerRestaurant;
        this.registerOrder = registerOrder;

    }

    public void start() {
        String input = "-1";

        while (!input.equals("5")) {
            OutputView.printProgramInfo();
            input = InputView.getUserInput();

            switch (input) {
                case "1":
                    registerRestaurant.registerRestaurant();
                    break;
                case "2":

                    break;
                case "3":
                    registerOrder.makeOrder();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                default:
                    throw new IllegalArgumentException("");
            }

        }

    }


}
