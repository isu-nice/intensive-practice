package oop_intensive.chicken.view;

import static oop_intensive.chicken.view.Guidance.CONTOUR;

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


}
