package com.company.epi262.types;

/**
 * 주어진 양수에 대해서 팰린드롬인지 체크하시오.
 * 조건 : 문자열과 관련된 기능을 사용하지 않아야 한다.
 *
 * hint : 최상위 비트와 최하위 비트를 비교하는 방식으로 접근
 * 상당히 어려운 문제이다.
 */
public class NumPalindrome {

    public static void main(String[] args) {
        long x = 123321;
        long x2 = 12343321;

        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(2));
    }


    // 최상위 비트 구하기
    // x의 자리수 x에 밑이 10인 로그를 취한 결과이다.
    // n = [log10x] + 1 => x / (10 ^ (n-1))
    // 최하위 비트 = x mod 10
    private static boolean isPalindrome(long x) {
        if( x < 0 ) return false;

        final int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
        int msdMaks = (int) Math.pow(10, numDigits - 1);

        for (int i = 0; i < (numDigits / 2); i++) {
            // 최상위 비트와 최하위 비트가 다른 경우!
            if(x / msdMaks != x % 10) return false;

            x %= msdMaks; // 최상위 비트 제거
            x /= 10; // x의 최하위 비트 제거
        }
        return true;
    }
}
