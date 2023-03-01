package java_basic.first;

public class ElectricityBill {
    public static void main(String[] args) {
        System.out.println("=".repeat(25));
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=".repeat(25));

        //TODO:

        // 1, 100 이하인 경우 전력당 60.7 원이 부가됩니다. (사용한 전력 100 kWh 이하일 경)

        // 2, 100 이하인 경우 전력당 60.7원 부과, 100 초과인 경우 125.9원 부과 (사용한 전력이 100 kWh 초과일 경우)

        System.out.println(computeElectricityBill(99));
        System.out.println(computeElectricityBill(150));
        System.out.println(computeElectricityBill(250));
        System.out.println(computeElectricityBill(301));
        System.out.println(computeElectricityBill(450));
        System.out.println(computeElectricityBill(510));
    }

    public static String computeElectricityBill(int usage) {
        final double PRICE_UNDER_100 = 60.7;
        final double PRICE_OVER_100 = 125.9;
        final double PRICE_OVER_200 = 187.9;
        final double PRICE_OVER_300 = 280.6;
        final double PRICE_OVER_400 = 417.7;
        final double PRICE_OVER_500 = 607.6;

        int initUsage = usage;
        double bill = 0;
        double excess;

        if (usage > 500) {
            excess = usage - 500;
            bill += excess * PRICE_OVER_500;
            usage = 500;
        }
        if (usage > 400) {
            excess = usage - 400;
            bill += excess * PRICE_OVER_400;
            usage = 400;
        }
        if (usage > 300) {
            excess = usage - 300;
            bill += excess * PRICE_OVER_300;
            usage = 300;
        }
        if (usage > 200) {
            excess = usage - 200;
            bill += excess * PRICE_OVER_200;
            usage = 200;
        }
        if (usage > 100) {
            excess = usage - 100;
            bill += excess * PRICE_OVER_100;
            usage = 100;
        }
        if (usage <= 100) {
            excess = usage;
            bill += excess * PRICE_UNDER_100;
        }

        return String.format("%dkWh의 전기 요금은 %.1f원 입니다.", initUsage, bill);
    }
}