package com.company.epi262.types;

/**
 * 해당 문제에서 무게는 정수의 비트에서 1의 개수를 의미한다.
 * EX. 8의 경우 무게는 1이다. 6의 경우 무게는 1이다.
 * 같은 무게를 가진 정수 중에 그 차이가 최소가 되는 y를 반환하라.
 * [ x의 모든 비트가 0 혹은 1인 경우는 없다. ] x는 정수가 아니다.
 */
public class FindMinWeight {

    public static void main(String[] args) {
        long x = 6; // 무게는 2이며 5를 반환해야 한다.

        System.out.println(findMinWeight(x));
    }

    private static long findMinWeight(long x) {
        final int NUM_BITS = 63; // 양의 정수만 들어오므로 MSB 1감소

        for (int i = 0; i < NUM_BITS; ++i) {
            // i번쨰와 i+1 비트가 다른 경우를 찾는다.
            if( ((x >>>i ) & 1) != ((x >>>(i+1)) & 1)) {

                // i 번쨰와 (i+1) 번째 비트에 대한 비트 마스크 생성.
                long bitMask = (1L << i) | (1L << (i+1));

                // 비트 마스크 xor 연산을 처리해서 둘을 스왑한다. [ swap bit 메커니즘 사용 ]
                x ^= bitMask;
                return x;
            }
        }
        // 모든 비트가 0이거나 1인 경우이다 [Exception 던지기]
        throw new IllegalArgumentException("All bits are 0 or 1");
    }
}
