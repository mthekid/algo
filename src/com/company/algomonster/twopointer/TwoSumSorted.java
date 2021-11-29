package com.company.algomonster.twopointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 투 포인터 기법중 양 끝에서 이동하는 기법을 활용.
 * 시작 점과 끝 점을 활용해서 문제를 푼다.
 */
public class TwoSumSorted {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, 5, 8, 11, 15);

        int target = 5;
        int target2 = 14;

        List<Integer> res = twoSumSorted(arr, target);
        List<Integer> res2 = twoSumSorted(arr, target2);

        printRes(res);
        printRes(res2);
    }

    private static void printRes(List<Integer> res) {
        System.out.println(res.stream().map(String::valueOf)
            .collect(Collectors.joining(" ")));
    }

    private static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        /* 나의 정답.
        int startIdx = 0;
        int endIdx = arr.size() - 1;
        List<Integer> ans = new LinkedList<>();

        for(;;) {
            int comp = arr.get(startIdx) + arr.get(endIdx);
            if(comp == target) {
                ans.add(startIdx);
                ans.add(endIdx);
                break;
            } else if(comp > target) {
                endIdx = endIdx - 1;
            } else {
                startIdx = startIdx + 1;
            }
        }
        return ans;
        */
        // solution [ right, left 변수명을 둔다. ] [ 우아하다. ]
        int l = 0;
        int r = arr.size() - 1;
        while(l < r) {
            int twoSum = arr.get(l) + arr.get(r);
            if(twoSum == target) return List.of(l, r);
            else if(twoSum < target) l++;
            else r--;
        }

        return null;
    }
}
