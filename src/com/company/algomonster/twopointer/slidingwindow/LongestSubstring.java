package com.company.algomonster.twopointer.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 *  반복되는 문자가 없는 가장 긴 부분 문자열(substring)의 길이를 반환하라.
 *  효율성으로 푼다면 상당히 어려운 문제이다.
 */
public class LongestSubstring {

    public static void main(String[] args) {

        String s1 = "abccabcabcc"; // 3
        String s2 = "aaaabaaaa"; // 2
        String s3 = "abcdbea";

        System.out.println(longestSubstringWithoutRepeatingCharacters(s1));
        System.out.println(longestSubstringWithoutRepeatingCharacters(s2));
        System.out.println(longestSubstringWithoutRepeatingCharacters(s3));
    }

    private static int bruteforce(String s) {
        int len = s.length();
        int longest = 0;
        for(int start = 0; start < len; start++) {
            for(int end = 0; end < len; end++) {
                String sub = s.substring(start, end+1);
                Set<Character> set = new HashSet<>();
                for(char ch : sub.toCharArray()) {
                    set.add(ch);
                }
                if( sub.length() == set.size() ) {
                    longest = Math.max(longest, end + 1 - start);
                }
            }
        }
        return longest;
    }

    private static int longestSubstringWithoutRepeatingCharacters(String s) {
        int len = s.length();
        int l = 0, r = 0;
        int longest = 0;

        Set<Character> set = new HashSet<>();
        while(r < len) {
            // 유일한 값을 만난 경우
            if(!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            // 중복된 값을 만난 경우 해당 중복된 값까지의 문자열은 길이에서 제외해야 한다.
            // r의 위치의 문자가 유일할 때까지 그 전 문자들을 제거해 나간다.
            else {
                set.remove(s.charAt(l));
                l++;
            }
            longest = Math.max(longest, r - l); // r - l 은 substring값이다.
        }
        return longest;
    }
}
