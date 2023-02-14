package com.zoo;

public class Zoo { // public이 아니면 다른 패키지에서 접근 불가
    public void tiger() {
        System.out.println("호랑이");
    }

    protected void giraffe() {
        System.out.println("기린");
    }

    void elephant() {
        System.out.println("코끼리");
    }

    private void lion() {
        System.out.println("사자");
    }
}
