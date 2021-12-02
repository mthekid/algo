package com.company.epi262.types;

/**
 * i인덱스와 j 인덱스의 비트를 스왑하라.
 * 1. i와 j인덱스의 비트가 같으면 스왑할 필요가 없다
 * 2. i와 j인덱스의 비트가 다르면 각 비트를 뒤집으면 된다. (~)
 *
 * 좋은 내용
 * 1. 서로 다른 비트 뒤집기 : xor : ^연산
 * 2. 비트 마스크 만들기
 * 3. 비트 시프트 (>>> (해당 인덱스 비트 가져오기), <<(비트 이동시키기) ]
 */
public class SwapBit {
    public static void main(String[] args) {

        // 000....01110;
        // 60, 61, 62, 63
        long x = 14;
        System.out.println(swapBits(x, 0, 1));
    }

    private static long swapBits(long x, int i, int j) {
        // i 번째 비트와 j 번쨰 비트를 비교한다.
        // 다른 경우 해당 비트를 뒤집는다.
        if( ((x >>> i) & 1) != ((x >>> j) & 1)) {

            // i와 j의 비트가 켜져있는 bitMask 생성
            long bitMask = (1L << i) | (1L << j);

            // x와 xor 연산을 해서 뒤집는다. x^1 = 0, x^0 = 1이다.
            // xor연산에서 서로 다른 경우가 1이된다.
            // [ 같은 경우는 0이나 여기선 같은 경우로 접근되지는 않는다. ]
            x ^= bitMask;
        }
        return x;
    }
}
