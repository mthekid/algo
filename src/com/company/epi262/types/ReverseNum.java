package com.company.epi262.types;


/**
 * 주어진 숫자를 뒤집어 반환하라.
 * 문자열과 관련된 기능을 사용해서는 안된다. [ StringBuilder X ]
 */
public class ReverseNum {

    public static void main(String[] args) {
        long x = 123; // 321반환
        long x2 = -152; // -251반환

        System.out.println(reverse(x));
        System.out.println(reverse(x2));
    }

    private static long reverse(long x) {
        // 결과값 보관
        long res = 0;

        // 10으로 나눈 나머지
        long xRemain = Math.abs(x);

        // x를 10으로 나누면서 진행하고 나머지를 구하면서 앞에 붙여나간다.
        while(xRemain != 0) {
            res = res * 10 + xRemain % 10;
            xRemain /= 10;
        }

        // 음수인 경우 부호를 붙여준다.
        return x < 0 ? -res : res;
    }

}
