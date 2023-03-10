package operator;

public class Dice {
    public static void main(String[] args) {

        while (true) {
            int dice1 = (int) (Math.random() * (6 - 1 + 1) + 1); // (int) (Math.random() * (최댓값 - 최소값 + 1) + 최소값)
            int dice2 = (int) (Math.random() * 6 + 1);

            System.out.println("주사위1: " + dice1 + " 주사위2: " + dice2);
            String result = dice1 > dice2 ?
                    "주사위1 승" :
                    dice1 < dice2 ?
                            "주사위2 승" :
                            "무승부";
//            if (dice1 > dice2) {
//                System.out.println("주사위1 승");
//            } else if (dice1 < dice2) {
//                System.out.println("주사위2 승");
//            } else {
//                System.out.println("무승부");
//            }
            System.out.println(result + "\n--------------------");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
[문제] 주사위 게임 - 난수
        2개의 주사위를 던져서 큰값을 가진 주사위가 승이다.
        주사위 값의 합도 출력하시오

        [실행결과]
        주사위1 : 3   주사위2 : 1
        주사위1 승
        -----------------------------
        주사위1 : 4   주사위2 : 6
        주사위2 승
        -----------------------------
        주사위1 : 3   주사위2 :3
        무승부
*/