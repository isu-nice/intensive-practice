
#### 💰 전기 요금 계산기 만들기

전기 요금을 계산하는 방법은 구글링해서 찾을 수 있습니다. 계산법은 다음과 같습니다. 이것을 지금까지 배운 제어문으로 코드를 작성하여 봅시다.
https://cyber.kepco.co.kr/ckepco/front/jsp/CY/J/A/CYJAPP000NFL.jsp

## 🖥  [전기 요금 계산기] 실행 결과 예시(100 kWh 이하 및 100kWh 초과분)
```
=========================
주택용 전기요금(저압) 계산기
=========================
99kWh의 전기 요금은 6009.3원 입니다.
150kWh의 전기 요금은 12365.0원 입니다.
```
※ 본 예시는 99kWh, 150kWh의 예시만 나와있습니다.
우리가 만들 전기 요금 계산기에는 99kWh, 150kWh, 250kWh, 301kWh, 450kWh, 510kWh 사용량에 해당하는 전기 요금을 출력해주세요.

# 💡 [한국전력공사]에서 내려온 프로그래밍 요청서
💰 주택용 전기요금 (저압) 계산법
저압의 경우 100kWh 이하는 kWh당 60.7원, 100kWh 초과는 125.9원, 200kWh 초과는 187.9원, 300kWh 초과는 280.6원, 400kWh 초과는 417.7원, 500kWh초과는 670.6원의 전력량 요금을 내야한다.

**주의사항 및 예시**
위 내용은 다소 단순하게 사용량만을 기준으로 작성되어 있습니다.
만약 전력 사용량이 150kWh 라면 100kWh를 초과하였으므로 125.9 × 150 라는 계산을 할 수 있습니다.
하지만 실제 요금 계산은 위와 같은 연산 방식이 아닌 전력량 초과분에 대해서는 초과분에 대한 요금을 책정해야 합니다.

예를 들어 150kWh를 사용하였다면 사용량의 100kWh에 대해서는 60.7원을, 나머지 50kWh 사용량에 대해서는 125.9원을 책정해주셔야 합니다.

# 🖥️ [코드스테이츠]에서 내려온 프로그래밍 참고사항
**⚙ 위 내용은 어떻게 코딩할 수 있을까요?**
위 모든 사항에 대하여 한 번에 코딩하기는 쉽지 않습니다. 그러므로 가장 쉬운경우 부터 작성해주세요. 예를들어 100kWh 이하에 대해서 먼저 제어문을 작성하여 출력 결과를 살펴보고, 100kWh 초과에 대해 작성한 다음 출력 결과를 살펴보는 방식으로 진행하면 시간은 오래걸릴지언정 완벽한 프로그램을 만들 수 있습니다.

**✍️ 연산을 위한 수식을 어떻게 코드로 구축하면 좋을까요?**
주의사항에도 언급된 것 처럼 단순히 100kWh 이하 60.7원, 100kWh 초과 125.9원 으로 생각해 연산을 하는 것이 아닌 해당 전력 사용량의 구간별 가격 책정이 진행됩니다.
만약 전력 사용량이 150kWh 라면 (100 * 60.7) + (50 * 125.9) 과 같이 수식을 작성하고 이를 그대로 코드로 옮겨 주시면 됩니다.

또 다른 예시로, 전력 사용량이 250kWh라면 다음과 같이 구간을 나눠 볼 수 있습니다.
1) 100 kWh 이하의 구간(100kWh)
2) 100 kWh 초과의 구간(100kWh)
3) 200 kWh 초과의 구간(50kWh)

