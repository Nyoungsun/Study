package basic;
// java default package = java.lang
public class Method01 {
    public static void main(String[] args) {
        int max = Math.max(25, 36);
        System.out.println(max);

        double min = Math.min(25.8, 78.6);
        System.out.println(min);

        String bin = Integer.toBinaryString(250);
        System.out.println(bin);

        String octal = Integer.toOctalString(250);
        System.out.println(octal);

        String hex = Integer.toHexString(250);
        System.out.println(hex);
    }
}
