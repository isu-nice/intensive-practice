public class electricityBill {
    public static void main(String[] args) {
        /*
        주의사항 및 예시
        위 내용은 다소 단순하게 사용량만을 기준으로 작성되어 있습니다.
        만약 전력 사용량이 150kWh 라면 100kWh를 초과하였으므로
        125.9 × 150 라는 계산을 할 수 있습니다.
        하지만 실제 요금 계산은 위와 같은 연산 방식이 아닌 전력량 초과분에
        대해서는 초과분에 대한 요금을 책정해야 합니다.

        예를 들어 150kWh를 사용하였다면 사용량의 100kWh에 대해서는 60.7원을,
         나머지 50kWh 사용량에 대해서는 125.9원을 책정해주셔야 합니다.

        우리가 만들 전기 요금 계산기에는 99kWh, 150kWh, 250kWh, 301kWh,
         450kWh, 510kWh 사용량에 해당하는 전기 요금을 출력해주세요.

        저압의 경우 100kWh 이하는 kWh당 60.7원, 100kWh 초과는 125.9원,
         200kWh 초과는 187.9원, 300kWh 초과는 280.6원, 400kWh 초과는 417.7원,
          500kWh초과는 670.6원의 전력량 요금을 내야한다.


         */
        int[] input = {99, 150, 250, 301, 450, 510};
        int[] standard = {500, 400, 300, 200, 100, 0};
        double[] price = {670.6, 417.7, 280.6, 187.9, 125.9, 60.7};

        for(int i : input){
            double sum = 0;
            int electricity = i;
            for(int j = 0; j<standard.length; j++){
                if(i>=standard[j]){
                    sum += (i-standard[j]) * price[j];
                    i -= i-standard[j];
                }
            }
            System.out.printf("%dkWh의 전기 요금은 %.1f원 입니다.\n",electricity,sum);
        }
    }
}
