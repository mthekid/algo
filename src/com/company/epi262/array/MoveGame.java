package com.company.epi262.array;

import java.util.Arrays;
import java.util.List;

/**
 * 첫 번쨰 위치에서 시작해서 마지막 위치에 도달하는 것이 목표이다.
 * 각 위치에는 음이 아닌 정수값이 들어 있고, 해당 위치에서 최대 그 숫자만큼 앞으로 나아갈 수 있다.
 * 길이가 n인 배열 A가 주어졌을 때, 배열의 시작점에서 마지막 지점까지 도달할 수 있는지 판단하는 프로그램을 작성하라.
 */
public class MoveGame {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 3, 1, 0, 2, 0 , 1);
        canReachEnd(list);
    }

    private static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size() - 1;

        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
            furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
            System.out.println(furthestReachSoFar);
        }

        return furthestReachSoFar >= lastIndex;
    }
}
