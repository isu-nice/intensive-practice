package oop_intensive.chicken;

import oop_intensive.chicken.order.RegisterOrder;
import oop_intensive.chicken.restaurant.RegisterRestaurant;
import oop_intensive.chicken.star.ManageStar;
import oop_intensive.chicken.view.InputView;
import oop_intensive.chicken.view.OutputView;

public class ChickenNation {
    private RegisterRestaurant registerRestaurant;
    private RegisterOrder registerOrder;
    private ManageStar manageStar;

    public ChickenNation(RegisterRestaurant registerRestaurant, RegisterOrder registerOrder, ManageStar manageStar) {
        this.registerRestaurant = registerRestaurant;
        this.registerOrder = registerOrder;
        this.manageStar = manageStar;
    }

    public void start() {
        String input = "-1";

        while (true) {
            OutputView.printProgramInfo();
            input = InputView.getUserInput();

            switch (input) {
                case "1":
                    registerRestaurant.registerRestaurant();
                    break;
                case "2":
                    manageStar.check();
                    break;
                case "3":
                    registerOrder.makeOrder();
                    break;
                case "4":
                    manageStar.feedback();
                    break;
                case "5":
                    OutputView.printExitInfo();
                    return;
                default:
                    throw new IllegalArgumentException("");
            }
        }
    }
}
