package com.company.epi262.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 2차원 배열에 나선형으로 원소 배치하기 문제.
 * 2차원 배열이 주어졋을 때, 이 배열을 "나선형으로 읽은 결과"를 반환하라.
 * n-1개의 원소를 읽어나가는 식으로 처리하면 된다. [ 빠르게 규칙을 확인하는 것이 중요하다. ]
 *
 */
public class Cycle {

    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrderring = new ArrayList<>();
        for(int offset = 0; offset < Math.ceil(0.5 * squareMatrix.size()); ++offset) {
            matrixLayerInClockwise(squareMatrix, offset, spiralOrderring);
        }
        return spiralOrderring;
    }

    private static void matrixLayerInClockwise(List<List<Integer>> squareMatrix, int offset, List<Integer> spiralOrderring) {

        // 크기가 홀수인 경우 마지막에 중심 원소 하나가 남는다.
        if(offset == squareMatrix.size() - offset - 1) {
            spiralOrderring.add(squareMatrix.get(offset).get(offset));
        }

        // 동쪽
        for(int j = offset; j < squareMatrix.size() - offset - 1; ++j) {
            spiralOrderring.add(squareMatrix.get(offset).get(j));
        }

        for (int i = offset; i < squareMatrix.size() - offset - 1; ++i) {
            spiralOrderring.add(
                    squareMatrix.get(i).get(squareMatrix.size() - offset - 1)
            );
        }

        for (int j = squareMatrix.size() - offset - 1; j > offset; --j) {
            spiralOrderring.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
        }

        for(int i = squareMatrix.size() - offset - 1; i > offset; --i) {
            spiralOrderring.add(squareMatrix.get(i).get(offset));
        }
    }
}
