package oop_intensive.chicken.restaurant;

import static oop_intensive.chicken.view.Guidance.INFO;
import static oop_intensive.chicken.view.Guidance.SYSTEM;
import static oop_intensive.chicken.view.InputView.getUserInput;

public class RegisterRestaurant {

    private RestaurantRepository restaurantRepository;

    public RegisterRestaurant(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void registerRestaurant() {
        System.out.println(INFO + "반갑습니다. 가맹주님!");
        System.out.println(INFO + "음식점 상호는 무엇인가요?");
        String restaurantName = getUserInput();
        //validate
        System.out.println(INFO + "대표 메뉴 이름은 무엇인가요?");
        String menuName = getUserInput();
        //validate
        System.out.println(INFO + "해당 메뉴 가격은 얼마인가요?");
        int menuPrice = Integer.parseInt(getUserInput());

        restaurantRepository.addRestaurant(
                new Restaurant(restaurantName, menuName, menuPrice));

        System.out.printf("%s에 메뉴(%s, %d)가 추가되었습니다.\n",
                restaurantName, menuName, menuPrice);
        System.out.println(SYSTEM + "가게 등록이 정상 처리되었습니다.\n");
    }


}
