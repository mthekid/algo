package com.company.algomonster.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        return List.of();
    }
}
