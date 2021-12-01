package com.company.algomonster.twopointer.oposite;

import java.util.Arrays;
import java.util.List;

/**
 * 비가오고 나서 채워진 물의 양을 구하는 문제
 * 각 인덱스의 값은 높이이다.
 * 양쪽끝 높이는 0으로 고려하고 문제를 풀어라.
 * [3, 2, 1, 2, 2, 3, 2]의 결과는 5이다.
 * 해당 문제는 구현 문제에 가깝다.
 * [현재의 높이에서 왼쪽 우측 높이를 구하는게 키 포인트이다. ]
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 2, 1, 2, 2, 3, 2);
        int res = trappingRainWater(list);
        System.out.println(res);
    }

    private static int trappingRainWater(List<Integer> list) {
        int len = list.size();
        // 각 위치에서 왼쪽으로 가장 큰 벽을 계산한다.
        int[] leftHighestWalls = new int[len];
        int[] rightHighestWalls = new int[len];

        int h = 0;
        for(int i = 0; i < len; i++) {
            leftHighestWalls[i] = h;
            h = Math.max(list.get(i), h);
        }
        System.out.println(Arrays.toString(leftHighestWalls));

        // 각 위치에서 오른쪽으로 가장 큰 벽들을 계산한다.
        h = 0;
        for(int i = len - 1; i > 0; i--) {
            rightHighestWalls[i] = h;
            h = Math.max(list.get(i), h);
        }
        System.out.println(Arrays.toString(rightHighestWalls));

        int res = 0;
        for (int i = 0; i < len; i++) {
            int curEvalutation = list.get(i);
            int minHeight = Math.min(leftHighestWalls[i], rightHighestWalls[i]);
            if(curEvalutation < minHeight) {
                res += minHeight - curEvalutation;
            }
        }
        return res;
    }
}
