package com.company.epi262.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * n보다 작은 모든 소수 나열하기.
 * 양의 정수 n이 주어졌을 때 1과 n사이에 있는 모든 소수를 반환하는 프로그램을 작성해보라.
 *
 * 해당 문제에서는 boolean 배열을 사용해서 전체 소수를 구한다.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int n = 18;
        System.out.println(generate(n));
    }

    /**
     * 소수를 보관할 리스트를 둔다.
     * 소수를 처리할 boolean 리스르를 생성하고 모두 true로 채운다. (Collection.nCopies(n+1, true))
     * 숫자 2부터 진행하면서 p의 배수들을 false로 세팅한다.
     * 처음 p를 마주한 경우는 소수이다. [ 소수가 아니라면 그 전에 2, 3, 5 ,7과 같은 자기보다 작은 수로 나뉘어져서 false로 세팅될 것이다. ]
     * 문제점 => 이미 false로 세팅된 부분도 다시 false로 세팅되는 중복 연산이 진행된다. [ 비효울적 ]
     * @param n
     * @return 주어진 n과 1사이의 소수들을 반환한다.
     */
    private static List<Integer> generate(int n) {
        List<Integer> primes = new ArrayList<>();

        // isPrime.get(p)는 p가 소수인지 아닌지를 나타낸다.  [ 초기에는 0과 1을 제외한 나머지를 모두 true로 세팅 (nCopies, true)를 활용.
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);

        for(int p = 2; p <= n; ++p) {
            if(isPrime.get(p)) {
                primes.add(p);
                // p의 배수들을 걸러낸다.
                for(int j = p; j <= n; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }
}
