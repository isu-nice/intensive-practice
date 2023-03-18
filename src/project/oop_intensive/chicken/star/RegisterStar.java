package oop_intensive.chicken.star;

import oop_intensive.chicken.view.InputView;

import static oop_intensive.chicken.view.Guidance.INFO;

public class RegisterStar {
    private StarRepository starRepository;

    public RegisterStar(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    public void feedback() {
        System.out.println(INFO + "고객님! 별점 등록을 진행합니다.");
        System.out.println(INFO + "주문자 이름은 무엇인가요?");
        String customerName = InputView.getUserInput();

        System.out.println(INFO + "음식점 상호는 무엇인가요?");
        String restaurantName = InputView.getUserInput();

        System.out.println(INFO + "주문하신 음식 이름은 무엇인가요?");
        String menuName = InputView.getUserInput();

        System.out.println(INFO + "음식 맛은 어떠셨나요? (1점 ~ 5점)");
        String starNumber = InputView.getUserInput();

        starRepository.addStar(customerName, restaurantName, menuName, starNumber);
        System.out.println(INFO + "리뷰 등록이 완료되었습니다.");
    }
}
