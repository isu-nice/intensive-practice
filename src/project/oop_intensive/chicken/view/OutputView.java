package oop_intensive.chicken.view;

import static oop_intensive.chicken.view.Guidance.CONTOUR;
import static oop_intensive.chicken.view.Guidance.INFO;

public class OutputView {
    public static void printProgramInfo() {
        System.out.println("[🍗치킨의 민족 프로그램🍗]");
        System.out.println(CONTOUR);
        System.out.println("1) [사장님용] 음식점 등록하기");
        System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
        System.out.println("3) [고객님용] 음식 주문하기");
        System.out.println("4) [고객님용] 별점 등록하기");
        System.out.println("5) 프로그램 종료하기");
        System.out.println(CONTOUR);
        System.out.println(" 무엇을 도와드릴까요?");
    }

    public static void printExitInfo() {
        System.out.println(INFO + "이용해 주셔서 감사합니다.");
    }

    public static void printStars(int starNumber) {
        for(int i = 0; i < starNumber; i++) {
            System.out.print("⭐");
        }
        System.out.println();
    }
}
