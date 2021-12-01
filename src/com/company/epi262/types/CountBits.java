package com.company.epi262.types;

public class CountBits {

    private static short countBits(int x) {
        short numBits = 0;
        while(x != 0) {
            numBits += (x & 1);

            // >>>로 처리하면 부호를 신경쓰지 않는다. [ 이동 공간을 모두 0으로 채움 ]
            x >>>= 1;
        }

        return numBits;
    }

    private static void mathMethods() {
        double a = 1.49;
        System.out.println("round " + Math.round(a));
        System.out.println("ceil " + Math.ceil(a));
        System.out.println("floor " + Math.floor(a)) ;

    }

    public static void main(String[] args) {

        int n1 = 16;
        System.out.println(countBits(n1));
        mathMethods();
    }
}
