package constructor;

public class VarArgs {

    public VarArgs() {
        System.out.println("기본 생성자");
    }

    public int sum(int... ar) { // ...: 인수의 개수가 가변적
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        VarArgs varArgs = new VarArgs();
        System.out.println("합 = " + varArgs.sum(10, 20));
        System.out.println("합 = " + varArgs.sum(10, 20, 30));
        System.out.println("합 = " + varArgs.sum(10, 20, 30, 40));

    }
}
