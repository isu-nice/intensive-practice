package oop_basic.starcraft;

public class StarCraftGame {
    public static final String INFO = "[안내] ";

    public static void main(String[] args) {
        System.out.println(INFO + "TRPG 스타크래프트 시작합니다.");

        Character mine = new Character();
        int[] mine_info = characterIntInfo(mine, false);

        Character opponent = new Character();
        int[] opponent_info = characterIntInfo(opponent, true);

        mine.attack(mine_info, opponent_info);
    }

    private static int[] characterIntInfo(Character character, boolean isOpponent) {
        String[] info = character.user_create(isOpponent);
        character.user_print(info);
        return character.user_info_int(info);
    }
}
