package oop_intensive.chicken.view;

import java.util.Scanner;

import static oop_intensive.chicken.view.Guidance.INPUT;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        System.out.print(INPUT);
        return scanner.nextLine();
    }

}
