package com.company.epi262.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 어떤 순열이 주어졌을 때 다음 순열을 구하는 함수를 작성하라.
 * 순열의 순서는 사전 순으로 정렬되어 있다. <2,0,1>은 <2, 1, 0>보다 앞에 온다. [ 이 부분이 핵심이다. ]
 * 난이도가 상당히 높다. [ 효율적으로 푸는 부분이 상당히 어렵다. ]
 * brute-force로 푸는 것도 n의 사이즈 증가하면 불가능하다.
 */
public class NextPerm {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 0, 3, 2);
        System.out.println(nextPermutation(list));
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        // 오른쪽에서 바로 다음 항목보다 작은 첫 번째 항목 찾기
        int inversionPoint = perm.size() - 2;
        while(inversionPoint >= 0 && perm.get(inversionPoint) >= perm.get(inversionPoint + 1)) {
            --inversionPoint;
        }
        // 가장 맨왼쪽으로 이동한 경우는 해당 perm보다 작은 값이 없는 경우이다.
        if(inversionPoint == -1) {
            return Collections.emptyList();
        }

        /**
         * inversionPoint 이후의 엔트리 중에서 perm.get(inversionPoint)보다 크지만 그 중에서 가장 작은 엔트리를 맞바꾼다. [ 다음값 ]
         * perm의 항목은 inversionPoint 이후 감소하기에 역순으로 검색하면 perm.get(inversionPoint)보다 큰 첫 번째 항목이 스왑할 항목이다.
         */
        for (int i = perm.size() - 1; i > inversionPoint; --i) {
            if(perm.get(i) > perm.get(inversionPoint)) {
                Collections.swap(perm, inversionPoint, i);
                break;
            }
        }

        // perm 항목은 inversionPoint 후에 감소 순서로 나타나야 한다. [ 단순히 이 순열을 뒤집음으로써 사전 순으로 가장 작은 수열을 만들 수 있다. ]
        Collections.reverse(perm.subList(inversionPoint + 1, perm.size()));
        return perm;
    }
}
