package com.company.algomonster.twopointer;

/**
 * 반대 방향 포인터 문제.
 * 알파벳이 아닌 문자를 무시하고, 대소문자도 무시한다. 해당 문자열이 팰린드롬인지 아닌지 확인하라.
 */
public class ValodPalindrome {

    public static void main(String[] args) {
        String s = "Do geese see God?";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    // 알파벳 문자가 아닌 경우는 포인터는 문자를 찾아나서야 한다.
    private static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);

            while (!Character.isAlphabetic(lch)) {
                l++;
                lch = s.charAt(l);
            }

            while(!Character.isAlphabetic(rch)) {
                r--;
                rch = s.charAt(r);
            }

//            System.out.println("left ch " + lch + " rightmost ch " + rch);
            if(lch != rch) return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
