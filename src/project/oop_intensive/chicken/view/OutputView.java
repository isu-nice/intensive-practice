package oop_intensive.chicken.view;

import static oop_intensive.chicken.view.Guidance.CONTOUR;
import static oop_intensive.chicken.view.Guidance.INFO;

public class OutputView {
    public static void printProgramInfo() {
        System.out.println("[๐์นํจ์ ๋ฏผ์กฑ ํ๋ก๊ทธ๋จ๐]");
        System.out.println(CONTOUR);
        System.out.println("1) [์ฌ์ฅ๋์ฉ] ์์์  ๋ฑ๋กํ๊ธฐ");
        System.out.println("2) [๊ณ ๊ฐ๋๊ณผ ์ฌ์ฅ๋์ฉ] ์์์  ๋ณ์  ์กฐํํ๊ธฐ");
        System.out.println("3) [๊ณ ๊ฐ๋์ฉ] ์์ ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("4) [๊ณ ๊ฐ๋์ฉ] ๋ณ์  ๋ฑ๋กํ๊ธฐ");
        System.out.println("5) ํ๋ก๊ทธ๋จ ์ข๋ฃํ๊ธฐ");
        System.out.println(CONTOUR);
        System.out.println(" ๋ฌด์์ ๋์๋๋ฆด๊น์?");
    }

    public static void printExitInfo() {
        System.out.println(INFO + "์ด์ฉํด ์ฃผ์์ ๊ฐ์ฌํฉ๋๋ค.");
    }


}
