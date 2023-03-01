package oop_basic.starcraft;

public class StarCraftGame {
    public static final String INFO = "[안내] ";

    public static void main(String[] args) {
        System.out.println(INFO + "TRPG 스타크래프트 시작합니다.");

        Character mine = new Character();
        String[] info_mine = mine.user_create(false);
        mine.user_print(info_mine);

        Character opponent = new Character();
        String[] info_opponent = opponent.user_create(true);
        opponent.user_print(info_opponent);
    }
}
