package com.company.epi262.types;

/**
 * 문제 4.1 패리티 계산하기.
 * 데이터를 저장하거나 네트워크로 통신할 때 오류를 확인하는 용도로 사용하는 패리티(2진수)는
 * 1이 홀수개이면 1을 짝수 개이면 0이 된다.
 * 64비트로 이루어진 숫자가 굉장히 많은 경우 패리티를 어떻게 계산하는 것이 효율적인가.
 */
public class Parity {

    public static void main(String[] args) {
        long p1 = 124123L;
        System.out.println(getparity(p1));
    }


    private static short getparity(long p1) {
        // 1이 홀수번 나오는지 짝수번 나오는지 체크
        short numBits = 0;
        while(p1 != 0) {
            // 더하는게 아닌 xor로 처리할 수 있다.
//            numBits += (p1 & 1);
            numBits ^= (p1 & 1);
            p1 >>>= 1;
        }
        return numBits;
    }

    /**
     * x &= (x-1)은 x가 가진 하위비트 1을 지워주는 메커니즘이다. [ 테크닉 ]
     * 대박이네....
     * x가 가진 비트의 개수만큼 만 로직이 돌아간다. [ 이전에는 n이었다면 이제는 k개의 개수로 처리된다. ] 
     * @param x 패리티를 체크할 숫자 
     * @return 패리티 값
     */
    private static short parity(long x) {
        short result = 0;
        while(x != 0) {
            result ^= 1;
            x &= (x-1); // x의 하ㅟ 비트를 지운다. [ 00101100 -> 00101000 이 된다. ]
        }
        return result;
    }
}
