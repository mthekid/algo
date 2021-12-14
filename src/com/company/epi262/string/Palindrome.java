package com.company.epi262.string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPadlindrome("abcba"));
    }


    // for 문 안에 start 포인터와 end 포인터를 선언한다.
    // two pointer 문제로 양 끝에서 접근하는 방식이다.
    // i < j 조건이 예술적이라고 생각한다. [ 이 방식으로 문자열의 길이가 짝수든 홀수든 상관없게 된다. ]
    private static boolean isPadlindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
