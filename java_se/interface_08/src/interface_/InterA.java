package interface_;

public interface InterA {
    public static final String NAME = "홍길동"; // Interface에는 상수와 추상메소드만 선언 가능
    int AGE = 25; // 상수만 선언 가능하므로 psf 생략 가능

    public void aa(); // 추상메소드만 선언 가능하기 때문에 abstract 생략 가능
    public abstract void bb();
}
